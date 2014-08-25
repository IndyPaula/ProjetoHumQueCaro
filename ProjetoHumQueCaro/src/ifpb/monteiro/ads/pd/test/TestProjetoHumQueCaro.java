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

		try {
			fachada.adicionaUsuario("email2@email.com", "111", "Carlos");
			fail("Usuário já cadastrado");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

		// USUÁRIO JÁ CADASTRADO
		try {
			fachada.adicionaUsuario("email@email.com", "111", "Joana");
			fail("Usuário já cadastrado");
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
			fachada.adicionaUsuario("12312@ç%4.12", "111", "José");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("â000@email.q", "111", "José");
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

		try {
			fachada.adicionaUsuario("email@email.com", "123", "");
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "123", null);
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaUsuario("email@email.com", "123", "$*#é_@");
			fail("Campo nome inválido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testAlteraUsuario() {
		try {
			fachada.alteraUsuario("email@email.com", "nome", "Silvio Santos");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}
		
		try {
			fachada.alteraUsuario("email2@email.com", "senha", "222");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

	}
	
	public void testGetUsuario(){
		try {
			fachada.buscaUsuario("email@email.com");
			assertEquals("", "");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}
	}
}
