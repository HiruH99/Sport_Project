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
public class PlayerDetails extends javax.swing.JFrame {
    
    static int selectedPid ;// varable to store previously selected player

   
    //================== variable declaration for DB connection====================
    private static final String username =ConnVariable.username1;
    private static final String password=ConnVariable.password1;
    private static final String dataconn =ConnVariable.dataconn1;
    
    Connection sqlconn= null;
    PreparedStatement pst =null;
    ResultSet RS =null;
//====================================================================================
    
    
    
    public PlayerDetails() {
        initComponents();
        FillTextFields();
        UpdateTable();
        SetComboCoaches();
        UpdateSportCoach();
    }

    //=======================Function to add values to text fields=============================
    void FillTextFields(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("SELECT pid,pname,dob,address,gender,joindate FROM player where pid=?");
            
            pst.setInt(1, selectedPid);
            
            RS = pst.executeQuery();
            
            while (RS.next()){
            jTextFieldId.setText(RS.getString("pid"));
            jTextFieldName.setText(RS.getString("pname"));
            jTextFieldDob.setText(RS.getString("dob"));
            jTextFieldAddress.setText(RS.getString("address"));
            jTextFieldGender.setText(RS.getString("gender"));
            jTextFieldJoinDate.setText(RS.getString("joindate"));
            }
           sqlconn.close();
           
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //=====================================================================================
    
    //===========================Function to show and update content on table=========================
     public void UpdateTable(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select sport.sname,performance.lev,performance.marks,coach.cname " +
                                            "from relationplayer " +
                                            "left join performance on relationplayer.pid=performance.pid and relationplayer.sid=performance.sid " +
                                            "left join coach on relationplayer.cid=coach.cid " +
                                            "left join sport on relationplayer.sid=sport.sid " +
                                            "where relationplayer.pid=?");
            
           
            pst.setInt(1, selectedPid); 
            RS=pst.executeQuery();
            ResultSetMetaData StData = RS.getMetaData();
            
            int q = StData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)playerDetailTable.getModel();
            RecordTable.setRowCount(0);
            
            while (RS.next()){
                Vector coloumnData =new Vector();
                
                for(int i=0;i<q;i++){
                    coloumnData.add(RS.getString("sport.sname"));
                    coloumnData.add(RS.getString("performance.lev"));
                    coloumnData.add(RS.getString("performance.marks"));
                    coloumnData.add(RS.getString("coach.cname"));
                   
                      
                }
                RecordTable.addRow(coloumnData);
                
            }
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }   
        
    }
