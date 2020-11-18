/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author netanel
 */
public class Conexionmysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String usuario = "root";
        String clave = "";
        String url = "jdbc:mysql://localhost:3306/base?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexionmysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, clave);
            stmt = con.createStatement();
            stmt.execute("INSERT INTO usuarios VALUES(null, 'Carlos', '97865', 'carlos@mail.com')");
            rs = stmt.executeQuery("SELECT * from usuarios");
            rs.next();
            do {
                System.out.println(rs.getString("id")+" Nombre: "+rs.getString("nombre")+" Contraseña: "+rs.getString("password")+" Email: "+rs.getString("email"));
            } while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(Conexionmysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
