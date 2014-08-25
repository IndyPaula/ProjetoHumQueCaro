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
			fail("Cliente já cadastrado");
		}

		try {
			fachada.adicionaCliente("Zé da Roça", "12345678901");
		} catch (HumQueCaroException e) {
			fail("Cliente já cadastrado");
		}

		// TESTE PARA CLIENTE JÁ CADASTRADO ATRAVÉS DESTE TELEFONE
		try {
			fachada.adicionaCliente("Mariquinha", "12345678901");
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
	public void testAlteraCliente() {
		try {
			fachada.alteraCliente("11111111111", "nome", "Hugo");
			assertEquals("11111111111, Hugo",
					fachada.buscaCliente("11111111111"));
		} catch (HumQueCaroException e) {
			fail("Cliente não cadastrado");
		}

		try {
			fachada.alteraCliente("11111111111", "telefone", "11111111110");
			assertEquals("11111111110, Hugo",
					fachada.buscaCliente("11111111110"));
		} catch (HumQueCaroException e) {
			fail("Cliente não cadastrado");
		}

		try {
			fachada.alteraCliente("11111111111", "telefone", "00000000000");
			fail("Cliente não cadastrado");
		} catch (HumQueCaroException e) {
		}
	}

}
