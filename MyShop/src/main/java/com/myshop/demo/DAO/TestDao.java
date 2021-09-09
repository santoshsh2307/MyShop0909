package com.myshop.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.myshop.demo.entity.ServicesInShop;
import com.myshop.demo.entity.ShopDetails;

@Repository
public class TestDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Object getCustomerProfileByUserId(Long userId,Long spId) {
		Session session = entityManager.unwrap(Session.class);
		Boolean status = true;
		StringBuffer hql = new StringBuffer(" select u.id as UserId, u.first_name as fName, u.last_name As lName, u.phone as phone , u.user_name AS userName,u.photo as profilePhoto, " + 
				" sp.id AS shopId,sp.address as shopAddress, sp.created_at AS sinceFrom, sp.latitude As lat, sp.longitude as log,sp.shop_name as shopName,sp.no_of_sheets As sheets " + 
				" FROM users As  u " + 
				" join shop_details AS sp On sp.user_id=u.id " + 
				" where u.id=:userId and u.status=:stat ");
		if (spId!=null) {
			hql.append("AND sp.id=:spId");
		}

		SQLQuery query = session.createSQLQuery(hql.toString());
		query.setParameter("userId", userId);
		query.setParameter("stat", true);
		if (spId!=null) {
			query.setParameter("spId", spId);
		}
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		if(query.list()!=null&&query.list().size()>0) {
			return query.list();
		}
		return null;
	}

	public Object getOwnerDeatailByShopId(Long shopId) {
		Session session = entityManager.unwrap(Session.class);
		Boolean status = true;
		StringBuffer hql = new StringBuffer(" SELECT u.id AS userId,u.first_name AS firstName,u.phone AS userPhone,u.user_name AS userName, " + 
				" sd.id AS shopId,sd.address AS shopAddress,sd.no_of_sheets AS sheets,sd.pin AS shopPin,sd.shop_name AS shopName  " + 
				" FROM shop_details AS sd " + 
				" JOIN users AS u ON u.id = sd.user_id  " + 
				" WHERE sd.id=:shopId  ");
		

		SQLQuery query = session.createSQLQuery(hql.toString());
		query.setParameter("shopId", shopId);
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		if(query.list()!=null) {
			return query.getSingleResult();
		}
		return null;
	}

	

	public List getShopDeatailByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Boolean status = true;
		StringBuffer hql = new StringBuffer(" SELECT u.id AS OwnerId,u.first_name AS fName,u.phone AS userPhone, " + 
				" sd.id AS shopId,sd.address AS shopAddress,sd.latitude as lat,sd.longitude AS lon,sd.no_of_sheets AS sheets,sd.shop_name AS shopName,sd.pin AS pincode " + 
				" FROM users AS u " + 
				" JOIN shop_details AS sd ON sd.user_id=u.id " + 
				" WHERE u.id=:userId ");
		

		SQLQuery query = session.createSQLQuery(hql.toString());
		query.setParameter("userId", ownerId);
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		if(query.list()!=null) {
			return query.list();
			
		}
		return null;

	}

	public List<ServicesInShop> getShopServicesByShopId(Long shopId) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Boolean status = true;
		StringBuffer hql = new StringBuffer(" SELECT ss.id AS serviceId,ss.swervice_name AS serviceName, " + 
				" aps.id AS appointSlotId,aps.shop_id AS shopId,service_amount AS serviceAmount   " + 
				" FROM services_in_shop AS ss " + 
				" JOIN appointment_slots AS aps ON aps.service_id =ss.id " + 
				" WHERE shop_id = :shopId ");
		

		SQLQuery query = session.createSQLQuery(hql.toString());
		query.setParameter("shopId", shopId);
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		if(query.list()!=null) {
			return query.list();
	}
		return null;
	}	
}
