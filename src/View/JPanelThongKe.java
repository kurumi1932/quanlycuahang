/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import Service.*;
import java.awt.*;
import java.sql.Date;
import java.text.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NHT_Kurumi
 */
public class JPanelThongKe extends javax.swing.JPanel {

    ThongKeService thongkeService;
    HoaDonService hoadonService;
    CTHoaDonService cthoadonService;
    PhieuNhapService phieunhapService;
    CTPhieuNhapService ctphieunhapService;
    private DefaultTableModel ModelHD;
    private DefaultTableModel ModelTKbySP1;
    private DefaultTableModel ModelTKbyNgay1;
    private DefaultTableModel ModelPN;
    private DefaultTableModel ModelTKbySP2;
    private DefaultTableModel ModelTKbyNgay2;
    /**
     * Creates new form NewJPanel
     */
    public JPanelThongKe() {
        initComponents();
        setBackground(Color.WHITE);
        
        LamMoi1();
        LamMoi2();
    }

//Hóa đơn    
    private void TableHD(){
        hoadonService = new HoaDonService();
        
        ModelHD = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tableHD.setModel(ModelHD);
        ModelHD.addColumn("STT");
        ModelHD.addColumn("Mã HD");
        ModelHD.addColumn("Ngày lập");
        ModelHD.addColumn("Tổng tiền");
        
        tableHD.getColumnModel().getColumn(0).setMinWidth(45);
        tableHD.getColumnModel().getColumn(0).setMaxWidth(45);
        tableHD.getColumnModel().getColumn(1).setMinWidth(180);
        tableHD.getColumnModel().getColumn(1).setMaxWidth(180);
        tableHD.getColumnModel().getColumn(2).setMinWidth(120);
        tableHD.getColumnModel().getColumn(2).setMaxWidth(120);
        tableHD.getColumnModel().getColumn(3).setMinWidth(110);
        tableHD.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataHDtable(hoadonService.getListHD());
    }

    private void setDataHDtable(List<HoaDon> HDlist){
        for(HoaDon hd : HDlist){
            ModelHD.addRow(new Object[]{
                ModelHD.getRowCount()+1, hd.getMahd(), hd.getNgayban(),
                String.format("%.0f",hd.getTonggiaban())
            });
        }
    }
    
    private void TableTKbySP1(){
        thongkeService = new ThongKeService();
        
        ModelTKbySP1 = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tableTKbySP1.setModel(ModelTKbySP1);
        ModelTKbySP1.addColumn("STT");
         ModelTKbySP1.addColumn("Mã SP");
        ModelTKbySP1.addColumn("Tên SP");
        ModelTKbySP1.addColumn("Số lượng");
        
        tableTKbySP1.getColumnModel().getColumn(0).setMinWidth(35);
        tableTKbySP1.getColumnModel().getColumn(0).setMaxWidth(35);
        tableTKbySP1.getColumnModel().getColumn(1).setMinWidth(55);
        tableTKbySP1.getColumnModel().getColumn(1).setMaxWidth(55);
        tableTKbySP1.getColumnModel().getColumn(2).setMinWidth(230);
        tableTKbySP1.getColumnModel().getColumn(2).setMaxWidth(230);
        tableTKbySP1.getColumnModel().getColumn(3).setMinWidth(65);
        tableTKbySP1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataTKbySP1(thongkeService.getListTKbySP1_1());
    }

    private void setDataTKbySP1(List<ThongKe> TKlist){
        for(ThongKe tk : TKlist){
            ModelTKbySP1.addRow(new Object[]{
                ModelTKbySP1.getRowCount()+1,tk.getMasp(),
                tk.getTensp(),tk.getSoluong()
            });
        }
    }
    
