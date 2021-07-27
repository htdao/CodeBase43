/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.DoanhThu;
import OBJ.NhanVien;
import OBJ.SanPham;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dao Ha
 */
public class frmThongKeTheoNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form frmThongKeTheoNhanVien
     */
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    ArrayList<DoanhThu> listDT = new ArrayList<>();
    ArrayList<DoanhThu> listTK = new ArrayList<>();
    public frmThongKeTheoNhanVien() {
        initComponents();
        loadFile();
        System.out.println(listDT);
        thongKe();
        getData(listDT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listDT = new ArrayList<>();
            fr = new FileReader("hoadon.txt");
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    String arr[] = s.split("\t");
                    DoanhThu dt = new DoanhThu();
                    dt.setMaNV(arr[1]);
                    for (NhanVien nv : new frmNhanVien().getListNV()) {
                        if(arr[1].equals(nv.getMaNhanVien())){
                            dt.setTenNV(nv.getHoTen());
                            break;
                        }
                    }
                    dt.setSoLuong(arr[6]);
                    dt.setTongTien(arr[7]);
                    listDT.add(dt);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
    
    private void getData(ArrayList<DoanhThu> listTK) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Tên NV");
        defaultTableModel.addColumn("Tổng Doanh Số");
        defaultTableModel.addColumn("Tổng Doanh Thu");

        for (DoanhThu doanhThu: listTK) {
            Vector vt = new Vector();
            vt.add(doanhThu.getMaNV());
            vt.add(doanhThu.getTenNV());
            vt.add(doanhThu.getSoLuong());
            vt.add(doanhThu.getTongTien());
            defaultTableModel.addRow(vt);
        }
        tbl_thongKe.setModel(defaultTableModel);
    }
    
    private void thongKe(){
        listTK.clear();
        for (int i = 0; i < listDT.size(); i++) {
            boolean daTonTai = false;
            for (int j = 0; j < listTK.size(); j++) {
                if(listDT.get(i).getMaNV().equals(listTK.get(j).getMaNV())){
                    daTonTai = true;
                    break;
                }
            }
            if (daTonTai) {
                for (int j = 0; j < listTK.size(); j++) {
                   if(listDT.get(i).getMaNV().equals(listTK.get(j).getMaNV())){
                       int slc = Integer.parseInt(listTK.get(j).getSoLuong());
                       int slm = Integer.parseInt(listDT.get(i).getSoLuong());
                       double ttc = Double.parseDouble(listTK.get(j).getTongTien());
                       double ttm = Double.parseDouble(listDT.get(i).getTongTien());
                       listTK.get(j).setSoLuong(slc+slm+"");
                       listTK.get(j).setTongTien(ttc+ttm+"");
                       break;
                   } 
                }
            }else{
                listTK.add(new DoanhThu(listDT.get(i).getMaNV(), listDT.get(i).getTenNV(), listDT.get(i).getSoLuong(), listDT.get(i).getTongTien()));
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        btn_thongKe = new javax.swing.JButton();
        btn_TKDTMax = new javax.swing.JButton();
        btn_TKDTMin = new javax.swing.JButton();
        btn_TKAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongKe = new javax.swing.JTable();
        btn_thoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Zent Coding School");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("THỐNG KÊ THEO NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(169, 169, 169))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã NV:");

        txt_maNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maNVActionPerformed(evt);
            }
        });

        btn_thongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart-icon.png"))); // NOI18N
        btn_thongKe.setText("Thống Kê");
        btn_thongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txt_maNV, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thongKe))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 139, -1, -1));

        btn_TKDTMax.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_TKDTMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart-icon.png"))); // NOI18N
        btn_TKDTMax.setText("Nhân Viên Có Doanh Thu Cao Nhất");
        btn_TKDTMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TKDTMaxActionPerformed(evt);
            }
        });
        add(btn_TKDTMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 460, -1));

        btn_TKDTMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_TKDTMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart-icon.png"))); // NOI18N
        btn_TKDTMin.setText("Nhân Viên Có Doanh Thu Thấp Nhất");
        btn_TKDTMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TKDTMinActionPerformed(evt);
            }
        });
        add(btn_TKDTMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 460, -1));

        btn_TKAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_TKAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill_icon.png"))); // NOI18N
        btn_TKAll.setText("Thống Kê Tổng Doanh Thu Của Các Nhân Viên");
        btn_TKAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TKAllActionPerformed(evt);
            }
        });
        add(btn_TKAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 460, -1));

        tbl_thongKe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_thongKe);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 322, 1058, 340));

        btn_thoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alarm-Error-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(958, 680, 154, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/34.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1170, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maNVActionPerformed

    private void btn_TKDTMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TKDTMinActionPerformed
        // TODO add your handling code here:
        double ttMin = Double.parseDouble(listTK.get(0).getTongTien());
        int vt=0;
        for (int i = 1; i < listTK.size(); i++) {
            if(ttMin > Double.parseDouble(listTK.get(i).getTongTien())){
                ttMin = Double.parseDouble(listTK.get(i).getTongTien());
                vt=i;
            }
        }
        JOptionPane.showMessageDialog(this, "Nhân viên có doanh thu thấp nhất: \n"
                +listTK.get(vt).getTenNV()
                +"\nTổng doanh thu: "+ttMin);
    }//GEN-LAST:event_btn_TKDTMinActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
        frmMain main = new frmMain();
        main.setVisible(true);
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void btn_TKDTMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TKDTMaxActionPerformed
        // TODO add your handling code here:
        double ttMax = Double.parseDouble(listTK.get(0).getTongTien());
        int vt=0;
        for (int i = 1; i < listTK.size(); i++) {
            if(ttMax < Double.parseDouble(listTK.get(i).getTongTien())){
                ttMax = Double.parseDouble(listTK.get(i).getTongTien());
                vt=i;
            }
        }
        JOptionPane.showMessageDialog(this, "Nhân viên có doanh thu cao nhất: \n"
                +listTK.get(vt).getTenNV()
                +"\nTổng doanh thu: "+ttMax);
    }//GEN-LAST:event_btn_TKDTMaxActionPerformed

    private void btn_TKAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TKAllActionPerformed
        // TODO add your handling code here:
        getData(listTK);
    }//GEN-LAST:event_btn_TKAllActionPerformed

    private void btn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeActionPerformed
        // TODO add your handling code here:
        ArrayList<DoanhThu> list = new ArrayList<>();
        String maNV = txt_maNV.getText();
        for (int i = 0; i < listDT.size(); i++) {
            if(maNV.equals(listDT.get(i).getMaNV())){
                list.add(listDT.get(i));
            }
        }
        getData(list);
    }//GEN-LAST:event_btn_thongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TKAll;
    private javax.swing.JButton btn_TKDTMax;
    private javax.swing.JButton btn_TKDTMin;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_thongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_thongKe;
    private javax.swing.JTextField txt_maNV;
    // End of variables declaration//GEN-END:variables
}