/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import login.logindash;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author w10
 */
public class adminStaff extends javax.swing.JFrame {
    public String uname;
    public adminStaff(String name) {
        initComponents();
        uname = name;
        displayName(getData("u_fname","tbl_users", "u_username", uname)+ " " + getData("u_lname","tbl_users", "u_username", uname));
        displayTable();
    }
    
    public void displayName(String uname){
        username.setText(uname);
    }
    
    public static String getData(String a,String b, String c, String d){
        dbConnector connector = new dbConnector();
        String returnString = null;
        try{
            String query = "SELECT "+a+" FROM "+b+"  WHERE "+c+" = '" +d + "'";
            ResultSet resultSet = connector.getData(query);
            if (resultSet.next()) {
                returnString = resultSet.getString(a);
                return returnString;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return returnString;
    }
    
    public void displayTable(){
        try{
            dbConnector connector = new dbConnector();
            String query = "SELECT * FROM tbl_users";
            ResultSet rs = connector.getData(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchbar = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(76, 205, 153));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 127, 115));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("System Administrator");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-admin-70.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, 90));

        username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("System Administrator");
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jPanel3.setBackground(new java.awt.Color(246, 233, 178));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Logout");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 106, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 50));

        jPanel4.setBackground(new java.awt.Color(246, 233, 178));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-bus-25.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Buses");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 106, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 50));

        jPanel5.setBackground(new java.awt.Color(246, 233, 178));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Staff");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 106, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-staff-25.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 50));

        jPanel6.setBackground(new java.awt.Color(246, 233, 178));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Settings");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 106, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-setting-25.png"))); // NOI18N
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 50));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 190, 500);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(210, 102, 570, 380);
        jPanel1.add(searchbar);
        searchbar.setBounds(210, 60, 190, 30);

        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-search-20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(400, 60, 40, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(450, 60, 90, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton4.setText("REFRESH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(540, 60, 80, 30);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton5.setText("EDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(620, 60, 80, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setText("DELETE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(700, 60, 80, 30);

        jPanel8.setBackground(new java.awt.Color(186, 205, 146));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(200, 50, 590, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        adminBusses bus = new adminBusses(uname);
        bus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        adminStaff bus = new adminStaff(uname);
        bus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        adminSettings bus = new adminSettings(uname);
        bus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        logindash log = new logindash();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM tbl_users WHERE u_id LIKE '%" + query + "%' OR u_fname LIKE '%" + query + "%' OR u_lname LIKE '%" + query + "%' OR u_username LIKE '%" 
                + query +"%' OR u_email LIKE '%" + query +"%' OR u_num LIKE '%" + query +"%' OR u_status LIKE '%" + query +"%' OR u_type LIKE '%" + query +"%'";
    
        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        adminStaffAdd add = new adminStaffAdd();
        add.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        displayTable();
        searchbar.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int rowid = table.getSelectedRow();
        TableModel model = table.getModel();
        
        if(rowid != -1){
            adminStaffEdit edit = new adminStaffEdit();
            edit.setVisible(true);
            edit.accessTable(model, rowid);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a staff!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int rowid = table.getSelectedRow();
        TableModel model = table.getModel();
        
        if(rowid != -1){
            Object value = model.getValueAt(rowid, 0);
            String id = value.toString();
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to Delete ID "+id +"?");
            if(confirm == JOptionPane.YES_OPTION){
                dbConnector connect = new dbConnector();
                int u_id = Integer.parseInt(id);
                connect.deleteData(u_id, "tbl_users", "u_id");
            }
            displayTable();
        }else{
            JOptionPane.showMessageDialog(this, "Please select a staff!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
      busconfig cons = busconfig();
      cons.Visible(true);
      this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(adminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminStaff("joshuateves123").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchbar;
    private javax.swing.JTable table;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    private busconfig busconfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
