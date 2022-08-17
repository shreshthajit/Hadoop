package org.danvk.hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class CustomMinMaxTuple implements Writable {
    private Integer min = new Integer(0);
    private long max = new Integer(0);
    private long count = 1;
    private  long finalmx=new Integer(0);
    public Integer getMin() {
        return min;
    }
    public void setMin(Integer min) {
        this.min = min;
    }
    public long getMax() {
        return max;
    }
    public void setMax(long max) {
        this.max = count;
        if(finalmx<count) finalmx=count;
    }
    public long getfinalmax() {
        return finalmx;
    }


    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public void readFields(DataInput in) throws IOException {
        min = in.readInt();
        max = in.readLong();
        count = in.readLong();
        finalmx=in.readLong();
    }
    public void write(DataOutput out) throws IOException {
        out.writeInt(min);
        out.writeLong(max);
        out.writeLong(count);
        out.writeLong(finalmx);
    }
//    public String toString() {
//        return min + "\t" + finalmx + "\t" + count;
//    }


    public String toString() {
//        return "\t"+finalmx + "\t" + count;
        return  "\t" + count;
    }
}