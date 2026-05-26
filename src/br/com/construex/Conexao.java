package br.com.construex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Configurações do seu banco de dados local MySQL
    // Dica: Ajuste o nome do banco após a barra '/' se o seu schema tiver outro nome
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/construex_db?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String USUARIO = "root"; 
    private static final String SENHA = "05071985Gi!"; // Insira a senha real do seu MySQL80

    /**
     * Método responsável por abrir e retornar a conexão com o banco de dados.
     * @return Connection
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection conectar() throws ClassNotFoundException, SQLException {
        // Carrega o driver de conexão do MySQL na memória
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Retorna a conexão estabelecida
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}