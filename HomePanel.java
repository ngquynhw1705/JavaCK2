package clinic.view;

import clinic.util.Session;
import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BorderLayout());
        JLabel lb = new JLabel("<html><h1>Phần mềm quản lý phòng khám da liễu</h1><p>Xin chào: "
                + Session.fullName + "</p><p>Vai trò: " + Session.role + "</p></html>", SwingConstants.CENTER);
        add(lb, BorderLayout.CENTER);
    }
}
