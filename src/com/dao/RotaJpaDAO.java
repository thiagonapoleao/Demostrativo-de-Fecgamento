/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import com.bean.Rota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 *
 * @author thiago.napoleao
 */
public class RotaJpaDAO {
    
   private static RotaJpaDAO instance;
    protected EntityManager entityManager;

    public static RotaJpaDAO getInstance() {
        if (instance == null) {
            instance = new RotaJpaDAO();
        }
        return instance;
    }

    public RotaJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TratativaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Rota getById(final int id) {
        return entityManager.find(Rota.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Rota> findAll() {
        return entityManager.createQuery("FROM " + Rota.class.getName()).getResultList();
    }

    
       
    
    
   public void persist(Rota rota) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rota);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Rota rota) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(rota);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Rota rota) {
        try {
            entityManager.getTransaction().begin();
            rota = entityManager.find(Rota.class, rota.getId());
            entityManager.remove(rota);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Rota rota = getById(id);
            remove(rota);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE rota").executeUpdate();
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
       
    
        public List<Rota> findByData(String data) {
        try {
            Query query = entityManager.createQuery("from Rota e where e.data = :data");
            query.setParameter("data", data);
            List<Rota> errosL = query.getResultList();
            return errosL;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    public List<Rota> findByEst(int est) {
        try {
            Query query = entityManager.createQuery("from Rota e where e.est = :est");
            query.setParameter("est", est);
            List<Rota> rota = query.getResultList();
            return rota;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
   
    }
   
    public List<Rota> findByDataCod(String data, int cod) {
        try {
        
            Query query = entityManager.createQuery("from Rota e where e.data = :data and e.cod = :cod");
            query.setParameter("data", data); 
            query.setParameter("cod", cod); 

            List<Rota> errosLinha = query.getResultList();
            return errosLinha;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
