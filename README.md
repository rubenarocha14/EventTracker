# EventTracker

# Description pt.1
This application is designed to track the rounds of golf played by a player, and
at a course. The player, course and round all have CRUD functionality, however the
round will default to adding player 1 and course 1 regardless of whether the a player
and course id was provided in the JSON. The course and player entities each have
many rounds associated with it, however a round only has one player and one courses
associated with it. The program is accessed through the endpoints provided in the
`#End Points` section of this file.

# Description pt.2
I wasn't able to get my toggle update to work to display the update player form. I should have it fixed
after lunch. All other CRUD functionality is working. The project was pretty straight
forward, so there weren't too many hiccups as far as functionality goes. All actions remain
on the index.html page, and I used toggles to be able to hide and display forms rather
than sending to another page.

# Description pt.3 Angular
Continuing to build off of the same project, it has been revamped to be a single page, dynamic site.
Full CRUD functionality performed by dynamically loading pages without routing to new urls. The index page
opens with the site logo, a greeting, the list of players who have played at Pebble Beach, and a forms
to add a new player. Users can click on players to see their home of record, and edit it if they wish.
Users are able to delete players by clicking the delete icon in the player table as well.



# Lessons Learned pt. 1
This application was fairly simple, however I was able to cement the difference between
the service layer and DAO layer after doing more research on the difference. By the third
Controller, I was able to quickly resolve my errors and conceptually understand the stack
trace regarding missing annotations or mapping errors.

# Lessons Learned pt. 3
Not necessarily a lesson, but a current struggle and hopefully soon solution. I have a logo image displayed in the header, however I couldn't figure out how to add an onclick event to get it to display the initial index page. I'd like to figure that out to make the site more functionally sound. Currently, to exit out of the
player detail and show the create player form again, you have to refresh the site. Otherwise you end up stuck on the page with only update and delete functionality. 

# Technology
STS, Postman, Udemy, Git, GitHub, JS, CSS, Angular

# End Points

|  CRUD Op.    | HTTP Verb  |       URI                |  RequestBody          |        ResponseBody     |
|---------------|------------|--------------------------|-----------------------|------------------------|
|Read Player    |GET         |`api/players`             |                       | List of all Players    |
|Read Player    |GET         |`api/players/{playerId}`  |                       | Singular Player        |
|Create Player  |POST        |`api/players/`            |JSON for new Player    | JSON of created Player |
|Update Player  |PUT         |`api/players/{playerId}`  |JSON for update Player | JSON of updated Player |
|Delete Player  |DELETE      |`api/players/{playerId}`  |                       |                        |
|---------------|------------|--------------------------|-----------------------|------------------------|
|Read Course    |GET         |`api/courses`             |                       | List of all Courses    |
|Read Course    |GET         |`api/course{courseId}`    |                       | Singular Course        |
|Create Course  |POST        |`api/courses`             |JSON for new Course    | JSON of created Course |
|Update Course  |PUT         |`api/courses{courseId}`   |JSON for update Course | JSON of updated Course |
|Delete Course  |DELETE      |`api/courses{courseId}`   |                       |                        |
|---------------|------------|--------------------------|-----------------------|------------------------|
|Read Round     |GET         |`api/rounds`              |                       | List of all Rounds     |
|Read Round     |GET         |`api/rounds{roundId}`     |                       | Singular Round         |
|Create Round   |POST        |`api/rounds`              |JSON for new Round     | JSON of created Round  |
|Update Round   |PUT         |`api/rounds{roundId}`     |JSON for update Round  | JSON of updated Round  |
|Delete Round   |DELETE      |`api/rounds{roundId}`     |                       |                        |
|---------------|------------|--------------------------|-----------------------|------------------------|
