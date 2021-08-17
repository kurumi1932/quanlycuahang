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
public class JFrameHoaDonEdit extends javax.swing.JFrame {

    private SanPhamService sanphamService;
    private HoaDonService hoadonService;
    private CTHoaDonService cthoadonService;
    private CodeEditHoaDon cehd;
    private CodeBanHang cbh;
    private DefaultTableModel ModelSP;
    private DefaultTableModel ModelCTHD;
    public static String SLMua2;
    String MaHD = String.valueOf(JPanelHoaDon.tableHD.getValueAt(JPanelHoaDon.tableHD.getSelectedRow(), 1));
    /**
     * Creates new form EditHoaDonJFrame
     */
    public JFrameHoaDonEdit() {
        initComponents();
        setTitle("Cập nhật hóa đơn");
        setResizable(false);//Vô hiệu hóa nút phóng to
        getContentPane().setBackground(Color.WHITE);//Backgrounf đổi màu
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//Đóng Jframe khi click(x)
        
        LamMoi();

        hoadonService = new HoaDonService();
        HoaDon hd = hoadonService.getHoaDonByMaHD(MaHD);
        txtMaHD.setText(hd.getMahd());
        txtTongTienCu.setText(String.format("%.0f", hd.getTonggiaban()));
        txtTongTienMoi.setText(String.valueOf(cbh.TinhTongTien(tableCTHD)));
        //Chuyển string -> date
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        txtNgayBan.setText(dateformat.format(hd.getNgayban()).toString());
        
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
        tableSP.getColumnModel().getColumn(1).setMinWidth(200);
        tableSP.getColumnModel().getColumn(1).setMaxWidth(250);
        tableSP.getColumnModel().getColumn(2).setMinWidth(20);
        tableSP.getColumnModel().getColumn(2).setMinWidth(20);
        tableSP.getColumnModel().getColumn(3).setMinWidth(80);
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
        tableCTHD.getColumnModel().getColumn(2).setMinWidth(320);
        tableCTHD.getColumnModel().getColumn(2).setMaxWidth(320);
        tableCTHD.getColumnModel().getColumn(3).setMinWidth(120);
        tableCTHD.getColumnModel().getColumn(3).setMaxWidth(120);
        tableCTHD.getColumnModel().getColumn(4).setMinWidth(100);
        tableCTHD.getColumnModel().getColumn(4).setMaxWidth(100);
        tableCTHD.getColumnModel().getColumn(5).setMinWidth(150);
        tableCTHD.getColumnModel().getColumn(5).setMaxWidth(150);
        tableCTHD.getColumnModel().getColumn(6).setMinWidth(150);
        tableCTHD.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        setDataCTHDtable2(cthoadonService.getListCTHDbyMaHD(MaHD));
        
    }
    
    private void setDataCTHDtable1(SanPham sp, String SLMua) {
        ModelCTHD.addRow(new Object[]{
            sp.getMasp(),ModelCTHD.getRowCount()+1, sp.getTensp(), 
            sp.getDvtinh(), SLMua, String.format("%.0f",sp.getDongiaban()), 
            String.format("%.0f", Float.parseFloat(SLMua) * sp.getDongiaban())
            });
        
    }
    
    private void setDataCTHDtable2(List<CTHoaDon> CTHDlist) {
        for(CTHoaDon cthd : CTHDlist){
        ModelCTHD.addRow(new Object[]{
            cthd.getMasp(),ModelCTHD.getRowCount()+1, cthd.getTensp(), 
            cthd.getDvtinh(), cthd.getSoluongban(), 
            String.format("%.0f",cthd.getDongiaban()), 
            String.format("%.0f", cthd.getThanhtien())
            });
        }
    }
    
    private void ThanhToan(){
        txtTongTienMoi.setText(cbh.TinhTongTien(tableCTHD));
        float TongTienMoi = Float.valueOf(txtTongTienMoi.getText().toString());
        float TongTienCu = Float.valueOf(txtTongTienCu.getText().toString());
        float KetToan = TongTienCu - TongTienMoi;
        txtTienTraKhach.setText(String.format("%.0f", KetToan));
    }
    
