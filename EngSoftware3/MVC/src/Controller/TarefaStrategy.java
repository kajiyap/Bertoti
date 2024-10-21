package Controller;

import Model.ListaDeTarefas;
import Model.Tarefa;

public interface TarefaStrategy {
    void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa);
}
