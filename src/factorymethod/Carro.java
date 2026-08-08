package factorymethod;

public class Carro implements Veiculo {

    @Override
    public void exibirDetalhes() {
        System.out.println("Veículo: Carro | 4 rodas | Categoria: Passeio");
    }
}
