# Fewcharts
Fewcharts is a ranking system focused mainly on music that allows you to find out who is the best. Through Fewcharts you can add your own preferences in 50 characters and create topic by voting with your friends. It's 100% free and will always be.

#Start del progetto da linea di comando
- installare Tomcat 7 ( http://tomcat.apache.org/download-70.cgi )
- installare maven ( https://maven.apache.org/download.cgi )
- installare git ( https://git-scm.com/downloads )
- `git clone https://github.com/Fewcharts/Fewcharts.git`
- `cd Fewcharts`
- `mvn clean install`

#Start del progetto con Eclipse
- installare git ( https://git-scm.com/downloads )
- `git clone https://github.com/Fewcharts/Fewcharts.git`
- installare maven e un plugin per git
- aprire git perspective
- cliccare su "add an existing local git repository"
- cliccare su browse e navigare alla cartella dove è stato fatto il clone 
- click destro su Fewcharts[master] e click su "Import Maven Projects..."
- click su finish

#Configurazione
- copiare il file default.config.properties in config.properties
- impostare tutti i parametri del config.properties
- impostare il parametro di avvio della virtual machine 
  `-Dfewcharts.config.path="/path/to/config.properties"`

#Come contribuire (tratto da https://help.github.com/articles/fork-a-repo/ ):
- fork del progetto su github.com
- copiare sugli appunti l'URL del tuo fork
- aprire il terminale
  - `git clone https://github.com/MIO_USERNAME/Fewcharts.git`
  - `git remote -v`
  - `git remote add upstream https://github.com/Fewcharts/Fewcharts.git`
  - `git remote -v`
- mantenere il proprio fork sincronizzato col repository upstream
  - `git fetch upstream`
  - `git checkout master`
  - `git merge upstream/master`
- mandare la pull request su github.com

#Come deployare su heroku:
- aprire il terminale
  - `git checkout heroku_deploy`
  - `git push heroku heroku_deploy:master`
