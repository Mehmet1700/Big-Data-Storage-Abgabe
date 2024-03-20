import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CopyToHDFS {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9000"), conf);
            Path srcPath = new Path("/./resources/ladestationen.csv");
            Path destPath = new Path("/input/ladestationen.csv");
            fs.copyFromLocalFile(srcPath, destPath);
            System.out.println("File copied to HDFS successfully!");
            fs.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
