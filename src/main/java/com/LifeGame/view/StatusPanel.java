package com.LifeGame.view;

import com.LifeGame.controller.StatusController;
import com.LifeGame.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

@Component
public class StatusPanel extends JPanel implements Observer {

    private final StatusController statusController;
    private int generation;
    private int livecell;
    private Button btn;
    private Button btn2;



    @Autowired
    public StatusPanel(StatusController statusController) {
        this.statusController = statusController;
        this.statusController.addObserver(this);

        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();

        f.setTitle("Cell Information");
        f.setSize(250, 250);
        f.setVisible(true);
        f.setLayout(null);

        p.setBounds(0, 0, 200, 100);
        p2.setBounds(0, 100, 200, 100);

        GridLayout layout = new GridLayout(1,2);
        p.setLayout(layout);
        p2.setLayout(layout);

        this.btn = new Button(String.valueOf(this.generation));
        this.btn2 = new Button(String.valueOf(this.livecell));

        this.btn.setBounds(50, 50, 10, 10);
        this.btn2.setBounds(0, 0, 10, 10);
        this.btn.setFont();

        JLabel gen = new JLabel();
        gen.setText("generation");
        p.add(gen);

        JLabel liv = new JLabel();
        liv.setText("live cell");
        p2.add(liv);

        p.add(this.btn);
        p2.add(this.btn2);

        f.add(p);
        f.add(p2);

        System.out.println("in status panel gen"+this.generation);
        System.out.println("in status panel liv"+this.livecell);

    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof Model) {
            this.generation = ((Model) o).getGeneration();
            this.livecell = ((Model) o).getLivecell();
        }

        this.btn.setLabel(String.valueOf(this.generation));
        this.btn2.setLabel(String.valueOf(this.livecell));

        this.repaint();
    }
}
