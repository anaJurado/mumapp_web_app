# MuMApp - Music Map Web App

**App name:** MuMApp\
**Developers team members:**
- Ana M Jurado Crespo 
    - email: anajuradoc@alumnos.urjc.es
    - github: https://github.com/anaJurado
    
---

##What is MuMApp about?

This app allows you to choose your favorite music styles and preferred cities all around the globe. 
With that information, MuMApp provides you with the latest popularity rates of those styles in your chosen cities. 
You can also check the info of the most popular music styles all around the globe.

---

## App Main Aspects 
### Entities
This app has 3 main entities:
- User
- Music
- City

A user can choose n music styles and m cities.
A music style can be chosen by n users and every style is related to every city.
A city can be chosen by n users and every city is related to every music style.
Every musical style is related to every cities sharing one attribute, the popularity rate of that style in that city.

### User permissions
The application contemplates three types of users:
- *Not registed:* Only have access to the main page and login page
- *Registed user:* It has access to the dashboard and profile pages
- *Admin:* It has also access to the admin panel

### Images
Every registed user and admin user have the option to upload a profile image to be used in the profile page and top navbar

![](https://github.com/anaJurado/mumapp_web_app/blob/update_readme/documents/profile_image.png)

### Graphics
In the dashboard view we can find a bar graphic showing:
- *X axis:* music and city tuples chosen by the user
- *Y axis:* Popularity rate between 0 and 100

![](https://github.com/anaJurado/mumapp_web_app/blob/update_readme/documents/graphic_bar.png)

There is a couple of tables that show data as well in the dashboard page.

### Complementary Tech
TO BE DETERMINED

### Advance Query
Due to the nature of the data schema that it's been created from the code by Spring I had to implement some advance queries.
Any query related to popularity rates had to be written as a because it wasn't possible to use the prebuilt Spring Data methods.
For example, to be able to find the popularity rates between the music styles and cities choosen by a user, this quey had to be implemented as follows:

    @Query ( value = "SELECT m.style_name, c.city_name, music_city.popularity_rate 
                      FROM music_city 
                            JOIN music m on music_city.music_id = m.id 
                            JOIN city c on music_city.city_id = c.id 
                      WHERE music_id in 
                                ( SELECT music_id as userMusicId 
                                  FROM user JOIN user_music um on user.id = um.user_id 
                                  WHERE user.id = ?1 ) 
                            and city_id in 
                                ( SELECT city_id as userCityId 
                                FROM user JOIN user_city uc on user.id = uc.user_id 
                                WHERE user.id = ?1 )
                      ",
             nativeQuery = true)
    Page<Object> findPopularityRateByUserIdPagination(long id, Pageable page);

As the popularity rate is randomly generated and can be "refresh" by the user, we've created three queries that populates the *music_city* table with all the music styles and cities using cross join first and then generates a random number between 0 and 100 to populate the field *popularity_rate*

    @Modifying
    @Query( value="INSERT INTO music_city (music_id, city_id) SELECT music.id music_id, city.id as city_id 
                    FROM music CROSS JOIN city",
            nativeQuery=true)
    void crossJoinMusicCity();

    @Modifying
    @Query( value="UPDATE music_city SET popularity_rate = 100 * RAND() WHERE 1",
            nativeQuery=true)
    void randomData();

More advance queries can be found in MusicRepository.java

### Web Navigation
Here is a scheme of the navigation that is possible to do in the app differentiating by the different users roles
![](https://github.com/anaJurado/mumapp_web_app/blob/update_readme/documents/mumapp-webnavigation_non-registered_user.png)
![](https://github.com/anaJurado/mumapp_web_app/blob/update_readme/documents/mumapp-web_navigation_admin.png)

You can also see it here:

