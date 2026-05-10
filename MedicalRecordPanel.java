package clinic.view;

import javax.swing.*;
import java.awt.*;

public class MedicalRecordPanel extends JPanel {
    public MedicalRecordPanel() {
        setLayout(new BorderLayout());
        add(CrudHelper.top("Quản lý hồ sơ khám bệnh"), BorderLayout.NORTH);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        area.setText("Module: Quản lý hồ sơ khám bệnh\n\n"
            + "Đây là khung giao diện để phát triển tiếp CRUD chi tiết.\n"
            + "Các class Model và DAO tương ứng đã được tạo trong project.\n\n"
            + "Bạn có thể làm giống PatientPanel để thêm/sửa/xóa dữ liệu.");
        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
