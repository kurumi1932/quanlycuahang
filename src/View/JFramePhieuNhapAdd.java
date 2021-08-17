/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import CodeFrame.*;
import Model.*;
import Service.*;
import java.awt.Color;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NHT_Kurumi
 */
public class JFramePhieuNhapAdd extends javax.swing.JFrame {

    SanPhamService sanphamService;
    PhieuNhapService phieunhapService;
    CTPhieuNhapService ctphieunhapService;
    CodeBanHang cbh;
    CodeAddPhieuNhap capn;
    private DefaultTableModel ModelSP;
    private DefaultTableModel ModelCTPN;
    public static String SLNhap;
    public static String DGNhap;
    /**
     * Creates new form AddHoaDon
     */
    public JFramePhieuNhapAdd() {
        initComponents();
        setTitle("Thêm phiếu nhập");
        setResizable(false);//Vô hiệu hóa nút phóng to
        getContentPane().setBackground(Color.WHITE);//Backgrounf đổi màu
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//Đóng Jframe khi click(x)
        
        LamMoi();
        
        //Tạo ngày hiện tại, chuyển string -> date
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        long millis=System.currentTimeMillis();   
        java.sql.Date d=new java.sql.Date(millis);
        txtNgayNhap.setText(dateformat.format(d).toString());
        
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
        tableSP.getColumnModel().getColumn(2).setMinWidth(30);
        tableSP.getColumnModel().getColumn(2).setMinWidth(30);
        tableSP.getColumnModel().getColumn(3).setMinWidth(60);
        tableSP.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataSPtable(sanphamService.getListSP());
    }

