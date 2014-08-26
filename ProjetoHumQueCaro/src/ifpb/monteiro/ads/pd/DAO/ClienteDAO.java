package ifpb.monteiro.ads.pd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class ClienteDAO extends DAO<Cliente> {

	public ClienteDAO() {
	}
	
	@Override
	public void adiciona(Cliente cli) throws HumQueCaroException {
		try {
			abrirBanco();
			getStmt().executeUpdate(
					"INSERT INTO clientes (nome, telefone) " + "VALUES('"
							+ cli.getNome() + "','" + cli.getTelefone() + "')");
			fecharBanco();
		} catch (SQLException e) {
			throw new HumQueCaroException("Cliente não adicionado"
					+ e.getMessage());
		}

	}

	@Override
	public void remove(Cliente cli) throws HumQueCaroException {
		try {
			abrirBanco();
			getStmt().executeUpdate(
					"DELETE FROM clientes WHERE telefone like '" + cli.getTelefone()
					+ "'");
			fecharBanco();
		} catch (SQLException e) {
			throw new HumQueCaroException("Cliente não removido"
					+ e.getMessage());
		}
	}

	@Override
	public void altera(Cliente algo) throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente procura(String telefone) throws HumQueCaroException {
		try {
			abrirBanco();
			ResultSet rs;
			Cliente cli = null;
			rs = getStmt().executeQuery(
					"SELECT * FROM clientes WHERE telefone like '" + telefone
							+ "'");
			while (rs.next()) {
				String codigo = rs.getString("codigo_cliente");
				String fone = rs.getString("telefone");
				String nome = rs.getString("nome");
				cli = new Cliente(nome, fone);
				cli.setCodigo(codigo);
			}
			fecharBanco();
			return cli;
		} catch (SQLException e) {
			throw new HumQueCaroException("Cliente não encontrado"
					+ e.getMessage());
		}
	}

}
