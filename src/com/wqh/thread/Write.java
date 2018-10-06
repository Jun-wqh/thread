package com.wqh.thread;

import com.wqh.util.Util;

import java.util.List;

/**
 * 写文件名线程
 *
 * @author jianjian
 * @date 2018/9/13 0013
 */
public class Write extends Thread {
    private List<String> list;

    public Write(List<String> list) {
        this.list = list;
    }


    @Override
    public void run() {
        while (list == null || list.size() == 0) {
            System.out.println("等待中：");
        }
        while (list != null && list.size() != 0) {
            System.out.println("正在写入文件：" + list.get(0));
            Util.write(list.get(0));
            list.remove(0);
        }
        System.out.println("运行完毕。。。");
    }
}
