package Controller;

import View.*;
import Model.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class ChangeToPenyedia {
    
    private View.UserProfile UserProfile;
    
    private User User;
    public ChangeToPenyedia(UserProfile UserProfile){
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
            User.cekLaundry(Controller.UserHome.email, Controller.UserHome.handphone);
            if(User.statusLaundry == 0){
                User.editProfile(Controller.UserHome.email, Controller.UserHome.handphone, username, email, handphone, password, alamat, "1");
                UserProfile.dispose();
            }else if(User.statusLaundry == 1){
                JOptionPane.showMessageDialog(null, "Kosongkan Deskripsi untuk gabung menjadi Penyedia");
                UserProfile.dispose();
            }
        }
    }
    public void setProfileLama(){
        UserProfile.judul().setText("Lamar Sebagai Penyedia");
        UserProfile.usernameNamaPenyedia().setText("Nama Penyedia");
        UserProfile.action().setText("Lamar");
        UserProfile.username().setText(Controller.UserHome.username);
        UserProfile.email().setText(Controller.UserHome.email);
        UserProfile.handphone().setText(Controller.UserHome.handphone);
        UserProfile.alamat().setText(Controller.UserHome.alamat);
    }
}
