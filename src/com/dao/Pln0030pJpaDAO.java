/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Pln0030p;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class Pln0030pJpaDAO {
    
 private static Pln0030pJpaDAO instance;
    protected EntityManager entityManager;

    public static Pln0030pJpaDAO getInstance() {
        if (instance == null) {
            instance = new Pln0030pJpaDAO();
        }
        return instance;
    }

    public Pln0030pJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TratativaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Pln0030p getById(final int id) {
        return entityManager.find(Pln0030p.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Pln0030p> findAll() {
        return entityManager.createQuery("FROM " + Pln0030p.class.getName()).getResultList();
    }

    
       
    
    
   public void persist(Pln0030p pln0030p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pln0030p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Pln0030p pln0030p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pln0030p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Pln0030p pln0030p) {
        try {
            entityManager.getTransaction().begin();
            pln0030p = entityManager.find(Pln0030p.class, pln0030p.getId());
            entityManager.remove(pln0030p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Pln0030p pln0030p = getById(id);
            remove(pln0030p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE pln0030p").executeUpdate();
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
       
    
        public List<Pln0030p> findByData(String data) {
        try {
            Query query = entityManager.createQuery("from Pln0030p e where e.data = :data");
            query.setParameter("data", data);
            List<Pln0030p> errosL = query.getResultList();
            return errosL;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    public List<Pln0030p> findByEst(int est) {
        try {
            Query query = entityManager.createQuery("from Pln0030p e where e.est = :est");
            query.setParameter("est", est);
            List<Pln0030p> pln0030p = query.getResultList();
            return pln0030p;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
   
    }
   
    public List<Pln0030p> findByDataCod(String data, int cod) {
        try {
        
            Query query = entityManager.createQuery("from Pln0030p e where e.data = :data and e.cod = :cod");
            query.setParameter("data", data); 
            query.setParameter("cod", cod); 

            List<Pln0030p> errosLinha = query.getResultList();
            return errosLinha;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

