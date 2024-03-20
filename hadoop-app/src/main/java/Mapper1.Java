import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper1 extends Mapper<LongWritable, Text, Text, Text> {

    private Text outputKey = new Text();
    private Text outputValue = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Split the CSV line into tokens
        StringTokenizer tokenizer = new StringTokenizer(value.toString(), ",");
        
        // Extract fields from the CSV
        String operator = tokenizer.nextToken().trim();
        int chargingPoints = Integer.parseInt(tokenizer.nextToken().trim());
        int powerRating = Integer.parseInt(tokenizer.nextToken().trim());

        // Emit operator as the key and chargingPoints and powerRating as the value
        outputKey.set(operator);
        outputValue.set(chargingPoints + "," + powerRating);
        context.write(outputKey, outputValue);
    }
}
