/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class PhieuXuat {
    private int Mapx;
    private Date Ngayxuat;
    private int Manv;
    private ChiTietPhieuXuat ctpx;
    private NhanVien nv;
    private HangHoa hh;


    public PhieuXuat() {
    }

    public PhieuXuat(int Mapx, Date Ngayxuat, int Manv, ChiTietPhieuXuat ctpx, NhanVien nv, HangHoa hh) {
        this.Mapx = Mapx;
        this.Ngayxuat = Ngayxuat;
        this.Manv = Manv;
        this.ctpx = ctpx;
        this.nv = nv;
        this.hh = hh;
    }

    public int getMapx() {
        return Mapx;
    }

    public void setMapx(int Mapx) {
        this.Mapx = Mapx;
    }

    public Date getNgayxuat() {
        return Ngayxuat;
    }

    public void setNgayxuat(Date Ngayxuat) {
        this.Ngayxuat = Ngayxuat;
    }

    public int getManv() {
        return Manv;
    }

    public void setManv(int Manv) {
        this.Manv = Manv;
    }

    public ChiTietPhieuXuat getCtpx() {
        return ctpx;
    }

    public void setCtpx(ChiTietPhieuXuat ctpx) {
        this.ctpx = ctpx;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public HangHoa getHh() {
        return hh;
    }

    public void setHh(HangHoa hh) {
        this.hh = hh;
    }

    

    
    
}
