/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sharat
 */
public class Ride extends javax.swing.JFrame {

    /**
     * Creates new form Ride
     */
    LendingPage bicycle;
    Commuter user;
    String bicycle_code, rider, start_time, start_location, end_time, end_location, rating;
    LocalDateTime start, stop;
    DateFormat dateFormat;
    SimpleDateFormat format;
    List<Commuter> commuterlist;
    static int hh, mm, ss;
    static final String COMMUTER_FILE = "data//commuter.txt";
    static final String BICYCLE_FILE = "data//bicycle.txt";
    static final String RIDE_FILE = "data//ride.txt";
    
    public Ride() {
        initComponents();
    }
    
    public Ride(Commuter user, LendingPage bicycle) {
        initComponents();
        NextBtn.setVisible(false);
        TimerLbl.setVisible(false);
        TimerDispLbl.setVisible(false);
        commuterlist = new ArrayList();
        load_dataC(COMMUTER_FILE);
        this.bicycle = bicycle;
        this.user = user;
        this.bicycle_code = bicycle.code;
        this.rider = bicycle.current_user;
        this.start_location = bicycle.location;
        Date date = Calendar.getInstance().getTime();  
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        this.start = LocalDateTime.now();
        
        this.start_time = this.dateFormat.format(date);
        
//        this.setVisible(true);
        
    }
    
    public Ride(String[] user) {
        initComponents();
        this.bicycle_code = user[0];
        this.rider = user[1];
        this.start_time = user[2];
        this.start_location = user[3];
        this.end_time = user[4];
        this.end_location = user[5];
        this.rating = user[6];
    }
    
//    public static void run_timer()
//    {
//        Instant prev = Instant.now();
//        hh=00; 
//        mm=00;
//        ss=00;
//        TimerDispLbl.setText("00 : 00 : 00");
//        for(;;)
//        {
//              if(Duration.between(prev, Instant.now()).getSeconds() > 1)
//              {
//                  prev = Instant.now();
//                  ss++;
//                  if(ss >= 60)
//                  {
//                      ss = 0;
//                      mm++;
//                      if(mm >= 60)
//                      {
//                          mm = 0;
//                          hh++;
//                      }
//                  }
//                  String passed_time = String.format("%02d : %02d : %02d", hh, mm, ss);
//                  TimerDispLbl.setText(passed_time);
////                  this.setVisible(true);
//              }
//
////            LocalDateTime now = LocalDateTime.now();
////            this.setVisible(true);
//        }
//    }
    
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
    
    void RideWrite(String filename)
    {
        String data = "";
        data += this.bicycle_code+", "+this.rider+", "+this.start_time+", "+this.start_location+", "+this.end_time+", "+this.end_location+", "+this.rating+";\n";
    
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            File file = new File(filename);
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("Writing done");
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
    
    String ChangeToStringB(LendingPage bic)
    {
        String ans = "";
        ans += bic.code+", "+bic.location+", "+bic.occupied+", "+bic.giver+", "+bic.current_user+";";
        return ans;
    }
    
    String ChangeToStringC(Commuter user)
    {
        String ans = "";
        ans += user.uname+", "+user.password+", "+user.name+", "+user.phone+", "+user.email+", "+user.balance+", "+user.emergency_phone+", "+user.gender+", "+user.blood_group+";\n";
        return ans;
    }
    
    void Write(String filename, String data)
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
        System.out.println(oldLine);
        System.out.println(newLine);
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
    
    void chargeCommuter(Commuter user, long duration)
    {
        int value = 10;
        if(duration > 15)
        {
            value += Math.ceil((duration-15)/15); 
        }
        String prev = ChangeToStringC(user);
        user.balance = Integer.toString(Integer.parseInt(user.balance)-value);
        String next = ChangeToStringC(user);
        modify(COMMUTER_FILE, prev, next);
        for(Commuter commuter : commuterlist)
            {
                if(commuter.uname.equals(user.uname))
                {
                    commuter.balance = user.balance;
                }
            }
            try(PrintWriter writer = new PrintWriter(COMMUTER_FILE))
            {
                writer.print("");
            }
            catch(Exception e)
            {
                System.out.println("Cannot open file"+COMMUTER_FILE);
            }
            for(Commuter commuter : commuterlist)
            {
                Write(COMMUTER_FILE, ChangeToStringC(commuter));
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TimerLbl = new javax.swing.JLabel();
        TimerDispLbl = new javax.swing.JLabel();
        EndRideBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        FinalLocLbl = new javax.swing.JLabel();
        LocationCombo = new javax.swing.JComboBox<>();
        NextBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        RatingCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TimerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerLbl.setText("Timer");

        TimerDispLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerDispLbl.setText("Timing");
        TimerDispLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(TimerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TimerDispLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TimerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(TimerDispLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EndRideBtn.setText("End Ride");
        EndRideBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndRideBtnActionPerformed(evt);
            }
        });

        FinalLocLbl.setText("Final Location");

        LocationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Building", "Nalanda Classroom Complex", "Pan Loop", "Gymkhana", "Tech Market" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(FinalLocLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LocationCombo, 0, 245, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(FinalLocLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addComponent(LocationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        NextBtn.setText("Next");
        NextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Rating");

        RatingCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "4", "3", "2", "1" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(RatingCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RatingCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(EndRideBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NextBtn)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EndRideBtn)
                    .addComponent(NextBtn))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Ride Has Started");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
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

    private void EndRideBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndRideBtnActionPerformed
        // TODO add your handling code here:
        if(this.end_time == null)
        {
            Date date = Calendar.getInstance().getTime();  
            this.end_time = this.dateFormat.format(date);
//            this.stop = LocalDateTime.now();
            Date d1 = null;
            Date d2 = null;
            try {
            d1 = this.dateFormat.parse(this.start_time);
            d2 = this.dateFormat.parse(this.end_time);
            } 
            catch (ParseException e) {
                e.printStackTrace();
            }    

            // Get msec from each, and subtract.
            long diff = d2.getTime() - d1.getTime();
//            long diffSeconds = diff / 1000;         
            long diffMinutes = diff / (60 * 1000);
            chargeCommuter(this.user, diffMinutes);
            EndRideBtn.setVisible(false);
            NextBtn.setVisible(true);
        }
    }//GEN-LAST:event_EndRideBtnActionPerformed

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        // TODO add your handling code here:
        this.end_location = LocationCombo.getSelectedItem().toString();
        this.rating = RatingCombo.getSelectedItem().toString();
        String prev = ChangeToStringB(this.bicycle);
        this.bicycle.location = this.end_location;
        this.bicycle.occupied = "0";
        this.bicycle.current_user = "--";
        String next = ChangeToStringB(this.bicycle);
        modify(BICYCLE_FILE, prev, next);
        RideWrite(RIDE_FILE);
        this.user.setVisible(true);
        dispose();
    }//GEN-LAST:event_NextBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Ride.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ride.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ride.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ride.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ride().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EndRideBtn;
    private javax.swing.JLabel FinalLocLbl;
    private javax.swing.JComboBox<String> LocationCombo;
    private javax.swing.JButton NextBtn;
    private javax.swing.JComboBox<String> RatingCombo;
    private javax.swing.JLabel TimerDispLbl;
    private javax.swing.JLabel TimerLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
