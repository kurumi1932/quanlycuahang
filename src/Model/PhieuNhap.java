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
public class PhieuNhap {
    private String mapn;
    private Date ngaynhap ;
    private float tonggianhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String mapn, Date ngayban, float tonggianhap) {
        this.mapn = mapn;
        this.ngaynhap = ngayban;
        this.tonggianhap = tonggianhap;
    }

    public String getMapn() {
        return mapn;
    }

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public float getTonggianhap() {
        return tonggianhap;
    }

    public void setTonggianhap(float tonggianhap) {
        this.tonggianhap = tonggianhap;
    }

}
