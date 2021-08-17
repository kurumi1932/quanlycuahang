/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFrame;

import Model.*;
import Service.*;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class CodeEditPhieuNhap {
    public void EditPNandCTPN(JTable table, String mapn){
        PhieuNhapService phieunhapService = new PhieuNhapService();
        PhieuNhap pn = phieunhapService.getPhieuNhapByMaPN(mapn);
        String MaPN = pn.getMapn(); 
        
        // xóa trong sql
        CTPhieuNhapService ctphieunhapService = new CTPhieuNhapService();
        ctphieunhapService.deleteCTPhieuNhap(MaPN);
            
        for (int i = 0; i < table.getRowCount(); i++) {
            //thêm lại ds trong table vào sql
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
