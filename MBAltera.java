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
    static JTextField txtPesquisa = new JTextField(10);

    static JLabel lblCodFab = new JLabel("Codigo de Fabricacao....: "); static JLabel lblMarca = new JLabel("Marca...................: ");
    static JLabel lblModelo = new JLabel("Modelo..................: "); static JLabel lblCadencia = new JLabel("Cadecia.................: ");
    static JLabel lblVelo = new JLabel("Velocidade..............: "); static JLabel lblMarcha = new JLabel("Marcha..................: ");
    static JLabel lblCorreiaExtra = new JLabel("Correia Extra...........: "); 

    static JTextField txtCodFab = new JTextField(10);
    static JTextField txtMarca = new JTextField(10); static JTextField txtModelo = new JTextField(10);
    static JTextField txtCadencia = new JTextField(10); static JTextField txtVelo = new JTextField(10);
    static JTextField txtMarcha = new JTextField(10); static JTextField txtCorreiaExtra = new JTextField(10);
    
    static JButton btnVoltar = new JButton("Voltar");
    static JButton btnCancelar = new JButton("Cancelar");
    static JButton btnConsultar = new JButton("Consultar");
    static JButton btnEditar = new JButton("Editar");
    static JButton btnAlterar = new JButton("Alterar");

    static int index = -1;
    static boolean foiConsultado = false;
    
    public void abreJanMBAltera() {
        foiConsultado = false;
        
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

        txtFieldEditavel(false);
        txtFieldLimpar();
        txtPesquisa.setText("");
        txtPesquisa.requestFocus();

        btnVoltar.addActionListener(mBAltera);
        btnConsultar.addActionListener(mBAltera);
        btnCancelar.addActionListener(mBAltera);
        btnEditar.addActionListener(mBAltera);
        btnAlterar.addActionListener(mBAltera);

        janMBAltera.setDefaultCloseOperation(janMBAltera.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnVoltar) || obj.equals(btnCancelar)) {MB mB = new MB(); mB.janMB.setVisible(true); janMBAltera.dispose();}
        if (obj.equals(btnConsultar)) {
            if (permissaoConsultar()) {
                int codigoX = Integer.parseInt(txtPesquisa.getText());
            
                index = armazem.consultar(mountainBike, codigoX);
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Nao foi encontrada nenhuma bicicleta com o codigo informado.");
                    txtFieldLimpar();
                    txtFieldEditavel(false);
                    foiConsultado = false;
                    txtPesquisa.setText("");
                    txtPesquisa.requestFocus();
                    return;
                }

                mountainBike = armazem.getMountainBike(index);

                txtFieldPopular();
                foiConsultado = true;
                btnEditar.requestFocus();
            }
        }
        if (obj.equals(btnEditar)) {
            if (permissaoEditar()) {
                txtFieldEditavel(true);
            }
        }
        if (obj.equals(btnAlterar)) {
            if (txtCodFab.isEditable()) {
                mountainBike.getFabricacao().setCodFab(Integer.parseInt(txtCodFab.getText()));
                mountainBike.getFabricacao().setMarca(txtMarca.getText());
                mountainBike.geraModelo(txtModelo.getText());
                mountainBike.mudarCadencia(Integer.parseInt(txtCadencia.getText()));
                mountainBike.setVelocidade(Integer.parseInt(txtVelo.getText()));
                mountainBike.mudarMarcha(Integer.parseInt(txtMarcha.getText()));
                mountainBike.setCorreiaExtra(txtCorreiaExtra.getText());

                armazem.alterar(mountainBike, index);
                JOptionPane.showMessageDialog(null, "Alteracoes realizadas com sucesso!");
                txtFieldLimpar();
                txtFieldEditavel(false);
                foiConsultado = false;
                txtPesquisa.setText("");
                txtPesquisa.requestFocus();
            }
        }
    }

    public void txtFieldPopular() {
        txtCodFab.setText("" + mountainBike.getFabricacao().getCodFab());
        txtMarca.setText(mountainBike.getFabricacao().getMarca());
        txtModelo.setText(mountainBike.getModelo());
        txtCadencia.setText("" + mountainBike.getCadencia());
        txtVelo.setText("" + mountainBike.getVelocidade());
        txtMarcha.setText("" + mountainBike.getMarcha());
        txtCorreiaExtra.setText(mountainBike.getCorreiaExtra());
    }

    public void txtFieldLimpar() {
        txtCodFab.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCadencia.setText("");
        txtVelo.setText("");
        txtMarcha.setText("");
        txtCorreiaExtra.setText("");
    }

    public void txtFieldEditavel(boolean b) {
        txtCodFab.setEditable(b);
        txtMarca.setEditable(b);
        txtModelo.setEditable(b);
        txtCadencia.setEditable(b);
        txtVelo.setEditable(b);
        txtMarcha.setEditable(b);
        txtCorreiaExtra.setEditable(b);
    }
    
    public boolean permissaoEditar() {
        if (foiConsultado) return true;
        else return false;
    }

    public boolean permissaoConsultar() {
        if (txtPesquisa.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}