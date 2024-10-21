# Exemplo de Aplicação MVC com Strategy, Observer e Composite

## Descrição

Este projeto demonstra o uso dos padrões de projeto MVC (Model-View-Controller) juntamente com Strategy, Observer e Composite em Java. A aplicação é um sistema de gerenciamento de tarefas onde o usuário pode adicionar, remover e listar tarefas.

## Estrutura do Projeto

### Model (com Observer)

#### `Tarefa`

A classe `Tarefa` representa uma tarefa simples.

```java
public class Tarefa {
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
```

#### `ListaDeTarefas`

A classe `ListaDeTarefas` mantém uma lista de tarefas e notifica os observadores sobre mudanças.

```java
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
```

#### `ListaDeTarefasObserver`

A interface `ListaDeTarefasObserver` define o método `update` para os observadores.

```java
public interface ListaDeTarefasObserver {
    void update();
}
```

### View (com Observer)

#### `TarefaView`

A classe `TarefaView` exibe a lista de tarefas e é notificada sobre mudanças.

```java
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
```

### Controller (com Strategy)

#### `TarefaStrategy`

A interface `TarefaStrategy` define o método `executar` para diferentes estratégias de manipulação de tarefas.

```java
public interface TarefaStrategy {
    void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa);
}
```

#### `AdicionarTarefaStrategy`

A classe `AdicionarTarefaStrategy` implementa a estratégia para adicionar tarefas.

```java
public class AdicionarTarefaStrategy implements TarefaStrategy {
    @Override
    public void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        listaDeTarefas.adicionarTarefa(tarefa);
    }
}
```

#### `RemoverTarefaStrategy`

A classe `RemoverTarefaStrategy` implementa a estratégia para remover tarefas.

```java
public class RemoverTarefaStrategy implements TarefaStrategy {
    @Override
    public void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        listaDeTarefas.removerTarefa(tarefa);
    }
}
```

#### `ListarTarefasStrategy`

A classe `ListarTarefasStrategy` implementa a estratégia para listar tarefas.

```java
public class ListarTarefasStrategy implements TarefaStrategy {
    @Override
    public void executar(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        for (Tarefa t : listaDeTarefas.getTarefas()) {
            System.out.println(t);
        }
    }
}
```

### `TarefaController`

A classe `TarefaController` utiliza a estratégia definida para executar operações sobre a lista de tarefas.

```java
public class TarefaController {
    private TarefaStrategy strategy;

    public void setStrategy(TarefaStrategy strategy) {
        this.strategy = strategy;
    }

    public void executarStrategy(ListaDeTarefas listaDeTarefas, Tarefa tarefa) {
        strategy.executar(listaDeTarefas, tarefa);
    }
}
```

### Classe Principal

#### `Main`

A classe `Main` é o ponto de entrada da aplicação. Ela cria instâncias das classes necessárias, configura o controlador e executa algumas operações de exemplo.

```java
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
```

## Como Executar o Projeto

1. **Compilação**: Compile todos os arquivos `.java` no projeto. Certifique-se de que não há conflitos de nomes com classes do JDK.
   
2. **Execução**: Execute a classe `Main`. Você verá a lista de tarefas sendo atualizada conforme você adiciona e remove tarefas.

## Observações

- O padrão **Observer** é utilizado para notificar a `TarefaView` sempre que a lista de tarefas é alterada.
- O padrão **Strategy** é utilizado no `TarefaController` para permitir diferentes operações (adicionar, remover e listar tarefas) sem precisar modificar a lógica do controlador.
- A aplicação pode ser facilmente estendida para incluir mais funcionalidades ou novos tipos de tarefas, pois a estrutura permite adicionar novas estratégias e observadores conforme necessário.

## Conclusão

Este exemplo demonstra como combinar os padrões de projeto **Strategy**, **Observer** e **Composite** em uma aplicação MVC simples. Isso permite uma separação clara de responsabilidades e facilita a manutenção e extensão do código.