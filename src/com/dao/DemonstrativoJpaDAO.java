/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Demonstrativo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class DemonstrativoJpaDAO {
  private static DemonstrativoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static DemonstrativoJpaDAO getInstance(){
    	if (instance == null){
    		instance = new DemonstrativoJpaDAO();
        }
    	return instance;
    }

    public DemonstrativoJpaDAO() {
    	entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TratativaPU");
        if (entityManager == null) {
        	entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Demonstrativo getById(final int id) {
    	return entityManager.find(Demonstrativo.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Demonstrativo> findAll() {
    	return entityManager.createQuery("FROM " + Demonstrativo.class.getName()).getResultList();
    }

    public void persist(Demonstrativo demonstrativo) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.persist(demonstrativo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Demonstrativo demonstrativo) {
    	try {
    		entityManager.getTransaction().begin();
            entityManager.merge(demonstrativo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Demonstrativo demonstrativo) {
    	try {
    		entityManager.getTransaction().begin();
            demonstrativo = entityManager.find(Demonstrativo.class, demonstrativo.getId());
            entityManager.remove(demonstrativo);
            entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   public void removeById(final int id) {
        try {
            Demonstrativo erroLinha = getById(id);
            remove(erroLinha);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Demonstrativo> findByPedido(String pedido) {
        try {
            Query query = entityManager.createQuery("from Demonstrativo e where e.pedido = :pedido");
            query.setParameter("pedido", pedido);
            List<Demonstrativo> venda = query.getResultList();
            return venda;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public List<Demonstrativo> findByData(String data) {
        try {
            Query query = entityManager.createQuery("from Demonstrativo e where e.data = :data");
            query.setParameter("data", data);
            List<Demonstrativo> venda = query.getResultList();
            return venda;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
     
        public List<Demonstrativo> findByCPD(String data, String impressora) {
        try {
            Query query = entityManager.createQuery("from Demonstrativo e where e.data = :data and e.impressora =:impressora");
            query.setParameter("data", data);
            query.setParameter("impressora", impressora);
            List<Demonstrativo> venda = query.getResultList();
            return venda;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
     
   
      public List<Demonstrativo> findByMes(String mes) {
        try {
            Query query = entityManager.createQuery("from Demonstrativo e where e.mes = :mes");
            query.setParameter("mes", mes);
            List<Demonstrativo> venda = query.getResultList();
            return venda;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
}
