/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap {
    private int Mancc;
    private String Tenncc;
    private int Sdt;
    private String Diachi;

    public NhaCungCap() {
    }

    public NhaCungCap(int Mancc, String Tenncc, int Sdt, String Diachi) {
        this.Mancc = Mancc;
        this.Tenncc = Tenncc;
        this.Sdt = Sdt;
        this.Diachi = Diachi;
    }

    public int getMancc() {
        return Mancc;
    }

    public void setMancc(int Mancc) {
        this.Mancc = Mancc;
    }

    public String getTenncc() {
        return Tenncc;
    }

    public void setTenncc(String Tenncc) {
        this.Tenncc = Tenncc;
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
    
}
