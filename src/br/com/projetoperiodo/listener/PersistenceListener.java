package br.com.projetoperiodo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.projetoperiodo.util.fachada.Fachada;
import br.com.projetoperiodo.util.fachada.Persistencia;

/**
 * Application Lifecycle Listener implementation class PersistenceListener
 *
 */
public class PersistenceListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PersistenceListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	Fachada.destroyInstance();
        Persistencia.destroyInstance();
    }
	
}
