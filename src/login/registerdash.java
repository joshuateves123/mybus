/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import admin.adminDash;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author w10
 */
public class registerdash extends javax.swing.JFrame {

    /**
     * Creates new form logindash
     */
    public registerdash() {
        initComponents();
    }
    
public boolean checkData (String var, String check){
    dbConnector connect = new dbConnector();
    try{
        String sql = "SELECT * FROM tbl_users WHERE "+var+" = '"+check+"'";
        ResultSet rs = connect.getData(sql);
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }catch(SQLException ex){
        System.out.println("Connection Error: "+ex);
        return false;
    }
}

public static boolean isNum(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

public void add(String fname, String lname, String username, String mail, String number, String password, String type){
        dbConnector connect = new dbConnector();
        String hashpass = null;
        try {
            hashpass = passwordHasher.hashPassword(password);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        
        String insertQuery = "INSERT INTO tbl_users (u_fname, u_lname, u_username,u_email, u_num, u_password, u_type, u_status) VALUES ('"+fname+"','"+lname+"','"+username+"','"+mail+"','"+number+"','"+hashpass+"','"+type+"', 'Pending')";
        try {
            int rowsInserted = connect.insertData(insertQuery);
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registered Successfully. Wait for Admin Approval");
                logindash open = new logindash();
                open.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Staff!");
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
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

        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jPanel7.setBackground(new java.awt.Color(27, 66, 66));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(19, 93, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel1.setForeground(new java.awt.Color(92, 131, 116));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(0, 153, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel5);
        jPanel5.setBounds(-10, -10, 540, 270);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Password:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(110, 430, 90, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Username:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(110, 380, 100, 17);

        jTextField2.setText("jTextField1");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(200, 380, 190, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(160, 100, 210, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(158, 200, 185));
        jLabel12.setText("First Name:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(50, 110, 100, 17);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(158, 200, 185));
        jLabel8.setText("Last Name:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 150, 100, 17);

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(160, 140, 210, 30);

        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        jPanel1.add(uname);
        uname.setBounds(160, 180, 210, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(158, 200, 185));
        jLabel10.setText("Username:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 170, 90, 50);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(158, 200, 185));
        jLabel9.setText("Email Address:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 210, 110, 50);

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(160, 220, 210, 30);

        num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numActionPerformed(evt);
            }
        });
        jPanel1.add(num);
        num.setBounds(160, 260, 210, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(158, 200, 185));
        jLabel11.setText("Contact #:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(50, 270, 100, 17);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(158, 200, 185));
        jLabel6.setText("Password:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 310, 100, 17);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        jPanel1.add(type);
        type.setBounds(160, 340, 210, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(158, 200, 185));
        jLabel2.setText("User Type:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 350, 100, 17);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-register-20.png"))); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 390, 100, 29);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(158, 200, 185));
        jLabel13.setText("REGISTER");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(150, 40, 150, 20);
        jPanel1.add(pass);
        pass.setBounds(160, 300, 210, 30);

        jPanel7.add(jPanel1);
        jPanel1.setBounds(460, 50, 440, 470);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/BUSWAYZ.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(0, 0, 920, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(fname.getText().isEmpty() || lname.getText().isEmpty() || uname.getText().isEmpty() ||email.getText().isEmpty() || num.getText().isEmpty()|| pass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, " Please fill up all fields!");
        }else if (!(pass.getText().length()>=8)){
            JOptionPane.showMessageDialog(null, "Password must have 8 characters");
        }else if(checkData("u_username", uname.getText())){
            JOptionPane.showMessageDialog(null, "Username is already taken!");
        }else if(checkData("u_email", email.getText())){
            JOptionPane.showMessageDialog(null, "Email is already taken!");
        }else if(!isNum(num.getText())){
            JOptionPane.showMessageDialog(null, "Invalid contact number!");
        }else{
            add(fname.getText(),lname.getText(),uname.getText(),email.getText(), num.getText(),pass.getText(),(String)type.getSelectedItem());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(registerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerdash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField num;
    private javax.swing.JPasswordField pass;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}