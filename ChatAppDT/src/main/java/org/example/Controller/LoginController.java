package org.example.Controller;

import org.example.View.LoginView;

import org.example.Dao.ClientDao;
import org.example.Model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginController {

    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        loginView.addButtonClickListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginView.getLogin()) {
                    try {
                        ClientDao clientDao = new ClientDao();
                        String username = loginView.getTusername().getText();
                        String password = new String(loginView.getTpassword().getPassword());
                        List<org.example.Entity.Client> clientList = clientDao.getAllClients();
                        boolean check = false;
                        for (org.example.Entity.Client client : clientList) {
                            if (client.getUsername().equals(username) && client.getPassword().equals(password)) {
                                new org.example.Model.Client(); // Create and show Client frame
                                check = true;
                                loginView.dispose(); // Close the login frame
                                break;
                            }
                        }
                        if (!check) {
                            JOptionPane.showMessageDialog(loginView, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        loginView.setVisible(true);
    }
}
