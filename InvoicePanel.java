package clinic.view;

import javax.swing.*;
import java.awt.*;

public class InvoicePanel extends JPanel {
    public InvoicePanel() {
        setLayout(new BorderLayout());
        add(CrudHelper.top("Quản lý thanh toán / hóa đơn"), BorderLayout.NORTH);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        area.setText("Module: Quản lý thanh toán / hóa đơn\n\n"
            + "Đây là khung giao diện để phát triển tiếp CRUD chi tiết.\n"
            + "Các class Model và DAO tương ứng đã được tạo trong project.\n\n"
            + "Bạn có thể làm giống PatientPanel để thêm/sửa/xóa dữ liệu.");
        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
