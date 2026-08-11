package abstractfactory;
/**
 *
 * Define os métodos de criação para toda a família de produtos que uma
 * montadora concreta precisa fabricar. Cada implementação concreta
 * FiatFactory, VolksFactorygarante que os três produtos criados
 * pertencem sempre à mesma marca é essa a garantia  do padrão
 * Abstract Factory que é nunca misturar, por exemplo, um Sedan da Fiat com
 * um Hatch da Volkswagen na mesma linha de produção.
 *
 * o método criarSUV() foi adicionado aqui depois que o mercado
 * exigiu um novo tipo de veículo. Como consequência, TODA classe que já
 * implementava esta interface FiatFactory, VolksFactory precisou ser
 * alterada para também implementar criarSUV() e esse é exatamente o
 * trade-off do Abstract Factory 
 */

public interface MontadoraFactory {
    Sedan criarSedan();
    Hatch criarHatch();
    SUV criarSUV();
}
