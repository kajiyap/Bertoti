package Controller;

import Model.ListaDeTarefas;
import Model.Tarefa;

public class RemoverTarefaStrategy implements TarefaStrategy {
    @Override
    public void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        listaDeTarefas.removerTarefa(tarefa);
    }
}
