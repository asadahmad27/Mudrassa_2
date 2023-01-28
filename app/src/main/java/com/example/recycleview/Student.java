package com.example.recycleview;

import java.util.ArrayList;

public class Student {
    public class Data {
        int manzil;
        int sabaq;
        int sabqi;

        public Data(int manzil, int sabaq, int sabqi) {
            this.manzil = manzil;
            this.sabaq = sabaq;
            this.sabqi = sabqi;
        }

        public int getManzil() {
            return manzil;
        }

        public void setManzil(int manzil) {
            this.manzil = manzil;
        }

        public int getSabaq() {
            return sabaq;
        }

        public void setSabaq(int sabaq) {
            this.sabaq = sabaq;
        }

        public int getSabqi() {
            return sabqi;
        }

        public void setSabqi(int sabqi) {
            this.sabqi = sabqi;
        }
    }

    String name;
    int image;
    ArrayList<Data> studentData;

    public Student(String name, int image) {
        this.name = name;
        this.image = image;
        this.studentData = new ArrayList<Data>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Data> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Data> studentData) {
        this.studentData = studentData;
    }
}
