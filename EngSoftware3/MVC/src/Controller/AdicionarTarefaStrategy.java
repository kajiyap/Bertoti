package Controller;

import Model.ListaDeTarefas;
import Model.Tarefa;

public class AdicionarTarefaStrategy implements TarefaStrategy {
    @Override
    public void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        listaDeTarefas.adicionarTarefa(tarefa);
    }
}
