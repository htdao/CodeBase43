/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.SanPham;
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
public class frmSanPham extends javax.swing.JPanel {

    /**
     * Creates new form frmSanPham
     */
    private DefaultTableModel defaultTableModel;
    SanPham sp = new SanPham();
    ValidateData validate = new ValidateData();
    ArrayList<SanPham> listSP = new ArrayList<>();

    public frmSanPham() {
        initComponents();
        loadFile();
        getData(listSP);
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSP = new ArrayList<>();
            fr = new FileReader("sanpham.txt");
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    String arr[] = s.split("\t");
                    SanPham sp = new SanPham();
                    sp.setMaSP(arr[0]);
                    sp.setTenSP(arr[1]);
                    sp.setDonViTinh(arr[2]);
                    sp.setTenNSX(arr[3]);
                    sp.setGiaNhap(arr[4]);
                    sp.setGiaBan(arr[5]);
                    sp.setSoLuong(arr[6]);
                    listSP.add(sp);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

    }

    private void getData(ArrayList<SanPham> listSP) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Đơn Vị Tính");
        defaultTableModel.addColumn("Tên NSX");
        defaultTableModel.addColumn("Giá Nhập");
        defaultTableModel.addColumn("Giá Bán");
        defaultTableModel.addColumn("Số Lượng");

