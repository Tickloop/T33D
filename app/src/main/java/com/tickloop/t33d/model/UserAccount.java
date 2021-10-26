package com.tickloop.t33d.model;

import androidx.annotation.NonNull;

import java.util.Objects;


public class UserAccount {
    /*@PrimaryKey(autoGenerate = true)
    @Col(name = "rowid")
    public int mUid;

    @NonNull
    @ColumnInfo(name = "name")
    public String mName;

    @NonNull
    @ColumnInfo(name = "password")
    public String mPassword;*/
    public int mUid;
    public String mName;
    public String mPassword;

    public UserAccount(@NonNull String name, @NonNull String password) {
        mName = name;
        mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public String getPassword() {
        return mPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return mName.equals(that.mName) && mPassword.equals(that.mPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mUid, mName, mPassword);
    }

    @NonNull
    @Override
    public String toString() {
        return "UserAccount{" +
                "uid=" + mUid +
                "; name='" + mName + '\'' +
                "; password='" + mPassword + '\'' +
                '}';
    }
}