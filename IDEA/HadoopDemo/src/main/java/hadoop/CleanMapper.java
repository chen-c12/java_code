package hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CleanMapper extends Mapper<LongWritable, Text, Text, NullWritable>{
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String jobResultData = "";		
		//将每个数据文件的内容转为String类型
		String reptileData = value.toString();
		//通过截取字符串的方式获取content中的数据
		String jobData = reptileData.substring(
				reptileData.indexOf("=",reptileData.indexOf("=")+1)+1,
				reptileData.length()-1);
		try {
			//获取content中的数据内容
			JSONObject contentJson = new JSONObject(jobData);
			String contentData = contentJson.getString("content");
			//获取content下positionResult中的数据内容		
			JSONObject positionResultJson = new JSONObject(contentData);
			String positionResultData =
					positionResultJson.getString("positionResult");
			//获取最终result中的数据内容
			JSONObject resultJson = new JSONObject(positionResultData);
			JSONArray resultData = resultJson.getJSONArray("result");
			
			jobResultData = CleanJob.resultToString(resultData);
			
			context.write(new Text(jobResultData), NullWritable.get());
			} catch (JSONException e) {
				e.printStackTrace();
		}
	}
}
