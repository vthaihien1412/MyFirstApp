package com.vincentvu.a312geek.myfirstapp

import android.content.Context
import android.preference.PreferenceManager

class userDataManager(val context: Context) {

   fun saveUser(user: UserList) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putStringSet(user.username.toHashSet(), user.password.toHashSet())
        sharedPreferences.apply()
    }

    fun readUser(): ArrayList<UserList> {

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPreferenceContents = sharedPreferences.all

        val userLists = ArrayList<UserList>()

        for (userList in sharedPreferenceContents) {

            val itemsHashSet = userList.value as HashSet<String>
            val list = UserList(userList.key, ArrayList(itemsHashSet))
            userLists.add(list)
        }

        return userLists
    }
}
}