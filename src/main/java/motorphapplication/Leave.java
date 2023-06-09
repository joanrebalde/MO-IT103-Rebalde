/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package motorphapplication;

import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import payrollsystem.Employee;

/**
 *
 * @author Joan
 */
public class Leave extends javax.swing.JFrame {
    public  static  String filename="Leave.csv";
    public  static  String filename2="Employee.csv";
    DefaultTableModel csv_data;
    private JTable table;
    private TableModel model;
   
    /**
     * Creates new form Leave
     */
    public Leave() {
        initComponents();
        
        readCSV();
    }
    
     private void readCSV () {
        DefaultTableModel csv_data = new DefaultTableModel();
        try {
            int start = 0;
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename));
            org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
            for (CSVRecord csvRecord : csvParser) {
                if (start == 0) {
                    start = 1;
                    csv_data.addColumn(csvRecord.get(0));
                    csv_data.addColumn(csvRecord.get(1));
                    csv_data.addColumn(csvRecord.get(2));
                    csv_data.addColumn(csvRecord.get(3));
                    csv_data.addColumn(csvRecord.get(4));
                    
                } else {
                    Vector row = new Vector();
                    row.add(csvRecord.get(0));
                    row.add(csvRecord.get(1));
                    row.add(csvRecord.get(2));
                    row.add(csvRecord.get(3));
                    row.add(csvRecord.get(4));

                    csv_data.addRow(row);
                }
            }

        } catch (Exception ex) {
            System.out.println("Error in Parsing CSV File");
        }
        jTable1.setModel(csv_data);
    }
     
     private void computeTotal () {
         
        try {
            Scanner inputStream = new Scanner (new File(filename));
            String line = inputStream.nextLine();
            SimpleDateFormat Dformat = new SimpleDateFormat("dd/MM/yyyy");
            double total = 0;
            
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                String[] ary = line.split(",");
                String empNo = ary[0];
                String type = ary[1];
                Date from = Dformat.parse(ary[2]);
                Date to = Dformat.parse(ary[3]);
                double tdays = Double.parseDouble(ary[4]);
                
                total += tdays;
                
                System.out.println(total);
                inputStream.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leave.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Leave.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     private void filter (String query) {
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (csv_data);
         jTable1.setRowSorter(tr);
         
         tr.setRowFilter(RowFilter.regexFilter(query));
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
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LEAVE APPLICATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Employee #");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("From");

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setText("Total # of Days:");

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(242, 38, 19));
        jLabel23.setText("0");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Type of Leave");

        jComboBox3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vacation Leave", "Sick Leave", "Emergency Leave", " " }));
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox3KeyTyped(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("To");

        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        jDateChooser2.setEnabled(false);

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton4.setText("<<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton6.setText("Check Remaining Leaves");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("0");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Total");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Available");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("0");

        jButton7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(127, 127, 127))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(10, 10, 10)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(89, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private JFrame frame;
    
    private void jComboBox3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SimpleDateFormat Dformat = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<String> arrayList = new ArrayList<String>();
        String empno = jTextField2.getText();
        String datefrom = Dformat.format(jDateChooser1.getDate());
        String dateto = Dformat.format(jDateChooser2.getDate());
        String line;
        
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            while ((line=reader.readLine())!=null){
                if(line.contains(empno) && line.contains(datefrom) && line.contains(dateto)){
                    System.out.println(line);
                    continue;
                }else {
                    arrayList.add(line);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error in updating CSV file");
        }
        try {
            FileWriter writer=new FileWriter(filename);
            for (int i=0;i<arrayList.size();i++){
                writer.append( arrayList.get(i));
                writer.append("\n");

            }
            writer.close();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("done!");
        }
        readCSV();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frame = new JFrame ("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","MotorPH Employee App",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
        this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     try {
                DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
                int SelectedRows = jTable1.getSelectedRow();
                
                jTextField2.setText(RecordTable.getValueAt(SelectedRows,0).toString());
                jComboBox3.setSelectedItem((String)RecordTable.getValueAt(SelectedRows, 1));
                jDateChooser1.setDate(new SimpleDateFormat ("dd/MM/yyyy").parse((String)RecordTable.getValueAt(SelectedRows, 2)));
                jDateChooser2.setDate(new SimpleDateFormat ("dd/MM/yyyy").parse((String)RecordTable.getValueAt(SelectedRows, 3)));
                jLabel23.setText(RecordTable.getValueAt(SelectedRows,4).toString());
                
                
            } catch (ParseException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SimpleDateFormat Dformat = new SimpleDateFormat("dd/MM/yyyy");
        double totald = Double.parseDouble(jLabel23.getText());
        double totala = Double.parseDouble(jLabel8.getText());
        
        double totalaa = totala-totald;
        if (totald <= 0 || totalaa < 0 || jTextField2.getText() == null || jComboBox3.getSelectedItem() == null || jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!",
                    "MotorPH Employee Application", JOptionPane.OK_OPTION);
        } else {
            
            try {
                Date leaveend = Dformat.parse(Dformat.format(jDateChooser2.getDate()));
                Date leavestart = Dformat.parse(Dformat.format(jDateChooser1.getDate()));

                long diff = leaveend.getTime() - leavestart.getTime();
                long hours = diff / (60 * 60 * 1000);
                long days = hours / 24;

                long fdays = days + 1;

                jLabel23.setText(Long.toString(fdays));

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid input!",
                        "MotorPH Employee Application", JOptionPane.OK_OPTION);
            }
            String empno = jTextField2.getText();
            String type = (String) jComboBox3.getSelectedItem();
            String datefrom = Dformat.format(jDateChooser1.getDate());
            String dateto = Dformat.format(jDateChooser2.getDate());
            String total = jLabel23.getText();

            String[] record = new String[]{empno, type, datefrom, dateto, total};

            try {
                CSVWriter writer = new CSVWriter(new FileWriter(filename, true));
                writer.writeNext(record, false);
                writer.close();
             
                JOptionPane.showMessageDialog(null, "Leave has been filed successfully!",
                        "MotorPH Employee Application", JOptionPane.OK_OPTION);
                 readCSV();
            } catch (Exception ex) {
                System.out.println("Error in updating CSV file");
            }
           
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SimpleDateFormat Dformat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date leaveend = Dformat.parse(Dformat.format(jDateChooser2.getDate()));
            Date leavestart = Dformat.parse(Dformat.format(jDateChooser1.getDate()));

            long diff = leaveend.getTime() - leavestart.getTime();
            long hours = diff / (60 * 60 * 1000);
            long days = hours / 24;

            long fdays = days + 1;

            jLabel23.setText(Long.toString(fdays));

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid input!",
                    "MotorPH Employee Application", JOptionPane.OK_OPTION);
        }
        
        computeTotal();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        String empNo = jTextField2.getText();
        String type = (String) jComboBox3.getSelectedItem();
        
        
        //filtering steps
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(rowSorter);
        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
        
        //filtering
        filters.add(RowFilter.regexFilter(empNo));
        filters.add(RowFilter.regexFilter(type));
        RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
        rowSorter.setRowFilter(rf);
       
        
        /*TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) jTable1.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(jTextField2.getText()));

        jTable1.setRowSorter(sorter);*/

        int rowsCount = jTable1.getRowCount();
        double sum = 0;

        for (int i = 0; i < rowsCount; i++) {
            double val = Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            sum += val;
        }

        jLabel3.setText(Double.toString(sum));
        double totall = Double.parseDouble(jLabel3.getText());


        if (type.equals("Vacation Leave")) {
           if (totall<=10) {
               double totala = 10-totall;
               jLabel8.setText(Double.toString(totala));
               
               jDateChooser1.setEnabled(true);
               jDateChooser2.setEnabled(true);
           } else {
               JOptionPane.showMessageDialog(null, "You have reached the total numbers of allowed leave!",
                    "MotorPH Employee Application", JOptionPane.OK_OPTION);
               jDateChooser1.setEnabled(false);
               jDateChooser2.setEnabled(false);
           }
               
        } else if (type.equals("Sick Leave")) {
            if (totall<=5) {
               double totala = 5-totall;
               jLabel8.setText(Double.toString(totala));
               jDateChooser1.setEnabled(true);
               jDateChooser2.setEnabled(true);
           } else {
                JOptionPane.showMessageDialog(null, "You have reached the total numbers of allowed leave!",
                        "MotorPH Employee Application", JOptionPane.OK_OPTION);
                jDateChooser1.setEnabled(false);
                jDateChooser2.setEnabled(false);
           }
        } else if (type.equals("Emergency Leave")) {
            if (totall<=5) {
               double totala = 5-totall;
               jLabel8.setText(Double.toString(totala));
               jDateChooser1.setEnabled(true);
               jDateChooser2.setEnabled(true);
           } else {
                JOptionPane.showMessageDialog(null, "You have reached the total numbers of allowed leave!",
                        "MotorPH Employee Application", JOptionPane.OK_OPTION);
                jDateChooser1.setEnabled(false);
                jDateChooser2.setEnabled(false);
           }
        } 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextField2.setText(null);
        jComboBox3.setSelectedItem(null);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jLabel23.setText("0");
        jLabel8.setText("0");
        jLabel3.setText("0");
        
      
        readCSV();
        
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
