package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Transaksi {
    public ResultSet totalPembayaran(String id_laundry){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM laundry WHERE id_laundry='"+id_laundry+"'");
            return rs;
        }catch(Exception e){
            
        }
        return null;
    }
    public void tambahkanPembayaran(String id_laundry, String metode_pembayaran, String total_pembayaran){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String rg = "INSERT INTO transaksi(id_laundry, metode_pembayaran) "
                + "VALUE ('"
                +id_laundry+"','"
                +metode_pembayaran+"')";
            if(!st.execute(rg)){
                JOptionPane.showMessageDialog(null, "Anda akan membayar sebesar Rp."+total_pembayaran);
                new Model.Laundry().setStatus(id_laundry, "3");
            }
        }catch(Exception e){}
    }
    public ResultSet getDataLaporanPembayaran(){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT laundry.id_penyedia, transaksi.metode_pembayaran, laundry.total_pembayaran FROM transaksi LEFT JOIN laundry ON transaksi.id_laundry = laundry.id_laundry ORDER BY id_transaksi DESC");
            return rs;
        }catch(Exception e){}
        return null;
    }
}
