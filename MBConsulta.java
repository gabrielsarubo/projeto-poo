import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * MBConsulta
 */
public class MBConsulta extends Banco implements ActionListener {

    static MBConsulta mBConsulta = new MBConsulta();
    static JFrame janMBConsulta = new JFrame("Consulta | Mountain Bikes");
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

    static int index = -1;

    public void abreJanMBConsulta() {
        janMBConsulta.setSize(500, 500);
        janMBConsulta.setLayout(new FlowLayout());
        janMBConsulta.setVisible(true);

        janMBConsulta.add(btnVoltar);
        janMBConsulta.add(lblPesquisa);
        janMBConsulta.add(txtPesquisa);
        janMBConsulta.add(btnConsultar);
        
        janMBConsulta.add(lblCodFab); janMBConsulta.add(txtCodFab);
        janMBConsulta.add(lblMarca); janMBConsulta.add(txtMarca);
        janMBConsulta.add(lblModelo); janMBConsulta.add(txtModelo);
        janMBConsulta.add(lblCadencia); janMBConsulta.add(txtCadencia);
        janMBConsulta.add(lblVelo); janMBConsulta.add(txtVelo);
        janMBConsulta.add(lblMarcha); janMBConsulta.add(txtMarcha);
        janMBConsulta.add(lblCorreiaExtra); janMBConsulta.add(txtCorreiaExtra);

        janMBConsulta.add(btnCancelar);

        txtFieldEditavel(false);
        txtFieldLimpar();
        txtPesquisa.setText("");
        txtPesquisa.requestFocus();

        btnVoltar.addActionListener(mBConsulta);
        btnConsultar.addActionListener(mBConsulta);
        btnCancelar.addActionListener(mBConsulta);

        janMBConsulta.setDefaultCloseOperation(janMBConsulta.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnVoltar) || obj.equals(btnCancelar)) {MB mB = new MB(); mB.janMB.setVisible(true); janMBConsulta.dispose();}
        if (obj.equals(btnConsultar)) {
            if (permissaoConsultar()) {
                txtFieldLimpar();

                int codigoX = Integer.parseInt(txtPesquisa.getText());
                
                index = armazem.consultar(mountainBike, codigoX);
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Nao foi encontrada nenhuma bicicleta com o codigo informado.");
                    txtPesquisa.setText("");
                    txtPesquisa.requestFocus();
                    return;
                }

                mountainBike = armazem.getMountainBike(index);

                txtFieldPopular();
            }
            
            txtPesquisa.setText("");
            txtPesquisa.requestFocus();
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

    public boolean permissaoConsultar() {
        String campo = txtPesquisa.getText();
        
        if (campo.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}