package com.netmind.dao;

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

}
