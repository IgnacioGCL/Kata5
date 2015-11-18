

package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conecta = DriverManager.getConnection("jdbc:sqlite:KATA5.DB");
        
        Statement state = conecta.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet resultado = state.executeQuery(query);
        while(resultado.next()){
            System.out.println("ID = " + resultado.getInt("ID"));
            System.out.println("NAME = " + resultado.getString("NAME"));
        }
    }
    
}
