public class Efeito {
    private String nome;
    private int duracao;

    public Efeito(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public void aplicarEfeito(Personagem personagem) {
        switch (nome) {
            case "Envenenado":
                personagem.receberDano(5); // Exemplo: toma 5 de dano a cada rodada
                break;
            case "Atordoado":
                // Implementação do efeito de atordoamento (ficar 1 turno sem atacar)
                // Aqui você poderia definir alguma lógica para o atordoamento
                break;
            case "Queimado":
                personagem.receberDano(10); // Exemplo: toma 10 de dano a cada rodada
                break;
            case "Dormindo":
                // Implementação do efeito de dormir (ficar X turnos sem atacar)
                // Aqui você poderia definir alguma lógica para o personagem dormir
                break;
            default:
                break;
        }
    }

    public void decrementarDuracao() {
        this.duracao--;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
