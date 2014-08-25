package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class GerenciadorProduto implements GerenciadorProdutoIF {
	
	Produto produto;
	
	public GerenciadorProduto() {
		produto = new Produto();
	}

	@Override
	public boolean adicionaProduto(String nomeProduto, String codigo,
			String fabricante) throws HumQueCaroException {
		return false;
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
	}

	@Override
	public void removeProduto(String codigo) throws HumQueCaroException {
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		return null;
	}
}
