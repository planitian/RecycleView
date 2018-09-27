package com.admin.plani.item;

/**
 * 创建时间 2018/9/26
 *
 * @author plani
 */
public class TestBean {
    private String image;
    private String size;
    private int age;

    public TestBean(String image, String size, int age) {
        this.image = image;
        this.size = size;
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "image='" + image + '\'' +
                ", size='" + size + '\'' +
                ", age=" + age +
                '}';
    }
}
