package entity;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBD {

    //Nome do User do mysql
    private static final String USERNAME = "root";

    //Senha do banco
    private static final String PASSWORD = "";

    //Caminho do banco ddde dados, porta, nomeBC
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/projetocrud";

    //Coneccao com BD
    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

//Criar coneccao com Bd
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }
    public static void main(String[] args) throws Exception {
        //Recuperar Coneccao
        Connection con = createConnectionToMySQL();

        //Testar se a conexao e nula
        if(con!=null){
            System.out.println("Conexao com Sucesso");
            con.close();
        }
    }
}

