package org.example.View;

import org.example.Dao.ClientDao;
import org.example.View.design.FButton;
import org.example.View.design.FPasswordField;
import org.example.View.design.FTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {

    FTextField temail, tusername, tphone;
    FPasswordField tpassword, tconfigpassword;
    FButton showPassword1, showPassword2, signup, back;

     SignUp(){

         ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("img/user-plus.png"));
         Image i22 = i11.getImage().getScaledInstance(64, 64, Image.SCALE_FAST);
         ImageIcon i33 = new ImageIcon(i22);
         JLabel imgg = new JLabel(i33);
         imgg.setBounds(160, 5, 64, 64);
         add(imgg);

         JLabel sign_up = new JLabel("Sign Up");
         sign_up.setFont(new Font("Raleway", Font.BOLD, 25));
         sign_up.setForeground(Color.BLACK);
         sign_up.setBounds(160, 70, 250, 50);
         add(sign_up);

         JLabel email = new JLabel("Email");
         email.setFont(new Font("Raleway", Font.BOLD, 15));
         email.setForeground(Color.BLACK);
         email.setBounds(40, 120, 250, 40);
         add(email);

         temail = new FTextField();
         temail.setBounds(40, 160, 300, 40);
         add(temail);

         JLabel phone = new JLabel("Phone");
         phone.setFont(new Font("Raleway", Font.BOLD, 15));
         phone.setForeground(Color.BLACK);
         phone.setBounds(40, 200, 250, 40);
         add(phone);

         tphone = new FTextField();
         tphone.setBounds(40, 240, 300, 40);
         add(tphone);


         JLabel username = new JLabel("Name");
         username.setFont(new Font("Raleway", Font.BOLD, 15));
         username.setForeground(Color.BLACK);
         username.setBounds(40, 280, 250, 40);
         add(username);

         tusername = new FTextField();
         tusername.setBounds(40, 320, 300, 40);
         add(tusername);

         JLabel password = new JLabel("Password");
         password.setFont(new Font("Raleway", Font.BOLD, 15));
         password.setForeground(Color.BLACK);
         password.setBounds(40, 360, 250, 40);
         add(password);

         tpassword = new FPasswordField();
         tpassword.setBounds(40, 400, 240, 40);
         add(tpassword);

         showPassword1 = new FButton();
         showPassword1.setBounds(280, 400, 60, 40);
         add(showPassword1);

         ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/eye.png"));
         Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
         ImageIcon scaledIcon = new ImageIcon(img);
         showPassword1.setIcon(scaledIcon);
         showPassword1.addActionListener(this);

         JLabel passwordconfig = new JLabel("Config Password");
         passwordconfig.setFont(new Font("Raleway", Font.BOLD, 15));
         passwordconfig.setForeground(Color.BLACK);
         passwordconfig.setBounds(40, 440, 250, 40);
         add(passwordconfig);

         tconfigpassword = new FPasswordField();
         tconfigpassword.setBounds(40, 480, 240, 40);
         add(tconfigpassword);


         showPassword2 = new FButton();
         showPassword2.setBounds(280, 480, 60, 40);
         add(showPassword2);

         ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("img/eye.png"));
         Image img1 = ic.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
         ImageIcon scaledIconn = new ImageIcon(img1);
         showPassword2.setIcon(scaledIconn);
         showPassword2.addActionListener(this);

         signup = new FButton();
         signup.setBounds(40, 540, 300, 45);
         signup.setText("SIGN UP");
         signup.addActionListener(this);
         add(signup);

         back = new FButton();
         back.setBounds(40, 610, 300, 45);
         back.setText("BACK");
         back.addActionListener(this);
         add(back);

         setSize(400, 700);
         setLocationRelativeTo(null);
         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }


    public static void main(String[] args) {
        new SignUp();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==showPassword1)
        {
            if (tpassword.getEchoChar()==(char)0) { // Password is hidden
                tpassword.setEchoChar('\u25cf'); // Show password

            } else { // Password is visible
                tpassword.setEchoChar((char) 0); // Hide password
            }
        }
        else if(e.getSource()==showPassword2)
        {
            if (tconfigpassword.getEchoChar() == (char)0) { // Password is hidden
                tconfigpassword.setEchoChar('\u25cf'); // Hide password

            } else { // Password is visible
                tconfigpassword.setEchoChar((char) 0); // Hide password

            }
        } else if (e.getSource()==back) {
            setVisible(false);
        }
        else if (e.getSource() == signup) {
            // Gather data from the fields
            String email = temail.getText();
            String username = tusername.getText();
            String phone = tphone.getText();
            String password = new String(tpassword.getPassword());
            String configPassword = new String(tconfigpassword.getPassword());

            // Validate the input data (optional but recommended)
            if (!password.equals(configPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new Client object with the gathered data
            org.example.Entity.Client client = new org.example.Entity.Client(email, phone, username, password);

            // Call the saveClient method from ClientDao
            ClientDao clientDao = new ClientDao();
            boolean success = clientDao.saveClient(client);

            if (success) {
                JOptionPane.showMessageDialog(this, "Sign Up Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Optionally, you can redirect the user to another screen or close the current screen
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Sign Up Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
