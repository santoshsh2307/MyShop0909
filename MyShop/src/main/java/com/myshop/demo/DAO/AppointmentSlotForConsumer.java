package com.myshop.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentSlotForConsumer {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Object> getAppointmentBasedOnStatus(Long consumerId, Long statusId) {
		Session session = entityManager.unwrap(Session.class);
		Boolean status = true;
		StringBuffer hql = new StringBuffer("SELECT asl.id AS aslId,asl.create_at AS createdDate,asl.appoint_type AS appType, " + 
				" cun.id AS consumerId, cun.first_name AS consumerName,cun.address AS consumerAddress, cun.dob AS consumerDob,cun.phone AS consumerPhone,cun.pin AS cPin, " + 
				" u.id AS owerId, u.first_name AS ownerName,u.phone AS owerPhone,u.photo AS ownerPhoto, " + 
				" sd.id AS shopId,sd.address AS ShopAddress,sd.created_at AS shopCreatedDate, sd.no_of_sheets AS sheets, sd.pin AS shopPin,sd.shop_name AS shopName,sd.user_id AS userId, " + 
				" sis.id AS serviceInShopId,sis.swervice_name AS serviceName, " + 
				" app.id AS appointmentId,app.app_date AS appDate,app.app_time AS appTime,app.booking_status_id AS bookingStatusId, " + 
				" bs.booking_name AS bookingStatus " + 
				" FROM appointment_slots AS asl " + 
				" JOIN consumer AS cun ON cun.id= asl.customer_id " + 
				" JOIN users AS u ON u.id = asl.owner_id " + 
				" JOIN shop_details AS sd ON sd.id=asl.shop_id " + 
				" JOIN services_in_shop AS sis ON sis.id= asl.service_id " + 
				" JOIN appointment AS app ON app.id = asl.slot_id " + 
				" JOIN booking_status AS bs ON app.booking_status_id =bs.id " + 
				" WHERE asl.customer_id=:consumerId  AND bs.id=:statusId ");
		

		SQLQuery query = session.createSQLQuery(hql.toString());
		query.setParameter("consumerId", consumerId);
		query.setParameter("statusId", statusId);

		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		if(query.list()!=null&&query.list().size()>0) {
			return query.list();
		}
	
		// TODO Auto-generated method stub
		return null;

		
	}


	

}
