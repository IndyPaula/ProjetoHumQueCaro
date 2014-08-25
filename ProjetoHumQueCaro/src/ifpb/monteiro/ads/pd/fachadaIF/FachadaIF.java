package ifpb.monteiro.ads.pd.fachadaIF;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;


/**
Instituto Federal de Educa��o, Ci�ncia e Tecnologia da Paraiba
* Curso ADS
* Projeto: HumQueCaro!!! 
* @author Prof�. Mirna Maia
* Disciplina: Processo de Desenvolvimento
*/

/**
* Essa Interface consiste na Fachada com as funcionalidades a serem
*  desenvolvidas da primeira sprint do projeto da disciplina de Processo 
*  de Desenvolvimento.  
*/


public interface FachadaIF {

	/**
	 * Esse m�todo cria um Usu�rio com os atributos passados como par�metros.
	 * 
	 * @param senha
	 *            A senha utilizada para acessar o sistema.
	 * @param nome
	 *            O nome do usu�rio.
	 *@param nome
	 *            Email do usu�rio.
	 * @throws HumQueCaroException
	 *             Caso email (!email@algumaCoisa.com), nome(Apenas letras) ou senha possuam valores inv�lidos, como nulo ou "",
	 *             devem ser apresentados as mensagens  <i>Campo email inv�lido <i>,<i>Campo nome
	 *             inv�lido</i> e <i>Campo senha inv�lida</i> respectivamente.
	 * 
	 */
	public void adicionaUsuario(String email, String senha, String nome)
			throws HumQueCaroException;
	
	/**
	 * Ajusta o atributo para o novo valor passado como par�metro. O us�ario poder� 
	 * alterar apenas o campo nome ou senha.
	 * 
	 * @param atributo
	 *
	 *            O atributo que deve ser alterado. Pode ser "senha" ou "nome".
	 * @param novoValor
	 *            O novo valor do atributo
	 * @throws HumQueCaroException
	 *             Caso o campo atributo seja nulo ou vazio ou diferente de
	 *             senha ou nome, deve ser apresentada a mensagem
	 *             "Campo atributo inv�lido". Caso atributo seja senha e o novo
	 *             valor sendo nulo ou vazio, deve ser apresentada a mensagem
	 *             "Campo novo valor inv�lido."
	 */
	public void alteraUsuario(String atributo, String novoValor)
			throws HumQueCaroException;

	/**
	 * Remove o usu�rio cujo cpf e senha foram passados como par�metro.
	 * 
	 * @param email
	 *            O email do usuario que deve ser removido.
	 * @param senha
	 *            A senha do usuario que deve ser removido.
	 * 			
	 * @throws HumQueCaroException
	 *             Caso o email seja invalido, deve ser apresentada a mensagem
	 *             "Campo email invalido". Caso a senha n�o seja a mesma que o usu�rio cadastrou, deve
	 *             ser apresentada a mensagem de erro "Opera��o inv�lida".
	 */
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException;

	/**
	 * Busca o usuario no banco.
	 * 
	 * @param email
	 * 		email do usuario.
	 * @return Usuario
	 *
	 * @throws HumQueCaroException
	 */
	public Usuario buscaUsuario(String email)
			throws HumQueCaroException;
	
	/**
	 * Esse m�todo adiciona produtos.
	 * 
	 * @param nomeProduto
	 *            nome do produto 
	 * @param codigo
	 *            Codigo de identifica��o do produto
	 * @param fabricante
	 *            Nome do fabricante do produto.
	 * @throws HumQueCaroException
	 *             Caso nomeProduto, c�digo ou o fabricante possuam valores inv�lidos, como nulo ou "",
	 *             devem ser apresentados as mensagens  <i>Campo nome do produto inv�lido <i>,<i>Campo codigo
	 *             inv�lido</i> e <i>Campo Fabricante inv�lido</i> respectivamente 
	 * @return <i>true</i> caso o produto tenha sido cadastrado com sucesso e
	 *         <i>false</i> caso o sistema j� possua um produto com o mesmo
	 *         codigo identificador.
	 */
	public boolean adicionaProduto(String nomeProduto, String codigo, String fabricante)
			throws HumQueCaroException;
	
	/**
	 * Ajusta o atributo para o novo valor passado como par�metro. Peder� altera 
	 * apenas os campos nome do Produto ou a empresa Fabricante.
	 * 
	 * @param atributo
	 *            O atributo que deve ser alterado. Pode ser "nomeProduto" ou "empresa".
	 * @param novoValor
	 *            O novo valor do atributo
	 * @param codigo
	 *            o codigo do produto
	 * @throws HumQueCaroException
	 *             Caso o campo atributo seja nulo ou vazio ou diferente de
	 *             nomeProduto ou fabricante, deve ser apresentada a mensagem
	 *             "Campo atributo inv�lido". "Caso o campo codigo seja nulo ou
	 * 		vazio ou nao exista, deve ser apresentada a mensagem
	 *             "Campo codigo inv�lido"
	 */
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException;

	/**
	 * Remove um produto cujo codigo de identifica��o.
	 * 
	 * @param codigo
	 *            O codigo do produto que deve ser removido.
	 * 
	 * @throws HumQueCaroException
	 *             Caso o codigo seja invalido, deve ser apresentada a mensagem
	 *             "Campo codigo de identifica��o invalido". 
	 *       
	 */
	public void removeProduto(String codigo)
			throws HumQueCaroException;
	
	/**
	 * Busca o produto no banco.
	 * 
	 * @param codigo
	 * 		Codigo de identifica��o do produto.
	 * @return Produto
	 * @throws HumQueCaroException
	 */
	public Produto buscaProduto(String codigo)
			throws HumQueCaroException;
	
	/**
	 * Esse m�todo adiciona Cliente.
	 * 
	 * @param nome
	 *            nome do Cliente 
	 * @param telefone
	 *            Numero do telefone do Cliente
	 * @throws HumQueCaroException
	 *             Caso nome, telefone possuam valores inv�lidos, como nulo ou "",
	 *             devem ser apresentados as mensagens  <i>Campo nome do Cliente inv�lido <i>,<i>Campo telefone
	 *             inv�lido</i> respectivamente 
	 */
	public void adicionaCliente(String nome, String telefone)
			throws HumQueCaroException;
	
	/**
	 * Ajusta o Cliente para o novo valor passado como par�metro. Peder� altera 
	 * apenas os campos nome do Cliente ou numero de telefone.
	 * 
	 * @param atributo
	 *            O atributo que deve ser alterado. Pode ser "telefone".
	 * @param novoValor
	 *            O novo valor do atributo
	 * @throws HumQueCaroException
	 *             Caso o campo atributo seja nulo ou vazio ou diferente de
	 *             nome , deve ser apresentada a mensagem
	 *             "Campo atributo inv�lido". 
	 */
	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException;

	/**
	 * Remove um Cliente cujo cpf foi passado como par�metro.
	 * 
	 * @param telefone
	 *            O telefone do cliente que deve ser removido.
	 * @throws HumQueCaroException
	 *             Caso o telefone seja invalido, deve ser apresentada a mensagem
	 *             "Campo telefone invalido".
	 */
	public void removeCliente(String telefone)
			throws HumQueCaroException;

	
	/**
	 * Busca o Cliente no banco.
	 * 
	 * @param telefone
	 * 		telefone fo Cliente.
	 * @return Cliente
	 * @throws HumQueCaroException
	 */
	public Cliente buscaCliente(String telefone)
			throws HumQueCaroException;
	

	
	
}


			
