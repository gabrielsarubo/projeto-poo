import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * MB
 */
public class MB implements ActionListener{

    static MB mB = new MB();
    static JFrame janMB = new JFrame("Mountain Bikes");
    static JLabel lblTitulo = new JLabel("Mountain Bikes");
    static JLabel lblSubTitulo = new JLabel("Escolha uma das opcoes abaixo");
    static JButton btnCadastar = new JButton("Cadastrar uma nova bicicleta");
    static JButton btnConsultar = new JButton("Consultar uma bicicleta");
    static JButton btnAlterar = new JButton("Alterar uma bicicleta");
    static JButton btnExcluir = new JButton("Exluir uma bicicleta");
    static JButton btnVoltar = new JButton("Voltar ao menu principal");

    public void abreJanMB() {
        janMB.setSize(500, 500);
        janMB.setLayout(new FlowLayout());
        janMB.setVisible(true);

        janMB.add(lblTitulo);
        janMB.add(lblSubTitulo);
        janMB.add(btnCadastar);
        janMB.add(btnConsultar);
        janMB.add(btnAlterar);
        janMB.add(btnExcluir);
        janMB.add(btnVoltar);

        btnCadastar.addActionListener(mB);
        btnConsultar.addActionListener(mB);
        btnAlterar.addActionListener(mB);
        btnExcluir.addActionListener(mB);
        btnVoltar.addActionListener(mB);

        janMB.setDefaultCloseOperation(janMB.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnCadastar)) {
            MBCadastro x = new MBCadastro();
            x.abreJanMBCadastro(); 
            janMB.setVisible(false);
        }
        if (obj.equals(btnConsultar)) {
            MBConsulta y = new MBConsulta();
            y.abreJanMBConsulta();
            janMB.setVisible(false);
        }
        if (obj.equals(btnAlterar)) {
            MBAltera z = new MBAltera();
            z.abreJanMBAltera();
            janMB.setVisible(false);
        }
        if (obj.equals(btnExcluir)) {
            MBExclui a = new MBExclui();
            a.abreJanMBExclui();
            janMB.setVisible(false);
        }
        if (obj.equals(btnVoltar)) {SistemaBike sistemaBike = new SistemaBike(); sistemaBike.janBemVindo.setVisible(true); janMB.dispose();}
    }
}