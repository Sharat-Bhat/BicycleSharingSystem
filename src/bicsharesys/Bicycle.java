/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sharat
 */
public class Bicycle extends javax.swing.JFrame {

    /**
     * Creates new form Bicycle
     */
    List<LendingPage> bicyclelist;
    LendingPage rented_bicycle;
    Commuter commuter;
    int count;
    String current_location;
    static final String BICYCLE_FILE = "data//bicycle.txt";
    
    public Bicycle() {
        initComponents();
    }
    
    public Bicycle(Commuter user) {
        initComponents();
        this.commuter = user;
        this.count = 1;
//        BicyclePnl.setVisible(false);
        bicyclelist = new ArrayList();
        load_dataB(BICYCLE_FILE);
        this.current_location = LocationCombo.getSelectedItem().toString();
        BicycleCombo.removeAllItems();
        BicycleCombo.setEditable(true);
        for(LendingPage bicycle : bicyclelist)
        {
            if(bicycle.location.equals(this.current_location) && bicycle.occupied.equals("0"))
            {
                BicycleCombo.addItem(bicycle.code);
                System.out.println("Added");
            }
            System.out.println("No idea");
        }
        this.setVisible(true);
    }
    
    private void load_dataB(String filename) {
        System.out.println("in load data func");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*;\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*,\\s*");
                bicyclelist.add(new LendingPage(author));
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    String ChangeToString(LendingPage bic)
    {
        String ans = "";
        ans += bic.code+", "+bic.location+", "+bic.occupied+", "+bic.giver+", "+bic.current_user+";";
        return ans;
    }
    
    void modify(String filepath, String oldLine, String newLine)
    {
        try
        {
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filepath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) 
        {
           buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
//        String oldLine = "No preconditions and no impediments. Simply Easy Learning!";
//        String newLine = "Enjoy the free content";
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filepath);
        System.out.println("");
        System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();
        }
        catch(Exception e)
        {
            System.out.println("Cannot open file " + filepath);
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
        jPanel2 = new javax.swing.JPanel();
        BicyclePnl = new javax.swing.JPanel();
        LocationLbl = new javax.swing.JLabel();
        BicycleCombo = new javax.swing.JComboBox<>();
        LocationPnl = new javax.swing.JPanel();
        LocationLbl1 = new javax.swing.JLabel();
        LocationCombo = new javax.swing.JComboBox<>();
        StartRideBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bicycle");

        LocationLbl.setText("Select Bicycle");

        BicycleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BicycleComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BicyclePnlLayout = new javax.swing.GroupLayout(BicyclePnl);
        BicyclePnl.setLayout(BicyclePnlLayout);
        BicyclePnlLayout.setHorizontalGroup(
            BicyclePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BicyclePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LocationLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(BicycleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BicyclePnlLayout.setVerticalGroup(
            BicyclePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BicyclePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LocationLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addComponent(BicycleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LocationLbl1.setText("Select Location");

        LocationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Building", "Nalanda Classroom Complex", "Pan Loop", "Gymkhana", "Tech Market" }));
        LocationCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LocationComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout LocationPnlLayout = new javax.swing.GroupLayout(LocationPnl);
        LocationPnl.setLayout(LocationPnlLayout);
        LocationPnlLayout.setHorizontalGroup(
            LocationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocationPnlLayout.createSequentialGroup()
                .addComponent(LocationLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(LocationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LocationPnlLayout.setVerticalGroup(
            LocationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LocationLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addComponent(LocationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        StartRideBtn.setText("Start Ride");
        StartRideBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartRideBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(BicyclePnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(RefreshBtn)
                .addGap(39, 39, 39)
                .addComponent(StartRideBtn)
                .addGap(18, 18, 18)
                .addComponent(BackBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LocationPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(BicyclePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartRideBtn)
                    .addComponent(BackBtn)
                    .addComponent(RefreshBtn))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(LocationPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );

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
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
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

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        this.commuter.setVisible(true);
        dispose();        
    }//GEN-LAST:event_BackBtnActionPerformed

    private void BicycleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BicycleComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BicycleComboActionPerformed

    private void LocationComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LocationComboItemStateChanged
        // TODO add your handling code here:
        this.current_location = LocationCombo.getSelectedItem().toString();
        BicycleCombo.removeAllItems();
        BicycleCombo.setEditable(true);
        for(LendingPage bicycle : bicyclelist)
        {
            if(bicycle.location.equals(this.current_location) && bicycle.occupied.equals("0"))
            {
                BicycleCombo.addItem(bicycle.code);
            }
        }
        this.setVisible(true);
    }//GEN-LAST:event_LocationComboItemStateChanged

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        // TODO add your handling code here:
        new Bicycle(this.commuter).setVisible(true);
        dispose();
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void StartRideBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartRideBtnActionPerformed
        // TODO add your handling code here:
//        load_dataB(BICYCLE_FILE); 
        for(LendingPage bicycle : bicyclelist)
        {
            if(bicycle.code.equals(BicycleCombo.getSelectedItem().toString()) && bicycle.occupied.equals("0"))
            {
                String prev = ChangeToString(bicycle);
                bicycle.occupied = "1";
                bicycle.current_user = this.commuter.uname;
                this.rented_bicycle = bicycle;
                String next = ChangeToString(this.rented_bicycle);
                modify(BICYCLE_FILE, prev, next);
            }
        }
        dispose();
        new Ride(this.commuter, this.rented_bicycle).setVisible(true);
    }//GEN-LAST:event_StartRideBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Bicycle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bicycle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bicycle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bicycle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bicycle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JComboBox<String> BicycleCombo;
    private javax.swing.JPanel BicyclePnl;
    private javax.swing.JComboBox<String> LocationCombo;
    private javax.swing.JLabel LocationLbl;
    private javax.swing.JLabel LocationLbl1;
    private javax.swing.JPanel LocationPnl;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton StartRideBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
