# Toy Store - Implementação do Padrão Composite

Este projeto demonstra a implementação do padrão de projeto Composite usando uma estrutura de brinquedos. O padrão Composite permite tratar objetos individuais e composições de objetos de maneira uniforme, facilitando a manipulação de hierarquias de objetos.

## Estrutura do Projeto

![alt text](image.png)

O projeto é composto pelas seguintes classes e interfaces:

1. **Toy**: Interface comum para todos os brinquedos.
2. **Doll**: Implementação de um brinquedo simples do tipo Boneca.
3. **ToyCar**: Implementação de um brinquedo simples do tipo Carro de Brinquedo.
4. **ToyBox**: Implementação de um conjunto de brinquedos que pode conter outros brinquedos.
5. **ToyStore**: Classe de demonstração que mostra como usar a estrutura Composite.

## Classes e Interfaces

### Toy

```java
public interface Toy {
    void display();
}
```

### Doll

```java
public class Doll implements Toy {
    private String name;

    public Doll(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Boneca: " + name);
    }
}
```

### ToyCar

```java
public class ToyCar implements Toy {
    private String name;

    public ToyCar(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Carro de Brinquedo: " + name);
    }
}
```

### ToyBox

```java
import java.util.ArrayList;
import java.util.List;

public class ToyBox implements Toy {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy(Toy toy) {
        toys.remove(toy);
    }

    @Override
    public void display() {
        System.out.println("Caixa de Brinquedos contém:");
        for (Toy toy : toys) {
            toy.display();
        }
    }
}
```

### ToyStore

```java
public class ToyStore {
    public static void main(String[] args) {
        Toy doll1 = new Doll("Boneca Barbie");
        Toy doll2 = new Doll("Boneca Polly");
        Toy toyCar1 = new ToyCar("Carro Hot Wheels");

        ToyBox toyBox1 = new ToyBox();
        toyBox1.addToy(doll1);
        toyBox1.addToy(toyCar1);

        ToyBox toyBox2 = new ToyBox();
        toyBox2.addToy(doll2);
        toyBox2.addToy(toyBox1);

        toyBox2.display();
    }
}
```

## Como Executar

1. Clone o repositório para sua máquina local.
2. Navegue até o diretório do projeto.
3. Compile as classes Java.
4. Execute a classe `ToyStore` para ver o padrão Composite em ação.

```sh
javac *.java
java ToyStore
```

## Explicação

- **Toy**: A interface `Toy` define o método `display()` que será implementado por todos os tipos de brinquedos.
- **Doll** e **ToyCar**: São folhas que implementam a interface `Toy` e representam brinquedos simples.
- **ToyBox**: É o Composite que pode conter outros brinquedos (folhas ou outros composites).
- **ToyStore**: Demonstra como construir uma estrutura hierárquica de brinquedos usando o padrão Composite. A `ToyBox` pode conter outros `Toy`s, inclusive outras `ToyBox`es, permitindo uma composição recursiva.

## Conclusão

O padrão Composite é útil para trabalhar com estruturas hierárquicas de objetos. Este exemplo mostra como você pode usar o padrão Composite para criar e manipular uma coleção de brinquedos de maneira simples e eficiente.

