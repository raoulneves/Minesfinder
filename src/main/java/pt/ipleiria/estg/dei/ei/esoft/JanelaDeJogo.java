package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;

public class JanelaDeJogo extends JFrame {
    private JPanel gamePanel; // painel do jogo. O nome é definido no modo Design, em "field name"
    public JanelaDeJogo() {
        setContentPane(gamePanel);
        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true); // opcional. Pode optar por fazer depois.
    }
}