    private void TableTKbyNgay1(){
        thongkeService = new ThongKeService();
        
        ModelTKbyNgay1 = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tableTKbyNgay1.setModel(ModelTKbyNgay1);
        ModelTKbyNgay1.addColumn("Ngày");
        ModelTKbyNgay1.addColumn("Mã SP");
        ModelTKbyNgay1.addColumn("Tên SP");
        ModelTKbyNgay1.addColumn("Số lượng");
        
        tableTKbyNgay1.getColumnModel().getColumn(0).setMinWidth(85);
        tableTKbyNgay1.getColumnModel().getColumn(0).setMaxWidth(85);
        tableTKbyNgay1.getColumnModel().getColumn(1).setMinWidth(55);
        tableTKbyNgay1.getColumnModel().getColumn(1).setMaxWidth(55);
        tableTKbyNgay1.getColumnModel().getColumn(2).setMinWidth(230);
        tableTKbyNgay1.getColumnModel().getColumn(2).setMaxWidth(230);
        tableTKbyNgay1.getColumnModel().getColumn(3).setMinWidth(65);
        tableTKbyNgay1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataTKbyNgay1(thongkeService.getListTKbyNgay1_1());
    }

    private void setDataTKbyNgay1(List<ThongKe> TKlist){
        for(ThongKe tk : TKlist){
            ModelTKbyNgay1.addRow(new Object[]{
                tk.getNgay(),tk.getMasp(),
                tk.getTensp(),tk.getSoluong()
            });
        }
    }
    
    private void TongDoanhThu() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for (int i = 0; i < tableHD.getRowCount(); i++) {
            Tong += Integer.parseInt(tableHD.getValueAt(i, 3).toString());
        }
        jlbTongDoanhThu1.setText("Tổng doanh thu: "+ x.format(Tong)+" VNĐ");
    }
    
    private void LamMoi1(){
        TableHD();
        TableTKbySP1();
        TableTKbyNgay1();
        TongDoanhThu();
    }
    
