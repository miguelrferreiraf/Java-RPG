import java.util.ArrayList;

public class Personagem {
    private String nome;
    private int pontosVida;
    private int forca;
    private int defesa;
    private int xp;
    private int nivel;
    private ArrayList<Habilidade> habilidades;
    private ArrayList<Efeito> efeitos;

    public Personagem(String nome, int pontosVida, int forca, int defesa) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.xp = 0;
        this.nivel = 1;
        this.habilidades = new ArrayList<>();
        this.efeitos = new ArrayList<>();
    }

    public void atacar(Personagem alvo) {
        int dano = calcularDano(alvo);
        alvo.receberDano(dano);
    }

    public void aplicarEfeitos() {
        ArrayList<Efeito> efeitosRemover = new ArrayList<>();
        for (Efeito efeito : efeitos) {
            efeito.aplicarEfeito(this);
            efeito.decrementarDuracao();
            if (efeito.getDuracao() <= 0) {
                efeitosRemover.add(efeito);
            }
        }
        efeitos.removeAll(efeitosRemover);
    }

    public int calcularDano(Personagem alvo) {
        int dano = this.forca - alvo.getDefesa();
        if (dano < 0) {
            dano = 0;
        }
        return dano;
    }

    public void receberDano(int dano) {
        this.pontosVida -= dano;
        if (this.pontosVida < 0) {
            this.pontosVida = 0;
        }
    }

    public void adicionarEfeito(Efeito efeito) {
        this.efeitos.add(efeito);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public ArrayList<Efeito> getEfeitos() {
        return efeitos;
    }

    public void setEfeitos(ArrayList<Efeito> efeitos) {
        this.efeitos = efeitos;
    }
}
