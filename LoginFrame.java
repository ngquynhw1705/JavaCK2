package clinic.view;

import clinic.service.AuthService;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();

    public LoginFrame() {
        setTitle("Đăng nhập hệ thống phòng khám da liễu");
        setSize(420, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel("DERM CLINIC MANAGER", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(title);
        panel.add(fieldPanel("Tên đăng nhập", txtUsername));
        panel.add(fieldPanel("Mật khẩu", txtPassword));

        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.addActionListener(e -> login());
        panel.add(btnLogin);

        add(panel);
    }

    private JPanel fieldPanel(String label, JComponent input) {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.add(new JLabel(label), BorderLayout.WEST);
        p.add(input, BorderLayout.CENTER);
        return p;
    }

    private void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (new AuthService().login(username, password)) {
            dispose();
            new MainFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
        }
    }
}
