package com.wqh.util;

import com.wqh.base.Suf;

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
                    if (tempList[i].getPath().endsWith(Suf.txt.toString())) {
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
     * 文件名写入到文件中，覆盖原文
     *
     * @param path 文件地址
     */
    public static void write(String path) {
        write(path, path, false);
    }

    /**
     * 将文件内容写入到文件中，覆盖原文
     *
     * @param path 文件地址
     * @param str  写入的内容
     */
    public static void write(String path, String str) {
        write(path, str, false);
    }

    /**
     * 文件名写入到文件中，可选是否覆盖原文
     *
     * @param path   文件地址
     * @param append 是否覆盖
     */
    public static void write(String path, boolean append) {
        write(path, path, append);
    }

    /**
     * @param path   文件地址
     * @param str    写入的内容
     * @param append 是否覆盖
     */
    public static void write(String path, String str, boolean append) {
        File file = new File(path);

        if (file.isDirectory()) {
            System.out.println("这不是一个文件");
            return;
        }
        if (!file.getPath().endsWith(Suf.txt.toString())) {
            System.out.println("这不是一个文本文件");
            return;
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file, append);
            byte[] bytes = str.getBytes();
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





