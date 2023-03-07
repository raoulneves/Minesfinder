package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;
import java.awt.*;

public class BotaoCampoMinado extends JButton {

    private int estado;

    private int linha;
    private int coluna;

    public BotaoCampoMinado(int linha, int coluna) {
        this.estado = CampoMinado.TAPADO;
        this.linha = linha;
        this.coluna = coluna;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        switch (estado) {
            case CampoMinado.VAZIO:
                setText("V");
                setBackground(Color.DARK_GRAY);
                break;
            case CampoMinado.TAPADO:
                setText("");
                setBackground(null);
                break;
            case CampoMinado.DUVIDA:
                setText("?");
                setBackground(Color.YELLOW);
                break;
            case CampoMinado.MARCADO:
                setText("!");
                setBackground(Color.RED);
                break;
            case CampoMinado.REBENTADO:
                setText("*");
                setBackground(Color.ORANGE);
                break;
            default:
                setText(String.valueOf(estado));
                setBackground(Color.DARK_GRAY);
        }
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

}