        for (SanPham sanPham : listSP) {
            Vector vt = new Vector();
            vt.add(sanPham.getMaSP());
            vt.add(sanPham.getTenSP());
            vt.add(sanPham.getDonViTinh());
            vt.add(sanPham.getTenNSX());
            vt.add(sanPham.getGiaNhap());
            vt.add(sanPham.getGiaBan());
            vt.add(sanPham.getSoLuong());
            defaultTableModel.addRow(vt);
        }
        tbl_sanPham.setModel(defaultTableModel);
    }

    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listSP.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listSP.get(i).getMaSP() + "\t";
                row = row + listSP.get(i).getTenSP() + "\t";
                row = row + listSP.get(i).getDonViTinh() + "\t";
                row = row + listSP.get(i).getTenNSX() + "\t";
                row = row + listSP.get(i).getGiaNhap() + "\t";
                row = row + listSP.get(i).getGiaBan() + "\t";
                row = row + listSP.get(i).getSoLuong() + "\n";
                data += row;
            }
            fw = new FileWriter("sanpham.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reset() {
        txt_maSP.setText("");
        txt_maSP.setEnabled(true);
        txt_tenSP.setText("");
        txt_donViTinh.setText("");
        txt_tenNSX.setText("");
        txt_giaNhap.setText("");
        txt_giaBan.setText("");
        txt_soLuong.setText("");
        btn_sua.setEnabled(true);
        btn_them.setEnabled(true);
        btn_xoa.setEnabled(true);
        getData(listSP);
    }

    public boolean check_maSP(String maSP) {
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSP())) {
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
        jTable1 = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_timKiem = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_maSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tenSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_donViTinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_tenNSX = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-add-icon.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 101, 40));

        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Files-Edit-file-icon.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 101, 40));

        btn_xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-icon.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 101, 40));

        btn_thoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alarm-Error-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 310, 101, 40));

        tbl_sanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sanPham);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 1060, 270));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Zent Coding School");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(275, 275, 275))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon (1).png"))); // NOI18N
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_timKiem)
                    .addComponent(btn_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Mã SP");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Tên SP");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Đơn Vị Tính");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Tên NSX");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Giá Nhập");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setText("Giá Bán");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Số lượng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_maSP)
                    .addComponent(txt_donViTinh)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(txt_soLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tenSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenNSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_donViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 120, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/25.jpg"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1170, 660));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_timKiem.getText();
        if (tuKhoa == "") {
            getData(listSP);
        } else {
            ArrayList<SanPham> listSearch = new ArrayList<>();
            for (int i = 0; i < listSP.size(); i++) {
                if (listSP.get(i).getMaSP().contains(tuKhoa) || listSP.get(i).getTenSP().contains(tuKhoa) || listSP.get(i).getDonViTinh().contains(tuKhoa) || listSP.get(i).getTenNSX().contains(tuKhoa) || listSP.get(i).getGiaNhap().contains(tuKhoa) || listSP.get(i).getGiaBan().contains(tuKhoa)) {
                    listSearch.add(listSP.get(i));
                }
            }
            getData(listSearch);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        SanPham sp = new SanPham();
        String maSP = txt_maSP.getText();
        String tenSP = txt_tenSP.getText();
        String dvt = txt_donViTinh.getText();
        String tenNSX = txt_tenNSX.getText();
        String giaNhap = txt_giaNhap.getText();
        String giaBan = txt_giaBan.getText();
        String soLuong = txt_soLuong.getText();

        if (maSP.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống!");
            return;
        } else {
            if (check_maSP(maSP) == false) {
                sp.setMaSP(maSP);
            } else {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!");
                return;
            }
        }

        if (tenSP.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!");
            return;
        } else {
            sp.setTenSP(tenSP);
        }

        if (dvt.equals("")) {
            JOptionPane.showMessageDialog(this, "Đơn vị tính không được để trống!");
            return;
        } else {
            sp.setDonViTinh(dvt);
        }

        if (tenNSX.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhà sản xuất không được để trống!");
            return;
        } else {
            sp.setTenNSX(tenNSX);
        }

        if (giaNhap.equals("")) {
            JOptionPane.showMessageDialog(this, "Gía nhập không được để trống!");
            return;
        } else {
            sp.setGiaNhap(giaNhap);
        }

        if (giaBan.equals("")) {
            JOptionPane.showMessageDialog(this, "Gía bán không được để trống!");
            return;
        } else {
            sp.setGiaBan(giaBan);
        }

        if (soLuong.equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống!");
            return;
        } else {
            sp.setSoLuong(soLuong);
        }

        listSP.add(sp);
        saveFile();
        getData(listSP);
        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
        reset();
    }//GEN-LAST:event_btn_themActionPerformed

    int index;
    private void tbl_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseClicked
        // TODO add your handling code here:
        int row = tbl_sanPham.getSelectedRow();
        String masp = tbl_sanPham.getValueAt(row, 0).toString();
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getMaSP().equals(masp)) {
                sp = listSP.get(i);
                index = i;
                break;
            }
        }
        txt_maSP.setEnabled(false);
        btn_them.setEnabled(false);

        txt_maSP.setText(sp.getMaSP());
        txt_donViTinh.setText(sp.getDonViTinh());
        txt_giaBan.setText(sp.getGiaBan());
        txt_giaNhap.setText(sp.getGiaNhap());
        txt_soLuong.setText(sp.getSoLuong());
        txt_tenNSX.setText(sp.getTenNSX());
        txt_tenSP.setText(sp.getTenSP());

    }//GEN-LAST:event_tbl_sanPhamMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int dem = 0;

        String tenSP = txt_tenSP.getText();
        String dvt = txt_donViTinh.getText();
        String tenNSX = txt_tenNSX.getText();
        String giaNhap = txt_giaNhap.getText();
        String giaBan = txt_giaBan.getText();
        String soLuong = txt_soLuong.getText();

        if (tenSP.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!");
            dem++;
            return;
        } else {
            sp.setTenSP(tenSP);
        }

        if (dvt.equals("")) {
            JOptionPane.showMessageDialog(this, "Đơn vị tính không được để trống!");
            dem++;
            return;
        } else {
            sp.setDonViTinh(dvt);
        }

        if (tenNSX.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhà sản xuất không được để trống!");
            dem++;
            return;
        } else {
            sp.setTenNSX(tenNSX);
        }

        if (giaNhap.equals("")) {
            JOptionPane.showMessageDialog(this, "Gía nhập không được để trống!");
            dem++;
            return;
        } else {
            sp.setGiaNhap(giaNhap);
        }

        if (giaBan.equals("")) {
            JOptionPane.showMessageDialog(this, "Gía bán không được để trống!");
            dem++;
            return;
        } else {
            sp.setGiaBan(giaBan);
        }

        if (soLuong.equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống!");
            dem++;
            return;
        } else {
            sp.setSoLuong(soLuong);
        }

        if (dem == 0) {
            listSP.set(index, sp);
            saveFile();
            getData(listSP);
            JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công!");
            reset();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không?", "Xóa", 2);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            if (listSP.remove(sp)) {
                saveFile();
                getData(listSP);
                reset();
                JOptionPane.showConfirmDialog(this, "Xóa thành công sản phẩm " + sp.getTenSP());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại");
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTextField txt_donViTinh;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_maSP;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenNSX;
    private javax.swing.JTextField txt_tenSP;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
