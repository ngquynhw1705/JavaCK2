package clinic.dao;

import clinic.model.Invoice;
import clinic.util.DBConnection;
import java.sql.*;
import java.util.*;

public class InvoiceDAO {
    public List<Invoice> findAll() {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM Invoice ORDER BY invoice_id DESC";
        try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Invoice(rs.getInt("invoice_id"), rs.getInt("patient_id"), rs.getString("invoice_date"), rs.getDouble("examination_fee"), rs.getDouble("medicine_fee"), rs.getDouble("service_fee"), rs.getDouble("discount"), rs.getDouble("total_amount"), rs.getString("payment_method")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean insert(Invoice x) {
        String sql = "INSERT INTO Invoice(patient_id,invoice_date,examination_fee,medicine_fee,service_fee,discount,total_amount,payment_method) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setString(2, x.getInvoiceDate());
            ps.setDouble(3, x.getExaminationFee());
            ps.setDouble(4, x.getMedicineFee());
            ps.setDouble(5, x.getServiceFee());
            ps.setDouble(6, x.getDiscount());
            ps.setDouble(7, x.getTotalAmount());
            ps.setString(8, x.getPaymentMethod());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean update(Invoice x) {
        String sql = "UPDATE Invoice SET patient_id=?,invoice_date=?,examination_fee=?,medicine_fee=?,service_fee=?,discount=?,total_amount=?,payment_method=? WHERE invoice_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, x.getPatientId());
            ps.setString(2, x.getInvoiceDate());
            ps.setDouble(3, x.getExaminationFee());
            ps.setDouble(4, x.getMedicineFee());
            ps.setDouble(5, x.getServiceFee());
            ps.setDouble(6, x.getDiscount());
            ps.setDouble(7, x.getTotalAmount());
            ps.setString(8, x.getPaymentMethod());
            ps.setInt(9, x.getInvoiceId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Invoice WHERE invoice_id=?";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
