# spring-demo

Demo to learn Spring HATEOAS with Spring BOOT (and the ecosystem of platform Spring)

# Dependencies

* Spring HATEOAS
* Spring Cloud / Spring Boot
* Retrofit

# Endpoint's

* projects

```
{
    "_embedded": {
        "repositoryList": [
            {
                "_links": {
                    "self": {
                        "href": "https://github.com/octocat/git-consortium"
                    }
                }, 
                "language": null, 
                "name": "git-consortium"
            }, 
            {
                "_links": {
                    "self": {
                        "href": "https://github.com/octocat/hello-worId"
                    }
                }, 
                "language": null, 
                "name": "hello-worId"
            }
            // ...
        ]
    }, 
    "_links": {
        "self": {
            "href": "http://example.com/products/1"
        }
    }
}
```