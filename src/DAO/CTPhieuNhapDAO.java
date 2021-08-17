/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.MyConnection;
import Model.CTPhieuNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NHT_Kurumi
 */
public class CTPhieuNhapDAO {
    public List<CTPhieuNhap> getListCTPNbyMaPN(String mapn){
        List<CTPhieuNhap> CTPNlist = new ArrayList<CTPhieuNhap>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM ct_pn WHERE mapn = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mapn);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                CTPhieuNhap ctpn = new CTPhieuNhap();     
                ctpn.setMapn(rs.getString("mapn"));
                ctpn.setMasp(rs.getString("masp"));
                ctpn.setTensp(rs.getString("tensp"));
                ctpn.setDvtinh(rs.getString("dvtinh"));
                ctpn.setSoluongnhap(rs.getInt("soluongnhap"));
                ctpn.setDongianhap(rs.getFloat("dongianhap"));
                ctpn.setThanhtien(rs.getFloat("thanhtien"));
                
                CTPNlist.add(ctpn);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return CTPNlist;
    }
    
    public void addCTPhieuNhap(CTPhieuNhap ctpn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "INSERT INTO ct_pn(mapn, masp, tensp, dvtinh, soluongnhap, dongianhap, thanhtien) VALUE(?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, ctpn.getMapn());
            ps.setString(2, ctpn.getMasp());
            ps.setString(3, ctpn.getTensp());
            ps.setString(4, ctpn.getDvtinh());
            ps.setInt(5, ctpn.getSoluongnhap());
            ps.setFloat(6, ctpn.getDongianhap());
            ps.setFloat(7, ctpn.getThanhtien());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCTPhieuNhap(CTPhieuNhap ctpn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "update ct_pn set tensp = ?, dvtinh = ?, soluongnhap = ?, "
                + " dongianhap = ?, thanhtien = ? WHERE mapn = ? and masp = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(6, ctpn.getMapn());
            ps.setString(7, ctpn.getMasp());
            ps.setString(1, ctpn.getTensp());
            ps.setString(2, ctpn.getDvtinh());
            ps.setInt(3, ctpn.getSoluongnhap());
            ps.setFloat(4, ctpn.getDongianhap());
            ps.setFloat(5, ctpn.getThanhtien());
            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCTPhieuNhap(String mapn){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "DELETE FROM ct_pn WHERE mapn = ?";
        
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
}
