package ifpb.monteiro.ads.pd.validacao;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public class Validacao {
	
	public static void validaEntrada(String entrada, String message) throws HumQueCaroException{
		if (entrada == null || entrada.equals("")) {
			throw new HumQueCaroException(message);
		}
	}

}
