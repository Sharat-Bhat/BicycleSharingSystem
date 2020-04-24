/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sharat
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    List<Commuter> commuterlist;
    List<Lender> lenderlist;
    List<Admin> adminlist;
    List<CustomerCareEmp> ccelist;
    static final String COMMUTER_FILE = "data//commuter.txt";
    static final String LENDER_FILE = "data//lender.txt";
    static final String ADMIN_FILE = "data//admin.txt";
    static final String CUSTOMERCARE_FILE = "data//customer_care.txt";
    
    public Login() {
        initComponents();
        commuterlist = new ArrayList();
        lenderlist = new ArrayList();
        adminlist = new ArrayList();
        ccelist = new ArrayList();
        load_dataC(COMMUTER_FILE);
        load_dataL(LENDER_FILE);
        load_dataA(ADMIN_FILE);
        load_dataCCE(CUSTOMERCARE_FILE);
    }
    
    private void load_dataC(String filename) {
        System.out.println("in load data func");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*;\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*,\\s*");
                commuterlist.add(new Commuter(author));
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    private void load_dataL(String filename) {
        System.out.println("in load data func");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*;\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*,\\s*");
                lenderlist.add(new Lender(author));
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    private void load_dataA(String filename) {
        System.out.println("in load data func");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*;\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*,\\s*");
                adminlist.add(new Admin(author));
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    private void load_dataCCE(String filename) {
        System.out.println("in load data func");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*;\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*,\\s*");
                ccelist.add(new CustomerCareEmp(author));
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    Commuter isvalidC(String uname, String password) {
        for(Commuter commuter : commuterlist){
            if(uname.equals(commuter.uname) && password.equals(commuter.password)){
                return commuter;
            }
        }
        return null;
    }
    
    Lender isvalidL(String uname, String password) {
        for(Lender lender : lenderlist){
            if(uname.equals(lender.uname) && password.equals(lender.password)){
                return lender;
            }
        }
        return null;
    }
    
    Admin isvalidA(String uname, String password) {
        for(Admin admin : adminlist){
            if(uname.equals(admin.uname) && password.equals(admin.password)){
                return admin;
            }
        }
        return null;
    }
    
    CustomerCareEmp isvalidCCE(String uname, String password) {
        for(CustomerCareEmp cce : ccelist){
            if(uname.equals(cce.uname) && password.equals(cce.password)){
                return cce;
            }
        }
        return null;
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
        jPanel3 = new javax.swing.JPanel();
        UsernameLbl = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        PasswordLbl = new javax.swing.JLabel();
        PasswordTxt = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        LoginAsLbl = new javax.swing.JLabel();
        CommuterRBtn = new javax.swing.JRadioButton();
        LenderRBtn = new javax.swing.JRadioButton();
        CustomerCareRBtn = new javax.swing.JRadioButton();
        AdminRBtn = new javax.swing.JRadioButton();
        LoginBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UsernameLbl.setText("Username");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(UsernameLbl)
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(130, Short.MAX_VALUE)
                    .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsernameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PasswordLbl.setText("Password");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(PasswordLbl)
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(129, Short.MAX_VALUE)
                    .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PasswordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        LoginAsLbl.setText("Login as");

        CommuterRBtn.setText("Commuter");

        LenderRBtn.setText("Lender");

        CustomerCareRBtn.setText("Customer Care");

        AdminRBtn.setText("Admin");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(LoginAsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(LenderRBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CommuterRBtn))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(CustomerCareRBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AdminRBtn)))
                .addGap(6, 6, 6))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginAsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommuterRBtn)
                    .addComponent(LenderRBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerCareRBtn)
                    .addComponent(AdminRBtn)))
        );

        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(LoginBtn)
                        .addGap(70, 70, 70)
                        .addComponent(CancelBtn)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginBtn)
                    .addComponent(CancelBtn))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        // TODO add your handling code here:
        String uname = UsernameTxt.getText(), password = PasswordTxt.getText();
        if(CommuterRBtn.isSelected()) {
            Commuter validcommuter = isvalidC(uname, password);
            if(validcommuter!=null) {
//                p.customer1.setCustomer(validcustomer);
                  validcommuter.setVisible(true);
                  dispose();
            }
            else    {
                javax.swing.JOptionPane.showMessageDialog(this,"Username and password do not match!");          
            }
        }
        else if(LenderRBtn.isSelected()) {
            Lender validlender = isvalidL(uname, password);
            if(validlender!=null) {
//                p.admin1.setAdmin(validadmin);
                validlender.setVisible(true);
                dispose();
            }
            else    {
                javax.swing.JOptionPane.showMessageDialog(this,"Username and password do not match!");          
            }
        }
        else if(AdminRBtn.isSelected()) {
            Admin validadmin = isvalidA(uname, password);
            if(validadmin!=null) {
//                p.admin1.setAdmin(validadmin);
                validadmin.setVisible(true);
                dispose();
            }
            else    {
                javax.swing.JOptionPane.showMessageDialog(this,"Username and password do not match!");          
            }
        }
        else if(CustomerCareRBtn.isSelected()) {
            CustomerCareEmp validcce = isvalidCCE(uname, password);
            if(validcce!=null) {
//                p.admin1.setAdmin(validadmin);
                validcce.setVisible(true);
                dispose();
            }
            else    {
                javax.swing.JOptionPane.showMessageDialog(this,"Username and password do not match!");          
            }
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AdminRBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JRadioButton CommuterRBtn;
    private javax.swing.JRadioButton CustomerCareRBtn;
    private javax.swing.JRadioButton LenderRBtn;
    private javax.swing.JLabel LoginAsLbl;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel PasswordLbl;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
