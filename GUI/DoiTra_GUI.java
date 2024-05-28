package GUI;

import java.awt.CardLayout;
import java.awt.Color;

public class DoiTra_GUI extends javax.swing.JPanel {

    private CardLayout cartLayout;

    /**
     * Creates new form HoaDon_JPanel
     */
    public DoiTra_GUI() {
        initComponents();
        setBounds(0, 0, 1186, 748);
        cartLayout = new CardLayout();
        panel_content.setLayout(cartLayout);
        
        TaoDoiTra_JPanel TaoDoiTra_Panel = new TaoDoiTra_JPanel();
        QuanLyDoiTra_JPanel QuanLyDoiTra_Panel = new QuanLyDoiTra_JPanel();
        panel_content.add(TaoDoiTra_Panel, "TaoDoiTra");
        panel_content.add(QuanLyDoiTra_Panel, "QuanLyDoiTra");
        
        btn_TaoDoiTra.setBackground(new Color(187,205,197));
        btn_TaoDoiTra.setSelected(true);
        btn_TaoDoiTra.setForeground(Color.black);
        btn_TaoDoiTra.setBorder(null);
        btn_QuanLyDoiTra.setBackground(new Color(0,51,51));
        btn_QuanLyDoiTra.setSelected(false);
        btn_QuanLyDoiTra.setForeground(Color.white);
        cartLayout.show(panel_content, "TaoDoiTra");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        btn_TaoDoiTra = new javax.swing.JButton();
        btn_QuanLyDoiTra = new javax.swing.JButton();
        panel_content = new javax.swing.JPanel();

        setBackground(new Color(22, 97, 86));
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setPreferredSize(new java.awt.Dimension(1186, 748));

        panel_menu.setBackground(new Color(22, 97, 86));

        btn_TaoDoiTra.setBackground(new Color(22, 97, 86));
        btn_TaoDoiTra.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_TaoDoiTra.setForeground(new Color(255, 255, 255));
        btn_TaoDoiTra.setText("Tạo đơn đổi trả");
        btn_TaoDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoDoiTraActionPerformed(evt);
            }
        });

        btn_QuanLyDoiTra.setBackground(new Color(128,82,246));
        btn_QuanLyDoiTra.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_QuanLyDoiTra.setForeground(new Color(255, 255, 255));
        btn_QuanLyDoiTra.setText("Quản lý đơn đổi trả");
        btn_QuanLyDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuanLyDoiTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addComponent(btn_TaoDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_QuanLyDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_TaoDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_QuanLyDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(836, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TaoDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoDoiTraActionPerformed
        btn_TaoDoiTra.setBackground(new Color(187,205,197));
        btn_TaoDoiTra.setSelected(true);
        btn_TaoDoiTra.setForeground(Color.black);
        btn_TaoDoiTra.setBorder(null);
        btn_QuanLyDoiTra.setBackground(new Color(0,51,51));
        btn_QuanLyDoiTra.setSelected(false);
        btn_QuanLyDoiTra.setForeground(Color.white);
        cartLayout.show(panel_content, "TaoDoiTra");
    }//GEN-LAST:event_btn_TaoDoiTraActionPerformed

    private void btn_QuanLyDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuanLyDoiTraActionPerformed
        btn_QuanLyDoiTra.setBackground(new Color(187,205,197));
        btn_QuanLyDoiTra.setSelected(true);
        btn_QuanLyDoiTra.setForeground(Color.black);
        btn_QuanLyDoiTra.setBorder(null);
        btn_TaoDoiTra.setBackground(new Color(0,51,51));
        btn_TaoDoiTra.setSelected(false);
        btn_TaoDoiTra.setForeground(Color.white);
        cartLayout.show(panel_content, "QuanLyDoiTra");
    }//GEN-LAST:event_btn_QuanLyDoiTraActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_QuanLyDoiTra;
    private javax.swing.JButton btn_TaoDoiTra;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables
}
