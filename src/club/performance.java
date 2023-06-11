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
public class performance extends javax.swing.JFrame {
    private int selectCheck=0; //variable to identify wethere a row is selected or not
    
    //==============Database connection===========================
    private static final String username =ConnVariable.username1;
    private static final String password=ConnVariable.password1;
    private static final String dataconn =ConnVariable.dataconn1;
    
    Connection sqlconn= null;
    PreparedStatement pst =null;
    ResultSet RS =null;
    //=============================================================================

    
    
    
    
    public performance() {
        initComponents();
        SetComboSport();
        UpdateDB();
    }

    
    //========================Function to set sport names  to combobox========================================================
    private void SetComboSport(){
        jComboBoxSport.removeAllItems();
         try {
             String performpid = jTextFieldPid.getText();
             
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select sname from sport join relationplayer on relationplayer.sid=sport.sid where relationplayer.pid=?");
            
            pst.setString(1, performpid);
            RS=pst.executeQuery();
            
            
               while (RS.next()){
                  String cbValue = RS.getString("sname");
                  jComboBoxSport.addItem(cbValue);
                   
                   
            }
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    //==========================================================================================
    
    
    
    //===========================Function to show and update content on table=========================
    private void UpdateDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select pe.pid,p.pname,s.sname,pe.lev,pe.marks from performance pe ,player p ,sport s where pe.pid=p.pid and pe.sid=s.sid order by pe.pid");
            
            RS=pst.executeQuery();
            ResultSetMetaData StData = RS.getMetaData();
            
            int q = StData.getColumnCount();
            
            DefaultTableModel RecordTablePer = (DefaultTableModel)performanceTable.getModel();
            RecordTablePer.setRowCount(0);
            
            while (RS.next()){
                Vector coloumnData =new Vector();
                
                for(int i=0;i<q;i++){
                    coloumnData.add(RS.getString("pe.pid"));
                    coloumnData.add(RS.getString("p.pname"));
                    coloumnData.add(RS.getString("s.sname"));
                    coloumnData.add(RS.getString("pe.lev"));
                    coloumnData.add(RS.getString("pe.marks"));
                    
                    
                      
                }
                RecordTablePer.addRow(coloumnData);
            }
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }   
        
    }
    
