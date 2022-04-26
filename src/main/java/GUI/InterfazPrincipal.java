package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame{
    private JTextField apellidoC;
    private JTextField cedulaC;
    private JTextField nombreC;
    private JTextField correoC;
    private JButton seleccionarButton;
    private JButton modificarButton;
    private JButton crearButton;
    private JButton eliminarButton;
    private JTextField textField1;
    private JPanel Main;
    public JTable table1;
    public DefaultTableModel modelo = null;



    public InterfazPrincipal() {
        setContentPane(Main);
        setTitle("CRUD OrientDB");
        setSize(700, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
