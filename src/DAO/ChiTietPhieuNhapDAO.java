/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.PhieuNhapDAO.cn;
import Model.ChiTietPhieuNhap;
import Model.PhieuNhap;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ChiTietPhieuNhapDAO {
    public void Themctpn(ChiTietPhieuNhap ctpn) {
    String sql = "INSERT INTO ChiTietPhieuNhap (Mahh,Mapn,Mancc, Soluong, Giatien)"
            +"VALUES (?, ?, ?, ?,?)";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ctpn.getMahh());
        ps.setInt(2,  ctpn.getMapn());
        ps.setInt(3,  ctpn.getMancc());
        ps.setInt(4, ctpn.getSoluong());
        ps.setDouble(5,ctpn.getGiatien());
      

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Them chi tiet phieu nhap thanh cong.");
        } else {
            System.out.println("Them chi tiet phieu nhap that bai.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void Xoactpn(int mapn) {
    String sql = "DELETE FROM ChiTietPhieuNhap WHERE Mapn = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, mapn);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xoa chi tiet phieu nhap thanh cong.");
        } else {
            System.out.println("Khong tim thay chi tiet phieu nhap co ma: " + mapn);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

   }
    
    public void Suactpn(ChiTietPhieuNhap ctpn) {
    String sql = "UPDATE ChiTietPhieuNhap SET Mahh = ?, Mancc=?, SoLuong=?, Giatien=? WHERE Mapn = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ctpn.getMahh());
        ps.setInt(2, ctpn.getMancc());
        ps.setInt(3, ctpn.getSoluong());
        ps.setDouble(4, ctpn.getGiatien());
        ps.setInt(5,ctpn.getMapn());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sua thong tin chi tiet phieu nhap  thanh cong.");
        } else {
            System.out.println("Khong tim thay chi tiet phieu nhap co ma: " + ctpn.getMapn());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
