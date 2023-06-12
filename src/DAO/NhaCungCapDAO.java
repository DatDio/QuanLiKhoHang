/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.NhanVienDAO.cn;
import DataBase.ConnectDB;
import Model.NhanVien;
import Model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhaCungCapDAO {
    
 public static ConnectDB cn = new ConnectDB();
 //Lấy dữ liệu nhà cung cấp
  public List<NhaCungCap> getAll() {
        List<NhaCungCap> list = new ArrayList<>();
        try {
           Connection conn=cn.getConnection();
         String sql = "SELECT * FROM NhaCungCap";
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        
            while (rs.next()) {
                list.add(new NhaCungCap(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)
                        ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
   public void Themncc(NhaCungCap ncc) {
    String sql = "INSERT INTO NhaCungCap (Mancc, Tenncc, Sdt, Diachi) "
            + "VALUES (?, ?, ?, ?)";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ncc.getMancc());
        ps.setString(2, ncc.getTenncc());
        ps.setInt(3, ncc.getSdt());
        ps.setString(4, ncc.getDiachi());
     

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Thêm nha cung cap thành công.");
        } else {
            System.out.println("Thêm nha cung cap thất bại.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  public void Xoancc(int mancc) {
    String sql = "DELETE FROM NhaCungCap WHERE Mancc = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, mancc);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xóa nha cung cap thành công.");
        } else {
            System.out.println("Không tìm thấy nha cung cap có mã: " + mancc);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void Suanc(NhaCungCap ncc) {
    String sql = "UPDATE NhaCungCap SET Tenncc = ?, Sdt = ?, Diachi = ? WHERE Mancc = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ncc.getTenncc());
        ps.setInt(2, ncc.getSdt());
        ps.setString(3, ncc.getDiachi());
        ps.setInt(4, ncc.getMancc());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sửa thông tin nha cung cap thành công.");
        } else {
            System.out.println("Không tìm thấy nha cung cap có mã: " + ncc.getMancc());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

  
}
  

