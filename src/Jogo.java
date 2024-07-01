import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Jogo {
    private ArrayList<Personagem> jogadores;
    private ArrayList<Inimigo> inimigos;
    private Personagem personagemSelecionado;

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
    }

    public void criarInimigos() {
        Inimigo monstro = new Inimigo("Monstro", 80, 15, 10, "Monstro", 50);
        Inimigo chefe = new Inimigo("Chefe", 120, 25, 20, "Chefe", 100);
        inimigos.add(monstro);
        inimigos.add(chefe);
    }

    public void escolherPersonagem(String nomePersonagem) {
        for (Personagem personagem : jogadores) {
            if (personagem.getNome().equals(nomePersonagem)) {
                this.personagemSelecionado = personagem;
                System.out.println("Você escolheu jogar com " + personagem.getNome() + ".");
                return;
            }
        }
        System.out.println("Personagem não encontrado.");
    }

    public void iniciarBatalha() {
        ArrayList<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(jogadores);
        todosPersonagens.addAll(inimigos);
        Batalha batalha = new Batalha(todosPersonagens);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (Personagem personagem : jogadores) {
                if (personagem.getPontosVida() > 0) {
                    System.out.println(personagem.getNome() + ", escolha uma ação: ");
                    System.out.println("1. Atacar");
                    System.out.println("2. Usar Habilidade");

                    int escolha = scanner.nextInt();

                    switch (escolha) {
                        case 1:
                            Personagem alvo = selecionarAlvo(personagem);
                            if (alvo != null) {
                                personagem.atacar(alvo);
                                System.out.println(personagem.getNome() + " atacou " + alvo.getNome() + "!");
                            }
                            break;
                        case 2:
                            System.out.println("Escolha uma habilidade:");
                            for (int j = 0; j < personagem.getHabilidades().size(); j++) {
                                Habilidade habilidade = personagem.getHabilidades().get(j);
                                System.out.println((j + 1) + ". " + habilidade.getNome() + " - Tipo: " + habilidade.getTipo() + ", Dano Base: " + habilidade.getDanoBase());
                            }
                            int escolhaHabilidade = scanner.nextInt();
                            if (escolhaHabilidade > 0 && escolhaHabilidade <= personagem.getHabilidades().size()) {
                                Habilidade habilidade = personagem.getHabilidades().get(escolhaHabilidade - 1);
                                alvo = selecionarAlvo(personagem);
                                if (alvo != null) {
                                    int dano = habilidade.getDanoBase();
                                    alvo.receberDano(dano);
                                    System.out.println(personagem.getNome() + " usou " + habilidade.getNome() + " em " + alvo.getNome() + " causando " + dano + " de dano!");
                                }
                            } else {
                                System.out.println("Escolha inválida.");
                            }
                            break;
                        default:
                            System.out.println("Escolha inválida.");
                            break;
                    }
                }
            }
            realizarTurnoInimigos();
        }
        scanner.close();
    }

    public Personagem selecionarAlvo(Personagem personagem) {
        ArrayList<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(jogadores);
        todosPersonagens.addAll(inimigos);

        // Selecionar aleatoriamente um alvo que não seja o próprio personagem
        Collections.shuffle(todosPersonagens);
        for (Personagem alvo : todosPersonagens) {
            if (alvo != personagem && alvo.getPontosVida() > 0) {
                return alvo;
            }
        }
        return null;
    }

    public void realizarTurnoInimigos() {
        ArrayList<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(jogadores);
        todosPersonagens.addAll(inimigos);

        Batalha batalha = new Batalha(todosPersonagens);
        batalha.realizarTurnoInimigos();
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
