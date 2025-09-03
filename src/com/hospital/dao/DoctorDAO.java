package com.hospital.dao;

import com.hospital.model.Doctor;
import com.hospital.util.DBConnection;
import java.sql.*;

public class DoctorDAO {
    public static void addDoctor(String name, String specialization) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO doctors(name, specialization) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewDoctors() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM doctors";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("specialization"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
