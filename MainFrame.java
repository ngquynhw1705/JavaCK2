package clinic.view;

import clinic.util.Session;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel content = new JPanel(new BorderLayout());

    public MainFrame() {
        setTitle("Quản lý phòng khám da liễu - " + Session.fullName + " (" + Session.role + ")");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel menu = new JPanel(new GridLayout(0, 1, 5, 5));
        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        menu.setPreferredSize(new Dimension(230, 0));

        addButton(menu, "Trang chủ", new HomePanel());

        String role = Session.role;

        if ("ADMIN".equals(role)) {
            addButton(menu, "Tài khoản", new AccountPanel());
            addButton(menu, "Bệnh nhân", new PatientPanel());
            addButton(menu, "Bác sĩ", new DoctorPanel());
            addButton(menu, "Lịch khám", new AppointmentPanel());
            addButton(menu, "Hồ sơ khám", new MedicalRecordPanel());
            addButton(menu, "Thuốc/Mỹ phẩm", new MedicinePanel());
            addButton(menu, "Dịch vụ", new ServicePanel());
            addButton(menu, "Liệu trình", new TreatmentPanel());
            addButton(menu, "Đơn thuốc", new PrescriptionPanel());
            addButton(menu, "Thanh toán", new InvoicePanel());
            addButton(menu, "Báo cáo", new ReportPanel());
        } else if ("DOCTOR".equals(role)) {
            addButton(menu, "Lịch khám", new AppointmentPanel());
            addButton(menu, "Hồ sơ khám", new MedicalRecordPanel());
            addButton(menu, "Liệu trình", new TreatmentPanel());
            addButton(menu, "Đơn thuốc", new PrescriptionPanel());
        } else if ("RECEPTIONIST".equals(role)) {
            addButton(menu, "Bệnh nhân", new PatientPanel());
            addButton(menu, "Lịch khám", new AppointmentPanel());
            addButton(menu, "Thanh toán", new InvoicePanel());
        } else if ("PHARMACIST".equals(role)) {
            addButton(menu, "Thuốc/Mỹ phẩm", new MedicinePanel());
            addButton(menu, "Đơn thuốc", new PrescriptionPanel());
        } else if ("CUSTOMER".equals(role)) {
            addButton(menu, "Thông tin cá nhân", new CustomerPanel());
            addButton(menu, "Đặt lịch khám", new AppointmentPanel());
            addButton(menu, "Hóa đơn", new InvoicePanel());
        }

        JButton logout = new JButton("Đăng xuất");
        logout.addActionListener(e -> {
            Session.clear();
            dispose();
            new LoginFrame().setVisible(true);
        });
        menu.add(logout);

        add(menu, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
        showPanel(new HomePanel());
    }

    private void addButton(JPanel menu, String text, JPanel panel) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> showPanel(panel));
        menu.add(btn);
    }

    private void showPanel(JPanel panel) {
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
}
