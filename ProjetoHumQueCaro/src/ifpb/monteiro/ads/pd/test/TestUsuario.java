package ifpb.monteiro.ads.pd.test;

import static org.junit.Assert.*;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;

import org.junit.Test;

/*
 * Classe para testes do Usuário:
 * Adicionar, Alterar, Remover e Buscar. 
 * 
 * >>> EM ANDAMENTO <<<
 * 
 * @author Deivid Azevedo
 */
public class TestUsuario {

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
			fail("Usuário não encontrado");
		}

		try {
			fachada.alteraUsuario("email2@email.com", "senha", "222");
		} catch (HumQueCaroException e) {
			fail("Usuário não encontrado");
		}

		// TESTES DE ERRO PARA ATRIBUTOS/NOVOS VALORES INVÁLIDOS
		try {
			fachada.alteraUsuario("email2@email.com", "nome", "222");
			fail("Campo novo valor inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraUsuario("email2@email.com", "nome", "#éç$jo");
			fail("Campo novo valor inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraUsuario("email2@email.com", "senhaa", "222");
			fail("Campo atributo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraUsuario("email2@email.com", "nomee", "Zé da Feira");
			fail("Campo atributo inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.alteraUsuario("emaill@email.com", "nome", "nome");
			fail("Usuário não encontrado");
		} catch (HumQueCaroException e) {
		}

	}

	@Test
	public void testGetUsuario() {
		try {
			assertEquals("email@email.com, Silvio Santos, 123",
					fachada.buscaUsuario("email@email.com"));
		} catch (HumQueCaroException e) {
			fail("Usuário não encontrado");
		}

		try {
			assertEquals("email2@email.com, Carlos, 222",
					fachada.buscaUsuario("email2@email.com"));
		} catch (HumQueCaroException e) {
			fail("Usuário não encontrado");
		}

		// TESTES PARA USUÁRIOS NÃO ENCONTRADOS
		try {
			fachada.buscaUsuario("emai2l@email.com");
			fail("Usuário não encontrado");
		} catch (HumQueCaroException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testRemoveUsuario() {
		try {
			fachada.removeUsuario("email@email.com", "123");
		} catch (HumQueCaroException e) {
			fail("Campo email inválido");
		}

		// REMOVER USUÁRIO JÁ REMOVIDO, NÃO CADASTRADO E/OU SENHA INCORRETA
		try {
			fachada.removeUsuario("email@email.com", "222");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("emaill@email.com", "222");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

		try {
			fachada.removeUsuario("email2@email.com", "111");
			fail("Campo email inválido");
		} catch (HumQueCaroException e) {
		}

	}
}
