import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * MBAltera
 */
public class MBAltera extends Banco implements ActionListener {

    static MBAltera mBAltera = new MBAltera();
    static JFrame janMBAltera = new JFrame("Altera | Mountain Bikes");
    static JLabel lblPesquisa = new JLabel("Insira o codigo da bicicleta:");

    static JLabel lblCodFab = new JLabel("Codigo de Fabricacao....: "); static JLabel lblMarca = new JLabel("Marca...................: ");
    static JLabel lblModelo = new JLabel("Modelo..................: "); static JLabel lblCadencia = new JLabel("Cadecia.................: ");
    static JLabel lblVelo = new JLabel("Velocidade..............: "); static JLabel lblMarcha = new JLabel("Marcha..................: ");
    static JLabel lblCorreiaExtra = new JLabel("Correia Extra...........: "); 

    static JTextField txtCodFab = new JTextField(10);
    static JTextField txtMarca = new JTextField(10); static JTextField txtModelo = new JTextField(10);
    static JTextField txtCadencia = new JTextField(10); static JTextField txtVelo = new JTextField(10);
    static JTextField txtMarcha = new JTextField(10); static JTextField txtCorreiaExtra = new JTextField(10);
    
    static JTextField txtPesquisa = new JTextField(10);
    static JButton btnVoltar = new JButton("Voltar");
    static JButton btnCancelar = new JButton("Cancelar");
    static JButton btnConsultar = new JButton("Consultar");
    static JButton btnEditar = new JButton("Editar");
    static JButton btnAlterar = new JButton("Alterar");

    static int index = -1;
    static boolean permissaoEditar = false;
    static boolean permissaoAlterar = false;
    
    public void abreJanMBAltera() {
        janMBAltera.setSize(500, 500);
        janMBAltera.setLayout(new FlowLayout());
        janMBAltera.setVisible(true);

        janMBAltera.add(btnVoltar);
        janMBAltera.add(lblPesquisa);
        janMBAltera.add(txtPesquisa);
        janMBAltera.add(btnConsultar);
        janMBAltera.add(btnEditar);

        janMBAltera.add(lblCodFab); janMBAltera.add(txtCodFab);
        janMBAltera.add(lblMarca); janMBAltera.add(txtMarca);
        janMBAltera.add(lblModelo); janMBAltera.add(txtModelo);
        janMBAltera.add(lblCadencia); janMBAltera.add(txtCadencia);
        janMBAltera.add(lblVelo); janMBAltera.add(txtVelo);
        janMBAltera.add(lblMarcha); janMBAltera.add(txtMarcha);
        janMBAltera.add(lblCorreiaExtra); janMBAltera.add(txtCorreiaExtra);

        janMBAltera.add(btnAlterar);
        janMBAltera.add(btnCancelar);

        entradaEditavel(false);

        btnVoltar.addActionListener(mBAltera);
        btnConsultar.addActionListener(mBAltera);
        btnCancelar.addActionListener(mBAltera);
        btnEditar.addActionListener(mBAltera);
        btnAlterar.addActionListener(mBAltera);

        janMBAltera.setDefaultCloseOperation(janMBAltera.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnVoltar)) {MB mB = new MB(); mB.janMB.setVisible(true); janMBAltera.dispose();}
        if (obj.equals(btnConsultar)) {
            int codigoX = Integer.parseInt(txtPesquisa.getText());
            
            index = armazem.consultar(codigoX);
            if (index == -1) {
                System.out.println("Bicicleta nao encontrada!");
                permissaoEditar = false;
                permissaoAlterar = false;
                return;
            }

            mountainBike = armazem.getMountainBike(index);

            setaEntradas();
            permissaoEditar = true;
        }
        if (obj.equals(btnEditar)) {
            if (permissaoEditar == true) {
                entradaEditavel(true);
                permissaoAlterar = true;
            } else {
                System.out.println("Para editar e' necessario consultar uma bicicleta primeiro!");
            }
        }
        if (obj.equals(btnAlterar)) {
            if (permissaoAlterar == true) {
                mountainBike.getFabricacao().setCodFab(Integer.parseInt(txtCodFab.getText()));
                mountainBike.getFabricacao().setMarca(txtMarca.getText());
                mountainBike.geraModelo(txtModelo.getText());
                mountainBike.mudarCadencia(Integer.parseInt(txtCadencia.getText()));
                mountainBike.setVelocidade(Integer.parseInt(txtVelo.getText()));
                mountainBike.mudarMarcha(Integer.parseInt(txtMarcha.getText()));
                mountainBike.setCorreiaExtra(txtCorreiaExtra.getText());

                armazem.alterar(mountainBike, index);
                JOptionPane.showMessageDialog(null, "Alteracoes realizadas com sucesso!");
            } else {
                System.out.println("Para alterar e' necessario editar uma bicicleta primeiro!");                
            }
        }
        // if (obj.equals(btnCancelar))
    }

    public void setaEntradas() {
        txtCodFab.setText(Integer.toString(mountainBike.getFabricacao().getCodFab()));
        txtMarca.setText(mountainBike.getFabricacao().getMarca());
        txtModelo.setText(mountainBike.getModelo());
        txtCadencia.setText(Integer.toString(mountainBike.getCadencia()));
        txtVelo.setText(Integer.toString(mountainBike.getVelocidade()));
        txtMarcha.setText(Integer.toString(mountainBike.getMarcha()));
        txtCorreiaExtra.setText(mountainBike.getCorreiaExtra());
    }

    public void entradaEditavel(boolean b) {
        txtCodFab.setEditable(b);
        txtMarca.setEditable(b);
        txtModelo.setEditable(b);
        txtCadencia.setEditable(b);
        txtVelo.setEditable(b);
        txtMarcha.setEditable(b);
        txtCorreiaExtra.setEditable(b);
    }
}