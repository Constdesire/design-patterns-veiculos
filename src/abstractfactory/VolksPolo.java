package abstractfactory;
public class VolksPolo implements Hatch {

    @Override
    public void exibirConsumo() {
        System.out.println("Volkswagen Polo | Consumo médio: 13,0 km/l (cidade)");
    }
}
