package com.netmind.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDaoTest {
	
	private Cliente cliente;
	private ClienteDao clienteDao;
	private static int IDCLIENTE = 0;
	
	@Before
	public void setUp() throws Exception{
		
	}
	

	@Test
	public void test1Add() throws Exception {
		
		cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setNombre("Pepe");
		cliente.setApellidos("Soto");
		cliente.setDni("73223212z");
		clienteDao = new ClienteDao();
		Cliente expectedReturn = clienteDao.add(cliente);
		IDCLIENTE=expectedReturn.getIdCliente();
		assertTrue(expectedReturn !=null);
		assertTrue(IDCLIENTE > 0);
		
		
		
		
	}
	
	@Test
	public void test2Modify() throws Exception {
		cliente = new Cliente();
		cliente.setIdCliente(IDCLIENTE);
		cliente.setNombre("Neus");
		cliente.setApellidos("Lastone");
		cliente.setDni("73223212z");
		clienteDao = new ClienteDao();
		Cliente expectedReturn = clienteDao.modify(cliente);
		IDCLIENTE=expectedReturn.getIdCliente();
		assertTrue(expectedReturn !=null);
		assertTrue(expectedReturn.getNombre().equals("Neus"));
	}
	
	@Test
	public void test3GetAll() {
		clienteDao = new ClienteDao();
		List<Cliente> clientes = clienteDao.getAll();
		assertTrue(clientes.size()> 0);
		
		
	}
	
	@Test
	public void test4GetById() {
		clienteDao = new ClienteDao();
		Cliente clienteExtracted = clienteDao.getById(IDCLIENTE);
		assertTrue(clienteExtracted !=null);
		assertTrue(clienteExtracted.getApellidos().equals("Lastone"));
		
	}
	
	@Test
	public void test5RemoveClientbyId() {
		clienteDao = new ClienteDao();
		clienteDao.remove(IDCLIENTE);
		assertTrue(clienteDao.getById(IDCLIENTE) == null);
		
	}


}
