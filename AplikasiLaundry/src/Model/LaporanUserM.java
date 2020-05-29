package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LaporanUserM {
    public void reportPenyedia(String id_laundry, String deskripsi){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String rg = "INSERT INTO laporan_user (id_laundry,deskripsi_laporan) VALUES ('"
                    +id_laundry+"','"+deskripsi+"')";
            String ls = "UPDATE laundry SET status = '-1' WHERE id_laundry='"+id_laundry+"'";
            if(!st.execute(rg) && !st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Penyedia berhasil dilaporkan!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya Anda sudah melaporkan penyedia ini");
        }
    }
    public void deleteNotif(String id_laundry){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String ls = "UPDATE laundry SET id_user = NULL WHERE id_laundry='"+id_laundry+"'";
            if(!st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Notif berhasil dihapus!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya ada masalah dalam proses penghapusan");
        }
    }
    
    public static ResultSet getLaporan(){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryLaporan = "SELECT laporan_user.id_laporanuser, laundry.id_penyedia, laundry.id_user, laporan_user.deskripsi_laporan FROM laporan_user LEFT JOIN laundry ON laporan_user.id_laundry = laundry.id_laundry ORDER BY id_laporanuser DESC";
            ResultSet laporan = st.executeQuery(queryLaporan);
            return laporan;
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
        return null;
    }
    public void fullDeleteNotif(String id_laporanuser){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String ls = "DELETE FROM laporan_user WHERE id_laporanuser='"+id_laporanuser+"'";
            if(!st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Laporan berhasil dihapus!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya ada masalah dalam proses penghapusan");
        }
    }
}
