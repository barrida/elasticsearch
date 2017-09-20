/**
 * 
 */
package com.elasticsearch.services;

import org.elasticsearch.action.search.SearchResponse;

/**
 * @author suleyman.yildirim
 *
 */
public interface ISearchService {
	
	/**
	 * The search method will execute the match_all query
	 * 
	 * @return
	 * @see
	    // GET /company/product/_search/
	    // {
	    //   "query": {
		//	 "match_all": {}
	    //   }
	    // }
	 */
	SearchResponse MatchAll();
  
	/**
	 * The search method will execute the multi match query against user input
	 * 
	 * @param query
	 * @return
	 * @see 
	 * GET /company/product/_search/
	     {
	       "query": {
	          "query_string": {
	             "query": "Samsung"
	          }
	       }
	     }
	 */
	SearchResponse SimpleQueryString(String query);
	
	/**
	 * Given a <code>query</code> (e.g.: "Samsung"), retrieves products whose price is between gte (e.g.: 1000) and lte (e.g.: 4000).
	 * 
	 * @param query
	 * @param gte
	 * @param lte
	 * @return
	 * @see
	   POST /company/product/_search/
	    {
	       "query": {
	          "bool": {
	             "must": {
	                "match": {
	                   "name": "Samsung"
	                }
	             },
	             "filter": [
	                {
	                   "range": {
	                      "price": {
	                         "gte": 1000,
	                         "lte": 4000
	                      }
	                    }
	                }
	             ]
	          }
	       }
	    }
	 */
	SearchResponse Filter(String query, int gte, int lte);
	
	/**
	 * Given a <code>query</code> (e.g.: "Samsung"), retrieves products whose price is 2900.
	 * 
	 * @param query
	 * @param value
	 * @return
	 * @see 
	   POST /company/product/_search/
          {
           "query": {
              "bool": {
                 "must": {
                    "match": {
                       "name": "Samsung"
                    }
                 },
                 "filter": {
                    "term": {
                       "price": 2900
                    }
                 }
              }
           }
          }
	 */
	SearchResponse FilterWithSpecificNumber(String query,int value);
	
	/**
	 * Sorts all products in ascending order.
	 * 
	 * @return
	 * @see
	   POST /company/product/_search/
         {
           "query": {
             "match_all": {}
           },
           "sort": {
              "price": "asc"
           }
         } 
	 */
	SearchResponse Sort();
	
	/**
	 * Sets the number of search hits to return. Defaults to 10
	 * 
	 * @param query
	 * @return
	 * @see 
	 * POST /company/product/_search/
		{
		   "query": {
		     "match_all": {}
		   },
		   "size": 20
		}
	 */
	SearchResponse Pagination();
}
