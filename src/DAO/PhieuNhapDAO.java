/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.HangHoaDAO.cn;
import DataBase.ConnectDB;
import Model.ChiTietPhieuNhap;
import Model.HangHoa;
import Model.NhaCungCap;
import Model.PhieuNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class PhieuNhapDAO {
    public static ConnectDB cn = new ConnectDB();
  public List<PhieuNhap> getAll() {
        List<PhieuNhap> list = new ArrayList<>();
        try {
           Connection conn=cn.getConnection();
         String sql = "select * from Phieunhap,ChiTietPhieuNhap,NhaCungCap,HangHoa where Phieunhap.Mapn=ChiTietPhieuNhap.Mapn and ChiTietPhieuNhap.Mancc=NhaCungCap.Mancc and HangHoa.Mahh=ChiTietPhieuNhap.Mahh";
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getInt("Mancc"),rs.getString("Tenncc"),rs.getInt("Sdt"),rs.getString("Diachi"));
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(rs.getInt("Mahh"),rs.getInt("Mapn"),rs.getInt("mancc"),rs.getInt("Soluong"),rs.getDouble("Giatien"));
                HangHoa hh = new HangHoa(rs.getInt("Mahh"), rs.getString("Tenhh"), rs.getInt("Mancc"), rs.getInt("Soluongton"),ncc);
                list.add(new PhieuNhap(rs.getInt("Mapn"), rs.getDate("Ngaynhap"), rs.getInt("Manv"),ctpn,hh,ncc
                        ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
   public void Thempn(PhieuNhap pn) {
    String sql = "INSERT INTO PhieuNhap (Mapn,NgayNhap, Manv) "
            + "VALUES (?, ?, ?)";
          
    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, pn.getMapn());
        ps.setDate(2, (Date) pn.getNgaynhap());
        ps.setInt(3, pn.getManv());
     
      

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Them phieu nhap thanh cong.");
        } else {
            System.out.println("Them phieu nhap that bai.");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   public void Xoapn(int mapn) {
    String sql = "DELETE FROM PhieuNhap WHERE Mapn = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, mapn);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xoa phieu nhap thanh cong.");
        } else {
            System.out.println("Khong tim thay phieu nhap co ma: " + mapn);
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

   }
   public void Suapn(PhieuNhap pn) {
    String sql = "UPDATE PhieuNhap SET NgayNhap = ?, Manv = ? WHERE Mapn = ?";

    try {
        Connection conn = cn.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, pn.getNgaynhap());
        ps.setInt(2, pn.getManv());
        ps.setInt(3, pn.getMapn());
       

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sua thong tin hang hoa thanh cong.");
        } else {
            System.out.println("Khong tim thay hang hoa co ma: " + pn.getMapn());
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
   
}

