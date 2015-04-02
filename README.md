# sillycat-playrest
Use Playframework 2.x Build RESTful Services Based on JAVA8

Command to Debug during developing
>activator -Dconfig.file=/Users/carl/work/sillycat/sillycat-playrest/conf/application-local.conf run


Command to run the Test
>activator test

Command to migrate the database
>sbt flywayMigrate

Command to clean the database
>sbt flywayClean