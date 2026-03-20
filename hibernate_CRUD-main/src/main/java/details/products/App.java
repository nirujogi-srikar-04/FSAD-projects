package details.products;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	System.out.println("**********Starting of creation*********");
    	
    	Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
//    	Transaction tx = session.beginTransaction();
    	
//    	Declare entity class
//    	Stock_Details stock = new Stock_Details();
//    	
//    	stock.setId(6); // Set Id information
//    	stock.setName("Lap");// Set name information
//    	stock.setPrice(12000.00);// Set price information
//    	stock.setQuantity(5);// Set quality information
//    	
//    	// Session should be saved and exited
//    	session.save(stock);
//    	tx.commit();
//    	System.out.println("Record Insert successfully");
//    	
//    	// Retrieve of data
//    	Stock_Details stock2 = session.find(Stock_Details.class, 1);
//    	System.out.println("Data retrived from Id-1: "+stock2.getPrice());// Get Id data
//    	
    	Stock_Details stock3 = session.find(Stock_Details.class,6);
//    	System.out.println("Updating Id of 1 price");
//    	stock3.setPrice(1000.00);
//    	stock3.setDescription("This is normal lap");
//    	session.save(stock3);
//    	Transaction tx1 = session.beginTransaction();
//    	tx1.commit();
//    	System.out.println("Updated Id of 1 price");
    	
//    	Deletion of data
//    	System.out.println("Deleting data of id of 2");
//    	Stock_Details stock4 = session.find(Stock_Details.class,3);
//    	session.delete(stock4);
//    	Transaction tx2 = session.beginTransaction();
//    	tx2.commit();
    	
    	
    	/*
    	 * Write HQL queries to retrieve all products sorted by price:
          a. Ascending order
          b. Descending order
         */
    	String hqlAsc = "FROM Stock_Details s ORDER BY s.price ASC";
    	List<Stock_Details> stockAsc = session.createQuery(hqlAsc,Stock_Details.class).list();
    	
    	for(Stock_Details stock : stockAsc) {
    		System.out.println(stock.getId()+" | "+stock.getName()+" | "+stock.getPrice()+" | "+stock.getQuantity());
    	}
    	
    	System.out.println();
    	String hqlDesc = "FROM Stock_Details s ORDER BY s.price DESC";
    	List<Stock_Details> stockDesc = session.createQuery(hqlDesc,Stock_Details.class).list();
    	
    	for(Stock_Details stock : stockDesc) {
    		System.out.println(stock.getId()+" | "+stock.getName()+" | "+stock.getPrice()+" | "+stock.getQuantity());
    	}
    	
    	System.out.println();
    	 /*
    	  * Write an HQL query to sort products by quantity (highest first).
    	 */
    	String hqlHigh = "FROM Stock_Details s ORDER BY s.quantity DESC";
    	List<Stock_Details> highestFirst = session.createQuery(hqlHigh,Stock_Details.class).list();
    	
    	for(Stock_Details stock : highestFirst) {
    		System.out.println(stock.getId()+" | "+stock.getName()+" | "+stock.getPrice()+" | "+stock.getQuantity());
    	}
    	
    	/*
    	 *  Implement pagination using HQL to display:
				a. First 3 products
				b. Next 3 products
    	 */
    	System.out.println();
    	Query<Stock_Details> query1 = session.createQuery("FROM Stock_Details",Stock_Details.class);
    	query1.setFirstResult(0);
    	query1.setMaxResults(3);
    	
    	List<Stock_Details> firstThree = query1.list();
    	for(Stock_Details stock : firstThree) {
    		System.out.println(stock.getId()+" | "+stock.getName()+" | "+stock.getPrice()+" | "+stock.getQuantity());
    	}
    	
    	System.out.println();
    	Query<Stock_Details> query2 = session.createQuery("FROM Stock_Details",Stock_Details.class);
    	query2.setFirstResult(3);
    	query2.setMaxResults(6);
    	
    	List<Stock_Details> nextThree = query2.list();
    	for(Stock_Details stock : nextThree) {
    		System.out.println(stock.getId()+" | "+stock.getName()+" | "+stock.getPrice()+" | "+stock.getQuantity());
    	}
    	
    	/*
    	 * Write HQL queries for aggregate operations:
			a. Count total number of products
			b. Count products where quantity > 0
			c. Count products grouped by description
			d. Find minimum and maximum price 

    	 * */
    	System.out.println();
    	// a. Count total number of products
    	Query<Long> countQuery = session.createQuery("SELECT COUNT(s.id) FROM Stock_Details s",Long.class);
    	Long totalCount = countQuery.uniqueResult();
    	System.out.println("Total count of products are: "+totalCount);
    	
    	//b. Count products where quantity > 0
    	Query<Long> countQuery2 = session.createQuery("SELECT COUNT(s.id) FROM Stock_Details s WHERE s.quantity > 0",Long.class);
    	Long totalCount2 = countQuery2.uniqueResult();
    	System.out.println("Total count where quantity > 0 is "+totalCount2);
    	
    	// c. Count products grouped by description
    	System.out.println();
    	Query<Object[]> queryDescription = session.createQuery("SELECT s.description, COUNT(s.id) FROM Stock_Details s GROUP BY s.description",Object[].class);
    	List<Object[]> groups = queryDescription.list();
    	
    	for(Object[] group : groups) {
    		System.out.println("Description: "+group[0]+"| Count: "+group[1]);
    	}
    	
    	// d. Find minimum and maximum price 
    	
    	Query<Object[]> minMaxQuery = session.createQuery("SELECT MIN(s.id), MAX(s.id) FROM Stock_Details s",Object[].class);
    	Object[] minMax = minMaxQuery.uniqueResult();
    	System.out.println("Minimum id is: "+minMax[0]);
    	System.out.println("Maximum id is: "+minMax[1]);
    	
    	
    	
    	
    	

    }
}
