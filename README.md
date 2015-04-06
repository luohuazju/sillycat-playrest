# sillycat-playrest
Use Playframework 2.x Build RESTful Services Based on JAVA8.

Using native SQL to build the DAO layer based on DBUtils. Using flyway to do the DB migration.

Flyway supports sbt, maven and etc, supports API for java/scala and etc.

(DAO test is based on localhost/test database with username/password=tester/tester)
(Local running is based on localhost/playrest database with username/password=playrest/playrest)

Command to Debug during developing
>activator run

Command to run the Test

>activator test

Command to run one test
>activator "testOnly Application*"

Command to migrate the database
>activator flywayMigrate

Command to clean the database
>activator flywayClean

Release
>activator dist

Command to run the release binary
>bin/sillycat-playrest -Dconfig.file=./conf/application-local.conf -Dhttp.port=9001 -Dhttp.address=0.0.0.0
