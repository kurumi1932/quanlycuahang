/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFrame;

import Model.CTPhieuNhap;
import Model.PhieuNhap;
import Service.CTPhieuNhapService;
import Service.PhieuNhapService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class CodeAddPhieuNhap {
    public static String TaoMaPN() {
        String mapn = "";
        try {
            //Chuyển date -> string
            DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
            long millis = System.currentTimeMillis();
            java.sql.Date d = new java.sql.Date(millis);
            //System.out.println("d:" + d);
            //System.out.println("d:" + dateformat.format(d));

            mapn = "PN" + dateformat.format(d);
            PhieuNhapService phieunhapService = new PhieuNhapService();
            ResultSet rs1 = phieunhapService.countMaPN(mapn);
            int rowCount = 0;
            if (rs1.next()) {
                rowCount = rs1.getInt(1);
            }
            //System.out.println("rowCount:" + rowCount);

            boolean dup = false;
            do {
                if (rowCount > 99) {
                    mapn = mapn + (rowCount + 1);
                } else if (rowCount < 9) {
                    mapn = mapn + "00" + (rowCount + 1);
                } else {
                    mapn = mapn + "0" + (rowCount + 1);
                }
                //System.out.println("mahd2:" + mahd);
                ResultSet rs2 = phieunhapService.getByMaPN(mapn);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    mapn = "PN" + dateformat.format(d);
                    //System.out.println("mahd3:" + mahd);
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException e) {
            System.out.println("Lỗi số hóa đơn!");
        }
        return mapn;
    }
       
    public void ThemCTPN (JTable table, String mapn){
        CTPhieuNhapService ctphieunhapService = new CTPhieuNhapService();
        PhieuNhapService phieunhapService = new PhieuNhapService();
        PhieuNhap pn = phieunhapService.getPhieuNhapByMaPN(mapn);
        String MaPN = pn.getMapn();      
            
        for(int i = 0; i < table.getRowCount(); i++){
            CTPhieuNhap ctpn = new CTPhieuNhap();
            ctpn.setMapn(MaPN);
            ctpn.setMasp(table.getValueAt(i, 0).toString());
            ctpn.setTensp(table.getValueAt(i, 2).toString());
            ctpn.setDvtinh(table.getValueAt(i, 3).toString());
            ctpn.setSoluongnhap(Integer.parseInt(table.getValueAt(i, 4).toString()));
            ctpn.setDongianhap(Float.parseFloat(table.getValueAt(i, 5).toString()));
            ctpn.setThanhtien(Float.parseFloat(table.getValueAt(i, 6).toString()));
            
            ctphieunhapService.addCTPhieuNhap(ctpn);
        }
    }
}
