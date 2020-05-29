package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JenisLaundry {
    public static ResultSet getJenisLaundry(String id_penyedia){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryJL = "SELECT * FROM jenis_laundry WHERE id_user='"+id_penyedia+"'";
            ResultSet JL = st.executeQuery(queryJL);
            return JL;
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
        return null;
    }
    public static ResultSet getDataJenisLaundry(){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryJL = "SELECT * FROM jenis_laundry ORDER BY id_jenislaundry DESC";
            ResultSet JL = st.executeQuery(queryJL);
            return JL;
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
        return null;
    }
    public void fullDeleteJenisLaundy(String id_jenislaundry){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String ls = "DELETE FROM jenis_laundry WHERE id_jenislaundry='"+id_jenislaundry+"'";
            if(!st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Jenis Laundry berhasil dihapus!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya ada masalah dalam proses penghapusan");
        }
    }
    public void addJenisLaundry(String id_penyedia, String barang, String harga_perkg, String harga_peritem){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String rg = "";
            if(harga_perkg == "NULL"){
                rg = "INSERT INTO jenis_laundry(barang, harga_perkg, harga_peritem, id_user) "
                    +" VALUES ('"
                    +barang+"',NULL,'"
                    +harga_peritem+"','"
                    +id_penyedia+"')";
            }else{
                rg = "INSERT INTO jenis_laundry(barang, harga_perkg, harga_peritem, id_user) "
                    +" VALUES ('"
                    +barang+"','"
                    +harga_perkg+"',NULL,'"
                    +id_penyedia+"')";
            }
            if(!st.execute(rg)){
                JOptionPane.showMessageDialog(null, "Berhasil ditambahkan");
            }else{
                JOptionPane.showMessageDialog(null, "Gagal ditambahkan");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
