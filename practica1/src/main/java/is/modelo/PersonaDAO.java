/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.modelo;

import is.mapeo.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Cygnus
 */
public class PersonaDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sess_factory) {
        this.sessionFactory = sess_factory;
    }
    
    public boolean save(Persona persona) {
        
        boolean saved = false;
        
        Session sess_fac = sessionFactory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            sess_fac.persist(persona);
            trans.commit();
            saved = true;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            sess_fac.close();
        }
        
        return saved;
    }
    
    public void update(Persona persona) {
        Session sess_fac = sessionFactory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            sess_fac.update(persona);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            sess_fac.close();
        }
    }
    
    public void eliminar(Persona persona) {
        Session sess_fac = sessionFactory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            sess_fac.delete(persona);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            sess_fac.close();
        }
    }
    
    public Persona getByName(String name) {
        Session sess_fac = sessionFactory.openSession();
        Transaction trans = null;
        Persona persona = null;
        
        try {
            trans = sess_fac.beginTransaction();
            String whereClause = "from Persona where nombre = :name";
            Query query = sess_fac.createQuery(whereClause);
            query.setParameter("nombre", name);
            persona = (Persona) query.uniqueResult();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            sess_fac.close();
        }
        return persona;
    } 
}
