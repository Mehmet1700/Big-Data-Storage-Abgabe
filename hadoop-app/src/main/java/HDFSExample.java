import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HDFSExample {

    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(URI.create("hdfs://localhost:9000"), conf);

            // Pfad zur lokalen CSV-Datei
            String localFilePath = "hadoop-app/src/resources/ladestationen.csv";
            // Ziel-Pfad im HDFS
            String hdfsFilePath = "hadoop-app/src/resources/Output";

            // Laden der lokalen Datei ins HDFS
            Path src = new Path(localFilePath);
            Path dst = new Path(hdfsFilePath);
            fs.copyFromLocalFile(src, dst);
            System.out.println("CSV-Datei wurde ins HDFS geladen.");

            // Überprüfen des Dateiformats und Zugriff auf die Datei im HDFS
            InputStream inputStream = fs.open(dst);
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            while (bytesRead != -1) {
                System.out.write(buffer, 0, bytesRead);
                bytesRead = inputStream.read(buffer);
            }
            inputStream.close();

            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
