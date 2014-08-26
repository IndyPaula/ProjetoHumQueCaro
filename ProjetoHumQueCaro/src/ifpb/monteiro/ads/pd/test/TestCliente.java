package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

/*
 * Classe para testes de Clientes, cadastrados no sistema HumQueCaro.
 */
public class TestCliente {

	public Fachada fachada = new Fachada();

	@Test
	public void testAddCliente() {
		try {
			fachada.adicionaCliente("Mirna", "11111111111");
		} catch (HumQueCaroException e) {
			fail("Cliente já cadastrado");
		}

		try {
			fachada.adicionaCliente("Zé da Roça", "12345678901");
		} catch (HumQueCaroException e) {
			fail("Cliente já cadastrado");
		}

		// TESTE PARA CLIENTES JÁ CADASTRADOS ATRAVÉS DO TELEFONE
		try {
			fachada.adicionaCliente("Mariquinha", "12345678901");
			fail("Cliente já cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("Mariquinha", "11111111111");
			fail("Cliente já cadastrado");
		} catch (HumQueCaroException e) {
		}
	}

	@Test
	public void testClienteInvalido() {
		try {
			fachada.adicionaCliente("", "1111111111");
			fail("Campo nome do cliente inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente(null, "1111111111");
			fail("Campo nome do cliente inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", "");
			fail("Campo telefone inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", null);
			fail("Campo telefone inválido");
		} catch (HumQueCaroException e) {
		}

		// NUMERO DE TELEFONE DO CLIENTE DEVE, OBRIGATORIAMENTE
		// CONTER 11 NÚMEROS, AO CONTRÁRIO DEVE LANÇAR EXCEÇÃO
		try {
			fachada.adicionaCliente("NomeDoCliente", "1231231231");
			fail("Campo telefone inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaCliente("NomeDoCliente", "123123123123");
			fail("Campo telefone inválido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testGetCliente() {

		try {
			assertEquals("11111111111, Mirna",
					fachada.buscaCliente("11111111111").toString());
		} catch (HumQueCaroException e) {
			fail("Cliente não encontrado");
		}

		try {
			assertEquals("12345678901, Zé da Roça",
					fachada.buscaCliente("12345678901").toString());
		} catch (HumQueCaroException e) {
			fail("Cliente não encontrado");
		}

		try {
			fachada.buscaCliente("00000000000");
			fail("Cliente não encontrado");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testRemoveCliente() {
		// Removendo clientes cadastrados
		try {
			fachada.removeCliente("11111111111");
		} catch (HumQueCaroException e) {
			fail("Cliente não cadastrado");
		}

		try {
			fachada.removeCliente("12345678901");
		} catch (HumQueCaroException e) {
			fail("Cliente não cadastrado");
		}

		// REMOVENDO CLIENTES JÁ REMOVIDOS E VALORES INVÁLIDOS
		try {
			fachada.removeCliente("11111111111");
			fail("Cliente não cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("12345678901");
			fail("Cliente não cadastrado");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente(null);
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("123456789012");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeCliente("1234567890");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

	}

}