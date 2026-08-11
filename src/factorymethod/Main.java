package factorymethod;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Cliente do padrão Factory Method.
 *
 * Interface  permite ao usuário escolher o tipo
 * de veículo Carro ou Moto e solicitar sua criação através da fábrica
 * VeiculoFactory, sem nunca usar "new Carro()" ou "new Moto()" aqui.
 */
public class Main extends JFrame {

    // A única instância de fábrica usada por toda a janela. É poe ela
    // que os veículos são criados o Cliente não conhece Carro
    // nem Moto, apenas Veiculo e VeiculoFactory.
    private final VeiculoFactory factory = new VeiculoFactory();

    private final JTextArea areaSaida = new JTextArea(10, 40);
    public Main() {
        super("Factory Method - Veículos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Painel superior com os três botões de ação.
        JPanel painelBotoes = new JPanel();
        JButton btnCarro = new JButton("Criar Carro");
        JButton btnMoto = new JButton("Criar Moto");
        JButton btnAmbos = new JButton("Criar Carro e Moto");

        // Cada botão, ao ser clicado, pede à fábrica um veículo do tipo
        // correspondente e imprime o resultado na área de texto.
        btnCarro.addActionListener(e -> criarEExibir("CARRO"));
        btnMoto.addActionListener(e -> criarEExibir("MOTO"));
        btnAmbos.addActionListener(e -> {
            criarEExibir("CARRO");
            criarEExibir("MOTO");
        });

        painelBotoes.add(btnCarro);
        painelBotoes.add(btnMoto);
        painelBotoes.add(btnAmbos);

        // A área de saída é somente leitura o usuário só visualiza o
        // resultado, não a edita.
        areaSaida.setEditable(false);
        areaSaida.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(painelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(areaSaida), BorderLayout.CENTER);

        // Ajusta o tamanho da janela ao conteúdo e a centraliza na tela.
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Usa a fábrica para instanciar o veículo pedido e mostra o resultado
     * do método exibirDetalhes() na área de texto da janela.
     *
     * 
     */
    private void criarEExibir(String tipo) {
        // pedimos o veículo à fábrica, e recebemos
        // de volta apenas o tipo abstrato Veiculo não sabemos nem
        // precisamos saber se por baixo é um Carro ou uma Moto.
        Veiculo veiculo = factory.criarVeiculo(tipo);

        // exibirDetalhes() escreve no console  por padrão.
        // Como queremos mostrar esse texto dentro da janela Swing e não
        // só no terminal, foi trocado por enquanto o destino padrão de
        // saída por um buffer em memória, e chama o método normalmente,
        // e depois restaura o console original.
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(buffer));
        veiculo.exibirDetalhes();
        System.setOut(original);

        // Acrescenta o texto capturado na área de saída da GUI.
        areaSaida.append(buffer.toString());
    }

    public static void main(String[] args) {
        // cria os dois tipos de veículo
        // e imprime seus detalhes, através da fábrica.
        VeiculoFactory factory = new VeiculoFactory();
        Veiculo carro = factory.criarVeiculo("CARRO");
        Veiculo moto = factory.criarVeiculo("MOTO");
        carro.exibirDetalhes();
        moto.exibirDetalhes();

        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
