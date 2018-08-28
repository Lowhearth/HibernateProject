package com.netmind.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		assertNotNull(session.beginTransaction());
	}

}
