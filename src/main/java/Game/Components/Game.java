package Game.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private String city="",country="";

    private JLabel countryCurent,cityCurent;

    private Dimension label=new Dimension(70,50);
    private String cityAndCountry [][]=new String[10][2];
    private JMenuBar menuBar;
    JMenu menuCuntry = new JMenu("Kraj");
    JMenu cityMenu = new JMenu("Stolica");

    public Game(){
        this.setTitle("Państwa-Miasta");
        this.setBounds(700,200,500,300);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        addComponents();
        setVisible(true);
        this.setLayout(null);
    }
    private void addComponents(){
         menuBar = new JMenuBar();
        menuBar.add(setings());
        menuBar.add(menuCuntry);
        menuBar.add(cityMenu);
        this.setJMenuBar(menuBar);
            menuBar.setVisible(true);
        JPanel panel = new JPanel(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.GRAY);
                countryCurent = new JLabel(country);
                countryCurent.setLocation(200,30);
                countryCurent.setSize(label);
                panel.add(countryCurent);
                cityCurent = new JLabel(city);
                cityCurent.setLocation(300,30);
                cityCurent.setSize(label);
                panel.add(cityCurent);

    }
    private  JMenuItem loadFromFile(){
        JMenuItem plik=new JMenuItem("Wczytaj");
            plik.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd =e.getActionCommand();
                    if(cmd.equalsIgnoreCase("Wczytaj")) {
                        try {
                            FileMenager file = new FileMenager();
                            cityAndCountry= file.wczytaj();
                            for (int i=0;i<10;i++){
                                menuCuntry.add(menuCuntry(cityAndCountry[i][0]));
                                cityMenu.add(menuCity(cityAndCountry[i][1]));
                            }
                        } catch (Exception errorFile) {
                            errorFile.printStackTrace();
                        }
                    }
                }
            });
        return plik;
    }
    JMenu setings(){
        JMenu ustawienia=new JMenu("Ustawienia");
        ustawienia.add(loadFromFile());
        return ustawienia;
    }
    private JMenuItem menuCuntry(String name){
        JMenuItem tempCuntryName= new JMenuItem(name);
        tempCuntryName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(cmd.equalsIgnoreCase(name)){
                    country=name;
                    countryCurent.setText(name);
                }
            }
        });
        return tempCuntryName;
    }
    private JMenuItem menuCity(String name){
        JMenuItem tempCityName= new JMenuItem(name);
        tempCityName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(cmd.equalsIgnoreCase(name)){
                    city=name;
                    cityCurent.setText(name);
                }
            }
        });
        return tempCityName;
    }
}
