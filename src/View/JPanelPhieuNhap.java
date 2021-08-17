/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import Service.*;
import java.awt.*;
import java.text.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NHT_Kurumi
 */
public class JPanelPhieuNhap extends javax.swing.JPanel {

    SanPhamService sanphamService;
    PhieuNhapService phieunhapService;
    CTPhieuNhapService ctphieunhapService;
    private DefaultTableModel ModelCTPN;
    private DefaultTableModel ModelPN;
    /**
     * Creates new form PhieuNhapJPanel
     */
    public JPanelPhieuNhap() {
        initComponents();
        setBackground(Color.WHITE);
        LamMoi();
        
        txtSearchMaPN.setToolTipText("Nhập mã hóa đơn!");
        txtSearchNgay1.setToolTipText("dd/mm/yyyy");
        txtSearchNgay2.setToolTipText("dd/mm/yyyy");
    }

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
        
        tablePN.getColumnModel().getColumn(0).setMinWidth(60);
        tablePN.getColumnModel().getColumn(0).setMaxWidth(60);
        tablePN.getColumnModel().getColumn(1).setMinWidth(150);
        tablePN.getColumnModel().getColumn(1).setMaxWidth(150);
        tablePN.getColumnModel().getColumn(2).setMinWidth(100);
        tablePN.getColumnModel().getColumn(2).setMinWidth(100);
        tablePN.getColumnModel().getColumn(3).setMinWidth(150);
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
    
