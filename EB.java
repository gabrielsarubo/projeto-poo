import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * EB
 */
public class EB implements ActionListener{

    static EB eB = new EB();
    static JFrame janEB = new JFrame("E-Bikes");
    static JLabel lblTitulo = new JLabel("E-Bikes");
    static JLabel lblSubTitulo = new JLabel("Escolha uma das opcoes abaixo");
    static JButton btnCadastar = new JButton("Cadastrar uma nova bicicleta");
    static JButton btnConsultar = new JButton("Consultar uma bicicleta");
    static JButton btnAlterar = new JButton("Alterar uma bicicleta");
    static JButton btnExcluir = new JButton("Exluir uma bicicleta");
    static JButton btnVoltar = new JButton("Voltar ao menu principal");

    public void abreJanEB() {
        janEB.setSize(500, 500);
        janEB.setLayout(new FlowLayout());
        janEB.setVisible(true);

        janEB.add(lblTitulo);
        janEB.add(lblSubTitulo);
        janEB.add(btnCadastar);
        janEB.add(btnConsultar);
        janEB.add(btnAlterar);
        janEB.add(btnExcluir);
        janEB.add(btnVoltar);

        btnCadastar.addActionListener(eB);
        btnConsultar.addActionListener(eB);
        btnAlterar.addActionListener(eB);
        btnExcluir.addActionListener(eB);
        btnVoltar.addActionListener(eB);

        janEB.setDefaultCloseOperation(janEB.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        // if (obj.equals(btnCadastar))
        // if (obj.equals(btnConsultar))
        // if (obj.equals(btnAlterar))
        // if (obj.equals(btnExcluir))
        if (obj.equals(btnVoltar)) {SistemaBike sistemaBike = new SistemaBike(); janEB.setVisible(false); sistemaBike.janBemVindo.setVisible(true);}
    }
}