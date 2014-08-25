package ifpb.monteiro.ads.pd.DAO;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class ProdutoDAO extends DAO<Produto>{

	@Override
	public void adiciona(Produto algo) throws HumQueCaroException{
		// TODO Terminar
		try {
			abrirBanco();
			getStmt().executeUpdate("");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no adciona de Produto " + e.getMessage());
		}
		
	}

	@Override
	public void remove(Produto algo) throws HumQueCaroException{
		// TODO Terminar
		try {
			abrirBanco();
			getStmt().executeUpdate("");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no remove de Produto " + e.getMessage());
		}
	}

	@Override
	public void altera(Produto algo) throws HumQueCaroException{
		// TODO Terminar na próxima sprint.
		try {
			abrirBanco();
			getStmt().executeUpdate("");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no altera de Produto " + e.getMessage());
		}
	}

	@Override
	public Produto procura(String algo) throws HumQueCaroException{
		// TODO Terminar
		try {
			abrirBanco();
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no altera de Produto " + e.getMessage());
		}
		return null;
	}

}
