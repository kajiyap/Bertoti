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
