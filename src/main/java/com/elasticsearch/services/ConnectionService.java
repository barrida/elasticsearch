package com.elasticsearch.services;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * Initializes connection using Java High Level REST Client
 * 
 * @author suleyman.yildirim
 * @see https://artifacts.elastic.co/javadoc/org/elasticsearch/client/elasticsearch-rest-high-level-client/5.6.0/index.html
 *
 */

public class ConnectionService {

	/**
	 * RestHighLevelClient instance needs a REST low-level client to be built
	 * @return RestHighLevelClient
	 */
	public static RestHighLevelClient getClient() {		
		RestClient lowLevelRestClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
		return new RestHighLevelClient(lowLevelRestClient);
	}
	
}
