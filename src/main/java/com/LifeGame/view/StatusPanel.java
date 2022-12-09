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


    @Autowired
    public StatusPanel(StatusController statusController) {
        this.statusController = statusController;
        this.statusController.addObserver(this);
        this.generation = generation;
        this.livecell = livecell;

        JFrame frame = new JFrame("Cell Information");
        frame.setLayout(new BorderLayout());
        frame.setSize(200, 200);

        JLabel gen = new JLabel();
        gen.setText(String.valueOf(this.generation));
        frame.add(gen);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof Model) {
            this.generation = ((Model) o).getGeneration();
            this.livecell = ((Model) o).getLivecell();
        }
        this.repaint();
    }
}
