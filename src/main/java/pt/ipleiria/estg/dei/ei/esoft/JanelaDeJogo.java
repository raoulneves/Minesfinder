package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;
import java.awt.*;

public class JanelaDeJogo extends JFrame {
    private JPanel gamePanel; // painel do jogo. O nome é definido no modo Design, em "field name"

    private BotaoCampoMinado[][] botoes;
    private CampoMinado campoMinado;

    public JanelaDeJogo(CampoMinado campoMinado) {
        this.campoMinado = campoMinado;

        var nrLinhas = campoMinado.getNrLinhas();
        var nrColunas = campoMinado.getNrColunas();

        this.botoes = new BotaoCampoMinado[nrLinhas][nrColunas];

        gamePanel.setLayout(new GridLayout(nrLinhas, nrColunas));

        // Cria e adiciona botoes
        for (int linha = 0; linha < nrLinhas; ++linha){
            for (int coluna = 0; coluna < nrColunas; ++coluna){
                botoes[linha][coluna] = new BotaoCampoMinado();
                gamePanel.add(botoes[linha][coluna]);
            }
        }

        setContentPane(gamePanel);
        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true); // opcional. Pode optar por fazer depois.
        pack();
    }
}
