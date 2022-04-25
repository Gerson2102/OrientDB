import GUI.Interfaz;
import GUI.InterfazPrincipal;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class Test {

    public static void main(String[] args) {
//        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
//        ODatabaseSession db = orient.open("test", "admin", "root");
//
//        ODocument animal = new ODocument("Client");
//        animal.field("name", "GERSON");
//        animal.field("location", "Guácimo");
//        animal.save();
//
        //let's do something with this server!
//        db.close();
//        orient.close();

        InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
    }
}
