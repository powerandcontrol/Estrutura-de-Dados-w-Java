public class Paciente {
    private String nome;
    private boolean prioritario;

    public Paciente(String nome, boolean prioritario) {
        this.nome = nome;
        this.prioritario = prioritario;
    }

    public boolean ehPrioritario() {
        return prioritario;
    }

    public String getNome() {
        return nome;
    }
}
