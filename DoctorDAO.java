package clinic.dao;

import clinic.model.Doctor;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class DoctorDAO {
    public List<Doctor> findAll() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctor ORDER BY doctor_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("doctor_id"), rs.getString("full_name"), rs.getString("phone"), rs.getString("email"), rs.getString("specialty"), rs.getString("work_schedule"), rs.getInt("patient_count"), rs.getInt("account_id")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Doctor x) {
        String sql = "INSERT INTO Doctor(full_name,phone,email,specialty,work_schedule,patient_count,account_id) VALUES(?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getFullName());
            ps.setString(2, x.getPhone());
            ps.setString(3, x.getEmail());
            ps.setString(4, x.getSpecialty());
            ps.setString(5, x.getWorkSchedule());
            ps.setInt(6, x.getPatientCount());
            ps.setInt(7, x.getAccountId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Doctor x) {
        String sql = "UPDATE Doctor SET full_name=?,phone=?,email=?,specialty=?,work_schedule=?,patient_count=?,account_id=? WHERE doctor_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getFullName());
            ps.setString(2, x.getPhone());
            ps.setString(3, x.getEmail());
            ps.setString(4, x.getSpecialty());
            ps.setString(5, x.getWorkSchedule());
            ps.setInt(6, x.getPatientCount());
            ps.setInt(7, x.getAccountId());
            ps.setInt(8, x.getDoctorId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Doctor WHERE doctor_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
