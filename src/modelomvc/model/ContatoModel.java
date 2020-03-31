package modelomvc.model;

import java.util.ArrayList;
import java.util.List;

public class ContatoModel {

	private int id;
	private String nome;
	private String telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public ContatoModel() {}
	
	public ContatoModel(int id, String nome, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	

	public boolean incluir() throws Exception{
		ContatoModel contato = this;
		System.out.println("Acessar o banco de dados e incluir");
		return true;
	}
	
	public boolean alterar() throws Exception {
		ContatoModel contato = this;
		System.out.println("Acessar o banco de dados e alterar");
		return true;
	}
	
	public boolean excluir() throws Exception {
		ContatoModel contato = this;
		System.out.println("Acessar o banco de dados e excluir");
		return true;
	}
	
	public static ContatoModel selecionar(int id) throws Exception {
		System.out.println("Acessar o banco de dados consultar os dados e retorna o registro");
		
		return new ContatoModel(10,"Raulivan","3799999999");
	}
	
	public static List<ContatoModel> selecionar() throws Exception{
		
		System.out.println("Acessar o banco de dados consultar os dados e retorna uma lista");
		List<ContatoModel> retorno = new ArrayList<ContatoModel>();
		retorno.add(new ContatoModel(10,"Raulivan","3799999999"));
		retorno.add(new ContatoModel(20,"Rodrigo","1234565678"));
		retorno.add(new ContatoModel(30,"Rodolfo","9999999999"));
		
		return retorno;
	}
}
