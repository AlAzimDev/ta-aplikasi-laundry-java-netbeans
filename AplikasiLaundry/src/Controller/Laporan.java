package Controller;

import View.*;
import Model.*;
import javax.swing.JOptionPane;

public class Laporan {
    private View.LaporanUser LaporanUser;
    
    private LaporanUserM LaporanUserM;
    public static String idLaundry = Controller.UserHome.idLaundry;
    public Laporan(LaporanUser LaporanUser){
        this.LaporanUser = LaporanUser;
        
        this.LaporanUserM = new LaporanUserM();
    }
    public void sumbitForm(){
        if(LaporanUser.deskripsi().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Masukkan deskripsi terlebih dahulu!");
        }else{
            LaporanUserM.reportPenyedia(idLaundry, LaporanUser.deskripsi().getText());
        }
        LaporanUser.dispose();
    }
}
