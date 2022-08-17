package org.danvk.hadoop;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends
        Mapper<Object, Text, Text, IntWritable> {

    private final IntWritable ONE = new IntWritable(1);
    private Text mapKey = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String valueString = value.toString();
        String[] SingleCountryData = valueString.split(" ");
//        System.out.println(SingleCountryData[6].split("/"));
        String[] path = SingleCountryData[6].split("/");
        if (path.length > 0) {
            String[] fileName = path[path.length - 1].split("\\?");
//            System.out.println(fileName[0]);
            if(fileName.length > 0) {
                mapKey.set(fileName[0]);
                context.write(mapKey, ONE);
                context.write(new Text("000000000000"), ONE);
            }
        }







//        String valueString = value.toString()
//        final String[] data = valueString.trim().split(" ");
//        if (data.length > 1) {
//            Question 1
//            final String ipAddress = data[0];
//            if (Objects.equals(ipAddress, "10.223.157.186")) {
//                mapKey.set(ipAddress);
//                context.write(mapKey, ONE);
//            }
//
//            Question 2
//            final String url = data[6];
//            if (Objects.equals(url, "/assets/js/the-associates.js")) {
//                mapKey.set(url);
//                context.write(mapKey, ONE);
//            }
//        }
    }
}