package previsao.dao;

import org.hibernate.HibernateException;

import previsao.dominio.DadosColetados;


public class TempoDAO extends PadraoDAO<DadosColetados> {

	public DadosColetados buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return super.buscarPorIdClasse(id, DadosColetados.class);
	}
	
	public String buscarTudo() throws HibernateException, IndexOutOfBoundsException{
		return super.buscarTudo(DadosColetados.class);
	}
}
