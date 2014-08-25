package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaBancoIF;

public class GerenciadorProduto implements GerenciadorProdutoIF {
	
	Produto produto;
	FachadaBancoIF pDAO = new FachadaBD();
	
	public GerenciadorProduto() {
		produto = new Produto();
	}

	@Override
	public boolean adicionaProduto(String nomeProduto, String codigo,
			String fabricante) throws HumQueCaroException {
		produto.setNome(nomeProduto);
		produto.setCodigo(codigo);
		produto.setFabricante(fabricante);
		if (pDAO.buscaProduto(codigo) != null) {
			return false;
		}
		pDAO.addProduto(produto);
		return true;
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		//TODO <<NÂO TERMINADO>>
	}

	@Override
	public void removeProduto(String codigo) throws HumQueCaroException {
		produto.setCodigo(codigo);
		pDAO.removeProduto(produto);
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		return pDAO.buscaProduto(codigo);
	}
}
