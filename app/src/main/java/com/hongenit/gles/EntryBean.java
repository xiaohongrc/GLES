package com.hongenit.gles;

/**
 * Created by hongenit on 18/1/23.
 */

class EntryBean {
    private String name;
    private Class data;


    public EntryBean(String name, Class data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Class getData() {
        return data;
    }

    public void setData(Class data) {
        this.data = data;
    }

}
