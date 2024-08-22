# Implementação do Strategy pattern.

## Sistema de Venda de Veículos

Este projeto demonstra a implementação de um sistema de venda de veículos usando o padrão de projeto **Strategy**. O sistema permite que diferentes estratégias de venda sejam aplicadas a um veículo, como venda à vista, a prazo, ou financiamento.

## Estrutura do Projeto

### Classes Principais

- **Veiculo**: Representa o veículo que será vendido. Contém informações como marca, modelo, placa e preço.
- **Venda (Interface)**: Define o contrato que todas as estratégias de venda devem seguir. Possui um único método `vender(Veiculo veiculo)`.
- **AVista**: Implementa a interface `Venda`, representando a venda do veículo à vista, com desconto.
- **APrazo**: Implementa a interface `Venda`, representando a venda do veículo a prazo, com juros.
- **Financiamento**: Implementa a interface `Venda`, representando a venda do veículo via financiamento, também com juros.

### Arquivo `App.java`

O arquivo `App.java` inicializa um veículo e aplica uma estratégia de venda específica. No exemplo, a estratégia aplicada é a venda à vista (`AVista`).

```java
public class App {
    public static void main(String[] args) throws Exception {
        Veiculo v1 = new Veiculo("chevrolet", "camaro", "DDH-10F3", 100000.00);
        v1.venda = new AVista();
        v1.fazerVenda(v1);
    }
}
```

## Padrão Strategy

### O que é o Strategy?

O **Strategy Pattern** é um padrão de design comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

### Implementação no Projeto

Neste projeto, a interface `Venda` é o núcleo do padrão Strategy. Ela define o método `vender`, que é implementado por várias classes concretas como `AVista`, `APrazo` e `Financiamento`. Cada uma dessas classes encapsula uma forma diferente de venda.

O objeto `Veiculo` possui uma referência à interface `Venda`, permitindo que a estratégia de venda seja definida em tempo de execução. Isso oferece flexibilidade, permitindo que diferentes estratégias de venda sejam aplicadas a diferentes veículos ou em diferentes situações.

### Diagrama UML

![Alt text](./DiagramaConcessionaria.svg)

### Explicação do Diagrama

- **Venda (Interface)**: Define o método `vender` que todas as estratégias de venda implementam.
- **Veiculo**: Contém as propriedades do veículo e a referência à estratégia de venda (`Venda`).
- **AVista, APrazo, Financiamento**: Classes concretas que implementam a interface `Venda`, cada uma representando uma estratégia de venda específica.

## Como Executar

1. Compile todas as classes com o comando:
   ```
   javac *.java
   ```
2. Execute o arquivo `App.java`:
   ```
   java App
   ```

Você verá a saída no console, mostrando os detalhes da venda conforme a estratégia aplicada (neste caso, venda à vista).