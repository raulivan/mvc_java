package modelomvc.controller;

import java.util.List;

import modelomvc.model.ContatoModel;

public class ContatoController {

	public boolean salvar(int id, String nome, String telefone) throws Exception {
		
		if(nome == null || nome.isEmpty())
			throw new Exception("Nome n�o informado");
		
		if(telefone == null || telefone.isEmpty())
			throw new Exception("Telefone n�o informado");
		
		ContatoModel contato = new ContatoModel(id, nome, telefone);
		
		if(contato.getId() == 0)
			contato.incluir();
		else
			contato.alterar();
		
		return true;
	}
	
	public boolean excluir(int id) throws Exception{
		
		ContatoModel c = ContatoModel.selecionar(id);
		if(c == null)
			throw new Exception("Registro n�o localizado!");
		c.excluir();
		
		return true;
	}
	
	public List<ContatoModel> selecionarTodos() throws Exception{
		return ContatoModel.selecionar();
	}

}
