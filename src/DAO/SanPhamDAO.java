/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.MyConnection;
import Model.SanPham;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author NHT_Kurumi
 */
//DAO là 1 lớp điều khiển chuyên dùng để liên kết giữa csdl với java
public class SanPhamDAO {
    public List<SanPham> getListSP(){
        List<SanPham> SPlist = new ArrayList<SanPham>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM san_pham";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SanPham sp = new SanPham();
                
                sp.setMasp(rs.getString("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setDvtinh(rs.getString("dvtinh"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongiaban(rs.getFloat("dongiaban"));
                
                SPlist.add(sp);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return SPlist;
    }
    
    public List<SanPham> getListSPinSanPham(){
        List<SanPham> SPlist = new ArrayList<SanPham>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM san_pham ORDER BY soluong ASC";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SanPham sp = new SanPham();
                
                sp.setMasp(rs.getString("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setDvtinh(rs.getString("dvtinh"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongiaban(rs.getFloat("dongiaban"));
                
                SPlist.add(sp);
            }
            ps.close();
            connection.close();                
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return SPlist;
    }
    
    public SanPham getSanPhamByMaSP(String masp){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM san_pham WHERE masp = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,masp);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SanPham sp = new SanPham();
                
                sp.setMasp(rs.getString("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setDvtinh(rs.getString("dvtinh"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongiaban(rs.getFloat("dongiaban"));
                
                return sp;
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;// nếu không có dữ liệu
    }
    
    public void addSanPham(SanPham sp){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "INSERT INTO san_pham(masp, tensp, dvtinh, soluong, dongiaban) VALUE(?,?,?,?,?)";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, sp.getMasp());
            ps.setString(2, sp.getTensp());
            ps.setString(3, sp.getDvtinh());
            ps.setInt(4, sp.getSoluong());
            ps.setFloat(5, sp.getDongiaban());
            
            int rs = ps.executeUpdate();
            
            ps.close();
            connection.close();            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateSanPham(SanPham sp){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "update san_pham set tensp = ?,dvtinh = ?,soluong = ?,dongiaban = ? "
                + " WHERE masp = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(5, sp.getMasp());
            ps.setString(1, sp.getTensp());
            ps.setString(2, sp.getDvtinh());
            ps.setInt(3, sp.getSoluong());
            ps.setFloat(4, sp.getDongiaban());
            
            int rs = ps.executeUpdate();
            
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteSanPham(String masp){
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "DELETE FROM san_pham WHERE masp = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, masp);            
            int rs = ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public List<SanPham> getListSPbyDVTinh(String dvtinh){
        List<SanPham> SPlist = new ArrayList<SanPham>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = "SELECT * FROM san_pham WHERE dvtinh = ? ORDER BY soluong ASC";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dvtinh);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SanPham sp = new SanPham();
                
                sp.setDvtinh(rs.getString("dvtinh"));
                sp.setMasp(rs.getString("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongiaban(rs.getFloat("dongiaban"));
                
                SPlist.add(sp);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return SPlist;
    }
    
    public List<SanPham> getListSPbyTenSP(JTable jt, String tensp){
        List<SanPham> SPlist = new ArrayList<SanPham>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT * FROM san_pham WHERE tensp LIKE ? ORDER BY soluong ASC";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, tensp);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SanPham sp = new SanPham();
                
                sp.setMasp(rs.getString("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setDvtinh(rs.getString("dvtinh"));
                sp.setSoluong(rs.getInt("soluong"));                
                sp.setDongiaban(rs.getFloat("dongiaban"));
                
                SPlist.add(sp);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return SPlist;
    }
    
    public void loadDataComboBox(JComboBox cb){
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " select dvtinh from san_pham group by dvtinh ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cb.addItem(rs.getString("dvtinh"));
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
