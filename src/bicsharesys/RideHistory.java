/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

import static bicsharesys.Bicycle.BICYCLE_FILE;
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
public class RideHistory extends javax.swing.JFrame {

    /**
     * Creates new form RideHistory
     */
    Commuter commuter;
    LendingPage bicycle;
    Admin admin;
    List<Ride> ridelist;
    List<LendingPage> bicyclelist;
    int iter;
    static final String RIDE_FILE = "data//ride.txt";
    static final String BICYCLE_FILE = "data//bicycle.txt";
    
    public RideHistory() {
        initComponents();
    }
    
    public RideHistory(Commuter user) {
        initComponents();
        ChooseBicPanel.setVisible(false);
        this.commuter = user;
        ridelist = new ArrayList();
        bicyclelist = new ArrayList();
        load_dataR(RIDE_FILE);
        this.iter = 0;
        if(ridelist.size() > 0)
        {
            BicCodeTxt.setVisible(true);
            StartLocTxt.setVisible(true);
            EndLocTxt.setVisible(true);
            StartTimeTxt.setVisible(true);
            EndTimeTxt.setVisible(true);
            RatingTxt.setVisible(true);
            BicCodeLbl.setVisible(true);
            StartLocLbl.setVisible(true);
            StartTimeLbl.setVisible(true);
            EndTimeLbl.setVisible(true);
            EndLocLbl.setVisible(true);
            RatingLbl.setVisible(true);
            PrevBtn.setVisible(true);
            NextBtn.setVisible(true);
            BicCodeTxt.setText(ridelist.get(this.iter).bicycle_code);
            StartLocTxt.setText(ridelist.get(this.iter).start_location);
            EndLocTxt.setText(ridelist.get(this.iter).end_location);
            StartTimeTxt.setText(ridelist.get(this.iter).start_time);
            EndTimeTxt.setText(ridelist.get(this.iter).end_time);
            RatingTxt.setText(ridelist.get(this.iter).rating);
        }
        else
        {
            BicCodeTxt.setVisible(false);
            StartLocTxt.setVisible(false);
            EndLocTxt.setVisible(false);
            StartTimeTxt.setVisible(false);
            EndTimeTxt.setVisible(false);
            RatingTxt.setVisible(false);
            BicCodeLbl.setVisible(false);
            StartLocLbl.setVisible(false);
            StartTimeLbl.setVisible(false);
            EndTimeLbl.setVisible(false);
            EndLocLbl.setVisible(false);
            RatingLbl.setVisible(false);
            PrevBtn.setVisible(false);
            NextBtn.setVisible(false);
            javax.swing.JOptionPane.showMessageDialog(this,"No rides found!"); 
        }
    }
    
    public RideHistory(Admin admin) {
        initComponents();
        BicCodeLbl.setText("Commuter");
        this.admin = admin;
        ridelist = new ArrayList();
        bicyclelist = new ArrayList();
        load_dataB(BICYCLE_FILE);
        BicycleCombo.removeAllItems();
        BicycleCombo.setEditable(true);
        for(LendingPage bicycle : bicyclelist)
        {
//            if(bicycle.location.equals(this.current_location) && bicycle.occupied.equals("0"))
//            {
                BicycleCombo.addItem(bicycle.code);
                System.out.println("Added");
//            }
//            System.out.println("No idea");
        }
        BicycleCombo.setEditable(false);
        this.setVisible(true);
        this.bicycle = bicycle;
        ridelist = new ArrayList();
        load_dataR(RIDE_FILE);
        this.iter = 0;
        if(ridelist.size() > 0)
        {
            BicCodeTxt.setVisible(true);
            StartLocTxt.setVisible(true);
            EndLocTxt.setVisible(true);
            StartTimeTxt.setVisible(true);
            EndTimeTxt.setVisible(true);
            RatingTxt.setVisible(true);
            BicCodeLbl.setVisible(true);
            StartLocLbl.setVisible(true);
            StartTimeLbl.setVisible(true);
            EndTimeLbl.setVisible(true);
            EndLocLbl.setVisible(true);
            RatingLbl.setVisible(true);
            PrevBtn.setVisible(true);
            NextBtn.setVisible(true);
            BicCodeTxt.setText(ridelist.get(this.iter).rider);
            StartLocTxt.setText(ridelist.get(this.iter).start_location);
            EndLocTxt.setText(ridelist.get(this.iter).end_location);
            StartTimeTxt.setText(ridelist.get(this.iter).start_time);
            EndTimeTxt.setText(ridelist.get(this.iter).end_time);
            RatingTxt.setText(ridelist.get(this.iter).rating);
            this.setVisible(true);
        }
        else
        {
            BicCodeTxt.setVisible(false);
            StartLocTxt.setVisible(false);
            EndLocTxt.setVisible(false);
            StartTimeTxt.setVisible(false);
            EndTimeTxt.setVisible(false);
            RatingTxt.setVisible(false);
            BicCodeLbl.setVisible(false);
            StartLocLbl.setVisible(false);
            StartTimeLbl.setVisible(false);
            EndTimeLbl.setVisible(false);
            EndLocLbl.setVisible(false);
            RatingLbl.setVisible(false);
            PrevBtn.setVisible(false);
            NextBtn.setVisible(false);
            javax.swing.JOptionPane.showMessageDialog(this,"No rides found!"); 
        }
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
    
    private void load_dataR(String filename) {
        System.out.println("in load data func ");
        ridelist.clear();
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            s.useDelimiter("\\s*;\\s*");
            while(s.hasNext()){
                String[] author = s.next().split("\\s*,\\s*");
                if(this.commuter != null)
                {
                    if(author[1].equals(this.commuter.uname))
                    {
                        ridelist.add(new Ride(author));
                    }
                }
                else if(this.admin != null)
                {
                    if(author[0].equals(BicycleCombo.getSelectedItem()))
                    {
                        ridelist.add(new Ride(author));
                    }
                }
                
            }
        }catch (IOException e){
            System.out.println("Cannot open file " + filename);
        }
    }
    
