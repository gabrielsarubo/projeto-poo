import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * MBConsulta
 */
public class MBConsulta extends Banco implements ActionListener {

    static MBConsulta mBConsulta = new MBConsulta();
    static JFrame janMBConsulta = new JFrame("Consulta | Mountain Bikes");
    static JLabel lblPesquisa = new JLabel("Insira o codigo da bicicleta:");

    static JLabel lblCodFab = new JLabel("Codigo de Fabricacao....: "); static JLabel lblMarca = new JLabel("Marca...................: ");
    static JLabel lblModelo = new JLabel("Modelo..................: "); static JLabel lblCadencia = new JLabel("Cadecia.................: ");
    static JLabel lblVelo = new JLabel("Velocidade..............: "); static JLabel lblMarcha = new JLabel("Marcha..................: ");
    static JLabel lblCorreiaExtra = new JLabel("Correia Extra...........: "); 
    
    static JTextField txtPesquisa = new JTextField(10);
    static JButton btnVoltar = new JButton("Voltar");
    static JButton btnCancelar = new JButton("Cancelar");
    static JButton btnConsultar = new JButton("Consultar");

    public void abreJanMBConsulta() {
        janMBConsulta.setSize(500, 500);
        janMBConsulta.setLayout(new FlowLayout());
        janMBConsulta.setVisible(true);

        janMBConsulta.add(btnVoltar);
        janMBConsulta.add(lblPesquisa);
        janMBConsulta.add(txtPesquisa);
        janMBConsulta.add(btnConsultar);
        janMBConsulta.add(lblCodFab);
        janMBConsulta.add(lblMarca); janMBConsulta.add(lblModelo); janMBConsulta.add(lblCadencia);
        janMBConsulta.add(lblVelo); janMBConsulta.add(lblMarcha); janMBConsulta.add(lblCorreiaExtra);
        janMBConsulta.add(btnCancelar);

        btnVoltar.addActionListener(mBConsulta);
        btnConsultar.addActionListener(mBConsulta);
        btnCancelar.addActionListener(mBConsulta);

        janMBConsulta.setDefaultCloseOperation(janMBConsulta.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnVoltar)) {MB mB = new MB(); mB.janMB.setVisible(true); janMBConsulta.dispose();}
        if (obj.equals(btnConsultar)) {
            restauraRotulos();

            int codigoX = Integer.parseInt(txtPesquisa.getText());
            
            int index = armazem.consultar(mountainBike, codigoX);
            if (index == -1) {
                System.out.println("Bicicleta nao encontrada!");
                return;
            }

            mountainBike = armazem.getMountainBike(index);

            lblCodFab.setText(lblCodFab.getText() + mountainBike.getFabricacao().getCodFab());
            lblMarca.setText(lblMarca.getText() + mountainBike.getFabricacao().getMarca());
            lblModelo.setText(lblModelo.getText() + mountainBike.getModelo());
            lblCadencia.setText(lblCadencia.getText() + mountainBike.getCadencia());
            lblVelo.setText(lblVelo.getText() + mountainBike.getVelocidade());
            lblMarcha.setText(lblMarcha.getText() + mountainBike.getMarcha());
            lblCorreiaExtra.setText(lblCorreiaExtra.getText() + mountainBike.getCorreiaExtra());
        }
        // if (obj.equals(btnCancelar))
    }

    public void restauraRotulos() {
        lblCodFab.setText("Codigo de Fabricacao....: ");
        lblMarca.setText("Marca...................: ");
        lblModelo.setText("Modelo..................: ");
        lblCadencia.setText("Cadecia.................: ");
        lblVelo.setText("Velocidade..............: ");
        lblMarcha.setText("Marcha..................: ");
        lblCorreiaExtra.setText("Correia Extra...........: ");
    }
}