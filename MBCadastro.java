import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * MBCadastro
 */
public class MBCadastro extends Banco implements ActionListener {

    static MBCadastro mBCadastro = new MBCadastro();
    static JFrame janMBCadastro = new JFrame("Cadastro | Mountain Bikes");
    static JLabel lblTitulo = new JLabel("Cadastrar uma nova bicicleta");
    static JLabel lblSubTitulo = new JLabel("Entre com os dados da nova bicicleta abaixo:");
    static JLabel lblCodFab = new JLabel("Codigo de Fabricacao"); static JLabel lblMarca = new JLabel("Marca");
    static JLabel lblModelo = new JLabel("Modelo"); static JLabel lblCadencia = new JLabel("Cadecia");
    static JLabel lblVelo = new JLabel("Velocidade"); static JLabel lblMarcha = new JLabel("Marcha");
    static JLabel lblCorreiaExtra = new JLabel("Correia Extra"); 
    static JTextField txtCodFab = new JTextField(10);
    static JTextField txtMarca = new JTextField(10); static JTextField txtModelo = new JTextField(10);
    static JTextField txtCadencia = new JTextField(10); static JTextField txtVelo = new JTextField(10);
    static JTextField txtMarcha = new JTextField(10); static JTextField txtCorreiaExtra = new JTextField(10);
    static JButton btnVoltar = new JButton("Voltar");
    static JButton btnCancelar = new JButton("Cancelar");
    static JButton btnCadastrar = new JButton("Cadastrar");

    public void abreJanMBCadastro() {
        janMBCadastro.setSize(500, 500);
        janMBCadastro.setLayout(new FlowLayout());
        janMBCadastro.setVisible(true);

        janMBCadastro.add(btnVoltar);
        janMBCadastro.add(lblTitulo);
        janMBCadastro.add(lblSubTitulo);
        janMBCadastro.add(lblCodFab); janMBCadastro.add(txtCodFab);
        janMBCadastro.add(lblMarca); janMBCadastro.add(txtMarca);
        janMBCadastro.add(lblModelo); janMBCadastro.add(txtModelo);
        janMBCadastro.add(lblCadencia); janMBCadastro.add(txtCadencia);
        janMBCadastro.add(lblVelo); janMBCadastro.add(txtVelo);
        janMBCadastro.add(lblMarcha); janMBCadastro.add(txtMarcha);
        janMBCadastro.add(lblCorreiaExtra); janMBCadastro.add(txtCorreiaExtra);
        janMBCadastro.add(btnCadastrar);
        janMBCadastro.add(btnCancelar);

        btnVoltar.addActionListener(mBCadastro);
        btnCancelar.addActionListener(mBCadastro);
        btnCadastrar.addActionListener(mBCadastro);

        janMBCadastro.setDefaultCloseOperation(janMBCadastro.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnVoltar)) {MB mB = new MB(); mB.janMB.setVisible(true); janMBCadastro.dispose();}
        if (obj.equals(btnCadastrar)) {
            mountainBike.getFabricacao().setCodFab(Integer.parseInt(txtCodFab.getText()));
            mountainBike.getFabricacao().setMarca(txtMarca.getText());
            mountainBike.geraModelo(txtModelo.getText());
            mountainBike.mudarCadencia(Integer.parseInt(txtCadencia.getText()));
            mountainBike.setVelocidade(Integer.parseInt(txtVelo.getText()));
            mountainBike.mudarMarcha(Integer.parseInt(txtMarcha.getText()));
            mountainBike.setCorreiaExtra(txtCorreiaExtra.getText());
            
            if (armazem.inserir(mountainBike)) JOptionPane.showMessageDialog(null, "Bicicleta cadastrada com sucesso!");
            else JOptionPane.showMessageDialog(null, "Bicicleta nao cadastrada: o armazem esta lotado!");
        }
        // if (obj.equals(btnCancelar))
    }
}