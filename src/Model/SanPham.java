/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tien1
 */
public class SanPham {
    private String masp;
    private String tensp;
    private String dvtinh;
    private int soluong;
    private float dongiaban;

    public SanPham() {
    }

    public SanPham(String masp, String tensp, String dvtinh, int soluong, float dongiaban) {
        this.masp = masp;
        this.tensp = tensp;
        this.dvtinh = dvtinh;
        this.soluong = soluong;
        this.dongiaban = dongiaban;
    }
    
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getDvtinh() {
        return dvtinh;
    }

    public void setDvtinh(String dvtinh) {
        this.dvtinh = dvtinh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongiaban() {
        return dongiaban;
    }

    public void setDongiaban(float dongiaban) {
        this.dongiaban = dongiaban;
    }


}