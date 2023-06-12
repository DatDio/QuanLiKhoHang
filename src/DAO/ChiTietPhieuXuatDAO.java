/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.PhieuNhapDAO.cn;
import Model.ChiTietPhieuNhap;
import Model.ChiTietPhieuXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ChiTietPhieuXuatDAO {
     public void Themctpx(ChiTietPhieuXuat ctpx) {
    String sql = "INSERT INTO ChiTietPhieuXuat (Mahh,Mapx, Soluong, Giatien)"
            +"VALUES (?, ?, ?, ?)";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ctpx.getMahh());
        ps.setInt(2,  ctpx.getMapx());
        ps.setInt(3, ctpx.getSoluong());
        ps.setDouble(4,ctpx.getGiatien());
      

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Them chi tiet phieu xuat thanh cong.");
        } else {
            System.out.println("Them chi tiet phieu xuat that bai.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void Xoactpx(int mapx) {
    String sql = "DELETE FROM ChiTietPhieuXuat WHERE Mapx = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, mapx);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xoa chi tiet phieu xuat thanh cong.");
        } else {
            System.out.println("Khong tim thay chi tiet phieu xuat co ma: " + mapx);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

   }
    
    public void Suactpx(ChiTietPhieuXuat ctpx) {
    String sql = "UPDATE ChiTietPhieuXuat SET Mahh = ?,  SoLuong=?, Giatien=? WHERE Mapx = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ctpx.getMahh());
      
        ps.setInt(2, ctpx.getSoluong());
        ps.setDouble(3, ctpx.getGiatien());
        ps.setInt(4,ctpx.getMapx());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sua thong tin chi tiet phieu xuat  thanh cong.");
        } else {
            System.out.println("Khong tim thay chi tiet phieu xuat co ma: " + ctpx.getMapx());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
