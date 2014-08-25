package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

/*
 * Classe para testes JUnit. >>> EM ANDAMENTO <<<
 * 
 * @author Deivid Azevedo
 */
public class TestProjetoHumQueCaro {

	public Fachada fachada = new Fachada();

	@Test
	public void testAdicionaUsuario() {
		try {
			fachada.adicionaUsuario("email@email.com", "123", "Maria");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUsuarioInvalido() {
		try {
			fachada.adicionaUsuario("", "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario(null, "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "", "José");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", null, "José");
			fail("Campo senha inválido");
		} catch (HumQueCaroException e) {
		}

	}

}
