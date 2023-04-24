/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.connguoi.NhanVien;
import model.share.ConnectDB;
import model.share.DiaChi;

/**
 *
 * @author thanh
 */
public class MainView extends javax.swing.JFrame {

    NhanVien nhanVien = null;
    /**
     * Creates new form MainView
     */
    private final CardLayout card;
    private final Color color_hover = new Color(216, 238, 255);
    private final Color color_active = new Color(187, 222, 251);
    private final Color default_color = new Color(242, 242, 242);

    public MainView() {
        connectDB();
        initComponents();

        card = (CardLayout) this.pnl_main.getLayout();
//        logout();

//  Khi ra mắt phải chỉnh lại chưa đăng nhập
        DiaChi dc = new DiaChi("s", "ds", "dsf", "dsà", "dsf", "dc0");
        try {
//            Nhân viên kinh doanh
            NhanVien nhanVien = new NhanVien("NV0001", "Quản lí", "Nguyễn Thanh Cảnh", "0123123123", "thanhcanhit@gmail.com", LocalDate.of(2003, 1, 1), dc, false);
            login(nhanVien);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        Sự kiện đóng
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Bạn có thật sự muốn tắt ComputerPartsShop?", "Đóng ứng dụng?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                    Đóng kết nối
                    ConnectDB.disconnect();
                    System.exit(0);
                }
            }
        });

//        Sự kiện đổi size
//        this.addComponentListener(new ComponentAdapter() {
//            public void componentResized(ComponentEvent e) {
//                ((Panel_Home) pnl_home).resizeImg();
//            }
//        });
    }

    public void connectDB() {
        try {
            ConnectDB.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối đến server!", "Lỗi", JOptionPane.DEFAULT_OPTION);
            System.exit(0);
        }
    }

    public void logout() {
        this.nhanVien = null;

        this.lbl_name.setText("");
        headerRender(this.btn_login);
        this.card.show(this.pnl_main, "home");

        buttonActive(lbl_home);
        disableAllFunction();
    }

    public void login(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        pnl_cart = new Panel_BanHang(nhanVien);
        pnl_main.add(this.pnl_cart, "cart");

        this.lbl_name.setText(nhanVien.getChucDanh() + ". " + nhanVien.getHoTen());
        headerRender(this.lbl_name);

        activeAllFunction();
    }

    public void headerRender(Component comp) {
        this.pnl_header.removeAll();
        this.pnl_header.add(comp);
        this.pnl_header.setVisible(false);
        this.pnl_header.setVisible(true);
    }

    public void disableAllFunction() {
        Arrays.stream(new Component[]{lbl_cart, lbl_customers, lbl_employees, lbl_inventory, lbl_logout, lbl_products}).forEach(item -> item.setVisible(false));
    }

    public void activeAllFunction() {
        Arrays.stream(new Component[]{lbl_cart, lbl_customers, lbl_employees, lbl_inventory, lbl_logout, lbl_products}).forEach(item -> item.setVisible(true));
        if (nhanVien.getChucDanh().equalsIgnoreCase("Nhân viên kinh doanh")) {
            lbl_employees.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_header = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        pnl_control = new javax.swing.JPanel();
        lbl_home = new javax.swing.JLabel();
        lbl_cart = new javax.swing.JLabel();
        lbl_products = new javax.swing.JLabel();
        lbl_inventory = new javax.swing.JLabel();
        lbl_customers = new javax.swing.JLabel();
        lbl_employees = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lbl_logout = new javax.swing.JLabel();
        pnl_main = new javax.swing.JPanel();
        pnl_home = new javax.swing.JPanel();
        pnl_cart = new javax.swing.JPanel();
        pnl_products = new javax.swing.JPanel();
        pnl_inventory = new javax.swing.JPanel();
        pnl_customers = new javax.swing.JPanel();
        pnl_employees = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computer Parts Shop");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")).getImage());

        pnl_header.setBackground(new java.awt.Color(65, 165, 238));
        pnl_header.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pnl_header.setMinimumSize(new java.awt.Dimension(500, 27));
        pnl_header.setPreferredSize(new java.awt.Dimension(500, 30));
        pnl_header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));

        lbl_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_name.setText("Nhân viên kinh doanh .Nguyễn Thanh Cảnh");
        lbl_name.setToolTipText("");
        lbl_name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_name.setMaximumSize(new java.awt.Dimension(500, 30));
        lbl_name.setMinimumSize(new java.awt.Dimension(500, 30));
        lbl_name.setPreferredSize(new java.awt.Dimension(500, 30));
        pnl_header.add(lbl_name);

        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(65, 165, 238));
        btn_login.setText("Đăng nhập");
        btn_login.setPreferredSize(new java.awt.Dimension(150, 30));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        pnl_header.add(btn_login);

        getContentPane().add(pnl_header, java.awt.BorderLayout.NORTH);

        pnl_control.setMaximumSize(new java.awt.Dimension(50, 0));
        pnl_control.setMinimumSize(new java.awt.Dimension(50, 0));
        pnl_control.setPreferredSize(new java.awt.Dimension(70, 0));
        pnl_control.setLayout(new javax.swing.BoxLayout(pnl_control, javax.swing.BoxLayout.Y_AXIS));

        lbl_home.setBackground(color_active);
        lbl_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        lbl_home.setToolTipText("Trang chủ");
        lbl_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_home.setDisabledIcon(null);
        lbl_home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_home.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_home.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_home.setOpaque(true);
        lbl_home.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_home);

        lbl_cart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart.png"))); // NOI18N
        lbl_cart.setToolTipText("Đặt hàng");
        lbl_cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_cart.setDisabledIcon(null);
        lbl_cart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_cart.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_cart.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_cart.setOpaque(true);
        lbl_cart.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_cart);

        lbl_products.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_products.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product_manager.png"))); // NOI18N
        lbl_products.setToolTipText("Quản lí sản phẩm");
        lbl_products.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_products.setDisabledIcon(null);
        lbl_products.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_products.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_products.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_products.setOpaque(true);
        lbl_products.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_products);

        lbl_inventory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/packing.png"))); // NOI18N
        lbl_inventory.setToolTipText("Quản lí đơn hàng");
        lbl_inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_inventory.setDisabledIcon(null);
        lbl_inventory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_inventory.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_inventory.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_inventory.setOpaque(true);
        lbl_inventory.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_inventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_inventory);

        lbl_customers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        lbl_customers.setToolTipText("Quản lí khách hàng");
        lbl_customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_customers.setDisabledIcon(null);
        lbl_customers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_customers.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_customers.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_customers.setOpaque(true);
        lbl_customers.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_customersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_customers);

        lbl_employees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employees.png"))); // NOI18N
        lbl_employees.setToolTipText("Quản lí nhân viên");
        lbl_employees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_employees.setDisabledIcon(null);
        lbl_employees.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_employees.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_employees.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_employees.setOpaque(true);
        lbl_employees.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_employeesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_employees);
        pnl_control.add(filler1);

        lbl_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        lbl_logout.setToolTipText("Đăng xuất");
        lbl_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_logout.setDisabledIcon(null);
        lbl_logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_logout.setMaximumSize(new java.awt.Dimension(70, 50));
        lbl_logout.setMinimumSize(new java.awt.Dimension(70, 50));
        lbl_logout.setOpaque(true);
        lbl_logout.setPreferredSize(new java.awt.Dimension(70, 70));
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonExitHover(evt);
            }
        });
        pnl_control.add(lbl_logout);

        getContentPane().add(pnl_control, java.awt.BorderLayout.LINE_START);

        pnl_main.setPreferredSize(new java.awt.Dimension(1000, 700));
        pnl_main.setLayout(new java.awt.CardLayout());

        pnl_home.setBackground(new java.awt.Color(255, 255, 255));
        pnl_home.setLayout(new java.awt.BorderLayout());
        pnl_home = new Panel_Home();
        pnl_main.add(pnl_home, "home");

        pnl_cart.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main.add(pnl_cart, "cart");

        pnl_products.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main.add(pnl_products, "products");

        pnl_inventory.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main.add(pnl_inventory, "inventory");

        pnl_customers.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main.add(pnl_customers, "customers");

        pnl_employees.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main.add(pnl_employees, "employees");

        getContentPane().add(pnl_main, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseClicked
        
        card.show(this.pnl_main, "home");
        buttonActive(evt.getComponent());
    }//GEN-LAST:event_lbl_homeMouseClicked

    private void lbl_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cartMouseClicked
