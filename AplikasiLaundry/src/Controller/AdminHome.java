package Controller;

import View.*;
import Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdminHome {
    public static String idPenyedia = "";
    public static String idLaundry = "";
    private final HomeAdmin HomeAdmin;
    private final User User;
    private final Laundry Laundry;
    private final LaporanUserM LaporanUserM;
    
    public static String username, email, handphone, alamat;
    public AdminHome(HomeAdmin HomeAdmin){
        this.HomeAdmin = HomeAdmin;
        
        this.User = new User();
        this.Laundry = new Laundry();
        this.LaporanUserM = new LaporanUserM();
        setProfile();
        setTabelPengguna(0, "");
        setTabelLaporan();
    }
    public void setProfile(){
        HomeAdmin.setUser().setText(username);
        HomeAdmin.username = username;
    }
    public void setTabelPengguna(Integer CBstatus, String cari){
        HomeAdmin.modeltab1 = new DefaultTableModel();
        HomeAdmin.tabelPengguna().setModel(HomeAdmin.modeltab1);
        HomeAdmin.modeltab1.addColumn("id_user");
        HomeAdmin.modeltab1.addColumn("Username");
        HomeAdmin.modeltab1.addColumn("Email");
        HomeAdmin.modeltab1.addColumn("Handphone");
        HomeAdmin.modeltab1.addColumn("Alamat");
        HomeAdmin.modeltab1.addColumn("Status");
        HomeAdmin.modeltab1.setNumRows(0);
        TableColumnModel tcm = HomeAdmin.tabelPengguna().getColumnModel();
        //hide Id
        tcm.getColumn(0).setWidth(0);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(0).setMaxWidth(0);
        try{
            ResultSet home = User.getPengguna(cari);
            while(home.next()){
                String status = "";
                if(home.getString("status").equals("-1")){
                    status = "'Blocked'";
                }else if(home.getString("status").equals("0")){
                    status = "'Pengguna'";
                }else if(home.getString("status").equals("1")){
                    status = "'Penyedia'";
                }
                if(CBstatus == 1 && home.getString("status").equals("0")){
                    HomeAdmin.modeltab1.addRow(new Object[]{
                        home.getString("id_user"),home.getString("username"),home.getString("email"),home.getString("handphone"),home.getString("alamat"),status
                    });
                }else if(CBstatus == 2 && home.getString("status").equals("1")){
                    HomeAdmin.modeltab1.addRow(new Object[]{
                        home.getString("id_user"),home.getString("username"),home.getString("email"),home.getString("handphone"),home.getString("alamat"),status
                    });
                }else if(CBstatus == 3 && home.getString("status").equals("-1")){
                    HomeAdmin.modeltab1.addRow(new Object[]{
                        home.getString("id_user"),home.getString("username"),home.getString("email"),home.getString("handphone"),home.getString("alamat"),status
                    });
                }else if(CBstatus == 0){
                    HomeAdmin.modeltab1.addRow(new Object[]{
                        home.getString("id_user"),home.getString("username"),home.getString("email"),home.getString("handphone"),home.getString("alamat"),status
                    });
                }
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void setStatus(String id_user, String status){
        User.setStatus(id_user, status);
    }
    public void setTabelLaporan(){
        HomeAdmin.modeltab2 = new DefaultTableModel();
        HomeAdmin.tabelLaporan().setModel(HomeAdmin.modeltab2);
        HomeAdmin.modeltab2.addColumn("id_laporanuser");
        HomeAdmin.modeltab2.addColumn("id_penyedia");
        HomeAdmin.modeltab2.addColumn("id_user");
        HomeAdmin.modeltab2.addColumn("Deskripsi Laporan");
        HomeAdmin.modeltab2.setNumRows(0);
        TableColumnModel tcm = HomeAdmin.tabelLaporan().getColumnModel();
        //hide Id
        tcm.getColumn(0).setWidth(0);
        tcm.getColumn(0).setMinWidth(0);
        tcm.getColumn(0).setMaxWidth(0);
        //
        tcm.getColumn(1).setWidth(0);
        tcm.getColumn(1).setMinWidth(0);
        tcm.getColumn(1).setMaxWidth(0);
        //
        tcm.getColumn(2).setWidth(0);
        tcm.getColumn(2).setMinWidth(0);
        tcm.getColumn(2).setMaxWidth(0);
        try{
            ResultSet home = LaporanUserM.getLaporan();
            while(home.next()){
                HomeAdmin.modeltab2.addRow(new Object[]{
                    home.getInt(1), home.getInt(2), home.getInt(3), home.getString("deskripsi_laporan")
                });
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void getDataUserViaJOptionPane(String id_user){
        if(Integer.parseInt(id_user) < 1){
            JOptionPane.showMessageDialog(null, "Tampaknya Pengguna telah mengkosongkan laporan ini");
        }
        try{
            ResultSet home = User.detailPenyedia(id_user);
            while(home.next()){
                if(home.getString("status") == "0"){
                    JOptionPane.showMessageDialog(null, "Nama Pengguna: "+home.getString("username")+
                            "\nEmail: "+home.getString("email")+
                            "\nHandphone: "+home.getString("handphone")+
                            "\nAlamat: "+home.getString("alamat")
                    );
                }else{
                    JOptionPane.showMessageDialog(null, "Nama Laundry: "+home.getString("username")+
                            "\nEmail: "+home.getString("email")+
                            "\nHandphone: "+home.getString("handphone")+
                            "\nAlamat: "+home.getString("alamat")
                    );
                }
            }
        }catch(SQLException e){System.err.println(e.getMessage());}
    }
    public void deleteLaporan(String id_laporan){
        LaporanUserM.fullDeleteNotif(id_laporan);
    }
}
