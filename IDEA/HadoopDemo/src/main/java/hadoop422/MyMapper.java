package hadoop422;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/22 17:40
* FileName: MyMapper
* Description: 
*/
public class MyMapper extends Mapper<Object, Text,Text, IntWritable> {
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] array = line.split(",");
        String keyOutPut = array[1];
        context.write(new Text(keyOutPut),new IntWritable(1));
    }
}
