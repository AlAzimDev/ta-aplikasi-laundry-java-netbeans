package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Laundry {
    public static Integer statusForm = 0;
    public void submit(String usernamePelaundry, String id_jenislaundry, String handphone, String alamat, String id_penyedia){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from users where username='"+usernamePelaundry+"' AND handphone='"+handphone+"'");
            
            if(rs.next()){
                String rg = "INSERT INTO laundry(alamat, id_user, id_penyedia, id_jenislaundry, status) "
                    + "VALUE ('"
                    +alamat+"','"
                    +rs.getString("id_user")+"','"
                    +id_penyedia+"','"
                    +id_jenislaundry+"','0')";
                System.out.println(rs.getString("id_user"));
                if(!st.execute(rg)){
                    JOptionPane.showMessageDialog(null, "Form sudah dikirimkan silahkan lihat notifikasi anda!");
                }else{
                    JOptionPane.showMessageDialog(null, "Masukkan form dengan benar");
                }
                statusForm = 1;
            }
        }catch(Exception e){
            statusForm = 0;
            JOptionPane.showMessageDialog(null, "Maaf Anda tidak memesan jasa Laundry 2 kali.");
        }
    }
    public ResultSet getLaundry(String usernamePelaundry, String handphone){
        ResultSet rs = null;
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rsu = st.executeQuery("SELECT * FROM users where username='"+usernamePelaundry+"' AND handphone='"+handphone+"'");
            if(rsu.next()){
                rs = st.executeQuery("SELECT laundry.id_laundry,laundry.id_penyedia,users.username,laundry.status "
                        +"FROM laundry LEFT JOIN users ON laundry.id_penyedia = users.id_user "
                        +"WHERE laundry.id_user='"+rsu.getString("id_user")+"' ORDER BY id_laundry DESC");
            }
        }catch(Exception e){System.out.println("Error saat pengambilan data deskripsi\t"+e);}
        return rs;
    }
    public void setStatus(String id_laundry, String status){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String ls = "UPDATE laundry SET status = '"+status+"' WHERE id_laundry='"+id_laundry+"'";
            if(!st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Notif berhasil diubah!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya ada masalah dalam proses pengubahan");
        }
    }
    public ResultSet getDataLaundry(String id_penyedia){
        ResultSet rs = null;
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            rs = st.executeQuery("SELECT laundry.id_laundry,laundry.id_user,laundry.status,laundry.alamat "
                    +"FROM laundry WHERE laundry.id_penyedia='"+id_penyedia+"' ORDER BY id_laundry DESC");
        }catch(Exception e){System.out.println("Error saat pengambilan data deskripsi\t");}
        return rs;
    }
    public void setTotalPembayaran(String id_laundry, String total_pembayaran){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String ls = "UPDATE laundry SET total_pembayaran = '"+total_pembayaran+"' WHERE id_laundry='"+id_laundry+"'";
            if(!st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Berhasil diubah!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya ada masalah dalam proses pengubahan");
        }
    }
}
