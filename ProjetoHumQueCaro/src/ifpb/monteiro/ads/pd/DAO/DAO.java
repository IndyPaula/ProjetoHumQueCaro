package ifpb.monteiro.ads.pd.DAO;

public interface DAO<T> {

	void adiciona(T algo);
	
	void remove (T algo);
	
	void altera (T algo);
	
	T procura (String algo);
	
}
