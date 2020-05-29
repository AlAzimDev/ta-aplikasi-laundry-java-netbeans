package Controller;

import View.*;
import Model.*;

public class RatePenyedia {
    public static String idPenyedia = Controller.UserHome.idPenyedia;
    public static String namaPelaundry = Controller.UserHome.username;
    public static String handphonePelaundry = Controller.UserHome.handphone;
    private View.RatingPenyedia RatingPenyedia;
    
    private Rating Rating;
    private Laundry Laundry;
    public RatePenyedia(RatingPenyedia RatingPenyedia){
        this.RatingPenyedia = RatingPenyedia;
        
        this.Rating = new Rating();
        this.Laundry = new Laundry();
    }
    public void sumbRating(){
        String bintang = "0";
        if(RatingPenyedia.rating().getSelectedIndex() == 0){
            bintang = "1";
        }else if(RatingPenyedia.rating().getSelectedIndex() == 1){
            bintang = "2";
        }else if(RatingPenyedia.rating().getSelectedIndex() == 2){
            bintang = "3";
        }else if(RatingPenyedia.rating().getSelectedIndex() == 3){
            bintang = "4";
        }else if(RatingPenyedia.rating().getSelectedIndex() == 4){
            bintang = "5";
        }
        Rating.ratingPenyedia(bintang, idPenyedia, namaPelaundry, handphonePelaundry);
        RatingPenyedia.dispose();
    }
}
