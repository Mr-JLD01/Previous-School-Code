package stubs;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper; 
import org.apache.hadoop.conf.Configuration;

public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private boolean isCaseSensitive = false;
	
  public void setup(Context context) {            
		Configuration conf =  context.getConfiguration(); 
		isCaseSensitive =  Boolean.parseBoolean(conf.get("caseSensitive"));
		}
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO implement
     */
	  String line = value.toString();
	  
	  for(String word : line.split("\\W+")){
		  if(word.length() > 0){
			  if (isCaseSensitive)
			  	context.write(new Text(word.substring(0,1)), new IntWritable(word.length()));
			  else
				  context.write(new Text(word.substring(0,1).toLowerCase()), new IntWritable(word.length()));
		  }
	  }

  }
}
