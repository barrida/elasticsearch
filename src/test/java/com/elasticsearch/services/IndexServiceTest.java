package com.elasticsearch.services;

import static org.junit.Assert.*;

import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IndexServiceTest {

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
	public void testBulkIndex() {
		RestHighLevelClient client = ConnectionService.getClient();
		IndexService service = new IndexService();
		BulkResponse response = service.bulkIndex(client);
		assertEquals(false, response.hasFailures());
	}

}
