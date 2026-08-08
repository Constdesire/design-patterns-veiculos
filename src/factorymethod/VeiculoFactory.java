package factorymethod;
public class VeiculoFactory {

    public Veiculo criarVeiculo(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de veículo não pode ser nulo.");
        }

        switch (tipo.trim().toUpperCase()) {
            case "CARRO":
                return new Carro();
            case "MOTO":
                return new Moto();
            default:
                throw new IllegalArgumentException("Tipo de veículo desconhecido: " + tipo);
        }
    }
}
