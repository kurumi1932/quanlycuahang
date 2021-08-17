/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import Service.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NHT_Kurumi
 */
public class JPanelHoaDon extends javax.swing.JPanel {
    
    SanPhamService sanphamService;
    HoaDonService hoadonService;
    CTHoaDonService cthoadonService;
    private DefaultTableModel ModelCTHD;
    private DefaultTableModel ModelHD;
    /**
     * Creates new form HoaDonJPanel
     */
    public JPanelHoaDon() {
        initComponents();
        setBackground(Color.WHITE);
        
        LamMoi();
        
        txtSearchMaHD.setToolTipText("Nhập mã hóa đơn!");
        txtSearchNgay1.setToolTipText("dd/mm/yyyy");
        txtSearchNgay2.setToolTipText("dd/mm/yyyy");
    }
    
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
        
        tableHD.getColumnModel().getColumn(0).setMinWidth(60);
        tableHD.getColumnModel().getColumn(0).setMaxWidth(60);
        tableHD.getColumnModel().getColumn(1).setMinWidth(150);
        tableHD.getColumnModel().getColumn(1).setMaxWidth(150);
        tableHD.getColumnModel().getColumn(2).setMinWidth(100);
        tableHD.getColumnModel().getColumn(2).setMinWidth(100);
        tableHD.getColumnModel().getColumn(3).setMinWidth(150);
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
    
