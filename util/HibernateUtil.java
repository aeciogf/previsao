package previsao.util;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	@Inject
	private SessionFactory fabricaSessoes;
	
	/**
	 * Método usado para obter a sessão atual.
	 * 
	 * @return
	 * @throws HibernateException
	 */
	@Produces
	public Session getNovaSessao() throws HibernateException {
    	return fabricaSessoes.openSession();
    }
	
	public void fecharSessao(@Disposes Session sessao) {
		sessao.close();
	}

}
