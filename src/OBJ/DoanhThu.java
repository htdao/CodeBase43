/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJ;

/**
 *
 * @author Dao Ha
 */
public class DoanhThu {
    private String maNV;
    private String tenNV;
    private String soLuong;
    private String tongTien;

    public DoanhThu() {
    }

    public DoanhThu(String maNV, String tenNV, String soLuong, String tongTien) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
