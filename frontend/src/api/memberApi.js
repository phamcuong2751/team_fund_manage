// src/api/memberApi.js
import axiosInstance from './api';

export const fetchMemberData = async () => {
    try {
        const response = await axiosInstance.get('members'); // Adjust 'members' path if necessary
        if (response.data.status_code === 200) {
            return response.data.data; // member data
        } else {
            throw new Error('Failed to fetch member data');
        }
    } catch (error) {
        throw error;
    }
};
