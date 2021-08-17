/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.SanPhamDAO;
import Model.SanPham;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class SanPhamService {
    private  SanPhamDAO sanphamDAO;
    
    public SanPhamService(){
        sanphamDAO = new SanPhamDAO();
    }
    
    public List<SanPham> getListSP(){
        return sanphamDAO.getListSP();
    }
    
    public List<SanPham> getListSPinSanPham(){
        return sanphamDAO.getListSPinSanPham();
    }
    
    public void addSanPham(SanPham sp){
        sanphamDAO.addSanPham(sp);
    }
    
    public void deleteSanPham(String masp){
        sanphamDAO.deleteSanPham(masp);
    }
    
    public SanPham getSanPhamByMaSP(String masp){
        return sanphamDAO.getSanPhamByMaSP(masp);
    }
    
    public void updateSanPham(SanPham sp){
        sanphamDAO.updateSanPham(sp);
    }
    
    public List<SanPham> getListSPbyDVTinh(String dvtinh) {
        return sanphamDAO.getListSPbyDVTinh(dvtinh);
    }
            
    public List<SanPham> getListSPbyTenSP(JTable jt, String tensp){
        return sanphamDAO.getListSPbyTenSP(jt, tensp);
    }
    
    public void loadDataComboBox(JComboBox cb){
        sanphamDAO.loadDataComboBox(cb);
    }
}
