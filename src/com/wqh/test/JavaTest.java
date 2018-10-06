package com.wqh.test;

import com.wqh.thread.Read;
import com.wqh.thread.Write;

import java.util.List;
import java.util.Vector;

/**
 * @author jianjian
 * @date 2018/9/13 0013
 */
public class JavaTest {
    public static void main(String[] args) {

        List<String> files = new Vector<>();
        String path1 = "D:/text";
        String path2 = "E:/text";
        Read read1 = new Read(path1, files);
        Read read2 = new Read(path2, files);
        Write write = new Write(files);
        read1.start();
        read2.start();
        write.start();
    }
}
