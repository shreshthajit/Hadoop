package org.danvk.hadoop;
 
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 
//public class WordCountMapper extends
//        Mapper<Object, Text, Text, IntWritable> {
//
//    private final IntWritable ONE = new IntWritable(1);
//    private Text word = new Text();
//
//    public void map(Object key, Text value, Context context)
//            throws IOException, InterruptedException {
//
//        final String ipAddress = value.toString();
//        final String[] data = ipAddress.trim().split(" ");
//        if (data.length > 1) {
//            final String docname = data[6];
//            word.set(docname);
//            context.write(word,ONE);
//        }
//
////        final String line = value.toString().trim();
////        final int firstIndex = line.indexOf("\"");
////        final int lastIndex = line.lastIndexOf("\"");
////        if (firstIndex > 1 && lastIndex > 2) {
////            final String requestString = line.substring(firstIndex + 1, lastIndex);
////            final String actualURL = requestString.split(" ")[1];
////            if(actualURL.startsWith("http")) {
////                final URL url = new URL(actualURL);
////                word.set(url.getPath());
////            } else {
////                word.set(actualURL);
////            }
////            context.write(word, ONE);
////        }
//    }
//}



public class WordCountMapper extends
        Mapper<Object, Text, Text, CustomMinMaxTuple> {

    private final IntWritable ONE = new IntWritable(1);

    private Text departmentName = new Text();
    private CustomMinMaxTuple outTuple = new CustomMinMaxTuple();


    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        final String data = value.toString();
//        final String[] data = ipAddress.trim().split(" ");
//        final String[] field = data.split(",", -1);
        final String[] field = data.trim().split(" ");

        Integer salary = 0;



//        if (data.length > 1) {
//            final String docname = data[6];
//            word.set(docname);
//            context.write(word,ONE);
//        }


        if (null != field) {
            //salary=Integer.parseInt(field[7]);
            salary = 1;
            long cnt = outTuple.getCount();
            outTuple.setMin(salary);
            outTuple.setMax(cnt);
            outTuple.setCount(salary);
            departmentName.set(field[0]);
            context.write(departmentName, outTuple);
        }

    }
}
