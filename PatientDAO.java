package clinic.dao;

import clinic.model.Patient;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class PatientDAO {
    public List<Patient> findAll() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Patient ORDER BY patient_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(rs.getInt("patient_id"), rs.getString("full_name"), rs.getString("birth_date"), rs.getString("gender"), rs.getString("phone"), rs.getString("address"), rs.getString("customer_type"), rs.getInt("points"), rs.getInt("account_id")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Patient x) {
        String sql = "INSERT INTO Patient(full_name,birth_date,gender,phone,address,customer_type,points,account_id) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getFullName());
            ps.setString(2, x.getBirthDate());
            ps.setString(3, x.getGender());
            ps.setString(4, x.getPhone());
            ps.setString(5, x.getAddress());
            ps.setString(6, x.getCustomerType());
            ps.setInt(7, x.getPoints());
            ps.setInt(8, x.getAccountId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Patient x) {
        String sql = "UPDATE Patient SET full_name=?,birth_date=?,gender=?,phone=?,address=?,customer_type=?,points=?,account_id=? WHERE patient_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getFullName());
            ps.setString(2, x.getBirthDate());
            ps.setString(3, x.getGender());
            ps.setString(4, x.getPhone());
            ps.setString(5, x.getAddress());
            ps.setString(6, x.getCustomerType());
            ps.setInt(7, x.getPoints());
            ps.setInt(8, x.getAccountId());
            ps.setInt(9, x.getPatientId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Patient WHERE patient_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
