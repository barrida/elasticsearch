package com.elasticsearch.services;

import static org.junit.Assert.*;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectionServiceTest {

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
	public void testGetClient() {
		RestClient lowLevelRestClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
		RestHighLevelClient client = new RestHighLevelClient(lowLevelRestClient);
		assertNotNull(client);
	}

}
