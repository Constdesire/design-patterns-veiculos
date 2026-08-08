package factorymethod;

public class Moto implements Veiculo {

    @Override
    public void exibirDetalhes() {
        System.out.println("Veículo: Moto | 2 rodas | Categoria: Urbana");
    }
}
