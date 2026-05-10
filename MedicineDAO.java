package clinic.dao;

import clinic.model.Medicine;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class MedicineDAO {
    public List<Medicine> findAll() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine ORDER BY medicine_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Medicine(rs.getInt("medicine_id"), rs.getString("name"), rs.getString("type"), rs.getInt("quantity"), rs.getInt("minimum_quantity"), rs.getDouble("price"), rs.getString("expiry_date"), rs.getString("description")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Medicine x) {
        String sql = "INSERT INTO Medicine(name,type,quantity,minimum_quantity,price,expiry_date,description) VALUES(?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getName());
            ps.setString(2, x.getType());
            ps.setInt(3, x.getQuantity());
            ps.setInt(4, x.getMinimumQuantity());
            ps.setDouble(5, x.getPrice());
            ps.setString(6, x.getExpiryDate());
            ps.setString(7, x.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Medicine x) {
        String sql = "UPDATE Medicine SET name=?,type=?,quantity=?,minimum_quantity=?,price=?,expiry_date=?,description=? WHERE medicine_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, x.getName());
            ps.setString(2, x.getType());
            ps.setInt(3, x.getQuantity());
            ps.setInt(4, x.getMinimumQuantity());
            ps.setDouble(5, x.getPrice());
            ps.setString(6, x.getExpiryDate());
            ps.setString(7, x.getDescription());
            ps.setInt(8, x.getMedicineId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Medicine WHERE medicine_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
