/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.pong.vapor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriane
 */
public class CreateAccount extends javax.swing.JDialog {

    /**
     * Creates new form CreateAccount
     */
    public CreateAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accountNameLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        accountNameLabel2 = new javax.swing.JLabel();
        accountNameLabel3 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        repasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        accountNameLabel1.setFont(new java.awt.Font("Lato Semibold", 1, 24)); // NOI18N
        accountNameLabel1.setText("Create Username:");

        usernameField.setFont(new java.awt.Font("Lato Light", 0, 18)); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        accountNameLabel2.setFont(new java.awt.Font("Lato Semibold", 1, 24)); // NOI18N
        accountNameLabel2.setText("Enter Password:");

        accountNameLabel3.setFont(new java.awt.Font("Lato Semibold", 1, 24)); // NOI18N
        accountNameLabel3.setText("Re-enter Password:");

        createButton.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Lato Light", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Lato Light", 0, 18)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        repasswordField.setFont(new java.awt.Font("Lato Light", 0, 18)); // NOI18N
        repasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repasswordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(createButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(repasswordField)
                    .addComponent(accountNameLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accountNameLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(accountNameLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(207, 207, 207))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(passwordField)
                    .addGap(209, 209, 209)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelButton)
                .addGap(31, 31, 31)
                .addComponent(accountNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(accountNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(accountNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(repasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createButton)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(216, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        String inputtedUsername=usernameField.getText();                        // gets username inputted from the username field
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:vapordb.db");       // starts a connection with the database file
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM accounts WHERE username='" + inputtedUsername + "'");     // finds the row of the inputted username if it even exists          

            if(rs.isBeforeFirst()){                                             // checks if the username is in the accounts table   
                JOptionPane.showMessageDialog(null, "Username already exists.", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (passwordField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a password.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                if (passwordField.getText().equals(repasswordField.getText())) {
                    PreparedStatement st = conn.prepareStatement("INSERT INTO accounts(username, password, balance) VALUES (?, ?, ?)");
                    st.setString(1, inputtedUsername);
                    st.setString(2, Password.encryptPassword(repasswordField.getText()));
                    st.setDouble(3, 0);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Account successfully added.", "Success", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        } catch (Exception e ) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void repasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repasswordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateAccount dialog = new CreateAccount(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountNameLabel1;
    private javax.swing.JLabel accountNameLabel2;
    private javax.swing.JLabel accountNameLabel3;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField repasswordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
