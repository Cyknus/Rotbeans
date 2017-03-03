/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.modelo;

import java.util.List;
import is.mapeo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Cygnus
 */
public class UserDAO {
    private SessionFactory factory;
    
    public void setSessionFactory(SessionFactory sess_fac) {
        this.factory = sess_fac;
    }
    
    public boolean save(User user) {
        boolean saved = false;

        Session sess_fac = factory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            sess_fac.persist(user);
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
        System.out.println("okva");
        return saved;
    }
    
    public void update(User user) {
        Session sess_fac = factory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            sess_fac.update(user);
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
    
    public void delete(User user) {
        Session sess_fac = factory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            sess_fac.delete(user);
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
    
    public User getByEmail(String email) {
        User user = null;

        Session sess_fac = factory.openSession();
        Transaction trans = null;
        
        try {
            trans = sess_fac.beginTransaction();
            String whereClause = " from User where correo = :email";
            Query query = sess_fac.createQuery(whereClause);
            query.setParameter("email", email);
            user = (User) query.uniqueResult();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace(); 
        } finally {
            sess_fac.close();
        }
        
        return user;
    }
    
    public List<User> getUsers() {
        List<User> users = null;

        Session sess_fac = factory.openSession();
        Transaction trans = null;

        try {
            trans = sess_fac.beginTransaction();
            String whereClause = " from user";
            Query query = sess_fac.createQuery(whereClause);
            users = query.list();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace(); 
        } finally {
            sess_fac.close();
        }
        
        return users;
    }
}
