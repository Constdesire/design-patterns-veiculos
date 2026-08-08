package abstractfactory;

public class VolksFactory implements MontadoraFactory {

    @Override
    public Sedan criarSedan() {
        return new VolksVirtus();
    }

    @Override
    public Hatch criarHatch() {
        return new VolksPolo();
    }

    @Override
    public SUV criarSUV() {
        return new VolksTCross();
    }
}
