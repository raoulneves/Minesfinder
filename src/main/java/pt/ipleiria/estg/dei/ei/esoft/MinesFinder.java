package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;

public class MinesFinder extends JFrame {

    private JPanel primaryPanel;
    private JButton jogoFácilButton;
    private JButton jogoDíficilButton;
    private JButton sairButton;
    private JButton jogoMédioButton;

    public MinesFinder(String title) {
        super(title);

        setContentPane(primaryPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
