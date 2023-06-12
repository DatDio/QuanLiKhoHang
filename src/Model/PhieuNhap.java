/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class PhieuNhap {
   private int Mapn;
   private Date Ngaynhap;
   private int Manv;
  
   private ChiTietPhieuNhap ctpn;
   private HangHoa hh;
   private NhaCungCap ncc;

    public PhieuNhap() {
    }

    public PhieuNhap(int Mapn, Date Ngaynhap, int Manv, ChiTietPhieuNhap ctpn, HangHoa hh, NhaCungCap ncc) {
        this.Mapn = Mapn;
        this.Ngaynhap = Ngaynhap;
        this.Manv = Manv;
        this.ctpn = ctpn;
        this.hh = hh;
        this.ncc = ncc;
    }

    public int getMapn() {
        return Mapn;
    }

    public void setMapn(int Mapn) {
        this.Mapn = Mapn;
    }

    public Date getNgaynhap() {
        return Ngaynhap;
    }

    public void setNgaynhap(Date Ngaynhap) {
        this.Ngaynhap = Ngaynhap;
    }

    public int getManv() {
        return Manv;
    }

    public void setManv(int Manv) {
        this.Manv = Manv;
    }

    public ChiTietPhieuNhap getCtpn() {
        return ctpn;
    }

    public void setCtpn(ChiTietPhieuNhap ctpn) {
        this.ctpn = ctpn;
    }

    public HangHoa getHh() {
        return hh;
    }

    public void setHh(HangHoa hh) {
        this.hh = hh;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

   

   
}
