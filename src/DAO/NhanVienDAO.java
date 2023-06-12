/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.NhanVien;
import View.Home;
import DataBase.ConnectDB;
import java.security.interfaces.RSAKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    public static ConnectDB cn = new ConnectDB();
  public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try {
           Connection conn=cn.getConnection();
         String sql = "SELECT * FROM NHANVIEN";
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        
            while (rs.next()) {
                list.add(new NhanVien(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
  public void Themnv(NhanVien nv) {
    String sql = "INSERT INTO NhanVien (Manv, Hoten, Sdt, Diachi, Matkhau) "
            + "VALUES (?, ?, ?, ?, ?)";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, nv.getManv());
        ps.setString(2, nv.getHoten());
        ps.setInt(3, nv.getSdt());
        ps.setString(4, nv.getDiachi());
        ps.setString(5, nv.getMatkhau());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Thêm nhân viên thành công.");
        } else {
            System.out.println("Thêm nhân viên thất bại.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  public void Xoanv(int manv) {
    String sql = "DELETE FROM NhanVien WHERE Manv = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, manv);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xóa nhân viên thành công.");
        } else {
            System.out.println("Không tìm thấy nhân viên có mã: " + manv);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void Suanv(NhanVien nv) {
    String sql = "UPDATE NhanVien SET Hoten = ?, Sdt = ?, Diachi = ?, Matkhau = ? WHERE Manv = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nv.getHoten());
        ps.setInt(2, nv.getSdt());
        ps.setString(3, nv.getDiachi());
        ps.setString(4, nv.getMatkhau());
        ps.setInt(5, nv.getManv());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sửa thông tin nhân viên thành công.");
        } else {
            System.out.println("Không tìm thấy nhân viên có mã: " + nv.getManv());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}


    

