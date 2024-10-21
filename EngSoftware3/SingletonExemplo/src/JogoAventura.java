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
