package ifpb.monteiro.ads.pd.main;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

public class Main {

	public static void main(String[] args) {
		Fachada fachada = new Fachada();
		try {
			fachada.adicionaUsuario("asdas", "123123", "sfgsfg");
		} catch (HumQueCaroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
