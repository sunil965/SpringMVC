package com.bridgeit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgeit.model.UserRegistrationModel;

@Repository
@Component
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void save(UserRegistrationModel user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	@Override
	public boolean existEmail(String email) {
		Session session = sessionFactory.openSession();
		String sql = "from UserRegistrationModel u where  u.email=:email";
		Query query = session.createQuery(sql);
		query.setParameter("email", email);
		List<UserRegistrationModel> list = query.list();
		if (list.size() > 0) {
			session.close();
			return true;
		} else {
			session.close();
		}
		return false;
	}

	@Override
	public List getAllUsersList() {
		Session session = sessionFactory.openSession();
		List userList = session.createQuery("from UserRegistrationModel").list();
		session.close();
		return userList;
	}

	@Override
	public List getUserbyId(int id) {
		Session session = sessionFactory.openSession();
		String query = "from UserRegistrationModel where id=" + id;
		Query query1 = session.createQuery(query);
		List list = query1.list();
		return list;

	}

	@Override
	public void update(UserRegistrationModel u) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(u);
		/*String q = "update UserRegistrationModel set name ="+u.getName()+",email="+u.getEmail()+",contact="+u.getContact()+",password="+u.getPassword()+"where id="+u.getId();
		Query query = session.createQuery(q);
		query.executeUpdate();*/
		session.getTransaction().commit();
	}

}
