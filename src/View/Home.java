/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ChiTietPhieuNhapDAO;
import DAO.ChiTietPhieuXuatDAO;
import DAO.HangHoaDAO;
import DAO.NhaCungCapDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import DataBase.ConnectDB;
import Model.NhanVien;
import DAO.NhanVienDAO;
import DAO.PhieuNhapDAO;
import DAO.PhieuXuatDAO;
import Model.ChiTietPhieuNhap;
import Model.ChiTietPhieuXuat;
import Model.HangHoa;
import Model.NhaCungCap;
import Model.PhieuNhap;
import Model.PhieuXuat;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Home extends javax.swing.JFrame {

    public static ConnectDB cn = new ConnectDB();
    private DefaultTableModel defaultTableModel;
    private NhanVienDAO nvDAO;
    private NhaCungCapDAO nccDAO;
    private HangHoaDAO hhDAO;
    private PhieuNhapDAO pnDAO;
    private ChiTietPhieuNhapDAO ctpnDAO;
    private PhieuXuatDAO pxDAO;
    private ChiTietPhieuXuatDAO ctpxDAO;

    NhanVien nv = new NhanVien();
    NhaCungCap ncc = new NhaCungCap();
    HangHoa hh = new HangHoa();
    PhieuNhap pn = new PhieuNhap();
    ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
    PhieuXuat px = new PhieuXuat();
    ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();

    public Home() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("QUẢN LÍ KHO HÀNG");
        this.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        jDialogThemPhieuNhap.setSize(800, 700);
        jDialogThemPhieuNhap.setLocationRelativeTo(null);

        jDialogThemPhieuXuat.setSize(800, 700);
        jDialogThemPhieuXuat.setLocationRelativeTo(null);

        nvDAO = new NhanVienDAO();
        nccDAO = new NhaCungCapDAO();
        hhDAO = new HangHoaDAO();
        pnDAO = new PhieuNhapDAO();
        ctpnDAO = new ChiTietPhieuNhapDAO();
        pxDAO = new PhieuXuatDAO();
        ctpxDAO = new ChiTietPhieuXuatDAO();

        loadDuLieu();

    }

    public void loadDuLieuNhanVien(List<NhanVien> list) {
        defaultTableModel = (DefaultTableModel) tblNhanVien.getModel();
        defaultTableModel.setRowCount(0);
        try {
            for (NhanVien x : list) {
                defaultTableModel.addRow(new Object[]{
                    x.getManv(), x.getHoten(), x.getSdt(), x.getDiachi(), x.getMatkhau()});

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void loadDuLieuNhaCungCap(List<NhaCungCap> list) {
        defaultTableModel = (DefaultTableModel) tblNhacc.getModel();
        defaultTableModel.setRowCount(0);
        try {
            for (NhaCungCap x : list) {
                defaultTableModel.addRow(new Object[]{
                    x.getMancc(), x.getTenncc(), x.getSdt(), x.getDiachi()});

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void loadDuLieuHangHoa(List<HangHoa> list) {
        defaultTableModel = (DefaultTableModel) tblHangHoa.getModel();
        defaultTableModel.setRowCount(0);

        try {

            for (HangHoa x : hhDAO.getAll()) {
                defaultTableModel.addRow(new Object[]{
                    x.getMahh(), x.getTenhh(), x.getSoluongton(), x.getNcc().getTenncc(), x.getNcc().getMancc()});

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void loadDuLieu() {
        loadDuLieuNhanVien(nvDAO.getAll());
        loadDuLieuNhaCungCap(nccDAO.getAll());
        loadDuLieuHangHoa(hhDAO.getAll());
        loadDuLieuPhieuNhap(pnDAO.getAll());
        loadDuLieuPhieuXuat(pxDAO.getAll());
    }

    public void loadDuLieuPhieuNhap(List<PhieuNhap> list) {
        defaultTableModel = (DefaultTableModel) tblPhieuNhap.getModel();
        defaultTableModel.setRowCount(0);

        try {

            for (PhieuNhap x : pnDAO.getAll()) {
                defaultTableModel.addRow(new Object[]{
                    x.getMapn(), x.getCtpn().getMancc(), x.getHh().getTenhh(),
                    x.getCtpn().getSoluong(), x.getCtpn().getGiatien(), x.getNcc().getSdt(),
                    x.getNgaynhap(), x.getNcc().getTenncc()});

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void loadDuLieuPhieuXuat(List<PhieuXuat> list) {
        defaultTableModel = (DefaultTableModel) tblPhieuXuat.getModel();
        defaultTableModel.setRowCount(0);

        try {

            for (PhieuXuat x : pxDAO.getAll()) {
                defaultTableModel.addRow(new Object[]{
                    x.getMapx(),
                    x.getCtpx().getSoluong(), x.getCtpx().getGiatien(),
                    x.getNgayxuat(), x.getHh().getTenhh(), x.getNv().getHoten()});

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogThemPhieuNhap = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMapnJdialog = new javax.swing.JTextField();
        txtMahhJdialogpn = new javax.swing.JTextField();
        txtManvJdialogpn = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtManccJdialogpn = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNgayNhapJdialogpn = new javax.swing.JTextField();
        txtSoLuongJdialogpn = new javax.swing.JTextField();
        txtGiaTienJdialogpn = new javax.swing.JTextField();
        btnThempn = new javax.swing.JButton();
        btnSuapnjDialog = new javax.swing.JButton();
        btnXoapnjDialog = new javax.swing.JButton();
        jDialogThemPhieuXuat = new javax.swing.JDialog();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtMapxjDialog = new javax.swing.JTextField();
        txtMahhpxjDialog = new javax.swing.JTextField();
        txtManvpxjDialog = new javax.swing.JTextField();
        txtNgayXuatjDialog = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtGiaTienpxjDialog = new javax.swing.JTextField();
        btnThempxjDialog = new javax.swing.JButton();
        txtSoluongpxjDialog = new javax.swing.JTextField();
        btnSuapxjDialog = new javax.swing.JButton();
        btnXoapxjDialog = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlPhieuNhap = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        btnThemJdialogPhieuNhap = new javax.swing.JButton();
        pnlNhaCungCap = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhacc = new javax.swing.JTable();
        btnThemncc = new javax.swing.JButton();
        btnSuancc = new javax.swing.JButton();
        btnXoancc = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMancc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenncc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSdtncc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDiachincc = new javax.swing.JTextField();
        pnlPhieuxuat = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPhieuXuat = new javax.swing.JTable();
        btnThempx = new javax.swing.JButton();
        pnlNhanVien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnThemnv = new javax.swing.JButton();
        btnSuanv = new javax.swing.JButton();
        btnXoanv = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnlHangHoa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHangHoa = new javax.swing.JTable();
        btnThemhh = new javax.swing.JButton();
        btnXoahh = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtMahh = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTenhh = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtManccpnlHangHoa = new javax.swing.JTextField();
        btnSuahh = new javax.swing.JButton();

        jPanel1.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel11.setText("Mã Phiếu Nhập");

        jLabel13.setText("Mã Nhân Viên");

        jLabel14.setText("Mã Hàng Hóa");

        jLabel15.setText("Mã Nhà Cung Cấp");

        jLabel16.setText("Ngày Nhập");

        jLabel17.setText("Số lượng");

        jLabel18.setText("Giá tiền");

        btnThempn.setText("Thêm");
        btnThempn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThempnActionPerformed(evt);
            }
        });

        btnSuapnjDialog.setText("Sửa");
        btnSuapnjDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuapnjDialogActionPerformed(evt);
            }
        });

        btnXoapnjDialog.setText("Xóa");
        btnXoapnjDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoapnjDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThempn))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMahhJdialogpn)
                            .addComponent(txtMapnJdialog)
                            .addComponent(txtManvJdialogpn)
                            .addComponent(txtManccJdialogpn)
                            .addComponent(txtNgayNhapJdialogpn)
                            .addComponent(txtSoLuongJdialogpn)
                            .addComponent(txtGiaTienJdialogpn, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                        .addContainerGap(130, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnSuapnjDialog)
                        .addGap(144, 144, 144)
                        .addComponent(btnXoapnjDialog)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMapnJdialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMahhJdialogpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtManvJdialogpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtManccJdialogpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNgayNhapJdialogpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSoLuongJdialogpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtGiaTienJdialogpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThempn)
                    .addComponent(btnSuapnjDialog)
                    .addComponent(btnXoapnjDialog))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jDialogThemPhieuNhapLayout = new javax.swing.GroupLayout(jDialogThemPhieuNhap.getContentPane());
        jDialogThemPhieuNhap.getContentPane().setLayout(jDialogThemPhieuNhapLayout);
        jDialogThemPhieuNhapLayout.setHorizontalGroup(
            jDialogThemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogThemPhieuNhapLayout.setVerticalGroup(
            jDialogThemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel22.setText("Mã Phiếu Xuất");

        jLabel23.setText("Mã Hàng Hóa");

        jLabel24.setText("Mã Nhân Viên");

        jLabel25.setText("Ngày Xuất");

        jLabel26.setText("Số Lượng");

        jLabel27.setText("Giá Tiền");

        btnThempxjDialog.setText("Thêm Phiếu Xuất");
        btnThempxjDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThempxjDialogActionPerformed(evt);
            }
        });

        btnSuapxjDialog.setText("Sửa Phiếu Xuất");
        btnSuapxjDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuapxjDialogActionPerformed(evt);
            }
        });

        btnXoapxjDialog.setText("Xóa Phiếu Xuất");
        btnXoapxjDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoapxjDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogThemPhieuXuatLayout = new javax.swing.GroupLayout(jDialogThemPhieuXuat.getContentPane());
        jDialogThemPhieuXuat.getContentPane().setLayout(jDialogThemPhieuXuatLayout);
        jDialogThemPhieuXuatLayout.setHorizontalGroup(
            jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemPhieuXuatLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogThemPhieuXuatLayout.createSequentialGroup()
                        .addComponent(btnThempxjDialog)
                        .addGap(53, 53, 53)
                        .addComponent(btnSuapxjDialog)
                        .addGap(80, 80, 80)
                        .addComponent(btnXoapxjDialog))
                    .addGroup(jDialogThemPhieuXuatLayout.createSequentialGroup()
                        .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSoluongpxjDialog, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaTienpxjDialog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(txtNgayXuatjDialog)))
                    .addGroup(jDialogThemPhieuXuatLayout.createSequentialGroup()
                        .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMahhpxjDialog, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtManvpxjDialog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(txtMapxjDialog))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jDialogThemPhieuXuatLayout.setVerticalGroup(
            jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemPhieuXuatLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMapxjDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtMahhpxjDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtManvpxjDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtNgayXuatjDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtSoluongpxjDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtGiaTienpxjDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jDialogThemPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThempxjDialog)
                    .addComponent(btnSuapxjDialog)
                    .addComponent(btnXoapxjDialog))
                .addGap(55, 55, 55))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 153));

        pnlPhieuNhap.setBackground(new java.awt.Color(204, 204, 255));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Nhập", "Mã Nhà Cung Cấp", "Tên Hàng Hóa", "Số Lượng", "Giá Tiền", "SDT Nhà CC", "Ngày Nhập", "Tên Nhà CC"
            }
        ));
        jScrollPane4.setViewportView(tblPhieuNhap);

        btnThemJdialogPhieuNhap.setText("Thêm, Sửa, Xóa Phiếu Nhập");
        btnThemJdialogPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemJdialogPhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPhieuNhapLayout = new javax.swing.GroupLayout(pnlPhieuNhap);
        pnlPhieuNhap.setLayout(pnlPhieuNhapLayout);
        pnlPhieuNhapLayout.setHorizontalGroup(
            pnlPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPhieuNhapLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(btnThemJdialogPhieuNhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPhieuNhapLayout.setVerticalGroup(
            pnlPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhieuNhapLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnThemJdialogPhieuNhap)
                .addGap(0, 151, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phiếu Nhập ", pnlPhieuNhap);

        pnlNhaCungCap.setBackground(new java.awt.Color(204, 204, 255));
        pnlNhaCungCap.setForeground(new java.awt.Color(204, 255, 255));

        tblNhacc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà CC", "SDT", "Địa Chỉ"
            }
        ));
        tblNhacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaccMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNhacc);

        btnThemncc.setText("Thêm Nhà Cung Cấp");
        btnThemncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemnccActionPerformed(evt);
            }
        });

        btnSuancc.setText("Sửa Nhà Cung Cấp");
        btnSuancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuanccActionPerformed(evt);
            }
        });

        btnXoancc.setText("Xóa Nhà Cung Cấp");
        btnXoancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoanccActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã Nhà Cung Cấp");

        jLabel8.setText("Tên Nhà Cung Cấp");

        jLabel9.setText("Số Điện Thoại");

        jLabel10.setText("Địa Chỉ");

        javax.swing.GroupLayout pnlNhaCungCapLayout = new javax.swing.GroupLayout(pnlNhaCungCap);
        pnlNhaCungCap.setLayout(pnlNhaCungCapLayout);
        pnlNhaCungCapLayout.setHorizontalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMancc, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiachincc, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                                        .addComponent(txtSdtncc, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSuancc)
                                            .addComponent(btnThemncc)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhaCungCapLayout.createSequentialGroup()
                                        .addComponent(btnXoancc)
                                        .addGap(10, 10, 10))))))
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlNhaCungCapLayout.setVerticalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel6))
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7))
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdtncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemncc))
                .addGap(24, 24, 24)
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(btnSuancc))
                .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachincc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnXoancc)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhà Cung Cấp", pnlNhaCungCap);

        pnlPhieuxuat.setBackground(new java.awt.Color(204, 204, 255));
        pnlPhieuxuat.setForeground(new java.awt.Color(102, 204, 255));

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Xuất", "Số Lượng Xuất", "Giá Tiền ", "Ngày Xuất", "Tên Hàng Hóa", "Nhân Viên Xuất"
            }
        ));
        jScrollPane5.setViewportView(tblPhieuXuat);

        btnThempx.setText("Thêm, Sửa, Xóa Phiếu Xuất");
        btnThempx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThempxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPhieuxuatLayout = new javax.swing.GroupLayout(pnlPhieuxuat);
        pnlPhieuxuat.setLayout(pnlPhieuxuatLayout);
        pnlPhieuxuatLayout.setHorizontalGroup(
            pnlPhieuxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhieuxuatLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(btnThempx)
                .addContainerGap(470, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        pnlPhieuxuatLayout.setVerticalGroup(
            pnlPhieuxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhieuxuatLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnThempx)
                .addGap(0, 154, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phiếu Xuất", pnlPhieuxuat);

        pnlNhanVien.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setText("Họ Và Tên");

        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        jLabel3.setText("Số Điện Thoại");

        jLabel4.setText("Địa Chỉ");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên", "SDT", "Địa Chỉ", "Mật Khẩu"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);

        btnThemnv.setText("Thêm Nhân Viên");
        btnThemnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemnvActionPerformed(evt);
            }
        });

        btnSuanv.setText("Sửa Nhân Viên");
        btnSuanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuanvActionPerformed(evt);
            }
        });

        btnXoanv.setText("Xóa Nhân Viên");
        btnXoanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoanvActionPerformed(evt);
            }
        });

        jLabel5.setText("Mật Khẩu ");

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoanv))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemnv))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuanv)))))
                .addGap(73, 73, 73))
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(445, Short.MAX_VALUE))
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemnv)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuanv))
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnXoanv)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân Viên", pnlNhanVien);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Tổng Số Lượng Nhập", "Tổng Số Lượng Xuất"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        jLabel28.setText("Ngày Bắt Đầu");

        jLabel29.setText("Ngày Kết Thúc");

        jButton1.setText("Thống Kê");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(112, 112, 112)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(32, 32, 32)
                .addComponent(jLabel29)
                .addGap(26, 26, 26)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống Kê", jPanel2);

        pnlHangHoa.setBackground(new java.awt.Color(204, 204, 255));
        pnlHangHoa.setForeground(new java.awt.Color(51, 255, 255));

        tblHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Số Lượng Tồn", "Tên Nhà Cung Cấp", "Mã Nhà  Cung Cấp"
            }
        ));
        tblHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHangHoa);

        btnThemhh.setText("Thêm Hàng Hóa");
        btnThemhh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemhhActionPerformed(evt);
            }
        });

        btnXoahh.setText("Xóa Hàng Hóa");
        btnXoahh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoahhActionPerformed(evt);
            }
        });

        jLabel19.setText("Mã Hàng Hóa");

        jLabel20.setText("Tên Hàng Hóa");

        jLabel21.setText("Mã Nhà Cung Cấp");

        btnSuahh.setText("Sửa Hàng Hóa");
        btnSuahh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuahhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHangHoaLayout = new javax.swing.GroupLayout(pnlHangHoa);
        pnlHangHoa.setLayout(pnlHangHoaLayout);
        pnlHangHoaLayout.setHorizontalGroup(
            pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHangHoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHangHoaLayout.createSequentialGroup()
                        .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHangHoaLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMahh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenhh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                        .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoahh)
                            .addComponent(btnSuahh)
                            .addComponent(btnThemhh))
                        .addGap(106, 106, 106))
                    .addGroup(pnlHangHoaLayout.createSequentialGroup()
                        .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHangHoaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlHangHoaLayout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(txtManccpnlHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHangHoaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        pnlHangHoaLayout.setVerticalGroup(
            pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHangHoaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHangHoaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMahh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuahh)
                            .addComponent(txtManccpnlHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlHangHoaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel19))
                            .addComponent(btnThemhh, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addComponent(jLabel20)
                .addGap(21, 21, 21)
                .addGroup(pnlHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenhh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoahh))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hàng Hóa", pnlHangHoa);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThempnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThempnActionPerformed
        pn.setMapn(Integer.parseInt(txtMapnJdialog.getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse(txtNgayNhapJdialogpn.getText());
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            pn.setNgaynhap(sqlDate);
        } catch (ParseException e) {
            // Xử lý ngoại lệ khi không thể phân tích chuỗi thành ngày
            e.printStackTrace();
        }

        pn.setManv(Integer.parseInt(txtManvJdialogpn.getText()));

        pnDAO.Thempn(pn);
        ctpn.setMahh(Integer.parseInt(txtMahhJdialogpn.getText()));
        ctpn.setMapn(Integer.parseInt(txtMapnJdialog.getText()));
        ctpn.setMancc(Integer.parseInt(txtManccJdialogpn.getText()));
        ctpn.setSoluong(Integer.parseInt(txtSoLuongJdialogpn.getText()));
        ctpn.setGiatien(Double.parseDouble(txtGiaTienJdialogpn.getText()));
        ctpnDAO.Themctpn(ctpn);
        hhDAO.UpdateSoLuongHangTonKho();
        loadDuLieu();
    }//GEN-LAST:event_btnThempnActionPerformed

    private void btnSuapnjDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuapnjDialogActionPerformed
        pn.setMapn(Integer.parseInt(txtMapnJdialog.getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse(txtNgayNhapJdialogpn.getText());
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            pn.setNgaynhap(sqlDate);
        } catch (ParseException e) {
            // Xử lý ngoại lệ khi không thể phân tích chuỗi thành ngày
            e.printStackTrace();
        }

        pn.setManv(Integer.parseInt(txtManvJdialogpn.getText()));
        pnDAO.Suapn(pn);
        ctpn.setMahh(Integer.parseInt(txtMahhJdialogpn.getText()));
        ctpn.setMapn(Integer.parseInt(txtMapnJdialog.getText()));
        ctpn.setMancc(Integer.parseInt(txtManccJdialogpn.getText()));
        ctpn.setSoluong(Integer.parseInt(txtSoLuongJdialogpn.getText()));
        ctpn.setGiatien(Double.parseDouble(txtGiaTienJdialogpn.getText()));
        ctpnDAO.Suactpn(ctpn);
        hhDAO.UpdateSoLuongHangTonKho();
        loadDuLieu();

    }//GEN-LAST:event_btnSuapnjDialogActionPerformed

    private void btnXoapnjDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoapnjDialogActionPerformed
        int mapn = (Integer.parseInt(txtMapnJdialog.getText()));
        ctpnDAO.Xoactpn(mapn);
        pnDAO.Xoapn(mapn);
        loadDuLieu();

    }//GEN-LAST:event_btnXoapnjDialogActionPerformed

    private void btnThempxjDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThempxjDialogActionPerformed
        px.setMapx(Integer.parseInt(txtMapxjDialog.getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse(txtNgayXuatjDialog.getText());
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            px.setNgayxuat(sqlDate);
        } catch (ParseException e) {

            e.printStackTrace();
        }

        px.setManv(Integer.parseInt(txtManvpxjDialog.getText()));

        pxDAO.Thempx(px);
        ctpx.setMahh(Integer.parseInt(txtMahhpxjDialog.getText()));
        ctpx.setMapx(Integer.parseInt(txtMapxjDialog.getText()));

        ctpx.setSoluong(Integer.parseInt(txtSoluongpxjDialog.getText()));
        ctpx.setGiatien(Double.parseDouble(txtGiaTienpxjDialog.getText()));
        ctpxDAO.Themctpx(ctpx);
        hhDAO.UpdateSoLuongHangTonKho();
        loadDuLieu();

    }//GEN-LAST:event_btnThempxjDialogActionPerformed

    private void btnSuapxjDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuapxjDialogActionPerformed
        px.setMapx(Integer.parseInt(txtMapxjDialog.getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse(txtNgayXuatjDialog.getText());
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            px.setNgayxuat(sqlDate);
        } catch (ParseException e) {
            // Xử lý ngoại lệ khi không thể phân tích chuỗi thành ngày
            e.printStackTrace();
        }

        px.setManv(Integer.parseInt(txtManvpxjDialog.getText()));

        pxDAO.Suapx(px);
        ctpx.setMahh(Integer.parseInt(txtMahhpxjDialog.getText()));
        ctpx.setMapx(Integer.parseInt(txtMapxjDialog.getText()));

        ctpx.setSoluong(Integer.parseInt(txtSoluongpxjDialog.getText()));
        ctpx.setGiatien(Double.parseDouble(txtGiaTienpxjDialog.getText()));
        ctpxDAO.Suactpx(ctpx);
        hhDAO.UpdateSoLuongHangTonKho();
        loadDuLieu();
    }//GEN-LAST:event_btnSuapxjDialogActionPerformed

    private void btnXoapxjDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoapxjDialogActionPerformed
        int mapx = (Integer.parseInt(txtMapxjDialog.getText()));
       
        ctpxDAO.Xoactpx(mapx);
         pxDAO.Xoapx(mapx);
        loadDuLieu();

    }//GEN-LAST:event_btnXoapxjDialogActionPerformed

    private void btnXoanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoanvActionPerformed
        int manv = (Integer.parseInt(txtMaNhanVien.getText()));
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn xóa nhân viên?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            nvDAO.Xoanv(manv);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnXoanvActionPerformed

    private void btnSuanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuanvActionPerformed

        nv.setManv(Integer.parseInt(txtMaNhanVien.getText()));
        nv.setHoten(txtHoTen.getText());
        nv.setSdt(Integer.parseInt(txtSoDienThoai.getText()));
        nv.setDiachi(txtDiaChi.getText());
        nv.setMatkhau(txtMatKhau.getText());
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn sửa nhân viên?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            nvDAO.Suanv(nv);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnSuanvActionPerformed

    private void btnThemnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemnvActionPerformed

        nv.setManv(Integer.parseInt(txtMaNhanVien.getText()));
        nv.setHoten(txtHoTen.getText());
        nv.setSdt(Integer.parseInt(txtSoDienThoai.getText()));
        nv.setDiachi(txtDiaChi.getText());
        nv.setMatkhau(txtMatKhau.getText());
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn thêm nhân viên?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            nvDAO.Themnv(nv);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnThemnvActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int  row = tblNhanVien.getSelectedRow();
        String manv = tblNhanVien.getValueAt(row, 0).toString();
        String hoTen = tblNhanVien.getValueAt(row, 1).toString();
        String sdt = tblNhanVien.getValueAt(row, 2).toString();
        String diaChi = tblNhanVien.getValueAt(row, 3).toString();
        String matkhau = tblNhanVien.getValueAt(row, 4).toString();
        txtMaNhanVien.setText(manv);
        txtHoTen.setText(hoTen);
        txtSoDienThoai.setText(sdt);
        txtDiaChi.setText(diaChi);
        txtMatKhau.setText(matkhau);

    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void btnThempxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThempxActionPerformed
        jDialogThemPhieuXuat.setVisible(true);
    }//GEN-LAST:event_btnThempxActionPerformed

    private void btnXoanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoanccActionPerformed
        int mancc = (Integer.parseInt(txtMancc.getText()));
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn xóa nhà cung cấp?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            nccDAO.Xoancc(mancc);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnXoanccActionPerformed

    private void btnSuanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuanccActionPerformed
        ncc.setMancc(Integer.parseInt(txtMancc.getText()));
        ncc.setTenncc(txtTenncc.getText());
        ncc.setSdt(Integer.parseInt(txtSdtncc.getText()));
        ncc.setDiachi(txtDiachincc.getText());
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn sửa nhà cung cấp ?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            nccDAO.Suanc(ncc);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnSuanccActionPerformed

    private void btnThemnccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemnccActionPerformed
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMancc(Integer.parseInt(txtMancc.getText()));
        ncc.setTenncc(txtTenncc.getText());
        ncc.setSdt(Integer.parseInt(txtSdtncc.getText()));
        ncc.setDiachi(txtDiachincc.getText());
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn thêm nhà cung cấp?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            nccDAO.Themncc(ncc);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnThemnccActionPerformed

    private void tblNhaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaccMouseClicked
        int  row = tblNhacc.getSelectedRow();
        String mancc = tblNhacc.getValueAt(row, 0).toString();
        String tenncc = tblNhacc.getValueAt(row, 1).toString();
        String sdt = tblNhacc.getValueAt(row, 2).toString();
        String diaChi = tblNhacc.getValueAt(row, 3).toString();

        txtMancc.setText(mancc);
        txtTenncc.setText(tenncc);
        txtSdtncc.setText(sdt);
        txtDiachincc.setText(diaChi);

    }//GEN-LAST:event_tblNhaccMouseClicked

    private void btnThemJdialogPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemJdialogPhieuNhapActionPerformed
        jDialogThemPhieuNhap.setVisible(true);

    }//GEN-LAST:event_btnThemJdialogPhieuNhapActionPerformed

    private void btnSuahhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuahhActionPerformed
        hh.setMahh(Integer.parseInt(txtMahh.getText()));
        hh.setTenhh(txtTenhh.getText());
        hh.setMancc(Integer.parseInt(txtManccpnlHangHoa.getText()));

        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn sửa hàng hóa?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            hhDAO.Suahh(hh);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnSuahhActionPerformed

    private void btnXoahhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoahhActionPerformed
        int mahh = (Integer.parseInt(txtMahh.getText()));
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn xóa hàng hóa?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            hhDAO.Xoahh(mahh);
        }
        loadDuLieu();
    }//GEN-LAST:event_btnXoahhActionPerformed

    private void btnThemhhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemhhActionPerformed

        hh.setMahh(Integer.parseInt(txtMahh.getText()));
        hh.setTenhh(txtTenhh.getText());
        hh.setMancc(Integer.parseInt(txtManccpnlHangHoa.getText()));
        int res = JOptionPane.showConfirmDialog(this,
            "Bạn muốn thêm hàng hóa?","Xác nhận",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            hhDAO.Themhh(hh);
        }

        loadDuLieu();

    }//GEN-LAST:event_btnThemhhActionPerformed

    private void tblHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangHoaMouseClicked
        int  row = tblHangHoa.getSelectedRow();
        String mahh = tblHangHoa.getValueAt(row, 0).toString();
        String tenhh = tblHangHoa.getValueAt(row, 1).toString();
        String mancc = tblHangHoa.getValueAt(row, 4).toString();

        txtMahh.setText(mahh);
        txtTenhh.setText(tenhh);
        txtManccpnlHangHoa.setText(mancc);
    }//GEN-LAST:event_tblHangHoaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuahh;
    private javax.swing.JButton btnSuancc;
    private javax.swing.JButton btnSuanv;
    private javax.swing.JButton btnSuapnjDialog;
    private javax.swing.JButton btnSuapxjDialog;
    private javax.swing.JButton btnThemJdialogPhieuNhap;
    private javax.swing.JButton btnThemhh;
    private javax.swing.JButton btnThemncc;
    private javax.swing.JButton btnThemnv;
    private javax.swing.JButton btnThempn;
    private javax.swing.JButton btnThempx;
    private javax.swing.JButton btnThempxjDialog;
    private javax.swing.JButton btnXoahh;
    private javax.swing.JButton btnXoancc;
    private javax.swing.JButton btnXoanv;
    private javax.swing.JButton btnXoapnjDialog;
    private javax.swing.JButton btnXoapxjDialog;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialogThemPhieuNhap;
    private javax.swing.JDialog jDialogThemPhieuXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pnlHangHoa;
    private javax.swing.JPanel pnlNhaCungCap;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlPhieuNhap;
    private javax.swing.JPanel pnlPhieuxuat;
    private javax.swing.JTable tblHangHoa;
    private javax.swing.JTable tblNhacc;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiachincc;
    private javax.swing.JTextField txtGiaTienJdialogpn;
    private javax.swing.JTextField txtGiaTienpxjDialog;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMahh;
    private javax.swing.JTextField txtMahhJdialogpn;
    private javax.swing.JTextField txtMahhpxjDialog;
    private javax.swing.JTextField txtMancc;
    private javax.swing.JTextField txtManccJdialogpn;
    private javax.swing.JTextField txtManccpnlHangHoa;
    private javax.swing.JTextField txtManvJdialogpn;
    private javax.swing.JTextField txtManvpxjDialog;
    private javax.swing.JTextField txtMapnJdialog;
    private javax.swing.JTextField txtMapxjDialog;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgayNhapJdialogpn;
    private javax.swing.JTextField txtNgayXuatjDialog;
    private javax.swing.JTextField txtSdtncc;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoLuongJdialogpn;
    private javax.swing.JTextField txtSoluongpxjDialog;
    private javax.swing.JTextField txtTenhh;
    private javax.swing.JTextField txtTenncc;
    // End of variables declaration//GEN-END:variables
}
