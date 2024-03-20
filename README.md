# Big-Data-Storage-Abgabe

Wichtige Commands 

 su - hdoop

./start-hadoop.sh

## Erstellen von Verzeichnissen
hdfs dfs -mkdir -p input
hdfs dfs -mkdir -p /intermediate
hdfs dfs -mkdir -p /output

hdfs dfs -put /home/student/PERSISTENT/Big-Data-Storage-Abgabe/Big-Data-Storage-Abgabe/hadoop-app/src/resources/ladestationen.csv /input

Die Daten sind jetzt in den Ordner input geladen.