    String ChangeToStringR(Ride ride)
    {
        String data = "";
        data += ride.bicycle_code+", "+ride.rider+", "+ride.start_time+", "+ride.start_location+", "+ride.end_time+", "+ride.end_location+", "+ride.rating+";\n";
        return data;
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
        jPanel4 = new javax.swing.JPanel();
        EndLocLbl = new javax.swing.JLabel();
        EndLocTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        StartLocLbl = new javax.swing.JLabel();
        StartLocTxt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        BicCodeLbl = new javax.swing.JLabel();
        BicCodeTxt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        EndTimeLbl = new javax.swing.JLabel();
        EndTimeTxt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        RatingLbl = new javax.swing.JLabel();
        RatingTxt = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        StartTimeLbl = new javax.swing.JLabel();
        StartTimeTxt = new javax.swing.JTextField();
        PrevBtn = new javax.swing.JButton();
        NextBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        ChooseBicPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BicycleCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Ride History");

        EndLocLbl.setText("End Location");

        EndLocTxt.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(EndLocLbl)
                .addGap(32, 32, 32)
                .addComponent(EndLocTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(EndLocLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(EndLocTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        StartLocLbl.setText("Start Location");

        StartLocTxt.setEditable(false);

        BicCodeLbl.setText("Bicycle Code");

        BicCodeTxt.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(BicCodeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(BicCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BicCodeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BicCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(StartLocLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StartLocTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartLocLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartLocTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        EndTimeLbl.setText("End Time");

        EndTimeTxt.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(EndTimeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(EndTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(EndTimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(EndTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RatingLbl.setText("Rating");

        RatingTxt.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(RatingLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RatingTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(RatingLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(RatingTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        StartTimeLbl.setText("Start Time");

        StartTimeTxt.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(StartTimeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StartTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(StartTimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(StartTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PrevBtn.setText("Previous");
        PrevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevBtnActionPerformed(evt);
            }
        });

        NextBtn.setText("Next");
        NextBtn.setPreferredSize(new java.awt.Dimension(71, 30));
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

        jLabel4.setText("Choose Bicycle");

        BicycleCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BicycleComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout ChooseBicPanelLayout = new javax.swing.GroupLayout(ChooseBicPanel);
        ChooseBicPanel.setLayout(ChooseBicPanelLayout);
        ChooseBicPanelLayout.setHorizontalGroup(
            ChooseBicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChooseBicPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(BicycleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        ChooseBicPanelLayout.setVerticalGroup(
            ChooseBicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChooseBicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChooseBicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(BicycleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(PrevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ChooseBicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrevBtn)
                    .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitBtn)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ChooseBicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(266, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        if(this.commuter != null)
        {
            this.commuter.setVisible(true);
            dispose();
        }
        if(this.admin != null)
        {
            this.admin.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void PrevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevBtnActionPerformed
        // TODO add your handling code here:
        ridelist = new ArrayList();
        load_dataR(RIDE_FILE);
        if(this.commuter != null)
        {
            if(this.iter > 0)
            {
                this.iter--;
            }
            if(ridelist.size() > 0)
            {
//                BicCodeLbl.setText("Commuter");
                BicCodeTxt.setText(ridelist.get(this.iter).bicycle_code);
                StartLocTxt.setText(ridelist.get(this.iter).start_location);
                EndLocTxt.setText(ridelist.get(this.iter).end_location);
                StartTimeTxt.setText(ridelist.get(this.iter).start_time);
                EndTimeTxt.setText(ridelist.get(this.iter).end_time);
                RatingTxt.setText(ridelist.get(this.iter).rating);
                this.setVisible(true);
            }
        }
        if(this.admin != null)
        {
            if(this.iter > 0)
            {
                this.iter--;
            }
            if(ridelist.size() > 0)
            {
                BicCodeLbl.setText("Commuter");
                BicCodeTxt.setText(ridelist.get(this.iter).rider);
                StartLocTxt.setText(ridelist.get(this.iter).start_location);
                EndLocTxt.setText(ridelist.get(this.iter).end_location);
                StartTimeTxt.setText(ridelist.get(this.iter).start_time);
                EndTimeTxt.setText(ridelist.get(this.iter).end_time);
                RatingTxt.setText(ridelist.get(this.iter).rating);
                this.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_PrevBtnActionPerformed

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        // TODO add your handling code here:
        ridelist = new ArrayList();
        load_dataR(RIDE_FILE);
        if(this.commuter != null)
        {
            if(this.iter < ridelist.size()-1)
            {
                this.iter++;
            }
            if(ridelist.size() > 0)
            {
//                BicCodeLbl.setText("Commuter");
                BicCodeTxt.setText(ridelist.get(this.iter).bicycle_code);
                StartLocTxt.setText(ridelist.get(this.iter).start_location);
                EndLocTxt.setText(ridelist.get(this.iter).end_location);
                StartTimeTxt.setText(ridelist.get(this.iter).start_time);
                EndTimeTxt.setText(ridelist.get(this.iter).end_time);
                RatingTxt.setText(ridelist.get(this.iter).rating);
                this.setVisible(true);
            }
        }
        if(this.admin != null)
        {
            if(this.iter < ridelist.size()-1)
            {
                this.iter++;
            }
            if(ridelist.size() > 0)
            {
                BicCodeLbl.setText("Commuter");
                BicCodeTxt.setText(ridelist.get(this.iter).rider);
                StartLocTxt.setText(ridelist.get(this.iter).start_location);
                EndLocTxt.setText(ridelist.get(this.iter).end_location);
                StartTimeTxt.setText(ridelist.get(this.iter).start_time);
                EndTimeTxt.setText(ridelist.get(this.iter).end_time);
                RatingTxt.setText(ridelist.get(this.iter).rating);
                this.setVisible(true);
            }
        }
    }//GEN-LAST:event_NextBtnActionPerformed

    private void BicycleComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BicycleComboItemStateChanged
        // TODO add your handling code here:
        ridelist = new ArrayList();
        load_dataR(RIDE_FILE);
        this.iter = 0;
        if(ridelist.size() > 0)
        {
            BicCodeTxt.setVisible(true);
            StartLocTxt.setVisible(true);
            EndLocTxt.setVisible(true);
            StartTimeTxt.setVisible(true);
            EndTimeTxt.setVisible(true);
            RatingTxt.setVisible(true);
            BicCodeLbl.setVisible(true);
            StartLocLbl.setVisible(true);
            StartTimeLbl.setVisible(true);
            EndTimeLbl.setVisible(true);
            EndLocLbl.setVisible(true);
            RatingLbl.setVisible(true);
            PrevBtn.setVisible(true);
            NextBtn.setVisible(true);
            BicCodeTxt.setText(ridelist.get(this.iter).rider);
            StartLocTxt.setText(ridelist.get(this.iter).start_location);
            EndLocTxt.setText(ridelist.get(this.iter).end_location);
            StartTimeTxt.setText(ridelist.get(this.iter).start_time);
            EndTimeTxt.setText(ridelist.get(this.iter).end_time);
            RatingTxt.setText(ridelist.get(this.iter).rating);
            this.setVisible(true);
        }
        else
        {
            BicCodeTxt.setVisible(false);
            StartLocTxt.setVisible(false);
            EndLocTxt.setVisible(false);
            StartTimeTxt.setVisible(false);
            EndTimeTxt.setVisible(false);
            RatingTxt.setVisible(false);
            BicCodeLbl.setVisible(false);
            StartLocLbl.setVisible(false);
            StartTimeLbl.setVisible(false);
            EndTimeLbl.setVisible(false);
            EndLocLbl.setVisible(false);
            RatingLbl.setVisible(false);
            PrevBtn.setVisible(false);
            NextBtn.setVisible(false);
            javax.swing.JOptionPane.showMessageDialog(this,"No rides found!"); 
//            BicCodeTxt.setText("");
//            StartLocTxt.setText("");
//            EndLocTxt.setText("");
//            StartTimeTxt.setText("");
//            EndTimeTxt.setText("");
//            RatingTxt.setText("");
//            this.setVisible(true);
        }
    }//GEN-LAST:event_BicycleComboItemStateChanged

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
            java.util.logging.Logger.getLogger(RideHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RideHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RideHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RideHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RideHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BicCodeLbl;
    private javax.swing.JTextField BicCodeTxt;
    private javax.swing.JComboBox<String> BicycleCombo;
    private javax.swing.JPanel ChooseBicPanel;
    private javax.swing.JLabel EndLocLbl;
    private javax.swing.JTextField EndLocTxt;
    private javax.swing.JLabel EndTimeLbl;
    private javax.swing.JTextField EndTimeTxt;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton NextBtn;
    private javax.swing.JButton PrevBtn;
    private javax.swing.JLabel RatingLbl;
    private javax.swing.JTextField RatingTxt;
    private javax.swing.JLabel StartLocLbl;
    private javax.swing.JTextField StartLocTxt;
    private javax.swing.JLabel StartTimeLbl;
    private javax.swing.JTextField StartTimeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
