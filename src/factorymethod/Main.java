package factorymethod;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main extends JFrame {

    private final VeiculoFactory factory = new VeiculoFactory();
    private final JTextArea areaSaida = new JTextArea(10, 40);

    public Main() {
        super("Factory Method - Veículos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel painelBotoes = new JPanel();
        JButton btnCarro = new JButton("Criar Carro");
        JButton btnMoto = new JButton("Criar Moto");
        JButton btnAmbos = new JButton("Criar Carro e Moto");

        btnCarro.addActionListener(e -> criarEExibir("CARRO"));
        btnMoto.addActionListener(e -> criarEExibir("MOTO"));
        btnAmbos.addActionListener(e -> {
            criarEExibir("CARRO");
            criarEExibir("MOTO");
        });

        painelBotoes.add(btnCarro);
        painelBotoes.add(btnMoto);
        painelBotoes.add(btnAmbos);

        areaSaida.setEditable(false);
        areaSaida.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(painelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(areaSaida), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void criarEExibir(String tipo) {
        Veiculo veiculo = factory.criarVeiculo(tipo);


        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(buffer));
        veiculo.exibirDetalhes();
        System.setOut(original);

        areaSaida.append(buffer.toString());
    }

    public static void main(String[] args) {

        VeiculoFactory factory = new VeiculoFactory();
        Veiculo carro = factory.criarVeiculo("CARRO");
        Veiculo moto = factory.criarVeiculo("MOTO");
        carro.exibirDetalhes();
        moto.exibirDetalhes();

        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
