/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.MyConnection;
import Model.CTHoaDon;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NHT_Kurumi
 */
public class CTHoaDonDAO {
    
    public List<CTHoaDon> getListCTHDbyMaHD(String mahd){
        List<CTHoaDon> CTHDlist = new ArrayList<CTHoaDon>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM ct_hd WHERE mahd = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mahd);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                CTHoaDon cthd = new CTHoaDon();             
                cthd.setMahd(rs.getString("mahd"));
                cthd.setMasp(rs.getString("masp"));
                cthd.setTensp(rs.getString("tensp"));
                cthd.setDvtinh(rs.getString("dvtinh"));
                cthd.setSoluongban(rs.getInt("soluongban"));
                cthd.setDongiaban(rs.getFloat("dongiaban"));
                cthd.setThanhtien(rs.getFloat("thanhtien"));
                
                CTHDlist.add(cthd);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return CTHDlist;
    }
    
    public void addCTHoaDon(CTHoaDon cthd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "INSERT INTO ct_hd(mahd, masp, tensp, dvtinh, soluongban, dongiaban, thanhtien) VALUE(?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, cthd.getMahd());
            ps.setString(2, cthd.getMasp());
            ps.setString(3, cthd.getTensp());
            ps.setString(4, cthd.getDvtinh());
            ps.setInt(5, cthd.getSoluongban());
            ps.setFloat(6, cthd.getDongiaban());
            ps.setFloat(7, cthd.getThanhtien());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCTHoaDon(CTHoaDon cthd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "update ct_hd set tensp = ?, dvtinh = ?, soluongban = ?, "
                + " dongiaban = ?, thanhtien = ? WHERE mahd = ? and masp = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(6, cthd.getMahd());
            ps.setString(7, cthd.getMasp());
            ps.setString(1, cthd.getTensp());
            ps.setString(2, cthd.getDvtinh());
            ps.setInt(3, cthd.getSoluongban());
            ps.setFloat(4, cthd.getDongiaban());
            ps.setFloat(5, cthd.getThanhtien());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCTHoaDon(String mahd){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "DELETE FROM ct_hd WHERE mahd = ?";
        
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
    
}
