package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;

public class GerenciadorCliente implements GerenciadorClienteIF {

	private FachadaBD cliDAO;

	public GerenciadorCliente() {
		cliDAO = new FachadaBD();
	}

	@Override
	public void adicionaCliente(String nome, String telefone)
			throws HumQueCaroException {
		if (buscaCliente(telefone) == null
				&& verificaAtributos(nome, telefone)) {
			cliDAO.addCliente(new Cliente(nome, telefone));
		}
	}

	public boolean verificaAtributos(String nome, String telefone)
			throws HumQueCaroException {
		if (nome == null || nome.equals("")) {
			throw new HumQueCaroException("Campo nome do cliente inválido");
		}
		if (telefone == null || telefone.equals("") || telefone.length() != 11) {
			throw new HumQueCaroException("Campo telefone inválido");
		}
		return true;

	}

	@Override
	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCliente(String telefone) throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente buscaCliente(String telefone) throws HumQueCaroException {
		return cliDAO.buscaCliente(telefone);
	}

}
