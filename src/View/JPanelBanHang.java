/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import CodeFrame.CodeBanHang;
import Model.*;
import Service.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author NHT_Kurumi
 */
public class JPanelBanHang extends javax.swing.JPanel {

    
    JFrameBanHangSLM addSLM;
    SanPhamService sanphamService;
    HoaDonService hoadonService;
    CTHoaDonService cthoadonService;
    CodeBanHang cbh;
    private DefaultTableModel ModelSP;
    private DefaultTableModel ModelCTHD;
    /**
     * Creates new form BanHangJPanel
     */
    public JPanelBanHang() {
        initComponents();
        LamMoi();
        
        //Tạo ngày hiện tại, chuyển string -> date
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        long millis=System.currentTimeMillis();   
        java.sql.Date d=new java.sql.Date(millis);
        txtNgayBan.setText(dateformat.format(d).toString());
        
        txtSearchSP.setToolTipText("Từ khóa phải có trong tên sản phẩm!");
    }

    private void TableSP(){
        sanphamService = new SanPhamService();
        
        ModelSP = new DefaultTableModel(){
            @Override //Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        tableSP.setModel(ModelSP);
        ModelSP.addColumn("Mã SP");
        ModelSP.addColumn("Tên SP");
        ModelSP.addColumn("SL");
        ModelSP.addColumn("Đơn giá");
        
        tableSP.getColumnModel().getColumn(0).setMinWidth(50);
        tableSP.getColumnModel().getColumn(0).setMaxWidth(50);
        tableSP.getColumnModel().getColumn(1).setMinWidth(235);
        tableSP.getColumnModel().getColumn(1).setMaxWidth(235);
        tableSP.getColumnModel().getColumn(2).setMinWidth(40);
        tableSP.getColumnModel().getColumn(2).setMaxWidth(40);
        tableSP.getColumnModel().getColumn(3).setMinWidth(65);
        tableSP.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        
        setDataSPtable(sanphamService.getListSP());
    }

    private void setDataSPtable(List<SanPham> SPlist){
        for(SanPham sp : SPlist){
            ModelSP.addRow(new Object[]{
                sp.getMasp(), sp.getTensp(), sp.getSoluong(), 
                String.format("%.0f",sp.getDongiaban())
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
        tableCTHD.getColumnModel().getColumn(1).setMinWidth(50);
        tableCTHD.getColumnModel().getColumn(1).setMaxWidth(50);
        tableCTHD.getColumnModel().getColumn(2).setMinWidth(250);
        tableCTHD.getColumnModel().getColumn(2).setMaxWidth(300);
        tableCTHD.getColumnModel().getColumn(3).setMinWidth(130);
        tableCTHD.getColumnModel().getColumn(3).setMaxWidth(130);
        tableCTHD.getColumnModel().getColumn(4).setMinWidth(110);
        tableCTHD.getColumnModel().getColumn(4).setMaxWidth(110);
        tableCTHD.getColumnModel().getColumn(5).setMinWidth(180);
        tableCTHD.getColumnModel().getColumn(5).setMaxWidth(180);
        tableCTHD.getColumnModel().getColumn(6).setMinWidth(180);
        tableCTHD.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void setDataCTHDtable(SanPham sp, String SLMua) {
        ModelCTHD.addRow(new Object[]{
            sp.getMasp(),ModelCTHD.getRowCount()+1, sp.getTensp(), 
            sp.getDvtinh(), SLMua, String.format("%.0f",sp.getDongiaban()), 
            String.format("%.0f", Float.parseFloat(SLMua) * sp.getDongiaban())
            });
        
    }
    
    private void ThanhToan(){
        txtTongTien.setText(cbh.TinhTongTien(tableCTHD));
        Float TongTien = Float.valueOf(txtTongTien.getText().toString());
        Float TienKhachTra = Float.valueOf(txtTienKhachTra.getText().toString());
        float ThanhToan = TienKhachTra - TongTien;
        txtTienTraKhach.setText(String.format("%.0f", ThanhToan));
    }
    
    private void LamMoi(){
        TableSP();
        TableCTHD();
        ThanhToan();
        
        //Load Item combobox
        jcbDVTinh.removeAllItems();
        sanphamService = new SanPhamService();
        sanphamService.loadDataComboBox(this.jcbDVTinh);

        //Làm mới mã hóa đơn
        txtMaHD.setText(cbh.TaoMaHD());
        txtSearchSP.setText("");
        txtSLMua.setText("1");
        txtTongTien.setText("0");
        txtTienKhachTra.setText("0");
        txtTienTraKhach.setText("0");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnCTHD = new javax.swing.JPopupMenu();
        mniDeleteSP = new javax.swing.JMenuItem();
        mniEditSP = new javax.swing.JMenuItem();
        panelHoaDon = new javax.swing.JPanel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgayBan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTHD = new javax.swing.JTable();
        txtTienKhachTra = new javax.swing.JTextField();
        txtTienTraKhach = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtThanhToan = new javax.swing.JButton();
        jbtHuy = new javax.swing.JButton();
        panelSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSP = new javax.swing.JTable();
        txtSearchSP = new javax.swing.JTextField();
        jcbDVTinh = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSLMua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbtSelectSP = new javax.swing.JButton();

        mniDeleteSP.setText("Xóa sản phẩm");
        mniDeleteSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteSPActionPerformed(evt);
            }
        });
        pmnCTHD.add(mniDeleteSP);

        mniEditSP.setText("Sửa sản phẩm");
        mniEditSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditSPActionPerformed(evt);
            }
        });
        pmnCTHD.add(mniEditSP);

