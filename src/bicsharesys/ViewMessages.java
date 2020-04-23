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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sharat
 */
public class ViewMessages extends javax.swing.JFrame {

    /**
     * Creates new form ViewMessages
     */
    CustomerCareEmp cce;
    Lender lender;
    Commuter commuter;
    List<Message> mymessageslist;
    int len, iter;
    static final String MESSAGES_FILE = "data//messages.txt";
    
    public ViewMessages() {
        initComponents();
    }

    public ViewMessages(CustomerCareEmp cce) {
        initComponents();
        this.cce = cce;
        mymessageslist = new ArrayList();
        load_dataM(MESSAGES_FILE);
        this.len = mymessageslist.size();
        try
        {
            this.iter = 0;
            MsgTxt.setText(mymessageslist.get(this.iter).text);
            if(mymessageslist.get(this.iter).reply.equals("--"))
            {
                ReplyTxt.setText("");
            }
            else
            {
                ReplyTxt.setText(mymessageslist.get(this.iter).reply);
                ReplyTxt.setEditable(false);
            }
        }
         
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"No messages found!");          
        }
    }
    
    public ViewMessages(Lender user) {
        initComponents();
        this.lender = user;
        mymessageslist = new ArrayList();
        TitleLbl.setText("My Messages");
        SubmitBtn.setVisible(false);
        ClearBtn.setVisible(false);
        load_dataM(MESSAGES_FILE);
        this.len = mymessageslist.size();
        if(this.len > 0)
        {
         this.iter = 0;
         MsgTxt.setText(mymessageslist.get(this.iter).text);
         if(mymessageslist.get(this.iter).reply.equals("--"))
            {
                ReplyTxt.setText("");
            }
            else
            {
                ReplyTxt.setText(mymessageslist.get(this.iter).reply);
                ReplyTxt.setEditable(false);
            }
        }
    }
    
    public ViewMessages(Commuter user) {
        initComponents();
        this.commuter = user;
        mymessageslist = new ArrayList();
        TitleLbl.setText("My Messages");
        SubmitBtn.setVisible(false);
        ClearBtn.setVisible(false);
        load_dataM(MESSAGES_FILE);
        this.len = mymessageslist.size();
        if(this.len > 0)
        {
         this.iter = 0;
         MsgTxt.setText(mymessageslist.get(this.iter).text);
         if(mymessageslist.get(this.iter).reply.equals("--"))
            {
                ReplyTxt.setText("");
                ReplyTxt.setEditable(true);
            }
            else
            {
                ReplyTxt.setText(mymessageslist.get(this.iter).reply);
                ReplyTxt.setEditable(false);
            }
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
                if(cce != null)
                {
                        if((author[2].equals("--") || author[2].equals(this.cce.uname)) && author[3].equals("--"))
                        {
                            mymessageslist.add(new Message(author));
                        }  
                }
                else if(lender != null)
                {
                    if(author[0].equals(this.lender.uname))
                    {
                        mymessageslist.add(new Message(author));
                    }
                }
                else if(commuter != null)
                {
                    if(author[0].equals(this.commuter.uname))
                    {
                        mymessageslist.add(new Message(author));
                    }
                }
                
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    
    String ChangeToStringM(Message msg)
    {
        String ans = "";
        ans += msg.sender+" & "+msg.text+" & "+msg.receiver+" & "+msg.reply+" & "+msg.receiver_read+" & "+msg.sender_read+"&&";
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
        TitleLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        MsgLbl = new javax.swing.JLabel();
        MsgTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        ReplyLbl = new javax.swing.JLabel();
        ReplyTxt = new javax.swing.JTextField();
        SubmitBtn = new javax.swing.JButton();
        MarkAsReadBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        PrevBtn = new javax.swing.JButton();
        NextBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLbl.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        TitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLbl.setText("Customer Messages");

        MsgLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MsgLbl.setText("Message");

        MsgTxt.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MsgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MsgTxt)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MsgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MsgTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap())
        );

        ReplyLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReplyLbl.setText("Reply");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReplyLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReplyTxt)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReplyLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReplyTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        SubmitBtn.setText("Submit");
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBtnActionPerformed(evt);
            }
        });

        MarkAsReadBtn.setText("Mark As Read");
        MarkAsReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkAsReadBtnActionPerformed(evt);
            }
        });

        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

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

        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubmitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PrevBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NextBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MarkAsReadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitBtn)
                    .addComponent(MarkAsReadBtn)
                    .addComponent(ClearBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrevBtn)
                    .addComponent(NextBtn)
                    .addComponent(ExitBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TitleLbl)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(TitleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        if(this.cce != null)
        {
            this.cce.setVisible(true);
            dispose();
        }
        else if(this.lender != null)
        {
            this.lender.setVisible(true);
            dispose();
        }
        else if(this.commuter != null)
        {
            this.commuter.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void PrevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevBtnActionPerformed
        // TODO add your handling code here:
        mymessageslist.clear();
        load_dataM(MESSAGES_FILE);
        this.len = mymessageslist.size();
        if(this.len > 0)
        {
            if(this.iter > 0)
            {
                this.iter--;
            }
            else
            {
                this.iter = 0;
            }
            MsgTxt.setText(mymessageslist.get(this.iter).text);
            if(mymessageslist.get(this.iter).reply.equals("--"))
            {
                ReplyTxt.setText("");
                ReplyTxt.setEditable(true);
            }
            else
            {
                ReplyTxt.setText(mymessageslist.get(this.iter).reply);
                ReplyTxt.setEditable(false);
            }
        }
    }//GEN-LAST:event_PrevBtnActionPerformed

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        // TODO add your handling code here:
        mymessageslist.clear();
        load_dataM(MESSAGES_FILE);
        this.len = mymessageslist.size();
        if(this.len > 0)
        {
            if(this.iter < this.len - 1)
            {
                this.iter++;
            }
            else
            {
                this.iter = this.len - 1;
            }
            MsgTxt.setText(mymessageslist.get(this.iter).text);
            if(mymessageslist.get(this.iter).reply.equals("--"))
            {
                ReplyTxt.setText("");
                ReplyTxt.setEditable(true);
            }
            else
            {
                ReplyTxt.setText(mymessageslist.get(this.iter).reply);
                ReplyTxt.setEditable(false);
            }
        }
    }//GEN-LAST:event_NextBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        ReplyTxt.setText("");
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void MarkAsReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkAsReadBtnActionPerformed
        // TODO add your handling code here:
        if(this.cce != null)
        {
            String prev = ChangeToStringM(mymessageslist.get(this.iter));
            mymessageslist.get(this.iter).receiver = this.cce.uname;
            mymessageslist.get(this.iter).receiver_read = "Yes";
            String next = ChangeToStringM(mymessageslist.get(this.iter));
            modify(MESSAGES_FILE, prev, next);
        }
        else if(this.lender != null)
        {
            String prev = ChangeToStringM(mymessageslist.get(this.iter));
            mymessageslist.get(this.iter).sender = this.lender.uname;
            mymessageslist.get(this.iter).sender_read = "Yes";
            String next = ChangeToStringM(mymessageslist.get(this.iter));
            modify(MESSAGES_FILE, prev, next);
        }
        else if(this.commuter != null)
        {
            String prev = ChangeToStringM(mymessageslist.get(this.iter));
            mymessageslist.get(this.iter).sender = this.commuter.uname;
            mymessageslist.get(this.iter).sender_read = "Yes";
            String next = ChangeToStringM(mymessageslist.get(this.iter));
            modify(MESSAGES_FILE, prev, next);
        }
    }//GEN-LAST:event_MarkAsReadBtnActionPerformed

    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBtnActionPerformed
        // TODO add your handling code here:
        if(this.cce != null)
        {
            String prev = ChangeToStringM(mymessageslist.get(this.iter));
            mymessageslist.get(this.iter).receiver = this.cce.uname;
            mymessageslist.get(this.iter).receiver_read = "Yes";
            mymessageslist.get(this.iter).reply = ReplyTxt.getText();
            String next = ChangeToStringM(mymessageslist.get(this.iter));
            modify(MESSAGES_FILE, prev, next);
            ReplyTxt.setEditable(false);
        }
    }//GEN-LAST:event_SubmitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMessages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton MarkAsReadBtn;
    private javax.swing.JLabel MsgLbl;
    private javax.swing.JTextField MsgTxt;
    private javax.swing.JButton NextBtn;
    private javax.swing.JButton PrevBtn;
    private javax.swing.JLabel ReplyLbl;
    private javax.swing.JTextField ReplyTxt;
    private javax.swing.JButton SubmitBtn;
    private javax.swing.JLabel TitleLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