    private void setDataSPtable(List<SanPham> SPlist){
        for(SanPham sp : SPlist){
            ModelSP.addRow(new Object[]{
                sp.getMasp(), sp.getTensp(), 
                sp.getSoluong(), String.format("%.0f", sp.getDongiaban())
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
        ModelCTPN.addColumn("Mã SP");
        ModelCTPN.addColumn("STT");
        ModelCTPN.addColumn("Tên sản phẩm");
        ModelCTPN.addColumn("Đơn vị");
        ModelCTPN.addColumn("Số lượng");
        ModelCTPN.addColumn("Đơn giá");
        ModelCTPN.addColumn("Thành tiền");
        
        //Giảm đọ dài cột đầu tiên của về 0
        tableCTPN.getColumnModel().getColumn(0).setMinWidth(0);
        tableCTPN.getColumnModel().getColumn(0).setMaxWidth(0);
        tableCTPN.getColumnModel().getColumn(1).setMinWidth(50);
        tableCTPN.getColumnModel().getColumn(1).setMaxWidth(50);
        tableCTPN.getColumnModel().getColumn(2).setMinWidth(250);
        tableCTPN.getColumnModel().getColumn(2).setMaxWidth(300);
        tableCTPN.getColumnModel().getColumn(3).setMinWidth(130);
        tableCTPN.getColumnModel().getColumn(3).setMaxWidth(130);
        tableCTPN.getColumnModel().getColumn(4).setMinWidth(110);
        tableCTPN.getColumnModel().getColumn(4).setMaxWidth(110);
        tableCTPN.getColumnModel().getColumn(5).setMinWidth(180);
        tableCTPN.getColumnModel().getColumn(5).setMaxWidth(180);
        tableCTPN.getColumnModel().getColumn(6).setMinWidth(180);
        tableCTPN.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void setDataCTPNtable(SanPham sp, String SLMua, String DonGiaNhap) {
        ModelCTPN.addRow(new Object[]{
            sp.getMasp(),ModelCTPN.getRowCount()+1, sp.getTensp(), 
            sp.getDvtinh(), SLMua, DonGiaNhap, 
            String.format("%.0f", Float.parseFloat(SLMua) * Float.parseFloat(DonGiaNhap))
            });
        
    }
    
    private void LamMoi(){
        TableSP();
        TableCTPN();
        
        //Load Item combobox
        jcbDVTinh.removeAllItems();
        sanphamService = new SanPhamService();
        sanphamService.loadDataComboBox(this.jcbDVTinh);
        
        txtTongTien.setText(cbh.TinhTongTien(tableCTPN));

        //Làm mới mã hóa đơn
        txtMaPN.setText(capn.TaoMaPN());
        txtSearchSP.setText("");
        txtSLNhap.setText("");
        txtTongTien.setText("0");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnCTPN = new javax.swing.JPopupMenu();
        mniDeleteSP = new javax.swing.JMenuItem();
        mniEditSP = new javax.swing.JMenuItem();
        panelHoaDon = new javax.swing.JPanel();
        txtMaPN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTPN = new javax.swing.JTable();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbtSave = new javax.swing.JButton();
        jbtHuy = new javax.swing.JButton();
        jbtDong = new javax.swing.JButton();
        panelSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSP = new javax.swing.JTable();
        txtSearchSP = new javax.swing.JTextField();
        jcbDVTinh = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSLNhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbtSelectSP = new javax.swing.JButton();
        txtDonGiaNhap = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        mniDeleteSP.setText("Xóa sản phẩm");
        mniDeleteSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteSPActionPerformed(evt);
            }
        });
        pmnCTPN.add(mniDeleteSP);

        mniEditSP.setText("Sửa sản phẩm");
        mniEditSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditSPActionPerformed(evt);
            }
        });
        pmnCTPN.add(mniEditSP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        panelHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtMaPN.setEditable(false);
        txtMaPN.setBackground(new java.awt.Color(255, 255, 255));
        txtMaPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPNActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã PN");

        txtNgayNhap.setEditable(false);
        txtNgayNhap.setBackground(new java.awt.Color(255, 255, 255));
        txtNgayNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayNhapActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ngày lập");

        tableCTPN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableCTPN.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tableCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Đơn vị", "Số lượng", "Đơn giá nhập", "Thành tiền"
            }
        ));
        tableCTPN.setComponentPopupMenu(pmnCTPN);
        tableCTPN.setGridColor(new java.awt.Color(255, 255, 255));
        tableCTPN.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tableCTPNComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(tableCTPN);

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(255, 255, 255));
        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.setText("0");
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jbtSave.setBackground(new java.awt.Color(0, 204, 0));
        jbtSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtSave.setForeground(new java.awt.Color(255, 255, 255));
        jbtSave.setText("Lưu");
        jbtSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSaveMouseClicked(evt);
            }
        });
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
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

        jbtDong.setBackground(new java.awt.Color(204, 0, 0));
        jbtDong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtDong.setForeground(new java.awt.Color(255, 255, 255));
        jbtDong.setText("Đóng");
        jbtDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtDong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHoaDonLayout.createSequentialGroup()
                        .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelHoaDonLayout.setVerticalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtDong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        txtSLNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSLNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLNhapActionPerformed(evt);
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

        txtDonGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDonGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaNhapActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Đơn giá nhập");

        javax.swing.GroupLayout panelSanPhamLayout = new javax.swing.GroupLayout(panelSanPham);
        panelSanPham.setLayout(panelSanPhamLayout);
        panelSanPhamLayout.setHorizontalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDonGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addComponent(jcbDVTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSLNhap)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSelectSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSLNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtSelectSP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPNActionPerformed

    private void txtNgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayNhapActionPerformed

    private void tableCTPNComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tableCTPNComponentShown

    }//GEN-LAST:event_tableCTPNComponentShown

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed

    }//GEN-LAST:event_txtTongTienActionPerformed
    int i=0;
    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        if (Float.parseFloat(txtTongTien.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào phiếu nhập!");
        } else {
            //Thêm hóa đơn
            PhieuNhap pn = new PhieuNhap();
            phieunhapService = new PhieuNhapService();
            pn.setMapn(txtMaPN.getText().toString());
            long millis = System.currentTimeMillis();
            pn.setNgaynhap(new java.sql.Date(millis));
            pn.setTonggianhap(Float.parseFloat(txtTongTien.getText()));
            phieunhapService.addPhieuNhap(pn);

            //Thêm cthd
            capn = new CodeAddPhieuNhap();
            capn.ThemCTPN(tableCTPN, txtMaPN.getText().toString());

            LamMoi();
            JOptionPane.showMessageDialog(this, "Lưu thành công!");
            i=i+1;
            System.out.println("i:"+i);
        }
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jbtHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHuyActionPerformed
        LamMoi();
        i=0;
        j=0;
    }//GEN-LAST:event_jbtHuyActionPerformed

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

    private void txtSLNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLNhapActionPerformed
    int j =0;
    private void jbtSelectSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSelectSPActionPerformed
        try {
            int row = tableSP.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                SLNhap = txtSLNhap.getText();
                DGNhap = txtDonGiaNhap.getText();

                if (SLNhap.equalsIgnoreCase("") || Integer.parseInt(SLNhap) <= 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập lại số lượng mua!");
                    txtSLNhap.requestFocusInWindow();
                } else if (DGNhap.equalsIgnoreCase("") || Float.parseFloat(DGNhap) <= 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập lại đơn giá nhập!");
                    txtDonGiaNhap.requestFocusInWindow();
                } else {

                    String MaSPtableSP = tableSP.getValueAt(row, 0).toString();
                    SanPham sp = sanphamService.getSanPhamByMaSP(MaSPtableSP);

                    // sao chép dữ liệu từ table vào list
                    //Chuyển về vector
                    Vector data = ModelCTPN.getDataVector();
                    // sao chép dữ liệu từ table vào list
                    int mColIndex = 0;
                    List colData = new ArrayList(tableCTPN.getRowCount());
                    for (int i = 0; i < tableCTPN.getRowCount(); i++) {
                        Vector row2 = (Vector) data.elementAt(i);
                        colData.add(row2.get(mColIndex));
                    }
                    //so sánh với mã sp trong list vừa có
                    if (colData.contains(MaSPtableSP)) {
                        JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong hóa đơn!", "Error Warning", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //Lấy dữ liệu từ tableSP và SLMua từ Frame SoLuongMua sang tableCTHD
                        setDataCTPNtable(sp, SLNhap, DGNhap);

                        txtSLNhap.requestFocusInWindow();
                        //Làm mới tiền trả
                        txtTongTien.setText(cbh.TinhTongTien(tableCTPN));
                        j=j+1;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtSelectSPActionPerformed

    private void txtDonGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaNhapActionPerformed

    private void mniDeleteSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteSPActionPerformed
        try {
            int row = tableCTPN.getSelectedRow();

            ModelCTPN.removeRow(row);
            for (int i = 0; i < tableCTPN.getRowCount(); i++) {
                tableCTPN.setValueAt(i + 1, i, 1);//reset STT
            }
            txtTongTien.setText(cbh.TinhTongTien(tableCTPN));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mniDeleteSPActionPerformed

    private void mniEditSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditSPActionPerformed
        int row = tableCTPN.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JFramePNaddSLNvsDGN dt = new JFramePNaddSLNvsDGN();
            dt.setLocationRelativeTo(null);
            dt.setVisible(true);
        }
    }//GEN-LAST:event_mniEditSPActionPerformed

    private void jbtDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDongActionPerformed
        if (i == 0 && j>=1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu phiếu nhập không?", "Thông báo", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                //Thêm hóa đơn
                PhieuNhap pn = new PhieuNhap();
                phieunhapService = new PhieuNhapService();
                pn.setMapn(txtMaPN.getText().toString());
                long millis = System.currentTimeMillis();
                pn.setNgaynhap(new java.sql.Date(millis));
                pn.setTonggianhap(Float.parseFloat(txtTongTien.getText()));
                phieunhapService.addPhieuNhap(pn);

                //Thêm cthd
                capn = new CodeAddPhieuNhap();
                capn.ThemCTPN(tableCTPN, txtMaPN.getText().toString());

                this.dispose();
            } else {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jbtDongActionPerformed
    
    private void jbtSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSaveMouseClicked

    }//GEN-LAST:event_jbtSaveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JButton jbtDong;
    private javax.swing.JButton jbtHuy;
    private javax.swing.JButton jbtSave;
    public static javax.swing.JButton jbtSelectSP;
    private javax.swing.JComboBox<String> jcbDVTinh;
    private javax.swing.JMenuItem mniDeleteSP;
    private javax.swing.JMenuItem mniEditSP;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JPopupMenu pmnCTPN;
    public static javax.swing.JTable tableCTPN;
    public static javax.swing.JTable tableSP;
    public static javax.swing.JTextField txtDonGiaNhap;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtNgayNhap;
    public static javax.swing.JTextField txtSLNhap;
    private javax.swing.JTextField txtSearchSP;
    public static javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
