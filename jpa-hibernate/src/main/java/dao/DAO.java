package dao;

import javax.persistence.EntityManager;

import model.AbstractEntity;
import util.ConnectionFactory;

public class DAO<T extends AbstractEntity> {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T findById(Class<T> clazz, Integer id) {
		return manager.find(clazz, id);
	}

	public void saveOrUpdate(T obj) {
		try {
			manager.getTransaction().begin();
			if (obj.getId() == null) {
				manager.persist(obj);
			} else {
				manager.merge(obj);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	public void remove(Class<T> clazz, Integer id) {
		T t = findById(clazz, id);
		try {
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

}
