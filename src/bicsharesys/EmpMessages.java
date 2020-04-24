/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

import static bicsharesys.Login.ADMIN_FILE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class EmpMessages extends javax.swing.JFrame {

    /**
     * Creates new form EmpMessages
     */
    Admin admin;
    CustomerCareEmp cce;
    String type;
    int iter;
    String sender, text, receiver;//, reply;
    List<EmpMessages> my_messages_list, all_messages_list;
    List<Admin> adminlist;
    List<CustomerCareEmp> ccelist;
    static final String EMP_MESSAGES_FILE = "data//emp_messages.txt";
    static final String ADMIN_FILE = "data//admin.txt";
    static final String CUSTOMERCARE_FILE = "data//customer_care.txt";
    
    public EmpMessages() {
        initComponents();
    }
    public EmpMessages(String[] msg)
    {
        this.sender = msg[0];
        this.text = msg[1];
        this.receiver = msg[2];
//        this.reply = msg[3];
    }
    
    public EmpMessages(Admin admin, String type) {
        initComponents();
        this.type = type;
        this.admin = admin;
        adminlist = new ArrayList();
        ccelist = new ArrayList();
        my_messages_list = new ArrayList();
        all_messages_list = new ArrayList();
        load_dataM(EMP_MESSAGES_FILE);
        load_dataA(ADMIN_FILE);
        load_dataCCE(CUSTOMERCARE_FILE);
        if(this.type.equals("view"))
        {
            try
            {
                this.iter = 0;
                MsgTxt.setEditable(false);
                SubmitBtn.setVisible(false);
                ClearBtn.setVisible(false);
                PrevBtn.setVisible(true);
                NextBtn.setVisible(true);
                TitleLbl.setText("View Messages");
                comboLbl.setText("Messages sent by : ");
                NameCombo.removeAllItems();
                NameCombo.setEditable(true);
    //            NameCombo.addItem(this.admin.uname+" (me)");
                for(CustomerCareEmp var : ccelist)
                {
                        NameCombo.addItem(var.uname);
                }
                NameCombo.setEditable(false);
                if(NameCombo.getSelectedItem().toString().equals(this.admin.uname+" (me)"))
                {
                    my_messages_list.clear();
                    for(EmpMessages msg : all_messages_list)
                    {
                        if(msg.sender.equals(this.admin.uname))
                        {
                            my_messages_list.add(msg);
                        }
                    }
                }
                else
                {
                    my_messages_list.clear();
                    for(EmpMessages var : all_messages_list)
                    {
                        if(var.sender.equals(NameCombo.getSelectedItem().toString()) && var.receiver.equals(this.admin.uname))
                        {
                            my_messages_list.add(var);
                        }
                    }
                }

                    MsgTxt.setText(my_messages_list.get(this.iter).text);

            }
            catch(Exception e)
            {
                PrevBtn.setVisible(false);
                NextBtn.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(this,"No messages found!");  
            }
        }
        else if(this.type.equals("send"))
        {
            TitleLbl.setText("Send Messages");
            PrevBtn.setVisible(false);
            NextBtn.setVisible(false);
            comboLbl.setText("Send Message to : ");
            NameCombo.removeAllItems();
            NameCombo.setEditable(true);
//            NameCombo.addItem(this.admin.uname+" (me)");
            for(CustomerCareEmp cce : ccelist)
            {
                    NameCombo.addItem(cce.uname);
            }
            NameCombo.setEditable(false);
        }
        
    }
    
    public EmpMessages(CustomerCareEmp cce, String type) {
        initComponents();
        this.type = type;
        this.cce = cce;
        adminlist = new ArrayList();
        ccelist = new ArrayList();
        my_messages_list = new ArrayList();
        all_messages_list = new ArrayList();
        load_dataM(EMP_MESSAGES_FILE);
        load_dataA(ADMIN_FILE);
        load_dataCCE(CUSTOMERCARE_FILE);
        if(this.type.equals("view"))
        {
            try
            {
            this.iter = 0;
            MsgTxt.setEditable(false);
            SubmitBtn.setVisible(false);
            ClearBtn.setVisible(false);
            PrevBtn.setVisible(true);
            NextBtn.setVisible(true);
            TitleLbl.setText("View Messages");
            comboLbl.setText("Messages sent by : ");
            NameCombo.removeAllItems();
            NameCombo.setEditable(true);
//            NameCombo.addItem(this.admin.uname+" (me)");
            for(Admin admin : adminlist)
            {
                    NameCombo.addItem(admin.uname);
            }
            NameCombo.setEditable(false);
            if(NameCombo.getSelectedItem().toString().equals(this.cce.uname+" (me)"))
            {
                my_messages_list.clear();
                for(EmpMessages msg : all_messages_list)
                {
                    if(msg.sender.equals(this.cce.uname))
                    {
                        my_messages_list.add(msg);
                    }
                }
            }
            else
            {
                my_messages_list.clear();
                for(EmpMessages msg : all_messages_list)
                {
                    if(msg.sender.equals(NameCombo.getSelectedItem().toString()) && msg.receiver.equals(this.cce.uname))
                    {
                        my_messages_list.add(msg);
                    }
                }
            }
            
                MsgTxt.setText(my_messages_list.get(this.iter).text);
        
            }
            catch(Exception e)
            {
                PrevBtn.setVisible(false);
                NextBtn.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(this,"No messages found!");  
            }
        }
        else if(this.type.equals("send"))
        {
            TitleLbl.setText("Send Messages");
            PrevBtn.setVisible(false);
            NextBtn.setVisible(false);
            comboLbl.setText("Send Message to : ");
            NameCombo.removeAllItems();
            NameCombo.setEditable(true);
//            NameCombo.addItem(this.admin.uname+" (me)");
            for(Admin var : adminlist)
            {
                    NameCombo.addItem(var.uname);
            }
            NameCombo.setEditable(false);
        }
        
    }

    private void load_dataM(String filename) {
        System.out.println("in load data func");
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*&&\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*&\\s*");
//                for(String str : author)
//                {
                    System.out.println(author.length);
                    System.out.println(author.toString());
//                }
                    all_messages_list.add(new EmpMessages(author));
                
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
    
    String ChangeToStringM(EmpMessages msg)
    {
        String ans = "";
        ans += msg.sender+" & "+msg.text+" & "+msg.receiver+"&&\n";
        return ans;
    }
    
    void EmpMsgWrite(String filename, String data)
    {
//        String data = "";
//        data += this.uname+", "+this.password+", "+this.name+", "+this.phone+", "+this.email+", "+this.balance+", "+this.emergency_phone+", "+this.gender+", "+this.blood_group+";\n";
    
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            File file = new File(filename);
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("Writing done");
//            Login.main(new String[]{});
//            dispose();
        }
        catch (IOException e) {}
        finally {
                try {
                    if (bw != null)
                            bw.close();
                    if (fw != null)
                            fw.close();
                } catch (IOException ex) {}
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
        TitleLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        comboLbl = new javax.swing.JLabel();
        NameCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        MsgTxt = new javax.swing.JTextArea();
        PrevBtn = new javax.swing.JButton();
        NextBtn = new javax.swing.JButton();
        SubmitBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLbl.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        TitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLbl.setText("Messages");

        comboLbl.setText("Message sent by");

        NameCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NameComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(NameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MsgTxt.setColumns(20);
        MsgTxt.setRows(5);
        jScrollPane1.setViewportView(MsgTxt);

        PrevBtn.setText("Previous");
        PrevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevBtnActionPerformed(evt);
            }
        });

        NextBtn.setText("Next");
        NextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBtnActionPerformed(evt);
            }
        });

        SubmitBtn.setText("Submit");
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBtnActionPerformed(evt);
            }
        });

        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PrevBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubmitBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrevBtn)
                    .addComponent(NextBtn)
                    .addComponent(SubmitBtn)
                    .addComponent(ExitBtn)
                    .addComponent(ClearBtn))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(TitleLbl)
                .addGap(18, 18, 18)
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

    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBtnActionPerformed
        // TODO add your handling code here:
        if(this.admin != null)
        {
            EmpMessages msg = new EmpMessages();
            msg.sender = this.admin.uname;
            msg.text = MsgTxt.getText();
            msg.receiver = NameCombo.getSelectedItem().toString();
            EmpMsgWrite(EMP_MESSAGES_FILE, ChangeToStringM(msg));            
        }
        else if(this.cce != null)
        {
            EmpMessages msg = new EmpMessages();
            msg.sender = this.cce.uname;
            msg.text = MsgTxt.getText();
            msg.receiver = NameCombo.getSelectedItem().toString();
            EmpMsgWrite(EMP_MESSAGES_FILE, ChangeToStringM(msg));            
        }
        MsgTxt.setText("");
    }//GEN-LAST:event_SubmitBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        MsgTxt.setText("");
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void NameComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NameComboItemStateChanged
        // TODO add your handling code here:
        my_messages_list = new ArrayList();
        this.iter = 0;
        if(this.type.equals("view"))
        {
            if(this.admin != null)
            {
                try
            {
                PrevBtn.setVisible(true);
                NextBtn.setVisible(true);
//                NameCombo.removeAllItems();
//                NameCombo.setEditable(true);
//    //            NameCombo.addItem(this.admin.uname+" (me)");
//                for(CustomerCareEmp var : ccelist)
//                {
//                        NameCombo.addItem(var.uname);
//                }
//                NameCombo.setEditable(false);
                if(NameCombo.getSelectedItem().toString().equals(this.admin.uname+" (me)"))
                {
                    my_messages_list.clear();
                    for(EmpMessages msg : all_messages_list)
                    {
                        if(msg.sender.equals(this.admin.uname))
                        {
                            my_messages_list.add(msg);
                        }
                    }
                }
                else
                {
                    
                    my_messages_list.clear();
                    for(EmpMessages msg : all_messages_list)
                    {
                        if(msg.sender.equals(NameCombo.getSelectedItem().toString()) && msg.receiver.equals(this.admin.uname))
                        {
                            my_messages_list.add(msg);
                        }
                    }
                }
                MsgTxt.setText(my_messages_list.get(this.iter).text);
            }
                catch(Exception e)
                {
                    PrevBtn.setVisible(false);
                    NextBtn.setVisible(false);
                    javax.swing.JOptionPane.showMessageDialog(this,"No messages found!"); 
                }
            }
            if(this.cce != null)
            {
                try
            {
                PrevBtn.setVisible(true);
            NextBtn.setVisible(true);
//                NameCombo.removeAllItems();
//                NameCombo.setEditable(true);
//    //            NameCombo.addItem(this.admin.uname+" (me)");
//                for(Admin admin : adminlist)
//                {
//                        NameCombo.addItem(admin.uname);
//                }
//                NameCombo.setEditable(false);
                if(NameCombo.getSelectedItem().toString().equals(this.cce.uname+" (me)"))
                {
                    my_messages_list.clear();
                    for(EmpMessages msg : all_messages_list)
                    {
                        if(msg.sender.equals(this.cce.uname))
                        {
                            my_messages_list.add(msg);
                        }
                    }
                }
                else
                {
                    my_messages_list.clear();
                    for(EmpMessages msg : all_messages_list)
                    {
                        if(msg.sender.equals(NameCombo.getSelectedItem().toString()) && msg.receiver.equals(this.cce.uname))
                        {
                            my_messages_list.add(msg);
                        }
                    }
                }
            
                MsgTxt.setText(my_messages_list.get(this.iter).text);
            }
                catch(Exception e)
                {
                    PrevBtn.setVisible(false);
                    NextBtn.setVisible(false);
                    javax.swing.JOptionPane.showMessageDialog(this,"No messages found!"); 
                }
            }
            
        }
        
    }//GEN-LAST:event_NameComboItemStateChanged

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        // TODO add your handling code here:
        if(this.iter < my_messages_list.size()-1)
        {
            this.iter++;
        }
        else
        {
            this.iter = my_messages_list.size()-1;
        }
        MsgTxt.setText(my_messages_list.get(this.iter).text);
    }//GEN-LAST:event_NextBtnActionPerformed

    private void PrevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevBtnActionPerformed
        // TODO add your handling code here:
        if(this.iter > 0)
        {
            this.iter--;
        }
        else
        {
            this.iter = 0;
        }
        MsgTxt.setText(my_messages_list.get(this.iter).text);
    }//GEN-LAST:event_PrevBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        if(this.admin != null)
        {
            this.admin.setVisible(true);
            dispose();
        }
        if(this.cce != null)
        {
            this.cce.setVisible(true);
            dispose();
        }
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
            java.util.logging.Logger.getLogger(EmpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpMessages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JTextArea MsgTxt;
    private javax.swing.JComboBox<String> NameCombo;
    private javax.swing.JButton NextBtn;
    private javax.swing.JButton PrevBtn;
    private javax.swing.JButton SubmitBtn;
    private javax.swing.JLabel TitleLbl;
    private javax.swing.JLabel comboLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
