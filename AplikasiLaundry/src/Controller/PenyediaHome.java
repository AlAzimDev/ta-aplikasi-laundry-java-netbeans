package Controller;

import View.*;
import Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PenyediaHome {
    public static String menuTabbed = "";
    public static String idLaundry = "";
    private final HomePenyedia HomePenyedia;
    private final User User;
    private final Laundry Laundry;
    private final JenisLaundry JenisLaundry;
    private final Transaksi Transaksi;
    
    public static String username, email, handphone, alamat;
    public PenyediaHome(HomePenyedia HomePenyedia){
        this.HomePenyedia = HomePenyedia;
        
        this.User = new User();
        this.Laundry = new Laundry();
        this.JenisLaundry = new JenisLaundry();
        this.Transaksi = new Transaksi();
        
        setProfile();
        setTabelLaporanPembayaran();
        setTabelJenisLaundry();
        setTabelDeskripsi();
    }
    public void setProfile(){
        HomePenyedia.setUser().setText(username);
        HomePenyedia.setUsername().setText(username);
        HomePenyedia.setEmail().setText(email);
        HomePenyedia.setHandphone().setText(handphone);
        HomePenyedia.setAlamat().setText(alamat);
        HomePenyedia.username = username;
    }
    public void setTabelLaporanPembayaran(){
        HomePenyedia.modeltab1 = new DefaultTableModel();
        HomePenyedia.tabelLaporanPembayaran().setModel(HomePenyedia.modeltab1);
        HomePenyedia.modeltab1.addColumn("Metode Pembayaran");
        HomePenyedia.modeltab1.addColumn("Pembayaran");
        HomePenyedia.modeltab1.setNumRows(0);
        try{
            ResultSet home = Transaksi.getDataLaporanPembayaran();
            ResultSet user = User.getIdUser(email, handphone);
            Integer totalSemua = 0;
            user.next();
            while(home.next()){
                if(home.getString("id_penyedia").equals(user.getString("id_user"))){
                    HomePenyedia.modeltab1.addRow(new Object[]{
                        home.getString("metode_pembayaran"),"Rp."+home.getString("total_pembayaran")
                    });
                    totalSemua += home.getInt("total_pembayaran");
                }
            }
            HomePenyedia.setTotal().setText("Total Pemasukan: Rp."+totalSemua.toString());
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void setTabelJenisLaundry(){
        HomePenyedia.modeltab3 = new DefaultTableModel();
        HomePenyedia.tabelJenisLaundry().setModel(HomePenyedia.modeltab3);
        HomePenyedia.modeltab3.addColumn("id_jenislaundry");
        HomePenyedia.modeltab3.addColumn("Nama Barang");
        HomePenyedia.modeltab3.addColumn("Harga Per");
        HomePenyedia.modeltab3.addColumn("Harga");
        HomePenyedia.modeltab3.setNumRows(0);
        TableColumnModel tcm = HomePenyedia.tabelJenisLaundry().getColumnModel();
        //hide Id
        tcm.getColumn(0).setWidth(0);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(0).setMaxWidth(0);
        try{
            ResultSet home = JenisLaundry.getDataJenisLaundry();
            ResultSet user = User.getIdUser(email, handphone);
            user.next();
            while(home.next()){
                if(home.getString("id_user").equals(user.getString("id_user"))){
                    if(home.getString("harga_peritem") == null){
                        HomePenyedia.modeltab3.addRow(new Object[]{
                            home.getString("id_jenislaundry"),home.getString("barang"),"KiloGram","Rp."+home.getString("harga_perkg")
                        });
                    }else{
                        HomePenyedia.modeltab3.addRow(new Object[]{
                            home.getString("id_jenislaundry"),home.getString("barang"),"Item","Rp."+home.getString("harga_peritem")
                        });
                    }
                }
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void deleteDataJenisLaundry(String id_jenislaundry){
        JenisLaundry.fullDeleteJenisLaundy(id_jenislaundry);
    }
    public void addDataJenisLaundry(){
        String barang = HomePenyedia.nameBarang().getText();
        String harga = HomePenyedia.nameHarga().getText();
        
        Pattern HargaP = Pattern.compile("^[0-9]+$");
        Matcher hargaM = HargaP.matcher(harga);
        if(barang == null){
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong!");
        }else if(harga == null){
            JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong!");
        }else if(!hargaM.matches()){
            JOptionPane.showMessageDialog(null, "Masukkan Harga dengan benar!");
        }else{
            try {
                ResultSet user = User.getIdUser(email, handphone);
                user.next();
                if(HomePenyedia.nameHargaPer().getSelectedIndex() == 0){
                    JenisLaundry.addJenisLaundry(user.getString("id_user"), barang, harga, "NULL");
                }else{
                    JenisLaundry.addJenisLaundry(user.getString("id_user"), barang, "NULL", harga);
                }
            }catch(SQLException e){System.err.println(e.getMessage());}
        }
        HomePenyedia.nameBarang().setText("");
        HomePenyedia.nameHargaPer().setSelectedIndex(0);
        HomePenyedia.nameHarga().setText("");
    }
    public void setTabelDeskripsi(){
        HomePenyedia.modeltab2 = new DefaultTableModel();
        HomePenyedia.tabelDeskripsi().setModel(HomePenyedia.modeltab2);
        HomePenyedia.modeltab2.addColumn("id_laundry");
        HomePenyedia.modeltab2.addColumn("id_user");
        HomePenyedia.modeltab2.addColumn("status");
        HomePenyedia.modeltab2.addColumn("Judul");
        HomePenyedia.modeltab2.addColumn("Alamat");
        HomePenyedia.modeltab2.setNumRows(0);
        TableColumnModel tcm = HomePenyedia.tabelDeskripsi().getColumnModel();
        //hide Id
        tcm.getColumn(0).setWidth(0);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(0).setMaxWidth(0);
        //hide Id
        tcm.getColumn(1).setWidth(0);
        tcm.getColumn(1).setMinWidth(0);
        tcm.getColumn(1).setMaxWidth(0);
        //hide Status
        tcm.getColumn(2).setWidth(0);
        tcm.getColumn(2).setMinWidth(0);
        tcm.getColumn(2).setMaxWidth(0);
        try{
            ResultSet user = User.getIdUser(email, handphone);
            user.next();
            ResultSet home = Laundry.getDataLaundry(user.getString("id_user"));
            while(home.next()){
                String judulTabel = "";
                String alamatTabel = "";
                if(home.getString("status").equals("-1")){
                    judulTabel = "Terjadi Kesalahan!";
                    alamatTabel = "";
                }else if(home.getString("status").equals("0")){
                    judulTabel = "Jemput Pakaian Pelangganmu Sekarang, Dia Sudah Menunggumu!";
                    alamatTabel = home.getString("alamat");
                }else if(home.getString("status").equals("1")){
                    judulTabel = "Selesaikan Cucian Kamu, Pelangganmu Sudah Menunggu Lho!";
                    alamatTabel = home.getString("alamat");
                }else if(home.getString("status").equals("2")){
                    judulTabel = "Masukkan Jumlah yang Harus Dibayarkan dan Tunggu Pelangganmu Membayar!";
                    alamatTabel = home.getString("alamat");
                }
                if(!home.getString("status").equals("3")){
                    HomePenyedia.modeltab2.addRow(new Object[]{
                        home.getString("id_laundry"),home.getString("id_user"),home.getString("status"),judulTabel,alamatTabel
                    });
                }
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void getDataUserViaJOptionPane(String id_user){
        try{
            ResultSet home = User.detailPenyedia(id_user);
            while(home.next()){
                JOptionPane.showMessageDialog(null, "Nama Pengguna: "+home.getString("username")+
                        "\nEmail: "+home.getString("email")+
                        "\nHandphone: "+home.getString("handphone")+
                        "\nAlamat: "+home.getString("alamat")
                );
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void updateStatusLaundry(String id_laundy, String status){
        try{
            Laundry.setStatus(id_laundy, status);
        }catch(Exception e){}
    }
    public void openLaporanUser(String id_laundry){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            HomePenyedia.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        HomePenyedia.dispose();
        idLaundry = id_laundry;
        new View.TotalPembayaranOlehUser().setVisible(true);
    }
    public void openEditProfile(){
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            HomePenyedia.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(InterruptedException e){}
        }
        menuTabbed = "modePenyedia";
        HomePenyedia.dispose();
        new View.UserProfile().setVisible(true);
        menuTabbed = "";
    }
}
