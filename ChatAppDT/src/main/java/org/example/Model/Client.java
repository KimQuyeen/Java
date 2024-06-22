package org.example.Model;

import org.example.View.design.FButton;
import org.example.View.design.FTextField;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Admin
 */
public class Client extends javax.swing.JFrame {

    private Thread thread;
    private BufferedWriter os;
    private BufferedReader is;
    private Socket socketOfClient;
    private List<String> onlineList;
    private int id;

    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jTextPane1.setEditable(false);
        jTextArea2.setEditable(false);
        onlineList = new ArrayList<>();
        jTextField1.setPreferredSize(new Dimension(400, 30)); // Change width and height as desired
        jButton1.setPreferredSize(new Dimension(50, 30));
        setUpSocket();
        id = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new JPanel();
        jPanel1 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextPane1 = new JTextPane(); // Changed from JTextArea to JTextPane
        jTextField1 = new FTextField();
        jButton1 = new FButton();
        jComboBox1 = new JComboBox<>();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTabbedPane1 = new JTabbedPane(); // Added this line

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea2.setColumns(100);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh sách online", jPanel1);

        jScrollPane1.setViewportView(jTextPane1); // Changed from jTextArea1 to jTextPane1

        jButton1.setText("Gửi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn người nhận");

        jLabel2.setText("Nhập tin nhắn");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("{Người nhận}");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhắn tin", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String messageContent = jTextField1.getText();
        if(messageContent.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tin nhắn");
            return;
        }
        if(jComboBox1.getSelectedIndex()==0){
            try {
                write("send-to-global"+","+messageContent+","+this.id);//[]
                appendText("Bạn: " + messageContent + "\n", StyleConstants.ALIGN_RIGHT);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra");
            }
        }else{
            try {
                String[] parner = ((String)jComboBox1.getSelectedItem()).split(" ");
                write("send-to-person"+","+messageContent+","+this.id+","+parner[1]);
                appendText("Bạn (tới Client " + parner[1] + "): " + messageContent + "\n", StyleConstants.ALIGN_RIGHT);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra");
            }
        }
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedIndex()==0){
            jLabel3.setText("Global");
        }
        else{
            jLabel3.setText("Đang nhắn với "+jComboBox1.getSelectedItem());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void setUpSocket() {
        try {
            thread = new Thread() {
                @Override
                public void run() {
                    try {
                        // Gửi yêu cầu kết nối tới Server đang lắng nghe
                        // trên máy 'localhost' cổng 7777.
                        socketOfClient = new Socket("localhost", 7777);
                        System.out.println("Kết nối thành công!");
                        // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
                        os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
                        // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
                        is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
                        String message;
                        while (true) {
                            message = is.readLine();
                            if (message == null) {
                                break;
                            }
                            String[] messageSplit = message.split(",");// ["get-id", "number"]
                            if (messageSplit[0].equals("get-id")) {
                                setID(Integer.parseInt(messageSplit[1]));
                                setIDTitle();
                            }
                            if (messageSplit[0].equals("update-online-list")) {
                                onlineList = new ArrayList<>();
                                String online = "";
                                String[] onlineSplit = messageSplit[1].split("-");
                                for (int i = 0; i < onlineSplit.length; i++) {
                                    onlineList.add(onlineSplit[i]);
                                    online += "Client "+onlineSplit[i] + " đang online\n";
                                }
                                jTextArea2.setText(online);
                                updateCombobox();
                            }
                            if (messageSplit[0].equals("global-message")) {
                                appendText(messageSplit[1] + "\n", StyleConstants.ALIGN_LEFT);
                            }
                        }
                        os.close();
                        is.close();
                        socketOfClient.close();
                    } catch (UnknownHostException e) {
                        return;
                    } catch (IOException e) {
                        return;
                    }
                }
            };
            thread.start(); // Correctly start the thread
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void appendText(String text, int alignment) {
        StyledDocument doc = jTextPane1.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, alignment);
        try {
            doc.insertString(doc.getLength(), text, attr);
            doc.setParagraphAttributes(doc.getLength(), 1, attr, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCombobox(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Gửi tất cả");
        String idString = ""+this.id;
        for(String e : onlineList){
            if(!e.equals(idString)){
                jComboBox1.addItem("Client "+ e);
            }
        }

    }
    private void setIDTitle(){
        this.setTitle("Client "+this.id);
    }
    private void setID(int id){
        this.id = id;
    }
    private void write(String message) throws IOException{
        os.write(message);
        os.newLine();
        os.flush();
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1; // Added this line
    private JTextArea jTextArea2;
    private FTextField jTextField1;
    private JTextPane jTextPane1; // Changed from JTextArea to JTextPane
    // End of variables declaration//GEN-END:variables
}
