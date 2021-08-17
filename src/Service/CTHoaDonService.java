/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.CTHoaDonDAO;
import Model.CTHoaDon;
import Model.SanPham;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class CTHoaDonService {
     
    private  CTHoaDonDAO ctHoaDonDAO;
    
    public CTHoaDonService(){
        ctHoaDonDAO = new CTHoaDonDAO();
    }
    
    public List<CTHoaDon> getListCTHDbyMaHD(String mahd){
        return ctHoaDonDAO.getListCTHDbyMaHD(mahd);
    }
    
    public void addCTHoaDon(CTHoaDon cthd){
        ctHoaDonDAO.addCTHoaDon(cthd);
    }
    
    public void deleteCTHoaDon(String mahd){
        ctHoaDonDAO.deleteCTHoaDon(mahd);
    }
    
    public void updateCTHoaDon(CTHoaDon cthd){
        ctHoaDonDAO.updateCTHoaDon(cthd);
    }

}
