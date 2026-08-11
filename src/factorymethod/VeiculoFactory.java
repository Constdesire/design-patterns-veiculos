package factorymethod;
/**
 * Factory Method.
 *
 * Centraliza a lógica de criação dos objetos concretos (Carro, Moto),
 * de forma que o Cliente (Main) nunca precise usar "new Carro()" ou
 * "new Moto()" diretamente. Isso desacopla o código cliente das
 * classes concretas, seguindo o Princípio Aberto/Fechado (OCP): para
 * adicionar um novo tipo de veículo no futuro, mexemos apenas aqui
 * dentro (e criamos a nova classe concreta), sem tocar em quem já usa
 * a fábrica.
 */
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
