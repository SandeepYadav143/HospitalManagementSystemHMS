package com.hospital.dao;

import com.hospital.model.Patient;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.*;

public class PatientDAO {
    public static void addPatient(String name, int age, String disease) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewPatients() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM patients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("age") + " | " +
                                   rs.getString("disease"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
