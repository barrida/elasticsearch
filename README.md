# Elasticsearch application
.NET application for simple full text search with sample queries. Java project will be added soon.

# Run the .NET application
1. Download Elasticsearch and follow instructions from https://www.elastic.co/downloads/elasticsearch in order to run bin\elasticsearch.bat on Windows.
2. Run the application on Visual Studio.

## Update for .NET application
1.      Queries are in ElasticSearchASPApplication.Services namespace. Current implementation only calls SimpleSearch function.
2.      Search results are not shown in ASP.NET view. Run/Debug testcases instead.

# Sample Queries

**Searching all products**

```
GET /company/product/_search/
```

Using query DSL for more usefull search in order to make a more useful search request. We also need to supply a request body with a query.

```
POST /company/product/_search/
{
    "query": {
        "query_string": {
          "query": "Huawei", 
        }
      }
}
```
**Fine tuning query string queries**

Retrieve documents with the name of “Huawei”
```
POST /company/product/_search/
{
    "query": {
        "query_string": {
          "query": "Huawei", 
          "fields": [
            "name"
         ]
        }
      }
}
```
**Searching for multiple products**

```
POST /company/product/_search/
{
    "query": {
        "query_string": {
          "query": "Huawei iPhone6s",
          }
      }
}
```
**Filtering**

```
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
```
**Sorting**

```
Sort all products
POST /company/product/_search/
{
   "query": {
     "match_all": {}
   },
   "sort": {
      "price": "asc"
   }
}

Sort product with a name "Samsung"

POST /company/product/_search/
{
   "query": {
      "query_string": {
         "query": "Samsung"
      }
   },
   "sort": {
      "price": "asc"
   }
}
```

**Pagination**

ElasticSearch returns the first ten hits by default. You can change it via size parameter.
```
POST /company/product/_search/
{
   "query": {
     "match_all": {}
   },
   "sort": {
      "price": "asc"
   },
   "size": 12
}
```

**Retrieving only parts of documents**

Add  _source property to the query. Following query retrieves only “name” of all products. It is also possible to retrieve multiple fields as well using "_source": ["property1", "property2"]
```
Query:
POST /company/product/_search/
{
  "_source": "name"
}

Result:
{
            "_index": "company",
            "_type": "product",
            "_id": "AV57gFjUQ8Qv2Iw4gRgt",
            "_score": 1,
            "_source": {
               "name": "iPhone7"
            }
}
```
