/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.HoaDon;
import OBJ.KhachHang;
import OBJ.NhanVien;
import OBJ.SanPham;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Dao Ha
 */
public class frmBanHang extends javax.swing.JPanel {

    /**
     * Creates new form frmBanHang
     */
    private DefaultTableModel defaultTableModel;
    ArrayList<HoaDon> listGH = new ArrayList<>();
    ArrayList<HoaDon> listHD = new ArrayList<>();
    NumberFormat formatter = new DecimalFormat("###,###");
    KhachHang kh = new KhachHang();
    SanPham sp = new SanPham();
    int index;

    public frmBanHang() {
        initComponents();
        getDataKH(loadKH());
        getDataSP(loadSP());
        loadFile();
        btn_thanhToan.setEnabled(false);
        lbl_nhanVien.setText(frmDangNhap.userName);
    }

    public ArrayList<KhachHang> loadKH() {
        frmKhachHang frmKH = new frmKhachHang();
        frmKH.loadFile();
        return frmKH.listKH;
    }

    public ArrayList<SanPham> loadSP() {
        frmSanPham frmSP = new frmSanPham();
        frmSP.loadFile();
        return frmSP.listSP;
    }

    private void getDataKH(ArrayList<KhachHang> listKH) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã KH");
        defaultTableModel.addColumn("Tên KH");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SĐT");

