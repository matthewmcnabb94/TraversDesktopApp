
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matth
 */
public class Reports extends javax.swing.JFrame {
    
    
    public static String userd;
    
    
    

    /**
     * Creates new form DeleteOrder
     */
    public Reports() {
        initComponents();
        jXDatePicker1.getEditor().setEditable(false);
        jXDatePicker2.getEditor().setEditable(false);
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
        jButton2 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate a report");
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jButton2.setText("Create Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Start date");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("End date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(82, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    public boolean generateReports(String sDate, String eDate) {
        
        try {
            userd = System.getProperty("user.home");
            
            
            File f = new File(userd+"\\Desktop\\car\\OrdersReport\\OrdersReport.csv");
            if(f.exists())
            {
                f.delete();
                System.out.println("File exists");
            }
            else
            {
                System.out.println("File does not exist");
            }

            FileWriter fw = new FileWriter(userd+"\\Desktop\\car\\OrdersReport\\OrdersReport.csv", true);
            
            String hostName = "3.16.15.26";
            int port = 80;

            Socket kkSocket = new Socket(hostName, port);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);

            System.out.println("Listing all information");
            out.println("REPORTS,"+sDate + "," +eDate);
            out.flush();
            
            ObjectInputStream object = new ObjectInputStream(kkSocket.getInputStream());
            Object obj = object.readObject();
            ArrayList<String[]> data = new ArrayList<>();
            data = (ArrayList<String[]>) obj;
            System.out.println("The response set is " + data.size());
            
            BufferedWriter bw20 = new BufferedWriter(fw);
            PrintWriter outp20 = new PrintWriter(bw20);
            
            outp20.println("Order number, Customer Name, Date due, Vehicle details, Turbo part model, Price, Payment, Fitting required, Order started date, Order status");
            outp20.flush();
            
            
            
            
            for (String[] rows : data) {
                String[] variables = rows;
                String Id = variables[0];
                String customerName = variables[1];
                String date = variables[2];
                String vehicleDetails = variables[3];
                String turboPartNumber = variables[4];
                String price = variables[5];
                String payment = variables[6];
                String fittingRequired = variables[7];
                String orderStartedDate = variables[8];
                String orderStatus = variables[9];
                
                System.out.println("Reply is: "+Id + "," + customerName + "," + date + "," + vehicleDetails + "," + turboPartNumber + "," + price + "," + payment + "," +fittingRequired + "," +orderStartedDate);
                outp20.println(Id + "," + customerName + "," + date + "," + vehicleDetails + "," + turboPartNumber + "," + price + "," + payment + "," +fittingRequired + "," +orderStartedDate + "," +orderStatus);
                outp20.flush();
                
                
                

            }
            
            outp20.close();
            
            return true;
            

        } catch (Exception e) {

// TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());

            e.printStackTrace();

        }
        
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        
        if(jXDatePicker1.getDate() != null && jXDatePicker2.getDate() != null)
        {
            
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
            String startDate = formater.format(jXDatePicker1.getDate());
            String endDate = formater.format(jXDatePicker2.getDate());
            System.out.println("start date = "+startDate);
            System.out.println("end date = "+endDate);
            
            
            
            if(generateReports(startDate,endDate))
            {
                JOptionPane.showMessageDialog(null, "Exported successfully to locationL: "+userd+"\\Desktop\\car\\OrdersReport\\OrdersReport.csv");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error exporting, try again.");
            }
            
            
            
            
            
            
            
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The date field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    // End of variables declaration//GEN-END:variables
}
