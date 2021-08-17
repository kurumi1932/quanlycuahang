/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFrame;

import Connect.MyConnection;
import Model.CTHoaDon;
import Model.HoaDon;
import Model.SanPham;
import Service.CTHoaDonService;
import Service.HoaDonService;
import Service.SanPhamService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class CodeBanHang {

    public static String TaoMaHD() {
        String mahd = "";
        try {
            //Chuyển date -> string
            DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
            long millis = System.currentTimeMillis();
            java.sql.Date d = new java.sql.Date(millis);
//            System.out.println("d:" + d);
//            System.out.println("d:" + dateformat.format(d));

            mahd = "HD" + dateformat.format(d);
//            System.out.println("mahd1:" + mahd);
            HoaDonService hoadonService = new HoaDonService();
            ResultSet rs1 = hoadonService.countMaHD(mahd);
            int rowCount = 0;
            if (rs1.next()) {
                rowCount = rs1.getInt(1);
            }
//            System.out.println("rowCount:" + rowCount);

            boolean dup = false;
            do {
                if (rowCount > 99) {
                    mahd = mahd + (rowCount + 1);
                } else if (rowCount < 9) {
                    mahd = mahd + "00" + (rowCount + 1);
                } else {
                    mahd = mahd + "0" + (rowCount + 1);
                }
//                System.out.println("mahd2:" + mahd);
                ResultSet rs2 = hoadonService.getByMaHD(mahd);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    mahd = "HD" + dateformat.format(d);
//                    System.out.println("mahd3:" + mahd);
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException e) {
            System.out.println("Lỗi số hóa đơn!");
        }
        return mahd;
    }

    public static String TinhTongTien(JTable tbl) {
        float tongtien = 0;
        for (int i = 0; i < tbl.getRowCount(); i++) {
            tongtien += Float.parseFloat(tbl.getValueAt(i, 6).toString());
        }

        return String.format("%.0f", tongtien);
    }
    
    
    public void ThemCTHD (JTable table, String mahd){
        CTHoaDonService cthoadonService = new CTHoaDonService();
        HoaDonService hoadonService = new HoaDonService();
        HoaDon hd = hoadonService.getHoaDonByMaHD(mahd);
        String MaHD = hd.getMahd();      
            
        for(int i = 0; i < table.getRowCount(); i++){
            CTHoaDon cthd = new CTHoaDon();
            cthd.setMahd(MaHD);
            cthd.setMasp(table.getValueAt(i, 0).toString());
            cthd.setTensp(table.getValueAt(i, 2).toString());
            cthd.setDvtinh(table.getValueAt(i, 3).toString());
            cthd.setSoluongban(Integer.parseInt(table.getValueAt(i, 4).toString()));
            cthd.setDongiaban(Float.parseFloat(table.getValueAt(i, 5).toString()));
            cthd.setThanhtien(Float.parseFloat(table.getValueAt(i, 6).toString()));
            
            cthoadonService.addCTHoaDon(cthd);
        }
    }
}
