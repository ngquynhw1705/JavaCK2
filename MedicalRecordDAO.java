package clinic.dao;

import clinic.model.MedicalRecord;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class MedicalRecordDAO {
    public List<MedicalRecord> findAll() {
        List<MedicalRecord> list = new ArrayList<>();
        String sql = "SELECT * FROM MedicalRecord ORDER BY record_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new MedicalRecord(rs.getInt("record_id"), rs.getInt("patient_id"), rs.getInt("doctor_id"), rs.getInt("appointment_id"), rs.getString("examination_date"), rs.getString("symptoms"), rs.getString("diagnosis"), rs.getString("treatment_method"), rs.getString("prescription"), rs.getString("note")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(MedicalRecord x) {
        String sql = "INSERT INTO MedicalRecord(patient_id,doctor_id,appointment_id,examination_date,symptoms,diagnosis,treatment_method,prescription,note) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setInt(2, x.getDoctorId());
            ps.setInt(3, x.getAppointmentId());
            ps.setString(4, x.getExaminationDate());
            ps.setString(5, x.getSymptoms());
            ps.setString(6, x.getDiagnosis());
            ps.setString(7, x.getTreatmentMethod());
            ps.setString(8, x.getPrescription());
            ps.setString(9, x.getNote());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(MedicalRecord x) {
        String sql = "UPDATE MedicalRecord SET patient_id=?,doctor_id=?,appointment_id=?,examination_date=?,symptoms=?,diagnosis=?,treatment_method=?,prescription=?,note=? WHERE record_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setInt(2, x.getDoctorId());
            ps.setInt(3, x.getAppointmentId());
            ps.setString(4, x.getExaminationDate());
            ps.setString(5, x.getSymptoms());
            ps.setString(6, x.getDiagnosis());
            ps.setString(7, x.getTreatmentMethod());
            ps.setString(8, x.getPrescription());
            ps.setString(9, x.getNote());
            ps.setInt(10, x.getRecordId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM MedicalRecord WHERE record_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
