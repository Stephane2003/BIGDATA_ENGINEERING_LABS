package edu.supmti.hadoop.hdfslab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class ReadHDFS {
    public static void main(String[] args) throws IOException {
        // Vérifier que l'utilisateur a bien passé un paramètre
        if (args.length < 1) {
            System.out.println("Usage: ReadHDFS <hdfs_file_path>");
            System.exit(1);
        }

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        // Utiliser le paramètre passé en ligne de commande
        Path nomComplet = new Path(args[0]);

        FSDataInputStream inStream = fs.open(nomComplet);
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        inStream.close();
        fs.close();
    }
}

