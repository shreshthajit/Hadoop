package org.danvk.hadoop;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.yarn.webapp.view.TextPage;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    int max_val = -1;
    int loop = 0;
    int inc = 0;
    int incre=0;
    String path = null;
    public void reduce(Text text, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;

        incre++;
//        System.out.println(text);
        if(text.equals(new Text("000000000000"))){
            for (IntWritable value : values) {
                loop += value.get();
            }
        }
        else{
            for(IntWritable value : values) {
                count += value.get();
                inc ++;
            }
            if(count > max_val){
                max_val = count;
                path = new String(text.toString());
//                System.out.println(path);
            }
//            System.out.println(path);
//        System.out.println(inc);
            if(inc == loop && inc != 0 && !text.equals(new Text("000000000000"))){
//                System.out.println(path);
                //context.write(new Text(path), new IntWritable(max_val));
//                context.write(new Text(""),new IntWritable(incre));
                  context.write(new Text(""),new IntWritable(incre));

            }
        }
    }
}