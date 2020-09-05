
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matth
 */
public class CreateOrder extends javax.swing.JFrame {
    
    private String customerName;
    private String datePicked;
    private String vehicleDetails;
    private String turboModel;
    private double price;
    private String payment;
    private String fittingRequired;
    

    /**
     * Creates new form CreateOrder
     */
    public CreateOrder() {
        initComponents();
        
        //method 1
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        System.out.println(timeStamp);
        
        timestamp.setText(timeStamp);
        
        jXDatePicker1.getEditor().setEditable(false);
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        cName = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        vDetails = new javax.swing.JTextField();
        tModel = new javax.swing.JTextField();
        pe = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        fRequired = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        timestamp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create an order");
        setBackground(new java.awt.Color(102, 102, 255));
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Customer Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Date Due");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Vehicle Details");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Turbo Part Number");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Payment");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Fitting Required");

        timestamp.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Order Started Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(timestamp)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(vDetails)
                                    .addComponent(tModel)
                                    .addComponent(pe)
                                    .addComponent(p)
                                    .addComponent(fRequired))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(207, 207, 207))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tModel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fRequired, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timestamp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int formatCounter = 0;
        
        boolean priceok = false;
        
        if(!cName.getText().equals(""))
        {
            customerName = cName.getText();
            formatCounter++;
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The customer name field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }       
        if(jXDatePicker1.getDate() != null)
        {
            Calendar cals = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
            String d = formater.format(jXDatePicker1.getDate());
            System.out.println("Date from calendar = "+d);
            datePicked = d;
            formatCounter++;
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The date field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        if(!vDetails.getText().equals(""))
        {
            vehicleDetails = vDetails.getText();
            formatCounter++;
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The vehicle details field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        if(!tModel.getText().equals(""))
        {
            turboModel = tModel.getText();
            formatCounter++;
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The turbo model field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        if(!pe.getText().equals(""))
        {
            formatCounter++;
            
            if(isNumeric(pe.getText()))
            {
               price = Double.parseDouble(pe.getText());
               priceok = true;
               
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                    "The price field must contain a number",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The price field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        if(!p.getText().equals(""))
        {
            formatCounter++;
            payment = p.getText();
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The payment field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        if(!fRequired.getText().equals(""))
        {
            formatCounter++;
            fittingRequired = fRequired.getText();
        }
        else
        {
            //custom title, error icon
            JOptionPane.showMessageDialog(null,
                    "The fitting required field cannot be blank",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        System.out.println("Format counter is: "+formatCounter);
        
        if(formatCounter == 7 && priceok)
        {
            System.out.println("Information ok. Sending.....");
            insertData();
        }
        
        System.out.println("Date is: "+datePicked);
        
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    
    
    
    
    
    
    
    
    
    
    
    
    private void insertData(){
     

     
        //create
        String protocolMessage = "CREATE,";
        protocolMessage += "('" + cName.getText().trim() + "'";
        protocolMessage += ",'" + datePicked + "'";
        protocolMessage += ",'" + vDetails.getText() + "'";
        protocolMessage += ",'" + tModel.getText() + "'";
        protocolMessage += ",'" + pe.getText() + "'";
        protocolMessage += ",'" + p.getText() + "'";
        protocolMessage += ",'" + fRequired.getText() + "'";
        protocolMessage += ",'" + timestamp.getText() + "'";
        protocolMessage += ")" + "\n";
     
        String hostName = "77.68.122.181";
        int port = 80;

     try {
         Socket kkSocket = new Socket(hostName, port);
         PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);          
         
         System.out.println("Insert Button Has Been Pressed");
         System.out.println("Client is Sending: " + protocolMessage);
         
         out.println(protocolMessage);           
         out.flush(); 
         
//         InputStreamReader isr = new InputStreamReader(kkSocket.getInputStream());
//         BufferedReader BR = new BufferedReader(isr);
//         String ResultSet = BR.readLine();



            try{
                
                String messageFromServer = null;
                ObjectInputStream object = new ObjectInputStream(kkSocket.getInputStream());
                Object obj = object.readObject();
                ArrayList<String[]> data = new ArrayList<>();
                data = (ArrayList<String[]>) obj;
                System.out.println("The result set is " + data.size());

            
                for (String[] rows : data) {
                    String[] variables = rows;

                    messageFromServer = variables[0];

                }

                if (messageFromServer != null) {
                    JOptionPane.showMessageDialog(null, messageFromServer, "Success", JOptionPane.INFORMATION_MESSAGE);
                    out.close();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Entry not sucessfull");
                }
            
            
            
            
            
            
            
            
            
            
            
            }catch(ClassNotFoundException e)
            {
                System.out.println("Exception: "+e.getMessage());
            }
            
            
            
            
         
         
         
     } 
     catch (UnknownHostException e1) {
         JOptionPane.showMessageDialog(null, "Don't know about host " + hostName);
     } 
     catch (IOException e2) {
         JOptionPane.showMessageDialog(null, "Couldn't get I/O for the connection to " +
             hostName);
     }
 }
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cName;
    private javax.swing.JTextField fRequired;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField p;
    private javax.swing.JTextField pe;
    private javax.swing.JTextField tModel;
    private javax.swing.JTextField timestamp;
    private javax.swing.JTextField vDetails;
    // End of variables declaration//GEN-END:variables
}
