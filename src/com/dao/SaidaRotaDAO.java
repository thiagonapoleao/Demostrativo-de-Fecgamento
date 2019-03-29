/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.SaidaRota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class SaidaRotaDAO {
       
    
    private static SaidaRotaDAO instance;
    protected EntityManager entityManager;

    public static SaidaRotaDAO getInstance() {
        if (instance == null) {
            instance = new SaidaRotaDAO();
        }
        return instance;
    }

    public SaidaRotaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public SaidaRota getById(final int id) {
        return entityManager.find(SaidaRota.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<SaidaRota> findAll() {
        return entityManager.createQuery("FROM " + SaidaRota.class.getName()).getResultList();
    }

    
       
    
    
   public void persist(SaidaRota saidaRota) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(saidaRota);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(SaidaRota saidaRota) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(saidaRota);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(SaidaRota saidaRota) {
        try {
            entityManager.getTransaction().begin();
            saidaRota = entityManager.find(SaidaRota.class, saidaRota.getId());
            entityManager.remove(saidaRota);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            SaidaRota saidaRota = getById(id);
            remove(saidaRota);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE saidaRota").executeUpdate();
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
       
    
        public List<SaidaRota> findByData(String data) {
        try {
            entityManager.clear();
            Query query = entityManager.createQuery("from SaidaRota e where e.data = :data");
            query.setParameter("data", data);
            List<SaidaRota> saidarota = query.getResultList();
            return saidarota;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    public List<SaidaRota> findByEst(int est) {
        try {
            Query query = entityManager.createQuery("from SaidaRota e where e.est = :est");
            query.setParameter("est", est);
            List<SaidaRota> saidaRota = query.getResultList();
            return saidaRota;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
   
    }
   
    public List<SaidaRota> findByDataCod(String data, int cod) {
        try {
        
            Query query = entityManager.createQuery("from SaidaRota e where e.data = :data and e.cod = :cod");
            query.setParameter("data", data); 
            query.setParameter("cod", cod); 

            List<SaidaRota> saidarota = query.getResultList();
            return saidarota;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
