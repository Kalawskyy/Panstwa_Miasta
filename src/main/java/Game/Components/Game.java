package Game.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private String city = "", country = "";
    private  int points=0;

    private JLabel countryCurent, cityCurent;

    private Dimension label = new Dimension(70, 50);
    private String cityAndCountry[][] = new String[10][2];
    private JMenuBar menuBar;
    private PointsFrame frame1;
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
        JPanel panel = new JPanel(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.GRAY);
        countryCurent = new JLabel(country);
        countryCurent.setLocation(200, 30);
        countryCurent.setSize(label);
        panel.add(countryCurent);
        cityCurent = new JLabel(city);
        cityCurent.setLocation(300, 30);
        cityCurent.setSize(label);
        panel.add(cityCurent);

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
        ustawienia.add(scoreFrame());
        return ustawienia;
    }

    JCheckBoxMenuItem scoreFrame() {
        JCheckBoxMenuItem scoreFrame = new JCheckBoxMenuItem("Okienko");
        frame1 = new PointsFrame();
        scoreFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equalsIgnoreCase("Okienko")) {
                    if (scoreFrame.getState()) {
                        frame1.setVisible(true);
                    } else {
                        frame1.setVisible(false);
                    }
                }
            }
        });
        return scoreFrame;
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
        int city=-1, country=-1;
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
        if(city==country&&(city<=0&&country<=0)){
            points=points+1;
            countryCurent = null;
            cityCurent = null;
            System.out.println("Get point : "+points);
        } else if (city!=country&&(city<=0&&country<=0)) {
            points=0;
            countryCurent = null;
            cityCurent = null;
            System.out.println("Loose all points");
        }else {
            System.out.println("Nothing");
        }
    }
}
