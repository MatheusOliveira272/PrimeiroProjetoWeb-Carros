package br.com.unincor.web.core;

import br.com.unincor.web.model.domain.Carro;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

/**
 *
 * @author alunos
 */
public class HibernateManager {

    private static Session session;

    public static Session getSession() {
        if (session == null) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            //se tiver mais classer só colocar .adde ir adicionadno
            Metadata md = new MetadataSources(ssr)
                    .addAnnotatedClass(Carro.class)
                    .getMetadataBuilder().build();
            SessionFactory sessionFactory = md.getSessionFactoryBuilder().build();
            session = sessionFactory.getCurrentSession();
        }
        return session;
    }

    public static EntityManager geEntityManager() {
        Session mySession = getSession();
        if (!mySession.getTransaction().isActive()) {
            mySession.beginTransaction();
        }
        return mySession.getEntityManagerFactory().createEntityManager();
    }

}
