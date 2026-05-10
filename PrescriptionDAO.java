package clinic.dao;

import clinic.model.Prescription;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class PrescriptionDAO {
    public List<Prescription> findAll() {
        List<Prescription> list = new ArrayList<>();
        String sql = "SELECT * FROM Prescription ORDER BY prescription_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Prescription(rs.getInt("prescription_id"), rs.getInt("record_id"), rs.getInt("patient_id"), rs.getInt("doctor_id"), rs.getString("created_date"), rs.getString("status")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Prescription x) {
        String sql = "INSERT INTO Prescription(record_id,patient_id,doctor_id,created_date,status) VALUES(?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getRecordId());
            ps.setInt(2, x.getPatientId());
            ps.setInt(3, x.getDoctorId());
            ps.setString(4, x.getCreatedDate());
            ps.setString(5, x.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Prescription x) {
        String sql = "UPDATE Prescription SET record_id=?,patient_id=?,doctor_id=?,created_date=?,status=? WHERE prescription_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getRecordId());
            ps.setInt(2, x.getPatientId());
            ps.setInt(3, x.getDoctorId());
            ps.setString(4, x.getCreatedDate());
            ps.setString(5, x.getStatus());
            ps.setInt(6, x.getPrescriptionId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Prescription WHERE prescription_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
