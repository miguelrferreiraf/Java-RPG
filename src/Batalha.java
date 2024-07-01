import java.util.ArrayList;
import java.util.Collections;

public class Batalha {
    private ArrayList<Personagem> personagens;

    public Batalha(ArrayList<Personagem> personagens) {
        if (personagens.isEmpty()) {
            throw new IllegalArgumentException("A lista de personagens não pode estar vazia.");
        }
        this.personagens = personagens;
    }

    public void realizarTurno() {
        for (Personagem personagem : personagens) {
            if (personagem.getPontosVida() > 0) {
                Personagem alvo = selecionarAlvo(personagem);
                if (alvo != null) {
                    personagem.atacar(alvo);
                    System.out.println(personagem.getNome() + " atacou " + alvo.getNome() + " e causou " + personagem.calcularDano(alvo) + " de dano.");
                    if (alvo.getPontosVida() <= 0) {
                        System.out.println(alvo.getNome() + " foi derrotado!");
                    }
                }
            }
        }
    }

    public void realizarTurnoInimigos() {
        for (Personagem personagem : personagens) {
            if (personagem instanceof Inimigo && personagem.getPontosVida() > 0) {
                Personagem alvo = selecionarAlvo(personagem);
                if (alvo != null) {
                    personagem.atacar(alvo);
                    System.out.println(personagem.getNome() + " atacou " + alvo.getNome() + " e causou " + personagem.calcularDano(alvo) + " de dano.");
                    if (alvo.getPontosVida() <= 0) {
                        System.out.println(alvo.getNome() + " foi derrotado!");
                    }
                }
            }
        }
    }

    private Personagem selecionarAlvo(Personagem personagem) {
        ArrayList<Personagem> todosPersonagens = new ArrayList<>();
        todosPersonagens.addAll(personagens);

        // Selecionar aleatoriamente um alvo que não seja o próprio personagem
        Collections.shuffle(todosPersonagens);
        for (Personagem alvo : todosPersonagens) {
            if (alvo != personagem && alvo.getPontosVida() > 0) {
                return alvo;
            }
        }
        return null;
    }
}
