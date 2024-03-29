package previsao.dao;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import previsao.dominio.PadraoDominio;

public class PadraoDAO<T extends PadraoDominio> {
	
	
	@Inject
	private Session sessao;
	
	private Transaction transacao;
	
	public PadraoDAO() {
		
	}

	public boolean atualizar(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.merge(objeto);
		encerrarOperacao();
		return true;
	}
	
	public boolean inserir(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.persist(objeto);
		encerrarOperacao();
		return true;
	}
	
	public boolean remover(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.delete(objeto);
		encerrarOperacao();
		return true;
	}
	
	public T buscarPorIdClasse(long id, Class<T> classe) throws HibernateException, IndexOutOfBoundsException {
		
		iniciarOperacao();
		
		StringBuilder textoConsulta = new StringBuilder();
		textoConsulta.append("SELECT objeto FROM ");
		textoConsulta.append(classe.getSimpleName());
		textoConsulta.append(" objeto WHERE id = ");
		textoConsulta.append(id);
		
		Query consulta = (Query) sessao.createQuery(textoConsulta.toString());
		
		@SuppressWarnings("unchecked")
		T resultado = (T) consulta.uniqueResult();
		
		encerrarOperacao();
		
		return resultado;
	}	

	public String buscarTudo(Class<T> classe) throws HibernateException, IndexOutOfBoundsException {
		
		iniciarOperacao();
		
		@SuppressWarnings("unchecked")
		List<T> lista1 = sessao.createQuery("from Employee").list(); 
		
		String lista2 = lista1.toString();
		
		encerrarOperacao();
		
		return lista2;
	}	
	
	private void iniciarOperacao() {
		transacao = sessao.beginTransaction();
	}
	
	private void encerrarOperacao() {
		transacao.commit();
	}
}
