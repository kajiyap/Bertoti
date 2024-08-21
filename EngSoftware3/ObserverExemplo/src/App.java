public class App {
    public static void main(String[] args) {
        // Criação do placar
        ScoreBoard scoreBoard = new ScoreBoard();

        // Criação dos observadores
        MobileDevice phone1 = new MobileDevice("Celular 1");
        MobileDevice phone2 = new MobileDevice("Celular 2");

        // Adicionando os observadores ao placar
        scoreBoard.addObserver(phone1);
        scoreBoard.addObserver(phone2);

        // Simulando mudanças no placar
        scoreBoard.setScore(1, 0);  // Time da casa marca um gol
        scoreBoard.setScore(1, 1);  // Time visitante empata
    }
}
