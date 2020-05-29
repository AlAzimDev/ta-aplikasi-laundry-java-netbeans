package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Rating {
    public static ResultSet getAverageRatingPenyedia(String id_penyedia){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            String queryR = "SELECT AVG(rating) FROM rating WHERE id_penyedia='"+id_penyedia+"'";
            ResultSet R = st.executeQuery(queryR);
            return R;
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
        return null;
    }
    public void ratingPenyedia(String bintang, String id_penyedia, String usernamePelaundry, String handphone){
        try{
            Statement st = Model.Connection.getkoneksi().createStatement();
            ResultSet rs = st.executeQuery("select * from users where username='"+usernamePelaundry+"' AND handphone='"+handphone+"'");
            
            if(rs.next()){
                String queryR = "INSERT INTO rating (rating,id_penyedia,id_user) VALUES ('"+
                        bintang+"','"+
                        id_penyedia+"','"+
                        rs.getString("id_user")+"');";
                if(!st.execute(queryR)){
                    JOptionPane.showMessageDialog(null, "Terima Kasih, jangan lupa memesan Jasa Laundry lagi di Lyoky.");
                }
            }
        } catch(Exception e){
            {System.err.println(e.getMessage());}
        }
    }
}
