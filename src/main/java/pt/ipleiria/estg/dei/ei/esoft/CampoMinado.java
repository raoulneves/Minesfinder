package pt.ipleiria.estg.dei.ei.esoft;

public class CampoMinado {

    private boolean[][] minas;
    public static final int VAZIO = 0;
    /* de 1 a 8 são o número de minas à volta */
    public static final int TAPADO = 9;
    public static final int DUVIDA = 10;
    public static final int MARCADO = 11;
    public static final int REBENTADO = 12;
    private int[][] estado;
    private int nrLinhas; // ou largura
    private int nrColunas; // ou altura
    private int nrMinas;

    public CampoMinado(int nrLinhas, int nrColunas, int nrMinas){
        this.nrLinhas = nrLinhas;
        this.nrColunas = nrColunas;
        this.nrMinas = nrMinas;

        this.minas = new boolean[nrLinhas][nrColunas]; // valores comecao a false
        this.estado = new int[nrLinhas][nrColunas]; // valores comecao a 0
    }

    public int getEstadoQuadricula(int x, int y){
        return estado[x][y];
    }

    public boolean hasMina(int x, int y) {
        return minas[x][y];
    }

    public int getNrLinhas() {
        return nrLinhas;
    }

    public int getNrColunas() {
        return nrColunas;
    }
}
