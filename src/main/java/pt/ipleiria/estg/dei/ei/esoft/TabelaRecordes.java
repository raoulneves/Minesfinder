package pt.ipleiria.estg.dei.ei.esoft;

public class TabelaRecordes {
    private String nome;
    private long tempo;

    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempo = 9999999;
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
        }
    }

}
