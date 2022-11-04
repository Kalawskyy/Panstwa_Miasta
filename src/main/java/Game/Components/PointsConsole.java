package Game.Components;

import java.sql.SQLOutput;

public class PointsConsole {
    private int punkty;
    private boolean showStatus;
    PointsConsole(){
        showStatus=false;
        punkty=0;
    }
    void addPoints(){
        if(showStatus==true){
            System.out.println("You get point");
        }
    }
    void losePoints(){
        if(showStatus==true){
            System.out.println("You lose all points");
        }
    }
     void getPoints(int punkty1){
        punkty=punkty1;
         System.out.println("Punkty : "+punkty);
     }
     void consoleStatusSwich(Boolean status){
       showStatus=status;
     }
}
