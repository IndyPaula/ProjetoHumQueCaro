package ifpb.monteiro.ads.pd.beans;

public class Produto {
	
	String nome;
	String codigo;
	String fabricante;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCodigo() {
		return codigo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Produto produto = (Produto) obj;
		return produto.getCodigo().equals(getCodigo());
	}
}
