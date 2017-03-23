package com.jxufe.ham.test.bean;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.jxufe.ham.test.bean.Log;

import net.sf.ehcache.config.ConfigurationFactory;

public class test {
	
	@Test
	@SuppressWarnings("deprecation")
	public  void testBean() {
		File fileConfig = new File("src/test/resources/config.properties") ;
		SessionFactory sessionFactory = new Configuration().configure(fileConfig).buildSessionFactory(
				new ServiceRegistryBuilder().build());
		Session session = sessionFactory.getCurrentSession();
		Log log = new Log(1,new Date());
		session.save(log);
		session.getTransaction().commit();
	}
	
//	@Test
	public void testFileConfig(){
//				System.out.println(fileConfig.exists());
	}
}
