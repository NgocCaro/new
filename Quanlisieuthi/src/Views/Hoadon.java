/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controller.Chitet_hdModify;
import Controller.CustomerModify;
import Controller.HoaDonModify;
import model.Product;
import Controller.ProductModify;
import model.chi_tiet_hd;
import model.loai_hang;
import model.quanlyhoadon;

/**
 *
 * @author Admin
 */
public class Hoadon extends javax.swing.JFrame {

    public int dem = 0, tmp = 0, kb = 0;
    HoaDonModify a = new HoaDonModify();
    Chitet_hdModify dao = new Chitet_hdModify();
    CustomerModify khach = new CustomerModify();
    ProductModify pr = new ProductModify();
    private List<quanlyhoadon> hoadon;
    private List<Product> sanpham;
    //private List<chi_tiet_hd> sanphamct;
    ArrayList<chi_tiet_hd> sanphamct = new ArrayList<>();
    private DefaultTableModel ModelHD;
    private DefaultTableModel ModelSP;
    private DefaultTableModel ModelSPCT;
    int selectedIndex;

    public Hoadon() {
        initComponents();
        this.setLocationRelativeTo(null);
        ModelHD = (DefaultTableModel) table_hd.getModel();
        ModelSP = (DefaultTableModel) table_sanpham.getModel();
        ModelSPCT = (DefaultTableModel) table_chi_tiet_hd.getModel();
        showTableHD();
        showTableSP();
        showTableSPCT();
        showTableSPCT_tamthoi();
        showTableSPCT_themmoi();
        //loaispp();
    }

    //hiển thị bảng hóa đơn
    private void showTableHD() {
        hoadon = new HoaDonModify().getListHD();
        ModelHD.setRowCount(0);
        for (quanlyhoadon hd : hoadon) {//
            ModelHD.addRow(new Object[]{
                hd.getMahd(), hd.getSdt(), hd.getTennv(), hd.getDate_Buy(), hd.getThanhTien()
            });

        }

    }

    // hiển thị bảng chọn sản phẩm 
    private void showTableSP() {
        sanpham = new ProductModify().getProduct();
        ModelSP.setRowCount(0);
        for (Product s : sanpham) {
            ModelSP.addRow(new Object[]{
                s.getMa_sp(), s.getTen_sp(), s.getGia_ban(), s.getSo_luong()
            });
        }
    }

    //hiển thị bảng chi tiết hóa đơn
    public void showTableSPCT() {
        ModelSPCT.setRowCount(0);
        //ArrayList<chi_tiet_hd> sanphamct=new ArrayList<>();
        for (chi_tiet_hd s : sanphamct) {
            Object[] row = new Object[]{
                table_chi_tiet_hd.getRowCount() + 1, s.getMasp(), s.getTen_sp(), s.getSo_luong(), s.getGiaban(), s.getGia()};
            ModelSPCT.addRow(row);
        }

    }

    //hiển thị bảng chi tiết hóa đơn tạm thời 
    public void showTableSPCT_tamthoi() {
        ModelSPCT.setRowCount(0);
        //ArrayList<chi_tiet_hd> sanphamct=new ArrayList<>();
        for (chi_tiet_hd s : sanphamct) {
            Object[] row = new Object[]{
                table_chi_tiet_hd.getRowCount() + 1, s.getMasp(), s.getTen_sp(), s.getSo_luong(), s.getGiaban(), s.getGia()};
            ModelSPCT.addRow(row);
        }
    }

    /* public void cleartable(){
        sanpham.clear();
    }*/
    // hien thi bang chi tiet hoa don tam thoi khi click chon "them moi hoa don"
    public void showTableSPCT_themmoi() {
        sanphamct.clear();
        showTableSPCT();
        showTableSPCT_tamthoi();
    }

    public int tichdiem(int tongtien, int diemco) {
        int diem = (int) Math.floor(tongtien / 50000);
        System.out.println("diem co: " + diemco);
        System.out.println("diem: " + diem);
        return diemco + diem;

    }


    public void tru_hang() {

        for (int i = 0; i < table_chi_tiet_hd.getRowCount(); i++) {
            int masp = Integer.parseInt(table_chi_tiet_hd.getValueAt(i, 1).toString());
            int sl = Integer.parseInt(table_chi_tiet_hd.getValueAt(i, 3).toString());
            int k = pr.getsl(masp);
            if (k >= sl) {
                pr.trusl(masp, k - sl);
            } else {
                JOptionPane.showMessageDialog(this, "san pham khong du");
            }

        }

    }

