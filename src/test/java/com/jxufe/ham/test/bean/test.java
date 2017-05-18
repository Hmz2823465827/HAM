package com.jxufe.ham.test.bean;

import java.io.File;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.House;
import com.jxufe.ham.bean.Housekey;
import com.jxufe.ham.bean.Log;


public class test {
	
	@Test
	public  void testBean() {
//		File fileConfig = new File("src/main/resources/config.properties") ;
		Configuration configuration = new Configuration().configure();
//		configuration.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
//		configuration.setProperty("jdbc.url", "jdbc:mysql://10.16.26.152:3306/houseagencymanagement");
//		configuration.setProperty("jdbc.username", "root");
//		configuration.setProperty("jdbc.password", "971021");
//		System.out.println(configuration.getProperty("hibernate.connection.url"));
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//		SessionFactory sessionFactory = new Configuration().configure(/*fileConfig*/).buildSessionFactory(
//				new ServiceRegistryBuilder().build());
//	    SessionFactory sessionFactory;
//	    Session session;
//	    Transaction transaction;
//		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder()
//                ./*applyImplicitNamingStrategy().*/build();
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction;
        transaction = session.beginTransaction();
//        transaction = session.beginTransaction();
		House log = new House();
//		log.setSid(1);
//		log.setNumber("qwe");
//		log.setName("bullshit");
		log.setHouseId(1);
		log.setClientPhone("test");
		Housekey employee = (Housekey)session.get(Housekey.class, 1);
//		System.out.println(employee.getHouseKey());
		transaction.commit();
//        // 关闭会话
//        session.close();
//        // 关闭会话工厂
//        sessionFactory.close();
	}
	
//	@Test
	public void testFileConfig(){
//				System.out.println(fileConfig.exists());
	}
	
//	@Test
	public void testSaxRead() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("src/main/java/com/jxufe/ham/test/bean/hibernatePersistentINF/Depart.hbm.xml"));
//		DocumentHelper.parseText(text);
		System.out.println(document.toString());
	}
}
