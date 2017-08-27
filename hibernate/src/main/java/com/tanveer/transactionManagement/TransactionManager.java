package com.tanveer.transactionManagement;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tanveer.util.HibernateUtil;

public class TransactionManager {
	
	private static final Logger LOGGER = Logger.getLogger("TransactionManager");
	
	public static void execute(Callable statemnts) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			tx.setTimeout(5);
			statemnts.call(session);
			tx.commit();
		}catch(RuntimeException e){
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				LOGGER.log(Level.INFO, "Couldn’t roll back transaction", rbe);
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}

	}
	
//	public static void main(String[] args) throws NamingException {
//		UserTransaction txn = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
//		
//		Session1= null;
//		Session2=null;
//		
//		try{
//			txn.begin();
//			Session1=sf1.openTransaction();
//			Session2=sf2.openTransaction();
//			txn.commit();
//		} catch (RuntimeException e){
//			try{
//				txn.rollback();
//			}  catch (Exception e) {
//				log.("cannnot rollback...")
//			}
//		}
//	}
	


}
