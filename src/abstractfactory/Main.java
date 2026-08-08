package abstractfactory;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main extends JFrame {

    private final JTextArea areaSaida = new JTextArea(12, 45);

    public Main() {
        super("Abstract Factory - Montadoras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel painelBotoes = new JPanel();
        JButton btnFiat = new JButton("Gerar linha Fiat");
        JButton btnVolks = new JButton("Gerar linha Volkswagen");

        btnFiat.addActionListener(e -> gerarLinha(new FiatFactory(), "FIAT"));
        btnVolks.addActionListener(e -> gerarLinha(new VolksFactory(), "VOLKSWAGEN"));

        painelBotoes.add(btnFiat);
        painelBotoes.add(btnVolks);

        areaSaida.setEditable(false);
        areaSaida.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(painelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(areaSaida), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void gerarLinha(MontadoraFactory factory, String nomeMontadora) {
        Sedan sedan = factory.criarSedan();
        Hatch hatch = factory.criarHatch();
        SUV suv = factory.criarSUV();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(buffer));
        sedan.exibirPortaMalas();
        hatch.exibirConsumo();
        suv.exibirAltura();
        System.setOut(original);

        areaSaida.append("== Linha " + nomeMontadora + " ==\n");
        areaSaida.append(buffer.toString());
        areaSaida.append("\n");
    }

    public static void main(String[] args) {
        MontadoraFactory fiat = new FiatFactory();
        MontadoraFactory volks = new VolksFactory();

        System.out.println("== Fiat ==");
        fiat.criarSedan().exibirPortaMalas();
        fiat.criarHatch().exibirConsumo();
        fiat.criarSUV().exibirAltura();

        System.out.println("== Volkswagen ==");
        volks.criarSedan().exibirPortaMalas();
        volks.criarHatch().exibirConsumo();
        volks.criarSUV().exibirAltura();

        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
