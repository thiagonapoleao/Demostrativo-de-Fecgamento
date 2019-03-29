/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Laser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class LaserJpaDAO {
  private static LaserJpaDAO instance;
    protected EntityManager entityManager;
    
    public static LaserJpaDAO getInstance(){
    	if (instance == null){
    		instance = new LaserJpaDAO();
        }
    	return instance;
    }

    public LaserJpaDAO() {
    	entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TratativaPU");
        if (entityManager == null) {
        	entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Laser getById(final int id) {
    	return entityManager.find(Laser.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Laser> findAll() {
    	return entityManager.createQuery("FROM " + Laser.class.getName()).getResultList();
    }

    public void persist(Laser laser) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.persist(laser);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Laser laser) {
    	try {
    		entityManager.getTransaction().begin();
            entityManager.merge(laser);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Laser laser) {
    	try {
    		entityManager.getTransaction().begin();
            laser = entityManager.find(Laser.class, laser.getId());
            entityManager.remove(laser);
            entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   public void removeById(final int id) {
        try {
            Laser erroLinha = getById(id);
            remove(erroLinha);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Laser> findByPedido(String pedido) {
        try {
            Query query = entityManager.createQuery("from Laser e where e.pedido = :pedido");
            query.setParameter("pedido", pedido);
            List<Laser> venda = query.getResultList();
            return venda;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public List<Laser> findByData(String data) {
        try {
            Query query = entityManager.createQuery("from Laser e where e.data = :data");
            query.setParameter("data", data);
            List<Laser> venda = query.getResultList();
            return venda;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
     
        public List<Laser> findByCPD(String data, String estacao) {
        try {
            Query query = entityManager.createQuery("from Laser e where e.data = :data and e.estacao =:estacao");
            query.setParameter("data", data);
            query.setParameter("estacao", estacao);
            List<Laser> venda = query.getResultList();
            return venda;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
     
   
      public List<Laser> findByMes(String mes) {
        try {
            Query query = entityManager.createQuery("from Laser e where e.mes = :mes");
            query.setParameter("mes", mes);
            List<Laser> venda = query.getResultList();
            return venda;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
}
