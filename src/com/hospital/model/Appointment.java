package com.hospital.model;

import java.sql.Date;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private Date date;

    public Appointment(int id, int patientId, int doctorId, Date date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public Date getDate() { return date; }
}
