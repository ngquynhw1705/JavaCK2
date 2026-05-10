package clinic.dao;

import clinic.model.Treatment;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class TreatmentDAO {
    public List<Treatment> findAll() {
        List<Treatment> list = new ArrayList<>();
        String sql = "SELECT * FROM Treatment ORDER BY treatment_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Treatment(rs.getInt("treatment_id"), rs.getInt("patient_id"), rs.getInt("doctor_id"), rs.getString("treatment_name"), rs.getString("start_date"), rs.getString("end_date"), rs.getString("initial_condition"), rs.getString("result"), rs.getString("evaluation"), rs.getString("before_image"), rs.getString("after_image")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Treatment x) {
        String sql = "INSERT INTO Treatment(patient_id,doctor_id,treatment_name,start_date,end_date,initial_condition,result,evaluation,before_image,after_image) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setInt(2, x.getDoctorId());
            ps.setString(3, x.getTreatmentName());
            ps.setString(4, x.getStartDate());
            ps.setString(5, x.getEndDate());
            ps.setString(6, x.getInitialCondition());
            ps.setString(7, x.getResult());
            ps.setString(8, x.getEvaluation());
            ps.setString(9, x.getBeforeImage());
            ps.setString(10, x.getAfterImage());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Treatment x) {
        String sql = "UPDATE Treatment SET patient_id=?,doctor_id=?,treatment_name=?,start_date=?,end_date=?,initial_condition=?,result=?,evaluation=?,before_image=?,after_image=? WHERE treatment_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setInt(2, x.getDoctorId());
            ps.setString(3, x.getTreatmentName());
            ps.setString(4, x.getStartDate());
            ps.setString(5, x.getEndDate());
            ps.setString(6, x.getInitialCondition());
            ps.setString(7, x.getResult());
            ps.setString(8, x.getEvaluation());
            ps.setString(9, x.getBeforeImage());
            ps.setString(10, x.getAfterImage());
            ps.setInt(11, x.getTreatmentId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Treatment WHERE treatment_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
