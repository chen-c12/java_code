package hadoop419;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/22 17:09
* FileName: DedupMapper
* Description: 
*/
public class DedupMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    private static Text field = new Text();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text,Text, NullWritable>.Context context) throws IOException, InterruptedException {
        field = value;
        context.write(field, NullWritable.get());
    }
}