    private void TableCTHD(){
        cthoadonService = new CTHoaDonService();
        ModelCTHD = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        tableCTHD.setModel(ModelCTHD);
        ModelCTHD.addColumn("Mã HD");
        ModelCTHD.addColumn("Mã SP");
        ModelCTHD.addColumn("STT");
        ModelCTHD.addColumn("Tên sản phẩm");
        ModelCTHD.addColumn("Đơn vị");
        ModelCTHD.addColumn("Số lượng");
        ModelCTHD.addColumn("Đơn giá");
        ModelCTHD.addColumn("Thành tiền");
        
        //Giảm đọ dài cột đầu tiên của tableCTHD về 0
        tableCTHD.getColumnModel().getColumn(0).setMinWidth(0);
        tableCTHD.getColumnModel().getColumn(0).setMaxWidth(0);
        tableCTHD.getColumnModel().getColumn(1).setMinWidth(0);
        tableCTHD.getColumnModel().getColumn(1).setMaxWidth(0);
        tableCTHD.getColumnModel().getColumn(2).setMinWidth(50);
        tableCTHD.getColumnModel().getColumn(2).setMaxWidth(50);
        tableCTHD.getColumnModel().getColumn(3).setMinWidth(280);
        tableCTHD.getColumnModel().getColumn(3).setMaxWidth(280);
        tableCTHD.getColumnModel().getColumn(4).setMinWidth(120);
        tableCTHD.getColumnModel().getColumn(4).setMaxWidth(120);
        tableCTHD.getColumnModel().getColumn(5).setMinWidth(100);
        tableCTHD.getColumnModel().getColumn(5).setMaxWidth(100);
        tableCTHD.getColumnModel().getColumn(6).setMinWidth(150);
        tableCTHD.getColumnModel().getColumn(6).setMaxWidth(150);
        tableCTHD.getColumnModel().getColumn(7).setMinWidth(150);
        tableCTHD.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    

    private void setDataCTHDtable(List<CTHoaDon> CTHDlist){
        for(CTHoaDon cthd : CTHDlist){
            ModelCTHD.addRow(new Object[]{
                cthd.getMahd(), cthd.getMasp(), 
                ModelCTHD.getRowCount() + 1, 
                cthd.getTensp(), cthd.getDvtinh(), 
                String.valueOf(cthd.getSoluongban()),
                String.format("%.0f", cthd.getDongiaban()),
                String.format("%.0f", cthd.getThanhtien())
            });
        }
    }
    
    private void LamMoi(){
        TableHD();
        TableCTHD();
        
        txtSearchMaHD.setText("");
        txtMaHD.setText("");
        txtNgayLap.setText("");
        txtTongTien.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTHD = new javax.swing.JTable();
        txtMaHD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSearchMaHD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtReset = new javax.swing.JButton();
        jbtEditHD = new javax.swing.JButton();
        jbtDeleteHD = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSearchNgay1 = new com.toedter.calendar.JDateChooser();
        jbtSearch = new javax.swing.JButton();
        txtSearchNgay2 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tableHD.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tổng tiền", "Ngày lập"
            }
        ));
        tableHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tableCTHD.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Đơn vị", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tableCTHD);

        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        txtNgayLap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã  HD");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ngày lập");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tổng tiền");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtSearchMaHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearchMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchMaHDActionPerformed(evt);
            }
        });
        txtSearchMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMaHDKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã HD");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Từ ngày");

        jbtReset.setBackground(new java.awt.Color(0, 204, 0));
        jbtReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtReset.setForeground(new java.awt.Color(255, 255, 255));
        jbtReset.setText("Làm mới");
        jbtReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResetActionPerformed(evt);
            }
        });

        jbtEditHD.setBackground(new java.awt.Color(0, 204, 0));
        jbtEditHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtEditHD.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditHD.setText("Sửa");
        jbtEditHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditHDActionPerformed(evt);
            }
        });

        jbtDeleteHD.setBackground(new java.awt.Color(255, 51, 0));
        jbtDeleteHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtDeleteHD.setForeground(new java.awt.Color(255, 255, 255));
        jbtDeleteHD.setText("Xóa");
        jbtDeleteHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteHDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Đến ngày");

        txtSearchNgay1.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchNgay1.setDateFormatString("dd/MM/yyyy");
        txtSearchNgay1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchNgay1.setMaxSelectableDate(new java.util.Date(253370743263000L));
        txtSearchNgay1.setMinSelectableDate(new java.util.Date(-62135791137000L));
        txtSearchNgay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchNgay1MouseClicked(evt);
            }
        });
        txtSearchNgay1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNgay1KeyReleased(evt);
            }
        });

        jbtSearch.setBackground(new java.awt.Color(0, 153, 255));
        jbtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_TimKiem.png"))); // NOI18N
        jbtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearchActionPerformed(evt);
            }
        });

        txtSearchNgay2.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchNgay2.setDateFormatString("dd/MM/yyyy");
        txtSearchNgay2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchNgay2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchNgay2MouseClicked(evt);
            }
        });
        txtSearchNgay2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNgay2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtReset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtEditHD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jbtDeleteHD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearchMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSearchNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchNgay2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchNgay2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchNgay1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtEditHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtDeleteHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHDMouseClicked
        try {
            int row = tableHD.getSelectedRow();
            String MaHD = String.valueOf(tableHD.getValueAt(row, 1));
            HoaDon hd = hoadonService.getHoaDonByMaHD(MaHD);
            
            txtMaHD.setText(hd.getMahd());
            DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            txtNgayLap.setText(dateformat.format(hd.getNgayban()).toString());
            txtTongTien.setText(String.format("%.0f", hd.getTonggiaban()));

            //Load tableCTHD
            ModelCTHD.setRowCount(0);
            cthoadonService = new CTHoaDonService();
            setDataCTHDtable(cthoadonService.getListCTHDbyMaHD(MaHD));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_tableHDMouseClicked

    private void jbtDeleteHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteHDActionPerformed
        int row = tableHD.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn xóa!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else{
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Thông báo",JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION){
                String MaHD = String.valueOf(tableHD.getValueAt(row, 1));
                
                
                cthoadonService.deleteCTHoaDon(MaHD);
                hoadonService.deleteHoaDon(MaHD);
                
                ModelHD.setRowCount(0);
                setDataHDtable(hoadonService.getListHD());
                
                LamMoi();
            }
        }
    }//GEN-LAST:event_jbtDeleteHDActionPerformed

    private void jbtEditHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditHDActionPerformed
        int row = tableHD.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần sửa!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JFrameHoaDonEdit editHD = new JFrameHoaDonEdit();
            editHD.setLocationRelativeTo(null);//Hiện giữa màn hình
            editHD.setVisible(true);
        }
    }//GEN-LAST:event_jbtEditHDActionPerformed

    private void txtSearchMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaHDKeyReleased
        String TuKhoa = "%"+ txtSearchMaHD.getText() +"%";
        
        ModelHD.setRowCount(0);
        setDataHDtable(hoadonService.getListHDbyMaHD(TuKhoa));
    }//GEN-LAST:event_txtSearchMaHDKeyReleased

    private void jbtResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResetActionPerformed
        LamMoi();
    }//GEN-LAST:event_jbtResetActionPerformed

    private void txtSearchMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMaHDActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtSearchNgay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNgay1MouseClicked

    }//GEN-LAST:event_txtSearchNgay1MouseClicked

    private void txtSearchNgay1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNgay1KeyReleased

    }//GEN-LAST:event_txtSearchNgay1KeyReleased

    private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String Ngayban1 = format.format(txtSearchNgay1.getDate());
            String Ngayban2 = format.format(txtSearchNgay2.getDate());

            //java.util.date
            java.util.Date ngayban1 = format.parse(Ngayban1);
            java.util.Date ngayban2 = format.parse(Ngayban2);
            //java,sql.date
            java.sql.Date sqlNgayban1 = new java.sql.Date(ngayban1.getTime());
            java.sql.Date sqlNgayban2 = new java.sql.Date(ngayban2.getTime());

            ModelHD.setRowCount(0);
            setDataHDtable(hoadonService.getListHDbyNgayBan(sqlNgayban1, sqlNgayban2));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Vui nhập lại thời gian cần tìm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtSearchActionPerformed

    private void txtSearchNgay2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNgay2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNgay2MouseClicked

    private void txtSearchNgay2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNgay2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNgay2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtDeleteHD;
    private javax.swing.JButton jbtEditHD;
    private javax.swing.JButton jbtReset;
    private javax.swing.JButton jbtSearch;
    private javax.swing.JTable tableCTHD;
    public static javax.swing.JTable tableHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSearchMaHD;
    private com.toedter.calendar.JDateChooser txtSearchNgay1;
    private com.toedter.calendar.JDateChooser txtSearchNgay2;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
