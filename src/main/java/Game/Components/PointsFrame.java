package Game.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointsFrame extends JFrame {
    private  JLabel socer;
    PointsFrame(){
        this.setTitle("Państwa-Miasta-Punkty");
        this.setBounds(300,200,400,200);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setBackground(Color.cyan);
        addComponents();
    }
    private void addComponents(){
        JMenuBar menuBar= new JMenuBar();
        JMenu setings = new JMenu("ustawienia");
        JMenuItem close=new JMenuItem("Zamknij");
        setings.add(close);
        menuBar.add(setings);
        JPanel panel = new JPanel(null);
        this.getContentPane().add(panel);
        panel.setVisible(true);
        panel.setBackground(Color.GRAY);
        socer =new JLabel("");
        socer.setBounds(100,50,100,50);
        socer.setVisible(true);
        panel.add(socer);
        socer.setBackground(new Color(21376));
        socer.setText("Punkty");
        this.setJMenuBar(menuBar);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(cmd.equalsIgnoreCase("Zamknij")){
                    dispose();
                }
            }
        });
    }
    void setSocer(int points){
        socer.setText("Punkty : "+points);
    }

}
