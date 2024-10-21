import Controller.AdicionarTarefaStrategy;
import Controller.ListarTarefasStrategy;
import Controller.RemoverTarefaStrategy;
import Controller.TarefaController;
import Model.ListaDeTarefas;
import Model.Tarefa;
import View.TarefaView;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        TarefaView tarefaView = new TarefaView(listaDeTarefas);
        TarefaController controller = new TarefaController();

        Tarefa tarefa1 = new Tarefa("Comprar leite");
        Tarefa tarefa2 = new Tarefa("Pagar contas");

        controller.setStrategy(new AdicionarTarefaStrategy());
        controller.executarStrategy(listaDeTarefas, tarefa1);
        controller.executarStrategy(listaDeTarefas, tarefa2);

        controller.setStrategy(new RemoverTarefaStrategy());
        controller.executarStrategy(listaDeTarefas, tarefa1);

        controller.setStrategy(new ListarTarefasStrategy());
        controller.executarStrategy(listaDeTarefas, null);
    }
}
