package Controller;

import View.*;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PesanJasa {
    public static String idPenyedia = Controller.UserHome.idPenyedia;
    public static String namaPelaundry = Controller.UserHome.username;
    public static String handphonePelaundry = Controller.UserHome.handphone;
    public static String alamatPelaundry = Controller.UserHome.alamat;
    public DefaultTableModel modeltab1;
    private final PesanJasaLaundry PesanJasaLaundry;
    private final User User;
    private final JenisLaundry JenisLaundry;
    private final Laundry Laundry;
    public PesanJasa(PesanJasaLaundry PesanJasaLaundry){
        this.PesanJasaLaundry = PesanJasaLaundry;
        
        this.User = new User();
        this.JenisLaundry = new JenisLaundry();
        this.Laundry = new Laundry();
        setDefaultForm();
    }
    public void setDefaultForm(){
        PesanJasaLaundry.textField1().setText(namaPelaundry);
        PesanJasaLaundry.textField1().setEditable(false);
        PesanJasaLaundry.textField2().setText(handphonePelaundry);
        PesanJasaLaundry.textField2().setEditable(false);
        PesanJasaLaundry.textArea1().setText(alamatPelaundry);
        
        PesanJasaLaundry.comboBox1().removeAllItems();
        ResultSet rs = JenisLaundry.getJenisLaundry(idPenyedia);
        modeltab1 = new DefaultTableModel();
        modeltab1.addColumn("harga_perkg");
        modeltab1.addColumn("harga_peritem");
        modeltab1.addColumn("id_jenislaundry");
        modeltab1.setNumRows(0);
        try {
            while(rs.next()){
                PesanJasaLaundry.comboBox1().addItem(rs.getString("barang"));
                if(rs.getString("harga_perkg") == null){
                    modeltab1.addRow(new Object[]{
                        null,rs.getString("harga_peritem"),rs.getString("id_jenislaundry")
                    });
                }else{
                    modeltab1.addRow(new Object[]{
                        rs.getString("harga_perkg"),null,rs.getString("id_jenislaundry")
                    });
                }
            }
            if(modeltab1.getValueAt(0, 1) == null){
                PesanJasaLaundry.label6().setText("Rp."+modeltab1.getValueAt(0, 0).toString()+" per KG");
            }else{
                PesanJasaLaundry.label6().setText("Rp."+modeltab1.getValueAt(0, 1).toString()+" per Item");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesanJasa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectedItem(){
        if(modeltab1.getValueAt(PesanJasaLaundry.comboBox1().getSelectedIndex(), 1) == null){
            PesanJasaLaundry.label6().setText("Rp."+modeltab1.getValueAt(PesanJasaLaundry.comboBox1().getSelectedIndex(), 0).toString()+" per KG");
        }else{
            PesanJasaLaundry.label6().setText("Rp."+modeltab1.getValueAt(PesanJasaLaundry.comboBox1().getSelectedIndex(), 1).toString()+" per Item");
        }
    }
    public void sumbitForm(String id_jenislaundry, String alamat){
        Laundry.submit(PesanJasa.namaPelaundry, id_jenislaundry, PesanJasa.handphonePelaundry, alamat, PesanJasa.idPenyedia);
        PesanJasaLaundry.dispose();
    }
}
