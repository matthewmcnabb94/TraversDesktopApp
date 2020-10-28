
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matth
 */
public class ViewOrders extends javax.swing.JFrame {

    DefaultTableModel model;
    
    String usersD = System.getProperty("user.home");

    /**
     * Creates new form ViewOrders
     */
    public ViewOrders() {
        initComponents();
        addRowToJTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        textField = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orders Database");
        setBackground(new java.awt.Color(102, 102, 255));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Customer Name", "Date due", "Vehicle Details", "Turbo Part Number", "Price", "Payment", "Fitting Required", "Order Started Date", "Order Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        textField.setText("Filter");
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Clear Filter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Export data to CSV");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        String text = filterText.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.out.println("Bad regex pattern");
            }
        }
    }//GEN-LAST:event_textFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        filterText.setText("");
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        String text = filterText.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.out.println("Bad regex pattern");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        String userd = System.getProperty("user.home");
        
        if(exportToCSV(userd+"\\Desktop\\car\\OrdersTable\\OrderData.csv"))
        {
            System.out.println("Success");
            JOptionPane.showMessageDialog(null, "Exported successfully to loation: "+userd+"\\Desktop\\car\\OrdersTable\\OrderData.csv");
        }
        else
        {
            System.out.println("false");
            JOptionPane.showMessageDialog(null, "Error exporting, try again.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean exportToCSV(String pathToExportTo) {

        try {

            TableModel model = table.getModel();
            FileWriter csv = new FileWriter(new File(pathToExportTo));
            
            

            for (int i = 0; i < model.getColumnCount(); i++) {
                csv.write(model.getColumnName(i) + ",");
            }

            csv.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    csv.write(model.getValueAt(i, j).toString() + ",");
                }
                csv.write("\n");
            }

            csv.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void listAllInformation() {
        try {

            String hostName = "3.16.15.26";
            int port = 80;

            Socket kkSocket = new Socket(hostName, port);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);

            System.out.println("Listing all information");
            out.println("LISTALL,");
            out.flush();

            ObjectInputStream object = new ObjectInputStream(kkSocket.getInputStream());
            Object obj = object.readObject();
            ArrayList<String[]> data = new ArrayList<>();
            data = (ArrayList<String[]>) obj;
            System.out.println("The result set is " + data.size());

            int row = 0;

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

                table.setValueAt((Id), row, 0);
                table.setValueAt((customerName), row, 1);
                table.setValueAt((date), row, 2);
                table.setValueAt((vehicleDetails), row, 3);
                table.setValueAt((turboPartNumber), row, 4);
                table.setValueAt((price), row, 5);
                table.setValueAt((payment), row, 6);
                table.setValueAt((fittingRequired), row, 7);
                table.setValueAt((orderStartedDate), row, 8);
                table.setValueAt((orderStatus), row, 9);

                row++;
            }

            System.out.print("Total Rows are : " + row);

        } catch (Exception e) {

// TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());

            e.printStackTrace();

        }
    }

    public void addRowToJTable() {
        model = (DefaultTableModel) table.getModel();
        ArrayList<Order> list = ListOrders();
        Object rowData[] = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).id;
            rowData[1] = list.get(i).customerName;
            rowData[2] = list.get(i).date;
            rowData[3] = list.get(i).vehicleDetails;
            rowData[4] = list.get(i).turboPartNumber;
            rowData[5] = list.get(i).price;
            rowData[6] = list.get(i).payment;
            rowData[7] = list.get(i).fittingRequired;
            rowData[8] = list.get(i).orderStartedDate;
            rowData[9] = list.get(i).orderStatus;
            model.addRow(rowData);
        }

    }

    // create a list of users
    public ArrayList ListOrders() {
        ArrayList<Order> list = new ArrayList<Order>();
        try {

            String hostName = "3.16.15.26";
            int port = 80;

            Socket kkSocket = new Socket(hostName, port);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);

            System.out.println("Listing all information");
            out.println("LISTALL,");
            out.flush();

            ObjectInputStream object = new ObjectInputStream(kkSocket.getInputStream());
            Object obj = object.readObject();
            ArrayList<String[]> data = new ArrayList<>();
            data = (ArrayList<String[]>) obj;
            System.out.println("The result set is " + data.size());

            int row = 0;

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

                Order order = new Order(Id, customerName, date, vehicleDetails, turboPartNumber, price, payment, fittingRequired, orderStartedDate, orderStatus);
                list.add(order);
                

                row++;
            }

        } catch (Exception e) {

// TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());

            e.printStackTrace();

        }

        return list;
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
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JButton textField;
    // End of variables declaration//GEN-END:variables
}
