package clinic.view;

import clinic.dao.AccountDAO;
import clinic.model.Account;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AccountPanel extends JPanel {
    private AccountDAO dao = new AccountDAO();
    private JTable table = new JTable();
    private DefaultTableModel model;

    public AccountPanel() {
        setLayout(new BorderLayout(10,10));
        add(CrudHelper.top("Quản lý tài khoản"), BorderLayout.NORTH);

        model = CrudHelper.model("ID","Username","Password","Họ tên","Role","Status");
        table.setModel(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton add = new JButton("Thêm");
        JButton edit = new JButton("Sửa");
        JButton del = new JButton("Xóa");
        JButton reload = new JButton("Tải lại");
        buttons.add(add); buttons.add(edit); buttons.add(del); buttons.add(reload);
        add(buttons, BorderLayout.SOUTH);

        add.addActionListener(e -> form(null));
        edit.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r < 0) return;
            form(new Account(
                Integer.parseInt(model.getValueAt(r,0).toString()),
                model.getValueAt(r,1).toString(),
                model.getValueAt(r,2).toString(),
                model.getValueAt(r,3).toString(),
                model.getValueAt(r,4).toString(),
                model.getValueAt(r,5).toString()
            ));
        });
        del.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0 && dao.delete(Integer.parseInt(model.getValueAt(r,0).toString()))) load();
        });
        reload.addActionListener(e -> load());
        load();
    }

    private void load() {
        model.setRowCount(0);
        for (Account a : dao.findAll()) {
            model.addRow(new Object[]{a.getAccountId(),a.getUsername(),a.getPassword(),a.getFullName(),a.getRole(),a.getStatus()});
        }
    }

    private void form(Account a) {
        JTextField username = CrudHelper.text(a==null?"":a.getUsername());
        JTextField password = CrudHelper.text(a==null?"123":a.getPassword());
        JTextField fullName = CrudHelper.text(a==null?"":a.getFullName());
        JComboBox<String> role = new JComboBox<>(new String[]{"ADMIN","DOCTOR","RECEPTIONIST","PHARMACIST","CUSTOMER"});
        JComboBox<String> status = new JComboBox<>(new String[]{"ACTIVE","LOCKED"});
        if (a != null) { role.setSelectedItem(a.getRole()); status.setSelectedItem(a.getStatus()); }

        JPanel p = new JPanel(new GridLayout(0,2));
        p.add(new JLabel("Username")); p.add(username);
        p.add(new JLabel("Password")); p.add(password);
        p.add(new JLabel("Họ tên")); p.add(fullName);
        p.add(new JLabel("Role")); p.add(role);
        p.add(new JLabel("Status")); p.add(status);

        if (JOptionPane.showConfirmDialog(this,p,"Thông tin tài khoản",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
            Account x = new Account(a==null?0:a.getAccountId(), username.getText(), password.getText(), fullName.getText(), role.getSelectedItem().toString(), status.getSelectedItem().toString());
            boolean ok = a==null ? dao.insert(x) : dao.update(x);
            if (ok) load();
        }
    }
}