        for (KhachHang khachHang : listKH) {
            Vector vt = new Vector();
            vt.add(khachHang.getMaKH());
            vt.add(khachHang.getTenKH());
            vt.add(khachHang.getEmail());
            vt.add(khachHang.getSdt());
            defaultTableModel.addRow(vt);
        }
        tbl_khachHang.setModel(defaultTableModel);
    }

    private void getDataSP(ArrayList<SanPham> listSP) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Đơn Vị Tính");
        defaultTableModel.addColumn("Tên NSX");
        defaultTableModel.addColumn("Số Lượng");
        defaultTableModel.addColumn("Giá Bán");

        for (SanPham sanPham : listSP) {
            Vector vt = new Vector();
            vt.add(sanPham.getMaSP());
            vt.add(sanPham.getTenSP());
            vt.add(sanPham.getDonViTinh());
            vt.add(sanPham.getTenNSX());
            vt.add(sanPham.getSoLuong());
            vt.add(sanPham.getGiaBan());
            defaultTableModel.addRow(vt);
        }
        tbl_sanPham.setModel(defaultTableModel);
    }

    public SanPham getSPByCode(String maSP) {
        ArrayList<SanPham> listSP = loadSP();
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSP())) {
                return listSP.get(i);
            }
        }
        return null;
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listHD = new ArrayList<>(); //lưu ý
            fr = new FileReader("hoadon.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    HoaDon hd = new HoaDon();
                    hd.setMaHD(arr[0]);
                    hd.setMaNV(arr[1]);
                    hd.setMaKH(arr[2]);
                    hd.setMaSP(arr[3]);
                    hd.setNgayBan(arr[4]);
                    hd.setDonGia(Double.parseDouble(arr[5]));
                    hd.setSoLuong(Integer.parseInt(arr[6]));
                    hd.setThanhTien(Double.parseDouble(arr[7]));
                    listHD.add(hd);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_nhanVien = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_khTimKiem = new javax.swing.JTextField();
        btn_khTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khachHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_spTimKiem = new javax.swing.JTextField();
        btn_spTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btn_themGH = new javax.swing.JButton();
        txt_spSoLuong = new javax.swing.JTextField();
        btn_thanhToan = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        btn_xoaGH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_maKH = new javax.swing.JLabel();
        lbl_hoTen = new javax.swing.JLabel();
        lbl_sdt = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_diaChi = new javax.swing.JLabel();
        lbl_tongTien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Zent Coding School");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu-icon.png"))); // NOI18N
        jLabel2.setText("HÓA ĐƠN BÁN HÀNG");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhân Viên:");

        lbl_nhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nhanVien.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(161, 161, 161)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1190, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setLayout(null);
        jPanel2.add(txt_khTimKiem);
        txt_khTimKiem.setBounds(76, 37, 235, 33);

        btn_khTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_khTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon (1).png"))); // NOI18N
        btn_khTimKiem.setText("Tìm Kiếm");
        btn_khTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btn_khTimKiem);
        btn_khTimKiem.setBounds(344, 37, 129, 33);

        tbl_khachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khachHang);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(19, 88, 552, 172);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 590, 280));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btn_spTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_spTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon (1).png"))); // NOI18N
        btn_spTimKiem.setText("Tìm Kiếm");
        btn_spTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_spTimKiemActionPerformed(evt);
            }
        });

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số Lượng:");

        btn_themGH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_themGH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket-icon.png"))); // NOI18N
        btn_themGH.setText("Thêm Vào Giỏ Hàng");
        btn_themGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themGHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(txt_spTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btn_spTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_spSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_themGH, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_spTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_spTimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_spSoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_themGH)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 590, 310));

        btn_thanhToan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash-icon.png"))); // NOI18N
        btn_thanhToan.setText("Thanh Toán");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });
        add(btn_thanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 610, 140, 35));

        btn_thoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alarm-Error-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 610, 130, 35));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mã KH:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sđt:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Giỏ Hàng:");

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_hoaDon);

        btn_xoaGH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoaGH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xkgh-icon.png"))); // NOI18N
        btn_xoaGH.setText("Xóa Khỏi Giỏ Hàng");
        btn_xoaGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaGHActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Họ và Tên:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Email:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tổng tiền:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("(VDN)");

        lbl_maKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_maKH.setForeground(new java.awt.Color(0, 0, 204));
        lbl_maKH.setText("...");

        lbl_hoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_hoTen.setForeground(new java.awt.Color(0, 0, 204));
        lbl_hoTen.setText("...");

        lbl_sdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sdt.setForeground(new java.awt.Color(0, 0, 204));
        lbl_sdt.setText("...");

        lbl_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(0, 0, 204));
        lbl_email.setText("...");

        lbl_diaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_diaChi.setForeground(new java.awt.Color(0, 0, 204));
        lbl_diaChi.setText("...");

        lbl_tongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_tongTien.setForeground(new java.awt.Color(204, 0, 0));
        lbl_tongTien.setText("...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_maKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_email, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel12))
                            .addComponent(btn_xoaGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_maKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(lbl_hoTen)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(lbl_sdt)
                    .addComponent(lbl_email))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_diaChi))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_xoaGH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbl_tongTien)
                    .addComponent(jLabel12))
                .addGap(64, 64, 64))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, 480));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/34.jpg"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_khTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khTimKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_khTimKiem.getText();
        if (tuKhoa == "") {
            getDataKH(loadKH());
        } else {
            ArrayList<KhachHang> listSearch = new ArrayList<>();
            for (int i = 0; i < loadKH().size(); i++) {
                if (loadKH().get(i).getMaKH().contains(tuKhoa) || loadKH().get(i).getTenKH().contains(tuKhoa) || loadKH().get(i).getEmail().contains(tuKhoa) || loadKH().get(i).getGioiTinh().contains(tuKhoa) || loadKH().get(i).getSdt().contains(tuKhoa) || loadKH().get(i).getDiaChi().contains(tuKhoa)) {
                    listSearch.add(loadKH().get(i));
                }
            }
            getDataKH(listSearch);
        }
    }//GEN-LAST:event_btn_khTimKiemActionPerformed

    private void btn_spTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spTimKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txt_spTimKiem.getText();
        if (tuKhoa == "") {
            getDataSP(loadSP());
        } else {
            ArrayList<SanPham> listSearch = new ArrayList<>();
            for (int i = 0; i < loadSP().size(); i++) {
                if (loadSP().get(i).getMaSP().contains(tuKhoa) || loadSP().get(i).getTenSP().contains(tuKhoa) || loadSP().get(i).getDonViTinh().contains(tuKhoa) || loadSP().get(i).getTenNSX().contains(tuKhoa) || loadSP().get(i).getGiaNhap().contains(tuKhoa) || loadSP().get(i).getGiaBan().contains(tuKhoa)) {
                    listSearch.add(loadSP().get(i));
                }
            }
            getDataSP(listSearch);
        }
    }//GEN-LAST:event_btn_spTimKiemActionPerformed

    private void tbl_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseClicked
        // TODO add your handling code here:
        int row = tbl_sanPham.getSelectedRow();
        String maSP = tbl_sanPham.getValueAt(row, 0).toString();
        for (int i = 0; i < loadSP().size(); i++) {
            if (loadSP().get(i).getMaSP().equals(maSP)) {
                sp = loadSP().get(i);
                index = i;
                break;
            }
        }
        txt_spSoLuong.setText("1");
    }//GEN-LAST:event_tbl_sanPhamMouseClicked

    double tongTien = 0;
    private void btn_themGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themGHActionPerformed
        // TODO add your handling code here:
        int soLuongMua = Integer.parseInt(txt_spSoLuong.getText());
        if (soLuongMua <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải >0");
        } else if (soLuongMua > Integer.parseInt(sp.getSoLuong())) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn số lượng trong giỏ hàng");
        } else {
            HoaDon hd = new HoaDon();
            hd.setMaSP(sp.getMaSP());
            hd.setSoLuong(soLuongMua);
            hd.setDonGia(Double.parseDouble(sp.getGiaBan()));
            hd.setThanhTien(soLuongMua * Double.parseDouble(sp.getGiaBan()));
            if (checkSPExistGH(hd.getMaSP(), listGH)) {
                HoaDon hoaDon = listGH.get(indexMaSPTrungTrongGioHang);
                hoaDon.setSoLuong(Integer.parseInt(txt_spSoLuong.getText()) + hoaDon.getSoLuong());
                hoaDon.setThanhTien(hoaDon.getSoLuong() * hd.getDonGia());
                listGH.set(indexMaSPTrungTrongGioHang, hoaDon);
            } else {
                listGH.add(hd);
            }
            loadGH(listGH);
            JOptionPane.showMessageDialog(this, "Thêm vào giỏ hàng thành công");
            tongTien = 0;
            for (int i = 0; i < listGH.size(); i++) {
                tongTien += listGH.get(i).getThanhTien();
            }
            lbl_tongTien.setText(formatter.format(tongTien));
        }
    }//GEN-LAST:event_btn_themGHActionPerformed

    int indexMaSPTrungTrongGioHang;

    public boolean checkSPExistGH(String maSP, ArrayList<HoaDon> listHD) {
        for (int i = 0; i < listHD.size(); i++) {
            if (maSP.equals(listHD.get(i).getMaSP())) {
                indexMaSPTrungTrongGioHang = i;
                return true;
            }
        }

        return false;
    }

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        // TODO add your handling code here:
        if (kh.getMaKH() == null || kh.getMaKH().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng trước!");
            return;
        } else {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            String maHD = kh.getMaKH() + "-" + sdf.format(date);
            for (int i = 0; i < listGH.size(); i++) {
                HoaDon hd = listGH.get(i);
                hd.setMaHD(maHD);
                hd.setMaKH(kh.getMaKH());
                hd.setMaNV(frmDangNhap.userName);
                hd.setNgayBan(sdf2.format(date));
                listGH.set(i, hd);
            }
            JTextField txtSoTien = new JTextField(10);

            JPanel myPanel = new JPanel();
            myPanel.add(Box.createHorizontalStrut(10));
            myPanel.add(new JLabel("Số tiền khách đưa: "));
            myPanel.add(txtSoTien);
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Số tiền khách thanh toán", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                double soTienKhachDua = Double.parseDouble(txtSoTien.getText());
                if (soTienKhachDua < tongTien) {
                    JOptionPane.showMessageDialog(this, "Số tiền khách trả chưa đủ !");
                    return;
                } else if (soTienKhachDua > tongTien) {
                    JOptionPane.showMessageDialog(this, "NV trả lại cho khách hàng " + (soTienKhachDua - tongTien));
                }
                saveFile();
                JOptionPane.showMessageDialog(this, "Thanh toán thành công !");
                frmSanPham frmSP = new frmSanPham();
                frmSP.loadFile();
                for (int i = 0; i < listGH.size(); i++) {
                    updateSoLuong(listGH.get(i).getMaSP(), listGH.get(i).getSoLuong(), frmSP.listSP);
                }
                frmSP.saveFile();
                listGH = new ArrayList<>();
                reset();
            }
        }

    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_xoaGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaGHActionPerformed
        // TODO add your handling code here:
        Double tienGiam;
        for (int i = 0; i < listGH.size(); i++) {
            if (maSP.equals(listGH.get(i).getMaSP())) {
                tienGiam = listGH.get(i).getThanhTien();
                listGH.remove(i);
                tongTien = tongTien - tienGiam;
                lbl_tongTien.setText(String.valueOf(tongTien));
            }
        }
        loadGH(listGH);
    }//GEN-LAST:event_btn_xoaGHActionPerformed

    String maSP;
    private void tbl_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoaDonMouseClicked
        // TODO add your handling code here:
        int row = tbl_hoaDon.getSelectedRow();
        maSP = tbl_hoaDon.getValueAt(row, 0).toString();
    }//GEN-LAST:event_tbl_hoaDonMouseClicked

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
        frmMain main = new frmMain();
        main.setVisible(true);
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void tbl_khachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachHangMouseClicked
        // TODO add your handling code here:
        int row = tbl_khachHang.getSelectedRow();
        String makh = tbl_khachHang.getValueAt(row, 0).toString();
        for (int i = 0; i < loadKH().size(); i++) {
            if (makh.equals(loadKH().get(i).getMaKH())) {
                kh = loadKH().get(i);
                index = i;
                break;
            }
        }

        lbl_maKH.setText(kh.getMaKH());
        lbl_hoTen.setText(kh.getTenKH());
        lbl_diaChi.setText(kh.getDiaChi());
        lbl_email.setText(kh.getEmail());
        lbl_sdt.setText(kh.getSdt());
    }//GEN-LAST:event_tbl_khachHangMouseClicked

    public void reset() {
        getDataKH(loadKH());
        getDataSP(loadSP());
        loadGH(listGH);
        lbl_diaChi.setText("...");
        lbl_email.setText("...");
        lbl_hoTen.setText("...");
        lbl_maKH.setText("...");
        lbl_sdt.setText("...");
        lbl_tongTien.setText("...");
        tongTien = 0;
    }

    public void saveFile() {
        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            listHD.addAll(listGH);
            for (int i = 0; i < listHD.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listHD.get(i).getMaHD() + "\t";
                row = row + listHD.get(i).getMaNV() + "\t";
                row = row + listHD.get(i).getMaKH() + "\t";
                row = row + listHD.get(i).getMaSP() + "\t";
                row = row + listHD.get(i).getNgayBan() + "\t";
                row = row + listHD.get(i).getDonGia() + "\t";
                row = row + listHD.get(i).getSoLuong() + "\t";
                row = row + listHD.get(i).getThanhTien() + "\n";
                data += row;
            }
            fw = new FileWriter("hoadon.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateSoLuong(String maSP, int soLuongMua, ArrayList<SanPham> listSP) {
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSP())) {
                SanPham sp = listSP.get(i);
                sp.setSoLuong(Integer.toString(Integer.parseInt(sp.getSoLuong()) - soLuongMua));
                listSP.set(i, sp);
            }
        }
    }

    public void loadGH(ArrayList<HoaDon> listHD) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Đơn Vị Tính");
        defaultTableModel.addColumn("Số Lượng");
        defaultTableModel.addColumn("Đơn Giá");
        defaultTableModel.addColumn("Thành Tiền");

        for (HoaDon obj : listHD) {
            SanPham sp = new frmBanHang().getSPByCode(obj.getMaSP());
            Vector vt = new Vector();
            vt.add(obj.getMaSP());
            vt.add(sp.getTenSP());
            vt.add(sp.getDonViTinh());
            vt.add(formatter.format(obj.getSoLuong()));
            vt.add(formatter.format(obj.getDonGia()));
            vt.add(formatter.format(obj.getThanhTien()));
            defaultTableModel.addRow(vt);
        }
        tbl_hoaDon.setModel(defaultTableModel);
        if (listHD.size() > 0) {
            btn_thanhToan.setEnabled(true);
        } else {
            btn_thanhToan.setEnabled(false);
        }
    }

    public String timKiemTenSPTheoMaSP(String maSP) {
        for (int i = 0; i < loadSP().size(); i++) {
            if (maSP.equals(loadSP().get(i).getMaSP())) {
                return loadSP().get(i).getTenSP();
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_khTimKiem;
    private javax.swing.JButton btn_spTimKiem;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.JButton btn_themGH;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoaGH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_diaChi;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_hoTen;
    private javax.swing.JLabel lbl_maKH;
    private javax.swing.JLabel lbl_nhanVien;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_tongTien;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTable tbl_khachHang;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTextField txt_khTimKiem;
    private javax.swing.JTextField txt_spSoLuong;
    private javax.swing.JTextField txt_spTimKiem;
    // End of variables declaration//GEN-END:variables
}
