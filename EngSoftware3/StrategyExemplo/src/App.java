public class App {
    public static void main(String[] args) throws Exception {
        Veiculo v1 = new Veiculo("chevrolet", "camaro", "DDH-10F3", 100000.00);
        v1.venda = new AVista();
        v1.fazerVenda(v1);
    }
}
