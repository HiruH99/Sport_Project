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
public class Payment extends javax.swing.JFrame {

    //==============Database connection===========================
    private static final String username =ConnVariable.username1;
    private static final String password=ConnVariable.password1;
    private static final String dataconn =ConnVariable.dataconn1;
    
    Connection sqlconn= null;
    PreparedStatement pst =null;
    ResultSet RS =null;
    //=============================================================================
    
    
    
    public Payment() {
        initComponents();
        UpdateDB();
    }

//===========================Function to show and update content on table=========================
    public void UpdateDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select payid,pname,transdate,amount from payment, player where player.pid=payment.pid");
            
            RS=pst.executeQuery();
            ResultSetMetaData StData = RS.getMetaData();
            
            int q = StData.getColumnCount();
            
            DefaultTableModel RecordTablePay = (DefaultTableModel)paymentTable.getModel();
            RecordTablePay.setRowCount(0);
            
            while (RS.next()){
                Vector coloumnData =new Vector();
                
                for(int i=0;i<q;i++){
                    coloumnData.add(RS.getString("payid"));
                    coloumnData.add(RS.getString("pname"));
                    coloumnData.add(RS.getString("transdate"));
                    coloumnData.add(RS.getString("amount"));
                    
                      
                }
                RecordTablePay.addRow(coloumnData);
            }
            sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }   
        
    }
    
  //============================================================================================================================    
    
    //==============================Function to set text fields null===========================
     private void ClearTextFields(){
         jTextFieldPid.setText(null);
         jTextFieldAmount.setText(null);   
                  
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
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPid = new javax.swing.JTextField();
        jTextFieldAmount = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setText("Payment Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 169, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel5.setText("Payment");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 120, 30));

        paymentTable.setBackground(new java.awt.Color(204, 204, 204));
        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
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
                "Payment ID", "Player Name", "Date", "Amount (Rs.)"
            }
        ));
        jScrollPane1.setViewportView(paymentTable);
        if (paymentTable.getColumnModel().getColumnCount() > 0) {
            paymentTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            paymentTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 510, 190));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel3.setText("Player ID :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 80, 30));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jLabel4.setText("Amount :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 80, 30));

        jTextFieldPid.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldPid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPidActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 258, -1));

        jTextFieldAmount.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextFieldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 260, -1));

        jButtonAdd.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAdd.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 90, -1));

        jButtonReset.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReset.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 90, -1));

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 90, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wins.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(987, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    //=================Add button==================================================
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("insert into payment(pid,transdate,amount) values(?,curdate(),?)");
            
            //get values from interface
            pst.setString(1,jTextFieldPid.getText());
            pst.setString(2,jTextFieldAmount.getText());
            
            
           // execute statement
           pst.executeUpdate();
           JOptionPane.showMessageDialog(this, "New Transaction Added.");
           
            //call function to update table
           UpdateDB();
           //Clear text fields
           ClearTextFields();
           sqlconn.close();
            }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    //============================Reset Button=====================
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        ClearTextFields();
    }//GEN-LAST:event_jButtonResetActionPerformed

    
    //======================Back Button======================================
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        Menu m =new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldPidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPidActionPerformed

    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldPid;
    private javax.swing.JTable paymentTable;
    // End of variables declaration//GEN-END:variables
}
