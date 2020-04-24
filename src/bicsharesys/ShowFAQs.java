/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author sharat
 */
public class ShowFAQs extends javax.swing.JFrame {

    /**
     * Creates new form ShowFAQs
     */
    Commuter commuter;
    Lender lender;
    Admin admin;
    CustomerCareEmp cce;
    static final String FAQS_FILE = "data//faqs.txt";
    
    public ShowFAQs() {
        initComponents();
        EditBtn.setVisible(false);
        try
        {
            DescriptionTxt.setText(Files.readString(Paths.get(FAQS_FILE)));
        }
        catch(Exception e)
        {
         System.out.println("Cannot open file " + FAQS_FILE);   
        }
    }
    public ShowFAQs(Commuter commuter) {
        initComponents();
        EditBtn.setVisible(false);
        this.commuter = commuter;
        try
        {
            DescriptionTxt.setText(Files.readString(Paths.get(FAQS_FILE)));
        }
        catch(Exception e)
        {
         System.out.println("Cannot open file " + FAQS_FILE);   
        }
    }
    public ShowFAQs(Lender lender) {
        initComponents();
        EditBtn.setVisible(false);
        this.lender = lender;
        try
        {
            DescriptionTxt.setText(Files.readString(Paths.get(FAQS_FILE)));
        }
        catch(Exception e)
        {
         System.out.println("Cannot open file " + FAQS_FILE);   
        }
    }
    public ShowFAQs(Admin admin) {
        initComponents();
        this.admin = admin;
        DescriptionTxt.setEditable(true);
        try
        {
            DescriptionTxt.setText(Files.readString(Paths.get(FAQS_FILE)));
        }
        catch(Exception e)
        {
         System.out.println("Cannot open file " + FAQS_FILE);   
        }
    }
    public ShowFAQs(CustomerCareEmp cce) {
        initComponents();
        EditBtn.setVisible(false);
        this.cce = cce;
        try
        {
            DescriptionTxt.setText(Files.readString(Paths.get(FAQS_FILE)));
        }
        catch(Exception e)
        {
         System.out.println("Cannot open file " + FAQS_FILE);   
        }
    }
    void editFAQs(String filename)
    {
        try(FileWriter fw = new FileWriter(filename,false))
        {
            fw.write(DescriptionTxt.getText());
        }
        catch(Exception e)
        {
            System.out.println("Cannot open file " + filename);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescriptionTxt = new javax.swing.JTextArea();
        EditBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FAQs");

        DescriptionTxt.setEditable(false);
        DescriptionTxt.setColumns(20);
        DescriptionTxt.setRows(5);
        DescriptionTxt.setText("You will be charged Rs 10 for first 15 minutes \nand then Rs 5 for every subsequent 15 minute \nduration.");
        jScrollPane1.setViewportView(DescriptionTxt);

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addGap(24, 24, 24)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditBtn)
                    .addComponent(ExitBtn))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
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

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
        editFAQs(FAQS_FILE);
        try
        {
            DescriptionTxt.setText(Files.readString(Paths.get(FAQS_FILE)));
        }
        catch(Exception e)
        {
            System.out.println("Cannot open file " + FAQS_FILE);
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        if(this.admin != null)
        {
            this.admin.setVisible(true);
        }
        else if(this.cce != null)
        {
            this.cce.setVisible(true);
        }
        else if(this.commuter != null)
        {
            this.commuter.setVisible(true);
        }
        else if(this.lender != null)
        {
            this.lender.setVisible(true);
        }
        else
        {
            new HomePage().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_ExitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ShowFAQs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowFAQs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowFAQs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowFAQs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowFAQs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DescriptionTxt;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
