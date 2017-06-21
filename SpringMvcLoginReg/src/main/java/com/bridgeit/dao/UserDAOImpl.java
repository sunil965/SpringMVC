package com.bridgeit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.model.UserRegistrationModel;

@Repository
//@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(UserRegistrationModel user) {
		/*Session session = sessionFactory.getCurrentSession();
		session.save(user);*/
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	@Override
	public boolean existEmail(String email) {
//		Session session = sessionFactory.getCurrentSession();
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
	public List<UserRegistrationModel> getAllUsersList() {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		List<UserRegistrationModel> userList = session.createQuery("from UserRegistrationModel").list();
		session.close();
		return userList;
	}

	@Override
	public List getUserbyId(int id) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		String query = "from UserRegistrationModel where id=" + id;
		Query query1 = session.createQuery(query);
		List list = query1.list();
		return list;

	}

	@Override
	public void update(UserRegistrationModel u) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(u);
		/*String q = "update UserRegistrationModel set name ="+u.getName()+",email="+u.getEmail()+",contact="+u.getContact()+",password="+u.getPassword()+"where id="+u.getId();
		Query query = session.createQuery(q);
		query.executeUpdate();*/
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteUser(int id) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from UserRegistrationModel where id="+id);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	@Override
	public List<UserRegistrationModel> loginUser(String email, String pwd) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		String qry="from UserRegistrationModel where email=:email and password=:pwd";
	    Query query=session.createQuery(qry);
		query.setParameter("email", email);
	    query.setParameter("pwd", pwd);
	    List<UserRegistrationModel> list=query.list();
    	return list;
	}

}
