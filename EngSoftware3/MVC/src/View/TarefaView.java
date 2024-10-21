package View;

import Model.ListaDeTarefas;
import Model.ListaDeTarefasObserver;
import Model.Tarefa;

public class TarefaView implements ListaDeTarefasObserver {
    private ListaDeTarefas listaDeTarefas;

    public TarefaView(ListaDeTarefas listaDeTarefas) {
        this.listaDeTarefas = listaDeTarefas;
        listaDeTarefas.adicionarObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Lista de Tarefas Atualizada:");
        for (Tarefa tarefa : listaDeTarefas.getTarefas()) {
            System.out.println("- " + tarefa);
        }
    }
}
