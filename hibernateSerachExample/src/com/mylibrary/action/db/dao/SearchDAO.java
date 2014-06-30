package com.mylibrary.action.db.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;

import com.mylibrary.action.db.entitys.Author;
import com.mylibrary.action.db.entitys.Book;
import com.mylibrary.action.db.manger.SessionManger;

public class SearchDAO {

	private Date getDate(String year) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.parseInt(year));
			return calendar.getTime();
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List doSearching(String searchKey) throws ParseException {
		System.out.println("searchKey : " + searchKey);
		EntityManager entityManager = SessionManger.getEntityManager();
	
		  FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		  
		Query luceneQuery = new WildcardQuery(new Term("*",searchKey ));
		
		    FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Book.class,Author.class);
		    fullTextQuery.setFirstResult(0);
		    fullTextQuery.setMaxResults(10);
		    List results = fullTextQuery.getResultList();
		    return results;
	}
	
}