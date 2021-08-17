/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.MyConnection;
import Model.*;
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
public class PhieuNhapDAO {
    
    public List<PhieuNhap> getListPN(){
        List<PhieuNhap> PNlist = new ArrayList<PhieuNhap>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM phieu_nhap";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap();
                
                pn.setMapn(rs.getString("mapn"));
                pn.setNgaynhap(rs.getDate("ngaynhap"));
                pn.setTonggianhap(rs.getFloat("tonggianhap"));
                
                PNlist.add(pn);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return PNlist;
    }
    
    public List<PhieuNhap> getListPNbyMaPN(String mapn){
        List<PhieuNhap> PNlist = new ArrayList<PhieuNhap>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM phieu_nhap WHERE mapn LIKE ? ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mapn);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap();
                
                pn.setMapn(rs.getString("mapn"));
                pn.setNgaynhap(rs.getDate("ngaynhap"));
                pn.setTonggianhap(rs.getFloat("tonggianhap"));
                
                PNlist.add(pn);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return PNlist;// nếu không có dữ liệu
    }
    
    public List<PhieuNhap> getListPNbyNgayNhap(Date ngaynhap1, Date ngaynhap2){
        List<PhieuNhap> PNlist = new ArrayList<PhieuNhap>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM phieu_nhap where  ngaynhap >= ? AND ngaynhap <= ? ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, ngaynhap1);
            ps.setDate(2, ngaynhap2);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap();
                
                pn.setNgaynhap(rs.getDate("ngaynhap"));
                pn.setMapn(rs.getString("mapn"));
                pn.setTonggianhap(rs.getFloat("tonggianhap"));
                
                PNlist.add(pn);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return PNlist;// nếu không có dữ liệu
    }
    
    public PhieuNhap getPhieuNhapByMaPN(String mapn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM phieu_nhap WHERE mapn = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mapn);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                PhieuNhap pn = new PhieuNhap();
                
                pn.setMapn(rs.getString("mapn"));
                pn.setNgaynhap(rs.getDate("ngaynhap"));
                pn.setTonggianhap(rs.getFloat("tonggianhap"));
                
                return pn;
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;// nếu không có dữ liệu
    }
    
    public void addPhieuNhap(PhieuNhap pn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "INSERT INTO phieu_nhap(mapn, ngaynhap, tonggianhap) VALUE(?,?,?)";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, pn.getMapn());
            ps.setDate(2, pn.getNgaynhap());
            ps.setFloat(3, pn.getTonggianhap());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePhieuNhap(PhieuNhap pn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "update phieu_nhap set ngaynhap = ?, tonggianhap = ? "
                + " WHERE mapn = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(3, pn.getMapn());
            ps.setDate(1, pn.getNgaynhap());
            ps.setFloat(2, pn.getTonggianhap());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePhieuNhap(String mapn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "DELETE FROM phieu_nhap WHERE mapn = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mapn);            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Đếm số hóa đơn ngày hôm đó có hay chưa
    public ResultSet countMaPN(String dem){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT Count(*) FROM phieu_nhap WHERE mapn Like '" + dem + "%' ";
        
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
    public ResultSet getByMaPN(String mapn) {
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM phieu_nhap WHERE mapn = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mapn);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
