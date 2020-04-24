/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

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
public class ViewCustomer extends javax.swing.JFrame {

    /**
     * Creates new form ViewCustomer
     */
    Admin admin;
    String customer;
    int iter;
    List<Commuter> commuterlist;
    List<Lender> lenderlist;
    List<CustomerCareEmp> ccelist;
    static final String COMMUTER_FILE = "data//commuter.txt";
    static final String LENDER_FILE = "data//lender.txt";
    static final String CCE_FILE = "data//customer_care.txt";
    
    public ViewCustomer() {
        initComponents();
    }

    public ViewCustomer( Admin admin, String customer) {
        initComponents();
        this.admin = admin;
        this.customer = customer;
        commuterlist = new ArrayList();
        lenderlist = new ArrayList();
        ccelist = new ArrayList();
        this.iter = 0;
        if(this.customer.equals("Commuter"))
        {
            commuterlist = new ArrayList();
            TitleLbl.setText("Commuters");
            load_dataC(COMMUTER_FILE);
            NameTxt.setText(commuterlist.get(this.iter).name);
            UserNameTxt.setText(commuterlist.get(this.iter).uname);
            PasswordTxt.setText(commuterlist.get(this.iter).password);
            EmailTxt.setText(commuterlist.get(this.iter).email);
            MobileTxt.setText(commuterlist.get(this.iter).phone);
            EmergencyMobileTxt.setText(commuterlist.get(this.iter).emergency_phone);
            GenderTxt.setText(commuterlist.get(this.iter).gender);
            BloodGroupTxt.setText(commuterlist.get(this.iter).blood_group);
        }
        else if(this.customer.equals("Lender"))
        {
            lenderlist = new ArrayList();
            TitleLbl.setText("Lenders");
            load_dataL(LENDER_FILE);
            NameTxt.setText(lenderlist.get(this.iter).name);
            UserNameTxt.setText(lenderlist.get(this.iter).uname);
            PasswordTxt.setText(lenderlist.get(this.iter).password);
            EmailTxt.setText(lenderlist.get(this.iter).email);
            MobileTxt.setText(lenderlist.get(this.iter).phone);
            EmergencyMobileTxt.setText(lenderlist.get(this.iter).emergency_phone);
            GenderTxt.setText(lenderlist.get(this.iter).gender);
            BloodGroupTxt.setText(lenderlist.get(this.iter).blood_group);
        }
        else if(this.customer.equals("CCE"))
        {
            ccelist = new ArrayList();
            TitleLbl.setText("Employees");
            load_dataCCE(CCE_FILE);
            NameTxt.setText(ccelist.get(this.iter).name);
            UserNameTxt.setText(ccelist.get(this.iter).uname);
            PasswordTxt.setText(ccelist.get(this.iter).password);
            EmailTxt.setText(ccelist.get(this.iter).email);
            MobileTxt.setText(ccelist.get(this.iter).phone);
            EmergencyMobileTxt.setText(ccelist.get(this.iter).emergency_phone);
            GenderTxt.setText(ccelist.get(this.iter).gender);
            BloodGroupTxt.setText(ccelist.get(this.iter).blood_group);
        }
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
        jPanel4 = new javax.swing.JPanel();
        NameLbl = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        UserNameLbl = new javax.swing.JLabel();
        UserNameTxt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        PasswordLbl = new javax.swing.JLabel();
        PasswordTxt = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        EmailLbl = new javax.swing.JLabel();
        EmailTxt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        MobileLbl = new javax.swing.JLabel();
        MobileTxt = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        EmergencyMobileLbl = new javax.swing.JLabel();
        EmergencyMobileTxt = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        BloodGroupLbl = new javax.swing.JLabel();
        GenderTxt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        BloodGroupLbl1 = new javax.swing.JLabel();
        BloodGroupTxt = new javax.swing.JTextField();
        PrevBtn = new javax.swing.JButton();
        NextBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLbl.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        TitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLbl.setText("View Customer");

        NameLbl.setText("Name");

        NameTxt.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        UserNameLbl.setText("User Name");

        UserNameTxt.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UserNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserNameTxt)
            .addComponent(UserNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PasswordLbl.setText("Password");

        PasswordTxt.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PasswordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PasswordTxt)
            .addComponent(PasswordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EmailLbl.setText("Email Id");

        EmailTxt.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EmailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EmailTxt)
                    .addComponent(EmailLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MobileLbl.setText("Mobile");

        MobileTxt.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MobileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(MobileLbl)
                .addComponent(MobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EmergencyMobileLbl.setText("Emergency Mobile");

        EmergencyMobileTxt.setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EmergencyMobileLbl)
                .addGap(4, 4, 4)
                .addComponent(EmergencyMobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(EmergencyMobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(EmergencyMobileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BloodGroupLbl.setText("Gender");

        GenderTxt.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BloodGroupLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GenderTxt)
            .addComponent(BloodGroupLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BloodGroupLbl1.setText("Blood Group");

        BloodGroupTxt.setEditable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BloodGroupLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BloodGroupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BloodGroupTxt)
            .addComponent(BloodGroupLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PrevBtn)
                        .addGap(41, 41, 41)
                        .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrevBtn)
                    .addComponent(NextBtn)
                    .addComponent(ExitBtn))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void PrevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevBtnActionPerformed
        // TODO add your handling code here:
        if(this.iter > 0)
            this.iter--;
        else
            this.iter = 0;
        if(this.customer.equals("Commuter"))
        {
            commuterlist = new ArrayList();
            TitleLbl.setText("Commuters");
            load_dataC(COMMUTER_FILE);
            NameTxt.setText(commuterlist.get(this.iter).name);
            UserNameTxt.setText(commuterlist.get(this.iter).uname);
            PasswordTxt.setText(commuterlist.get(this.iter).password);
            EmailTxt.setText(commuterlist.get(this.iter).email);
            MobileTxt.setText(commuterlist.get(this.iter).phone);
            EmergencyMobileTxt.setText(commuterlist.get(this.iter).emergency_phone);
            GenderTxt.setText(commuterlist.get(this.iter).gender);
            BloodGroupTxt.setText(commuterlist.get(this.iter).blood_group);
        }
        else if(this.customer.equals("Lender"))
        {
            lenderlist = new ArrayList();
            TitleLbl.setText("Lenders");
            load_dataL(LENDER_FILE);
            NameTxt.setText(lenderlist.get(this.iter).name);
            UserNameTxt.setText(lenderlist.get(this.iter).uname);
            PasswordTxt.setText(lenderlist.get(this.iter).password);
            EmailTxt.setText(lenderlist.get(this.iter).email);
            MobileTxt.setText(lenderlist.get(this.iter).phone);
            EmergencyMobileTxt.setText(lenderlist.get(this.iter).emergency_phone);
            GenderTxt.setText(lenderlist.get(this.iter).gender);
            BloodGroupTxt.setText(lenderlist.get(this.iter).blood_group);
        }
        else if(this.customer.equals("CCE"))
        {
            ccelist = new ArrayList();
            TitleLbl.setText("Employees");
            load_dataCCE(CCE_FILE);
            NameTxt.setText(ccelist.get(this.iter).name);
            UserNameTxt.setText(ccelist.get(this.iter).uname);
            PasswordTxt.setText(ccelist.get(this.iter).password);
            EmailTxt.setText(ccelist.get(this.iter).email);
            MobileTxt.setText(ccelist.get(this.iter).phone);
            EmergencyMobileTxt.setText(ccelist.get(this.iter).emergency_phone);
            GenderTxt.setText(ccelist.get(this.iter).gender);
            BloodGroupTxt.setText(ccelist.get(this.iter).blood_group);
        }
        
    }//GEN-LAST:event_PrevBtnActionPerformed

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        // TODO add your handling code here:
        if(this.customer.equals("Commuter"))
        {
            commuterlist = new ArrayList();
            TitleLbl.setText("Commuters");
            load_dataC(COMMUTER_FILE);
            if(this.iter < commuterlist.size()-1)
            {
                this.iter++;
            }
            else
            {
                this.iter = commuterlist.size()-1;
            }
            NameTxt.setText(commuterlist.get(this.iter).name);
            UserNameTxt.setText(commuterlist.get(this.iter).uname);
            PasswordTxt.setText(commuterlist.get(this.iter).password);
            EmailTxt.setText(commuterlist.get(this.iter).email);
            MobileTxt.setText(commuterlist.get(this.iter).phone);
            EmergencyMobileTxt.setText(commuterlist.get(this.iter).emergency_phone);
            GenderTxt.setText(commuterlist.get(this.iter).gender);
            BloodGroupTxt.setText(commuterlist.get(this.iter).blood_group);
        }
        else if(this.customer.equals("Lender"))
        {
            lenderlist = new ArrayList();
            TitleLbl.setText("Lenders");
            load_dataL(LENDER_FILE);
            if(this.iter < lenderlist.size()-1)
            {
                this.iter++;
            }
            else
            {
                this.iter = lenderlist.size()-1;
            }
            NameTxt.setText(lenderlist.get(this.iter).name);
            UserNameTxt.setText(lenderlist.get(this.iter).uname);
            PasswordTxt.setText(lenderlist.get(this.iter).password);
            EmailTxt.setText(lenderlist.get(this.iter).email);
            MobileTxt.setText(lenderlist.get(this.iter).phone);
            EmergencyMobileTxt.setText(lenderlist.get(this.iter).emergency_phone);
            GenderTxt.setText(lenderlist.get(this.iter).gender);
            BloodGroupTxt.setText(lenderlist.get(this.iter).blood_group);
        }
        else if(this.customer.equals("CCE"))
        {
            ccelist = new ArrayList();
            TitleLbl.setText("Employees");
            load_dataCCE(CCE_FILE);
            if(this.iter < ccelist.size()-1)
            {
                this.iter++;
            }
            else
            {
                this.iter = ccelist.size()-1;
            }
            NameTxt.setText(ccelist.get(this.iter).name);
            UserNameTxt.setText(ccelist.get(this.iter).uname);
            PasswordTxt.setText(ccelist.get(this.iter).password);
            EmailTxt.setText(ccelist.get(this.iter).email);
            MobileTxt.setText(ccelist.get(this.iter).phone);
            EmergencyMobileTxt.setText(ccelist.get(this.iter).emergency_phone);
            GenderTxt.setText(ccelist.get(this.iter).gender);
            BloodGroupTxt.setText(ccelist.get(this.iter).blood_group);
        }
    }//GEN-LAST:event_NextBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        this.admin.setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BloodGroupLbl;
    private javax.swing.JLabel BloodGroupLbl1;
    private javax.swing.JTextField BloodGroupTxt;
    private javax.swing.JLabel EmailLbl;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JLabel EmergencyMobileLbl;
    private javax.swing.JTextField EmergencyMobileTxt;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JTextField GenderTxt;
    private javax.swing.JLabel MobileLbl;
    private javax.swing.JTextField MobileTxt;
    private javax.swing.JLabel NameLbl;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JButton NextBtn;
    private javax.swing.JLabel PasswordLbl;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JButton PrevBtn;
    private javax.swing.JLabel TitleLbl;
    private javax.swing.JLabel UserNameLbl;
    private javax.swing.JTextField UserNameTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
