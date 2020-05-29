package Controller;

import View.*;
import Model.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Main {
    private LoginSignUp LoginSignUp;
    private Home Home;
    private User User;
    
    public static String emailUserLogin;
    public Main(LoginSignUp LoginSignUp){
        this.LoginSignUp = LoginSignUp;
        
        this.User = new User();
    }
    public static void main(String[] args) {
        try{
            new View.LoginSignUp().setVisible(true);
        }
        catch(Exception e){}
    }
    public void SignUp(String username, String email, String handphone, String password, String alamat){
        Pattern emailP = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher emailM = emailP.matcher(email);
        
        Pattern handphoneP = Pattern.compile("^[0-9]+$");
        Matcher handphoneM = handphoneP.matcher(handphone);
        if(username.isEmpty()){
            JOptionPane.showMessageDialog(null, "Username Kosong");
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(null, "Email Kosong");
        }else if(!emailM.matches()){
            JOptionPane.showMessageDialog(null, "Masukkan Email dengan benar");
        }else if(handphone.isEmpty()){
            JOptionPane.showMessageDialog(null, "No Handphone Kosong");
        }else if(!handphoneM.matches()){
            JOptionPane.showMessageDialog(null, "Masukkan No Handphone dengan benar");
        }else if(alamat.isEmpty()){
            JOptionPane.showMessageDialog(null, "Alamat Kosong");
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Password Kosong");
        }else{
            User.signUp(username, email, handphone, password, alamat);
            if(User.loginStatus == 0){
                new View.Home().setVisible(true);
                LoginSignUp.dispose();
            }else{
                System.out.println("Gagal menampilkan halaman User karna ada masalah");
            }
        }
    }
    public void Login(String email, String password){
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(null, "Email Kosong");
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Password Kosong");
        }else{
            User.Login(email, password);
            if(User.loginStatus == 2){
                new View.HomeAdmin().setVisible(true);
                LoginSignUp.dispose();
            }else if(User.loginStatus == 1){
                new View.HomePenyedia().setVisible(true);
                LoginSignUp.dispose();
            }else if(User.loginStatus == 0){
                new View.Home().setVisible(true);
                LoginSignUp.dispose();
            }else if(User.loginStatus == -1){
                JOptionPane.showMessageDialog(null, "Blocked");
                LoginSignUp.dispose();
            }
        }
    }
}
