package util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;



public class ConnectionFactory {
public static String PATH = "jdbc:postgresql://localhost:1234/superdev-db";
public static String USER = "postgres";
    public static String PASSWORD =  "joaovitor14";

    //metodo que retorna conexão estabelecida com o banco de dados
    public static Connection getConnection() throws  Exception{
        try {
         //carregar o driver do postgresql
         Class.forName("org.postgresql.Driver");
         return DriverManager.getConnection(PATH, USER , PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
            // throw new Exception(e.getMessage());
        }
    }
public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
}
public static  void closeConnection (Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
}
    public static  void closeConnection (Connection conn) throws Exception {
        close(conn, null, null);
    }

    private  static  void close (Connection conn, Statement stmt, ResultSet rs) throws Exception{
        try {
            if( rs!= null){
                rs.close();
            }
            if( stmt!= null){
                stmt.close();
            }
            if( conn!= null){
                conn.close();
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
