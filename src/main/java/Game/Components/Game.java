package Game.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private String city="",country="";

    private JLabel countryCurent,cityCurent;

    private Dimension label=new Dimension(70,50);


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
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(countryMenu());
        menuBar.add(cityMenu());
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
    private JMenu countryMenu(){
        JMenu menuCuntry = new JMenu("Kraj");
        menuCuntry.add(menuCuntry("Polska"));
        menuCuntry.add(menuCuntry("Niemcy"));
        menuCuntry.add(menuCuntry("Czechy"));
        return  menuCuntry;
    }
    private JMenu cityMenu(){
        JMenu cityMenu = new JMenu("Stolica");
        cityMenu.add(menuCity("Warszawa"));
        cityMenu.add(menuCity("Berlin"));
        cityMenu.add(menuCity("Praga"));
        return  cityMenu;
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
