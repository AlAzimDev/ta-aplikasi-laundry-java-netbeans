package Controller;

import View.*;
import Model.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DetailPenyediaC {
    private DetailPenyedia DetailPenyedia;
    
    private User User;
    public static String idPenyedia = Controller.UserHome.idPenyedia;
    public DetailPenyediaC(DetailPenyedia DetailPenyedia){
        this.DetailPenyedia = DetailPenyedia;
        
        this.User = new User();
        getDetailPenyedia(idPenyedia);
    }
    public void getDetailPenyedia(String id_penyedia){
        try{
            ResultSet rs = User.detailPenyedia(id_penyedia);
            if(rs.next()){
                DetailPenyedia.username().setText(rs.getString("username").toString());
                DetailPenyedia.handphone().setText(rs.getString("handphone").toString());
                DetailPenyedia.email().setText(rs.getString("email").toString());
                DetailPenyedia.alamat().setText(rs.getString("alamat").toString());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Maaf ada masalah dalam pengambilan Data Penyedia!");
        }
    }
}
