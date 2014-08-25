package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.DAO.ClienteDAO;
import ifpb.monteiro.ads.pd.DAO.DAO;
import ifpb.monteiro.ads.pd.DAO.ProdutoDAO;
import ifpb.monteiro.ads.pd.DAO.UsuarioDAO;
import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.enumerations.Dados;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;

public class FachadaBD implements FachadaBancoIF {

	private DAO<Cliente> cliDAO;
	private DAO<Produto> pDAO;
	private DAO<Usuario> pUsuario;

	public FachadaBD() {
		cliDAO = new ClienteDAO();
		pDAO = new ProdutoDAO();
		pUsuario = new UsuarioDAO();
	}

	@Override
	public void addUsuario(Usuario usuario) throws HumQueCaroException {
		pUsuario.adiciona(usuario);
	}

	@Override
	public void removeUsuario(Usuario usuario) throws HumQueCaroException {
		pUsuario.remove(usuario);
	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		return pUsuario.procura(email);
	}

	@Override
	public void alteraUsuario(Usuario usuario) throws HumQueCaroException {

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
		// TODO Exception com mensagem "Campo cï¿½digo invï¿½lido" caso seja
		// nulo, vazio ou nï¿½o exista.
		return pDAO.procura(codigo);
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		Produto produto = pDAO.procura(codigo);
		if (atributo.equals(Dados.NOME)) {
			produto.setNome(novoValor);
		} else if (atributo.equals(Dados.FABRICANTE)) {
			produto.setFabricante(novoValor);
		} else {
			throw new HumQueCaroException("Campo atributo invï¿½lido");
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
		if (telefone == null || telefone.equals("")) {
			throw new HumQueCaroException("Campo telefone inválido");
		}
		if (cliDAO.procura(telefone) == null) {
			throw new HumQueCaroException("Cliente não existe");
		}
		return cliDAO.procura(telefone);
	}

	@Override
	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

}
