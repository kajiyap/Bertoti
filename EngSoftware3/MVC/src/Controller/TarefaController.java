package Controller;

import Model.ListaDeTarefas;
import Model.Tarefa;

public class TarefaController {
    private TarefaStrategy strategy;

    public void setStrategy(TarefaStrategy strategy) {
        this.strategy = strategy;
    }

    public void executarStrategy(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        strategy.executar(listaDeTarefas, tarefa);
    }
}