    public void setModel(Product pr) {
        txtSp.setText(String.valueOf(pr.getMa_sp()));
        txtTensp.setText(pr.getTen_sp());
        txtSo_luong.setText(String.valueOf(pr.getSo_luong()));
        txtGia.setText(String.valueOf(pr.getGia_ban()));

    }

    /*  private void showTableSPCT(){
       sanphamct=new Chitet_hdModify().getListSP();
        //sanphamct=new Chitet_hdModify().luutamthoi();
        ModelSPCT.setRowCount(0);
        for(chi_tiet_hd s:sanphamct){
           Object dataRow[]=new Object[4];
           dataRow[0]=s.getMa_chi_tiet_hd();
           dataRow[1]=s.getMasp();
           dataRow[2]=s.getSo_luong();
           dataRow[3]=s.getGia();          
           ModelSPCT.addRow(dataRow);
        }
        
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnThanh_toan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTensp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jsdt = new javax.swing.JTextField();
        txtSp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtong = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Jdiem = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Jdungdiem = new javax.swing.JTextField();
        txtSo_luong = new javax.swing.JTextField();
        Jdiemcos = new javax.swing.JLabel();
        Jdiemcoss = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnAdd_sp = new javax.swing.JButton();
        btnXoa_gio = new javax.swing.JButton();
        btnAdd_bill = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_hd = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_chi_tiet_hd = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_sanpham = new javax.swing.JTable();
        combox_find_bill = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phiếu mua hàng");

        jPanel2.setBackground(new java.awt.Color(237, 250, 253));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 115, 103));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN");
        jLabel1.setToolTipText("");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        jButton4.setText("Home");
        jButton4.setToolTipText("Thoát");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnThanh_toan.setBackground(new java.awt.Color(139, 203, 200));
        btnThanh_toan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThanh_toan.setText("Thanh toán");
        btnThanh_toan.setToolTipText("Thanh toán");
        btnThanh_toan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnThanh_toan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanh_toanActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(193, 217, 214)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tên Sản phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Số điện thoại");
        jLabel2.setToolTipText("");

        txtTensp.setToolTipText("Tên Sản phẩm");
        txtTensp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Mã Sản phẩm");

        txtGia.setToolTipText("Đơn giá");
        txtGia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        jsdt.setToolTipText("Mã nhân viên");
        jsdt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        txtSp.setToolTipText("Mã Sản phẩm");
        txtSp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Số Lượng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tổng tiền");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Đơn giá");

        jtong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        jButton1.setBackground(new java.awt.Color(139, 203, 200));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Điểm");
        jButton1.setToolTipText("Xem điểm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(139, 203, 200));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Dùng điểm");
        jButton3.setToolTipText("Sử dụng điểm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Jdungdiem.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        txtSo_luong.setToolTipText("Nhập số lượng");
        txtSo_luong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(193, 217, 214)));

        jButton5.setBackground(new java.awt.Color(139, 203, 200));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Tìm kiếm sản phẩm");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jdiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Jdiemcoss)
                                        .addGap(46, 46, 46)
                                        .addComponent(Jdiemcos))
                                    .addComponent(Jdungdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jtong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSp, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtTensp)
                    .addComponent(txtGia)
                    .addComponent(txtSo_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Jdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jdiemcos)
                                    .addComponent(Jdiemcoss))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jdungdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtSo_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        btnDelete.setBackground(new java.awt.Color(139, 203, 200));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete.setText("Xóa hóa đơn");
        btnDelete.setToolTipText("Xóa hóa đơn");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Chi tiết hóa đơn");

        btnAdd_sp.setBackground(new java.awt.Color(139, 203, 200));
        btnAdd_sp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd_sp.setText("Thêm vào giỏ");
        btnAdd_sp.setToolTipText("Thêm vào giỏ");
        btnAdd_sp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnAdd_sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_spActionPerformed(evt);
            }
        });

        btnXoa_gio.setBackground(new java.awt.Color(139, 203, 200));
        btnXoa_gio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa_gio.setText("Xóa hàng");
        btnXoa_gio.setToolTipText("Xóa hàng trong giỏ");
        btnXoa_gio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnXoa_gio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_gioActionPerformed(evt);
            }
        });

        btnAdd_bill.setBackground(new java.awt.Color(139, 203, 200));
        btnAdd_bill.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd_bill.setText("Thêm hóa đơn");
        btnAdd_bill.setToolTipText("Thêm hóa đơn");
        btnAdd_bill.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnAdd_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_billActionPerformed(evt);
            }
        });

        table_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "SĐT Khách", "Tên Nhân viên", "Ngày mua", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_hdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_hd);

        table_chi_tiet_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Tổng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_chi_tiet_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_chi_tiet_hdMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_chi_tiet_hd);
        if (table_chi_tiet_hd.getColumnModel().getColumnCount() > 0) {
            table_chi_tiet_hd.getColumnModel().getColumn(0).setMinWidth(50);
            table_chi_tiet_hd.getColumnModel().getColumn(0).setMaxWidth(50);
            table_chi_tiet_hd.getColumnModel().getColumn(2).setMinWidth(120);
            table_chi_tiet_hd.getColumnModel().getColumn(2).setMaxWidth(120);
            table_chi_tiet_hd.getColumnModel().getColumn(3).setMinWidth(70);
            table_chi_tiet_hd.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        table_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Số lượng"
            }
        ));
        table_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_sanpham);

        combox_find_bill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm hóa đơn", "SĐT khách", "Ngày mua", "Nhân viên" }));
        combox_find_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_find_billActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnAdd_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa_gio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3))
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAdd_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThanh_toan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(combox_find_bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(28, 28, 28))))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa_gio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanh_toan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combox_find_bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// thêm hóa đơn
    private void btnAdd_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_billActionPerformed
        dem = 0;
        kb = 0;
        tmp = 0;
        txtGia.setText("");
        txtSo_luong.setText("");
        txtSp.setText("");
        txtTensp.setText("");
        jtong.setText("");
        Jdungdiem.setText("");
        jsdt.setText("");
        Jdiemcoss.setText("");
        System.out.println(dem);
        showTableSPCT_themmoi();
    }//GEN-LAST:event_btnAdd_billActionPerformed
//click trong bảng sản phẩm
    private void table_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sanphamMouseClicked
        // TODO add your handling code here:
        selectedIndex = table_sanpham.getSelectedRow();
        System.out.println(selectedIndex);
        Product sp = sanpham.get(selectedIndex);
        // System.out.println(sp);
        if (sp.getSo_luong() > 0) {
            txtSp.setText(String.valueOf(sp.getMa_sp()));
            txtTensp.setText(sp.getTen_sp());
            txtGia.setText(sp.getGia_ban() + "");
        } else {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng");
        }

    }//GEN-LAST:event_table_sanphamMouseClicked
// thêm sản phẩm vào giỏ
    private void btnAdd_spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_spActionPerformed
        // TODO add your handling code here:
        int masp = 0;
        String tensp = "";
        int soluong = 0;
        int gia = 0;
        int tonggia = 0;
        int giaban = 0;

        tensp = txtTensp.getText();
        masp = Integer.parseInt(txtSp.getText());
        soluong = Integer.parseInt(txtSo_luong.getText());
        gia = Integer.parseInt(txtGia.getText());
        giaban = Integer.parseInt(txtGia.getText());
        int GIA = soluong * giaban;
        int k = pr.getsl(masp);
        System.out.println("k: " + k + " so luong: " + soluong);
        if (k >= soluong) {
            if (kb > 0) {
                int q = 0;
                for (chi_tiet_hd s : sanphamct) {

                    if (s.getMasp() == masp) {

                        //System.out.println("huou cao co: "+s.getSo_luong()+soluong);
                        q++;
                        s.setGia((s.getSo_luong() + soluong) * giaban);
                        s.setSo_luong(s.getSo_luong() + soluong);
                    }

                }
                if (q == 0) {
                    chi_tiet_hd sp = new chi_tiet_hd(masp, tensp, soluong, giaban, GIA);
                    sanphamct.add(sp);
                }
            } else {
                chi_tiet_hd sp = new chi_tiet_hd(masp, tensp, soluong, giaban, GIA);
                sanphamct.add(sp);
                kb++;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sản phẩm không đủ");
        }

        /*
         int p=0;
         int t=0;
        if(tmp>0){
             for(int i=0;i<table_chi_tiet_hd.getRowCount();i++){
               
             p= Integer.parseInt(table_chi_tiet_hd.getValueAt(i, 1).toString());
                 System.out.println("tmp: "+tmp);
                 System.out.println(table_chi_tiet_hd.getRowCount());
                  System.out.println("p="+p);
              if(masp==p){
                  System.out.println(p+"p day ne");
                  
                //  System.out.println(sanphamct);
                  int kq= sanphamct.get(i).getSo_luong();
                   sanphamct.get(i).setSo_luong(soluong+kq);   
                   t++; 
                   tmp++;
                    break;
              }
               
                 
          }
             if(t>0){
                  chi_tiet_hd sp=new chi_tiet_hd(masp,soluong,GIA,giaban); 
                        sanphamct.add(sp);
                        tmp++;
                        
              }  
             
        }
        else{
            System.out.println("tmp"+tmp);
             chi_tiet_hd sp=new chi_tiet_hd(masp,soluong,GIA,giaban*soluong); 
              sanphamct.add(sp);
              tmp++;
              
        } 
         */
        showTableSPCT();

