# MuMAPP - API REST Documentation

## About our API
All you can find in our API Rest is information about users, music styles and cities All you need to do is simply; you have to follow the API rules. If you try to do following a different way, it's probably what you will recieve an error.

## How to use our API
1. Download [Postman](https://www.getpostman.com/).
2. You only can send GET, POST, PUT and DELETE requests.
3. Use the api.postman_collection.json as an example of the request that can be done.

## API requests

### Resources
The resource API has GET, POST, PUT and DELETE methods.
http: // localhost: 8443 followed by the containt request URL.

All success response are **200 OK** except for the POST methods whose success codes are **201 CREATED**

**All API queries have been preceded by /api**

## USER

#### GET - http://localhost:8443/api/user/all
	Get all registered and admin users info

* ##### URL: 	

	< /user/all >

* ##### Method: 

	`GET`
	
* ##### Success Response:
  
	**Code:** 200 OK

                
    {
        "id": 51,
        "firstName": "admin_First",
        "lastName": "admin_Last",
        "name": "admin",
        "email": "admin@mumapp.not",
        "roles": [
            "ROLE_ADMIN",
            "ROLE_USER"
        ],
        "musicSet": [
            {
                "id": 20,
                "styleName": "urban"
            },
            {
                "id": 5,
                "styleName": "r and b"
            },
            {
                "id": 24,
                "styleName": "acoustic"
            },
            {
                "id": 21,
                "styleName": "disco"
            }
        ],
        "citySet": [
            {
                "id": 35,
                "cityName": "mexico city",
                "country": "mexico",
                "continent": "america"
            },
            {
                "id": 41,
                "cityName": "shanghai",
                "country": "china",
                "continent": "asia"
            },
            {
                "id": 44,
                "cityName": "cape town",
                "country": "south africa",
                "continent": "africa"
            },
            {
                "id": 29,
                "cityName": "helsinki",
                "country": "finland",
                "continent": "europe"
            }
        ]
    },
    {
        "id": 52,
        "firstName": "admin2",
        "lastName": "admin2",
        "name": "admin2",
        "email": "admin2@mumapp.not",
        "roles": [
            "ROLE_ADMIN",
            "ROLE_USER"
        ],
        "musicSet": [
            {
                "id": 2,
                "styleName": "blues"
            },
            {
                "id": 19,
                "styleName": "electronic"
            },
            {
                "id": 22,
                "styleName": "singer-songwriter"
            }
        ],
        "citySet": [
            {
                "id": 28,
                "cityName": "rome",
                "country": "italy",
                "continent": "europe"
            },
            {
                "id": 31,
                "cityName": "amsterdam",
                "country": "netherlands",
                "continent": "europe"
            },
            {
                "id": 27,
                "cityName": "barcelona",
                "country": "spain",
                "continent": "europe"
            }
        ]
    },
    {
        "id": 53,
        "firstName": "ana",
        "lastName": "j",
        "name": "anita",
        "email": "ana@mumapp.not",
        "roles": [
            "ROLE_USER"
        ],
        "musicSet": [
            {
                "id": 1,
                "styleName": "jazz"
            },
            {
                "id": 14,
                "styleName": "classical"
            },
            {
                "id": 3,
                "styleName": "funk"
            },
            {
                "id": 5,
                "styleName": "r and b"
            },
            {
                "id": 4,
                "styleName": "soul"
            }
        ],
        "citySet": [
            {
                "id": 32,
                "cityName": "new york",
                "country": "usa",
                "continent": "america"
            },
            {
                "id": 26,
                "cityName": "madrid",
                "country": "spain",
                "continent": "europe"
            },
            {
                "id": 45,
                "cityName": "cairo",
                "country": "egypt",
                "continent": "africa"
            },
            {
                "id": 30,
                "cityName": "dublin",
                "country": "ireland",
                "continent": "europe"
            },
            {
                "id": 48,
                "cityName": "sidney",
                "country": "australia",
                "continent": "oceania"
            }
        ]
    },
    {
        "id": 54,
        "firstName": "maria",
        "lastName": "k",
        "name": "maria",
        "email": "mimi@mumapp.not",
        "roles": [
            "ROLE_USER"
        ],
        "musicSet": [
            {
                "id": 1,
                "styleName": "jazz"
            },
            {
                "id": 6,
                "styleName": "latin"
            },
            {
                "id": 12,
                "styleName": "country"
            },
            {
                "id": 11,
                "styleName": "punk"
            },
            {
                "id": 15,
                "styleName": "tv and film"
            },
            {
                "id": 8,
                "styleName": "pop"
            },
            {
                "id": 13,
                "styleName": "trap"
            },
            {
                "id": 7,
                "styleName": "indie"
            },
            {
                "id": 10,
                "styleName": "metal"
            },
            {
                "id": 9,
                "styleName": "rock"
            }
        ],
        "citySet": [
            {
                "id": 36,
                "cityName": "buenos aires",
                "country": "argentina",
                "continent": "america"
            },
            {
                "id": 38,
                "cityName": "tokyo",
                "country": "japan",
                "continent": "asia"
            },
            {
                "id": 37,
                "cityName": "santiago",
                "country": "chile",
                "continent": "america"
            }
        ]
	}
              
  
* ##### Error response:

	**Code**:  404 NOT FOUND


#### POST - http://localhost:8443/api/user
	Create a new user (new_admin)

* ##### URL:

	< /api/user >

* ##### Method:

	`POST`

* ##### Success Response: 

	**Code:** 201 CREATED
  

	{
		{
    "id": 0,
    "firstName": "new_admin",
    "lastName": "new_admin_Last",
    "name": "new_admin_new",
    "email": "new_admin@mumapp.not",
    "roles": [
        "ROLE_ADMIN",
        "ROLE_USER"
    ],
    "musicSet": [
        {
            "id": 20,
            "styleName": "urban"
        },
        {
            "id": 5,
            "styleName": "r and b"
        }
    ],
    "citySet": [
        {
            "id": 29,
            "cityName": "helsinki",
            "country": "finland",
            "continent": "europe"
        },
        {
            "id": 44,
            "cityName": "cape town",
            "country": "south africa",
            "continent": "africa"
        }
    ]
	}


* ##### Error response:

	**Code**: 401 UNAUTHORIZED or 400 BAD REQUEST or 500 INTERNAL SERVER ERROR
	

#### GET - http://localhost:8443/api/user/53
	Get info user by id

* ##### URL:

	< /user/53>

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  
  
	{
		{
    "id": 53,
    "firstName": "ana",
    "lastName": "j",
    "name": "anita",
    "email": "ana@mumapp.not",
    "roles": [
        "ROLE_USER"
    ],
    "musicSet": [
        {
            "id": 14,
            "styleName": "classical"
        },
        {
            "id": 4,
            "styleName": "soul"
        },
        {
            "id": 3,
            "styleName": "funk"
        },
        {
            "id": 5,
            "styleName": "r and b"
        },
        {
            "id": 1,
            "styleName": "jazz"
        }
    ],
    "citySet": [
        {
            "id": 48,
            "cityName": "sidney",
            "country": "australia",
            "continent": "oceania"
        },
        {
            "id": 26,
            "cityName": "madrid",
            "country": "spain",
            "continent": "europe"
        },
        {
            "id": 30,
            "cityName": "dublin",
            "country": "ireland",
            "continent": "europe"
        },
        {
            "id": 45,
            "cityName": "cairo",
            "country": "egypt",
            "continent": "africa"
        },
        {
            "id": 32,
            "cityName": "new york",
            "country": "usa",
            "continent": "america"
        }
    ]
	}


* ##### Error response:

	**Code**: 404 NOT FOUND


#### PUT - http://localhost:8443/api/user/55
	Update user info 

* ##### URL:

	< /user/{id}>

* ##### Method:

	`PUT`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
    "id": 55,
    "firstName": "abc",
    "lastName": "xyz",
    "name": "new_admin_new",
    "email": "new_admin@mumapp.not",
    "roles": [
        "ROLE_ADMIN",
        "ROLE_USER"
    ],
    "musicSet": [
        {
            "id": 8,
            "styleName": "pop"
        },
        {
            "id": 20,
            "styleName": "urban"
        }
    ],
    "citySet": [
        {
            "id": 29,
            "cityName": "helsinki",
            "country": "finland",
            "continent": "europe"
        },
        {
            "id": 30,
            "cityName": "dublin",
            "country": "ireland",
            "continent": "europe"
        }
    ]
	}



* ##### Error response:

	**Code**: 401 UNAUTHORIZED or 400 BAD REQUEST


#### DELETE - http://localhost:8443/api/user/{id}
	Delete user by id

* ##### URL:

	< /user/{id} >

* ##### Method:

	`DELETE`

* ##### Success Response:
	**Code:** 200 OK  
  
  
	{
		"id": 55,
	    "firstName": "abc",
	    "lastName": "xyz",
	    "name": "new_admin_new",
	    "email": "new_admin@mumapp.not",
	    "roles": [
	        "ROLE_ADMIN",
	        "ROLE_USER"
	    ],
	    "musicSet": [],
	    "citySet": []
	}



* ##### Error response:

	**Code**: 404 NOT FOUND


#### GET - http://localhost:8443/api/user/{id}/music
	Get user_music by user id
* ##### URL:

	< /user/{id}/music >

* ##### Method:

	`GET`

* ##### Success Response:
	**Code:** 200 OK


	{
		[
    {
        "id": 14,
        "styleName": "classical"
    },
    {
        "id": 1,
        "styleName": "jazz"
    },
    {
        "id": 4,
        "styleName": "soul"
    },
    {
        "id": 5,
        "styleName": "r and b"
    },
    {
        "id": 3,
        "styleName": "funk"
    }
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET -  http://localhost:8443/api/user/{id}/city
	Get user_city by user id
* ##### URL:

	< /user/{id}/city >

* ##### Method:

	`GET`

* ##### Success Response:
	**Code:** 200 OK


	{
		[
    {
        "id": 30,
        "cityName": "dublin",
        "country": "ireland",
        "continent": "europe"
    },
    {
        "id": 45,
        "cityName": "cairo",
        "country": "egypt",
        "continent": "africa"
    },
    {
        "id": 32,
        "cityName": "new york",
        "country": "usa",
        "continent": "america"
    },
    {
        "id": 48,
        "cityName": "sidney",
        "country": "australia",
        "continent": "oceania"
    },
    {
        "id": 26,
        "cityName": "madrid",
        "country": "spain",
        "continent": "europe"
    }
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND



## MUSIC

#### GET - http://localhost:8443/api/music/all/style
	Get a list of all music styles

* ##### URL:

	< /music/all/style >

* ##### Method:

	`GET`

* ##### Success Response:
	**Code:** 200 OK


	{
		[
    "jazz",
    "blues",
    "funk",
    "soul",
    "r and b",
    "latin",
    "indie",
    "pop",
    "rock",
    "metal",
    "punk",
    "country",
    "trap",
    "classical",
    "tv and film",
    "romantic",
    "bolero",
    "cumbia",
    "electronic",
    "urban",
    "disco",
    "singer-songwriter",
    "cover",
    "acoustic",
    "bossa-nova"
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET - http://localhost:8443/api/music/all/id
	Get a list of all music ids

* ##### URL:

	< /music/all/id >

* ##### Method:

	`GET`

* ##### Success Response:
	**Code:** 200 OK
 
 
	{
		[
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
    20,
    21,
    22,
    23,
    24,
    25
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET - http://localhost:8443/api/music/{id}
	Get music by id

* ##### URL:

	< /music/{id} >

* ##### Method:

	`GET`

* ##### Success Response:
	**Code:** 200 OK
  
  
	{
		{
    "id": 1,
    "styleName": "jazz"
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET - http://localhost:8443/api/music/style/{style}
	Get music by style

* ##### URL:

	< /music/style/{style} >

* ##### Method:

	`GET`

* ##### Success Response:
	**Code:** 200 OK


	{
		{
    "id": 1,
    "styleName": "jazz"
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### POST - http://localhost:8443/api/music
	Create new music

* ##### URL:

	< /api/music >

* ##### Method:

	`POST`

* ##### Success Response:
  	**Code:** 201 CREATED


	{
		{
    "id": 0,
    "styleName": "black metal"
		}
	}


* ##### Error response:

	**Code:** 500 INTERNAL SERVER ERROR or 400 BAD REQUEST


#### PUT - http://localhost:8443/api/music/{id} 
	Update music by id

* ##### URL:

	< /music/{id}  >

* ##### Method:

	`PUT`

* ##### Success Response:
  	**Code:** 200 OK

	{
		{
    "id": 57,
    "styleName": "hard metal"
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### DELETE - http://localhost:8443/api/music/{id}
	Delete music by id

* ##### URL:

	< /music/{id} >

* ##### Method:

	`DELETE`

* ##### Success Response:
  
  
	{
		{
    "id": 56,
    "styleName": "black metal"
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND or 401 UNAUTHORIZED



## CITY

#### GET - http://localhost:8443/api/city/all
	Get a list of all the cities

* ##### URL:

	< /city/all >

* ##### Method:

	`GET`

* ##### Success Response:
  

	{
		[
    {
        "id": 26,
        "cityName": "madrid",
        "country": "spain",
        "continent": "europe"
    },
    {
        "id": 27,
        "cityName": "barcelona",
        "country": "spain",
        "continent": "europe"
    },
    {
        "id": 28,
        "cityName": "rome",
        "country": "italy",
        "continent": "europe"
    },
    {
        "id": 29,
        "cityName": "helsinki",
        "country": "finland",
        "continent": "europe"
    },
    {
        "id": 30,
        "cityName": "dublin",
        "country": "ireland",
        "continent": "europe"
    },
    {
        "id": 31,
        "cityName": "amsterdam",
        "country": "netherlands",
        "continent": "europe"
    },
    {
        "id": 32,
        "cityName": "new york",
        "country": "usa",
        "continent": "america"
    },
    {
        "id": 33,
        "cityName": "l.a.",
        "country": "usa",
        "continent": "america"
    },
    {
        "id": 34,
        "cityName": "vancouver",
        "country": "canada",
        "continent": "america"
    },
    {
        "id": 35,
        "cityName": "mexico city",
        "country": "mexico",
        "continent": "america"
    },
    {
        "id": 36,
        "cityName": "buenos aires",
        "country": "argentina",
        "continent": "america"
    },
    {
        "id": 37,
        "cityName": "santiago",
        "country": "chile",
        "continent": "america"
    },
    {
        "id": 38,
        "cityName": "tokyo",
        "country": "japan",
        "continent": "asia"
    },
    {
        "id": 39,
        "cityName": "manila",
        "country": "philippines",
        "continent": "asia"
    },
    {
        "id": 40,
        "cityName": "beijing",
        "country": "china",
        "continent": "asia"
    },
    {
        "id": 41,
        "cityName": "shanghai",
        "country": "china",
        "continent": "asia"
    },
    {
        "id": 42,
        "cityName": "mumbai",
        "country": "india",
        "continent": "asia"
    },
    {
        "id": 43,
        "cityName": "nairobi",
        "country": "kenya",
        "continent": "africa"
    },
    {
        "id": 44,
        "cityName": "cape town",
        "country": "south africa",
        "continent": "africa"
    },
    {
        "id": 45,
        "cityName": "cairo",
        "country": "egypt",
        "continent": "africa"
    },
    {
        "id": 46,
        "cityName": "luanda",
        "country": "angola",
        "continent": "africa"
    },
    {
        "id": 47,
        "cityName": "tunis",
        "country": "tunisia",
        "continent": "africa"
    },
    {
        "id": 48,
        "cityName": "sidney",
        "country": "australia",
        "continent": "oceania"
    },
    {
        "id": 49,
        "cityName": "brisbane",
        "country": "australia",
        "continent": "oceania"
    },
    {
        "id": 50,
        "cityName": "wellington",
        "country": "new zealand",
        "continent": "oceania"
    }
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET- http://localhost:8443/api/city/all/name
	Get a list of all citie's names

* ##### URL:

	< /city/all/name >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK


	{
		[
    "madrid",
    "barcelona",
    "rome",
    "helsinki",
    "dublin",
    "amsterdam",
    "new york",
    "l.a.",
    "vancouver",
    "mexico city",
    "buenos aires",
    "santiago",
    "tokyo",
    "manila",
    "beijing",
    "shanghai",
    "mumbai",
    "nairobi",
    "cape town",
    "cairo",
    "luanda",
    "tunis",
    "sidney",
    "brisbane",
    "wellington"
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET - http://localhost:8443/api/city/all/id
	Get a list of all citie's ids

* ##### URL:

	< /city/all/id >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		[
    26,
    27,
    28,
    29,
    30,
    31,
    32,
    33,
    34,
    35,
    36,
    37,
    38,
    39,
    40,
    41,
    42,
    43,
    44,
    45,
    46,
    47,
    48,
    49,
    50
		]
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET - http://localhost:8443/api/city/{id}
	Get city info by city id

* ##### URL:

	< /city/{id} >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
    "id": 26,
    "cityName": "madrid",
    "country": "spain",
    "continent": "europe"
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### GET - http://localhost:8443/api/city/name/{name}
	Get city by name

* ##### URL:

	< /city/name/{name} >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
    "id": 27,
    "cityName": "barcelona",
    "country": "spain",
    "continent": "europe"
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### POST - http://localhost:8443/api/city
	Create new city

* ##### URL:

	< /city >

* ##### Method:

	`POST`

* ##### Success Response:

	**Code:** 201 CREATED
  

	{
		{
		    "id": 0,
		    "cityName": "gijón",
		    "country": "spain",
		    "continent": "europe"
		}
	}


* ##### Error response:

	**Code**: 401 UNAUTHORIZED or 400 BAD REQUEST or 500 INTERNAL SERVER ERROR


#### DELETE - http://localhost:8443/api/city/{id}
	Delete city by id

* ##### URL:

	< /city/{id} >

* ##### Method:

	`DELETE`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
	    "id": 58,
	    "cityName": "oviedo",
	    "country": "spain",
	    "continent": "europe"
		}
	}


* ##### Error response

	* Code: 404 NOT FOUND or 401 UNAUTHORIZED


#### PUT - http://localhost:8443/api/city/{id}
	Update city by id

* ##### URL:

	< /city/{id} >

* ##### Method:

	`PUT`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
    "id": 58,
    "cityName": "oviedo",
    "country": "spain",
    "continent": "europe"
		}
	}


* ##### Error response:

	PUT: **Code:** 404 NOT FOUND




## POPULARITY

#### http://localhost:8443/api/world/popularity/pagination

* ##### URL:

	< /world/popularity/pagination >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
    "content": [],
    "pageable": {
        "sort": {
            "unsorted": true,
            "sorted": false,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 0,
    "totalElements": 0,
    "last": true,
    "size": 20,
    "number": 0,
    "sort": {
        "unsorted": true,
        "sorted": false,
        "empty": true
    },
    "numberOfElements": 0,
    "first": true,
    "empty": true
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### http://localhost:8443/api/world/popularity/pagination?size=10

* ##### URL:

	< /world/popularity/pagination?size=10 >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  

	{
		{
    "content": [],
    "pageable": {
        "sort": {
            "unsorted": true,
            "sorted": false,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 0,
    "totalElements": 0,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "unsorted": true,
        "sorted": false,
        "empty": true
    },
    "numberOfElements": 0,
    "first": true,
    "empty": true
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### http://localhost:8443/api/{user_id}/popularity/pagination

* ##### URL:

	< /{user_id}/popularity/pagination >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  
 
	{
		{
		    "content": [],
		    "pageable": {
		        "sort": {
		            "unsorted": true,
		            "sorted": false,
		            "empty": true
		        },
		        "offset": 0,
		        "pageNumber": 0,
		        "pageSize": 20,
		        "paged": true,
		        "unpaged": false
		    },
		    "totalPages": 0,
		    "totalElements": 0,
		    "last": true,
		    "size": 20,
		    "number": 0,
		    "sort": {
		        "unsorted": true,
		        "sorted": false,
		        "empty": true
		    },
		    "numberOfElements": 0,
		    "first": true,
		    "empty": true
		}
	}


* ##### Error response:

	**Code:** 404 NOT FOUND


#### http://localhost:8443/api/popularity

* ##### URL:

	< /popularity >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  
  
    [
        "classical",
        "l.a.",
        100
    ],
    [
        "cumbia",
        "luanda",
        100
    ],
    [
        "indie",
        "sidney",
        100
    ],
    [
        "indie",
        "brisbane",
        100
    ],
    [
        "trap",
        "madrid",
        99
    ],
    [
        "pop",
        "amsterdam",
        99
    ],
    [
        "bolero",
        "amsterdam",
        99
    ],
    [
        "tv and film",
        "l.a.",
        99
    ],
    [
        "blues",
        "vancouver",
        99
    ],
    [
        "cover",
        "buenos aires",
        99
    ],
    [
        "latin",
        "manila",
        99
    ],
    [
        "cumbia",
        "manila",
        99
    ],
    [
        "romantic",
        "beijing",
        99
    ],
    [
        "cumbia",
        "mumbai",
        99
    ],
    [
        "singer-songwriter",
        "cairo",
        99
    ],
    [
        "bolero",
        "tunis",
        99
    ],
    [
        "indie",
        "wellington",
        99
    ],
    [
        "pop",
        "rome",
        98
    ],
    [
        "disco",
        "new york",
        98
    ],
    [
        "trap",
        "tokyo",
        98
    ],
    [
        "pop",
        "brisbane",
        98
    ],
    [
        "rock",
        "wellington",
        98
    ],
    [
        "country",
        "amsterdam",
        97
    ],
    [
        "jazz",
        "new york",
        97
    ],
    [
        "tv and film",
        "mexico city",
        97
    ],
    [
        "cover",
        "cairo",
        97
    ],
    [
        "rock",
        "amsterdam",
        96
    ],
    [
        "acoustic",
        "manila",
        96
    ],
    [
        "funk",
        "madrid",
        95
    ],
    [
        "pop",
        "madrid",
        95
    ],
    [
        "hard metal",
        "dublin",
        95
    ],
    [
        "urban",
        "new york",
        95
    ],
    [
        "hard metal",
        "beijing",
        95
    ],
    [
        "jazz",
        "mumbai",
        95
    ],
    [
        "funk",
        "cairo",
        95
    ],
    [
        "bossa-nova",
        "luanda",
        95
    ],
    [
        "pop",
        "wellington",
        95
    ],
    [
        "urban",
        "madrid",
        94
    ],
    [
        "disco",
        "madrid",
        94
    ],
    [
        "bossa-nova",
        "madrid",
        94
    ],
    [
        "metal",
        "manila",
        94
    ],
    [
        "hard metal",
        "shanghai",
        94
    ],
    [
        "cumbia",
        "cape town",
        94
    ],
    [
        "hard metal",
        "cairo",
        94
    ],
    [
        "punk",
        "brisbane",
        94
    ],
    [
        "romantic",
        "madrid",
        93
    ],
    [
        "rock",
        "tunis",
        93
    ],
    [
        "hard metal",
        "tunis",
        93
    ],
    [
        "soul",
        "barcelona",
        92
    ],
    [
        "acoustic",
        "new york",
        92
    ],
    [
        "cover",
        "tokyo",
        92
    ],
    [
        "electronic",
        "beijing",
        92
    ],
    [
        "jazz",
        "helsinki",
        91
    ],
    [
        "jazz",
        "sidney",
        91
    ],
    [
        "jazz",
        "brisbane",
        91
    ],
    [
        "tv and film",
        "madrid",
        90
    ],
    [
        "rock",
        "vancouver",
        90
    ],
    [
        "bolero",
        "mexico city",
        90
    ],
    [
        "disco",
        "mumbai",
        90
    ],
    [
        "r and b",
        "wellington",
        90
    ],
    [
        "punk",
        "new york",
        89
    ],
    [
        "romantic",
        "buenos aires",
        89
    ],
    [
        "urban",
        "santiago",
        89
    ],
    [
        "rock",
        "cairo",
        89
    ],
    [
        "romantic",
        "tunis",
        89
    ],
    [
        "country",
        "brisbane",
        89
    ],
    [
        "indie",
        "new york",
        88
    ],
    [
        "singer-songwriter",
        "tokyo",
        88
    ],
    [
        "urban",
        "luanda",
        88
    ],
    [
        "jazz",
        "tunis",
        88
    ],
    [
        "urban",
        "tunis",
        88
    ],
    [
        "cover",
        "vancouver",
        87
    ],
    [
        "disco",
        "brisbane",
        87
    ],
    [
        "latin",
        "dublin",
        86
    ],
    [
        "punk",
        "vancouver",
        86
    ],
    [
        "cumbia",
        "shanghai",
        86
    ],
    [
        "classical",
        "cairo",
        86
    ],
    [
        "r and b",
        "sidney",
        86
    ],
    [
        "funk",
        "wellington",
        86
    ],
    [
        "disco",
        "wellington",
        86
    ],
    [
        "electronic",
        "madrid",
        85
    ],
    [
        "singer-songwriter",
        "barcelona",
        85
    ],
    [
        "cumbia",
        "vancouver",
        85
    ],
    [
        "singer-songwriter",
        "mexico city",
        85
    ],
    [
        "tv and film",
        "manila",
        85
    ],
    [
        "romantic",
        "mumbai",
        85
    ],
    [
        "bossa-nova",
        "wellington",
        85
    ],
    [
        "cumbia",
        "mexico city",
        84
    ],
    [
        "rock",
        "santiago",
        84
    ],
    [
        "metal",
        "shanghai",
        84
    ],
    [
        "latin",
        "cairo",
        84
    ],
    [
        "punk",
        "luanda",
        84
    ],
    [
        "cumbia",
        "wellington",
        84
    ],
    [
        "singer-songwriter",
        "new york",
        83
    ],
    [
        "bossa-nova",
        "new york",
        83
    ],
    [
        "pop",
        "buenos aires",
        83
    ],
    [
        "singer-songwriter",
        "manila",
        83
    ],
    [
        "electronic",
        "mumbai",
        83
    ],
    [
        "hard metal",
        "mumbai",
        83
    ],
    [
        "r and b",
        "luanda",
        83
    ],
    [
        "jazz",
        "wellington",
        83
    ],
    [
        "cumbia",
        "amsterdam",
        82
    ],
    [
        "hard metal",
        "new york",
        82
    ],
    [
        "trap",
        "santiago",
        82
    ],
    [
        "blues",
        "manila",
        82
    ],
    [
        "urban",
        "beijing",
        82
    ],
    [
        "metal",
        "cairo",
        82
    ],
    [
        "classical",
        "wellington",
        82
    ],
    [
        "r and b",
        "madrid",
        81
    ],
    [
        "hard metal",
        "helsinki",
        81
    ],
    [
        "trap",
        "vancouver",
        81
    ],
    [
        "acoustic",
        "mexico city",
        81
    ],
    [
        "country",
        "manila",
        81
    ],
    [
        "urban",
        "mumbai",
        81
    ],
    [
        "rock",
        "madrid",
        80
    ],
    [
        "blues",
        "dublin",
        80
    ],
    [
        "blues",
        "new york",
        80
    ],
    [
        "metal",
        "new york",
        80
    ],
    [
        "cumbia",
        "l.a.",
        80
    ],
    [
        "rock",
        "manila",
        80
    ],
    [
        "romantic",
        "luanda",
        80
    ],
    [
        "r and b",
        "barcelona",
        79
    ],
    [
        "blues",
        "helsinki",
        79
    ],
    [
        "soul",
        "helsinki",
        79
    ],
    [
        "indie",
        "amsterdam",
        79
    ],
    [
        "soul",
        "vancouver",
        79
    ],
    [
        "acoustic",
        "vancouver",
        79
    ],
    [
        "rock",
        "mexico city",
        79
    ],
    [
        "pop",
        "tokyo",
        79
    ],
    [
        "pop",
        "vancouver",
        78
    ],
    [
        "cover",
        "santiago",
        78
    ],
    [
        "funk",
        "manila",
        78
    ],
    [
        "metal",
        "mumbai",
        78
    ],
    [
        "tv and film",
        "dublin",
        77
    ],
    [
        "electronic",
        "new york",
        77
    ],
    [
        "country",
        "sidney",
        77
    ],
    [
        "pop",
        "barcelona",
        76
    ],
    [
        "indie",
        "rome",
        76
    ],
    [
        "cumbia",
        "helsinki",
        76
    ],
    [
        "r and b",
        "dublin",
        76
    ],
    [
        "disco",
        "dublin",
        76
    ],
    [
        "metal",
        "amsterdam",
        76
    ],
    [
        "r and b",
        "new york",
        76
    ],
    [
        "classical",
        "new york",
        76
    ],
    [
        "r and b",
        "l.a.",
        76
    ],
    [
        "romantic",
        "mexico city",
        76
    ],
    [
        "cumbia",
        "beijing",
        76
    ],
    [
        "electronic",
        "barcelona",
        75
    ],
    [
        "metal",
        "helsinki",
        75
    ],
    [
        "electronic",
        "helsinki",
        75
    ],
    [
        "tv and film",
        "amsterdam",
        75
    ],
    [
        "country",
        "l.a.",
        75
    ],
    [
        "hard metal",
        "mexico city",
        75
    ],
    [
        "urban",
        "buenos aires",
        75
    ],
    [
        "hard metal",
        "buenos aires",
        75
    ],
    [
        "disco",
        "tokyo",
        75
    ],
    [
        "bolero",
        "beijing",
        75
    ],
    [
        "bolero",
        "shanghai",
        75
    ],
    [
        "country",
        "nairobi",
        75
    ],
    [
        "trap",
        "rome",
        74
    ],
    [
        "country",
        "vancouver",
        74
    ],
    [
        "latin",
        "mexico city",
        74
    ],
    [
        "tv and film",
        "tokyo",
        74
    ],
    [
        "r and b",
        "manila",
        74
    ],
    [
        "trap",
        "shanghai",
        74
    ],
    [
        "indie",
        "mumbai",
        74
    ],
    [
        "punk",
        "nairobi",
        74
    ],
    [
        "latin",
        "luanda",
        74
    ],
    [
        "cover",
        "tunis",
        74
    ],
    [
        "urban",
        "sidney",
        74
    ],
    [
        "latin",
        "rome",
        73
    ],
    [
        "acoustic",
        "rome",
        73
    ],
    [
        "disco",
        "vancouver",
        73
    ],
    [
        "soul",
        "mexico city",
        73
    ],
    [
        "trap",
        "luanda",
        73
    ],
    [
        "electronic",
        "luanda",
        73
    ],
    [
        "classical",
        "brisbane",
        73
    ],
    [
        "singer-songwriter",
        "dublin",
        72
    ],
    [
        "blues",
        "mexico city",
        72
    ],
    [
        "cover",
        "mexico city",
        72
    ],
    [
        "soul",
        "nairobi",
        72
    ],
    [
        "cover",
        "madrid",
        71
    ],
    [
        "blues",
        "rome",
        71
    ],
    [
        "punk",
        "amsterdam",
        71
    ],
    [
        "urban",
        "amsterdam",
        71
    ],
    [
        "acoustic",
        "l.a.",
        71
    ],
    [
        "classical",
        "vancouver",
        71
    ],
    [
        "latin",
        "brisbane",
        71
    ],
    [
        "urban",
        "barcelona",
        70
    ],
    [
        "tv and film",
        "helsinki",
        70
    ],
    [
        "metal",
        "l.a.",
        70
    ],
    [
        "acoustic",
        "buenos aires",
        70
    ],
    [
        "romantic",
        "cairo",
        70
    ],
    [
        "singer-songwriter",
        "madrid",
        69
    ],
    [
        "cover",
        "amsterdam",
        69
    ],
    [
        "latin",
        "new york",
        69
    ],
    [
        "romantic",
        "new york",
        69
    ],
    [
        "pop",
        "shanghai",
        69
    ],
    [
        "acoustic",
        "sidney",
        69
    ],
    [
        "urban",
        "rome",
        68
    ],
    [
        "tv and film",
        "cape town",
        68
    ],
    [
        "soul",
        "sidney",
        68
    ],
    [
        "rock",
        "sidney",
        68
    ],
    [
        "bossa-nova",
        "dublin",
        67
    ],
    [
        "bossa-nova",
        "vancouver",
        67
    ],
    [
        "disco",
        "barcelona",
        66
    ],
    [
        "jazz",
        "dublin",
        66
    ],
    [
        "punk",
        "santiago",
        66
    ],
    [
        "cumbia",
        "santiago",
        66
    ],
    [
        "bossa-nova",
        "manila",
        66
    ],
    [
        "cover",
        "beijing",
        66
    ],
    [
        "rock",
        "nairobi",
        66
    ],
    [
        "romantic",
        "brisbane",
        66
    ],
    [
        "bolero",
        "wellington",
        66
    ],
    [
        "blues",
        "nairobi",
        65
    ],
    [
        "jazz",
        "cairo",
        65
    ],
    [
        "acoustic",
        "cairo",
        65
    ],
    [
        "disco",
        "tunis",
        65
    ],
    [
        "latin",
        "sidney",
        65
    ],
    [
        "romantic",
        "barcelona",
        64
    ],
    [
        "blues",
        "amsterdam",
        64
    ],
    [
        "soul",
        "amsterdam",
        64
    ],
    [
        "romantic",
        "vancouver",
        64
    ],
    [
        "blues",
        "buenos aires",
        64
    ],
    [
        "soul",
        "manila",
        64
    ],
    [
        "jazz",
        "beijing",
        64
    ],
    [
        "blues",
        "luanda",
        64
    ],
    [
        "acoustic",
        "amsterdam",
        63
    ],
    [
        "funk",
        "vancouver",
        63
    ],
    [
        "indie",
        "mexico city",
        63
    ],
    [
        "cumbia",
        "buenos aires",
        63
    ],
    [
        "tv and film",
        "shanghai",
        63
    ],
    [
        "tv and film",
        "tunis",
        63
    ],
    [
        "tv and film",
        "sidney",
        63
    ],
    [
        "latin",
        "wellington",
        63
    ],
    [
        "trap",
        "wellington",
        63
    ],
    [
        "pop",
        "helsinki",
        62
    ],
    [
        "country",
        "helsinki",
        62
    ],
    [
        "rock",
        "shanghai",
        62
    ],
    [
        "electronic",
        "nairobi",
        62
    ],
    [
        "r and b",
        "cairo",
        62
    ],
    [
        "bolero",
        "luanda",
        62
    ],
    [
        "bossa-nova",
        "barcelona",
        61
    ],
    [
        "latin",
        "helsinki",
        61
    ],
    [
        "urban",
        "l.a.",
        61
    ],
    [
        "classical",
        "buenos aires",
        61
    ],
    [
        "tv and film",
        "santiago",
        61
    ],
    [
        "classical",
        "sidney",
        61
    ],
    [
        "bossa-nova",
        "brisbane",
        61
    ],
    [
        "rock",
        "beijing",
        60
    ],
    [
        "funk",
        "shanghai",
        60
    ],
    [
        "singer-songwriter",
        "luanda",
        60
    ],
    [
        "rock",
        "brisbane",
        60
    ],
    [
        "bolero",
        "brisbane",
        60
    ],
    [
        "blues",
        "barcelona",
        59
    ],
    [
        "cumbia",
        "rome",
        59
    ],
    [
        "jazz",
        "amsterdam",
        59
    ],
    [
        "tv and film",
        "vancouver",
        59
    ],
    [
        "funk",
        "beijing",
        59
    ],
    [
        "metal",
        "cape town",
        59
    ],
    [
        "electronic",
        "cape town",
        59
    ],
    [
        "blues",
        "cairo",
        59
    ],
    [
        "indie",
        "santiago",
        58
    ],
    [
        "blues",
        "beijing",
        58
    ],
    [
        "jazz",
        "shanghai",
        58
    ],
    [
        "bossa-nova",
        "tunis",
        58
    ],
    [
        "electronic",
        "brisbane",
        58
    ],
    [
        "tv and film",
        "rome",
        57
    ],
    [
        "bossa-nova",
        "amsterdam",
        57
    ],
    [
        "funk",
        "santiago",
        57
    ],
    [
        "pop",
        "manila",
        57
    ],
    [
        "country",
        "beijing",
        57
    ],
    [
        "acoustic",
        "shanghai",
        57
    ],
    [
        "acoustic",
        "mumbai",
        57
    ],
    [
        "cumbia",
        "cairo",
        57
    ],
    [
        "funk",
        "rome",
        56
    ],
    [
        "classical",
        "helsinki",
        56
    ],
    [
        "punk",
        "dublin",
        56
    ],
    [
        "trap",
        "l.a.",
        56
    ],
    [
        "singer-songwriter",
        "l.a.",
        56
    ],
    [
        "indie",
        "luanda",
        56
    ],
    [
        "electronic",
        "l.a.",
        55
    ],
    [
        "indie",
        "vancouver",
        55
    ],
    [
        "trap",
        "barcelona",
        54
    ],
    [
        "r and b",
        "vancouver",
        54
    ],
    [
        "classical",
        "mexico city",
        54
    ],
    [
        "singer-songwriter",
        "beijing",
        54
    ],
    [
        "pop",
        "tunis",
        54
    ],
    [
        "bolero",
        "madrid",
        53
    ],
    [
        "r and b",
        "rome",
        53
    ],
    [
        "urban",
        "dublin",
        53
    ],
    [
        "disco",
        "l.a.",
        53
    ],
    [
        "latin",
        "nairobi",
        53
    ],
    [
        "cover",
        "luanda",
        53
    ],
    [
        "jazz",
        "barcelona",
        52
    ],
    [
        "bolero",
        "l.a.",
        52
    ],
    [
        "romantic",
        "manila",
        52
    ],
    [
        "electronic",
        "shanghai",
        52
    ],
    [
        "bolero",
        "mumbai",
        52
    ],
    [
        "cover",
        "nairobi",
        52
    ],
    [
        "country",
        "cape town",
        52
    ],
    [
        "punk",
        "tunis",
        52
    ],
    [
        "electronic",
        "sidney",
        52
    ],
    [
        "metal",
        "mexico city",
        51
    ],
    [
        "latin",
        "tokyo",
        51
    ],
    [
        "classical",
        "manila",
        51
    ],
    [
        "tv and film",
        "luanda",
        51
    ],
    [
        "trap",
        "tunis",
        51
    ],
    [
        "blues",
        "brisbane",
        51
    ],
    [
        "metal",
        "barcelona",
        50
    ],
    [
        "bolero",
        "new york",
        50
    ],
    [
        "funk",
        "sidney",
        50
    ],
    [
        "r and b",
        "brisbane",
        50
    ],
    [
        "disco",
        "rome",
        49
    ],
    [
        "electronic",
        "mexico city",
        49
    ],
    [
        "r and b",
        "buenos aires",
        49
    ],
    [
        "indie",
        "buenos aires",
        49
    ],
    [
        "bossa-nova",
        "mumbai",
        49
    ],
    [
        "trap",
        "cape town",
        49
    ],
    [
        "funk",
        "barcelona",
        48
    ],
    [
        "classical",
        "barcelona",
        48
    ],
    [
        "country",
        "mexico city",
        48
    ],
    [
        "latin",
        "buenos aires",
        48
    ],
    [
        "hard metal",
        "santiago",
        48
    ],
    [
        "pop",
        "beijing",
        48
    ],
    [
        "latin",
        "cape town",
        48
    ],
    [
        "cover",
        "wellington",
        48
    ],
    [
        "cumbia",
        "madrid",
        47
    ],
    [
        "singer-songwriter",
        "helsinki",
        47
    ],
    [
        "cover",
        "dublin",
        47
    ],
    [
        "jazz",
        "vancouver",
        47
    ],
    [
        "jazz",
        "tokyo",
        47
    ],
    [
        "disco",
        "manila",
        47
    ],
    [
        "singer-songwriter",
        "brisbane",
        47
    ],
    [
        "pop",
        "santiago",
        46
    ],
    [
        "r and b",
        "tokyo",
        46
    ],
    [
        "rock",
        "tokyo",
        46
    ],
    [
        "cumbia",
        "sidney",
        46
    ],
    [
        "latin",
        "amsterdam",
        45
    ],
    [
        "disco",
        "amsterdam",
        45
    ],
    [
        "tv and film",
        "new york",
        45
    ],
    [
        "indie",
        "beijing",
        45
    ],
    [
        "funk",
        "cape town",
        45
    ],
    [
        "singer-songwriter",
        "cape town",
        45
    ],
    [
        "classical",
        "tunis",
        45
    ],
    [
        "cumbia",
        "brisbane",
        45
    ],
    [
        "hard metal",
        "barcelona",
        44
    ],
    [
        "disco",
        "helsinki",
        44
    ],
    [
        "electronic",
        "amsterdam",
        44
    ],
    [
        "pop",
        "new york",
        44
    ],
    [
        "funk",
        "nairobi",
        44
    ],
    [
        "classical",
        "nairobi",
        44
    ],
    [
        "bossa-nova",
        "cape town",
        44
    ],
    [
        "bossa-nova",
        "l.a.",
        43
    ],
    [
        "electronic",
        "vancouver",
        43
    ],
    [
        "trap",
        "manila",
        43
    ],
    [
        "cover",
        "shanghai",
        43
    ],
    [
        "blues",
        "madrid",
        42
    ],
    [
        "rock",
        "new york",
        42
    ],
    [
        "r and b",
        "mexico city",
        42
    ],
    [
        "disco",
        "santiago",
        42
    ],
    [
        "latin",
        "beijing",
        42
    ],
    [
        "punk",
        "beijing",
        42
    ],
    [
        "blues",
        "shanghai",
        42
    ],
    [
        "r and b",
        "shanghai",
        42
    ],
    [
        "country",
        "shanghai",
        42
    ],
    [
        "singer-songwriter",
        "wellington",
        42
    ],
    [
        "latin",
        "vancouver",
        41
    ],
    [
        "indie",
        "tokyo",
        41
    ],
    [
        "blues",
        "tunis",
        41
    ],
    [
        "soul",
        "wellington",
        41
    ],
    [
        "hard metal",
        "madrid",
        40
    ],
    [
        "cumbia",
        "barcelona",
        40
    ],
    [
        "romantic",
        "rome",
        40
    ],
    [
        "soul",
        "beijing",
        40
    ],
    [
        "country",
        "mumbai",
        40
    ],
    [
        "funk",
        "luanda",
        40
    ],
    [
        "punk",
        "mexico city",
        39
    ],
    [
        "classical",
        "santiago",
        39
    ],
    [
        "bolero",
        "santiago",
        39
    ],
    [
        "cumbia",
        "tokyo",
        39
    ],
    [
        "metal",
        "nairobi",
        39
    ],
    [
        "disco",
        "nairobi",
        39
    ],
    [
        "trap",
        "buenos aires",
        38
    ],
    [
        "jazz",
        "santiago",
        38
    ],
    [
        "blues",
        "mumbai",
        38
    ],
    [
        "latin",
        "mumbai",
        38
    ],
    [
        "classical",
        "mumbai",
        38
    ],
    [
        "cumbia",
        "nairobi",
        38
    ],
    [
        "bossa-nova",
        "nairobi",
        38
    ],
    [
        "trap",
        "sidney",
        38
    ],
    [
        "punk",
        "wellington",
        38
    ],
    [
        "punk",
        "buenos aires",
        37
    ],
    [
        "tv and film",
        "nairobi",
        37
    ],
    [
        "rock",
        "cape town",
        37
    ],
    [
        "country",
        "cairo",
        37
    ],
    [
        "cover",
        "brisbane",
        37
    ],
    [
        "punk",
        "helsinki",
        36
    ],
    [
        "trap",
        "mexico city",
        36
    ],
    [
        "electronic",
        "santiago",
        36
    ],
    [
        "romantic",
        "shanghai",
        36
    ],
    [
        "jazz",
        "cape town",
        36
    ],
    [
        "bolero",
        "cairo",
        36
    ],
    [
        "acoustic",
        "wellington",
        36
    ],
    [
        "latin",
        "barcelona",
        35
    ],
    [
        "indie",
        "dublin",
        35
    ],
    [
        "singer-songwriter",
        "buenos aires",
        35
    ],
    [
        "electronic",
        "manila",
        35
    ],
    [
        "trap",
        "brisbane",
        35
    ],
    [
        "funk",
        "helsinki",
        34
    ],
    [
        "metal",
        "santiago",
        34
    ],
    [
        "indie",
        "manila",
        34
    ],
    [
        "hard metal",
        "nairobi",
        34
    ],
    [
        "electronic",
        "tunis",
        34
    ],
    [
        "metal",
        "wellington",
        34
    ],
    [
        "electronic",
        "wellington",
        34
    ],
    [
        "rock",
        "rome",
        33
    ],
    [
        "indie",
        "helsinki",
        33
    ],
    [
        "hard metal",
        "amsterdam",
        33
    ],
    [
        "country",
        "new york",
        33
    ],
    [
        "trap",
        "new york",
        33
    ],
    [
        "bolero",
        "manila",
        33
    ],
    [
        "r and b",
        "beijing",
        33
    ],
    [
        "singer-songwriter",
        "mumbai",
        33
    ],
    [
        "indie",
        "tunis",
        33
    ],
    [
        "country",
        "tunis",
        33
    ],
    [
        "tv and film",
        "wellington",
        33
    ],
    [
        "acoustic",
        "madrid",
        32
    ],
    [
        "country",
        "barcelona",
        32
    ],
    [
        "bolero",
        "barcelona",
        32
    ],
    [
        "country",
        "rome",
        32
    ],
    [
        "urban",
        "helsinki",
        32
    ],
    [
        "country",
        "santiago",
        32
    ],
    [
        "bolero",
        "nairobi",
        32
    ],
    [
        "rock",
        "luanda",
        32
    ],
    [
        "pop",
        "sidney",
        32
    ],
    [
        "soul",
        "rome",
        31
    ],
    [
        "funk",
        "l.a.",
        31
    ],
    [
        "punk",
        "l.a.",
        31
    ],
    [
        "singer-songwriter",
        "vancouver",
        31
    ],
    [
        "rock",
        "mumbai",
        31
    ],
    [
        "tv and film",
        "cairo",
        31
    ],
    [
        "singer-songwriter",
        "sidney",
        31
    ],
    [
        "funk",
        "new york",
        30
    ],
    [
        "bolero",
        "tokyo",
        30
    ],
    [
        "metal",
        "luanda",
        30
    ],
    [
        "jazz",
        "rome",
        29
    ],
    [
        "urban",
        "nairobi",
        29
    ],
    [
        "country",
        "luanda",
        29
    ],
    [
        "cumbia",
        "tunis",
        29
    ],
    [
        "acoustic",
        "brisbane",
        29
    ],
    [
        "romantic",
        "dublin",
        28
    ],
    [
        "urban",
        "mexico city",
        28
    ],
    [
        "soul",
        "buenos aires",
        28
    ],
    [
        "electronic",
        "tokyo",
        28
    ],
    [
        "urban",
        "manila",
        28
    ],
    [
        "cover",
        "manila",
        28
    ],
    [
        "hard metal",
        "manila",
        28
    ],
    [
        "r and b",
        "nairobi",
        28
    ],
    [
        "r and b",
        "helsinki",
        27
    ],
    [
        "bossa-nova",
        "buenos aires",
        27
    ],
    [
        "disco",
        "cape town",
        27
    ],
    [
        "soul",
        "luanda",
        27
    ],
    [
        "r and b",
        "tunis",
        27
    ],
    [
        "cover",
        "barcelona",
        26
    ],
    [
        "bolero",
        "helsinki",
        26
    ],
    [
        "acoustic",
        "helsinki",
        26
    ],
    [
        "bossa-nova",
        "helsinki",
        26
    ],
    [
        "trap",
        "dublin",
        26
    ],
    [
        "classical",
        "amsterdam",
        26
    ],
    [
        "soul",
        "tokyo",
        26
    ],
    [
        "metal",
        "sidney",
        26
    ],
    [
        "metal",
        "rome",
        25
    ],
    [
        "funk",
        "buenos aires",
        25
    ],
    [
        "urban",
        "shanghai",
        25
    ],
    [
        "funk",
        "mumbai",
        25
    ],
    [
        "rock",
        "buenos aires",
        24
    ],
    [
        "tv and film",
        "brisbane",
        24
    ],
    [
        "rock",
        "l.a.",
        23
    ],
    [
        "urban",
        "vancouver",
        23
    ],
    [
        "funk",
        "mexico city",
        23
    ],
    [
        "pop",
        "mexico city",
        23
    ],
    [
        "acoustic",
        "tokyo",
        23
    ],
    [
        "romantic",
        "cape town",
        23
    ],
    [
        "metal",
        "brisbane",
        23
    ],
    [
        "bossa-nova",
        "rome",
        22
    ],
    [
        "rock",
        "helsinki",
        22
    ],
    [
        "pop",
        "l.a.",
        22
    ],
    [
        "bolero",
        "buenos aires",
        22
    ],
    [
        "soul",
        "santiago",
        22
    ],
    [
        "indie",
        "shanghai",
        22
    ],
    [
        "punk",
        "cairo",
        22
    ],
    [
        "singer-songwriter",
        "rome",
        21
    ],
    [
        "cover",
        "helsinki",
        21
    ],
    [
        "cover",
        "l.a.",
        21
    ],
    [
        "romantic",
        "tokyo",
        21
    ],
    [
        "jazz",
        "manila",
        21
    ],
    [
        "trap",
        "beijing",
        21
    ],
    [
        "classical",
        "luanda",
        21
    ],
    [
        "classical",
        "rome",
        20
    ],
    [
        "electronic",
        "rome",
        20
    ],
    [
        "cover",
        "rome",
        20
    ],
    [
        "singer-songwriter",
        "amsterdam",
        20
    ],
    [
        "soul",
        "new york",
        20
    ],
    [
        "punk",
        "tokyo",
        20
    ],
    [
        "bossa-nova",
        "beijing",
        20
    ],
    [
        "punk",
        "mumbai",
        20
    ],
    [
        "acoustic",
        "luanda",
        20
    ],
    [
        "classical",
        "dublin",
        19
    ],
    [
        "r and b",
        "santiago",
        19
    ],
    [
        "latin",
        "santiago",
        19
    ],
    [
        "singer-songwriter",
        "santiago",
        19
    ],
    [
        "metal",
        "tokyo",
        19
    ],
    [
        "urban",
        "tokyo",
        19
    ],
    [
        "singer-songwriter",
        "shanghai",
        19
    ],
    [
        "soul",
        "mumbai",
        19
    ],
    [
        "hard metal",
        "cape town",
        19
    ],
    [
        "romantic",
        "santiago",
        18
    ],
    [
        "urban",
        "cairo",
        18
    ],
    [
        "hard metal",
        "sidney",
        18
    ],
    [
        "pop",
        "dublin",
        17
    ],
    [
        "country",
        "dublin",
        17
    ],
    [
        "metal",
        "buenos aires",
        17
    ],
    [
        "bossa-nova",
        "santiago",
        17
    ],
    [
        "blues",
        "tokyo",
        17
    ],
    [
        "disco",
        "cairo",
        17
    ],
    [
        "latin",
        "tunis",
        17
    ],
    [
        "indie",
        "barcelona",
        16
    ],
    [
        "electronic",
        "buenos aires",
        16
    ],
    [
        "classical",
        "shanghai",
        16
    ],
    [
        "cover",
        "mumbai",
        16
    ],
    [
        "romantic",
        "nairobi",
        16
    ],
    [
        "jazz",
        "luanda",
        16
    ],
    [
        "disco",
        "sidney",
        16
    ],
    [
        "rock",
        "barcelona",
        15
    ],
    [
        "bolero",
        "dublin",
        15
    ],
    [
        "country",
        "buenos aires",
        15
    ],
    [
        "country",
        "tokyo",
        15
    ],
    [
        "indie",
        "cairo",
        15
    ],
    [
        "hard metal",
        "luanda",
        15
    ],
    [
        "blues",
        "sidney",
        15
    ],
    [
        "acoustic",
        "barcelona",
        14
    ],
    [
        "electronic",
        "dublin",
        14
    ],
    [
        "romantic",
        "l.a.",
        14
    ],
    [
        "jazz",
        "buenos aires",
        14
    ],
    [
        "classical",
        "tokyo",
        14
    ],
    [
        "hard metal",
        "tokyo",
        14
    ],
    [
        "classical",
        "beijing",
        14
    ],
    [
        "trap",
        "nairobi",
        14
    ],
    [
        "acoustic",
        "nairobi",
        14
    ],
    [
        "funk",
        "tunis",
        14
    ],
    [
        "rock",
        "dublin",
        13
    ],
    [
        "metal",
        "beijing",
        13
    ],
    [
        "latin",
        "shanghai",
        13
    ],
    [
        "pop",
        "luanda",
        13
    ],
    [
        "country",
        "wellington",
        13
    ],
    [
        "metal",
        "vancouver",
        12
    ],
    [
        "disco",
        "buenos aires",
        12
    ],
    [
        "bolero",
        "sidney",
        12
    ],
    [
        "cover",
        "sidney",
        12
    ],
    [
        "romantic",
        "amsterdam",
        11
    ],
    [
        "jazz",
        "mexico city",
        11
    ],
    [
        "tv and film",
        "buenos aires",
        11
    ],
    [
        "r and b",
        "mumbai",
        11
    ],
    [
        "blues",
        "cape town",
        11
    ],
    [
        "hard metal",
        "brisbane",
        11
    ],
    [
        "jazz",
        "madrid",
        10
    ],
    [
        "soul",
        "madrid",
        10
    ],
    [
        "trap",
        "helsinki",
        10
    ],
    [
        "romantic",
        "helsinki",
        10
    ],
    [
        "latin",
        "l.a.",
        10
    ],
    [
        "funk",
        "tokyo",
        10
    ],
    [
        "cover",
        "cape town",
        10
    ],
    [
        "electronic",
        "cairo",
        10
    ],
    [
        "soul",
        "tunis",
        10
    ],
    [
        "punk",
        "sidney",
        10
    ],
    [
        "blues",
        "wellington",
        10
    ],
    [
        "romantic",
        "wellington",
        10
    ],
    [
        "metal",
        "madrid",
        9
    ],
    [
        "country",
        "madrid",
        9
    ],
    [
        "hard metal",
        "l.a.",
        9
    ],
    [
        "bolero",
        "vancouver",
        9
    ],
    [
        "disco",
        "beijing",
        9
    ],
    [
        "acoustic",
        "beijing",
        9
    ],
    [
        "punk",
        "shanghai",
        9
    ],
    [
        "singer-songwriter",
        "nairobi",
        9
    ],
    [
        "r and b",
        "cape town",
        9
    ],
    [
        "punk",
        "cape town",
        9
    ],
    [
        "soul",
        "cairo",
        9
    ],
    [
        "soul",
        "brisbane",
        9
    ],
    [
        "punk",
        "rome",
        8
    ],
    [
        "acoustic",
        "dublin",
        8
    ],
    [
        "jazz",
        "l.a.",
        8
    ],
    [
        "blues",
        "l.a.",
        8
    ],
    [
        "soul",
        "l.a.",
        8
    ],
    [
        "soul",
        "shanghai",
        8
    ],
    [
        "classical",
        "madrid",
        7
    ],
    [
        "funk",
        "amsterdam",
        7
    ],
    [
        "acoustic",
        "santiago",
        7
    ],
    [
        "trap",
        "mumbai",
        7
    ],
    [
        "bolero",
        "cape town",
        7
    ],
    [
        "romantic",
        "sidney",
        7
    ],
    [
        "bossa-nova",
        "sidney",
        7
    ],
    [
        "funk",
        "brisbane",
        7
    ],
    [
        "tv and film",
        "barcelona",
        6
    ],
    [
        "cover",
        "new york",
        6
    ],
    [
        "disco",
        "mexico city",
        6
    ],
    [
        "indie",
        "nairobi",
        6
    ],
    [
        "indie",
        "cape town",
        6
    ],
    [
        "acoustic",
        "tunis",
        6
    ],
    [
        "bolero",
        "rome",
        5
    ],
    [
        "cumbia",
        "new york",
        5
    ],
    [
        "bossa-nova",
        "mexico city",
        5
    ],
    [
        "tv and film",
        "mumbai",
        5
    ],
    [
        "soul",
        "cape town",
        5
    ],
    [
        "bossa-nova",
        "cairo",
        5
    ],
    [
        "indie",
        "l.a.",
        4
    ],
    [
        "tv and film",
        "beijing",
        4
    ],
    [
        "jazz",
        "nairobi",
        4
    ],
    [
        "trap",
        "cairo",
        4
    ],
    [
        "urban",
        "brisbane",
        4
    ],
    [
        "hard metal",
        "rome",
        3
    ],
    [
        "bossa-nova",
        "tokyo",
        3
    ],
    [
        "disco",
        "shanghai",
        3
    ],
    [
        "classical",
        "cape town",
        3
    ],
    [
        "pop",
        "cairo",
        3
    ],
    [
        "disco",
        "luanda",
        3
    ],
    [
        "metal",
        "tunis",
        3
    ],
    [
        "punk",
        "barcelona",
        2
    ],
    [
        "funk",
        "dublin",
        2
    ],
    [
        "cumbia",
        "dublin",
        2
    ],
    [
        "trap",
        "amsterdam",
        2
    ],
    [
        "blues",
        "santiago",
        2
    ],
    [
        "bossa-nova",
        "shanghai",
        2
    ],
    [
        "pop",
        "mumbai",
        2
    ],
    [
        "acoustic",
        "cape town",
        2
    ],
    [
        "singer-songwriter",
        "tunis",
        2
    ],
    [
        "hard metal",
        "wellington",
        2
    ],
    [
        "latin",
        "madrid",
        1
    ],
    [
        "indie",
        "madrid",
        1
    ],
    [
        "punk",
        "madrid",
        1
    ],
    [
        "r and b",
        "amsterdam",
        1
    ],
    [
        "hard metal",
        "vancouver",
        1
    ],
    [
        "pop",
        "nairobi",
        1
    ],
    [
        "pop",
        "cape town",
        1
    ],
    [
        "urban",
        "cape town",
        1
    ],
    [
        "urban",
        "wellington",
        1
    ],
    [
        "soul",
        "dublin",
        0
    ],
    [
        "metal",
        "dublin",
        0
    ],
    [
        "punk",
        "manila",
        0
    ]


* ##### Error response:

	**Code:** 404 NOT FOUND


#### http://localhost:8443/api/popularity/top

* ##### URL:

	< /popularity/top >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  

    [
        "indie",
        "sidney",
        100
    ],
    [
        "classical",
        "l.a.",
        100
    ],
    [
        "indie",
        "brisbane",
        100
    ],
    [
        "cumbia",
        "luanda",
        100
    ],
    [
        "blues",
        "vancouver",
        99
    ],
    [
        "pop",
        "amsterdam",
        99
    ],
    [
        "romantic",
        "beijing",
        99
    ],
    [
        "tv and film",
        "l.a.",
        99
    ],
    [
        "trap",
        "madrid",
        99
    ],
    [
        "latin",
        "manila",
        99
    ]


* ##### Error response:

	**Code:** 404 NOT FOUND


#### http://localhost:8443/api/{user_id}/popularity

* ##### URL:

	< /{user_id}/popularity >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  
  
    [
        "jazz",
        "madrid",
        10
    ],
    [
        "jazz",
        "dublin",
        66
    ],
    [
        "jazz",
        "new york",
        97
    ],
    [
        "jazz",
        "cairo",
        65
    ],
    [
        "jazz",
        "sidney",
        91
    ],
    [
        "funk",
        "madrid",
        95
    ],
    [
        "funk",
        "dublin",
        2
    ],
    [
        "funk",
        "new york",
        30
    ],
    [
        "funk",
        "cairo",
        95
    ],
    [
        "funk",
        "sidney",
        50
    ],
    [
        "soul",
        "madrid",
        10
    ],
    [
        "soul",
        "dublin",
        0
    ],
    [
        "soul",
        "new york",
        20
    ],
    [
        "soul",
        "cairo",
        9
    ],
    [
        "soul",
        "sidney",
        68
    ],
    [
        "r and b",
        "madrid",
        81
    ],
    [
        "r and b",
        "dublin",
        76
    ],
    [
        "r and b",
        "new york",
        76
    ],
    [
        "r and b",
        "cairo",
        62
    ],
    [
        "r and b",
        "sidney",
        86
    ],
    [
        "classical",
        "madrid",
        7
    ],
    [
        "classical",
        "dublin",
        19
    ],
    [
        "classical",
        "new york",
        76
    ],
    [
        "classical",
        "cairo",
        86
    ],
    [
        "classical",
        "sidney",
        61
    ]


* ##### Error response:

	**Code:** 404 NOT FOUND


#### http://localhost:8443/api/{user_id}/popularity/top

* ##### URL:

	< /{user_id}/popularity/top >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  
        [
            "jazz",
            "new york",
            97
        ],
        [
            "funk",
            "madrid",
            95
        ],
        [
            "funk",
            "cairo",
            95
        ],
        [
            "jazz",
            "sidney",
            91
        ],
        [
            "classical",
            "cairo",
            86
        ],
        [
            "r and b",
            "sidney",
            86
        ],
        [
            "r and b",
            "madrid",
            81
        ],
        [
            "classical",
            "new york",
            76
        ],
        [
            "r and b",
            "dublin",
            76
        ],
        [
            "r and b",
            "new york",
            76
        ]


* ##### Error response:

	**Code:** 404 NOT FOUND



## GENERATE DATA

#### http://localhost:8443/api/generate_data

* ##### URL:

	< /generate_data >

* ##### Method:

	`GET`

* ##### Success Response:

	**Code:** 200 OK
  
                
        {
         "Data has been generated"
        }

* ##### Error response:

	**Code:** 404 NOT FOUND
