package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // btn sair
        sairButton.addActionListener(this::btnSairActionPerformed);
        jogoFácilButton.addActionListener(this::btnFacilActionPerformed);
        jogoMédioButton.addActionListener(this::btnMedioactionPerformed);
        jogoDíficilButton.addActionListener(this::btnDificilactionPerformed);
    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnFacilActionPerformed(ActionEvent e){
        var janela = new JanelaDeJogo(new CampoMinado(9,9,10));
        janela.setVisible(true);
    }

    private void btnMedioactionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16,16,40));
        janela.setVisible(true);
    }

    private void btnDificilactionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16,30,90));
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
