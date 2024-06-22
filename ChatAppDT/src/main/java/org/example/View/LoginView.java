package org.example.View;

import org.example.View.design.FButton;
import org.example.View.design.FPasswordField;
import org.example.View.design.FTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {

    FTextField tusername;
    FPasswordField tpassword;
    FButton login;
    FButton signup;
    FButton showPassword;

    public LoginView() {
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("img/user.png"));
        Image i22 = i11.getImage().getScaledInstance(64, 64, Image.SCALE_FAST);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(160, 5, 64, 64);
        add(imgg);

        JLabel Login = new JLabel("Login");
        Login.setFont(new Font("Raleway", Font.BOLD, 25));
        Login.setForeground(Color.BLACK);
        Login.setBounds(160, 70, 250, 50);
        add(Login);

        JLabel username = new JLabel("Username");
        username.setFont(new Font("Raleway", Font.BOLD, 13));
        username.setForeground(Color.BLACK);
        username.setBounds(40, 110, 80, 30);
        add(username);

        tusername = new FTextField();
        tusername.setBounds(40, 150, 300, 40);
        add(tusername);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Raleway", Font.BOLD, 13));
        password.setForeground(Color.BLACK);
        password.setBounds(40, 190, 80, 30);
        add(password);

        tpassword = new FPasswordField();
        tpassword.setBounds(40, 230, 240, 45);
        add(tpassword);

        showPassword = new FButton();
        showPassword.setBounds(280, 230, 60, 45);
        add(showPassword);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/eye.png"));
        Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        showPassword.setIcon(scaledIcon);
        showPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setShowPasswordMouseClick(e);
            }
        });
        login = new FButton();
        login.setBounds(40, 290, 300, 45);
        login.setText("LOGIN");

        add(login);

        JLabel text = new JLabel("You don't have an account?");
        text.setFont(new Font("Raleway",Font.CENTER_BASELINE, 12));
        text.setForeground(Color.gray);
        text.setBounds(110, 340, 200, 30);
        add(text);

        signup = new FButton();
        signup.setBounds(40, 370, 300, 45);
        signup.setText("Sign Up Now");
        add(signup);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignUp();
            }
        });

        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addButtonClickListener(ActionListener listener) {
        login.addActionListener(listener);

    }

    public FTextField getTusername() {
        return tusername;
    }

    public void setTusername(FTextField tusername) {
        this.tusername = tusername;
    }

    public FPasswordField getTpassword() {
        return tpassword;
    }

    public void setTpassword(FPasswordField tpassword) {
        this.tpassword = tpassword;
    }

    public FButton getLogin() {
        return login;
    }

    public void setLogin(FButton login) {
        this.login = login;
    }

    public FButton getSignup() {
        return signup;
    }

    public void setSignup(FButton signup) {
        this.signup = signup;
    }

    public FButton getShowPassword() {
        return showPassword;
    }

    public void setShowPassword(FButton showPassword) {
        this.showPassword = showPassword;
    }

    private void setShowPasswordMouseClick(MouseEvent event) {
        if (tpassword.getEchoChar() ==(char) 0) { // Password is hidden
            tpassword.setEchoChar('\u25cf'); // Hide password
        } else { // Password is visible
            tpassword.setEchoChar((char) 0); // Show password
        }
    }
}
