/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ViewComponents;
import Model.MenuModel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    private EventSelected event;
    public void addEventSelected(EventSelected event){
        this.event=event;
        menuList1.addEventSelected(event);
    }
    
    public Menu() {
        initComponents();
        setOpaque(false);
        //menuList1.setOpaque(false);
        addList();
    }

    private void addList(){
        menuList1.addItems(new MenuModel("dashboard","Dashboard",MenuModel.MenuType.MENU));
        menuList1.addItems(new MenuModel("sales","Sales",MenuModel.MenuType.MENU));
        menuList1.addItems(new MenuModel("products","Products",MenuModel.MenuType.MENU));
        menuList1.addItems(new MenuModel("reports","Reports",MenuModel.MenuType.MENU));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSideMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuList1 = new Control.MenuController<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));

        panelSideMain.setOpaque(false);

        javax.swing.GroupLayout panelSideMainLayout = new javax.swing.GroupLayout(panelSideMain);
        panelSideMain.setLayout(panelSideMainLayout);
        panelSideMainLayout.setHorizontalGroup(
            panelSideMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelSideMainLayout.setVerticalGroup(
            panelSideMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        menuList1.setBackground(new java.awt.Color(0, 102, 102));
        menuList1.setBorder(null);
        menuList1.setForeground(new java.awt.Color(255, 255, 255));
        menuList1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(menuList1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.jpg"))); // NOI18N
        jLabel1.setText("  ShopSpeed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSideMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSideMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics graphic) {
        try {
        Graphics2D g1= (Graphics2D) graphic;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g= new GradientPaint(0, 0, Color.decode("#093028"), 0, getHeight(), Color.decode("#34e89e"));
        g1.setPaint(g);
        g1.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g1.fillRect(getWidth()-20, 0, getWidth(), getHeight());
       super.paintChildren(graphic); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error occurred" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();  
        }
    }

    private int x;
    private int y;
    
    public void initMoving(JFrame frame){
        panelSideMain.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                x=e.getX();
                y=e.getY();// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        panelSideMain.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen()- y); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Control.MenuController<String> menuList1;
    private javax.swing.JPanel panelSideMain;
    // End of variables declaration//GEN-END:variables
}