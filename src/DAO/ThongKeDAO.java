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
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author NHT_Kurumi
 */
public class ThongKeDAO {
    
    //Hóa đơn
    public List<ThongKe> getListTKbySP1_1(){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT ct_hd.masp, ct_hd.tensp, sum(ct_hd.soluongban) as tongsp "
                + " FROM hoa_don INNER JOIN ct_hd on hoa_don.mahd= ct_hd.mahd "
                + " group by masp, tensp ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setMasp(rs.getString("ct_hd.masp"));
                tk.setTensp(rs.getString("ct_hd.tensp"));
                tk.setSoluong(rs.getInt("tongsp"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;
    }
    
    public List<ThongKe> getListTKbyNgay1_1(){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT hoa_don.ngayban, ct_hd.masp, ct_hd.tensp, sum(ct_hd.soluongban) as tongsptheongay "
                + " FROM hoa_don INNER JOIN ct_hd on hoa_don.mahd= ct_hd.mahd "
                + " group by ngayban, masp, tensp ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setNgay(rs.getDate("hoa_don.ngayban"));
                tk.setMasp(rs.getString("ct_hd.masp"));
                tk.setTensp(rs.getString("ct_hd.tensp"));
                tk.setSoluong(rs.getInt("tongsptheongay"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;// nếu không có dữ liệu
    }
    
    public List<ThongKe> getListTKbySP1_2(Date ngayban1, Date ngayban2){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT ct_hd.masp, ct_hd.tensp, sum(ct_hd.soluongban) as tongsp "
                + " FROM hoa_don INNER JOIN ct_hd on hoa_don.mahd= ct_hd.mahd "
                + " where  ngayban >= ? AND ngayban <= ? "
                + " group by masp, tensp ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, ngayban1);
            ps.setDate(2, ngayban2);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setMasp(rs.getString("ct_hd.masp"));
                tk.setTensp(rs.getString("ct_hd.tensp"));
                tk.setSoluong(rs.getInt("tongsp"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;
    }
    
    public List<ThongKe> getListTKbyNgay1_2(Date ngayban1, Date ngayban2){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT hoa_don.ngayban, ct_hd.masp, ct_hd.tensp, sum(ct_hd.soluongban) as tongsptheongay "
                + " FROM hoa_don INNER JOIN ct_hd on hoa_don.mahd= ct_hd.mahd "
                + " where  ngayban >= ? AND ngayban <= ? "
                + " group by ngayban, masp, tensp ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, ngayban1);
            ps.setDate(2, ngayban2);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setNgay(rs.getDate("hoa_don.ngayban"));
                tk.setMasp(rs.getString("ct_hd.masp"));
                tk.setTensp(rs.getString("ct_hd.tensp"));
                tk.setSoluong(rs.getInt("tongsptheongay"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;// nếu không có dữ liệu
    }
    
    
    //Phiếu nhập
    public List<ThongKe> getListTKbySP2_1(){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT ct_pn.masp, ct_pn.tensp, sum(ct_pn.soluongnhap) as tongsp "
                + " FROM phieu_nhap INNER JOIN ct_pn on phieu_nhap.mapn= ct_pn.mapn "
                + " group by masp, tensp ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setMasp(rs.getString("ct_pn.masp"));
                tk.setTensp(rs.getString("ct_pn.tensp"));
                tk.setSoluong(rs.getInt("tongsp"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;
    }
    
    public List<ThongKe> getListTKbyNgay2_1(){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT phieu_nhap.ngaynhap, ct_pn.masp, ct_pn.tensp, sum(ct_pn.soluongnhap) as tongsptheongay "
                + " FROM phieu_nhap INNER JOIN ct_pn on phieu_nhap.mapn= ct_pn.mapn "
                + " group by ngaynhap, masp, tensp ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setNgay(rs.getDate("phieu_nhap.ngaynhap"));
                tk.setMasp(rs.getString("ct_pn.masp"));
                tk.setTensp(rs.getString("ct_pn.tensp"));
                tk.setSoluong(rs.getInt("tongsptheongay"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;// nếu không có dữ liệu
    }
    
    public List<ThongKe> getListTKbySP2_2(Date ngaynhap1, Date ngaynhap2){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT ct_pn.masp, ct_pn.tensp, sum(ct_pn.soluongnhap) as tongsp "
                + " FROM phieu_nhap INNER JOIN ct_pn on phieu_nhap.mapn= ct_pn.mapn "
                + " where  ngaynhap >= ? AND ngaynhap <= ? "
                + " group by masp, tensp ";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, ngaynhap1);
            ps.setDate(2, ngaynhap2);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setMasp(rs.getString("ct_pn.masp"));
                tk.setTensp(rs.getString("ct_pn.tensp"));
                tk.setSoluong(rs.getInt("tongsp"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;
    }
    
    public List<ThongKe> getListTKbyNgay2_2(Date ngaynhap1, Date ngaynhap2){
        List<ThongKe> TKlist = new ArrayList<ThongKe>();
        Connection connection = MyConnection.getMyConnection();
        
        String sql = " SELECT phieu_nhap.ngaynhap, ct_pn.masp, ct_pn.tensp, sum(ct_pn.soluongnhap) as tongsptheongay "
                + " FROM phieu_nhap INNER JOIN ct_pn on phieu_nhap.mapn= ct_pn.mapn "
                + " where  ngaynhap >= ? AND ngaynhap <= ? "
                + " group by ngaynhap, masp, tensp ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, ngaynhap1);
            ps.setDate(2, ngaynhap2);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKe tk = new ThongKe();
                
                tk.setNgay(rs.getDate("phieu_nhap.ngaynhap"));
                tk.setMasp(rs.getString("ct_pn.masp"));
                tk.setTensp(rs.getString("ct_pn.tensp"));
                tk.setSoluong(rs.getInt("tongsptheongay"));
                
                TKlist.add(tk);
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return TKlist;// nếu không có dữ liệu
    }
}
