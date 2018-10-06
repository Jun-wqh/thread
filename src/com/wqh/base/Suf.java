package com.wqh.base;

/**
 * @author jianjian
 * @date 2018/10/6 0006
 */
public enum Suf {
    /**
     *
     */
    txt(".txt");
    private String name;

    /**
     * @param name
     */
    Suf(String name) {
        this.name = name;
    }

    public boolean equals(String str) {
        return name.equals(str);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
