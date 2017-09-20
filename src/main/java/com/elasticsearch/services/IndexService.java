package com.elasticsearch.services;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import com.elasticsearch.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates bulk index
 * 
 * @author suleyman.yildirim
 *
 */
public class IndexService {

	/**
	 * Perform bulk index
	 * 
	 * @param client
	 *            RestHighLevelClient
	 * @return BulkResponse
	 */
	BulkResponse bulkIndex(RestHighLevelClient client) {
		
		BulkResponse response = null;
		
		try {
			// create dummy data
			List<Product> productList = new ArrayList<Product>();
			productList.add(new Product("iPhone6s", 3000, "TL"));
			productList.add(new Product("iPhone6", 2500, "TL"));
			productList.add(new Product("iPhone7", 4500, "TL"));
			productList.add(new Product("Samsung Galaxy S8", 3400, "TL"));
			productList.add(new Product("Samsung Galaxy S7", 2900, "TL"));

			// create bulk request
			BulkRequest bulkRequest = new BulkRequest();
			productList.forEach(product -> {
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("name", product.getName());
				jsonMap.put("price", product.getPrice());
				jsonMap.put("currency", product.getCurrency());
				bulkRequest.add(new IndexRequest("company", "product").source(jsonMap));
			});

			response = client.bulk(bulkRequest);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return response;
	}
}
