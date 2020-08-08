package com.cjc.componentdatadeliver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CC
 **/

public class User implements Parcelable {
    private String name;
    private int age;
    private float tall;

    public User() {
    }

    public User(String name, int age, float tall) {
        this.name = name;
        this.age = age;
        this.tall = tall;
    }

    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        tall = in.readFloat();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getTall() {
        return tall;
    }

    public void setTall(float tall) {
        this.tall = tall;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeFloat(tall);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tall=" + tall +
                '}';
    }
}
