/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class HangHoa {
    private int Mahh;
    private String Tenhh;
    private int Mancc;
    private int Soluongton;
    private NhaCungCap ncc;

    public HangHoa() {
    }

    public HangHoa(int Mahh, String Tenhh, int Mancc, int Soluongton, NhaCungCap ncc) {
        this.Mahh = Mahh;
        this.Tenhh = Tenhh;
        this.Mancc = Mancc;
        this.Soluongton = Soluongton;
        this.ncc = ncc;
    }

    public int getMahh() {
        return Mahh;
    }

    public void setMahh(int Mahh) {
        this.Mahh = Mahh;
    }

    public String getTenhh() {
        return Tenhh;
    }

    public void setTenhh(String Tenhh) {
        this.Tenhh = Tenhh;
    }

    public int getMancc() {
        return Mancc;
    }

    public void setMancc(int Mancc) {
        this.Mancc = Mancc;
    }

    public int getSoluongton() {
        return Soluongton;
    }

    public void setSoluongton(int Soluongton) {
        this.Soluongton = Soluongton;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    
}
