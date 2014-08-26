package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

public class TestCliente {

	public Fachada fachada = new Fachada();

	@Test
	public void testAddCliente() {
		try {
			fachada.adicionaCliente("Mirna", "11111111111");
		} catch (HumQueCaroException e) {
			fail("Cliente j� cadastrado");
		}

		try {
			fachada.adicionaCliente("Z� da Ro�a", "12345678901");
		} catch (HumQueCaroException e) {
			fail("Cliente j� cadastrado");
		}

		// TESTE PARA CLIENTES J� CADASTRADOS ATRAV�S DO TELEFONE
		try {
			fachada.adicionaCliente("Mariquinha", "12345678901");
			fail("Cliente j� cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("Mariquinha", "11111111111");
			fail("Cliente j� cadastrado");
		} catch (HumQueCaroException e) {
		}
	}

	@Test
	public void testClienteInvalido() {
		try {
			fachada.adicionaCliente("", "1111111111");
			fail("Campo nome do cliente inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente(null, "1111111111");
			fail("Campo nome do cliente inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", "");
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", null);
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

		// NUMERO DE TELEFONE DO CLIENTE DEVE, OBRIGATORIAMENTE
		// CONTER 11 N�MEROS, AO CONTR�RIO DEVE LAN�AR EXCE��O
		try {
			fachada.adicionaCliente("NomeDoCliente", "1231231231");
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", "123123123123");
			fail("Campo telefone inv�lido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testAlteraCliente() {
		try {
			fachada.alteraCliente("11111111111", "nome", "Hugo");
			assertEquals("11111111111, Hugo",
					fachada.buscaCliente("11111111111"));
		} catch (HumQueCaroException e) {
			fail("Cliente n�o cadastrado");
		}

		try {
			fachada.alteraCliente("11111111111", "telefone", "11111111110");
			assertEquals("11111111110, Hugo",
					fachada.buscaCliente("11111111110"));
		} catch (HumQueCaroException e) {
			fail("Cliente n�o cadastrado");
		}

		try {
			fachada.alteraCliente("12345678901", "nome", "Jos� da Feira");
			assertEquals("12345678901, Jos� da Feira",
					fachada.buscaCliente("12345678901"));
		} catch (HumQueCaroException e) {
			fail("Cliente n�o cadastrado");
		}

		// TESTES PARA CLIENTES, ATRIBUTOS E NOVOS VALORES INV�LIDOS
		try {
			fachada.alteraCliente("11111111111", "telefone", "00000000000");
			fail("Cliente n�o cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraCliente("11111111111", "", "Ana");
			fail("Campo atributo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraCliente("11111111111", null, "Ana");
			fail("Campo atributo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraCliente("11111111111", "nome", "");
			fail("Campo novo valor inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraCliente("11111111111", "telefone", null);
			fail("Campo novo valor inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraCliente("11111111111", "nomes", "Luana");
			fail("Campo atributo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraCliente("11111111111", "telefonee", "12121212121");
			fail("Campo atributo inv�lido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testGetCliente() {

		try {
			assertEquals("11111111110, Hugo",
					fachada.buscaCliente("11111111110"));
		} catch (HumQueCaroException e) {
			fail("Cliente n�o encontrado");
		}

		try {
			assertEquals("12345678901, Jos� da Feira",
					fachada.buscaCliente("12345678901"));
		} catch (HumQueCaroException e) {
			fail("Cliente n�o encontrado");
		}

	}

	@Test
	public void testRemoveCliente() {
		try {
			fachada.removeCliente("11111111111");
			fail("Cliente n�o cadastrado");
		} catch (HumQueCaroException e) {
		}

		// REMOVENDO CLIENTES J� REMOVIDOS E VALORES INV�LIDOS
		try {
			fachada.removeCliente("11111111111");
			fail("Cliente n�o cadastrado");
		} catch (HumQueCaroException e) {
		}

//		try {
//			fachada.removeCliente("12345678901");
//		} catch (HumQueCaroException e) {
//			fail("Cliente n�o cadastrado");
//		}
		
		try {
			fachada.removeCliente("");
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente(null);
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("123456789012");
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("1234567890");
			fail("Campo inv�lido");
		} catch (HumQueCaroException e) {
		}

	}

}
