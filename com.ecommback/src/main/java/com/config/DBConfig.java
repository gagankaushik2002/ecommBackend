package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Cart;
import com.model.CartItem;
import com.model.Category;
import com.model.OrderDetail;
import com.model.Product;
import com.model.Supplier;
import com.model.UserDetail;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{

	@Bean(name="dataSource")
	public DataSource getMySqlDataSource()
	{
		//getH2DataSource
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/abc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		System.out.println("Data Source Object Created");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getMySqlDataSource());
		sessionFactoryBuilder.addProperties(properties);
		
		sessionFactoryBuilder.addAnnotatedClass(Category.class);
		sessionFactoryBuilder.addAnnotatedClass(Product.class);
		sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		sessionFactoryBuilder.addAnnotatedClass(Cart.class);
		sessionFactoryBuilder.addAnnotatedClass(CartItem.class);
		sessionFactoryBuilder.addAnnotatedClass(OrderDetail.class);
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		
		System.out.println("SessionFactory Object Created");
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}

