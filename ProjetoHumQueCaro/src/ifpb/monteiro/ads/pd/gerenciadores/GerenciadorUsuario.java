package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.enumerations.Dados;
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
		fachadaBd.addUsuario(new Usuario(email, senha, nome));
	}

	@Override
	public void alteraUsuario(String email, String atributo, String novoValor)
			throws HumQueCaroException {
		if(Dados.NOME.getNome().equals(atributo)){
			
		}else if (Dados.SENHA.getNome().equals(atributo)){
			
		}
	}

	@Override
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException {
		if (buscaUsuario(email).getSenha().equals(senha))
			fachadaBd.removeUsuario(new Usuario(email, senha));
		else
			throw new HumQueCaroException("Senha ou Email Invalido");
	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		return fachadaBd.buscaUsuario(email);
	}

}
