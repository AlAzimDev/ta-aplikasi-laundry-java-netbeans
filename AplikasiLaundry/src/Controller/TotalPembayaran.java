package Controller;

import View.*;
import Model.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class TotalPembayaran {
    private View.TotalPembayaranOlehUser TotalPembayaranOlehUser;
    
    private Laundry Laundry;
    public static String idLaundry = Controller.PenyediaHome.idLaundry;
    public TotalPembayaran(TotalPembayaranOlehUser TotalPembayaranOlehUser){
        this.TotalPembayaranOlehUser = TotalPembayaranOlehUser;
        
        this.Laundry = new Laundry();
    }
    public void sumbitForm(){
        Pattern totalP = Pattern.compile("^[0-9]+$");
        Matcher totalM = totalP.matcher(TotalPembayaranOlehUser.nameTotal().getText());
        if(TotalPembayaranOlehUser.nameTotal().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Masukkan Total Pembayaran terlebih dahulu!");
        }else if(!totalM.matches()){
            JOptionPane.showMessageDialog(null, "Masukkan Total Harga dengan benar!");
        }else{
            Laundry.setTotalPembayaran(idLaundry, TotalPembayaranOlehUser.nameTotal().getText());
            TotalPembayaranOlehUser.dispose();
        }
    }
}