//========================================================================================================================================
    
   //========================Function to set coaches names  to combobox========================================================
    private void SetComboCoaches(){
         
        //set Cricket coaches
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select cname from coach where sid='S001'");
            
            RS=pst.executeQuery();
            
            
               while (RS.next()){
                  String cbValue = RS.getString("cname");
                  jComboBoxCricketCoach.addItem(cbValue);
                   
                   
            }
               sqlconn.close();
            
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        
        //set Batminton coaches
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select cname from coach where sid='S002'");
            
            RS=pst.executeQuery();
            
            
               while (RS.next()){
                  String cbValue = RS.getString("cname");
                  jComboBoxBatmintonCoach.addItem(cbValue);
                   
                   
            }
               sqlconn.close();
            
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        
        //set Swimming coaches
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select cname from coach where sid='S003'");
            
            RS=pst.executeQuery();
            
            
               while (RS.next()){
                  String cbValue = RS.getString("cname");
                  jComboBoxSwimmingCoach.addItem(cbValue);
                   
                   
            }
               sqlconn.close();
            
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    //========================================================================================== 
    
    
    
    //========================Function to Update Sport and coach Details========================================================
    private void UpdateSportCoach(){
        
        //=================Update Check Boxes=============================
         try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select sid from relationplayer where pid=?");
            
            pst.setInt(1, selectedPid); 
            RS=pst.executeQuery();
            
            while (RS.next()){
                String ts = RS.getString("sid");
                if(ts.equals("S001")){
                    jCheckBoxCricket.setSelected(true);
                }
                if(ts.equals("S002")){
                    jCheckBoxBatminton.setSelected(true);
                }
                if(ts.equals("S003")){
                    jCheckBoxSwimming.setSelected(true);
                }
            }
           
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
         
         //=================Update COach==================================================
         //cricket coach
         try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select cname from coach left join relationplayer on relationplayer.cid=coach.cid where relationplayer.pid=? and relationplayer.sid='S001'");
            
            pst.setInt(1, selectedPid); 
            RS=pst.executeQuery();
            
            while (RS.next()){
               jComboBoxCricketCoach.setSelectedItem(RS.getString("cname"));
            }
           sqlconn.close();
            
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
         
         //Batminton coach
         try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select cname from coach left join relationplayer on relationplayer.cid=coach.cid where relationplayer.pid=? and relationplayer.sid='S002'");
            
            pst.setInt(1, selectedPid); 
            RS=pst.executeQuery();
            
            while (RS.next()){
               jComboBoxBatmintonCoach.setSelectedItem(RS.getString("cname"));
            }
           sqlconn.close();
            
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
         
         //Swimmingcoach
         try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select cname from coach left join relationplayer on relationplayer.cid=coach.cid where relationplayer.pid=? and relationplayer.sid='S003'");
            
            pst.setInt(1, selectedPid); 
            RS=pst.executeQuery();
            
            while (RS.next()){
               jComboBoxSwimmingCoach.setSelectedItem(RS.getString("cname"));
            }
           
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
        
    }
    //==========================================================================================
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldDob = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jTextFieldGender = new javax.swing.JTextField();
        jTextFieldJoinDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxCricketCoach = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerDetailTable = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBoxCricket = new javax.swing.JCheckBox();
        jCheckBoxBatminton = new javax.swing.JCheckBox();
        jCheckBoxSwimming = new javax.swing.JCheckBox();
        jComboBoxSwimmingCoach = new javax.swing.JComboBox<>();
        jComboBoxBatmintonCoach = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(227, 225, 225));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel1.setText("Player Details");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setText("Name :");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth :");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setText("Address :");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Gender :");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("Joined Date :");

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldName.setEditable(false);
        jTextFieldName.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldDob.setEditable(false);
        jTextFieldDob.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldAddress.setEditable(false);
        jTextFieldAddress.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldGender.setEditable(false);
        jTextFieldGender.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldJoinDate.setEditable(false);
        jTextFieldJoinDate.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldGender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jTextFieldAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDob, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldJoinDate))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldJoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(973, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 1388));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setText("Coach");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 75, -1));

        jComboBoxCricketCoach.setBackground(new java.awt.Color(204, 204, 204));
        jComboBoxCricketCoach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null" }));
        jPanel1.add(jComboBoxCricketCoach, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 190, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel9.setText("Performance");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 168, -1));

        playerDetailTable.setBackground(new java.awt.Color(204, 204, 204));
        playerDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sport", "Level", "Marks", "Coach"
            }
        ));
        playerDetailTable.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(playerDetailTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 171));

        jButtonAdd.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdd.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Update");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 90, 30));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 90, 30));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        jLabel10.setText("Add Sports and coaches");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 210, -1));

        jLabel11.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel11.setText("Sport");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 75, -1));

        jCheckBoxCricket.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jCheckBoxCricket.setText("Cricket");
        jPanel1.add(jCheckBoxCricket, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 146, -1));

        jCheckBoxBatminton.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jCheckBoxBatminton.setText("Batminton");
        jPanel1.add(jCheckBoxBatminton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 146, -1));

        jCheckBoxSwimming.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxSwimming.setText("Swimming");
        jPanel1.add(jCheckBoxSwimming, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 146, -1));

        jComboBoxSwimmingCoach.setBackground(new java.awt.Color(204, 204, 204));
        jComboBoxSwimmingCoach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null" }));
        jPanel1.add(jComboBoxSwimmingCoach, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 190, -1));

        jComboBoxBatmintonCoach.setBackground(new java.awt.Color(204, 204, 204));
        jComboBoxBatmintonCoach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null" }));
        jPanel1.add(jComboBoxBatmintonCoach, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 190, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log.png"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 880, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(987, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    //=====================Back Button=================================
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    //============================Update Button===================================
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        //======Add to database 
        
        //======================================Cricket Add Update Delete===================
        if(jCheckBoxCricket.isSelected())/*Add update */ {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from relationplayer where pid=? and sid='S001'");
            pst.setInt(1, selectedPid);
            
            RS=pst.executeQuery();
            
            if(!RS.next()){
                //if record doesnt exist create new 
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("insert into relationplayer(pid,sid,cid) values (?,'S001',(select cid from coach where cname=?))");

                    //get values from interface
                    pst.setInt(1,selectedPid);
                    pst.setString(2,(String) jComboBoxCricketCoach.getSelectedItem());

                   // execute statement
                   pst.executeUpdate();
                   

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
                
            }
            
        
            //if entery exists update
            else {
                //if record doesnt exist create new 
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("update relationplayer set cid=(select cid from coach where cname=?) where pid=? and sid='S001'");

                    //get values from interface
                    pst.setInt(2,selectedPid);
                    pst.setString(1,(String) jComboBoxCricketCoach.getSelectedItem());

                   // execute statement
                   pst.executeUpdate();
                  

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                 
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
                
            }
           
          // sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
        }
        
        if(!jCheckBoxCricket.isSelected())/*delete*/{
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("delete from relationplayer where pid=? and sid='S001'");

                    //get values from interface
                    pst.setInt(1,selectedPid);
                    

                   // execute statement
                   pst.executeUpdate();
                  

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
        }
        //========================End of Cricket Add Update Delete===============================================
        
        
        //======================================Batminton Add Update Delete===================
        if(jCheckBoxBatminton.isSelected())/*update Add*/ {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from relationplayer where pid=? and sid='S002'");
            pst.setInt(1, selectedPid);
            
            RS=pst.executeQuery();
            
            if(!RS.next()){
                //if record doesnt exist create new 
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("insert into relationplayer(pid,sid,cid) values (?,'S002',(select cid from coach where cname=?))");

                    //get values from interface
                    pst.setInt(1,selectedPid);
                    pst.setString(2,(String) jComboBoxBatmintonCoach.getSelectedItem());

                   // execute statement
                   pst.executeUpdate();
                  

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
                
            }
            
            
            //if entery exists update
           else{
                //if record doesnt exist create new 
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("update relationplayer set cid=(select cid from coach where cname=?) where pid=? and sid='S002'");

                    //get values from interface
                    pst.setInt(2,selectedPid);
                    pst.setString(1,(String) jComboBoxBatmintonCoach.getSelectedItem());

                   // execute statement
                   pst.executeUpdate();
                   

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
                
            }
           
           //sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
        }
        
        if(!jCheckBoxBatminton.isSelected())/*delete*/{
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("delete from relationplayer where pid=? and sid='S002'");

                    //get values from interface
                    pst.setInt(1,selectedPid);
                    

                   // execute statement
                   pst.executeUpdate();
                   

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
        }
        //========================End of Batminton Add Update Delete===============================================
        
        //======================================Swimming Add Update Delete===================
        if(jCheckBoxSwimming.isSelected())/*update Add*/ {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from relationplayer where pid=? and sid='S003'");
            pst.setInt(1, selectedPid);
            
            RS=pst.executeQuery();
            
            if(!RS.next()){
                //if record doesnt exist create new 
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("insert into relationplayer(pid,sid,cid) values (?,'S003',(select cid from coach where cname=?))");

                    //get values from interface
                    pst.setInt(1,selectedPid);
                    pst.setString(2,(String) jComboBoxSwimmingCoach.getSelectedItem());

                   // execute statement
                   pst.executeUpdate();
                  

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
                
            }
            
            
            //if entery exists update
           else{
                //if record doesnt exist create new 
                 try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("update relationplayer set cid=(select cid from coach where cname=?) where pid=? and sid='S003'");

                    //get values from interface
                    pst.setInt(2,selectedPid);
                    pst.setString(1,(String) jComboBoxSwimmingCoach.getSelectedItem());

                   // execute statement
                   pst.executeUpdate();
                   

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
                
            }
           
          
           
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
         
        }
        
        if(!jCheckBoxSwimming.isSelected())/*delete*/{
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("delete from relationplayer where pid=? and sid='S003'");

                    //get values from interface
                    pst.setInt(1,selectedPid);
                    

                   // execute statement
                   pst.executeUpdate();
                   

                    UpdateSportCoach();
                    UpdateTable();
                    sqlconn.close();

                    }
                catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PlayerDetails.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
        }
        //========================End of Swimming Add Update Delete===============================================
       JOptionPane.showMessageDialog(this, "Sport and Coach Detail Updated."); 
    }//GEN-LAST:event_jButtonAddActionPerformed

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
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JCheckBox jCheckBoxBatminton;
    private javax.swing.JCheckBox jCheckBoxCricket;
    private javax.swing.JCheckBox jCheckBoxSwimming;
    private javax.swing.JComboBox<String> jComboBoxBatmintonCoach;
    private javax.swing.JComboBox<String> jComboBoxCricketCoach;
    private javax.swing.JComboBox<String> jComboBoxSwimmingCoach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldDob;
    private javax.swing.JTextField jTextFieldGender;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldJoinDate;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTable playerDetailTable;
    // End of variables declaration//GEN-END:variables
}
