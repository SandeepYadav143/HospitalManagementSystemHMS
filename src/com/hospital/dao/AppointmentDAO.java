package com.hospital.dao;

import com.hospital.util.DBConnection;
import java.sql.*;

public class AppointmentDAO {
    public static void addAppointment(int patientId, int doctorId, Date date) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO appointments(patient_id, doctor_id, date) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setDate(3, date);
            ps.executeUpdate();
            System.out.println("Appointment scheduled successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewAppointments() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM appointments";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getInt("patient_id") + " | " +
                                   rs.getInt("doctor_id") + " | " +
                                   rs.getDate("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
