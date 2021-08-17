/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author NHT_Kurumi
 */
public class HoaDon {
    private String mahd;
    private Date ngayban ;
    private float tonggiaban;

    public HoaDon() {
    }

    public HoaDon(String mahd, Date ngayban, float tonggiaban) {
        this.mahd = mahd;
        this.ngayban = ngayban;
        this.tonggiaban = tonggiaban;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgayban() {
        return ngayban;
    }

    public void setNgayban(Date ngayban) {
        this.ngayban = ngayban;
    }

    public float getTonggiaban() {
        return tonggiaban;
    }

    public void setTonggiaban(Float tonggiaban) {
        this.tonggiaban = tonggiaban;
    }
    
}
