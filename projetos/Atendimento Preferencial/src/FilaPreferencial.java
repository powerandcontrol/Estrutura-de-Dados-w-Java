public class FilaPreferencial {
    private No inicio;
    private No ultimo;
    private No ultimoPreferencial;

    public FilaPreferencial() {
        inicio = null;
        ultimo = null;
        ultimoPreferencial = null;
    }

  public void push(Paciente paciente) {
      No novoNo = new No(paciente);

      if (inicio == null) {
          inicio = novoNo;
          ultimo = novoNo;
          if (paciente.ehPrioritario()) {
              ultimoPreferencial = novoNo;
          }
      } else {
          if (paciente.ehPrioritario()) {
              if (ultimoPreferencial != null) {
                  novoNo.proximo = ultimoPreferencial.proximo;
                  ultimoPreferencial.proximo = novoNo;
                  ultimoPreferencial = novoNo;
              } else {
                  novoNo.proximo = inicio;
                  inicio = novoNo;
                  ultimoPreferencial = novoNo;
              }
          } else {
              ultimo.proximo = novoNo;
              ultimo = novoNo;
          }
      }
  }


    public void pop() {
        if (inicio != null) {
            if (inicio == ultimoPreferencial) {
                ultimoPreferencial = null;
            }
            inicio = inicio.proximo;
            if (inicio == null) {
                ultimo = null;
            }
        }
    }

    public void listarPacientes() {
        No temp = inicio;
        System.out.println("Pacientes aguardando atendimento:");
        while (temp != null) {
            System.out.println(temp.paciente.getNome() + (temp.paciente.ehPrioritario() ? " (Prioritário)" : ""));
            temp = temp.proximo;
        }
    }
}
