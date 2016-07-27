/*
 * Programa Gerenciador de Campeonatos de Futebol - Versão 1.0
 * Desenvolvido para a disciplina de Gerência de Projeto de Software, do período
 * 2016.1, do curso de Engenharia de Software da Universidade Federal de Goiás
 * Desenvolvedor do software: Augusto César da Fonseca Falcão - Matrícula: 140614
 * Equipe do projeto: Augusto César, Igor Queiroz, Márcio Flores, Guilherme Alves,
 * Erik Raphael e Vinícius
 * Cliente: Prof.ª Mª Adriana

 */
package myconnection;

/**
 *
 * @author Augusto César da Fonseca Falcão
 */

//TODO author
import java.sql.Connection; //abrange a conexão com o banco de dados
import java.sql.DriverManager; //gerenciamento das configurações de conexão
import java.sql.SQLException; //exceções de conexão

public class MyConnection {
       public static String status = "Não conectou...";

    public MyConnection(){ // método construtor
    } 
    
    // método que inicia a conexão
    public static java.sql.Connection getMyConnection(){
        Connection conexao = null; //variável para instanciar o objeto conexão. É inicializada com valor null
        try{ //utilizado para verificar se a classe do driver está na biblioteca
            //nome do drive do banco
            String driverName = "com.mysql.jdbc.Driver"; 
            //retorna a classe correspondente ao drive name na biblioteca.
            Class.forName(driverName);
            
            //Configuração da conexão com banco
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "campeonato";        //nome do banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "Augustofalcao_19";      //sua senha de acesso

            //Realiza a conexao
            conexao = DriverManager.getConnection(url, username, password);
            
            //Testa a conexão//  
            if (conexao != null) {
                status = ("STATUS--->Conectado com sucesso!");
                System.out.println(status);
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
                System.out.println(status);
            }

            return conexao;
 
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            // Se o Driver não for encontrado retorna null plara a conexão
            return null;
            
        } catch (SQLException e) { //Conexão não realizada (p ex: senha errada)
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            // retorna null plara a conexão recusada
            return null;
        }
    } // Encerra método getMyConnection

    
    // Método que retorna o status da sua conexão
    public static String statusConection() {
        return status;
    }

    
    // Método que fecha a conexão
    public static boolean FecharConexao() {
        try {
            MyConnection.getMyConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
   // Método que reinicia sua conexão
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return MyConnection.getMyConnection();
    }           
            
}
    
    

