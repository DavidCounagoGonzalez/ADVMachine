
package baserelacionala;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
            
public class BaseRelacionalA {
    
    
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

    public static void main(String[] args) throws SQLException{
        BaseRelacionalA.insireProduto("p4", "chave", 11, "08/11/2022");
        BaseRelacionalA.listaProdutos();
        BaseRelacionalA.modificarProduto("p2", "descricion", "cravos");
        BaseRelacionalA.eliminaProduto("p4");
    }
    
    public static void insireProduto(String codigo, String desc, int prezo, String data) throws SQLException{
        Connection conn = BaseRelacionalA.Conexion();
        
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataformateada = LocalDate.parse(data, formato);
        Date dataf = Date.valueOf(dataformateada);
      
        String consulta= ("INSERT INTO  produtos(codigo, descricion, prezo, datac) VALUES (?,?,?,?)");
        
        PreparedStatement state = conn.prepareStatement(consulta);
        try{
           state.setString(1, codigo);
           state.setString(2, desc);
           state.setInt(3, prezo);
           state.setDate(4, dataf);
           
        state.executeUpdate();
        }
        catch(Exception e ){
            System.out.println("Existe un error al insertar los datos" + e);
        }
    }
    
    public static void listaProdutos() throws SQLException{
        Connection conn = BaseRelacionalA.Conexion();
        
        String muestra = ("SELECT * FROM  produtos");
        
        Statement st = conn.createStatement();
        try{
            java.sql.ResultSet resultado= st.executeQuery(muestra);

            while(resultado.next()){
                System.out.println(resultado.getString(1));
                System.out.println(resultado.getString(2));
                System.out.println(resultado.getString(3));
                System.out.println(resultado.getString(4));
            }
        }
        catch(Exception e){
            System.out.println("Error ao mostarra a lista" + e);
        }
        
        
        
    }
    
    public static void modificarProduto(String codMod, String campo, String dato) throws SQLException{
        Connection conn = BaseRelacionalA.Conexion();
        
        String consul = ("UPDATE produtos SET "+ campo +" = ? WHERE codigo=?");
        
        PreparedStatement st = conn.prepareStatement(consul);
        
        try{
            st.setString(1, dato);
            st.setString(2, codMod);
            
            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }        
    }
    
    public static void eliminaProduto(String cod) throws SQLException{
        Connection conn = BaseRelacionalA.Conexion();
        
        String borrar = ("DELETE FROM produtos WHERE codigo = ?");
        
        PreparedStatement st = conn.prepareStatement(borrar);
        
        try{
            st.setString(1,cod);
            
            st.executeUpdate();
            
            System.out.println("Eliminada correctamente la fila con código " + cod);
        }
        catch(Exception e){
            System.out.println("Error ao eliminar a fila " + e);
        }
        
    }
    }
    

