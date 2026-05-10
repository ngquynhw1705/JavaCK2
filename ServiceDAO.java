package clinic.dao;

import clinic.model.ClinicService;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class ServiceDAO {
    public List<ClinicService> findAll() {
        List<ClinicService> list = new ArrayList<>();
        String sql = "SELECT * FROM Service ORDER BY service_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new ClinicService(rs.getInt("service_id"), rs.getString("name"), rs.getDouble("price"), rs.getString("duration"), rs.getString("description")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(ClinicService x) {
        String sql = "INSERT INTO Service(name,price,duration,description) VALUES(?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getName());
            ps.setDouble(2, x.getPrice());
            ps.setString(3, x.getDuration());
            ps.setString(4, x.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(ClinicService x) {
        String sql = "UPDATE Service SET name=?,price=?,duration=?,description=? WHERE service_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getName());
            ps.setDouble(2, x.getPrice());
            ps.setString(3, x.getDuration());
            ps.setString(4, x.getDescription());
            ps.setInt(5, x.getServiceId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Service WHERE service_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
