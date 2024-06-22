package org.example;

import org.example.Controller.LoginController;
import org.example.View.LoginView;

public class Login {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        new LoginController(view);
    }
}
