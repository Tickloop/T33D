package com.tickloop.t33d.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;


/**
 * Single point of accessing UserAccount data in the app.
 *
 * Source: https://developer.android.com/codelabs/android-room-with-a-view
 *
 * Created by acc on 2021/08/04.
 */
public class UserAccountRepository {

    /*private UserAccountDao mUserAccountDao;
    private LiveData<List<UserAccount>> mAllUserAccounts;

    private final String TAG = getClass().getSimpleName();

    /*UserAccountRepository(Application application) {
        UserAccountDatabase db = UserAccountDatabase.getDatabase(application);
        mUserAccountDao = db.getUserAccountDao();
        mAllUserAccounts = mUserAccountDao.getAllUserAccounts();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData notify the observer upon data change.
    LiveData<List<UserAccount>> getAllUserAccounts() {
        return mAllUserAccounts;
    }

    LiveData<UserAccount> findUserAccountByName(UserAccount userAccount) {
        LiveData<UserAccount> theUserAccount = mUserAccountDao.findByName(userAccount.getName(), userAccount.getPassword());

        return theUserAccount;
    }

    // You MUST call this on a non-UI thread or the app will throw an exception.
    // I'm passing a Runnable object to the database.
    void insert(UserAccount userAccount) {
        UserAccountDatabase.databaseWriteExecutor.execute(() ->
                mUserAccountDao.insert(userAccount));
    }*/
}