    public void LamMoi(){
        TableSP();
        TableCTHD();
        ThanhToan();
        
        //Load Item combobox
        jcbDVTinh.removeAllItems();
        sanphamService = new SanPhamService();
        sanphamService.loadDataComboBox(this.jcbDVTinh);
        
        txtSearchSP.setText("");
        txtSLMua.setText("1");
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
        txtTongTienMoi = new javax.swing.JTextField();
        txtTienTraKhach = new javax.swing.JTextField();
        txtTongTienCu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtThanhToan = new javax.swing.JButton();
        jbtClose = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        txtTongTienMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTienMoi.setText("0");
        txtTongTienMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienMoiActionPerformed(evt);
            }
        });
        txtTongTienMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienMoiKeyReleased(evt);
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

        txtTongTienCu.setEditable(false);
        txtTongTienCu.setBackground(new java.awt.Color(255, 255, 255));
        txtTongTienCu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTienCu.setText("0");
        txtTongTienCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienCuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tổng tiền mới");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tổng tiền cũ");

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

        jbtClose.setBackground(new java.awt.Color(204, 0, 0));
        jbtClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtClose.setForeground(new java.awt.Color(255, 255, 255));
        jbtClose.setText("Đóng");
        jbtClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoaDonLayout.createSequentialGroup()
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelHoaDonLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelHoaDonLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelHoaDonLayout.createSequentialGroup()
                                .addComponent(jbtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jbtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTienCu, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTienMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienCu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txtSLMua.setText("1");
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
                                .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbDVTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(126, 126, 126)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(txtSLMua, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtSelectSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
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
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSLMua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSelectSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtNgayBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBanActionPerformed

    private void tableCTHDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tableCTHDComponentShown

    }//GEN-LAST:event_tableCTHDComponentShown

    private void txtTongTienMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienMoiActionPerformed
        ThanhToan();
    }//GEN-LAST:event_txtTongTienMoiActionPerformed

    private void txtTongTienMoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienMoiKeyReleased

    }//GEN-LAST:event_txtTongTienMoiKeyReleased

    private void txtTienTraKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienTraKhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienTraKhachActionPerformed

    private void txtTongTienCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienCuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienCuActionPerformed
    int i=0;
    private void jbtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThanhToanActionPerformed
        if (Float.parseFloat(txtTongTienMoi.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào phiếu nhập!");
        } else {
            //Update tổng tiền hóa đơn
            String MaHD = txtMaHD.getText().toString();
            HoaDon hd = hoadonService.getHoaDonByMaHD(MaHD);
            hd.setTonggiaban(Float.parseFloat(txtTongTienMoi.getText()));
            hoadonService.updateHoaDon(hd);
            //Thêm cthd
            cehd = new CodeEditHoaDon();
            cehd.EditHDandCTHD(tableCTHD, txtMaHD.getText().toString());

            JOptionPane.showMessageDialog(this, "Bạn đã cập nhật thành công!");
            TableSP();
            i=i+1;
        } 
    }//GEN-LAST:event_jbtThanhToanActionPerformed

    private void jbtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCloseActionPerformed
        if (i == 0) {
            if (j >= 1 || m >= 1 || n >= 1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thay đổi không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    //Update tổng tiền hóa đơn
                    String MaHD = txtMaHD.getText().toString();
                    HoaDon hd = hoadonService.getHoaDonByMaHD(MaHD);
                    hd.setTonggiaban(Float.parseFloat(txtTongTienMoi.getText()));
                    hoadonService.updateHoaDon(hd);
                    //Thêm cthd
                    cehd = new CodeEditHoaDon();
                    cehd.EditHDandCTHD(tableCTHD, txtMaHD.getText().toString());

                    this.dispose();
                } else {
                    this.dispose();
                }
            } else {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jbtCloseActionPerformed

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
        // TODO add your handling code here:
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
    int m=0;
    private void mniDeleteSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteSPActionPerformed
        try {
            int row = tableCTHD.getSelectedRow();

            ModelCTHD.removeRow(row);
            for (int i = 0; i < tableCTHD.getRowCount(); i++) {
                tableCTHD.setValueAt(i + 1, i, 1);//reset STT
            }
            ThanhToan();
            m=m+1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mniDeleteSPActionPerformed
    int n=0;
    private void mniEditSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditSPActionPerformed
        try {
            int row = tableCTHD.getSelectedRow();
            SLMua2=tableCTHD.getValueAt(row, 4).toString();
            System.out.println("SLM2:"+SLMua2);
            
            //Thêm SP
            String MaSPtableSP = tableCTHD.getValueAt(row, 0).toString();
            SanPham sp = sanphamService.getSanPhamByMaSP(MaSPtableSP);
            setDataCTHDtable1(sp, SLMua2);
            
            //Xóa hàng vừa được thêm vào
            ModelCTHD.removeRow(ModelCTHD.getRowCount() - 1);

                
            JFrameHDeditSLM editSLM = new JFrameHDeditSLM();
            editSLM.setLocationRelativeTo(null);
            editSLM.setVisible(true);
            n=n+1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mniEditSPActionPerformed
    int j=0;
    private void jbtSelectSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSelectSPActionPerformed
        int row = tableSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Error Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            SLMua2 = txtSLMua.getText();
            if (Integer.parseInt(SLMua2) <= 0 || SLMua2.equals("")) {
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
                    if (Integer.valueOf(SLMua2) > SL) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập lại số lượng mua!");
                        txtSLMua.requestFocusInWindow();
                    } else {
                        setDataCTHDtable1(sp, SLMua2);

                        txtSLMua.requestFocusInWindow();
                        //Làm mới tiền trả
                        ThanhToan();
                        
                        j=j+1;
                    }
                }
            }
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
    private javax.swing.JButton jbtClose;
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
    private javax.swing.JTextField txtSLMua;
    private javax.swing.JTextField txtSearchSP;
    public static javax.swing.JTextField txtTienTraKhach;
    public static javax.swing.JTextField txtTongTienCu;
    public static javax.swing.JTextField txtTongTienMoi;
    // End of variables declaration//GEN-END:variables
}
