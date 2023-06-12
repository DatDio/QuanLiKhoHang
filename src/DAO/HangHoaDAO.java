/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.NhanVienDAO.cn;
import DataBase.ConnectDB;
import Model.NhanVien;
import Model.HangHoa;
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
public class HangHoaDAO {
      public static ConnectDB cn = new ConnectDB();
  public List<HangHoa> getAll() {
        List<HangHoa> list = new ArrayList<>();
        try {
           Connection conn=cn.getConnection();
         String sql = "SELECT * FROM HangHoa,NhaCungCap where HangHoa.Mancc = NhaCungCap.Mancc";
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getInt("Mancc"),rs.getString("Tenncc"),rs.getInt("Sdt"),rs.getString("Diachi"));
                list.add(new HangHoa(rs.getInt("Mahh"), rs.getString("Tenhh"), rs.getInt("Mancc"), rs.getInt("Soluongton"),ncc
                        ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
 public void Themhh(HangHoa hh) {
    String sql = "INSERT INTO HangHoa (Mahh, Tenhh, Mancc, Soluongton) "
            + "VALUES (?, ?, ?, '')";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, hh.getMahh());
        ps.setString(2, hh.getTenhh());
        ps.setInt(3, hh.getMancc());
        

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Thêm Hang Hoa thành công.");
        } else {
            System.out.println("Thêm Hang Hoa thất bại.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  public void Xoahh(int mahh) {
    String sql = "DELETE FROM HangHoa WHERE Mahh = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, mahh);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xóa Hang Hoa thành công.");
        } else {
            System.out.println("Không tìm thấy Hang Hoa có mã: " + mahh);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  public void Suahh(HangHoa hh) {
    String sql = "UPDATE HangHoa SET Tenhh = ?, Mancc = ? WHERE Mahh = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, hh.getTenhh());
        ps.setInt(2, hh.getMancc());
        ps.setInt(3, hh.getMahh());
       

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sua thong tin hang hoa thanh cong.");
        } else {
            System.out.println("Khong tim thay hang hoa co ma: " + hh.getMahh());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

  
  public void UpdateSoLuongHangTonKho(){
           try {
            Connection conn = cn.getConnection();
           
            String sql="UPDATE HangHoa\n" +
"SET Soluongton = (\n" +
"    SELECT COALESCE(\n" +
"        (SELECT SUM(Soluong) FROM ChiTietPhieuNhap WHERE ChiTietPhieuNhap.Mahh = HangHoa.mahh), 0\n" +
"    ) - \n" +
"    COALESCE(\n" +
"        (SELECT SUM(Soluong) FROM ChiTietPhieuXuat WHERE ChiTietPhieuXuat.Mahh = HangHoa.Mahh), 0\n" +
"    )\n" +
")";
            PreparedStatement ps =conn.prepareStatement(sql);
               ps.executeUpdate();
               
        } catch (Exception e) {
            e.printStackTrace();
        }
       }
  
}
