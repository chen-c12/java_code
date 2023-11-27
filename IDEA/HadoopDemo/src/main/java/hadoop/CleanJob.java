package hadoop;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CleanJob {
	public static String deleteString(String str,char delChat) {
		StringBuffer stringBuffer = new StringBuffer("");
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i) != delChat) {
				stringBuffer.append(str.charAt(i));
			}
		}
		return stringBuffer.toString();
	}
	
	
	
	public static String mergeString(String position ,JSONArray company)throws JSONException{
		String result="";
		if(company.length() != 0) {
			for(int i=0;i<company.length();i++) {
				result = result + company.get(i) + "-";
			}
		}
		if(position != "") {
			String[] positionList = position.split("|;|,|、|,|;|/");
			for (int i=0;i<positionList.length;i++) {
				result = result + positionList[i].replaceAll("[\\pP\\p{Punct}]","")+"-";
			}
		}
		return result.substring(0,result.length()-1);
	}
	
	
	public static String killResult (JSONArray killData)throws JSONException{
		String result = "";
		if(killData.length() != 0) {
		for (int i=0;i<killData.length();i++) {
			result = result + killData.get(i) + "-";
			}
		return result.substring(0,result.length()-1);
		}else {
			return "null";
		}
	}
	
	
	public static String resultToString(JSONArray jobdata)throws JSONException{
		String jobResultData="";
		for(int i=0;i<jobdata.length();i++) {
			String everyData=jobdata.get(i).toString();
			JSONObject everyDataJson = new JSONObject(everyData);
			String city = everyDataJson.getString("city");
			String salary = everyDataJson.getString("salary");
			String positionAdvantage = everyDataJson.getString("positionAdvantage");
			JSONArray companyLabelList = everyDataJson.getJSONArray("companyLabelList");
			JSONArray skillLables = everyDataJson.getJSONArray("skillLables");
			String salaryNew = deleteString (salary,'k');
			String welfare = mergeString(positionAdvantage,companyLabelList);
			String kill = killResult(skillLables);
			if(i == jobdata.length()-1) {
				jobResultData = jobResultData + city +","+salaryNew+","+welfare+","+kill;
			}else {
			jobResultData = jobResultData+city+","+salaryNew+","+welfare+","+kill+"\n";
			}
		}
		return jobResultData;
	}
}
