import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        System.out.println("Escolha seu personagem:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Mago");
        System.out.println("3. Arqueiro");

        Scanner scanner = new Scanner(System.in);
        int escolhaPersonagem = scanner.nextInt();

        jogo.criarPersonagens();

        switch (escolhaPersonagem) {
            case 1:
                jogo.escolherPersonagem("Guerreiro");
                break;
            case 2:
                jogo.escolherPersonagem("Mago");
                break;
            case 3:
                jogo.escolherPersonagem("Arqueiro");
                break;
            default:
                System.out.println("Escolha inválida. Escolha um número de 1 a 3.");
                break;
        }

        jogo.criarInimigos();

        // Loop para simular a batalha
        for (int turno = 1; turno <= 3; turno++) {
            System.out.println("Turno " + turno);

            // Loop para permitir que cada personagem faça sua ação
            for (Personagem personagem : jogo.getJogadores()) {
                if (personagem.getPontosVida() > 0) {
                    System.out.println(personagem.getNome() + ", é sua vez.");
                    System.out.println("1 - Atacar");
                    System.out.println("2 - Usar habilidade (se disponível)");

                    int escolha = scanner.nextInt();

                    switch (escolha) {
                        case 1:
                            Personagem alvo = jogo.selecionarAlvo(personagem);
                            if (alvo != null) {
                                personagem.atacar(alvo);
                                System.out.println(personagem.getNome() + " atacou " + alvo.getNome() + " e causou " + personagem.calcularDano(alvo) + " de dano!");
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
