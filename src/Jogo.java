import java.util.ArrayList;

public class Jogo {
    private ArrayList<Personagem> jogadores;
    private ArrayList<Inimigo> inimigos;

    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.inimigos = new ArrayList<>();
    }

    public void criarPersonagens() {
        Guerreiro guerreiro = new Guerreiro("Guerreiro", 100, 20, 15);
        Mago mago = new Mago("Mago", 80, 15, 10, 50);
        Arqueiro arqueiro = new Arqueiro("Arqueiro", 90, 18, 12, 25);
        jogadores.add(guerreiro);
        jogadores.add(mago);
        jogadores.add(arqueiro);

        System.out.println("Personagens criados:");
        for (Personagem personagem : jogadores) {
            System.out.println("- " + personagem.getNome());
        }
    }

    public void criarInimigos() {
        Inimigo monstro = new Inimigo("Monstro", 80, 15, 10, "Monstro", 50);
        Inimigo chefe = new Inimigo("Chefe", 120, 25, 20, "Chefe", 100);
        inimigos.add(monstro);
        inimigos.add(chefe);

        System.out.println("Inimigos criados:");
        for (Inimigo inimigo : inimigos) {
            System.out.println("- " + inimigo.getNome() + " (Tipo: " + inimigo.getTipo() + ")");
        }
    }

    public void iniciarBatalha() {
        ArrayList<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(jogadores);
        todosPersonagens.addAll(inimigos);
        Batalha batalha = new Batalha(todosPersonagens);
        for (int i = 0; i < 3; i++) {
            batalha.realizarTurno();
        }
    }

    public ArrayList<Personagem> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Personagem> jogadores) {
        this.jogadores = jogadores;
    }

    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }
}

