# Exemplo do Padrão Singleton em Java

## Descrição

Este projeto demonstra o uso do padrão de projeto Singleton em Java. O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a essa instância. Neste exemplo, a classe `Configuracao` utiliza o padrão Singleton para gerenciar uma configuração única em um aplicativo.

## Estrutura do Projeto

### Classe `Configuracao`

A classe `Configuracao` implementa o padrão Singleton. Ela possui um construtor privado para evitar a criação de instâncias fora da classe e um método `getInstancia` que garante que apenas uma instância da classe seja criada.

```java
public class Configuracao {
    private static Configuracao instancia;
    private String configuracao;

    private Configuracao() {
        // Configuração inicial
        configuracao = "Configuração padrão";
    }

    public static synchronized Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }
}
```

### Classe Principal `Main`

A classe `Main` contém o método `main` que demonstra a obtenção e uso da instância única da classe `Configuracao`.

```java
public class Main {
    public static void main(String[] args) {
        // Obtendo a instância única da configuração
        Configuracao config = Configuracao.getInstancia();
        
        // Exibindo a configuração padrão
        System.out.println(config.getConfiguracao());
        
        // Modificando a configuração
        config.setConfiguracao("Nova configuração");

        // Obtendo a instância novamente e exibindo a nova configuração
        Configuracao config2 = Configuracao.getInstancia();
        System.out.println(config2.getConfiguracao());
    }
}
```

## Diagrama UML

Abaixo está o diagrama UML representando a estrutura das classes neste exemplo.

```plaintext
@startuml
class Configuracao {
    - instancia: Configuracao
    - configuracao: String
    - Configuracao()
    + static getInstancia(): Configuracao
    + getConfiguracao(): String
    + setConfiguracao(configuracao: String): void
}

Configuracao --> Configuracao : "1 instancia"

class Main {
    + main(args: String[]): void
}

Main --> Configuracao
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

Este exemplo utiliza o padrão Singleton para garantir que a classe `Configuracao` tenha apenas uma instância. O método `getInstancia` verifica se a instância já foi criada; se não, ele cria uma nova instância. Isso garante que sempre haverá apenas uma instância de `Configuracao` no aplicativo, permitindo o acesso e a modificação centralizada das configurações.