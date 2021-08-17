/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.HoaDonDAO;
import Model.HoaDon;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class HoaDonService {

    private  HoaDonDAO HoaDonDAO;
    
    public HoaDonService(){
        HoaDonDAO = new HoaDonDAO();
    }
    
    public List<HoaDon> getListHD(){
        return HoaDonDAO.getListHD();
    }
    
    public List<HoaDon> getListHDbyMaHD(String mahd){
        return HoaDonDAO.getListHDbyMaHD(mahd);
    }
    
    public List<HoaDon> getListHDbyNgayBan(Date ngayban1, Date ngayban2){
        return HoaDonDAO.getListHDbyNgayBan(ngayban1, ngayban2);
    }
    
    public HoaDon  getHoaDonByMaHD(String mahd){
        return HoaDonDAO.getHoaDonByMaHD(mahd);
    }
    
    public void addHoaDon(HoaDon hd){
        HoaDonDAO.addHoaDon(hd);
    }
    
    public void updateHoaDon(HoaDon hd){
        HoaDonDAO.updateHoaDon(hd);
    }

    public void deleteHoaDon(String mahd){
        HoaDonDAO.deleteHoaDon(mahd);
    }
    
    public ResultSet countMaHD(String dem){
        return HoaDonDAO.countMaHD(dem);
    }
    
    public ResultSet getByMaHD(String mahd){
        return HoaDonDAO.getByMaHD(mahd);
    }
}
