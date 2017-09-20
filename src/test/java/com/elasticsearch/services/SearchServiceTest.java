package com.elasticsearch.services;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatchAll() {
		SearchResponse response = new SearchService().MatchAll();
		assertEquals(RestStatus.OK,response.status());
		assertEquals(26, response.getHits().getTotalHits());
	}
	
	@Test
	public void testSimpleQueryString() {
		SearchResponse response = new SearchService().SimpleQueryString("Samsung");
		assertEquals(RestStatus.OK,response.status());
	}

	@Test
	public void testFilter() {
		SearchResponse response = new SearchService().Filter("Samsung",1000,4000);
		assertEquals(RestStatus.OK, response.status());
		assertEquals(6, response.getHits().getTotalHits());
		
		SearchResponse response2 = new SearchService().Filter("Samsung",1000,3000);
		assertEquals(RestStatus.OK, response2.status());
		assertEquals(3, response2.getHits().getTotalHits());
		
		SearchResponse response3 = new SearchService().Filter("Samsung",1000,2000);
		assertEquals(RestStatus.OK, response3.status());
		assertEquals(0, response3.getHits().getTotalHits());
	}

	@Test
	public void testFilterWithSpecificNumber() {
		SearchResponse response = new SearchService().FilterWithSpecificNumber("Samsung", 2900);
		assertEquals(RestStatus.OK, response.status());
		assertEquals(3, response.getHits().getTotalHits());
	}

	@Test
	public void testSort() {
		SearchResponse response = new SearchService().Sort();
		assertEquals(RestStatus.OK, response.status());
		Iterator<SearchHit> iterator  = response.getHits().iterator();
        int characteristics = Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;

        Spliterator<SearchHit> spliterator = Spliterators.spliteratorUnknownSize(iterator,characteristics);
		StreamSupport.stream(spliterator, false);
	}

	@Test
	public void testPagination() {
		SearchResponse response = new SearchService().Pagination();
		assertEquals(RestStatus.OK, response.status());	
		assertEquals(20, response.getHits().getHits().length);
		assertEquals(26, response.getHits().getTotalHits());
	}

}
