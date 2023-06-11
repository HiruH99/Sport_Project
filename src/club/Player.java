/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package club;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HIRUNI
 */
public class Player extends javax.swing.JFrame {

    int selectCheck = 0; // variable to identify wether a record is selected
    int pid;
    //================== variable declaration for DB connection====================
    private static final String username =ConnVariable.username1;
    private static final String password=ConnVariable.password1;
    private static final String dataconn =ConnVariable.dataconn1;
    
    Connection sqlconn= null;
    PreparedStatement pst =null;
    ResultSet RS =null;
//====================================================================================
    
    public Player() {
        initComponents();
         UpdateDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     //===========================Function to show and update content on table=========================
     public void UpdateDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("SELECT * FROM player");
            
           
            RS=pst.executeQuery();
            ResultSetMetaData StData = RS.getMetaData();
            
            int q = StData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)playerTable.getModel();
            RecordTable.setRowCount(0);
            
            while (RS.next()){
                Vector coloumnData =new Vector();
                
                for(int i=0;i<q;i++){
                    coloumnData.add(RS.getString("pid"));
                    coloumnData.add(RS.getString("pname"));
                    coloumnData.add(RS.getString("dob"));
                    coloumnData.add(RS.getString("address"));
                    coloumnData.add(RS.getString("gender"));
                    coloumnData.add(RS.getString("joindate"));
                      
                }
                RecordTable.addRow(coloumnData);
            }
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }   
        
    }
