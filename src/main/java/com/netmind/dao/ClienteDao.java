package com.netmind.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;



public class ClienteDao {
	
	
	Session session = null;
	
	public Cliente add(Cliente cliente) throws HibernateException {
		
		Transaction trns = null;
		session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			
		}catch(HibernateException e) {
			
			if(trns !=null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			session.flush();
			session.close();
		}
		return cliente;
		
	}
	
	public Cliente modify (Cliente cliente)throws HibernateException{
		Cliente clienteExtraido = null;
		Transaction trns = null;
		session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			clienteExtraido = (Cliente) session.get(Cliente.class, cliente.getIdCliente());
			clienteExtraido.setNombre(cliente.getNombre());
			clienteExtraido.setApellidos(cliente.getApellidos());
			clienteExtraido.setDni(cliente.getDni());
			
			session.save(clienteExtraido);
			session.getTransaction().commit();
			
		}catch(HibernateException e) {
			if(trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw e;
		}finally {
			session.flush();
			session.close();
		}
		return clienteExtraido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getAll() throws HibernateException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			clientes = session.createQuery("from Cliente").list();
			trns.commit();
			
		}catch(HibernateException e) {
			if (trns != null) {
				trns.rollback();
				throw e;
				}
				throw e;
			}
			finally {
			session.flush();
			session.close();
		}
		return clientes;
	}
	
	public Cliente getById(int idCliente) throws HibernateException{
		
		Cliente cliente = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {	
			String queryString = "from Cliente where idCliente = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", idCliente);
			cliente = (Cliente) query.uniqueResult();
		
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return cliente;
		
	}
	
	public int remove(int idCliente) throws HibernateException{
		
		Transaction trns =null;
		session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns = session.beginTransaction();
			Cliente cliente = (Cliente) session.load(Cliente.class, new Integer(idCliente));
			session.delete(cliente);
			session.getTransaction().commit();
		}catch (RuntimeException e) {
			if(trns!=null) {
				trns.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		
		
		return idCliente;
		
	}

}
