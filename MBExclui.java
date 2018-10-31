import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * MBExclui
 */
public class MBExclui extends Banco implements ActionListener {

    static MBExclui mBExclui = new MBExclui();
    static JFrame janMBExclui = new JFrame("Exclui | Mountain Bikes");
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
    static JButton btnExcluir = new JButton("Excluir");

    static int index = -1;
    static boolean permissaoExcluir = false;
    
    public void abreJanMBExclui() {
        janMBExclui.setSize(500, 500);
        janMBExclui.setLayout(new FlowLayout());
        janMBExclui.setVisible(true);

        janMBExclui.add(btnVoltar);
        janMBExclui.add(lblPesquisa);
        janMBExclui.add(txtPesquisa);
        janMBExclui.add(btnConsultar);

        janMBExclui.add(lblCodFab); janMBExclui.add(txtCodFab);
        janMBExclui.add(lblMarca); janMBExclui.add(txtMarca);
        janMBExclui.add(lblModelo); janMBExclui.add(txtModelo);
        janMBExclui.add(lblCadencia); janMBExclui.add(txtCadencia);
        janMBExclui.add(lblVelo); janMBExclui.add(txtVelo);
        janMBExclui.add(lblMarcha); janMBExclui.add(txtMarcha);
        janMBExclui.add(lblCorreiaExtra); janMBExclui.add(txtCorreiaExtra);

        janMBExclui.add(btnExcluir);
        janMBExclui.add(btnCancelar);

        entradaEditavel(false);

        btnVoltar.addActionListener(mBExclui);
        btnConsultar.addActionListener(mBExclui);
        btnCancelar.addActionListener(mBExclui);
        btnExcluir.addActionListener(mBExclui);

        janMBExclui.setDefaultCloseOperation(janMBExclui.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnVoltar)) {MB mB = new MB(); mB.janMB.setVisible(true); janMBExclui.dispose();}
        if (obj.equals(btnConsultar)) {
            int codigoX = Integer.parseInt(txtPesquisa.getText());
            
            index = armazem.consultar(mountainBike, codigoX);
            if (index == -1) {
                System.out.println("Bicicleta nao encontrada!");
                permissaoExcluir = false;
                return;
            }

            mountainBike = armazem.getMountainBike(index);
            setaEntradas();

            permissaoExcluir = true;
        }
        if (obj.equals(btnExcluir)) {
            if (permissaoExcluir == true) {
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que gostaria de excluir esta bicicleta?", "Confirmar Exclusao", JOptionPane.YES_NO_CANCEL_OPTION);
                if (opcao == 0) {
                    armazem.excluir(mountainBike, index);
                    JOptionPane.showMessageDialog(null, "A bicicleta foi excluida com sucesso!");
                }
                else if (opcao == 1) JOptionPane.showMessageDialog(null, "A operacao foi cancelada!");
                else if (opcao == 2) JOptionPane.showMessageDialog(null, "A operacao foi cancelada!");
            } else {
                System.out.println("Para excluir e' necessario consultar uma bicicleta primeiro!");                
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