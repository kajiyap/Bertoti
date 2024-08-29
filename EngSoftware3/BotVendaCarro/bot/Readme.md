# MyAmazingBot - Telegram Bot com Padrão Observer

## Descrição
O MyAmazingBot é um bot do Telegram desenvolvido em Java, que implementa o padrão de projeto Observer. Este bot foi criado para responder a comandos relacionados a diferentes modalidades de venda de veículos e notificar observadores quando novas mensagens são recebidas.

## Funcionalidades
- **Respostas a Comandos**: O bot responde aos comandos `/Parcelado`, `/Avista` e `/Financiado`, fornecendo informações detalhadas sobre as modalidades de venda.
- **Notificação de Observadores**: Utiliza o padrão Observer para notificar objetos observadores sempre que uma mensagem é recebida, permitindo a implementação de ações customizadas pelos observadores.

## Estrutura do Projeto
- **Main.java**: Classe principal que inicializa e executa o bot.
- **MyAmazingBot.java**: Implementação do bot que consome mensagens e utiliza o padrão Observer.
- **Observer.java**: Interface que define o método `update` para os observadores.
- **Subject.java**: Classe que gerencia a lista de observadores e os notifica sobre mudanças.
- **MessageObserver.java**: Implementação da interface Observer que realiza ações específicas ao receber notificações.
- **service/Venda.java**: Interface que define o comportamento de diferentes tipos de venda.
- **service/impl/AVista.java**: Implementação da venda à vista.
- **service/impl/Parcelado.java**: Implementação da venda parcelada.
- **service/impl/Financiamento.java**: Implementação da venda financiada.

## Como Funciona
1. **Comandos do Bot**: O bot monitora mensagens recebidas e responde aos comandos `/Parcelado`, `/Avista` e `/Financiado` com informações detalhadas sobre cada modalidade de venda.
2. **Padrão Observer**: Sempre que uma mensagem é recebida, o bot notifica todos os observadores registrados através do método `notifyObservers` na classe `Subject`.
3. **Implementação das Vendas**: As classes de venda (`AVista`, `Parcelado`, `Financiamento`) implementam a interface `Venda` e fornecem detalhes específicos sobre cada tipo de transação de venda.

## Exemplo de Uso
- **Interação com o Bot**: Um usuário envia um comando `/Avista` para o bot. O bot responde com detalhes sobre a venda à vista, e todos os observadores são notificados da mensagem recebida.
- **Notificação de Observadores**: Qualquer classe que implemente a interface `Observer` e seja registrada no `Subject` receberá notificações sempre que o bot receber uma nova mensagem.

## Conclusão
O MyAmazingBot demonstra uma integração prática do padrão de projeto Observer em um bot do Telegram, proporcionando um exemplo claro de como estruturar notificações de eventos em um contexto de mensagens de bot.