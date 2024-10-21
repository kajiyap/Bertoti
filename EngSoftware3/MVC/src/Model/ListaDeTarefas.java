package Model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private List<ListaDeTarefasObserver> observers = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        notificarObservers();
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
        notificarObservers();
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void adicionarObserver(ListaDeTarefasObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(ListaDeTarefasObserver observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        for (ListaDeTarefasObserver observer : observers) {
            observer.update();
        }
    }
}
