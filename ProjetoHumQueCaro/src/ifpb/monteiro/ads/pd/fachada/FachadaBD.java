package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;

public class FachadaBD implements FachadaBancoIF{

	@Override
	public void addUsuario(Usuario usuario) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUsuario(Usuario usario) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraUsuario(String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduto(Produto produto) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduto(Produto produto) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCliente(Cliente cliente) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCliente(Cliente cliente) throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscaCliente(String telefone) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub
		
	}

}