//        pnl_cart = new Panel_BanHang();
//        pnl_main.add(this.pnl_cart, "cart");
        card.show(this.pnl_main, "cart");
        buttonActive(evt.getComponent());
    }//GEN-LAST:event_lbl_cartMouseClicked

    private void lbl_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productsMouseClicked
        pnl_products = new Panel_QuanLySanPham();
        pnl_main.add(this.pnl_products, "products");
        card.show(this.pnl_main, "products");
        buttonActive(evt.getComponent());
    }//GEN-LAST:event_lbl_productsMouseClicked

    private void lbl_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_inventoryMouseClicked
        pnl_inventory = new Panel_QuanLyDonHang(this.nhanVien);
        pnl_main.add(this.pnl_inventory, "inventory");
        card.show(this.pnl_main, "inventory");
        buttonActive(evt.getComponent());
    }//GEN-LAST:event_lbl_inventoryMouseClicked

    private void lbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_customersMouseClicked
        pnl_customers = new Panel_QuanLyKhachHang();
        pnl_main.add(this.pnl_customers, "customers");
        card.show(this.pnl_main, "customers");
        buttonActive(evt.getComponent());
    }//GEN-LAST:event_lbl_customersMouseClicked

    private void lbl_employeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_employeesMouseClicked
        pnl_employees = new Panel_QuanLyNhanVien();
        pnl_main.add(this.pnl_employees, "employees");
        card.show(this.pnl_main, "employees");
        buttonActive(evt.getComponent());
    }//GEN-LAST:event_lbl_employeesMouseClicked

    private void buttonHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHover
        if (evt.getComponent().getBackground().equals(default_color))
            evt.getComponent().setBackground(color_hover);
    }//GEN-LAST:event_buttonHover

    private void buttonExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExitHover
        if (evt.getComponent().getBackground().equals(color_hover))
            evt.getComponent().setBackground(default_color);
    }//GEN-LAST:event_buttonExitHover

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        new Frame_DangNhap(this).setVisible(true);
    }//GEN-LAST:event_btn_loginActionPerformed

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        if (JOptionPane.showConfirmDialog(this, "Bạn có thật sự muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            logout();
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void buttonActive(Component c) {
        Arrays.stream(new Component[]{lbl_cart, lbl_customers, lbl_employees, lbl_home, lbl_inventory, lbl_logout, lbl_products}).forEach(item -> item.setBackground(default_color));
        c.setBackground(color_active);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatIntelliJLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel lbl_cart;
    private javax.swing.JLabel lbl_customers;
    private javax.swing.JLabel lbl_employees;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_inventory;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_products;
    private javax.swing.JPanel pnl_cart;
    private javax.swing.JPanel pnl_control;
    private javax.swing.JPanel pnl_customers;
    private javax.swing.JPanel pnl_employees;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_inventory;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_products;
    // End of variables declaration//GEN-END:variables
}
