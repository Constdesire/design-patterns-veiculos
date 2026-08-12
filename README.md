# Factory Method e Abstract Factory

Projeto que implementa e compara dois padrões de
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

Cada montadora tem suas próprias implementações concretas desses produtos.

MontadoraFactory é a fábrica abstrata, com um método de criação para cada tipo de produto da família.

FiatFactory e VolksFactory são as fábricas concretas, cada uma garante que os produtos criados pertencem sempre à mesma família de marca, evitando misturar.

## O problema do novo produto
Ao tentar adicionar o SUV à fábrica abstrata que já existe, aparece s limitação do Abstract Factory.

A interface SUV foi criada e as classes FiatPulse e VolksTCross a implementaram sem dificuldade.

O problema acontece na interface MontadoraFactory, porque para que as fábricas pudessem criar o novo produto, foi obrigatório mudar a interface da fábrica abstrata, acrescentando SUV criarSUV().

Essa alteração quebra o Princípio Aberto/Fechado (OCP), e toda fábrica concreta que existe precisou ser mudada para implementar o novo método. Se houvesse mais montadoras no sistema como ChevroletFactory, todas elas parariam de compilar até implementarem criarSUV().

Esse padrão ele deixa mais facil adicionar novas famílias como uma montadora inteira sem tocar no código que ja existe, mas deixa mais dificil adicionar um novo produto a todas as famílias já existentes, porque exige alterar a interface da fábrica e, em cascata, todas as implementações.

Uma alternativa para cenários em que novos tipos de produto aparecem com frequência seria combinar Abstract Factory com Factory Method por tipo de produto, ou usar um registro dinâmico de criadores abrindo mão, de parte da segurança em tempo de compilação.

## Diagrama de Classes (UML)

### Abstract Factory (já com SUV integrado)

![Diagrama de classes do Abstract Factory](docs/diagrama-abstract-factory.png)


### Factory Method 

![Diagrama de classes do Factory Method](docs/diagrama-factory-method.png)

Desirée Constantino 

