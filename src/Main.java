//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao jogo de RPG em Java!");

        Jogo jogo = new Jogo();
        jogo.criarPersonagens();
        System.out.println("Personagens criados com sucesso!");

        jogo.criarInimigos();
        System.out.println("Inimigos criados com sucesso!");

        jogo.iniciarBatalha();
        System.out.println("Batalha iniciada!");
    }
}

