package com.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;

import com.elasticsearch.services.ConnectionService;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	RestHighLevelClient client = ConnectionService.getClient();
    	
    }
}
