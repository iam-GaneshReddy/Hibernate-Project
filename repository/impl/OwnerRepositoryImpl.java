package com.scaleupindia.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.repository.OwnerRepository;

public class OwnerRepositoryImpl implements OwnerRepository {
  private static SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();
	@Override
	public void saveOwner(Owner owner) {
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.persist(owner);
			transaction.commit();
		}
		
	}

	@Override
	public Owner findOwner(int ownerId) {
		try(Session session = sessionFactory.openSession()){
			//Transaction transaction = session.beginTransaction();
			Owner owner=session.find(Owner.class, ownerId);
			return owner;
			
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			Owner owner=session.find(Owner.class, ownerId);
			owner.setPetName(petName);
			session.merge(owner);
			transaction.commit();	
			
		}
		
	}

	@Override
	public void deleteOwner(int ownerId) {
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			Owner owner=session.find(Owner.class, ownerId);
			session.remove(owner);
			transaction.commit();	
		
	}
	}
}
