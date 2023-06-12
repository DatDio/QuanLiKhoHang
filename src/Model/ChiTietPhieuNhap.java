/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class ChiTietPhieuNhap {
    private int Mahh;
    private int Mapn;
    private int Mancc;
    private int Soluong;
    private double Giatien;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(int Mahh, int Mapn, int Mancc, int Soluong, double Giatien) {
        this.Mahh = Mahh;
        this.Mapn = Mapn;
        this.Mancc = Mancc;
        this.Soluong = Soluong;
        this.Giatien = Giatien;
    }

    public int getMahh() {
        return Mahh;
    }

    public void setMahh(int Mahh) {
        this.Mahh = Mahh;
    }

    public int getMapn() {
        return Mapn;
    }

    public void setMapn(int Mapn) {
        this.Mapn = Mapn;
    }

    public int getMancc() {
        return Mancc;
    }

    public void setMancc(int Mancc) {
        this.Mancc = Mancc;
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
