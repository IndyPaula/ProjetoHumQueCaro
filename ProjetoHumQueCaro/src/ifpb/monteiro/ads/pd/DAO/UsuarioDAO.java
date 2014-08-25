package ifpb.monteiro.ads.pd.DAO;

import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class UsuarioDAO extends DAO<Usuario> {

	@Override
	public void adiciona(Usuario algo) throws HumQueCaroException {
		try {
			abrirBanco();
			getStmt().executeUpdate(
					"INSERT INTO usuarios (email, nome, senha) " + "VALUES('"
							+ algo.getEmail() + "','" + algo.getNome() + "','"
							+ algo.getSenha() + "')");
			fecharBanco();
		} catch (SQLException e) {
			throw new HumQueCaroException("Erro ao adicionar um usuario - "
					+ e.getMessage());
		}

	}

	@Override
	public void remove(Usuario algo) throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

	@Override
	public void altera(Usuario algo) throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario procura(String algo) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

}
