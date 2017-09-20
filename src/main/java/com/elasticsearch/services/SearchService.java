/**
 * 
 */
package com.elasticsearch.services;


import java.io.IOException;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import static org.elasticsearch.index.query.QueryBuilders.*;


/**
 * @author suleyman.yildirim
 *
 */
public class SearchService implements ISearchService {
	
	@Override
	public SearchResponse MatchAll() {
		SearchResponse response = null;
		SearchSourceBuilder source = new SearchSourceBuilder().query(matchAllQuery());
		String[] indices = new String[] { "company" };
		SearchRequest searchRequest = new SearchRequest(indices, source);
		try {
			response = ConnectionService.getClient().search(searchRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public SearchResponse SimpleQueryString(String query) {
		SearchResponse response = null;
		
		SearchSourceBuilder source = new SearchSourceBuilder()
				.query(simpleQueryStringQuery(query));
		
		String[] indices = new String[] { "company" };
		SearchRequest searchRequest = new SearchRequest(indices, source);
		try {
			response = ConnectionService.getClient().search(searchRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public SearchResponse Filter(String query,int gte, int lte) {
		SearchResponse response = null;

		QueryBuilder qb = boolQuery()
				 .must(simpleQueryStringQuery(query))
				 .filter(rangeQuery("price")
				 .gte(gte)
				 .lte(lte));
		
		SearchSourceBuilder source = new SearchSourceBuilder().query(qb);
		String[] indices = new String[] { "company" };
		SearchRequest searchRequest = new SearchRequest(indices, source);
		try {
			response = ConnectionService.getClient().search(searchRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
		
	}

	@Override
	public SearchResponse FilterWithSpecificNumber(String query, int value) {
		SearchResponse response = null;

		QueryBuilder qb = boolQuery()
				 .must(simpleQueryStringQuery(query))
				 .filter(termQuery("price", value));
		
		SearchSourceBuilder source = new SearchSourceBuilder().query(qb);
		String[] indices = new String[] { "company" };
		SearchRequest searchRequest = new SearchRequest(indices, source);
		try {
			response = ConnectionService.getClient().search(searchRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public SearchResponse Sort() {
		SearchResponse response = null;

		SearchSourceBuilder source = new SearchSourceBuilder()
				.query(matchAllQuery())
				.sort("price", SortOrder.ASC);	
		
		String[] indices = new String[] { "company" };
		SearchRequest searchRequest = new SearchRequest(indices, source);
		try {
			response = ConnectionService.getClient().search(searchRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public SearchResponse Pagination() {
		SearchResponse response = null;

		SearchSourceBuilder source = new SearchSourceBuilder()
				.query(matchAllQuery())
				.size(20);		
		
		String[] indices = new String[] { "company" };
		SearchRequest searchRequest = new SearchRequest(indices, source);
		try {
			response = ConnectionService.getClient().search(searchRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;		
	}

	

}
