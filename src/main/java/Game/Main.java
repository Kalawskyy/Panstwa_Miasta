package Game;
import Game.Components.Game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
try{
    SwingUtilities.invokeLater(Game::new);
}catch (Exception e){

}
    }
}
