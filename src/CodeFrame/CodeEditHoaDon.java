/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFrame;

import Model.CTHoaDon;
import Model.HoaDon;
import Model.SanPham;
import Service.CTHoaDonService;
import Service.HoaDonService;
import Service.SanPhamService;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class CodeEditHoaDon {
    
    public void EditHDandCTHD (JTable table, String mahd){
        HoaDonService hoadonService = new HoaDonService();
        HoaDon hd = hoadonService.getHoaDonByMaHD(mahd);
        String MaHD = hd.getMahd(); 
        
        // xóa trong sql
        CTHoaDonService cthoadonService = new CTHoaDonService();
        cthoadonService.deleteCTHoaDon(MaHD);
        
            
        for (int i = 0; i < table.getRowCount(); i++) {
            //thêm lại ds trong table vào sql
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
