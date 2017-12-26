package com.pankaj.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pankaj.dto.Address;
import com.pankaj.dto.UserDetails;

public class Endpoint {

	static Logger LOG = LoggerFactory.getLogger(Endpoint.class);

	public static void main(String[] args) {
		Session session = null;
		try {
			LOG.info("-------::: Service Started :::--------");
			session = HibernateSessionFactory.getSession();
			UserDetails user = new UserDetails();
			user.setUserId(1);
			user.setUserName("pjs130312");
			Address a1 = new Address("Aya nagar", "New Delhi", "Delhi", "110047");
			Address a2 = new Address("DLF Phase 3", "Gurgaon", "Haryana", "122002");
			user.getListOfAddresses().add(a1);
			user.getListOfAddresses().add(a2);
			Transaction txn = session.beginTransaction();
			session.save(user);
			txn.commit();
			session.clear();
			session=HibernateSessionFactory.getSession();
			user=null;
			user=(UserDetails)session.get(UserDetails.class, 1);
			System.out.println(user.getListOfAddresses().size());
			LOG.info("-------::: Service End :::--------");
		} catch (Exception e) {
			LOG.error("Some Internal Error !!", e);
		} finally {
			if (session.isOpen() || session != null) {
				session.close();
			}
		}
	}

}
