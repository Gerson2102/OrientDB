package GUI;

import javax.swing.*;

public class Interfaz extends JFrame{
    private JPanel MainView;
    private JButton btnCrear;
    private JButton btnMostrar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JLabel tituloPantalla;

    public Interfaz() {
        setContentPane(MainView);
        setTitle("CRUD OrientDB");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