        for (int i = 0; i < table_chi_tiet_hd.getRowCount(); i++) {
            tonggia += Integer.parseInt(table_chi_tiet_hd.getValueAt(i, 5).toString());
        }
        jtong.setText(tonggia + "");
        //dao.addSP(sp);
        // dao.Dungtest(GIA);
        showTableSPCT_tamthoi();

    }//GEN-LAST:event_btnAdd_spActionPerformed
//click vào bảng chi tiết hóa đơn   
    private void table_chi_tiet_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_chi_tiet_hdMouseClicked

    }//GEN-LAST:event_table_chi_tiet_hdMouseClicked
// đẩy chi tiết hóa đơn lên db

    public void luu_db_chi_tiet_hd(int k) {
        System.out.println("ma hd: " + k);
        for (int i = 0; i < sanphamct.size(); i++) {

            //int gia= sanphamct.get(i).getGiaban();    gia,
            int ma_sp = sanphamct.get(i).getMasp();
            int so_luong = sanphamct.get(i).getSo_luong();
            int tong = sanphamct.get(i).getGia();
            System.out.println("ma sp: " + ma_sp + " so luong: " + so_luong + " " + tong);
            chi_tiet_hd sp = new chi_tiet_hd(ma_sp, so_luong, tong);

            dao.addSP(sp, k);
        }

    }

    public String getdate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();

        String date = dtf.format(now);
        return date;
    }

