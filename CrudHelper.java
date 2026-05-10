package clinic.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CrudHelper {
    public static JPanel top(String title) {
        JPanel p = new JPanel(new BorderLayout());
        JLabel lb = new JLabel(title);
        lb.setFont(new Font("Arial", Font.BOLD, 22));
        p.add(lb, BorderLayout.WEST);
        return p;
    }

    public static JTextField text(String value) {
        return new JTextField(value == null ? "" : value);
    }

    public static void msg(Component c, String s) {
        JOptionPane.showMessageDialog(c, s);
    }

    public static DefaultTableModel model(String... cols) {
        return new DefaultTableModel(cols, 0);
    }
}
