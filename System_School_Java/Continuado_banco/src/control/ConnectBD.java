
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cadastros;
import sun.security.util.Password;

public class ConnectBD {
    private Connection connect;
    
    private final String URLBD = "jdbc:sqlserver://localhost:1433;databaseName=JAVA_DATABASE;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"; //3306
    
    private final String user = "Iumy";
    private final String password = "";

    // Metodo responsavel por abrir a conexão
    public ConnectBD() {
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //com.sqlserver.cj.jdbc.Driver
            connect = DriverManager.getConnection(URLBD, user, password); 
            
            System.out.println("Conectado com sucesso!");
            
        }catch (Exception e){
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        
        }
    }
    
    
    // Metodo responsavel por fechar a conexão
    public void desconnectBD() {
        try {
            if (connect != null && !connect.isClosed()) {
                
            
                connect.close(); 
            
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    // Metodo responsavel por inserir dados
    public boolean insetCadastros(String nome, String endereco, String sexo, String telefone, String num_cpf, String tipo_sangue, String fator_rh, String curso, String nome_emerg, String tel_emerg){
       
        try{
            PreparedStatement psInsert = connect.prepareStatement("INSERT INTO CADASTROS(nome, endereco, sexo, telefone, num_cpf, tipo_sangue, fator_rh, curso, nome_emerg, tel_emerg) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psInsert.setString(1, nome);
            psInsert.setString(2, endereco);
            psInsert.setString(3, sexo);
            psInsert.setString(4, telefone);
            psInsert.setString(5, num_cpf);
            psInsert.setString(6, tipo_sangue);
            psInsert.setString(7, fator_rh);
            psInsert.setString(8, curso);
            psInsert.setString(9, nome_emerg);
            psInsert.setString(10, tel_emerg);
            
           JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Cadastro inserido!");
             
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
        
    }
    
    
    // Metodo responsavel por alterar dados
     public boolean alterCadastros(String campo, String valor, int id){
        try{
            PreparedStatement psInsert = connect.prepareStatement("UPDATE CADASTROS SET " + campo + " = ? WHERE id = ?");
            psInsert.setString(1, valor);
            psInsert.setInt(2, id); 
            
            JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Informação Alterada!");
            return psInsert.execute();
            
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }
    
     
    // Metodo responsavel por deletar dados
    public boolean deleteCadastros(int id){
        try{
            PreparedStatement psDelete = connect.prepareStatement("DELETE FROM CADASTROS WHERE id = ?");
            psDelete.setInt(1,id);
            int rowsAffected = psDelete.executeUpdate();
            
            /*
            if (rowsAffected > 0) {
                PreparedStatement psUpdate = connect.prepareStatement("UPDATE CADASTRO SET id = id - 1 WHERE ID > ?");
                psUpdate.setInt(1, id);
                psUpdate.executeUpdate();
            }
            */
            JOptionPane.showMessageDialog(null, "Operação com Sucesso! Cadastro deletado!");
            return true;
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    
    // Metodo responsavel por mostrar os dados
    public boolean selectCadastros(){
        try{
            PreparedStatement psInsert = connect.prepareStatement("SELECT * FROM CADASTROS ORDER BY id");
            
            ResultSet rs;
            rs = psInsert.executeQuery();

            while (rs.next()) {
                String idd = rs.getString("id");
                String name = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                String num_cpf = rs.getString("num_cpf");
                String tipo_sangue = rs.getString("tipo_sangue");
                String fator_rh = rs.getString("fator_rh");
                String curso = rs.getString("curso");
                String nome_emerg = rs.getString("nome_emerg");
                String tel_emerg = rs.getString("tel_emerg");
                
                Cadastros cad = new Cadastros(idd, name, endereco, sexo, telefone, num_cpf, tipo_sangue, fator_rh, curso, nome_emerg, tel_emerg);
                
            }
            
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }
    
 
    // Metodo responsavel por autenticar os logins
     public boolean autenticaLogin(String email, String senha){
        try{
            boolean autentication = false;
            
            PreparedStatement psInsert = connect.prepareStatement("SELECT email, senha FROM LOGIN WHERE email = ? AND senha = ?");
            psInsert.setString(1, email);
            psInsert.setString(2, senha);
            
            ResultSet rs;
            rs = psInsert.executeQuery();
            
            if (rs.next()) {
                String loginBD = rs.getString("email");
                String senhaBD = rs.getString("senha");
                autentication = true;
            }
 
            psInsert.close(); 
            
            
            return autentication;
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }

}
