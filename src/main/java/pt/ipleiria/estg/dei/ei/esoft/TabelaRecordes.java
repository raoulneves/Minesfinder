package pt.ipleiria.estg.dei.ei.esoft;

import java.io.Serializable;
import java.util.ArrayList;

public class TabelaRecordes implements Serializable {
    private String nome;
    private long tempo;

    private transient ArrayList<TabelaRecordesListener> listeners;

    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempo = 9999999;
        listeners=new ArrayList<>();
    }

    public long getTempo() {
        return tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setRecorde(String nome, long tempo) {
        if(tempo < this.tempo){
            this.tempo = tempo;
            this.nome = nome;
            notifyRecordesActualizados();
        }
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners == null) listeners = new ArrayList<>();
        listeners.add(list);
    }
    public void removeTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners != null) listeners.remove(list);
    }

    private void notifyRecordesActualizados() {
        if (listeners != null) {
            for (TabelaRecordesListener list:listeners)
                list.recordesActualizados(this);
        }
    }
}
