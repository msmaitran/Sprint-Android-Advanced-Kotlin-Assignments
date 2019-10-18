package com.lambdaschool.extensionexercises

class Person(name: String, val age: Int): Named(name), Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return if(name == other.name) {
            age - other.age
        } else {
            name.compareTo(other.name)
        }
    }

    fun compareTo(other: Car): Int {
        return -1
    }

}

class Car(name: String, val brand: String): Named(name) {
    operator fun plus(car: Car): String {
        return "$name/${car.name}"
    }
    operator fun minus(car: Car): String {
        return "minus"
    }
}

open class Named(val name: String)