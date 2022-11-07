# EventTracker

#Description
This application is designed to track the rounds of golf played by a player, and
at a course. The player, course and round all have CRUD functionality, however the
round will default to adding player 1 and course 1 regardless of whether the a player
and course id was provided in the JSON. The course and player entities each have
many rounds associated with it, however a round only has one player and one courses
associated with it. The program is accessed through the endpoints provided in the
`#End Points` section of this file.

#Lessons Learned
This application was fairly simple, however I was able to cement the difference between
the service layer and DAO layer after doing more research on the difference. By the third
Controller, I was able to quickly resolve my errors and conceptually understand the stack
trace regarding missing annotations or mapping errors.

#Technology
STS, Postman, Udemy, Git, GitHub

#End Points

    CRUD Op.    | HTTP Verb  |       URI                |  RequestBody          |        ResponseBody
|---------------|------------|--------------------------|-----------------------|------------------------|
 Read Player    |GET         |`api/players`             |                       | List of all Players
 Read Player    |GET         |`api/players/{playerId}`  |                       | Singular Player
 Create Player  |POST        |`api/players/`            |JSON for new Player    | JSON of created Player
 Update Player  |PUT         |`api/players/{playerId}`  |JSON for update Player | JSON of updated Player
 Delete Player  |DELETE      |`api/players/{playerId}`  |                       |                      
|---------------|------------|--------------------------|-----------------------|------------------------|
 Read Course    |GET         |`api/courses`             |                       | List of all Courses
 Read Course    |GET         |`api/course{courseId}`    |                       | Singular Course
 Create Course  |POST        |`api/courses`             |JSON for new Course    | JSON of created Course
 Update Course  |PUT         |`api/courses{courseId}`   |JSON for update Course | JSON of updated Course
 Delete Course  |DELETE      |`api/courses{courseId}`   |                       |
|---------------|------------|--------------------------|-----------------------|------------------------|
 Read Round     |GET         |`api/rounds`              |                       | List of all Rounds
 Read Round     |GET         |`api/rounds{roundId}`     |                       | Singular Round
 Create Round   |POST        |`api/rounds`              |JSON for new Round     | JSON of created Round
 Update Round   |PUT         |`api/rounds{roundId}`     |JSON for update Round  | JSON of updated Round
 Delete Round   |DELETE      |`api/rounds{roundId}`     |                       |
|---------------|------------|--------------------------|-----------------------|------------------------|
