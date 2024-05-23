
package model;

//import dao.CadastrosDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Cadastros {
    
    private static DefaultTableModel modeloTabela;
    
    public static List<Cadastros> listaCadastros;  

    static {
        listaCadastros = new ArrayList<>();
    }
    
    private String id;
    private String nome;
    private String endereco;
    private String sexo;
    private String telefone;
    private String num_cpf;
    private String tipo_sangue;
    private String fator_rh;
    private String curso;
    private String nome_emerg;
    private String tel_emerg;

    public Cadastros(String id, String nome, String endereco, String sexo, String telefone, String num_cpf, String tipo_sangue, String fator_rh, String curso, String nome_emerg, String tel_emerg) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.telefone = telefone;
        this.num_cpf = num_cpf;
        this.tipo_sangue = tipo_sangue;
        this.fator_rh = fator_rh;
        this.curso = curso;
        this.nome_emerg = nome_emerg;
        this.tel_emerg = tel_emerg;
        
        listaCadastros.add(this);
    }
    
    public Cadastros(){
        
    }
      

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNum_cpf() {
        return num_cpf;
    }

    public void setNum_cpf(String num_cpf) {
        this.num_cpf = num_cpf;
    }

    public String getTipo_sangue() {
        return tipo_sangue;
    }

    public void setTipo_sangue(String tipo_sangue) {
        this.tipo_sangue = tipo_sangue;
    }

    public String getFator_rh() {
        return fator_rh;
    }

    public void setFator_rh(String fator_rh) {
        this.fator_rh = fator_rh;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome_emerg() {
        return nome_emerg;
    }

    public void setNome_emerg(String nome_emerg) {
        this.nome_emerg = nome_emerg;
    }

    public String getTel_emerg() {
        return tel_emerg;
    }

    public void setTel_emerg(String tel_emerg) {
        this.tel_emerg = tel_emerg;
    }

    public void setModeloTabela(DefaultTableModel modeloTabela) {
        
        Cadastros.modeloTabela = modeloTabela;
        
    }
    
     public void adicionarCads(Cadastros cad) {

        // Adicione os dados do produto ao modelo da tabela
        modeloTabela.addRow(new Object[]{
            cad.getId(), 
            cad.getNome(),
            cad.getEndereco(), 
            cad.getSexo(), 
            cad.getTelefone(),
            cad.getNum_cpf(),
            cad.getTipo_sangue(),
            cad.getFator_rh(),
            cad.getCurso(),
            cad.getTel_emerg(),
            cad.getNome_emerg()
        });      
    }
    
    
}
