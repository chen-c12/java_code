package hadoop422;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/22 17:44
* FileName: MyReducer
* Description: 
*/
public class MyReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable val:values){
            sum += val.get();
        }
        context.write(key, new IntWritable(sum));
    }
}
