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

		try {
			assertEquals(false,
					fachada.adicionaProduto("NomeProduto", "01", "fabricante"));
		} catch (HumQueCaroException e) {
		}
	}
	
	//TODO Estes testes não eram para a próximo sprint?
	@Test
	public void testAlteraProduto() {
		
		try {
			fachada.alteraProduto("01", "nomeProduto", "Produto1");
			assertEquals("Produto1, 01, fab1", fachada.buscaProduto("01"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		try {
			fachada.alteraProduto("01", "empresa", "Empresa1");
			assertEquals("Produto1, 01, Empresa1", fachada.buscaProduto("01"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		try {
			fachada.alteraProduto("02", "nomeProduto", "Produto2");
			assertEquals("Produto2, 02, fab2", fachada.buscaProduto("02"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		try {
			fachada.alteraProduto("02", "empresa", "Empresa2");
			assertEquals("Produto2, 02, Empresa2", fachada.buscaProduto("02"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

	}

	//TODO Estes testes não eram para a próximo sprint
	@Test
	public void testAlteraProdutoAtributoInvalido() {

		try {
			fachada.alteraProduto("01", "empresaa", "Empresa2");
			fail("Campo atributo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("01", "nomeProoduto", "Prod");
			fail("Campo atributo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("01", "", "Empresa2");
			fail("Campo atributo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("02", null, "Empresa2");
			fail("Campo atributo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("", "nomeProduto", "produto");
			fail("Campo codigo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto(null, "nomeProduto", "produto1");
			fail("Campo codigo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("010", "nomeProduto", "produto");
			fail("Campo codigo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("1", "empresa", "Empresa2");
			fail("Campo codigo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraProduto("002", "empresa", "Empresa2");
			fail("Campo codigo inválido");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testBuscaProduto() {
		//TODO A mensagem esperado para esse tipo de erro é "Campo codigo de identificacao invalido"
		try {
			fachada.buscaProduto("");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.buscaProduto(null);
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}
		
		//TODO Por que este código é inválido?
		try {
			fachada.buscaProduto("0001");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}
		
		//TODO Estes 2 próximos códigos condizem com as mudaças no alteraProduto. Adcione outros
		// depois, pois esta sprint não conta com o alteraProduto.
		try {
			assertEquals("Produto1, 01, Empresa1", fachada.buscaProduto("01"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}
		
		try {
			assertEquals("Produto2, 02, Empresa2", fachada.buscaProduto("02"));
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

	}

	@Test
	public void testRemoveProduto() {
		//TODO Este código condiz com as mudaças no alteraProduto. Adcione outros
		// depois, pois esta sprint não conta com o alteraProduto.
		try {
			assertEquals("Produto1, 01, Empresa1", fachada.buscaProduto("01"));
			fachada.removeProduto("01");
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		//TODO Código que conta com o de cima.
		try {
			fachada.removeProduto("01");
			fail("Campo código de identificação inválido");
		} catch (HumQueCaroException e) {
		}

		//TODO Este código condiz com as mudaças no alteraProduto. Adcione outros
		// depois, pois esta sprint não conta com o alteraProduto.
		try {
			assertEquals("Produto2, 02, Empresa2", fachada.buscaProduto("02"));
			fachada.removeProduto("02");
		} catch (HumQueCaroException e) {
			fail("Produto não encontrado");
		}

		//TODO Código que conta com o de cima.
		try {
			fachada.removeProduto("02");
			fail("Campo código de identificação inválido");
		} catch (HumQueCaroException e) {
		}

		// TESTE DE ATRIBUTOS INVÁLIDOS

		//TODO A mensagem esperada para esse 2 tipos de erro que seguem é "Campo codigo de identificacao invalido"
		try {
			fachada.removeProduto("");
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeProduto(null);
			fail("Campo inválido");
		} catch (HumQueCaroException e) {
		}

	}

}
