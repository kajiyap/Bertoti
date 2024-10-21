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
