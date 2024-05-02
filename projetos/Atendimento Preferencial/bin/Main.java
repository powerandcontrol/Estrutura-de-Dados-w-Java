import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaPreferencial fila = new FilaPreferencial();
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.print("Digite o nome do paciente (ou 'SAIR' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("SAIR")) {
                break;
            }

            System.out.print("O paciente é prioritário? (S/N): ");
            String prioritarioStr = scanner.nextLine();
            boolean prioritario = prioritarioStr.equalsIgnoreCase("S");

            fila.push(new Paciente(nome, prioritario));
            count++;

            if (count % 3 == 0) {
                fila.listarPacientes();
                fila.pop();
            }
        }

        scanner.close();

        System.out.println("Programa encerrado.");
    }
}
