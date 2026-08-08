# Padrões de Criação em Java: Factory Method e Abstract Factory

Projeto em **Java (Swing)** que implementa e compara dois padrões de
projeto criacionais do GoF

**Factory Method** pacote [`factorymethod`](src/factorymethod)
**Abstract Factory** pacote [`abstractfactory`](src/abstractfactory)

## Factory Method

Veiculo define o contrato exibirDetalhes().

Carro e Moto implementam esse contrato.

VeiculoFactory.criarVeiculo(String tipo) encapsula a decisão de qual classe concreta instanciar ("CARRO" = Carro, "MOTO" = Moto).

Em Main, o cliente não escreve new Carro() nem new Moto(), o que reduz o acoplamento entre o código cliente e as classes concretas.

## Abstract Factory

Sedan e Hatch são os produtos abstratos.

Cada montadora tem suas próprias implementações concretas desses produtos (FiatCronos/FiatArgo, VolksVirtus/VolksPolo).

MontadoraFactory é a fábrica abstrata, com um método de criação para cada tipo de produto da família.

FiatFactory e VolksFactory são as fábricas concretas, cada uma garante que os produtos criados pertencem sempre à mesma família de marca, evitando misturar.

## Parte 3 — O desafio do novo produto (SUV)
Ao tentar adicionar o SUV à fábrica abstrata que já existe, surge a limitação clássica do Abstract Factory.

A interface SUV foi criada e as classes FiatPulse e VolksTCross a implementaram sem dificuldade (isso é apenas mais um produto).

O problema ocorreu na interface MontadoraFactory: para que as fábricas pudessem criar o novo produto, foi obrigatório alterar a interface da fábrica abstrata, acrescentando SUV criarSUV().

Essa alteração quebra o Princípio Aberto/Fechado (OCP), e toda fábrica concreta existente precisou ser modificada para implementar o novo método. Se houvesse mais montadoras no sistema (ex.: ChevroletFactory), todas elas parariam de compilar até implementarem criarSUV().

Esse padrão facilita adicionar novas famílias (como uma montadora inteira) sem tocar no código existente, mas dificulta adicionar um novo produto a todas as famílias já existentes, pois exige alterar a interface da fábrica e, em cascata, todas as suas implementações.

Uma alternativa para cenários em que novos tipos de produto aparecem com frequência seria combinar Abstract Factory com Factory Method por tipo de produto, ou usar um registro dinâmico de criadores (abrindo mão, porém, de parte da segurança em tempo de compilação).

## Diagrama de Classes (UML)

### Abstract Factory (Partes 2 e 3 já com SUV integrado)

![Diagrama de classes do Abstract Factory](docs/diagrama-abstract-factory.png)

Fica visível como cada `MontadoraFactory` concreta (`FiatFactory`,
`VolksFactory`) realiza a fábrica abstrata, e como cada produto
concreto realiza sua respectiva interface de produto (`Sedan`,
`Hatch`, `SUV`), sempre dentro da mesma família coluna e a garantia
central que o Abstract Factory oferece.

### Factory Method (Parte 1)

![Diagrama de classes do Factory Method](docs/diagrama-factory-method.png)

## Referências

- GAMMA, E.; HELM, R.; JOHNSON, R.; VLISSIDES, J. *Design Patterns:
  Elements of Reusable Object-Oriented Software*. Addison-Wesley, 1994.
- Refactoring.Guru — [Factory Method](https://refactoring.guru/design-patterns/factory-method) e
  [Abstract Factory](https://refactoring.guru/design-patterns/abstract-factory).
- Oracle — [The Java™ Tutorials: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html).

---

**Nome do aluno:*Desirée*
