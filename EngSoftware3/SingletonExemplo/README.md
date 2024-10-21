### README

# Exemplo Lúdico do Padrão Composite em Java

## Descrição

Este projeto demonstra o uso do padrão de projeto Composite em Java através de um exemplo lúdico de um jogo de aventura. Neste jogo, temos diferentes tipos de objetos: `Personagem`, `Item` e `Grupo`. Um `Grupo` pode conter tanto `Personagem` quanto `Item` ou até mesmo outros `Grupo`, formando uma estrutura hierárquica. 

## Estrutura do Projeto

### Interface `Componente`

A interface `Componente` define a operação comum `exibir` que deve ser implementada por todos os componentes do sistema.

```java
public interface Componente {
    void exibir();
}
```

### Classe `Item`

A classe `Item` representa um item no jogo, como uma espada ou arco. Ela implementa a interface `Componente`.

```java
public class Item implements Componente {
    private String nome;

    public Item(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir() {
        System.out.println("Item: " + nome);
    }
}
```

### Classe `Personagem`

A classe `Personagem` representa um personagem no jogo, como um guerreiro ou arqueiro. Ela também implementa a interface `Componente`.

```java
public class Personagem implements Componente {
    private String nome;

    public Personagem(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir() {
        System.out.println("Personagem: " + nome);
    }
}
```

### Classe `Grupo`

A classe `Grupo` é o componente composto que pode conter outros `Componente`, incluindo `Item`, `Personagem` e outros `Grupo`.

```java
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Componente {
    private String nome;
    private List<Componente> componentes = new ArrayList<>();

    public Grupo(String nome) {
        this.nome = nome;
    }

    public void adicionar(Componente componente) {
        componentes.add(componente);
    }

    public void remover(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public void exibir() {
        System.out.println("Grupo: " + nome);
        for (Componente componente : componentes) {
            componente.exibir();
        }
    }
}
```

### Classe Principal `JogoAventura`

A classe `JogoAventura` contém o método `main` que cria e organiza os objetos, demonstrando a utilização do padrão Composite.

```java
public class JogoAventura {
    public static void main(String[] args) {
        Personagem guerreiro = new Personagem("Guerreiro");
        Personagem arqueiro = new Personagem("Arqueiro");
        Item espada = new Item("Espada");
        Item arco = new Item("Arco");

        Grupo grupo1 = new Grupo("Grupo 1");
        grupo1.adicionar(guerreiro);
        grupo1.adicionar(espada);

        Grupo grupo2 = new Grupo("Grupo 2");
        grupo2.adicionar(arqueiro);
        grupo2.adicionar(arco);

        Grupo todosOsGrupos = new Grupo("Todos os Grupos");
        todosOsGrupos.adicionar(grupo1);
        todosOsGrupos.adicionar(grupo2);

        todosOsGrupos.exibir();
    }
}
```

## Diagrama UML

Abaixo está o diagrama UML representando a estrutura das classes neste exemplo.

```plaintext
@startuml
interface Componente {
    + exibir(): void
}

class Item {
    - nome: String
    + Item(nome: String)
    + exibir(): void
}

class Personagem {
    - nome: String
    + Personagem(nome: String)
    + exibir(): void
}

class Grupo {
    - nome: String
    - componentes: List<Componente>
    + Grupo(nome: String)
    + adicionar(componente: Componente): void
    + remover(componente: Componente): void
    + exibir(): void
}

Componente <|.. Item
Componente <|.. Personagem
Componente <|.. Grupo
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
   java JogoAventura
   ```

## Explicação

Este exemplo utiliza o padrão Composite para permitir que objetos individuais (`Item` e `Personagem`) e grupos de objetos (`Grupo`) sejam tratados de maneira uniforme. O método `exibir` é definido na interface `Componente` e implementado por todas as classes concretas, permitindo que cada componente se descreva de maneira apropriada. Isso torna o código extensível e flexível, facilitando a adição de novos tipos de componentes no futuro.