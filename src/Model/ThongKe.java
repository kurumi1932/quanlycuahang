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
public class ThongKe extends SanPham{
    private Date ngay;

    public ThongKe() {
    }

    public ThongKe(Date ngay, String masp, String tensp, String dvtinh, int soluong, float dongiaban) {
        super(masp, tensp, dvtinh, soluong, dongiaban);
        this.ngay = ngay;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
}
