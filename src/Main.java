import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.criarPersonagens();
        jogo.criarInimigos();

        Scanner scanner = new Scanner(System.in);

        // Loop para simular a batalha
        for (int turno = 1; turno <= 3; turno++) {
            System.out.println("Turno " + turno);

            // Loop para permitir que cada personagem faça sua ação
            for (Personagem personagem : jogo.getJogadores()) {
                if (personagem.getPontosVida() > 0) {
                    System.out.println(personagem.getNome() + ", é sua vez. O que você deseja fazer?");
                    System.out.println("1 - Atacar");
                    System.out.println("2 - Usar habilidade (se disponível)");

                    int escolha = scanner.nextInt();

                    switch (escolha) {
                        case 1:
                            Personagem alvo = jogo.selecionarAlvo(personagem);
                            if (alvo != null) {
                                personagem.atacar(alvo);
                                System.out.println(personagem.getNome() + " atacou " + alvo.getNome() + "!");
                            }
                            break;
                        case 2:
                            // Lógica para usar habilidade (se implementado)
                            break;
                        default:
                            System.out.println("Escolha inválida. Passe sua vez.");
                            break;
                    }
                }
            }

            // Realizar turno dos inimigos
            jogo.realizarTurnoInimigos();
        }

        scanner.close();
    }
}