//========================================================================================================================================
    
     
     //==============================Function to set text fields null===========================
     private void ClearTextFields(){
         jTextFieldName.setText(null);
         jTextFieldDob.setText(null);   
         jTextFieldAddress.setText(null);
     }
     //===================================================================================

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldDob = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jComboBoxGender = new javax.swing.JComboBox<>();
        jButtonAddPlayer = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonView = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(227, 225, 225));
        jPanel1.setPreferredSize(new java.awt.Dimension(372, 648));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 523));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel2.setText("Name :");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel4.setText("Dob :");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel5.setText("Address :");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel6.setText("Gender :");

        jTextFieldName.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldDob.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldAddress.setBackground(new java.awt.Color(204, 204, 204));

        jComboBoxGender.setBackground(new java.awt.Color(204, 204, 204));
        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jButtonAddPlayer.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAddPlayer.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonAddPlayer.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddPlayer.setText("Add");
        jButtonAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPlayerActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 0, 0));
        jButtonUpdate.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReset.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldName)
                            .addComponent(jTextFieldDob, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(jTextFieldAddress)
                            .addComponent(jComboBoxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonAddPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel1.setText("Player Details ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 680));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonView.setBackground(new java.awt.Color(0, 0, 0));
        jButtonView.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonView.setForeground(new java.awt.Color(255, 255, 255));
        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonView, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 90, 30));

        jButtonDelete.setBackground(new java.awt.Color(0, 0, 0));
        jButtonDelete.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 90, 30));

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 90, 30));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setText("Players list");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, -1));

        playerTable.setBackground(new java.awt.Color(204, 204, 204));
        playerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Date of birth", "Address", "Gender", "Joined Date"
            }
        ));
        playerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(playerTable);
        if (playerTable.getColumnModel().getColumnCount() > 0) {
            playerTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            playerTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 544, 254));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel10.setText("Search Name :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 88, -1));

        jTextFieldSearch.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 170, -1));

        jButtonSearch.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSearch.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 0, 900, 680));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 0, 690, 680));

        setSize(new java.awt.Dimension(987, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    //===========================Add Button=================================================================
    private void jButtonAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPlayerActionPerformed
         // =============================================add new player to DB=================================  
    
    //If clause is used to make sure no any record is selected while adding a new player
    if(selectCheck==0){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("insert into player (pname,dob,address,gender,joindate) values(?,?,?,?,curdate())");
            
            //get values from interface
            pst.setString(1,jTextFieldName.getText());
            pst.setString(2,jTextFieldDob.getText());
            pst.setString(3,jTextFieldAddress.getText());
            pst.setString(4,(String) jComboBoxGender.getSelectedItem());
            
           // execute statement
           pst.executeUpdate();
           JOptionPane.showMessageDialog(this, "New player Added.");
           
            //call function to update table
           UpdateDB();
           //Clear text fields
           ClearTextFields();
           selectCheck = 0;
           sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }   
    else if (selectCheck==1){
        JOptionPane.showMessageDialog(this,"Duplicate Player. Please Reset Fields");
    }
    //====================================================================================================================    
        
    }//GEN-LAST:event_jButtonAddPlayerActionPerformed

    
    
    //======================Delete Button======================================
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        //========store selected player ID=======
        int pid= Integer.parseInt(playerTable.getValueAt(playerTable.getSelectedRow(), 0).toString());
        
        //==========Get User Confirmation==============
        int deleteItem= JOptionPane.showConfirmDialog(null, "Confirm to Delete Player.","warning",JOptionPane.YES_NO_OPTION);
        
        //======if yes execute delete=====
        if (deleteItem==JOptionPane.YES_OPTION){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("delete from player where pid=?");
                
                pst.setInt(1, pid);
                pst.executeUpdate();
                sqlconn.close();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //======update BD=====
            UpdateDB();
            ClearTextFields();
            
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    
    
    //=========================Update Button=================================
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        //===================stor selected row ID ===================
       int pid = Integer.parseInt(playerTable.getValueAt(playerTable.getSelectedRow(), 0).toString());
       //user confirmation
       int update= JOptionPane.showConfirmDialog(null, "Confirm to Update Player Information.","warning",JOptionPane.YES_NO_OPTION);
       //if yes execute
       if (update==JOptionPane.YES_OPTION){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("update player set pname=?,dob=?,address=?,gender=? where pid=? ");
                
                pst.setString(1, jTextFieldName.getText());
                pst.setString(2, jTextFieldDob.getText());
                pst.setString(3, jTextFieldAddress.getText());
                pst.setString(4, (String) jComboBoxGender.getSelectedItem());
                pst.setInt(5, pid);
                
                pst.executeUpdate();
                sqlconn.close();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //======update BD=====
            UpdateDB();
            ClearTextFields();
            
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    
    
    //==========When Selected A row========================
    private void playerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerTableMouseClicked
        int selectedRow= playerTable.getSelectedRow();
        
        jTextFieldName.setText(playerTable.getValueAt(selectedRow, 1).toString());
        jTextFieldDob.setText(playerTable.getValueAt(selectedRow, 2).toString());
        jTextFieldAddress.setText(playerTable.getValueAt(selectedRow, 3).toString());
        jComboBoxGender.setSelectedItem(playerTable.getValueAt(selectedRow,4).toString());
        
        pid = Integer.parseInt(playerTable.getValueAt(playerTable.getSelectedRow(), 0).toString()); 
        selectCheck = 1;
        PlayerDetails.selectedPid=pid;// set variable in PlayerDetail Jframe
    }//GEN-LAST:event_playerTableMouseClicked

    
    //=======================Reset Button================================
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        ClearTextFields();
        selectCheck=0;
    }//GEN-LAST:event_jButtonResetActionPerformed

    
    
    //==============================Search Button=====================================
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("select * from player where pname like ? ");
                
                String text=jTextFieldSearch.getText();
                pst.setString(1,"%"+text+"%");
                
                RS=pst.executeQuery();
            ResultSetMetaData StData = RS.getMetaData();
            
            int q = StData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)playerTable.getModel();
            RecordTable.setRowCount(0);
            
            while (RS.next()){
                Vector coloumnData =new Vector();
                
                for(int i=0;i<q;i++){
                    coloumnData.add(RS.getString("pid"));
                    coloumnData.add(RS.getString("pname"));
                    coloumnData.add(RS.getString("dob"));
                    coloumnData.add(RS.getString("address"));
                    coloumnData.add(RS.getString("gender"));
                    coloumnData.add(RS.getString("joindate"));
                      
                }
                RecordTable.addRow(coloumnData);
                sqlconn.close();
            }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    
    //==================================Back Button===================================
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButtonBackActionPerformed

    
    //========================view button==============================
    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
       
       //if clause is used to identify wether a row is selected
       if (selectCheck==0){
           JOptionPane.showMessageDialog(this, "Please select a player");
       }
       
       if(selectCheck==1){
          
           
           PlayerDetails pd =new PlayerDetails();
            
           pd.setVisible(true);
       }
        
    }//GEN-LAST:event_jButtonViewActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPlayer;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonView;
    private javax.swing.JComboBox<String> jComboBoxGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldDob;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTable playerTable;
    // End of variables declaration//GEN-END:variables
}
