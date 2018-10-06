package com.wqh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * 读写文件工具类
 *
 * @author jianjian
 * @date 2018/9/13 0013
 */
public class Util {
    /**
     * 读取目标路径下所有的txt文件，放入list
     *
     * @param path  文件夹路径
     * @param files 存储文件夹
     */
    public static void readFileNames(String path, List<String> files) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println(path + "文件夹不存在");
            return;
        }
        if (files == null) {
            files = new Vector<>();
        }
        File[] tempList = file.listFiles();
        if (tempList != null) {
            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isFile()) {
                    if (tempList[i].getPath().endsWith(".txt")) {
                        System.out.println("已找到文本文件：" + tempList[i]);
                        files.add(tempList[i].toString());
                    }
                }
                if (tempList[i].isDirectory()) {
                    //递归调用
                    readFileNames(tempList[i].getPath(), files);
                }
            }
        }
    }

    /**
     * @param path 文件地址
     */
    public static void write(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            System.out.println("这不是一个文件");
            return;
        }

        if (!file.getPath().endsWith(".txt")) {
            System.out.println("这不是一个文本文件");
            return;
        }

        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file, true);
            byte[] bytes = ("\r\n" + path).getBytes();
            outputStream.write(bytes);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}





