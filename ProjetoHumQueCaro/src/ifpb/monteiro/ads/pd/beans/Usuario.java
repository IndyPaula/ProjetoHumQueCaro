package ifpb.monteiro.ads.pd.beans;

public class Usuario {
	private String email, senha, nome;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario(String email, String senha, String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

}
