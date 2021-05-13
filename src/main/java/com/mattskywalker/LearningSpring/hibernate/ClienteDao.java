package com.mattskywalker.LearningSpring.hibernate;

import com.mattskywalker.LearningSpring.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClienteDao implements ClienteDaoInterface{


    public void Cadastrar(Cliente cliente){

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.persist(cliente);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public List<Cliente> Listar(){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            return em.createQuery("select a from Cliente a",
                    Cliente.class).getResultList();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            em.close();

        }
        return null;
    }

    public Cliente pesquisarCliente(Cliente cliente){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cliente a = null;

        try{
            tx.begin();
            a = em.find(Cliente.class,cliente.getCpf());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            em.close();
        }
        return a;

    }

    public void deletar(Cliente cliente){

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            Cliente a = pesquisarCliente(cliente);
            tx.begin();
            a = em.merge(a);
            em.remove(a);
            tx.commit();

        }catch(Exception e){

            e.printStackTrace();

        }finally {
            em.close();
        }
    }

}
