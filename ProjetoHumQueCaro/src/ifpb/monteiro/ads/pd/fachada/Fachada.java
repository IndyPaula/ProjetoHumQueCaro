package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;

public class Fachada implements FachadaIF {

	@Override
	public void adicionaUsuario(String email, String senha, String nome)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alteraUsuario(String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionaProduto(String nomeProduto, String codigo,
			String fabricante) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduto(String codigo) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionaCliente(String nome, String telefone)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
