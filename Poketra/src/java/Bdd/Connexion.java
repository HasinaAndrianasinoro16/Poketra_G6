package Bdd;
import java.sql.*;
public class Connexion {
    public Connection connecte () {
         String url = "jdbc:postgresql://localhost:5432/stock";
        String user = "postgres";
        String password = "1762";
        Connection con = null;
         try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, password);
         }catch(Exception e){
             e.printStackTrace();
         }finally {
            try {
                if (con == null)
                    con.close();
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + ex.getMessage());
            }
    }
         return con ;
}
}