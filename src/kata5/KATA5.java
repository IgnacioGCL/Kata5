

package kata5;

import java.io.*;
import java.sql.*;

public class KATA5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection conecta = DriverManager.getConnection("jdbc:sqlite:KATA5.DB");
        
        Statement state = conecta.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet resultado = state.executeQuery(query);
        while(resultado.next()){
            System.out.println("ID = " + resultado.getInt("ID"));
            System.out.println("NAME = " + resultado.getString("NAME"));
        }
        
        String nameFile="C:\\Users\\usuario\\Downloads\\emailsfilev1.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        String mail;
        while((mail = reader.readLine()) != null){
            if(!mail.contains("@")) continue;
            query = "INSERT INTO MAILS (MAIL) VALUES('" + mail + "')";
            state.executeUpdate(query);
        }
        conecta.commit();
        resultado.close();
        state.close();
        conecta.close();
    }
    
}
