package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class ProdutoDAO extends DAO<Produto>{

	@Override
	public void adiciona(Produto algo) throws HumQueCaroException{
		try {
			abrirBanco();
			getStmt().executeUpdate("INSERT INTO produtos (codigo_produtos, codigo, nome, fabricante) VALUES ('"
					+ algo.getCodigo()
					+ "', '"
					+ algo.getNome()
					+ "', '"
					+ algo.getFabricante()
					+ "' )");
			fecharBanco();
		} catch (Exception e) {
			throw new HumQueCaroException("Erro no adciona de Produto " + e.getMessage());
		}
	}

	@Override
	public void remove(Produto algo) throws HumQueCaroException{
		try {
			procura(algo.getCodigo());
			abrirBanco();
			getStmt().execute("DELETE FROM produtos WHERE codigo = '"
					+ algo.getCodigo()
					+ "' ");
			fecharBanco();
		} catch (HumQueCaroException e) {
			throw new HumQueCaroException(e.getMessage());
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
		try {
			Produto produto = null;
			abrirBanco();
			ResultSet rSet = getStmt().executeQuery("SELECT * FROM produtos WHERE codigo = '"
					+ algo
					+ "' ");
			if (rSet.next()) {
				produto = new Produto(rSet.getString("nome"), rSet.getString("codigo"), rSet.getString("fabricante"));
				produto.setCodigoProduto(rSet.getInt("codigo_produtos"));
			} else {
				throw new HumQueCaroException("Campo codigo de identificacao invalido");
			}
			fecharBanco();
			return produto;
		} catch (SQLException e) {
			throw new HumQueCaroException("Erro no procura de Produto " + e.getMessage());
		}
	}

}
