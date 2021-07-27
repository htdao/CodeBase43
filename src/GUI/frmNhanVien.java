/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.NhanVien;
import Utils.ValidateData;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dao Ha
 */
public class frmNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form frmNhanVien
     */
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    NhanVien nv = new NhanVien();
    ArrayList<NhanVien> listNV = new ArrayList<>();

    public frmNhanVien() {
        initComponents();
        lbl_hello.setText("Xin chào, " + frmDangNhap.userName + " !");
        loadFile();
        getData(listNV);
    }

    public ArrayList<NhanVien> getListNV(){
        return listNV;
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNV = new ArrayList<>(); //lưu ý
            fr = new FileReader("nhanvien.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(arr[0]);
                    nv.setHoTen(arr[1]);
                    nv.setGioiTinh(arr[2]);
                    nv.setEmail(arr[3]);
                    nv.setSoDienThoai(arr[4]);
                    nv.setMatKhau(arr[5]);
                    nv.setNhom(Integer.parseInt(arr[6]));
                    nv.setTrangThai(Integer.parseInt(arr[7]));
                    listNV.add(nv);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getData(ArrayList<NhanVien> listNV) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Họ tên NV");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SĐT");
        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Trạng Thái");

        for (NhanVien obj : listNV) {
            Vector vector = new Vector();
            vector.add(obj.getMaNhanVien());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getEmail());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        tbl_nhanvien.setModel(defaultTableModel);
    }

    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listNV.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listNV.get(i).getMaNhanVien() + "\t";
                row = row + listNV.get(i).getHoTen() + "\t";
                row = row + listNV.get(i).getGioiTinh() + "\t";
                row = row + listNV.get(i).getEmail() + "\t";
                row = row + listNV.get(i).getSoDienThoai() + "\t";
                row = row + listNV.get(i).getMatKhau() + "\t";
                row = row + listNV.get(i).getNhom() + "\t";
                row = row + listNV.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("nhanvien.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reset() {
        txt_email.setText("");
        txt_maNhanVien.setText("");
        txt_hoTen.setText("");
        txt_matKhau.setText("");
        txt_soDienThoai.setText("");
        txt_gioiTinh.setSelectedIndex(0);
        txt_nhom.setSelectedIndex(0);
        txt_trangThai.setSelectedIndex(0);
        txt_matKhau.setEnabled(true);
        txt_maNhanVien.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_them.setEnabled(true);
        btn_xoa.setEnabled(true);
        getData(listNV);
    }

    public boolean check_maNV(String maNV) {
        for (int i = 0; i < listNV.size(); i++) {
            if (maNV.equals(listNV.get(i).getMaNhanVien())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_timKiem = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_maNhanVien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nhom = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_gioiTinh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_soDienThoai = new javax.swing.JTextField();
        txt_trangThai = new javax.swing.JComboBox<>();
        txt_matKhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_hello = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1110, 240));

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-add-icon.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setToolTipText("");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 118, 40));

        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Files-Edit-file-icon.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 118, 40));

        btn_thoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alarm-Error-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 320, 118, 40));

        btn_xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-icon.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, 118, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setAutoscrolls(true);

        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon (1).png"))); // NOI18N
        btn_timKiem.setBorder(null);
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_timKiem)
                    .addComponent(btn_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "THÔNG TIN NHÂN VIÊN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Mã Nhân Viên");

        txt_maNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Họ Tên");

        txt_hoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Nhóm");

        txt_nhom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nhom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân Viên" }));
        txt_nhom.setBorder(null);
        txt_nhom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nhomActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Giới Tính");

        txt_gioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        txt_gioiTinh.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("SĐT");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Trạng Thái");

        txt_soDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_soDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soDienThoaiActionPerformed(evt);
            }
        });

        txt_trangThai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Đã khóa" }));
        txt_trangThai.setBorder(null);

        txt_matKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Mật Khẩu");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Email");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_matKhau)
                    .addComponent(txt_soDienThoai)
                    .addComponent(txt_nhom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_hoTen)
                            .addComponent(txt_gioiTinh, 0, 203, Short.MAX_VALUE)
                            .addComponent(txt_email)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_trangThai, 0, 200, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nhom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel3)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txt_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 113, 690, 270));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Zent Coding School");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(276, 276, 276))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        lbl_hello.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_hello.setForeground(new java.awt.Color(0, 0, 204));
        lbl_hello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PF18.jpg"))); // NOI18N
        add(lbl_hello, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 730));

        jLabel12.setText("jLabel12");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nhomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nhomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nhomActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem.getText();
        if (tuKhoa == "") {
            getData(listNV);
        } else {
            ArrayList<NhanVien> listSearch = new ArrayList<>();
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getMaNhanVien().contains(tuKhoa) || listNV.get(i).getHoTen().contains(tuKhoa) || listNV.get(i).getEmail().contains(tuKhoa) || listNV.get(i).getSoDienThoai().contains(tuKhoa)) {
                    listSearch.add(listNV.get(i));
                }
            }
            getData(listSearch);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int dem = 0;

        String gioiTinh = "";
        if (txt_gioiTinh.getSelectedItem().equals("Nam")) {
            gioiTinh = "Nam";
        } else if (txt_gioiTinh.getSelectedItem().equals("Nữ")) {
            gioiTinh = "Nữ";
        } else {
            gioiTinh = "Khác";
        }

        int nhom = 0;
        if (txt_nhom.getSelectedItem().toString().equals("Quản lý")) {
            nhom = 1;
        } else {
            nhom = 0;
        }

        int trangThai = 0;
        if (txt_trangThai.getSelectedItem().toString().equals("Hoạt động")) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }

        String email = txt_email.getText();
        String matKhau = validate.md5(txt_matKhau.getText());
        String sdt = txt_soDienThoai.getText();
        String hoTen = txt_hoTen.getText();

        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống!");
            dem++;
            return;

        } else {
            nv.setHoTen(validate.chuanHoaTen(hoTen));
        }

        if (email.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
            dem++;
            return;
        } else {
            if (validate.check_email(email) == false) {
                JOptionPane.showMessageDialog(this, "Email nhập không đúng định dạng!");
                dem++;
                return;
            } else {
                nv.setEmail(email);
            }
        }

        String check_sdt = validate.check_sdt(sdt);
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
            dem++;
            return;
        } else {
            if (check_sdt.equals("corret")) {
                nv.setSoDienThoai(sdt);
            } else {
                JOptionPane.showMessageDialog(this, check_sdt);
                return;
            }
        }

        nv.setGioiTinh(gioiTinh);
        nv.setNhom(nhom);
        nv.setTrangThai(trangThai);
        if (dem == 0) {
            listNV.set(index, nv);
            saveFile();
            getData(listNV);
            JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!");
            reset();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_soDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soDienThoaiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        NhanVien nv = new NhanVien();
        String maNV = txt_maNhanVien.getText();
        String hoTen = txt_hoTen.getText();

        String gioiTinh = "";
        if (txt_gioiTinh.getSelectedItem().equals("Nam")) {
            gioiTinh = "Nam";
        } else if (txt_gioiTinh.getSelectedItem().equals("Nữ")) {
            gioiTinh = "Nữ";
        } else {
            gioiTinh = "Khác";
        }

        int nhom = 0;
        if (txt_nhom.getSelectedItem().toString().equals("Quản lý")) {
            nhom = 1;
        } else {
            nhom = 0;
        }

        int trangThai = 0;
        if (txt_trangThai.getSelectedItem().toString().equals("Hoạt động")) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }

        String email = txt_email.getText();
        String matKhau = validate.md5(txt_matKhau.getText());
        String sdt = txt_soDienThoai.getText();

        if (maNV.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống!");
            return;
        } else {
            if (check_maNV(maNV) == false) {
                nv.setMaNhanVien(maNV);
            } else {
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
                return;
            }
        }

        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống!");
            return;
        } else {
            nv.setHoTen(validate.chuanHoaTen(hoTen));
        }

        if (email.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
            return;
        } else {
            if (validate.check_email(email) == false) {
                JOptionPane.showMessageDialog(this, "Email nhập không đúng định dạng!");
                return;
            } else {
                nv.setEmail(email);
            }
        }

        String check_sdt = validate.check_sdt(sdt);
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
            return;
        } else {
            if (check_sdt.equals("corret")) {
                nv.setSoDienThoai(sdt);
            } else {
                JOptionPane.showMessageDialog(this, check_sdt);
                return;
            }
        }

        if (sdt.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải nhiều hơn 6 kí tự!");
        } else {
            nv.setMatKhau(validate.md5(matKhau));
        }

        nv.setGioiTinh(gioiTinh);
        nv.setNhom(nhom);
        nv.setTrangThai(trangThai);
        listNV.add(nv);
        saveFile();
        getData(listNV);
        JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
        reset();
    }//GEN-LAST:event_btn_themActionPerformed

    int index;
    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        // TODO add your handling code here:
        //Lấy dòng người dùng đang click
        int row = tbl_nhanvien.getSelectedRow();

        //Lấy mã nhân viên
        String manv = tbl_nhanvien.getValueAt(row, 0).toString();

        //duyệt list nhân viên để lấy ra thông tin nhân viên được chọn
        for (int i = 0; i < listNV.size(); i++) {
            if (manv.equals(listNV.get(i).getMaNhanVien())) {
                nv = listNV.get(i);
                index = i;
                break;
            }
        }

        btn_them.setEnabled(false);
        txt_maNhanVien.setEnabled(false);
        txt_matKhau.setEnabled(false);

        txt_maNhanVien.setText(nv.getMaNhanVien());
        txt_hoTen.setText(nv.getHoTen());
        txt_soDienThoai.setText(nv.getSoDienThoai());
        txt_email.setText(nv.getEmail());

        if (nv.getGioiTinh().equals("Nam")) {
            txt_gioiTinh.setSelectedItem("Nam");
        } else {
            txt_gioiTinh.setSelectedItem("Nữ");
        }

        if (nv.getNhom() == 1) {
            txt_nhom.setSelectedItem("Quản lý");
        } else {
            txt_nhom.setSelectedItem("Nhân viên");
        }

        if (nv.getTrangThai() == 1) {
            txt_trangThai.setSelectedItem("Hoạt động");
        } else {
            txt_trangThai.setSelectedItem("Đã khóa");
        }


    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không?", "Xóa", 2);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            if (listNV.remove(nv)) {
                saveFile();
                getData(listNV);
                reset();
                JOptionPane.showConfirmDialog(this, "Xóa thành công nhân viên " + nv.getHoTen());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
        frmMain main = new frmMain();
        main.setVisible(true);
    }//GEN-LAST:event_btn_thoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hello;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txt_email;
    private javax.swing.JComboBox<String> txt_gioiTinh;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maNhanVien;
    private javax.swing.JPasswordField txt_matKhau;
    private javax.swing.JComboBox<String> txt_nhom;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JComboBox<String> txt_trangThai;
    // End of variables declaration//GEN-END:variables
}
