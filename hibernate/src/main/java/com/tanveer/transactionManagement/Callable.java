package com.tanveer.transactionManagement;

import org.hibernate.Session;

public abstract class Callable {
	
	public abstract void call(Session session);
}
