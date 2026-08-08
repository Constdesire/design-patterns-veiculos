package abstractfactory;

public interface MontadoraFactory {
    Sedan criarSedan();
    Hatch criarHatch();
    SUV criarSUV();
}
