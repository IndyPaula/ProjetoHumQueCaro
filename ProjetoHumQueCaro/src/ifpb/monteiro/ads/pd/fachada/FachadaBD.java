package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.DAO.DAO;
import ifpb.monteiro.ads.pd.DAO.ProdutoDAO;
import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;

public class FachadaBD implements FachadaBancoIF{
	
	private DAO<Produto> pDAO;

	public FachadaBD() {
		pDAO = new ProdutoDAO();
	}
	
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
		pDAO.adiciona(produto);
	}

	@Override
	public void removeProduto(Produto produto) throws HumQueCaroException {
		pDAO.remove(produto);
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		//TODO Exception com mensagem "Campo código inválido" caso seja nulo, vazio ou não exista.
		return pDAO.procura(codigo);
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		Produto produto = pDAO.procura(codigo);
		if (atributo.equals(Produto.ATRIBUTO_NOME)) {
			produto.setNome(novoValor);
		} else if (atributo.equals(Produto.ATRIBUTO_FABRICANTE)) {
			produto.setFabricante(novoValor);
		} else {
			throw new HumQueCaroException("Campo atributo inválido");
		}
		pDAO.altera(produto);
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
