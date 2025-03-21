/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pong.vapor;

/**
 *
 * @author Adriane
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Store extends javax.swing.JFrame {
    

    
    //---------------------------------------------------------------------------------------------------------------------//
    // initializes the table model to display cells in store table when first opening the store page
    public static DefaultTableModel initStoreTableModel() {         
        DefaultTableModel storeTableModel = new DefaultTableModel();

        // Sets the first row values
        storeTableModel.setColumnIdentifiers(new String[]{
            "Name", "Release Date", "User Rating", "Popularity", "Price"
        });

        // Iterates through the array list of games to place in the table model (Creates a new row for each game)
            for (Game o : staticVar.storeResults) {
                storeTableModel.addRow(new Object[]{
                    o.name, 
                    o.releaseDate, 
                    o.userRating,
                    o.popularity, 
                    "$ " + o.price
                });
            }

            return storeTableModel;
    }
    
    
    static void storeResultQuery() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:vapordb.db");
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM games ORDER BY user_rating DESC");
            
            staticVar.storeResults.clear();
            while (rs.next()) {
                staticVar.storeResults.add(new Game(rs.getInt("game_id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"),rs.getString("release_date"), rs.getInt("developer_id"), rs.getInt("user_rating"), rs.getDouble("popularity")));
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------------------------------------------------//
    // changes the order of the table display if there is a filter
    public static DefaultTableModel initStoreTableModel(String searchResult, String filterSelection) {         
        DefaultTableModel storeTableModel = new DefaultTableModel();

        // Sets the first row values
        storeTableModel.setColumnIdentifiers(new String[]{
            "Name", "Release Date", "User Rating", "Popularity", "Price"
        });

        storeResultQuery(searchResult, filterSelection);
        // Iterates through the array list of patients to place in the table model (Creates a new row for each patient)
            for (Game o : staticVar.storeResults) {
                storeTableModel.addRow(new Object[]{
                    o.name, 
                    o.releaseDate, 
                    o.userRating,
                    o.popularity, 
                    "$ " + o.price
                });
            }

            return storeTableModel;
    }
      
    static void storeResultQuery(String searchResult, String filterSelection) {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:vapordb.db");
                        
            String orderBy = "ORDER BY user_rating DESC";
            if (orderComboBox.getSelectedItem().equals("Sort by Name [A-Z]")) {
                orderBy = "ORDER BY name ASC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Name [Z-A]")) {
                orderBy = "ORDER BY name DESC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Price [Highest to Lowest]")) {
                orderBy = "ORDER BY price DESC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Price [Lowest to Highest]")) {
                orderBy = "ORDER BY price ASC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Popularity [Highest to Lowest]")) {
                orderBy = "ORDER BY popularity DESC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Popularity [Lowest to Highest]")) {
                orderBy = "ORDER BY popularity ASC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by User Rating [Highest to Lowest]")) {
                orderBy = "ORDER BY user_rating DESC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by User Rating [Lowest to Highest]")) {
                orderBy = "ORDER BY user_rating ASC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Release Date [Latest to Earliest]")) {
                orderBy = "ORDER BY release_date DESC";
            } else if (orderComboBox.getSelectedItem().equals("Sort by Release Date [Earliest to Latest]")) {
                orderBy = "ORDER BY release_date ASC";
            }
            
            
            // SQL Injection Proofed
            String searchResultWhereFilter = "WHERE name LIKE ? OR name LIKE ? OR name LIKE ? OR name LIKE ?";
            PreparedStatement st = conn.prepareStatement("SELECT * FROM games " + searchResultWhereFilter + " " + orderBy);
            st.setString(1, searchResult + "%");
            st.setString(2, "%" + searchResult + " ");
            st.setString(3, " " + searchResult + "%");
            st.setString(4, "% " + searchResult + " %");
            
            ResultSet rs = st.executeQuery();
            
            staticVar.storeResults.clear();
            while (rs.next()) {
                staticVar.storeResults.add(new Game(rs.getInt("game_id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"),rs.getString("release_date"), rs.getInt("developer_id"), rs.getInt("user_rating"), rs.getDouble("popularity")));
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
    //---------------------------------------------------------------------------------------------------------------------//

    
    public Store() {
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

        vaporMarketPlaceLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        vaporMarketPlaceLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        balanceLabel = new javax.swing.JLabel();
        userBalance = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        orderComboBox = new javax.swing.JComboBox<>();
        filterButton = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        vaporMarketPlaceLabel.setFont(new java.awt.Font("Lato Light", 0, 24)); // NOI18N
        vaporMarketPlaceLabel.setForeground(new java.awt.Color(12, 12, 12));
        vaporMarketPlaceLabel.setText("Search");

        searchField.setFont(new java.awt.Font("Lato Light", 0, 18)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        vaporMarketPlaceLabel1.setFont(new java.awt.Font("Lato Semibold", 1, 48)); // NOI18N
        vaporMarketPlaceLabel1.setForeground(new java.awt.Color(12, 12, 12));
        vaporMarketPlaceLabel1.setText("VAPOR MARKETPLACE");
        vaporMarketPlaceLabel1.setToolTipText("");

        jTable1.setFont(new java.awt.Font("Meiryo", 0, 24)); // NOI18N
        jTable1.setModel(initStoreTableModel());
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(600);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(125);
        jScrollPane1.setViewportView(jTable1);

        balanceLabel.setFont(new java.awt.Font("Lato Light", 0, 24)); // NOI18N
        balanceLabel.setForeground(new java.awt.Color(12, 12, 12));
        balanceLabel.setText("Balance:");

        userBalance.setFont(new java.awt.Font("Lato Light", 1, 24)); // NOI18N
        userBalance.setForeground(new java.awt.Color(12, 12, 12));
        userBalance.setText("$ " + String.format("%.2f", staticVar.userThatIsLoggedIn.balance));

        backButton.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        orderComboBox.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        orderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by Name [A-Z]", "Sort by Name [Z-A]", "Sort by Price [Highest to Lowest]", "Sort by Price [Lowest to Highest]", "Sort by Popularity [Highest to Lowest]", "Sort by Popularity [Lowest to Highest]", "Sort by User Rating [Highest to Lowest]", "Sort by User Rating [Lowest to Highest]", "Sort by Release Date [Earliest to Latest]", "Sort by Release Date [Latest to Earliest]" }));
        orderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderComboBoxActionPerformed(evt);
            }
        });

        filterButton.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        filterButton.setText("Apply");
        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterButtonMouseClicked(evt);
            }
        });
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        cartButton.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        cartButton.setText("Cart");
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cartButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(vaporMarketPlaceLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vaporMarketPlaceLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(orderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(balanceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userBalance)
                        .addGap(912, 912, 912)
                        .addComponent(backButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(vaporMarketPlaceLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchField)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(vaporMarketPlaceLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterButton))
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceLabel)
                    .addComponent(userBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new MainMenu().setVisible(true);               // goes back to main menu
        dispose();                                  // deletes the current frame
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        java.awt.Point pointClicked = evt.getPoint();
        int row = jTable1.rowAtPoint(pointClicked);

        staticVar.previewedGame = staticVar.storeResults.get(row);
        GamePage dialog = new GamePage(new javax.swing.JFrame(), true); 

        dialog.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        jTable1.setModel(initStoreTableModel(searchField.getText(), orderComboBox.getSelectedItem().toString()));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(600);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(125);
    }//GEN-LAST:event_filterButtonActionPerformed

    private void filterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterButtonMouseClicked
        // Why is this here
    }//GEN-LAST:event_filterButtonMouseClicked

    private void orderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderComboBoxActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_orderComboBoxActionPerformed

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        Cart dialog = new Cart(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_cartButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Store().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JButton cartButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JComboBox<String> orderComboBox;
    private javax.swing.JTextField searchField;
    protected static javax.swing.JLabel userBalance;
    private javax.swing.JLabel vaporMarketPlaceLabel;
    private javax.swing.JLabel vaporMarketPlaceLabel1;
    // End of variables declaration//GEN-END:variables
}
