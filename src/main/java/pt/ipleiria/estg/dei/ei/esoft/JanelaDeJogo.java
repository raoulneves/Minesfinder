package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaDeJogo extends JFrame {
    private JPanel gamePanel; // painel do jogo. O nome é definido no modo Design, em "field name"

    private BotaoCampoMinado[][] botoes;
    private CampoMinado campoMinado;

    public JanelaDeJogo(CampoMinado campoMinado) {
        this.campoMinado = campoMinado;

        var nrLinhas = campoMinado.getNrLinhas();
        var nrColunas = campoMinado.getNrColunas();

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON3) {
                    return;
                }
                var botao = (BotaoCampoMinado) e.getSource();
                var y = botao.getColuna();
                var x = botao.getLinha();
                var estadoQuadricula = campoMinado.getEstadoQuadricula(x, y);
                marcarQuadricula(x, y);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                var botao = (BotaoCampoMinado) e.getSource();
                var x = botao.getLinha(); // ou var linha = botao.getLinha();
                var y = botao.getColuna(); // ou var coluna = botao.getColuna();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> botoes[--x < 0 ? nrLinhas - 1 :
                            x][y].requestFocus();
                    case KeyEvent.VK_DOWN -> botoes[(x + 1) %
                            nrLinhas][y].requestFocus();
                    case KeyEvent.VK_LEFT -> botoes[x][--y < 0 ? nrColunas - 1 :
                            y].requestFocus();
                    case KeyEvent.VK_RIGHT -> botoes[x][(y + 1) %
                            nrColunas].requestFocus();
                    case KeyEvent.VK_M -> {
                        marcarQuadricula(x, y);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        this.botoes = new BotaoCampoMinado[nrLinhas][nrColunas];

        gamePanel.setLayout(new GridLayout(nrLinhas, nrColunas));

        // Cria e adiciona botoes
        for (int linha = 0; linha < nrLinhas; ++linha) {
            for (int coluna = 0; coluna < nrColunas; ++coluna) {
                botoes[linha][coluna] = new BotaoCampoMinado(linha, coluna);
                botoes[linha][coluna].addActionListener(
                        this::btnCampoMinadoActionPerformed
                );
                botoes[linha][coluna].addKeyListener(keyListener);
                botoes[linha][coluna].addMouseListener(mouseListener);
                gamePanel.add(botoes[linha][coluna]);
            }
        }

        setContentPane(gamePanel);
        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true); // opcional. Pode optar por fazer depois.
        pack();

    }

    public void btnCampoMinadoActionPerformed(ActionEvent e) {
        var botao = (BotaoCampoMinado) e.getSource();
        int x = botao.getLinha();
        int y = botao.getColuna();
        campoMinado.revelarQuadricula(x, y);
        actualizarEstadoBotoes();
        if (campoMinado.isJogoTerminado()) {
            if (campoMinado.isJogadorDerrotado())
                JOptionPane.showMessageDialog(null, "Oh, rebentou uma mina",
                        "Perdeu!", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Parabéns. Conseguiu descobrir todas as minas em " +
                                (campoMinado.getDuracaoJogo() / 1000) + " segundos",
                        "Vitória", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        }
    }

    private void marcarQuadricula(int x, int y) {
        switch (campoMinado.getEstadoQuadricula(x, y)) {
            case CampoMinado.TAPADO -> campoMinado.marcarComoTendoMina(x, y);
            case CampoMinado.MARCADO -> campoMinado.marcarComoSuspeita(x, y);
            case CampoMinado.DUVIDA -> campoMinado.desmarcarQuadricula(x, y);
        }
        actualizarEstadoBotoes();
    }

    private void actualizarEstadoBotoes() {
        for (int x = 0; x < campoMinado.getNrLinhas(); x++) {
            for (int y = 0; y < campoMinado.getNrColunas(); y++) {
                botoes[x][y].setEstado(campoMinado.getEstadoQuadricula(x, y));
            }
        }
    }


}
