package clinic.dao;

import clinic.model.Appointment;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class AppointmentDAO {
    public List<Appointment> findAll() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM Appointment ORDER BY appointment_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Appointment(rs.getInt("appointment_id"), rs.getInt("patient_id"), rs.getInt("doctor_id"), rs.getString("appointment_date"), rs.getString("appointment_time"), rs.getString("reason"), rs.getString("status")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Appointment x) {
        String sql = "INSERT INTO Appointment(patient_id,doctor_id,appointment_date,appointment_time,reason,status) VALUES(?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setInt(2, x.getDoctorId());
            ps.setString(3, x.getAppointmentDate());
            ps.setString(4, x.getAppointmentTime());
            ps.setString(5, x.getReason());
            ps.setString(6, x.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Appointment x) {
        String sql = "UPDATE Appointment SET patient_id=?,doctor_id=?,appointment_date=?,appointment_time=?,reason=?,status=? WHERE appointment_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setInt(2, x.getDoctorId());
            ps.setString(3, x.getAppointmentDate());
            ps.setString(4, x.getAppointmentTime());
            ps.setString(5, x.getReason());
            ps.setString(6, x.getStatus());
            ps.setInt(7, x.getAppointmentId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Appointment WHERE appointment_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
