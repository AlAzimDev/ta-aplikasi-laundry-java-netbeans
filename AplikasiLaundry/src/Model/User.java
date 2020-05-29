package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class User{
    public int loginStatus;
    public int statusLaundry = -1;
    public void signUp(String username, String email, String handphone, String password, String alamat){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from users where email='"+email+"' OR handphone='"+handphone+"'");
            String rg = "INSERT INTO users(username, email, handphone, password, alamat, status) "
                    + "VALUE ('"
                    +username+"','"
                    +email+"','"
                    +handphone+"','"
                    +password+"','"
                    +alamat+"','"
                    +"0')";
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Email atau Nomor Handphone yang Anda masukkan sudah dipakai!");
                loginStatus = -2;
            }else{
                if(!st.execute(rg)){
                    JOptionPane.showMessageDialog(null, "Sekarang username "+username+" telah didaftarkan!!");
                    setProfile(username,email,handphone,alamat);
                    loginStatus = 0;
                } else {
                    loginStatus = -2;
                    JOptionPane.showMessageDialog(null, "Harap periksa Koneksi!");
                }
            }
        }catch(Exception e){
            loginStatus = -2;
            JOptionPane.showMessageDialog(null, "Harap periksa Koneksi!");
        }
    }
    public void Login(String email, String password){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from users where email='"+email+"' AND password='"+password+"'"
            );
            if(rs.next()){
                if(rs.getInt("status") == 2){
                    loginStatus = 2;
                }else if(rs.getInt("status") == 1){
                    loginStatus = 1;
                }else if(rs.getInt("status") == 0){
                    loginStatus = 0;
                }else{
                    loginStatus = -1;
                }
                if(rs.getInt("status") == 0){
                    setProfile(rs.getString("username"),rs.getString("email"),rs.getString("handphone"),rs.getString("alamat"));
                }else if(rs.getInt("status") == 1){
                    setProfilePenyedia(rs.getString("username"),rs.getString("email"),rs.getString("handphone"),rs.getString("alamat"));
                }else if(rs.getInt("status") == 2){
                    setProfileAdmin(rs.getString("username"),rs.getString("email"),rs.getString("handphone"),rs.getString("alamat"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Email atau Password yang anda masukkan salah!");
                loginStatus = -2;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Harap periksa Koneksi!");
        }
    }
    public static ResultSet getUserPenyedia(String userLogin, String cari){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryPenyedia = "";
            if(cari.equals(null) || cari.equals("")){
                queryPenyedia = "SELECT * FROM users WHERE NOT email='"+userLogin+"' AND status='1'";
            }else{
                queryPenyedia = "SELECT * FROM users WHERE NOT email='"+userLogin+"' AND status='1' AND (username LIKE '%"+cari+"%' OR alamat LIKE '%"+cari+"%')";
            }
            ResultSet penyedia = st.executeQuery(queryPenyedia);
            return penyedia;
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
        return null;
    }
    private void setProfile(String username, String email, String handphone, String alamat){
        Controller.UserHome.username = username;
        Controller.UserHome.email = email;
        Controller.UserHome.handphone = handphone;
        Controller.UserHome.alamat = alamat;
    }
    private void setProfileAdmin(String username, String email, String handphone, String alamat){
        Controller.AdminHome.username = username;
        Controller.AdminHome.email = email;
        Controller.AdminHome.handphone = handphone;
        Controller.AdminHome.alamat = alamat;
    }
    private void setProfilePenyedia(String username, String email, String handphone, String alamat){
        Controller.PenyediaHome.username = username;
        Controller.PenyediaHome.email = email;
        Controller.PenyediaHome.handphone = handphone;
        Controller.PenyediaHome.alamat = alamat;
    }
    public static ResultSet detailPenyedia(String id_penyedia){
        ResultSet rs = null;
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryPenyedia = "SELECT * FROM users WHERE id_user='"+id_penyedia+"'";
            rs = st.executeQuery(queryPenyedia);
        }catch(Exception e){}
        return rs;
    }
    public void editProfile(String emailLama, String handphoneLama, String username, String email, String handphone, String password, String alamat, String status){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            Statement sta = Model.Connection.getkoneksi().createStatement();
            ResultSet rse = null;
            ResultSet rsh = null;
            if(!emailLama.equals(email)){
                rse = st.executeQuery("SELECT * FROM users WHERE email='"+email+"'");
            }
            if(!handphoneLama.equals(handphone)){
                rsh = sta.executeQuery("SELECT * FROM users WHERE handphone='"+handphone+"'");
            }
            String rg = "";
            if(password.equals("")){
                rg = "UPDATE users SET username='"+username+
                        "', email='"+email+
                        "', handphone='"+handphone+
                        "', alamat='"+alamat+
                        "', status='"+status+
                        "' WHERE email='"+emailLama+"'";
            }else{
                rg = "UPDATE users SET username='"+username+
                        "', email='"+email+
                        "', handphone='"+handphone+
                        "', password='"+password+
                        "', alamat='"+alamat+
                        "', status='"+status+
                        "' WHERE email='"+emailLama+"'";
            }
            if(rse != null && rse.next()){
                JOptionPane.showMessageDialog(null, "Email yang Anda masukkan sudah dipakai!");
            }else if(rsh != null && rsh.next()){
                JOptionPane.showMessageDialog(null, "Nomor Handphone yang Anda masukkan sudah dipakai!");
            }else{
                if(!st.execute(rg)){
                    JOptionPane.showMessageDialog(null, "Berhasil diubah!");
                    setProfile(username,email,handphone,alamat);
                } else {
                    JOptionPane.showMessageDialog(null, "Harap periksa Koneksi!");
                }
            }
        }catch(Exception e){}
    }
    public void cekLaundry(String emailLama, String handphoneLama){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rse = st.executeQuery("SELECT * FROM users WHERE email='"+emailLama+"' AND handphone='"+handphoneLama+"'");
            if(rse.next()){
                ResultSet rsr = st.executeQuery("SELECT * FROM laundry WHERE id_user='"+rse.getString("id_user")+"'");
                if(rsr.next()){
                    statusLaundry = 1;
                }else{
                    statusLaundry = 0;
                }
            }
        }catch(Exception e){}
    }
    public static ResultSet getPengguna(String cari){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryPengguna = "";
            if(cari.equals(null) || cari.equals("")){
                queryPengguna = "SELECT * FROM users WHERE NOT status='2'";
            }else{
                queryPengguna = "SELECT * FROM users WHERE NOT status='2' AND (username LIKE '%"+cari+"%' OR alamat LIKE '%"+cari+"%' OR email LIKE '%"+cari+"%' OR handphone LIKE '%"+cari+"%')";
            }
            ResultSet penyedia = st.executeQuery(queryPengguna);
            return penyedia;
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
        return null;
    }
    public void setStatus(String id_user, String status){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String ls = "UPDATE users SET status = '"+status+"' WHERE id_user='"+id_user+"'";
            if(!st.execute(ls)){
                JOptionPane.showMessageDialog(null, "Status berhasil diubah!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tampaknya ada masalah dalam proses pengubahan");
        }
    }
    public ResultSet getIdUser(String email, String handphone){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE email='"+email+"' AND handphone='"+handphone+"'");
            return rs;
        }catch(Exception e){}
        return null;
    }
}
