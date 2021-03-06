/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dao Ha
 */
public class ValidateData {

    public static String md5(String str) {
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean check_email(String email) {
        String dinhDangEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean ktEmail = email.matches(dinhDangEmail);
        return ktEmail;
        // String dinhDangEmail nó giống như là format chuẩn cho email mình nhập vào, nếu sai cái
        // dịnh dạng này thì là lỗi.
        // Hàm matches dùng để xác định xem chuỗi email của mình có khớp với định dạng mình đã quy 
        // định trước hay không. hàm này trả về true , false nên mình khởi tạo 1 biến ktEmail rồi gán
        // cho nó. false thì báo lỗi.
    }

    public String check_sdt(String sdt) {
        sdt = sdt.trim();
        sdt = sdt.replace(".", "");
        sdt = sdt.replace(",", "");
        sdt = sdt.replace(" ", "");
        sdt = sdt.replaceAll("\\s+", "");
        try {
            if (!sdt.startsWith(0 + "")) {
                return "Số điện thoại phải bắt đầu bằng 0!";
            } else if (sdt.length() != 10) {
                return "Số điện thoại phải có 10 chữ số!";
            }
            long sdt_long = Long.parseLong(sdt);
        } catch (NumberFormatException ex) {
            return "Số điện thoại không được chứa chữ cái!";
        } catch (Exception ex) {
            return "Fail" + ex.getMessage();
        }
        return "corret";
    }

    public String chuanHoaTen(String hoTen) {
        String tg = "";
        hoTen = hoTen.toLowerCase();
        hoTen = hoTen.trim();
        String[] arr = hoTen.split(" ");
        for (String s : arr) {
            if (!hoTen.equals("") && !hoTen.equals(null)) {
                tg += String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1) + " ";
            }
        }
        return tg.substring(0, tg.length() - 1);
    }
}
