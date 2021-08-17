/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ThongKeDAO;
import Model.*;
import java.sql.Date;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author NHT_Kurumi
 */
public class ThongKeService {
    
    private  ThongKeDAO ThongKeDAO;
    
    public ThongKeService(){
        ThongKeDAO = new ThongKeDAO();
    }
    
    public List<ThongKe> getListTKbySP1_1(){
        return ThongKeDAO.getListTKbySP1_1();
    }
    
    public List<ThongKe> getListTKbyNgay1_1(){
        return ThongKeDAO.getListTKbyNgay1_1();
    }
    
    public List<ThongKe> getListTKbySP1_2(Date ngayban1, Date ngayban2){
        return ThongKeDAO.getListTKbySP1_2(ngayban1, ngayban2);
    }
    
    public List<ThongKe> getListTKbyNgay1_2(Date ngayban1, Date ngayban2){
        return ThongKeDAO.getListTKbyNgay1_2(ngayban1, ngayban2);
    }
    
    public List<ThongKe> getListTKbySP2_1(){
        return ThongKeDAO.getListTKbySP2_1();
    }
    
    public List<ThongKe> getListTKbyNgay2_1(){
        return ThongKeDAO.getListTKbyNgay2_1();
    }
    
    public List<ThongKe> getListTKbySP2_2(Date ngaynhap1, Date ngaynhap2){
        return ThongKeDAO.getListTKbySP2_2(ngaynhap1, ngaynhap2);
    }
    
    public List<ThongKe> getListTKbyNgay2_2(Date ngaynhap1, Date ngaynhap2){
        return ThongKeDAO.getListTKbyNgay2_2(ngaynhap1, ngaynhap2);
    }
}
