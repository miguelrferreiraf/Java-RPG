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
                if (alvo != null) {
                    personagem.atacar(alvo);
                    // Outras ações possíveis durante o turno
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

