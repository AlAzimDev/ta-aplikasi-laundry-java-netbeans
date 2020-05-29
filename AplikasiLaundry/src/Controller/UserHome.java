package Controller;

import View.*;
import Model.*;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
public class UserHome {
    public static String idPenyedia = "";
    public static String idLaundry = "";
    public static String menuTabbed = "";
    private final Home Home;
    private final User User;
    private final JenisLaundry JenisLaundry;
    private final Rating Rating;
    private final Laundry Laundry;
    private final LaporanUserM LaporanUserM;
    
    public static String username, email, handphone, alamat;
    public UserHome(Home Home){
        this.Home = Home;
        
        this.User = new User();
        this.JenisLaundry = new JenisLaundry();
        this.Rating = new Rating();
        this.Laundry = new Laundry();
        this.LaporanUserM = new LaporanUserM();
        setProfile();
        setTabelPenyedia(0,"");
        setTabelDeskripsi();
    }
    public void setProfile(){
        Home.setUser().setText(username);
        Home.setUsername().setText(username);
        Home.setEmail().setText(email);
        Home.setHandphone().setText(handphone);
        Home.setAlamat().setText(alamat);
        Home.username = username;
    }
    public void setTabelPenyedia(Integer rating, String cari){
        Home.modeltab1 = new DefaultTableModel();
        Home.tabelPenyedia().setModel(Home.modeltab1);
        Home.modeltab1.addColumn("id");
        Home.modeltab1.addColumn("Nama Laundry");
        Home.modeltab1.addColumn("Alamat");
        Home.modeltab1.addColumn("Jenis Barang Yang Dilaundry");
        Home.modeltab1.addColumn("Rating");
        Home.modeltab1.setNumRows(0);
        TableColumnModel tcm = Home.tabelPenyedia().getColumnModel();
        //hide Id
        tcm.getColumn(0).setWidth(0);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(0).setMaxWidth(0);
        //setRating
        tcm.getColumn(4).setWidth(50);
        tcm.getColumn(4).setMinWidth(50);
        tcm.getColumn(4).setMaxWidth(50);
        try{
            ResultSet home = User.getUserPenyedia(email,cari);
            while(home.next()){
                ResultSet jl = JenisLaundry.getJenisLaundry(home.getString("id_user"));
                ArrayList<String> ary = new ArrayList<String>();
                while(jl.next()){
                    ary.add(jl.getString("barang"));
                }
                ResultSet r = Rating.getAverageRatingPenyedia(home.getString("id_user"));
                r.next();
                if(r.getFloat(1) >= rating){
                    Home.modeltab1.addRow(new Object[]{
                        home.getString("id_user"),home.getString("username"),home.getString("alamat"),ary.toString(),r.getFloat(1)
                    });
                }
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void openPesanJasaForm(String id_penyedia){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        idPenyedia = id_penyedia;
        new View.PesanJasaLaundry().setVisible(true);
    }
    public void setTabelDeskripsi(){
        Home.modeltab2 = new DefaultTableModel();
        Home.tabelDeskripsi().setModel(Home.modeltab2);
        Home.modeltab2.addColumn("ID Laundry");
        Home.modeltab2.addColumn("ID Penyedia");
        Home.modeltab2.addColumn("Judul Notifikasi");
        Home.modeltab2.addColumn("Deskripsi");
        Home.modeltab2.addColumn("STATUS");
        Home.modeltab2.setNumRows(0);
        TableColumnModel tcm = Home.tabelDeskripsi().getColumnModel();
        //hide Id
        tcm.getColumn(0).setWidth(0);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(0).setMaxWidth(0);
        tcm.getColumn(1).setWidth(0);
        tcm.getColumn(1).setMinWidth(0);
        tcm.getColumn(1).setMaxWidth(0);
        tcm.getColumn(4).setWidth(0);
        tcm.getColumn(4).setMinWidth(0);
        tcm.getColumn(4).setMaxWidth(0);
        try{
            ResultSet rs = Laundry.getLaundry(username, handphone);
            while(rs.next()){
                if(rs.getInt(4) == 0){
                    Home.modeltab2.addRow(new Object[]{
                        rs.getInt(1),rs.getInt(2),
                        "Karyawan sedang menjemput pakaian Anda",
                        "Harap tunggu karyawan di alamat yang telah Anda masukkan.",
                        rs.getInt(4)
                    });
                }else if(rs.getInt(4) == 1){
                    Home.modeltab2.addRow(new Object[]{
                        rs.getInt(1),rs.getInt(2),
                        "Pakaian Anda sedang dilaundry",
                        "Harap tunggu laundry Anda.",
                        rs.getInt(4)
                    });
                }else if(rs.getInt(4) == 2){
                    Home.modeltab2.addRow(new Object[]{
                        rs.getInt(1),rs.getInt(2),
                        "Karyawan sedang mengantarkan pakaian Anda",
                        "Harap tunggu karywan di alamat yang telah Anda masukkan. Siapkan pembayaran Anda sebelum karyawan datang.",
                        rs.getInt(4)
                    });
                }else if(rs.getInt(4) == 3){
                    Home.modeltab2.addRow(new Object[]{
                        rs.getInt(1),rs.getInt(2),
                        "Rating penyedia??",
                        "Bantu penyedia menjadi top laundry didekat sini??",
                        rs.getInt(4)
                    });
                }else if(rs.getInt(4) == -1){
                    Home.modeltab2.addRow(new Object[]{
                        rs.getInt(1),rs.getInt(2),
                        "Anda telah melaporkan "+rs.getString("username"),
                        "laporan Anda akan diproses secepatnya",
                        rs.getInt(4)
                    });
                }
            }
        }catch(Exception e){System.out.println(e);}
    }
    public void openDetailPenyedia(String id_penyedia){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        idPenyedia = id_penyedia;
        new View.DetailPenyedia().setVisible(true);
    }
    public void openLaporanUser(String id_laundry){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        idLaundry = id_laundry;
        new View.LaporanUser().setVisible(true);
    }
    public void setStatusNotifikasi(String id_laundry, String status){
        Laundry.setStatus(id_laundry, status);
    }
    public void deleteNotif(String id_laundry){
        LaporanUserM.deleteNotif(id_laundry);
    }
    public void openRatePenyedia(String id_laundry, String id_penyedia){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        idLaundry = id_laundry;
        idPenyedia = id_penyedia;
        new View.RatingPenyedia().setVisible(true);
    }
    public void openPembayaran(String id_laundry){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        idLaundry = id_laundry;
        new View.Pembayaran().setVisible(true);
    }
    public void openEditProfile(){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        menuTabbed = "editProfile";
        new View.UserProfile().setVisible(true);
    }
    public void openChangeToPenyedia(){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            Home.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        Home.dispose();
        menuTabbed = "changeToPenyedia";
        new View.UserProfile().setVisible(true);
    }
}
