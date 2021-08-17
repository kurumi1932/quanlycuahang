/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.MyConnection;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class HoaDonDAO {

    public List<HoaDon> getListHD(){
        List<HoaDon> HDlist = new ArrayList<HoaDon>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM hoa_don";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();               
                hd.setMahd(rs.getString("mahd"));
                hd.setNgayban(rs.getDate("ngayban"));
                hd.setTonggiaban(rs.getFloat("tonggiaban"));
                
                HDlist.add(hd);
            }
            ps.close();
            connection.close();                
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return HDlist;
    }
    
    public List<HoaDon> getListHDbyMaHD(String mahd){
        List<HoaDon> HDlist = new ArrayList<HoaDon>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM hoa_don WHERE mahd LIKE ? ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mahd);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();               
                hd.setMahd(rs.getString("mahd"));
                hd.setNgayban(rs.getDate("ngayban"));
                hd.setTonggiaban(rs.getFloat("tonggiaban"));
                
                HDlist.add(hd);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return HDlist;// nếu không có dữ liệu
    }
    
    public List<HoaDon> getListHDbyNgayBan(Date ngayban1, Date ngayban2){
        List<HoaDon> HDlist = new ArrayList<HoaDon>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM hoa_don where  ngayban >= ? AND ngayban <= ? ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, ngayban1);
            ps.setDate(2, ngayban2);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();               
                hd.setNgayban(rs.getDate("ngayban"));
                hd.setMahd(rs.getString("mahd"));
                hd.setTonggiaban(rs.getFloat("tonggiaban"));
                
                HDlist.add(hd);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return HDlist;// nếu không có dữ liệu
    }
    
    public HoaDon getHoaDonByMaHD(String mahd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM hoa_don WHERE mahd = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mahd);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                HoaDon hd = new HoaDon();               
                hd.setMahd(rs.getString("mahd"));
                hd.setNgayban(rs.getDate("ngayban"));
                hd.setTonggiaban(rs.getFloat("tonggiaban"));
                
                return hd;
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;// nếu không có dữ liệu
    }
    
    public void addHoaDon(HoaDon hd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "INSERT INTO hoa_don(mahd, ngayban, tonggiaban) VALUE(?,?,?)";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, hd.getMahd());
            ps.setDate(2, hd.getNgayban());
            ps.setFloat(3, hd.getTonggiaban());
            
            int rs = ps.executeUpdate();
            
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateHoaDon(HoaDon hd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "update hoa_don set ngayban = ?,tonggiaban = ? "
                + " WHERE mahd = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(3, hd.getMahd());
            ps.setDate(1, hd.getNgayban());
            ps.setFloat(2, hd.getTonggiaban());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteHoaDon(String mahd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "DELETE FROM hoa_don WHERE mahd = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mahd);            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Đếm số hóa đơn ngày hôm đó có hay chưa
    public ResultSet countMaHD(String dem){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT Count(*) FROM hoa_don WHERE mahd Like '" + dem + "%' ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;// nếu không có dữ liệu
    }
    
    //Kiểm tra mã hóa đơn
    public ResultSet getByMaHD(String mahd) {
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM hoa_don WHERE mahd = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mahd);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
