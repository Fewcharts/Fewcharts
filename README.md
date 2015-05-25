# Fewcharts
Fewcharts is a ranking system focused mainly on music that allows you to find out who is the best. Through Fewcharts you can add your own preferences in 50 characters and create topic by voting with your friends. It's 100% free and will always be.

# Start project in Eclipse

- install maven
- install tomcat 7
- install git plugin for eclipse
- git checkout
- in git perspective click "add existing git repository" and select the folder where you checked out the project
- right click in Fewcharts > Import Projects ...
- select "Import using the new project wizard" and click finish
- select Web > Dynamic web project and click next
- edit project name
- untick "Use default location" under project location and select the folder where you checked out the project
- click finish
- add VM parameter -Dfewcharts.config.path="/path/to/config.properties"
- create local file config.properties and populate with properties from the default.config.properties file