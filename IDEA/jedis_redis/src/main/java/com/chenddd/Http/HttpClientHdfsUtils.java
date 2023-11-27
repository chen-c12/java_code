package com.chenddd.Http;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chenddd
 * @title: HttpClientHdfsUtils
 * @projectName jedis_redis
 * @description: Hdfs´æ´¢
 * @date 2022/3/3114:21
 */
public class HttpClientHdfsUtils {
    public static void createFileBySysTime(String url,String fileName,String data){
        System.setProperty("HADOOP_USER_NAME", "root");
        Path path = null;
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String filePath = format.format(time);
        Configuration conf = new Configuration();
        URI uri = URI.create(url);
        FileSystem fileSystem;
        try {
            fileSystem = FileSystem.get(uri,conf);
            path = new Path("/JobData/"+filePath);
            if (!fileSystem.exists(path)){
                fileSystem.mkdirs(path);
            }
            FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path(path.toString() + "/" + fileName));
            IOUtils.copyBytes(new ByteArrayInputStream(data.getBytes()), fsDataOutputStream, conf, true);
            fileSystem.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
