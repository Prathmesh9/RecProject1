package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import model.RecModel;
import recInterface.RecDaoInterface;

public class RecDaoImpl implements RecDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	public void addRecord(RecModel record) {
		if (!getByContentID(record.getmContentID())) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			System.out.println("Inside dao add " + record.getmVisitorID());
			try {
				System.out.println("Transaction started..");
				session.save(record);
				System.out.println("Transaction commit");
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				session.close();
			}
		}else{
			System.out.println("Already exists");
		}
	}

	@SuppressWarnings("unchecked")
	private boolean getByContentID(String pContentID) {
		Session session = sessionFactory.openSession();

		Query<String> query = session.createQuery("from RecModel u where u.mContentID= :ContentID");
		query.setParameter("ContentID", pContentID);

		List<String> result = query.getResultList(); // getting hql result

		// checking result
		if (result != null && result.size() > 0)
			return true;
		else
			return false;

	}
}
