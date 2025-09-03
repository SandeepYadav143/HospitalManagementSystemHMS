package com.hospital;

import java.sql.Date;
import java.util.Scanner;
import com.hospital.dao.PatientDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.AppointmentDAO;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine();
                    PatientDAO.addPatient(pname, age, disease);
                    break;
                case 2:
                    PatientDAO.viewPatients();
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter specialization: ");
                    String spec = sc.nextLine();
                    DoctorDAO.addDoctor(dname, spec);
                    break;
                case 4:
                    DoctorDAO.viewDoctors();
                    break;
                case 5:
                    System.out.print("Enter patient id: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter doctor id: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String dateStr = sc.nextLine();
                    Date date = Date.valueOf(dateStr);
                    AppointmentDAO.addAppointment(pid, did, date);
                    break;
                case 6:
                    AppointmentDAO.viewAppointments();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
