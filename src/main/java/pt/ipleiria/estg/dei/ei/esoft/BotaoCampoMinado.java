package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;
import java.awt.*;

public class BotaoCampoMinado extends JButton {

    private int estado;

    public BotaoCampoMinado() {
        this.estado = CampoMinado.TAPADO;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        switch (estado) {
            case CampoMinado.VAZIO:
                setText("");
                setBackground(Color.LIGHT_GRAY);
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
                setBackground(Color.LIGHT_GRAY);
        }
    }
}