  //============================================================================================================================
    
    
  //==============================Function to set text fields null===========================
     private void ClearTextFields(){
         jTextFieldPid.setText(null);
         jTextFieldLevel.setText(null);   
         jTextFieldMark.setText(null);
         
         jComboBoxSport.removeAllItems();
         selectCheck = 0; // deselect rows
     }
     //===================================================================================  
    
    
    
    
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
        jButtonUpdate = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPid = new javax.swing.JTextField();
        jTextFieldLevel = new javax.swing.JTextField();
        jTextFieldMark = new javax.swing.JTextField();
        jComboBoxSport = new javax.swing.JComboBox<>();
        jButtonValidate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        performanceTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(227, 225, 225));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel1.setText("Performance");

        jButtonUpdate.setBackground(new java.awt.Color(0, 0, 0));
        jButtonUpdate.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdd.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setText("Sport :");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setText("Player :");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Level :");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("Mark :");

        jTextFieldPid.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldPid.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTextFieldPidComponentAdded(evt);
            }
        });
        jTextFieldPid.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldPidInputMethodTextChanged(evt);
            }
        });

        jTextFieldLevel.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldMark.setBackground(new java.awt.Color(204, 204, 204));

        jComboBoxSport.setBackground(new java.awt.Color(204, 204, 204));
        jComboBoxSport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxSportKeyPressed(evt);
            }
        });

        jButtonValidate.setBackground(new java.awt.Color(0, 0, 0));
        jButtonValidate.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonValidate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonValidate.setText("Validate");
        jButtonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxSport, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldMark, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPid, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonValidate)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButtonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 680));

        performanceTable.setBackground(new java.awt.Color(204, 204, 204));
        performanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Player ID", "Player Name", "Sport ", "Level", "Marks"
            }
        ));
        performanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(performanceTable);
        if (performanceTable.getColumnModel().getColumnCount() > 0) {
            performanceTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            performanceTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 586, 190));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel2.setText("Search name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 123, -1));

        jTextFieldSearch.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 400, 190, -1));

        jButtonSearch.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSearch.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 90, 30));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setText("Performance Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 211, -1));

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 90, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 900, -1));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(987, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    //===============================Back Button=================================
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
       Menu m =new Menu();
       m.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldPidComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTextFieldPidComponentAdded
        
    }//GEN-LAST:event_jTextFieldPidComponentAdded

    private void jComboBoxSportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxSportKeyPressed
       
    }//GEN-LAST:event_jComboBoxSportKeyPressed

    private void jTextFieldPidInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldPidInputMethodTextChanged
        
    }//GEN-LAST:event_jTextFieldPidInputMethodTextChanged

    
    
    //=to know wether player has any sports==================
    private void jButtonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidateActionPerformed

        SetComboSport();
    }//GEN-LAST:event_jButtonValidateActionPerformed

    
    //==================when clicked a row=======================
    private void performanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_performanceTableMouseClicked
        jComboBoxSport.removeAllItems(); //reset sports
        int selectedRow= performanceTable.getSelectedRow();
        
        jTextFieldPid.setText(performanceTable.getValueAt(selectedRow, 0).toString());
        jTextFieldLevel.setText(performanceTable.getValueAt(selectedRow, 3).toString());
        jTextFieldMark.setText(performanceTable.getValueAt(selectedRow, 4).toString());
        
        SetComboSport();
        //if clause is used to set value if sport is null
        if(performanceTable.getValueAt(selectedRow,2)==null){
        jComboBoxSport.setSelectedIndex(0);
        }
        else{
           jComboBoxSport.setSelectedItem(performanceTable.getValueAt(selectedRow,2).toString()); 
        }
        
        
        
       
       
        selectCheck = 1;//identify a row is selected
        
        
    }//GEN-LAST:event_performanceTableMouseClicked

    
    //===================Reset Button======================
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        ClearTextFields();
    }//GEN-LAST:event_jButtonResetActionPerformed

    
    //=================Update Button=================
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        //===================stor selected row ID ===================
       int cid = Integer.parseInt(performanceTable.getValueAt(performanceTable.getSelectedRow(), 0).toString());
       //user confirmation
       int update= JOptionPane.showConfirmDialog(null, "Confirm to Update Performance.","warning",JOptionPane.YES_NO_OPTION);
       
       //if yes execute
       if (update==JOptionPane.YES_OPTION){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("update performance set lev=?,marks=? where pid=? and sid = (select sid from sport where sport.sname=?) ");
                
                pst.setString(1, jTextFieldLevel.getText());
                pst.setString(2, jTextFieldMark.getText());
                pst.setString(3, jTextFieldPid.getText());
                pst.setString(4, (String) jComboBoxSport.getSelectedItem());
                
                
                pst.executeUpdate();
                sqlconn.close(); 
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //======update BD=====
            UpdateDB();
            ClearTextFields();
            jComboBoxSport.removeAllItems();
           
        }
        
        
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    
    //========================Add Button===================================
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        //If clause is used to make sure no any record is selected while adding a new player
    if(selectCheck==0){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("insert into performance (pid,sid,lev,marks) values (?,(select sid from sport where sport.sname=?),?,?)");
            
            //get values from interface
            pst.setString(1,jTextFieldPid.getText());
            pst.setString(2,(String) jComboBoxSport.getSelectedItem());
            pst.setString(3,jTextFieldLevel.getText());
            pst.setString(4,jTextFieldMark.getText());
            
            
           // execute statement
           pst.executeUpdate();
           JOptionPane.showMessageDialog(this, "New Performance Added.");
           
            //call function to update table
           UpdateDB();
           //Clear text fields
           ClearTextFields();
           sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }   
    else if (selectCheck==1){
        JOptionPane.showMessageDialog(this,"Duplicate Performane. Please Reset Fields");
    }
        
        
        
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    
    //==========================Search Button================================
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
   try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("select pe.pid,p.pname,s.sname,pe.lev,pe.marks from performance pe join player p on pe.pid=p.pid join sport s on pe.sid=s.sid where p.pname like ? order by pe.pid  ");
                
                String text=jTextFieldSearch.getText();
                pst.setString(1,"%"+text+"%");
                
                RS=pst.executeQuery();
            ResultSetMetaData StData = RS.getMetaData();
            
            int q = StData.getColumnCount();
            
            DefaultTableModel RecordTablePer = (DefaultTableModel)performanceTable.getModel();
            RecordTablePer.setRowCount(0);
            
            while (RS.next()){
                Vector coloumnData =new Vector();
                
                for(int i=0;i<q;i++){
                    coloumnData.add(RS.getString("pe.pid"));
                    coloumnData.add(RS.getString("p.pname"));
                    coloumnData.add(RS.getString("s.sname"));
                    coloumnData.add(RS.getString("pe.lev"));
                    coloumnData.add(RS.getString("pe.marks"));
                    
                    
                      
                }
                RecordTablePer.addRow(coloumnData);
                sqlconn.close();
            }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(performance.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new performance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonValidate;
    private javax.swing.JComboBox<String> jComboBoxSport;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldLevel;
    private javax.swing.JTextField jTextFieldMark;
    private javax.swing.JTextField jTextFieldPid;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTable performanceTable;
    // End of variables declaration//GEN-END:variables
}
