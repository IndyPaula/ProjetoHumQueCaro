package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;

public class GerenciadorUsuario implements GerenciadorUsuarioIF {
	FachadaBD fachadaBd;

	public GerenciadorUsuario() {
		fachadaBd = new FachadaBD();
	}

	@Override
	public void adicionaUsuario(String email, String senha, String nome)
			throws HumQueCaroException {
		fachadaBd.addUsuario(new Usuario(email, senha,nome));
	}

	@Override
	public void alteraUsuario(String email, String atributo, String novoValor)
			throws HumQueCaroException {
		fachadaBd.alteraUsuario(email, atributo, novoValor);
	}

	@Override
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		// TODO Auto-generated method stub
		return null;
	}

}
