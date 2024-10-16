/* eslint-disable eqeqeq */
import * as React from "react";
import { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import { Button, TextField, Grid } from "@mui/material";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import dayjs from "dayjs"; // Import dayjs for date handling
import axiosInstance from "../api/api"; // Your Axios instance

export default function Member() {
  const [members, setMembers] = useState([]);
  const [loading, setLoading] = useState(true);
    const [, setError] = useState(null);
//   const [setError] = useState(null);
  // State for the new member's input fields
  const [newMember, setNewMember] = useState({
    name: "",
    phone: "",
    email: "",
    status: "1", // Default status
    joinDate: dayjs(), // Use dayjs for the date picker
    birthday: null, // Use null initially for the birthday
  });

  const [selectedMember, setSelectedMember] = useState(null); // State to track selected member

  // Fetch data from the API
  useEffect(() => {
    const fetchMemberData = async () => {
      try {
        const response = await axiosInstance.get("members"); // Adjust this if necessary
        setMembers(response.data.data); // Assuming the API returns the data correctly
        setLoading(false);
      } catch (err) {
        setError("Error fetching member data");
        setLoading(false);
      }
    };

    fetchMemberData();
  }, []);

  // Function to handle adding a new row and posting to the API
  const handleAddRow = async () => {
    const { name, phone, email, status, joinDate, birthday } = newMember;

    // Validate input fields
    if (!name || !phone || !email || !birthday) {
      setError("Please fill in all fields.");
      return;
    }

    const newRow = {
      id: members.length + 1, // Generate a new ID based on current number of rows
      name,
      phone,
      email,
      status,
      joinDate: joinDate.format("YYYY-MM-DD"), // Format the date properly for the backend
      birthday: birthday.format("YYYY-MM-DD"), // Format the date properly
    };

    // Update local state
    setMembers([...members, newRow]);

    // Send POST request to the API
    try {
      const response = await axiosInstance.post("members", newRow);
      const addedMember = response.data.data;
      newRow.id = addedMember.id;
      console.log(addedMember);
      console.log("Member added successfully:", newRow);
      setNewMember({
        name: "",
        phone: "",
        email: "",
        status: "1",
        joinDate: dayjs(),
        birthday: null,
      }); // Reset input fields
    } catch (error) {
      console.error("Error adding member:", error);
      setError("Error adding member");
    }
  };

  // Function to handle deleting a row
  const handleDeleteRow = async () => {
    console.log("selectedMember", selectedMember);
    if (!selectedMember) {
      setError("Please select a member to delete.");
      return;
    }

    // Send DELETE request to the API
    try {
      console.log("selectedMember", selectedMember);
      await axiosInstance.delete(`members/${selectedMember}`);

      // Update local state by removing the deleted member
      const delMember =  members.find((member) => selectedMember != member.id);
      console.log(`Delete member ${delMember.name} successfully`);
      setMembers(members.filter((member) => selectedMember != member.id));
      
      setSelectedMember(null); // Reset selected member
      
    } catch (error) {
      console.error("Error deleting member:", error);
      setError("Error deleting member");
    }
  };

  // Handle input change
  const handleInputChange = (e) => {
    console.log(e);
    const { name, value } = e.target;
    setNewMember({ ...newMember, [name]: value });
  };

  // Handle date changes for DatePicker
  const handleDateChange = (field, date) => {
    setNewMember({ ...newMember, [field]: date });
  };

  // Handle row selection
  const handleRowSelection = (ids) => {
    console.log("handleRowSelection ", ids);
    if (ids.length > 0) {
      setSelectedMember(ids[0]);
      console.log("selectedMember ", selectedMember);
    } else {
      setSelectedMember(null);
    }
  };

  // Define columns for the DataGrid
  const columns = [
    { field: "id", headerName: "ID", width: 70 },
    { field: "name", headerName: "Name", width: 150 },
    { field: "phone", headerName: "Phone", width: 150 },
    { field: "email", headerName: "Email", width: 200 },
    { field: "status", headerName: "Status", width: 100 },
    { field: "joinDate", headerName: "Join Date", width: 150 },
    { field: "birthday", headerName: "Birthday", width: 150 },
  ];

  // Show loading or error message
  if (loading) return <p>Loading...</p>;
  // if (error) return <p>{error}</p>;

  return (
    <div style={{ width: "100%" }}>
      <Grid container spacing={2} style={{ marginBottom: "16px" }}>
        <Grid item xs={12} sm={4}>
          <TextField
            fullWidth
            label="Name"
            name="name"
            value={newMember.name}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={12} sm={4}>
          <TextField
            fullWidth
            label="Phone"
            name="phone"
            value={newMember.phone}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={12} sm={4}>
          <TextField
            fullWidth
            label="Email"
            name="email"
            value={newMember.email}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="Birthday"
              value={newMember.birthday}
              onChange={(date) => handleDateChange("birthday", date)}
              renderInput={(params) => <TextField fullWidth {...params} />}
            />
          </LocalizationProvider>
        </Grid>
        <Grid item>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="Join Date"
              value={newMember.joinDate}
              onChange={(date) => handleDateChange("joinDate", date)}
              renderInput={(params) => <TextField fullWidth {...params} />}
            />
          </LocalizationProvider>
        </Grid>
      </Grid>
      <Button size="small" onClick={handleAddRow}>
        Add a row
      </Button>

      <Button size="small" onClick={handleDeleteRow}>
        DELETE
      </Button>
      <div style={{ height: 400, width: "100%", marginTop: "16px" }}>
        <DataGrid
          rows={members}
          columns={columns}
          pageSize={10}
          checkboxSelection
          onRowSelectionModelChange={handleRowSelection}
        />
      </div>
    </div>
  );
}
