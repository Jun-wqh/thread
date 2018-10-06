package com.wqh.thread;

import com.wqh.util.Util;

import java.util.List;

/**
 * 读文件名线程
 *
 * @author jianjian
 * @date 2018/9/13 0013
 */
public class Read extends Thread {
    private String path;
    private List<String> list;

    public Read(String path, List<String> list) {
        this.path = path;
        this.list = list;
    }

    @Override
    public void run() {
        Util.readFileNames(path, list);
    }
}
