/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;


import com.bean.Dados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




/*
 *
 * @author Thiago Napoleão
 *
 */
public class DadosDAO {

      private static DadosDAO instance;
    protected EntityManager entityManager;

    public static DadosDAO getInstance() {
        if (instance == null) {
            instance = new DadosDAO();
        }
        return instance;
    }

    public DadosDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TratativaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Dados getById(final int id) {
        return entityManager.find(Dados.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Dados> findAll() {
        return entityManager.createQuery("FROM " + Dados.class.getName()).getResultList();
    }

    
       
    
    
   public void persist(Dados dados) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(dados);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Dados dados) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(dados);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Dados dados) {
        try {
            entityManager.getTransaction().begin();
            dados = entityManager.find(Dados.class, dados.getId());
            entityManager.remove(dados);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Dados dados = getById(id);
            remove(dados);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE dados").executeUpdate();
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
       
    
        public List<Dados> findByData(String data) {
        try {
            Query query = entityManager.createQuery("from Dados e where e.data = :data");
            query.setParameter("data", data);
            List<Dados> errosL = query.getResultList();
            return errosL;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    public List<Dados> findByEst(int est) {
        try {
            Query query = entityManager.createQuery("from Dados e where e.est = :est");
            query.setParameter("est", est);
            List<Dados> dados = query.getResultList();
            return dados;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
   
    }
   
    public List<Dados> findByDataCod(String data, int cod) {
        try {
        
            Query query = entityManager.createQuery("from Dados e where e.data = :data and e.cod = :cod");
            query.setParameter("data", data); 
            query.setParameter("cod", cod); 

            List<Dados> errosLinha = query.getResultList();
            return errosLinha;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