        setBackground(new java.awt.Color(255, 255, 255));

        panelHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        panelHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtMaHD.setEditable(false);
        txtMaHD.setBackground(new java.awt.Color(255, 255, 255));
        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã HD");

        txtNgayBan.setEditable(false);
        txtNgayBan.setBackground(new java.awt.Color(255, 255, 255));
        txtNgayBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNgayBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ngày lập");

        tableCTHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableCTHD.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Đon vị", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tableCTHD.setComponentPopupMenu(pmnCTHD);
        tableCTHD.setGridColor(new java.awt.Color(255, 255, 255));
        tableCTHD.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tableCTHDComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(tableCTHD);

        txtTienKhachTra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTienKhachTra.setText("0");
        txtTienKhachTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachTraActionPerformed(evt);
            }
        });
        txtTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachTraKeyReleased(evt);
            }
        });

        txtTienTraKhach.setEditable(false);
        txtTienTraKhach.setBackground(new java.awt.Color(255, 255, 255));
        txtTienTraKhach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTienTraKhach.setText("0");
        txtTienTraKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienTraKhachActionPerformed(evt);
            }
        });

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(255, 255, 255));
        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.setText("0");
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tiền khách trả");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tiền trả khách");

        jbtThanhToan.setBackground(new java.awt.Color(0, 204, 0));
        jbtThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        jbtThanhToan.setText("Thanh toán");
        jbtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThanhToanActionPerformed(evt);
            }
        });

        jbtHuy.setBackground(new java.awt.Color(204, 0, 0));
        jbtHuy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtHuy.setForeground(new java.awt.Color(255, 255, 255));
        jbtHuy.setText("Hủy");
        jbtHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelHoaDonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jbtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelHoaDonLayout.setVerticalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelSanPham.setBackground(new java.awt.Color(255, 255, 255));
        panelSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tableSP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableSP.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "SL", "Đơn giá"
            }
        ));
        tableSP.setGridColor(new java.awt.Color(255, 255, 255));
        tableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSPMouseClicked(evt);
            }
        });
        tableSP.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tableSPComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tableSP);

        txtSearchSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearchSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchSPActionPerformed(evt);
            }
        });
        txtSearchSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSPKeyReleased(evt);
            }
        });

        jcbDVTinh.setBackground(new java.awt.Color(0, 153, 255));
        jcbDVTinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbDVTinh.setForeground(new java.awt.Color(255, 255, 255));
        jcbDVTinh.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDVTinhPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcbDVTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDVTinhActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Chọn đơn vị tính");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nhập từ khóa");

        txtSLMua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSLMua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLMuaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Nhập số lượng");

        jbtSelectSP.setBackground(new java.awt.Color(0, 204, 0));
        jbtSelectSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtSelectSP.setForeground(new java.awt.Color(255, 255, 255));
        jbtSelectSP.setText("Thêm");
        jbtSelectSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSelectSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSanPhamLayout = new javax.swing.GroupLayout(panelSanPham);
        panelSanPham.setLayout(panelSanPhamLayout);
        panelSanPhamLayout.setHorizontalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(txtSLMua, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtSelectSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jcbDVTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        panelSanPhamLayout.setVerticalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDVTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSelectSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLMua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachTraActionPerformed
        ThanhToan();
    }//GEN-LAST:event_txtTienKhachTraActionPerformed

    private void txtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachTraKeyReleased

    }//GEN-LAST:event_txtTienKhachTraKeyReleased

    private void txtTienTraKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienTraKhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienTraKhachActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed

    }//GEN-LAST:event_txtTongTienActionPerformed

    private void jbtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThanhToanActionPerformed
        if (Float.parseFloat(txtTienKhachTra.getText()) <= Float.parseFloat(txtTongTien.getText())) {
            JOptionPane.showMessageDialog(this, "Số tiền khách trả nhỏ hơn tổng tiền!");
            txtTienKhachTra.requestFocusInWindow();
        } else{
            //Thêm hóa đơn
            HoaDon hd = new HoaDon();
            hoadonService = new HoaDonService();
            hd.setMahd(txtMaHD.getText().toString());
            long millis = System.currentTimeMillis();
            hd.setNgayban(new java.sql.Date(millis));
            hd.setTonggiaban(Float.parseFloat(txtTongTien.getText()));
            hoadonService.addHoaDon(hd);

            //Thêm cthd
            cbh = new CodeBanHang();
            cbh.ThemCTHD(tableCTHD, txtMaHD.getText().toString());

            LamMoi();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
        }
    }//GEN-LAST:event_jbtThanhToanActionPerformed

    private void jbtHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHuyActionPerformed
        LamMoi();
        
    }//GEN-LAST:event_jbtHuyActionPerformed

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtNgayBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBanActionPerformed

    
    private void tableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSPMouseClicked

    }//GEN-LAST:event_tableSPMouseClicked

    private void tableSPComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tableSPComponentShown

    }//GEN-LAST:event_tableSPComponentShown

    private void txtSearchSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchSPActionPerformed

    private void txtSearchSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSPKeyReleased
        String TuKhoa = "%"+ txtSearchSP.getText() +"%";

        ModelSP.setRowCount(0);
        setDataSPtable(sanphamService.getListSPbyTenSP(tableSP, TuKhoa));
    }//GEN-LAST:event_txtSearchSPKeyReleased

    private void jcbDVTinhPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDVTinhPopupMenuWillBecomeInvisible
        //Tìm kiếm bằng Jcombobox
        try {
            String SPdvtinh = (String) this.jcbDVTinh.getSelectedItem();

            //Làm mới mỗi lần tìm kiếm tableSP
            ModelSP.setRowCount(0);
            setDataSPtable(sanphamService.getListSPbyDVTinh(SPdvtinh));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jcbDVTinhPopupMenuWillBecomeInvisible

    private void jcbDVTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDVTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDVTinhActionPerformed

    private void txtSLMuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLMuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLMuaActionPerformed

    private void tableCTHDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tableCTHDComponentShown

    }//GEN-LAST:event_tableCTHDComponentShown

    private void mniDeleteSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteSPActionPerformed
        try {
            int row = tableCTHD.getSelectedRow();

            ModelCTHD.removeRow(row);
            for (int i = 0; i < tableCTHD.getRowCount(); i++) {
                tableCTHD.setValueAt(i + 1, i, 1);//reset STT                  
            }
            ThanhToan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mniDeleteSPActionPerformed
    public static String SLMua;
    private void mniEditSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditSPActionPerformed
        int row = tableCTHD.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JFrameBanHangSLM addSLM = new JFrameBanHangSLM();
            addSLM.setLocationRelativeTo(null);
            addSLM.setVisible(true);
        }
    }//GEN-LAST:event_mniEditSPActionPerformed

    private void jbtSelectSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSelectSPActionPerformed
        try {
            int row = tableSP.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                SLMua = txtSLMua.getText();
                if (Integer.parseInt(SLMua) <= 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập lại số lượng mua!");
                    txtSLMua.requestFocusInWindow();
                } else {
                    String MaSPtableSP = tableSP.getValueAt(row, 0).toString();
                    SanPham sp = sanphamService.getSanPhamByMaSP(MaSPtableSP);

                    // sao chép dữ liệu từ table vào list
                    //Chuyển về vector
                    Vector data = ModelCTHD.getDataVector();
                    // sao chép dữ liệu từ table vào list
                    int mColIndex = 0;
                    List colData = new ArrayList(tableCTHD.getRowCount());
                    for (int i = 0; i < tableCTHD.getRowCount(); i++) {
                        Vector row2 = (Vector) data.elementAt(i);
                        colData.add(row2.get(mColIndex));
                    }
                    //so sánh với mã sp trong list vừa có
                    if (colData.contains(MaSPtableSP)) {
                        JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong hóa đơn!", "Error Warning", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //Kiểm tra số lượng nhập vào
                        int SL = Integer.valueOf(tableSP.getValueAt(row, 2).toString());
                        if (Integer.valueOf(SLMua) > SL) {
                            JOptionPane.showMessageDialog(this, "số lượng mua lớn hơn số lượng tồn!");
                            txtSLMua.requestFocusInWindow();
                        } else {

                            //Lấy dữ liệu từ tableSP và SLMua từ Frame SoLuongMua sang tableCTHD
                            setDataCTHDtable(sp, SLMua);
                            
                            txtSLMua.requestFocusInWindow();
                            //Làm mới tiền trả
                            ThanhToan();
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại số lượng mua!");
            txtSLMua.requestFocusInWindow();
        }
    }//GEN-LAST:event_jbtSelectSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtHuy;
    public static javax.swing.JButton jbtSelectSP;
    private javax.swing.JButton jbtThanhToan;
    private javax.swing.JComboBox<String> jcbDVTinh;
    private javax.swing.JMenuItem mniDeleteSP;
    private javax.swing.JMenuItem mniEditSP;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JPopupMenu pmnCTHD;
    public static javax.swing.JTable tableCTHD;
    public static javax.swing.JTable tableSP;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayBan;
    public static javax.swing.JTextField txtSLMua;
    private javax.swing.JTextField txtSearchSP;
    public static javax.swing.JTextField txtTienKhachTra;
    public static javax.swing.JTextField txtTienTraKhach;
    public static javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
