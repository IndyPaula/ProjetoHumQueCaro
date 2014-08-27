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
			fachada.adicionaProduto("p1", "01", "fab1");
		} catch (HumQueCaroException e) {
			fail("Produto n�o adicionado");
		}

		try {
			fachada.adicionaProduto("p2", "02", "fab2");
		} catch (HumQueCaroException e) {
			fail("Produto n�o adicionado");
		}

		try {

			fachada.adicionaProduto("Produto3", "03", "Fabricante3");
		} catch (HumQueCaroException e) {
			fail("Produto n�o adicionado");
		}
	}

	/**
	 * TESTES PARA ATRIBUTOS INV�LIDOS E PRODUTOS COM MESMO C�DIGO J�
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

		// PRODUTOS J� CADASTRADOS ANTERIORMENTE (MESMO C�DIGO)
		try {

			fachada.adicionaProduto("NomeProduto", "01", "fabricante");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.adicionaProduto("Pro", "02", "Fab");
		} catch (HumQueCaroException e) {
		}
	}

	@Test
	public void testBuscaProduto() {
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

		try {
			fachada.buscaProduto("0001");
			fail("Produto n�o encontrado");
		} catch (HumQueCaroException e) {
		}

		try {
			assertEquals("p1, 01, fab1", fachada.buscaProduto("01"));
		} catch (HumQueCaroException e) {
			fail("Produto n�o encontrado");
		}

		try {
			assertEquals("Produto3, 03, Fabricante3",
					fachada.buscaProduto("03"));
		} catch (HumQueCaroException e) {
			fail("Produto n�o encontrado");
		}

		try {
			assertEquals("p2, 02, fab2", fachada.buscaProduto("02"));
		} catch (HumQueCaroException e) {
			fail("Produto n�o encontrado");
		}

	}

	@Test
	public void testRemoveProduto() {
		try {
			assertEquals("p1, 01, fab1", fachada.buscaProduto("01"));
			fachada.removeProduto("01");
		} catch (HumQueCaroException e) {
			fail("Produto n�o encontrado");
		}

		try {
			fachada.removeProduto("01");
			fail("Campo c�digo de identifica��o inv�lido");
		} catch (HumQueCaroException e) {
		}

		try {
			assertEquals("p2, 02, fab2", fachada.buscaProduto("02"));
			fachada.removeProduto("02");
		} catch (HumQueCaroException e) {
			fail("Produto n�o encontrado");
		}

		try {
			fachada.removeProduto("02");
			fail("Campo c�digo de identifica��o inv�lido");
		} catch (HumQueCaroException e) {
		}

		// TESTE DE ATRIBUTOS INV�LIDOS

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
