package me.hafizdwp.kade_submission_2.util.ext

import android.view.View
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/**
 * @author hafizdwp
 * 29/10/2019
 **/

/**
 * View visibility utility
 * */
fun View.visible() {
        visibility = View.VISIBLE
}

fun View.invisible() {
        visibility = View.INVISIBLE
}

fun View.gone() {
        visibility = View.GONE
}

fun View.isVisible(): Boolean {
        return visibility == View.VISIBLE
}

fun View.isInvisible(): Boolean {
        return visibility == View.INVISIBLE
}

fun View.isGone(): Boolean {
        return visibility == View.GONE
}

/**
 * Gson ez toJson / fromJson
 * ---------------------------------------------------------------------------------------------
 * */
val gson by lazy { GsonBuilder().setPrettyPrinting().create() }

fun <T> T.toJson(): String = gson.toJson(this)
inline fun <reified T> makeType() = object : TypeToken<T>() {}.type
inline fun <reified T> String.fromJson(): T = gson.fromJson(this,
        makeType<T>()
)