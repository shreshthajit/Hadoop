package org.danvk.hadoop;
 
import java.io.IOException;
 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
//public class WordCountReducer extends
//        Reducer<Text, IntWritable, Text, IntWritable> {
//
//    public void reduce(Text text, Iterable<IntWritable> values, Context context)
//            throws IOException, InterruptedException {
//        int sum = 0;
//        for (IntWritable value : values) {
//            sum += value.get();
//        }
//        context.write(text, new IntWritable(sum));
//    }
//}





public class WordCountReducer extends
        Reducer<Text, CustomMinMaxTuple, Text, CustomMinMaxTuple> {

    private CustomMinMaxTuple result = new CustomMinMaxTuple();

    public void reduce(Text key, Iterable<CustomMinMaxTuple> values, Context context)
            throws IOException, InterruptedException {
//        int sum = 0;
//        for (IntWritable value : values) {
//            sum += value.get();
//        }
//        context.write(text, new IntWritable(sum));


        result.setMin(null);
        result.setMax(0);
        result.setCount(0);
        long sum = 0;
        for (CustomMinMaxTuple minMaxCountTuple : values) {
            if (result.getMax() == 0 || (minMaxCountTuple.getMax() > result.getMax())) {
                result.setMax(minMaxCountTuple.getMax());
            }
            if (result.getMin() == null || (minMaxCountTuple.getMin() < result.getMin())) {
                result.setMin(minMaxCountTuple.getMin());
            }
            sum = sum + minMaxCountTuple.getCount();
            result.setCount(sum);
        }

//        for(CustomMinMaxTuple val:values){
//            if(sum>val.getCount()){
//                result.setMax(sum);
//            }
//            else result.setMax(val.getCount());
//        }
        //result.setMax(sum);
        context.write(new Text(key.toString()), result);
    }
}













