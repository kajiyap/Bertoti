package Controller;

import Model.ListaDeTarefas;
import Model.Tarefa;

public class ListarTarefasStrategy implements TarefaStrategy {
    @Override
    public void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        for (Tarefa t : listaDeTarefas.getTarefas()) {
            System.out.println(t);
        }
    }
}
