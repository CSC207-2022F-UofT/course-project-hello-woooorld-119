package Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JTextField userId = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JLabel userIdLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    public LoginPage(){
        //this.loginInfo = loginInfo;

        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(50, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 10));

        userId.setBounds(125, 100, 200, 25);
        userPassword.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener(this);

        registerButton.setBounds(225, 200, 100, 25);
        registerButton.addActionListener(this);

        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(userId);
        frame.add(userPassword);
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginButton){
            String username = userId.getText();
            String password = String.valueOf(userPassword.getPassword());
            LoginController loginController = new LoginController(username, password);

            if (loginController.checkUser(username, password)){
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");
                frame.dispose();
                WelcomePage welcomePage = new WelcomePage();
            }
            else if (username.equals("") || password.equals("")){
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Input fields cannot be left empty. Please try again.");
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Incorrect username or password. Please try again.");
            }
        }
        else{
            frame.dispose();
            RegisterPage registerPage = new RegisterPage();
        }

    }
}
