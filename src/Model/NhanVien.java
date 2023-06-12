/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private int Manv;
    private String Hoten;
    private int Sdt;
    private String Diachi;
    private String Matkhau;
    public NhanVien(){
        
    }

    public NhanVien(int Manv, String Hoten, int Sdt, String Diachi, String Matkhau) {
        this.Manv = Manv;
        this.Hoten = Hoten;
        this.Sdt = Sdt;
        this.Diachi = Diachi;
        this.Matkhau = Matkhau;
    }

    public int getManv() {
        return Manv;
    }

    public void setManv(int Manv) {
        this.Manv = Manv;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }
    
}

    