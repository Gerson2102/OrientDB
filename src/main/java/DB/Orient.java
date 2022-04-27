package DB;

import GUI.InterfazPrincipal;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.iterator.ORecordIteratorClass;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Orient extends InterfazPrincipal{
    OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    ODatabaseSession db = orient.open("Clientes", "root", "root");

    // Generalizar la conexión a la base de datos ya que se ve muy mal....
    public void insert(String cedula, String nombre, String apellido,String correo){

        String consulta = "INSERT INTO Client SET cedula = ?, nombre = ?, apellido = ?, correo = ?";
        db.command(consulta,cedula,nombre,apellido,correo);
        orient.close();
    }





    public void actualizar(String cedula,String new_correo){

        String statement = "SELECT FROM Client WHERE cedula = ? ";
        OResultSet rs = db.query(statement, cedula);
        while(rs.hasNext()){
            rs.next().getElement().ifPresent(x->{
                x.setProperty("correo", new_correo);
                x.save();
            });
        }

        rs.close();
        orient.close();


    }
    public void eliminar(String dato){
        //OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        //ODatabaseSession db = orient.open("Clientes", "root", "root");
        String statement = "Delete FROM Client WHERE cedula = ?";

        OResultSet rs = db.command(statement, dato);

        rs.close();
        orient.close();

    }
    public boolean buscar(String cedula){
        String dato ="";
        String statement = "SELECT FROM Client WHERE cedula = ? ";
        OResultSet rs = db.query(statement, cedula);
        while(rs.hasNext()){
            OResult row = rs.next();
            dato = row.getProperty("nombre");
        }
        if (dato == ""){
            rs.close();
            return false;
        }
        else{
            rs.close();
            return true;
        }



    }


}
