package org.danvk.hadoop;
 
import java.io.IOException;
import java.util.Objects;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 
public class WordCountMapper extends
        Mapper<Object, Text, Text, IntWritable> {
 
    private final IntWritable ONE = new IntWritable(1);
    private Text mapKey = new Text();
 
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
               String valueString = value.toString();
        final String[] data = valueString.trim().split(" ");
        if (data.length > 1) {
            final String ipAddress = data[0];
            if (Objects.equals(ipAddress, "10.223.157.186")) {
                mapKey.set(ipAddress);
                context.write(mapKey, ONE);
            }
        }



    }
}
