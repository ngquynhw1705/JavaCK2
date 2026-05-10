package clinic.dao;

import clinic.model.Account;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class AccountDAO {
    public Account login(String username, String password) {
        String sql = "SELECT * FROM Account WHERE username=? AND password=? AND status='ACTIVE'";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getInt("account_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("full_name"),
                    rs.getString("role"),
                    rs.getString("status")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account ORDER BY account_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"),
                    rs.getString("full_name"), rs.getString("role"), rs.getString("status")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Account a) {
        String sql = "INSERT INTO Account(username,password,full_name,role,status) VALUES(?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,a.getUsername()); ps.setString(2,a.getPassword()); ps.setString(3,a.getFullName());
            ps.setString(4,a.getRole()); ps.setString(5,a.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Account a) {
        String sql = "UPDATE Account SET username=?, password=?, full_name=?, role=?, status=? WHERE account_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,a.getUsername()); ps.setString(2,a.getPassword()); ps.setString(3,a.getFullName());
            ps.setString(4,a.getRole()); ps.setString(5,a.getStatus()); ps.setInt(6,a.getAccountId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM Account WHERE account_id=?")) {
            ps.setInt(1,id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
