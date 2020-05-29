package Controller;

import View.*;
import Model.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class EditProfile {
    
    private View.UserProfile UserProfile;
    
    private User User;
    
    public EditProfile(UserProfile UserProfile){
        this.UserProfile = UserProfile;
        
        this.User = new User();
        
        setProfileLama();
    }
    public void sumbAction(String username, String email, String handphone, String alamat, String password, String confirmPassword){
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
        }else if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "Password Tidak Sama");
        }else{
            if(Controller.PenyediaHome.email == null && UserProfile.mode == ""){
                User.editProfile(Controller.UserHome.email, Controller.UserHome.handphone, username, email, handphone, password, alamat, "0");
            }else{
                User.editProfile(Controller.PenyediaHome.email, Controller.PenyediaHome.handphone, username, email, handphone, password, alamat, "1");
            }
            UserProfile.dispose();
        }
    }
    public void setProfileLama(){
        UserProfile.judul().setText("Edit Profile");
        UserProfile.usernameNamaPenyedia().setText("Username");
        UserProfile.action().setText("Update");
        if(UserProfile.mode == ""){
            UserProfile.username().setText(Controller.UserHome.username);
            UserProfile.email().setText(Controller.UserHome.email);
            UserProfile.handphone().setText(Controller.UserHome.handphone);
            UserProfile.alamat().setText(Controller.UserHome.alamat);
        }else{
            UserProfile.username().setText(Controller.PenyediaHome.username);
            UserProfile.email().setText(Controller.PenyediaHome.email);
            UserProfile.handphone().setText(Controller.PenyediaHome.handphone);
            UserProfile.alamat().setText(Controller.PenyediaHome.alamat);
        }
    }
}
