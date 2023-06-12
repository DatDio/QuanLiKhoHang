/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.PhieuNhapDAO.cn;
import DataBase.ConnectDB;
import Model.ChiTietPhieuXuat;
import Model.HangHoa;
import Model.NhaCungCap;
import Model.NhanVien;
import Model.PhieuNhap;
import Model.PhieuXuat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class PhieuXuatDAO {
     public static ConnectDB cn = new ConnectDB();
  public List<PhieuXuat> getAll() {
        List<PhieuXuat> list = new ArrayList<>();
        try {
           Connection conn=cn.getConnection();
         String sql = "select * from PhieuXuat,ChiTietPhieuXuat,NhanVien,HangHoa where PhieuXuat.Mapx=ChiTietPhieuXuat.Mapx and PhieuXuat.Manv=NhanVien.Manv and HangHoa.Mahh=ChiTietPhieuXuat.Mahh ";
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        
            while (rs.next()) {
                 
                
               
                list.add(new PhieuXuat(rs.getInt("Mapx"), 
                        rs.getDate("Ngayxuat"), 
                        rs.getInt("Manv"),
                        new ChiTietPhieuXuat(rs.getInt("Mahh"),
                                rs.getInt("Mapx"),rs.getInt("Soluong"),rs.getDouble("Giatien")),
                new NhanVien(
                        rs.getInt("Manv"),
                        rs.getString("Hoten"),rs.getInt("Sdt"),
                        rs.getString("Diachi"),rs.getString("Matkhau")),
                        new HangHoa(rs.getInt("Mahh"), 
                                rs.getString("Tenhh"), rs.getInt("Mancc"), rs.getInt("Soluongton"),
                                new NhaCungCap()
                                        
                        )));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
  public void Thempx(PhieuXuat px) {
    String sql = "INSERT INTO PhieuXuat (Mapx,NgayXuat, Manv) "
            + "VALUES (?, ?, ?)";
          
    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, px.getMapx());
        ps.setDate(2, (Date) px.getNgayxuat());
        ps.setInt(3, px.getManv());
     
      

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Them phieu xuat thanh cong.");
        } else {
            System.out.println("Them phieu xuat that bai.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
   public void Xoapx(int mapx) {
    String sql = "DELETE FROM PhieuXuat WHERE Mapx = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, mapx);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xoa phieu xuat thanh cong.");
        } else {
            System.out.println("Khong tim thay phieu xuat co ma: " + mapx);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

   }
   public void Suapx(PhieuXuat px) {
    String sql = "UPDATE PhieuXuat SET NgayXuat = ?, Manv = ? WHERE Mapx = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, (Date) px.getNgayxuat());
        ps.setInt(2, px.getManv());
        ps.setInt(3, px.getMapx());
       

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sua thong tin phieu xuat thanh cong.");
        } else {
            System.out.println("Khong tim thay hang hoa co ma: " + px.getMapx());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
