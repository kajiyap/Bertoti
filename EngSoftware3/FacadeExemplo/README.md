# Exemplo do Padrão Facade em Java

## Descrição

Este projeto demonstra o uso do padrão de projeto Facade em Java. O padrão Facade fornece uma interface simplificada para um conjunto complexo de subsistemas. Neste exemplo, uma loja online utiliza vários sistemas internos para processar um pedido: sistema de pagamento, sistema de estoque e sistema de entrega. A classe `LojaFacade` simplifica a interação com esses sistemas.

## Estrutura do Projeto

### Classe `SistemaDePagamento`

A classe `SistemaDePagamento` representa o sistema responsável por processar pagamentos.

```java
public class SistemaDePagamento {
    public void processarPagamento(String conta, double valor) {
        System.out.println("Pagamento de " + valor + " processado para a conta " + conta);
    }
}
```

### Classe `SistemaDeEstoque`

A classe `SistemaDeEstoque` representa o sistema responsável por atualizar o estoque de produtos.

```java
public class SistemaDeEstoque {
    public void atualizarEstoque(String produto, int quantidade) {
        System.out.println("Estoque de " + produto + " atualizado para " + quantidade + " unidades.");
    }
}
```

### Classe `SistemaDeEntrega`

A classe `SistemaDeEntrega` representa o sistema responsável por agendar entregas de produtos.

```java
public class SistemaDeEntrega {
    public void agendarEntrega(String produto, String endereco) {
        System.out.println("Entrega de " + produto + " agendada para " + endereco);
    }
}
```

### Classe Facade `LojaFacade`

A classe `LojaFacade` simplifica a interação com os diferentes sistemas necessários para processar um pedido.

```java
public class LojaFacade {
    private SistemaDePagamento pagamento;
    private SistemaDeEstoque estoque;
    private SistemaDeEntrega entrega;

    public LojaFacade() {
        pagamento = new SistemaDePagamento();
        estoque = new SistemaDeEstoque();
        entrega = new SistemaDeEntrega();
    }

    public void realizarCompra(String produto, int quantidade, String conta, String endereco) {
        pagamento.processarPagamento(conta, quantidade * 100); // Supondo que cada produto custa 100
        estoque.atualizarEstoque(produto, quantidade);
        entrega.agendarEntrega(produto, endereco);
    }
}
```

### Classe Principal `Main`

A classe `Main` contém o método `main` que demonstra o uso da `LojaFacade` para realizar uma compra.

```java
public class Main {
    public static void main(String[] args) {
        LojaFacade loja = new LojaFacade();
        loja.realizarCompra("Notebook", 2, "12345-6", "Rua das Flores, 123");
    }
}
```

## Diagrama UML

Abaixo está o diagrama UML representando a estrutura das classes neste exemplo.

```plaintext
@startuml
class SistemaDePagamento {
    + processarPagamento(conta: String, valor: double): void
}

class SistemaDeEstoque {
    + atualizarEstoque(produto: String, quantidade: int): void
}

class SistemaDeEntrega {
    + agendarEntrega(produto: String, endereco: String): void
}

class LojaFacade {
    - pagamento: SistemaDePagamento
    - estoque: SistemaDeEstoque
    - entrega: SistemaDeEntrega
    + LojaFacade()
    + realizarCompra(produto: String, quantidade: int, conta: String, endereco: String): void
}

LojaFacade --> SistemaDePagamento
LojaFacade --> SistemaDeEstoque
LojaFacade --> SistemaDeEntrega

class Main {
    + main(args: String[]): void
}

Main --> LojaFacade
@enduml
```

## Como Executar

1. Clone o repositório para sua máquina local.
2. Navegue até o diretório do projeto.
3. Compile os arquivos `.java`:
   ```sh
   javac *.java
   ```
4. Execute a classe principal:
   ```sh
   java Main
   ```

## Explicação

Este exemplo utiliza o padrão Facade para simplificar a interação com múltiplos subsistemas (pagamento, estoque e entrega). A classe `LojaFacade` fornece um método `realizarCompra` que encapsula a complexidade das operações nos diferentes sistemas, oferecendo uma interface simples para o cliente.