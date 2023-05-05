package com.pojo;

public class Area {
    private int id;
    private String code;
    private String name;
    private String pcode;

    public Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pcode='" + pcode + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public Area(int id, String code, String name, String pcode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.pcode = pcode;
    }

    public Area() {
    }
}
