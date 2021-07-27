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
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String email;
    private String gioiTinh;
    private String sdt;
    private int trangThai;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String email, String gioiTinh, String sdt, int trangThai, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
}
