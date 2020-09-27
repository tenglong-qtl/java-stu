package org.zicheng.stu.thread;

import com.sun.xml.internal.ws.api.pipe.Pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Author: zicheng
 * Since: 2020-09-27 18:58
 */
public class ThreadPiped {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        writer.connect(reader);

        new ThreadReader(reader).start();
        Thread.sleep(500L);
        new ThreadWriter(writer).start();
    }
}

class ThreadReader extends Thread {
    private PipedReader pipedReader;

    public ThreadReader(PipedReader pipedReader) {
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        try {
            int i = -1;
            while ((i = pipedReader.read()) != -1){
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pipedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadWriter extends Thread {
    private PipedWriter pipedWriter;

    public ThreadWriter(PipedWriter pipedWriter) {
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
        try {
            pipedWriter.write("Test".toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pipedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
