package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;
import ifpb.monteiro.ads.pd.validacao.Validacao;

public class GerenciadorProduto implements GerenciadorProdutoIF {
	
	private FachadaBancoIF pDAO;
	
	public GerenciadorProduto() {
		pDAO = new FachadaBD();
	}

	@Override
	public boolean adicionaProduto(String nomeProduto, String codigo,
			String fabricante) throws HumQueCaroException {
		Validacao.validaEntrada(nomeProduto, "Campo nome do produto invalido");
		Validacao.validaEntrada(codigo, "Campo codigo invalido");
		Validacao.validaEntrada(fabricante, "Campo Fabricante invalido");
		try {
			pDAO.addProduto(new Produto(nomeProduto, codigo, fabricante));
		} catch (HumQueCaroException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		pDAO.alteraProduto(codigo, atributo, novoValor);
	}

	@Override
	public void removeProduto(String codigo) throws HumQueCaroException {
		pDAO.removeProduto(new Produto(null, codigo, null));
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		return pDAO.buscaProduto(codigo);
	}
}
