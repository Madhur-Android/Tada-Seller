package com.example.tadaseller.SharedPreferences

import android.content.Context
import android.content.SharedPreferences
import android.icu.lang.UProperty.AGE

class SharedPreferences(activity: Context) {
    private val Image = "image"

    private var editor: SharedPreferences.Editor? = null

    var pref: SharedPreferences? = null

    fun setImage(state: String) { editor?.putString(Image, state)?.apply() }
    fun getImage(): String? { return pref?.getString(Image, Image)}
}