import sub.SistemaDeEntrega;
import sub.SistemaDeEstoque;
import sub.SistemaDePagamento;

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
