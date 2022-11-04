package Game.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private String city = "", country = "";
    private int points = 0;

    private JLabel countryCurent, cityCurent,punktyGlowne;
    private JCheckBoxMenuItem scoreFrame, mainPoins,console;
    private Dimension label = new Dimension(70, 50);
    private String cityAndCountry[][] = new String[10][2];
    private JMenuBar menuBar;
    private PointsFrame frame1;
  private   PointsConsole console1;
    private JMenu menuCuntry = new JMenu("Kraj");
    private JMenu cityMenu = new JMenu("Stolica");

    public Game() {
        this.setTitle("Państwa-Miasta");
        this.setBounds(700, 200, 500, 300);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        addComponents();
        setVisible(true);
        this.setLayout(null);
    }

    private void addComponents() {
        menuBar = new JMenuBar();
        menuBar.add(setings());
        menuBar.add(menuCuntry);
        menuBar.add(cityMenu);
        this.setJMenuBar(menuBar);
        menuBar.setVisible(true);
        //Panel
        JPanel panel = new JPanel(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.GRAY);
        //kraj
        countryCurent = new JLabel(country);
        countryCurent.setLocation(200, 30);
        countryCurent.setSize(label);
        panel.add(countryCurent);
        //miasto
        cityCurent = new JLabel(city);
        cityCurent.setLocation(300, 30);
        cityCurent.setSize(label);
        panel.add(cityCurent);
        //punkty
        punktyGlowne = new JLabel("Punkty : "+points);
        punktyGlowne.setBounds(200,100,100,50);
        punktyGlowne.setVisible(false);
        panel.add(punktyGlowne);
    }
    private JCheckBoxMenuItem mainPoints(){
        mainPoins=new JCheckBoxMenuItem("Glowne okno");
        mainPoins.setActionCommand("mainPunkt");
            mainPoins.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd = e.getActionCommand();
                    if(cmd.equalsIgnoreCase("mainPunkt")){
                        if(mainPoins.getState()){
                            punktyGlowne.setVisible(true);
                        }else{
                            punktyGlowne.setVisible(false);
                        }
                    }
                }
            });

        return mainPoins;
    }
    private JMenuItem loadFromFile() {
        JMenuItem plik = new JMenuItem("Wczytaj");
        plik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equalsIgnoreCase("Wczytaj")) {
                    try {
                        FileMenager file = new FileMenager();
                        cityAndCountry = file.wczytaj();
                        for (int i = 0; i < 10; i++) {
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

    JMenu setings() {
        JMenu ustawienia = new JMenu("Ustawienia");
        ustawienia.add(loadFromFile());
        ustawienia.add(punkty());
        ustawienia.add(scoreFrame());
        ustawienia.add(mainPoints());
        ustawienia.add(consolePoints());
        ustawienia.add(showHideAll());
        return ustawienia;
    }

    JCheckBoxMenuItem scoreFrame() {
        scoreFrame = new JCheckBoxMenuItem("Okienko");
        frame1 = new PointsFrame();
        scoreFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (scoreFrame.getState()) {
                        frame1.setVisible(true);
                    } else {
                        frame1.setVisible(false);
                    }
            }
        });
        return scoreFrame;
    }
    JCheckBoxMenuItem consolePoints(){
        console=new JCheckBoxMenuItem("Konsola");
        console1=new PointsConsole();
        console.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   if (console.getState()){
                       console1.consoleStatusSwich(true);
                   }else {
                    console1.consoleStatusSwich(false);
                }
            }
        });
        return console;
    }

    private JMenuItem menuCuntry(String name) {
        JMenuItem tempCuntryName = new JMenuItem(name);
        tempCuntryName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equalsIgnoreCase(name)) {
                    country = name;
                    countryCurent.setText(name);
                    checkPoints();
                }
            }
        });
        return tempCuntryName;
    }

    private JMenuItem menuCity(String name) {
        JMenuItem tempCityName = new JMenuItem(name);
        tempCityName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equalsIgnoreCase(name)) {
                    city = name;
                    cityCurent.setText(name);
                    checkPoints();
                }
            }
        });
        return tempCityName;
    }

    private void checkPoints() {
        int city = -1, country = -1;
        for (int i = 0; i < 10; i++) {
            if (cityCurent.getText().equalsIgnoreCase(cityAndCountry[i][1])) {
                city = i;
                break;
            } else if (cityCurent == null) {
                break;
            } else {

            }
        }
        for (int i = 0; i < 10; i++) {
            if (countryCurent.getText().equalsIgnoreCase(cityAndCountry[i][0])) {
                country = i;
                break;
            } else if (countryCurent == null) {
                break;
            } else {

            }
        }
        if (city == country && (city >= 0 && country >= 0)) {
            points = points + 1;
            countryCurent.setText("");
            cityCurent.setText("");
            console1.addPoints();
        } else if (city != country && (city >= 0 && country >= 0)) {
            points = 0;
            countryCurent.setText("");
            cityCurent.setText("");
           console1.losePoints();
        } else {

        }
    }

    private JMenuItem punkty() {
        JMenuItem punkty = new JMenuItem("Punkty");
        punkty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame1.setSocer(points);
                    punktyGlowne.setText("Punkty : "+points);
                    console1.getPoints(points);
                }
        });
        return punkty;
    }
    private JCheckBoxMenuItem showHideAll(){
        JCheckBoxMenuItem  allPoints=new JCheckBoxMenuItem("On all/Off all");
        allPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (allPoints.getState()){
                        console.setState(true);
                        mainPoins.setState(true);
                        scoreFrame.setState(true);
                    }else {
                        console.setState(false);
                        mainPoins.setState(false);
                        scoreFrame.setState(false);
                    }
                }

        });
        return allPoints;
    }
}
