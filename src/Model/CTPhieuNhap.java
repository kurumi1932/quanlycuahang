/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NHT_Kurumi
 */
public class CTPhieuNhap extends SanPham{
    private String mapn;
    private int soluongnhap;
    private float thanhtien;
    private float dongianhap;

    public CTPhieuNhap() {
    }

    public CTPhieuNhap(String mapn, int soluongnhap, float thanhtien, float dongianhap, String masp, String tensp, String dvtinh, int soluong, float dongiaban) {
        super(masp, tensp, dvtinh, soluong, dongiaban);
        this.mapn = mapn;
        this.soluongnhap = soluongnhap;
        this.thanhtien = thanhtien;
        this.dongianhap = dongianhap;
    }

    public String getMapn() {
        return mapn;
    }

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public float getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(float dongianhap) {
        this.dongianhap = dongianhap;
    }
    
}
