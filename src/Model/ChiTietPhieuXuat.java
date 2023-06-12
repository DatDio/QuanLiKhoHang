/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class ChiTietPhieuXuat {
    private int Mahh;
    private int Mapx;
    private int Soluong;
    private double Giatien;

    public ChiTietPhieuXuat() {
    }

    public ChiTietPhieuXuat(int Mahh, int Mapx, int Soluong, double Giatien) {
        this.Mahh = Mahh;
        this.Mapx = Mapx;
        this.Soluong = Soluong;
        this.Giatien = Giatien;
    }

    public int getMahh() {
        return Mahh;
    }

    public void setMahh(int Mahh) {
        this.Mahh = Mahh;
    }

    public int getMapx() {
        return Mapx;
    }

    public void setMapx(int Mapx) {
        this.Mapx = Mapx;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public double getGiatien() {
        return Giatien;
    }

    public void setGiatien(double Giatien) {
        this.Giatien = Giatien;
    }
    
}
