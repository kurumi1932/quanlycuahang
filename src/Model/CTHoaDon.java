/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Service.CTHoaDonService;
import Service.HoaDonService;
import javax.swing.JTable;


/**
 *
 * @author NHT_Kurumi
 */
public class CTHoaDon extends SanPham{
    private String mahd;
    private int soluongban;
    private float thanhtien;

    public CTHoaDon() {
    }

    public CTHoaDon(String mahd, String masp, String tensp, String dvtinh, int soluongban, int soluong, float dongiaban, float thanhtien) {
        super(masp, tensp, dvtinh, soluong, dongiaban);
        this.mahd = mahd;
        this.soluongban = soluongban;
        this.thanhtien = thanhtien;
    } 

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }
    
    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Float thanhtien) {
        this.thanhtien = soluongban*super.getDongiaban();
    }
    
}