// thanh toán
    private void btnThanh_toanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanh_toanActionPerformed
        // tự động reset các ô nhập
        Login l = new Login();

        //thanh toán 
        String DateBuy = getdate();

        int gia = 0;
        for (int i = 0; i < table_chi_tiet_hd.getRowCount(); i++) {
            gia += Integer.parseInt(table_chi_tiet_hd.getValueAt(i, 5).toString());
        }
        //System.out.println(gia);
        if (jsdt.getText().isEmpty()) {

            quanlyhoadon hd = new quanlyhoadon(DateBuy, (Integer.parseInt(jtong.getText())), l.returnma());

            if (a.Addhdno(hd) > 0) {

                luu_db_chi_tiet_hd(a.getmahd());
                tru_hang();
                System.out.println("oh o day");
                showTableHD();
                showTableSP();
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
            }

        } else {
            quanlyhoadon hd = new quanlyhoadon(DateBuy, (Integer.parseInt(jtong.getText())), l.returnma(), jsdt.getText());

            if (a.AddHD(hd) > 0) {
                // khach.congdiem(tichdiem(Integer.parseInt(jtong.getText()), khach.getdiem(a.getmakh( jsdt.getText()))),(a.getmakh(jsdt.getText())));
                // khach.congdiem(tichdiem(gia, khach.getdiem(a.getmakh(Integer.parseInt(jsdt.getText())))));
                luu_db_chi_tiet_hd(a.getmahd());
                tru_hang();
                showTableHD();
                showTableSP();
                if (dem == 0) {
                    khach.congdiem(tichdiem(Integer.parseInt(jtong.getText()), khach.getdiem(a.getmakh(jsdt.getText()))), (a.getmakh(jsdt.getText())));
                    System.out.println("dem=0");
                } else if (dem == 1) {
                    int diemcon = Integer.parseInt(Jdiemcoss.getText()) - Integer.parseInt(Jdungdiem.getText());
                    System.out.println("dem=1");
                    khach.congdiem(tichdiem(Integer.parseInt(jtong.getText()), diemcon), (a.getmakh(jsdt.getText())));
                    dem = 0;
                }
            }

            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
        }

        // đồng thời lưu luôn chi tiết hóa đơn vào db
        txtSp.setText("");
        txtTensp.setText("");
        txtSo_luong.setText("");
        txtGia.setText("");
        jtong.setText("");
        Jdiemcoss.setText("");

    }//GEN-LAST:event_btnThanh_toanActionPerformed

// xóa hóa đơn
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selectedIndex = table_hd.getSelectedRow();
        quanlyhoadon sp = hoadon.get(selectedIndex);
        new HoaDonModify().DeleteHD(sp.getMahd());
        showTableHD();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btnDeleteActionPerformed

