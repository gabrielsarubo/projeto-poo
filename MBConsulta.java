import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * MBConsulta
 */
public class MBConsulta extends Banco implements ActionListener {

    static MBConsulta mBConsulta = new MBConsulta();
    static JFrame janMBConsulta = new JFrame("Consulta | Mountain Bikes");
    static JButton btnVoltar = new JButton("Voltar");
    static JButton btnCancelar = new JButton("Cancelar");
    static JButton btnConsultar = new JButton("Consultar");

    public void abreJanMBConsulta() {
        janMBConsulta.setSize(500, 500);
        janMBConsulta.setLayout(new FlowLayout());
        janMBConsulta.setVisible(true);

        janMBConsulta.add(btnVoltar);
        janMBConsulta.add(btnConsultar);
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
            System.out.println("btnConsultar");
            armazem.imprimir(mountainBike, 0);
            armazem.imprimir(mountainBike, 1);
        }
        // if (obj.equals(btnCancelar))
    }
}