    private void TableCTPN(){
        ctphieunhapService = new CTPhieuNhapService();
        ModelCTPN = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        tableCTPN.setModel(ModelCTPN);
        ModelCTPN.addColumn("Mã HD");
        ModelCTPN.addColumn("Mã SP");
        ModelCTPN.addColumn("STT");
        ModelCTPN.addColumn("Tên sản phẩm");
        ModelCTPN.addColumn("Đơn vị");
        ModelCTPN.addColumn("Số lượng");
        ModelCTPN.addColumn("Đơn giá");
        ModelCTPN.addColumn("Thành tiền");
        
        //Giảm đọ dài cột đầu tiên của tableCTPN về 0
        tableCTPN.getColumnModel().getColumn(0).setMinWidth(0);
        tableCTPN.getColumnModel().getColumn(0).setMaxWidth(0);
        tableCTPN.getColumnModel().getColumn(1).setMinWidth(0);
        tableCTPN.getColumnModel().getColumn(1).setMaxWidth(0);
        tableCTPN.getColumnModel().getColumn(2).setMinWidth(50);
        tableCTPN.getColumnModel().getColumn(2).setMaxWidth(50);
        tableCTPN.getColumnModel().getColumn(3).setMinWidth(280);
        tableCTPN.getColumnModel().getColumn(3).setMaxWidth(280);
        tableCTPN.getColumnModel().getColumn(4).setMinWidth(120);
        tableCTPN.getColumnModel().getColumn(4).setMaxWidth(120);
        tableCTPN.getColumnModel().getColumn(5).setMinWidth(100);
        tableCTPN.getColumnModel().getColumn(5).setMaxWidth(100);
        tableCTPN.getColumnModel().getColumn(6).setMinWidth(150);
        tableCTPN.getColumnModel().getColumn(6).setMaxWidth(150);
        tableCTPN.getColumnModel().getColumn(7).setMinWidth(150);
        tableCTPN.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void setDataCTPNtable(List<CTPhieuNhap> CTPNlist){
        for(CTPhieuNhap ctpn : CTPNlist){
            ModelCTPN.addRow(new Object[]{
                ctpn.getMapn(), ctpn.getMasp(), 
                ModelCTPN.getRowCount() + 1, 
                ctpn.getTensp(), ctpn.getDvtinh(), 
                String.valueOf(ctpn.getSoluongnhap()),
                String.format("%.0f", ctpn.getDongianhap()),
                String.format("%.0f", ctpn.getThanhtien())
            });
        }
    }
    
    private void LamMoi(){
        TablePN();
        TableCTPN();
        
        txtSearchMaPN.setText("");
        txtMaPN.setText("");
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
        tablePN = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtSearchMaPN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtReset = new javax.swing.JButton();
        jbtEditPN = new javax.swing.JButton();
        jbtDeletePN = new javax.swing.JButton();
        jbtAddPN = new javax.swing.JButton();
        txtSearchNgay1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jbtSearch = new javax.swing.JButton();
        txtSearchNgay2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTPN = new javax.swing.JTable();
        txtMaPN = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tablePN.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tablePN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã PN", "Tổng tiền", "Ngày lập"
            }
        ));
        tablePN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePN);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtSearchMaPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearchMaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchMaPNActionPerformed(evt);
            }
        });
        txtSearchMaPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMaPNKeyReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã PN");

        jbtReset.setBackground(new java.awt.Color(0, 204, 0));
        jbtReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtReset.setForeground(new java.awt.Color(255, 255, 255));
        jbtReset.setText("Làm mới");
        jbtReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResetActionPerformed(evt);
            }
        });

        jbtEditPN.setBackground(new java.awt.Color(0, 204, 0));
        jbtEditPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtEditPN.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditPN.setText("Sửa");
        jbtEditPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditPNActionPerformed(evt);
            }
        });

        jbtDeletePN.setBackground(new java.awt.Color(255, 51, 0));
        jbtDeletePN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtDeletePN.setForeground(new java.awt.Color(255, 255, 255));
        jbtDeletePN.setText("Xóa");
        jbtDeletePN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeletePNActionPerformed(evt);
            }
        });

        jbtAddPN.setBackground(new java.awt.Color(0, 204, 0));
        jbtAddPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtAddPN.setForeground(new java.awt.Color(255, 255, 255));
        jbtAddPN.setText("Thêm");
        jbtAddPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddPNActionPerformed(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Đến ngày");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Từ ngày");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtDeletePN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(txtSearchMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jbtAddPN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jbtEditPN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearchNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchNgay2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtSearchNgay2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtAddPN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtDeletePN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtEditPN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tableCTPN.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Đơn vị", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tableCTPN);

        txtMaPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        txtNgayLap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mã  PN");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ngày lập");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tổng tiền");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablePNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePNMouseClicked
        try {
            int row = tablePN.getSelectedRow();
            String MaPN = String.valueOf(tablePN.getValueAt(row, 1));
            PhieuNhap pn = phieunhapService.getPhieuNhapByMaPN(MaPN);

            txtMaPN.setText(pn.getMapn());
            DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            txtNgayLap.setText(dateformat.format(pn.getNgaynhap()).toString());
            txtTongTien.setText(String.format("%.0f", pn.getTonggianhap()));

            //Load tableCTHD
            ModelCTPN.setRowCount(0);
            ctphieunhapService = new CTPhieuNhapService();
            setDataCTPNtable(ctphieunhapService.getListCTPNbyMaPN(MaPN));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tablePNMouseClicked

    private void txtSearchMaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchMaPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMaPNActionPerformed

    private void txtSearchMaPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaPNKeyReleased
        String TuKhoa = "%"+ txtSearchMaPN.getText() +"%";

        ModelPN.setRowCount(0);
        setDataPNtable(phieunhapService.getListPNbyMaPN(TuKhoa));
    }//GEN-LAST:event_txtSearchMaPNKeyReleased

    private void jbtResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResetActionPerformed
        LamMoi();
    }//GEN-LAST:event_jbtResetActionPerformed

    private void jbtEditPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditPNActionPerformed
        int row = tablePN.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập cần sửa!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JFramePhieuNhapEdit edit = new JFramePhieuNhapEdit();
            edit.setLocationRelativeTo(null);//Hiện giữa màn hình
            edit.setVisible(true);
        }
    }//GEN-LAST:event_jbtEditPNActionPerformed

    private void jbtDeletePNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeletePNActionPerformed
        int row = tablePN.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập xóa!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else{
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Thông báo",JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION){
                String MaHD = String.valueOf(tablePN.getValueAt(row, 1));

                ctphieunhapService.deleteCTPhieuNhap(MaHD);
                phieunhapService.deletePhieuNhap(MaHD);

                ModelPN.setRowCount(0);
                setDataPNtable(phieunhapService.getListPN());

                LamMoi();
            }
        }
    }//GEN-LAST:event_jbtDeletePNActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void jbtAddPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddPNActionPerformed
        JFramePhieuNhapAdd add = new JFramePhieuNhapAdd();
        add.setLocationRelativeTo(null);//Hiện giữa màn hình
        add.setVisible(true);
    }//GEN-LAST:event_jbtAddPNActionPerformed

    private void txtSearchNgay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNgay1MouseClicked

    }//GEN-LAST:event_txtSearchNgay1MouseClicked

    private void txtSearchNgay1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNgay1KeyReleased

    }//GEN-LAST:event_txtSearchNgay1KeyReleased

    private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String Ngaynhap1 = format.format(txtSearchNgay1.getDate());
            String Ngaynhap2 = format.format(txtSearchNgay2.getDate());

            //java.util.date
            java.util.Date ngaynhap1 = format.parse(Ngaynhap1);
            java.util.Date ngaynhap2 = format.parse(Ngaynhap2);
            //java,sql.date
            java.sql.Date sqlNgaynhap1 = new java.sql.Date(ngaynhap1.getTime());
            java.sql.Date sqlNgaynhap2 = new java.sql.Date(ngaynhap2.getTime());

            ModelPN.setRowCount(0);
            setDataPNtable(phieunhapService.getListPNbyNgayNhap(sqlNgaynhap1, sqlNgaynhap2));
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
    private javax.swing.JButton jbtAddPN;
    private javax.swing.JButton jbtDeletePN;
    private javax.swing.JButton jbtEditPN;
    private javax.swing.JButton jbtReset;
    private javax.swing.JButton jbtSearch;
    private javax.swing.JTable tableCTPN;
    public static javax.swing.JTable tablePN;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSearchMaPN;
    private com.toedter.calendar.JDateChooser txtSearchNgay1;
    private com.toedter.calendar.JDateChooser txtSearchNgay2;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
