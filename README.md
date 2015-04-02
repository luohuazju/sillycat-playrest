# sillycat-playrest
Use Playframework 2.x Build RESTful Services Based on JAVA8

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
