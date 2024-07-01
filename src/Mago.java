import java.util.ArrayList;

public class Mago extends Personagem {
    private int pontosMagia;

    public Mago(String nome, int pontosVida, int forca, int defesa, int pontosMagia) {
        super(nome, pontosVida, forca, defesa);
        this.pontosMagia = pontosMagia;
    }

    public int getPontosMagia() {
        return pontosMagia;
    }

    public void setPontosMagia(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }
}

