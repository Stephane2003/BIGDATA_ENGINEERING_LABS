package edu.supmti.hadoop.hdfslab;

import java.io.IOException;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;


public class WriteHDFS {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        Path nomComplet = new Path(args[0]);

        if (!fs.exists(nomComplet)) {
            FSDataOutputStream outStream = fs.create(nomComplet, true);
            outStream.writeBytes("Bonjour tout le monde !");
            outStream.writeBytes(args[1]);
            outStream.close();
        }

        fs.close();
    }
}

