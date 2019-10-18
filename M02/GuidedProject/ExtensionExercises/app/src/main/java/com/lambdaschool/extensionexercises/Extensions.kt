package com.lambdaschool.extensionexercises

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.pow

// Int
fun Int.isOdd(): Boolean {
    return this % 2 == 1
}

fun Int.isEven() = !isOdd()

// String
fun String.isPalindrome(): Boolean {
    return this.reversed() == this
}

// List<Person>
fun List<Person>.isAliceThere(): Boolean {
    return this.any {
        it.name == "Alice"
    }
}

fun List<Person>.findAlice(): Person? {
    return this.find {
        it.name == "Alice"
    }
}

fun List<Person>.doesPersonExist(name: String): Boolean {
    return this.any {
        it.name == name
    }
}

fun List<Named>.doesNameExist(name: String): Boolean {
    return this.any {
        it.name == name
    }
}

operator fun List<Named>.contains(name: String): Boolean {
    return this.any {
        it.name == name
    }
}

// infix
infix fun Number.toPowerOf(exponent: Double): Double {
    return this.toDouble().pow(exponent)
}

// View
fun View.visible() {
    this.visibility = View.VISIBLE
}

infix fun View.disappears(now: String) {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

// Toast
fun Context.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

// Alert
fun Context.showAlert(title: String = "", message: String = "") {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .create()
        .show()
}