package com.R72X.entity;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contactnote entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.R72X.entity.Contactnote
 * @author MyEclipse Persistence Tools
 */

public class ContactnoteDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ContactnoteDAO.class);
	// property constants
	public static final String CONTACT_NOTE_NAME = "contactNoteName";
	public static final String CONTACT_DESC = "contactDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(Contactnote transientInstance) {
		log.debug("saving Contactnote instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Contactnote persistentInstance) {
		log.debug("deleting Contactnote instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contactnote findById(java.lang.Integer id) {
		log.debug("getting Contactnote instance with id: " + id);
		try {
			Contactnote instance = (Contactnote) getHibernateTemplate().get(
					"com.R72X.entity.Contactnote", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contactnote instance) {
		log.debug("finding Contactnote instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Contactnote instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Contactnote as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContactNoteName(Object contactNoteName) {
		return findByProperty(CONTACT_NOTE_NAME, contactNoteName);
	}

	public List findByContactDesc(Object contactDesc) {
		return findByProperty(CONTACT_DESC, contactDesc);
	}

	public List findAll() {
		log.debug("finding all Contactnote instances");
		try {
			String queryString = "from Contactnote";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Contactnote merge(Contactnote detachedInstance) {
		log.debug("merging Contactnote instance");
		try {
			Contactnote result = (Contactnote) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contactnote instance) {
		log.debug("attaching dirty Contactnote instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contactnote instance) {
		log.debug("attaching clean Contactnote instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ContactnoteDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ContactnoteDAO) ctx.getBean("ContactnoteDAO");
	}
}