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
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(UserRegistrationModel user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public boolean existEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from UserRegistrationModel u where  u.email=:email";
		Query query = session.createQuery(sql);
		query.setParameter("email", email);
		List<UserRegistrationModel> list = query.list();
		if (list.size() > 0) {
			return true;
		} 
		return false;
	}

	public List<UserRegistrationModel> getAllUsersList() {
		Session session = sessionFactory.getCurrentSession();
		List<UserRegistrationModel> userList = session.createQuery("from UserRegistrationModel").list();
		return userList;
	}

	public List getUserbyId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from UserRegistrationModel where id=" + id;
		Query query1 = session.createQuery(query);
		List list = query1.list();
		return list;
	}

	public void update(UserRegistrationModel u) {
		Session session = sessionFactory.getCurrentSession();
		session.update(u);
		/*String q = "update UserRegistrationModel set name ="+u.getName()+",email="+u.getEmail()+",contact="+u.getContact()+",password="+u.getPassword()+"where id="+u.getId();
		Query query = session.createQuery(q);
		query.executeUpdate();*/
	}

	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from UserRegistrationModel where id="+id);
		query.executeUpdate();
	}

	public List<UserRegistrationModel> loginUser(String email, String pwd) {
		Session session = sessionFactory.getCurrentSession();
	    Query query=session.createQuery("from UserRegistrationModel where email=:email and password=:pwd");
		query.setParameter("email", email);
	    query.setParameter("pwd", pwd);
	    List<UserRegistrationModel> list=query.list();
    	return list;
	}

}
