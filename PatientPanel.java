package clinic.view;

import clinic.dao.PatientDAO;
import clinic.model.Patient;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PatientPanel extends JPanel {
    private PatientDAO dao = new PatientDAO();
    private JTable table = new JTable();
    private DefaultTableModel model = CrudHelper.model("ID","Họ tên","Ngày sinh","Giới tính","SĐT","Địa chỉ","Loại KH","Điểm","AccountID");

    public PatientPanel() {
        setLayout(new BorderLayout(10,10));
        add(CrudHelper.top("Quản lý bệnh nhân / khách hàng"), BorderLayout.NORTH);
        table.setModel(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel btns = new JPanel();
        JButton add = new JButton("Thêm"), edit = new JButton("Sửa"), del = new JButton("Xóa"), reload = new JButton("Tải lại");
        btns.add(add); btns.add(edit); btns.add(del); btns.add(reload);
        add(btns, BorderLayout.SOUTH);
        add.addActionListener(e -> form(null));
        edit.addActionListener(e -> editSelected());
        del.addActionListener(e -> { int r=table.getSelectedRow(); if(r>=0 && dao.delete((int)model.getValueAt(r,0))) load(); });
        reload.addActionListener(e -> load());
        load();
    }

    private void load() {
        model.setRowCount(0);
        for(Patient x: dao.findAll()) model.addRow(new Object[]{x.getPatientId(),x.getFullName(),x.getBirthDate(),x.getGender(),x.getPhone(),x.getAddress(),x.getCustomerType(),x.getPoints(),x.getAccountId()});
    }

    private void editSelected() {
        int r=table.getSelectedRow(); if(r<0) return;
        form(new Patient((int)model.getValueAt(r,0), str(r,1), str(r,2), str(r,3), str(r,4), str(r,5), str(r,6), Integer.parseInt(str(r,7)), Integer.parseInt(str(r,8))));
    }

    private String str(int r,int c){ Object v=model.getValueAt(r,c); return v==null?"":v.toString(); }

    private void form(Patient a) {
        JTextField name=CrudHelper.text(a==null?"":a.getFullName());
        JTextField birth=CrudHelper.text(a==null?"2005-01-01":a.getBirthDate());
        JComboBox<String> gender=new JComboBox<>(new String[]{"Nam","Nữ","Khác"});
        JTextField phone=CrudHelper.text(a==null?"":a.getPhone());
        JTextField address=CrudHelper.text(a==null?"":a.getAddress());
        JComboBox<String> type=new JComboBox<>(new String[]{"Thường","VIP","VVIP"});
        JTextField points=CrudHelper.text(a==null?"0":String.valueOf(a.getPoints()));
        JTextField accountId=CrudHelper.text(a==null?"0":String.valueOf(a.getAccountId()));
        if(a!=null){gender.setSelectedItem(a.getGender());type.setSelectedItem(a.getCustomerType());}
        JPanel p=new JPanel(new GridLayout(0,2));
        p.add(new JLabel("Họ tên"));p.add(name); p.add(new JLabel("Ngày sinh yyyy-MM-dd"));p.add(birth);
        p.add(new JLabel("Giới tính"));p.add(gender); p.add(new JLabel("SĐT"));p.add(phone);
        p.add(new JLabel("Địa chỉ"));p.add(address); p.add(new JLabel("Loại KH"));p.add(type);
        p.add(new JLabel("Điểm"));p.add(points); p.add(new JLabel("Account ID"));p.add(accountId);
        if(JOptionPane.showConfirmDialog(this,p,"Bệnh nhân",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            Patient x=new Patient(a==null?0:a.getPatientId(),name.getText(),birth.getText(),gender.getSelectedItem().toString(),phone.getText(),address.getText(),type.getSelectedItem().toString(),Integer.parseInt(points.getText()),Integer.parseInt(accountId.getText()));
            boolean ok=a==null?dao.insert(x):dao.update(x); if(ok)load();
        }
    }
}