// click vào bảng hóa đơn    
    private void table_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_hdMouseClicked
        // TODO add your handling code here:
        int numRow = table_hd.getSelectedRow();
        int ma_hd = Integer.parseInt(table_hd.getValueAt(numRow, 0).toString());
        sanphamct = new Chitet_hdModify().getchi_tiet_hdByMa_hd(ma_hd);
        ModelSPCT.setRowCount(0);
        sanphamct.forEach((chi_tiet_hd) -> {
            ModelSPCT.addRow(new Object[]{table_chi_tiet_hd.getRowCount() + 1, chi_tiet_hd.getMasp(), chi_tiet_hd.getTen_sp(), chi_tiet_hd.getSo_luong(), chi_tiet_hd.getGiaban(), chi_tiet_hd.getGia()});
        });
    }//GEN-LAST:event_table_hdMouseClicked
// xóa sản phẩm khỏi giỏ hàng
    private void btnXoa_gioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_gioActionPerformed
         
        selectedIndex = table_chi_tiet_hd.getSelectedRow();
        chi_tiet_hd sp = sanphamct.get(selectedIndex);
       int k= sp.getGia();
         int kq= Integer.parseInt(jtong.getText());
         jtong.setText((kq-k)+"");
        sanphamct.remove(selectedIndex);
        showTableSPCT();
    }//GEN-LAST:event_btnXoa_gioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CustomerModify khach = new CustomerModify();
        Jdiemcoss.setText(khach.getdiem(a.getmakh(jsdt.getText())) + "");
        //a.getmakh(Integer.parseInt(jsdt.getText()))
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if ((Integer.parseInt(Jdungdiem.getText()) <= (Integer.parseInt(Jdiemcoss.getText()))) && (Integer.parseInt(Jdungdiem.getText()) >= 0 && dem == 0)) {
            int k = (Integer.parseInt(jtong.getText())) - (1000 * Integer.parseInt(Jdungdiem.getText()));
            System.out.println("11111" + Integer.parseInt(jtong.getText()));
            System.out.println("22222" + Integer.parseInt(Jdungdiem.getText()));
            System.out.println("ahi=====" + k);
            jtong.setText(k + "");
            dem++;
        } else {
            JOptionPane.showMessageDialog(this, "bạn không đủ điều kiện đổi điểm");

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
        Home_Banhang ah = new Home_Banhang();
        ah.show();
    }//GEN-LAST:event_jButton4ActionPerformed
// tìm kiếm sản phẩm
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (txtTensp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "!!! Chưa nhập tên sản phẩm cần tìm");
        } else {
            Product sp = sanpham.get(selectedIndex);
            if (sp.getSo_luong() > 0) {
                if (pr.getProductByName(txtTensp.getText()) == null) {
                    txtSp.setText(String.valueOf(sp.getMa_sp()));
                    txtTensp.setText(sp.getTen_sp());
                    txtGia.setText(sp.getGia_ban() + "");
                    JOptionPane.showMessageDialog(this, "!!! Không có sản phẩm  này");
                } else {
                    Product r = pr.getProductByName(txtTensp.getText());
                    setModel(r);
                }
            } else {
                JOptionPane.showMessageDialog(this, "san pham da het hang");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void combox_find_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_find_billActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) combox_find_bill.getSelectedItem();
        System.out.println("Lua chon: " + selectedItem);

        if (selectedItem.equalsIgnoreCase("SĐT khách")) {
            FindBillBy_sdt find1 = new FindBillBy_sdt(this, rootPaneCheckingEnabled);
            find1.setVisible(true);

        }
        if (selectedItem.equalsIgnoreCase("ngày mua")) {
            FindBillBy_ngay find2 = new FindBillBy_ngay(this, rootPaneCheckingEnabled);
            find2.setVisible(true);
        }
        if (selectedItem.equalsIgnoreCase("nhân viên")) {
            FindBillBy_tennv find3 = new FindBillBy_tennv(this, rootPaneCheckingEnabled);
            find3.setVisible(true);
        }
    }//GEN-LAST:event_combox_find_billActionPerformed

    
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
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jdiem;
    private javax.swing.JLabel Jdiemcos;
    private javax.swing.JLabel Jdiemcoss;
    private javax.swing.JTextField Jdungdiem;
    private javax.swing.JButton btnAdd_bill;
    private javax.swing.JButton btnAdd_sp;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnThanh_toan;
    private javax.swing.JButton btnXoa_gio;
    private javax.swing.JComboBox<String> combox_find_bill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField jsdt;
    private javax.swing.JLabel jtong;
    private javax.swing.JTable table_chi_tiet_hd;
    private javax.swing.JTable table_hd;
    private javax.swing.JTable table_sanpham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSo_luong;
    private javax.swing.JTextField txtSp;
    private javax.swing.JTextField txtTensp;
    // End of variables declaration//GEN-END:variables

}
