import java.util.ArrayList;

public class Batalha {
    private ArrayList<Personagem> personagens;

    public Batalha(ArrayList<Personagem> personagens) {
        this.personagens = personagens;
    }

    public void realizarTurno() {
        for (Personagem personagem : personagens) {
            if (personagem.getPontosVida() > 0) {
                Personagem alvo = selecionarAlvo(personagem);
                if (alvo != null && alvo.getPontosVida() > 0) {
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
                if (alvo != null && alvo.getPontosVida() > 0) {
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
        for (Personagem alvo : personagens) {
            if (alvo != personagem && alvo.getPontosVida() > 0) {
                return alvo;
            }
        }
        return null;
    }
}
