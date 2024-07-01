public class Arqueiro extends Personagem {
    private int destreza;

    public Arqueiro(String nome, int pontosVida, int forca, int defesa, int destreza) {
        super(nome, pontosVida, forca, defesa);
        this.destreza = destreza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}
