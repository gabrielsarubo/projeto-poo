import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * SistemaBike
 */
public class SistemaBike implements ActionListener{

    static SistemaBike sistemaBike = new SistemaBike();
    static JFrame janBemVindo = new JFrame("Bem-vindo");
    static JLabel lblTitulo = new JLabel("Bem-vindo ao sistema de bicicletas");
    static JLabel lblSubTitulo = new JLabel("Escolha uma das opcoes abaixo para comecar");
    static JButton btnEntrarMB = new JButton("Entrar em Mountain Bikes");
    static JButton btnEntrarEB = new JButton("Entrar em E-Bikes");
    static JButton btnSair = new JButton("Sair");

    public static void main(String[] args) {
        janBemVindo.setSize(500, 500);
        janBemVindo.setLayout(new FlowLayout());
        janBemVindo.setVisible(true);

        janBemVindo.add(lblTitulo);
        janBemVindo.add(lblSubTitulo);
        janBemVindo.add(btnEntrarMB);
        janBemVindo.add(btnEntrarEB);
        janBemVindo.add(btnSair);

        btnEntrarEB.addActionListener(sistemaBike);
        btnEntrarMB.addActionListener(sistemaBike);
        btnSair.addActionListener(sistemaBike);

        janBemVindo.setDefaultCloseOperation(janBemVindo.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(btnEntrarMB)) {MB mB = new MB(); mB.abreJanMB(); janBemVindo.setVisible(false);}
        if (obj.equals(btnEntrarEB)) {EB eB = new EB(); eB.abreJanEB(); janBemVindo.setVisible(false);}
        if (obj.equals(btnSair)) janBemVindo.dispose();
    }
}