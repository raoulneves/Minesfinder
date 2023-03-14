package pt.ipleiria.estg.dei.ei.esoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinesFinder extends JFrame {

    private JPanel primaryPanel;
    private JButton jogoFácilButton;
    private JButton jogoDíficilButton;
    private JButton sairButton;
    private JButton jogoMédioButton;
    private JLabel lblNomeMedio;
    private JLabel lblTempoMedio;
    private JLabel lblNomeDificil;
    private JLabel lblTempoDificil;
    private JLabel lblTempoFacil;
    private JLabel lblNomeFacil;

    private TabelaRecordes recordesFacil;

    private TabelaRecordes recordesMedio;

    private TabelaRecordes recordesDificil;

    public MinesFinder(String title) {
        super(title);

        setContentPane(primaryPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.recordesFacil = new TabelaRecordes();
        this.recordesMedio = new TabelaRecordes();
        this.recordesDificil = new TabelaRecordes();
        lerRecordesDoDisco();
        lblNomeFacil.setText(recordesFacil.getNome());
        lblTempoFacil.setText(Long.toString(recordesFacil.getTempo()/1000));
        lblNomeMedio.setText(recordesMedio.getNome());
        lblTempoMedio.setText(Long.toString(recordesMedio.getTempo()/1000));
        lblNomeDificil.setText(recordesDificil.getNome());
        lblTempoDificil.setText(Long.toString(recordesDificil.getTempo()/1000));

        recordesFacil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesFacilActualizado(recordes);
            }
        });
        recordesMedio.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesMedioActualizado(recordes);
            }
        });
        recordesDificil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesDificilActualizado(recordes);
            }
        });

        pack();

        // btn sair
        sairButton.addActionListener(this::btnSairActionPerformed);
        jogoFácilButton.addActionListener(this::btnFacilActionPerformed);
        jogoMédioButton.addActionListener(this::btnMedioactionPerformed);
        jogoDíficilButton.addActionListener(this::btnDificilactionPerformed);
    }

    private void recordesDificilActualizado(TabelaRecordes recordes) {
        lblNomeDificil.setText(recordes.getNome());
        lblTempoDificil.setText(Long.toString(recordes.getTempo() / 1000));
    }

    private void recordesMedioActualizado(TabelaRecordes recordes) {
        lblNomeMedio.setText(recordes.getNome());
        lblTempoMedio.setText(Long.toString(recordes.getTempo() / 1000));
    }

    private void recordesFacilActualizado(TabelaRecordes recordes) {
        lblNomeFacil.setText(recordes.getNome());
        lblTempoFacil.setText(Long.toString(recordes.getTempo() / 1000));
    }

    private void btnSairActionPerformed(ActionEvent e) {
        guardarRecordesDisco();
        System.exit(0);
    }

    private void btnFacilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(9, 9, 5), recordesFacil);
        janela.setVisible(true);
    }

    private void btnMedioactionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16, 16, 5), recordesMedio);
        janela.setVisible(true);
    }

    private void btnDificilactionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16, 30, 5), recordesDificil);
        janela.setVisible(true);
    }

    private void guardarRecordesDisco() {
        ObjectOutputStream oos = null;
        try {
            File f = new
                    File(System.getProperty("user.home") + File.separator + "minesfinder.recordes");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(recordesFacil);
            oos.writeObject(recordesMedio);
            oos.writeObject(recordesDificil);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    private void lerRecordesDoDisco() {
        ObjectInputStream ois = null;
        File f = new
                File(System.getProperty("user.home") + File.separator + "minesfinder.recordes");
        if (f.canRead()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                recordesFacil = (TabelaRecordes) ois.readObject();
                recordesMedio = (TabelaRecordes) ois.readObject();
                recordesDificil = (TabelaRecordes) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}