//Phiếu nhập    
    private void TablePN(){
        phieunhapService = new PhieuNhapService();
        
        ModelPN = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tablePN.setModel(ModelPN);
        ModelPN.addColumn("STT");
        ModelPN.addColumn("Mã PN");
        ModelPN.addColumn("Ngày lập");
        ModelPN.addColumn("Tổng tiền");
        
        tablePN.getColumnModel().getColumn(0).setMinWidth(45);
        tablePN.getColumnModel().getColumn(0).setMaxWidth(45);
        tablePN.getColumnModel().getColumn(1).setMinWidth(180);
        tablePN.getColumnModel().getColumn(1).setMaxWidth(180);
        tablePN.getColumnModel().getColumn(2).setMinWidth(120);
        tablePN.getColumnModel().getColumn(2).setMaxWidth(120);
        tablePN.getColumnModel().getColumn(3).setMinWidth(110);
        tablePN.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataPNtable(phieunhapService.getListPN());
    }
    
    private void setDataPNtable(List<PhieuNhap> PNlist){
        for(PhieuNhap pn : PNlist){
            ModelPN.addRow(new Object[]{
                ModelPN.getRowCount()+1, pn.getMapn(), pn.getNgaynhap(),
                String.format("%.0f",pn.getTonggianhap())
            });
        }
    }
    
    private void TableTKbySP2(){
        thongkeService = new ThongKeService();
        
        ModelTKbySP2 = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tableTKbySP2.setModel(ModelTKbySP2);
        ModelTKbySP2.addColumn("STT");
        ModelTKbySP2.addColumn("Mã SP");
        ModelTKbySP2.addColumn("Tên SP");
        ModelTKbySP2.addColumn("Số lượng");
        
        tableTKbySP2.getColumnModel().getColumn(0).setMinWidth(35);
        tableTKbySP2.getColumnModel().getColumn(0).setMaxWidth(35);
        tableTKbySP2.getColumnModel().getColumn(1).setMinWidth(55);
        tableTKbySP2.getColumnModel().getColumn(1).setMaxWidth(55);
        tableTKbySP2.getColumnModel().getColumn(2).setMinWidth(230);
        tableTKbySP2.getColumnModel().getColumn(2).setMaxWidth(230);
        tableTKbySP2.getColumnModel().getColumn(3).setMinWidth(65);
        tableTKbySP2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataTKbySP2(thongkeService.getListTKbySP2_1());
    }

    private void setDataTKbySP2(List<ThongKe> TKlist){
        for(ThongKe tk : TKlist){
            ModelTKbySP2.addRow(new Object[]{
                ModelTKbySP2.getRowCount()+1,tk.getMasp(),
                tk.getTensp(),tk.getSoluong()
            });
        }
    }
    
    private void TableTKbyNgay2(){
        thongkeService = new ThongKeService();
        
        ModelTKbyNgay2 = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tableTKbyNgay2.setModel(ModelTKbyNgay2);
        ModelTKbyNgay2.addColumn("Ngày");
        ModelTKbyNgay2.addColumn("Mã SP");
        ModelTKbyNgay2.addColumn("Tên SP");
        ModelTKbyNgay2.addColumn("Số lượng");
        
        tableTKbyNgay2.getColumnModel().getColumn(0).setMinWidth(85);
        tableTKbyNgay2.getColumnModel().getColumn(0).setMaxWidth(85);
        tableTKbyNgay2.getColumnModel().getColumn(1).setMinWidth(55);
        tableTKbyNgay2.getColumnModel().getColumn(1).setMaxWidth(55);
        tableTKbyNgay2.getColumnModel().getColumn(2).setMinWidth(230);
        tableTKbyNgay2.getColumnModel().getColumn(2).setMaxWidth(230);
        tableTKbyNgay2.getColumnModel().getColumn(3).setMinWidth(65);
        tableTKbyNgay2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataTKbyNgay2(thongkeService.getListTKbyNgay2_1());
    }

    private void setDataTKbyNgay2(List<ThongKe> TKlist){
        for(ThongKe tk : TKlist){
            ModelTKbyNgay2.addRow(new Object[]{
                tk.getNgay(),tk.getMasp(),
                tk.getTensp(),tk.getSoluong()
            });
        }
    }
    
    private void TongTienDaThanhToan() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for (int i = 0; i < tablePN.getRowCount(); i++) {
            Tong += Integer.parseInt(tablePN.getValueAt(i, 3).toString());
        }
        jlbTongDoanhThu2.setText("Tổng tiền đã thanh toán: "+ x.format(Tong)+" VNĐ");
    }
    
    private void LamMoi2(){
        TablePN();
        TableTKbySP2();
        TableTKbyNgay2();
        TongTienDaThanhToan();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnHD = new javax.swing.JPanel();
        jpnSearch = new javax.swing.JPanel();
        jbtSearch1 = new javax.swing.JButton();
        jbtReset1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSearchFromNgay1 = new com.toedter.calendar.JDateChooser();
        txtSearchToNgay1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHD = new javax.swing.JTable();
        jlbTongDoanhThu1 = new javax.swing.JLabel();
        jpnThongKeSP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTKbySP1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTKbyNgay1 = new javax.swing.JTable();
        jpnPN = new javax.swing.JPanel();
        jpnSearch1 = new javax.swing.JPanel();
        jbtSearch2 = new javax.swing.JButton();
        jbtReset2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSearchFromNgay2 = new com.toedter.calendar.JDateChooser();
        txtSearchToNgay2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jpnThongKeSP1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTKbySP2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableTKbyNgay2 = new javax.swing.JTable();
        jpnHoaDon1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePN = new javax.swing.JTable();
        jlbTongDoanhThu2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jpnHD.setBackground(new java.awt.Color(255, 255, 255));

        jpnSearch.setBackground(new java.awt.Color(255, 255, 255));
        jpnSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jbtSearch1.setBackground(new java.awt.Color(0, 204, 0));
        jbtSearch1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtSearch1.setForeground(new java.awt.Color(255, 255, 255));
        jbtSearch1.setText("Tìm kiếm");
        jbtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearch1ActionPerformed(evt);
            }
        });

        jbtReset1.setBackground(new java.awt.Color(0, 204, 0));
        jbtReset1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtReset1.setForeground(new java.awt.Color(255, 255, 255));
        jbtReset1.setText("Làm mới");
        jbtReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtReset1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Đến ngày");

        txtSearchFromNgay1.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchFromNgay1.setDateFormatString("dd/MM/yyyy");
        txtSearchFromNgay1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchFromNgay1.setMaxSelectableDate(new java.util.Date(253370743263000L));
        txtSearchFromNgay1.setMinSelectableDate(new java.util.Date(-62135791137000L));
        txtSearchFromNgay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchFromNgay1MouseClicked(evt);
            }
        });
        txtSearchFromNgay1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchFromNgay1KeyReleased(evt);
            }
        });

        txtSearchToNgay1.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchToNgay1.setDateFormatString("dd/MM/yyyy");
        txtSearchToNgay1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchToNgay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchToNgay1MouseClicked(evt);
            }
        });
        txtSearchToNgay1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchToNgay1KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Từ ngày");

        javax.swing.GroupLayout jpnSearchLayout = new javax.swing.GroupLayout(jpnSearch);
        jpnSearch.setLayout(jpnSearchLayout);
        jpnSearchLayout.setHorizontalGroup(
            jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchFromNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchToNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpnSearchLayout.setVerticalGroup(
            jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSearchLayout.createSequentialGroup()
                .addGroup(jpnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearchFromNgay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnSearchLayout.createSequentialGroup()
                        .addComponent(jbtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbtReset1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchToNgay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        jpnHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tableHD.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Ngày lập", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tableHD);

        jlbTongDoanhThu1.setBackground(new java.awt.Color(255, 255, 255));
        jlbTongDoanhThu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbTongDoanhThu1.setForeground(java.awt.Color.red);
        jlbTongDoanhThu1.setText("Tổng doanh thu: ");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(jlbTongDoanhThu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTongDoanhThu1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnThongKeSP.setBackground(new java.awt.Color(255, 255, 255));
        jpnThongKeSP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm tiêu thụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jpnThongKeSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tableTKbySP1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableTKbySP1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Tổng số lượng"
            }
        ));
        jScrollPane2.setViewportView(tableTKbySP1);

        tableTKbyNgay1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableTKbyNgay1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Mã SP", "Tên SP", "Số lượng"
            }
        ));
        jScrollPane3.setViewportView(tableTKbyNgay1);

        javax.swing.GroupLayout jpnThongKeSPLayout = new javax.swing.GroupLayout(jpnThongKeSP);
        jpnThongKeSP.setLayout(jpnThongKeSPLayout);
        jpnThongKeSPLayout.setHorizontalGroup(
            jpnThongKeSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnThongKeSPLayout.setVerticalGroup(
            jpnThongKeSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeSPLayout.createSequentialGroup()
                .addGroup(jpnThongKeSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnHDLayout = new javax.swing.GroupLayout(jpnHD);
        jpnHD.setLayout(jpnHDLayout);
        jpnHDLayout.setHorizontalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnHDLayout.createSequentialGroup()
                        .addComponent(jpnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnHDLayout.createSequentialGroup()
                        .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnThongKeSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnHDLayout.setVerticalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnThongKeSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hóa Đơn", jpnHD);

        jpnPN.setBackground(new java.awt.Color(255, 255, 255));

        jpnSearch1.setBackground(new java.awt.Color(255, 255, 255));
        jpnSearch1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jbtSearch2.setBackground(new java.awt.Color(0, 204, 0));
        jbtSearch2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtSearch2.setForeground(new java.awt.Color(255, 255, 255));
        jbtSearch2.setText("Tìm kiếm");
        jbtSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearch2ActionPerformed(evt);
            }
        });

        jbtReset2.setBackground(new java.awt.Color(0, 204, 0));
        jbtReset2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtReset2.setForeground(new java.awt.Color(255, 255, 255));
        jbtReset2.setText("Làm mới");
        jbtReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtReset2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Đến ngày");

        txtSearchFromNgay2.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchFromNgay2.setDateFormatString("dd/MM/yyyy");
        txtSearchFromNgay2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchFromNgay2.setMaxSelectableDate(new java.util.Date(253370743263000L));
        txtSearchFromNgay2.setMinSelectableDate(new java.util.Date(-62135791137000L));
        txtSearchFromNgay2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchFromNgay2MouseClicked(evt);
            }
        });
        txtSearchFromNgay2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchFromNgay2KeyReleased(evt);
            }
        });

        txtSearchToNgay2.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchToNgay2.setDateFormatString("dd/MM/yyyy");
        txtSearchToNgay2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchToNgay2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchToNgay2MouseClicked(evt);
            }
        });
        txtSearchToNgay2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchToNgay2KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Từ ngày");

        javax.swing.GroupLayout jpnSearch1Layout = new javax.swing.GroupLayout(jpnSearch1);
        jpnSearch1.setLayout(jpnSearch1Layout);
        jpnSearch1Layout.setHorizontalGroup(
            jpnSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSearch1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtSearchFromNgay2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchToNgay2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpnSearch1Layout.setVerticalGroup(
            jpnSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSearch1Layout.createSequentialGroup()
                .addGroup(jpnSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtReset2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnSearch1Layout.createSequentialGroup()
                        .addGroup(jpnSearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtSearch2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearchToNgay2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearchFromNgay2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpnThongKeSP1.setBackground(new java.awt.Color(255, 255, 255));
        jpnThongKeSP1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm nhập vào", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jpnThongKeSP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tableTKbySP2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableTKbySP2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Tổng số lượng"
            }
        ));
        jScrollPane4.setViewportView(tableTKbySP2);

        tableTKbyNgay2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableTKbyNgay2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Mã SP", "Tên SP", "Số lượng"
            }
        ));
        jScrollPane5.setViewportView(tableTKbyNgay2);

        javax.swing.GroupLayout jpnThongKeSP1Layout = new javax.swing.GroupLayout(jpnThongKeSP1);
        jpnThongKeSP1.setLayout(jpnThongKeSP1Layout);
        jpnThongKeSP1Layout.setHorizontalGroup(
            jpnThongKeSP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeSP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnThongKeSP1Layout.setVerticalGroup(
            jpnThongKeSP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeSP1Layout.createSequentialGroup()
                .addGroup(jpnThongKeSP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jpnHoaDon1.setBackground(new java.awt.Color(255, 255, 255));
        jpnHoaDon1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tablePN.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tablePN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã PN", "Ngày lập", "Tổng tiền"
            }
        ));
        jScrollPane6.setViewportView(tablePN);

        jlbTongDoanhThu2.setBackground(new java.awt.Color(255, 255, 255));
        jlbTongDoanhThu2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbTongDoanhThu2.setForeground(java.awt.Color.red);
        jlbTongDoanhThu2.setText("Tổng : ");

        javax.swing.GroupLayout jpnHoaDon1Layout = new javax.swing.GroupLayout(jpnHoaDon1);
        jpnHoaDon1.setLayout(jpnHoaDon1Layout);
        jpnHoaDon1Layout.setHorizontalGroup(
            jpnHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDon1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(jlbTongDoanhThu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnHoaDon1Layout.setVerticalGroup(
            jpnHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDon1Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTongDoanhThu2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnPNLayout = new javax.swing.GroupLayout(jpnPN);
        jpnPN.setLayout(jpnPNLayout);
        jpnPNLayout.setHorizontalGroup(
            jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPNLayout.createSequentialGroup()
                        .addComponent(jpnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnPNLayout.createSequentialGroup()
                        .addComponent(jpnHoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnThongKeSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnPNLayout.setVerticalGroup(
            jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnHoaDon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThongKeSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phiếu nhập", jpnPN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearch1ActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String Ngayban1 = format.format(txtSearchFromNgay1.getDate());
            String Ngayban2 = format.format(txtSearchToNgay1.getDate());

            //java.util.date
            java.util.Date ngayban1 = format.parse(Ngayban1);
            java.util.Date ngayban2 = format.parse(Ngayban2);
            //java,sql.date
            java.sql.Date sqlNgayban1 = new java.sql.Date(ngayban1.getTime());
            java.sql.Date sqlNgayban2 = new java.sql.Date(ngayban2.getTime());

            ModelHD.setRowCount(0);
            setDataHDtable(hoadonService.getListHDbyNgayBan(sqlNgayban1, sqlNgayban2));
            
            ModelTKbySP1.setRowCount(0);
            setDataTKbySP1(thongkeService.getListTKbySP1_2(sqlNgayban1, sqlNgayban2));
            
            ModelTKbyNgay1.setRowCount(0);
            setDataTKbyNgay1(thongkeService.getListTKbyNgay1_2(sqlNgayban1, sqlNgayban2));

            TongDoanhThu();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Vui nhập lại thời gian cần tìm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtSearch1ActionPerformed

    private void jbtReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtReset1ActionPerformed
        LamMoi1();
    }//GEN-LAST:event_jbtReset1ActionPerformed

    private void jbtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearch2ActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String Ngaynhap1 = format.format(txtSearchFromNgay2.getDate());
            String Ngaynhap2 = format.format(txtSearchToNgay2.getDate());

            //java.util.date
            java.util.Date ngaynhap1 = format.parse(Ngaynhap1);
            java.util.Date ngaynhap2 = format.parse(Ngaynhap2);
            //java,sql.date
            java.sql.Date sqlNgaynhap1 = new java.sql.Date(ngaynhap1.getTime());
            java.sql.Date sqlNgaynhap2 = new java.sql.Date(ngaynhap2.getTime());

            ModelPN.setRowCount(0);
            setDataPNtable(phieunhapService.getListPNbyNgayNhap(sqlNgaynhap1, sqlNgaynhap2));

            ModelTKbySP2.setRowCount(0);
            setDataTKbySP2(thongkeService.getListTKbySP2_2(sqlNgaynhap1, sqlNgaynhap2));

            ModelTKbyNgay2.setRowCount(0);
            setDataTKbyNgay2(thongkeService.getListTKbyNgay2_2(sqlNgaynhap1, sqlNgaynhap2));

            TongTienDaThanhToan();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Vui nhập lại thời gian cần tìm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtSearch2ActionPerformed

    private void jbtReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtReset2ActionPerformed
        LamMoi2();
    }//GEN-LAST:event_jbtReset2ActionPerformed

    private void txtSearchFromNgay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchFromNgay1MouseClicked

    }//GEN-LAST:event_txtSearchFromNgay1MouseClicked

    private void txtSearchFromNgay1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFromNgay1KeyReleased

    }//GEN-LAST:event_txtSearchFromNgay1KeyReleased

    private void txtSearchToNgay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchToNgay1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchToNgay1MouseClicked

    private void txtSearchToNgay1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchToNgay1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchToNgay1KeyReleased

    private void txtSearchFromNgay2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchFromNgay2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFromNgay2MouseClicked

    private void txtSearchFromNgay2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFromNgay2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFromNgay2KeyReleased

    private void txtSearchToNgay2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchToNgay2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchToNgay2MouseClicked

    private void txtSearchToNgay2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchToNgay2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchToNgay2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtReset1;
    private javax.swing.JButton jbtReset2;
    private javax.swing.JButton jbtSearch1;
    private javax.swing.JButton jbtSearch2;
    private javax.swing.JLabel jlbTongDoanhThu1;
    private javax.swing.JLabel jlbTongDoanhThu2;
    private javax.swing.JPanel jpnHD;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnHoaDon1;
    private javax.swing.JPanel jpnPN;
    private javax.swing.JPanel jpnSearch;
    private javax.swing.JPanel jpnSearch1;
    private javax.swing.JPanel jpnThongKeSP;
    private javax.swing.JPanel jpnThongKeSP1;
    private javax.swing.JTable tableHD;
    private javax.swing.JTable tablePN;
    private javax.swing.JTable tableTKbyNgay1;
    private javax.swing.JTable tableTKbyNgay2;
    private javax.swing.JTable tableTKbySP1;
    private javax.swing.JTable tableTKbySP2;
    private com.toedter.calendar.JDateChooser txtSearchFromNgay1;
    private com.toedter.calendar.JDateChooser txtSearchFromNgay2;
    private com.toedter.calendar.JDateChooser txtSearchToNgay1;
    private com.toedter.calendar.JDateChooser txtSearchToNgay2;
    // End of variables declaration//GEN-END:variables
}
