package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

public class TestProduto {

	public Fachada fachada = new Fachada();

	@Test
	public void testAddProduto() {
		try {
			assertEquals(true, fachada.adicionaProduto("p1", "01", "fab1"));
		} catch (HumQueCaroException e) {
			fail("Produto não adicionado");
		}

		try {
			assertEquals(true, fachada.adicionaProduto("p2", "02", "fab2"));
		} catch (HumQueCaroException e) {
			fail("Produto não adicionado");
		}

		try {
			assertEquals(true,
					fachada.adicionaProduto("Produto3", "03", "Fabricante3"));
		} catch (HumQueCaroException e) {
			fail("Produto não adicionado");
		}
	}

	/**
	 * TESTES PARA ATRIBUTOS INVÁLIDOS E PRODUTOS COM MESMO CÓDIGO JÁ
	 * CADASTRADOS.
	 */
	@Test
	public void testAddProdutoInvalido() {
		try {
			fachada.adicionaProduto("", "02", "fab2");
			fail("Campo nome do produto invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaProduto(null, "02", "fab2");
			fail("Campo nome do produto invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaProduto("NomeProduto", "", "fab2");
			fail("Campo codigo invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaProduto("NomeProduto", null, "fab2");
			fail("Campo codigo invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaProduto("NomeProduto", "CodigoProd", "");
			fail("Campo Fabricante invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaProduto("NomeProduto", "CodigoProd", null);
			fail("Campo Fabricante invalido");
		} catch (HumQueCaroException e) {
		}

		// PRODUTOS JÁ CADASTRADOS ANTERIORMENTE (MESMO CÓDIGO)
		try {
			assertEquals(false,
					fachada.adicionaProduto("NomeProduto", "01", "fabricante"));
		} catch (HumQueCaroException e) {
		}

		try {
			assertEquals(false, fachada.adicionaProduto("Pro", "02", "Fab"));
		} catch (HumQueCaroException e) {
		}
	}

	@Test
	public void testBuscaProduto() {
		// TODO a mensagem dentro do fail não influencia o que vem da Exception
		// Deste modo não é feita a comparação de mensagens de erro. Ainda
		// assim, modifiquei para a mensagem que você espera
		try {
			fachada.buscaProduto("");
			fail("Campo codigo de identificacao invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.buscaProduto(null);
			fail("Campo codigo de identificacao invalido");
		} catch (HumQueCaroException e) {
		}

		// (Luiz) TODO Por que este código é inválido?
		// (Deivid) Como dito anteriormente, a mensagem de erro dentro do fail
		// não é comparada com a mensagem de erro vinda da Exception, sendo
		// assim este próximo teste dá erro porque o codigo do produto que se
		// deseja buscar não foi previamente cadastrado no sistema
		try {
			fachada.buscaProduto("0001");
			fail("Produto não encontrado");
		} catch (HumQueCaroException e) {
		}

		// Teste sem as alterações de produto
		try {
			assertEquals("p1, 01, fab1", fachada.buscaProduto("01"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		try {
			assertEquals("Produto3, 03, Fabricante3",
					fachada.buscaProduto("03"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		try {
			assertEquals("p2, 02, fab2", fachada.buscaProduto("02"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

	}

	@Test
	public void testRemoveProduto() {
		try {
			assertEquals("p1, 01, fab1", fachada.buscaProduto("01"));
			fachada.removeProduto("01");
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		// TODO Removendo produto já removido anteriormente
		try {
			fachada.removeProduto("01");
			fail("Campo código de identificação inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			assertEquals("p2, 02, fab2", fachada.buscaProduto("02"));
			fachada.removeProduto("02");
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		// TODO Removendo produto já removido anteriormente
		try {
			fachada.removeProduto("02");
			fail("Campo código de identificação inválido");
		} catch (HumQueCaroException e) {
		}

		// TESTE DE ATRIBUTOS INVÁLIDOS

		try {
			fachada.removeProduto("");
			fail("Campo codigo de identificacao invalido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeProduto(null);
			fail("Campo codigo de identificacao invalido");
		} catch (HumQueCaroException e) {
		}

	}

}
