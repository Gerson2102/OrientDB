package GUI;

import DB.Orient;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame{
    public JTextField apellidoC;
    public JTextField cedulaC;
    public JTextField nombreC;
    public JTextField correoC;
    private JButton seleccionarButton;
    private JButton modificarButton;
    private JButton crearButton;
    private JButton eliminarButton;
    private JTextField textField1;
    private  String dato;
    private JPanel Main;
    public JTable table1;
    public DefaultTableModel modelo = null;
    String cedula;
    String nombre;
    String apellido;
    String correo;



    public void data () {
        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        ODatabaseSession db = orient.open("Clientes", "root", "root");
        String[] Columnas = {"Cedula", "Nombre", "Apellido", "Correo"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(Columnas);
        table1.setModel(modelo);
        String statement = "SELECT * FROM Client";
        OResultSet rs = db.query(statement);
        while (rs.hasNext()) {
            OResult row = rs.next();
            cedula = row.getProperty("cedula");
            nombre = row.getProperty("nombre");
            apellido = row.getProperty("apellido");
            correo = row.getProperty("correo");
            add(modelo, cedula, nombre, apellido, correo);
        }
        rs.close();
        orient.close();
    }
    private void add(DefaultTableModel modelo, String cedula,String nombre, String apellido, String correo){
        Object[] datosFila = {cedula,nombre,apellido,correo};
        modelo.addRow(datosFila);
    }


    public void Interfaz() {
        setContentPane(Main);
        setTitle("CRUD OrientDB");

        setSize(700, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        modificarButton.setEnabled(false);
        eliminarButton.setEnabled(false);
        data();
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(cedulaC.getText().toString().equals("")) && !(nombreC.getText().toString().equals("")) &&
                        !(apellidoC.getText().toString().equals("")) && !(correoC.getText().toString().equals(""))) {
                    Orient conection = new Orient();
                    cedula = cedulaC.getText();
                    nombre = nombreC.getText();
                    apellido = apellidoC.getText();
                    correo = correoC.getText();
                    cedulaC.setText("");
                    nombreC.setText("");
                    apellidoC.setText("");
                    correoC.setText("");
                    conection.insert(cedula, nombre, apellido, correo);
                    data();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        });


        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(correoC.getText().toString().equals(""))){
                    cedulaC.setEnabled(true);
                    nombreC.setEnabled(true);
                    apellidoC.setEnabled(true);
                    modificarButton.setEnabled(false);
                    eliminarButton.setEnabled(false);
                    crearButton.setEnabled(true);
                    Orient conection = new Orient();
                    correo = correoC.getText();
                    correoC.setText("");
                    textField1.setText("");
                    conection.actualizar(dato,correo);
                    dato="";
                    data();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese el correo", "Información", JOptionPane.INFORMATION_MESSAGE);
                }




            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cedulaC.setEnabled(true);
                nombreC.setEnabled(true);
                apellidoC.setEnabled(true);
                modificarButton.setEnabled(false);
                eliminarButton.setEnabled(false);
                crearButton.setEnabled(true);
                Orient conection = new Orient();
                System.out.println(dato);
                conection.eliminar(dato);
                dato = "";
                data();


            }
        });
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Orient db = new Orient();
                dato = textField1.getText();


                boolean bool=db.buscar(dato);

                if (bool == false){
                    textField1.setText("");
                    JOptionPane.showMessageDialog(null, "Ha seleccionado un usuario que no existe", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    cedulaC.setEnabled(false);
                    nombreC.setEnabled(false);
                    apellidoC.setEnabled(false);
                    modificarButton.setEnabled(true);
                    eliminarButton.setEnabled(true);
                    crearButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Ha seleccionado el usuario" +" "+ dato, "Información", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        });
    }

    private void createUIComponents() {
    }
}
