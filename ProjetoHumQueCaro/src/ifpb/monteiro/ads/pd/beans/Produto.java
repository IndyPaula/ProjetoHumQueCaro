package ifpb.monteiro.ads.pd.beans;

public class Produto {
	
	private String nome;
	private String codigo;
	private String fabricante;
	
	public static final String ATRIBUTO_NOME = "nome";
	public static final String ATRIBUTO_FABRICANTE = "fabricante";
	
	public Produto(String nome, String codigo, String fabricante) {
		this.nome = nome;
		this.codigo = codigo;
		this.fabricante = fabricante;
	}
	
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
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
