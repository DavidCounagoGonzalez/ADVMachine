
package baserelacionalb;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BaseRelacionalB {
    
    public static Connection Conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "oracle";
        String password = "oracle";
        String url = driver + host+ porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url,usuario,password);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        BaseRelacionalB.ActuaResult();
    }
    
    public static void ActuaResult() throws SQLException{
        Connection conn = BaseRelacionalB.Conexion();
        
        Statement stmt =conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                        ResultSet.CONCUR_UPDATABLE);
        
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");
        
        while(rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
        }
        
        rs.absolute(2);
        rs.updateInt("prezo", 8);
        rs.updateRow();
        
        rs.moveToInsertRow();
        rs.updateString("codigo", "p4");
        rs.updateString("descricion", "martelo");
        rs.updateInt("prezo", 20);
        rs.insertRow();
        rs.moveToCurrentRow();

        rs.last();
        rs.relative(-1);
        rs.deleteRow();
        
    }    
}
