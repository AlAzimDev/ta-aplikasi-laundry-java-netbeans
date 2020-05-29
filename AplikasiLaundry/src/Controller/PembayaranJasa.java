package Controller;

import View.*;
import Model.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PembayaranJasa {
    
    private Pembayaran Pembayaran;
    
    private Transaksi Transaksi;
    public static String idLaundry = Controller.UserHome.idLaundry;
    public PembayaranJasa(Pembayaran Pembayaran){
        this.Pembayaran = Pembayaran;
        
        this.Transaksi = new Transaksi();
    }
    public void cekTotalPembayaran(){
        try{
            ResultSet rs = Transaksi.totalPembayaran(idLaundry);
            if(rs.next()){
                if(rs.getString("total_pembayaran") == null){
                    JOptionPane.showMessageDialog(null, "Harap tunggu, tampaknya penyedia belum memasukkan harga.");
                    Pembayaran.dispose();
                }else{
                    String metode = "";
                    if(Pembayaran.metode_pembayaran().getSelectedIndex() == 0){
                        metode = "dana";
                    }else if(Pembayaran.metode_pembayaran().getSelectedIndex() == 1){
                        metode = "gopay";
                    }else if(Pembayaran.metode_pembayaran().getSelectedIndex() == 2){
                        metode = "ovo";
                    }
                    bayar(rs.getString("total_pembayaran"), metode);
                }
            }
        }catch(Exception e){
        }
    }
    public void bayar(String total_pembayaran, String metode_pembayaran){
        Transaksi.tambahkanPembayaran(idLaundry, metode_pembayaran, total_pembayaran);
        Pembayaran.dispose();
    }
}
