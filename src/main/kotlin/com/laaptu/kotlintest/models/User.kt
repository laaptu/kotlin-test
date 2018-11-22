package com.laaptu.kotlintest.models

class User(val firstName: String, val lastName: String, age_: Int) {

    val age: Int = age_
        get() = if (field < 0) 0 else field

    operator fun invoke(userExtension: User.() -> String) {
        userExtension()
    }

    fun getFullName(): String = firstName.plus(" ").plus(lastName)

}

fun User.printFirstName(fn: () -> String) {
    fn()
}

fun User.invoke(userExtension: User.() -> String) {
    userExtension()
}

fun main(args: Array<String>) {
    val user = User("Jackie", "Chan", 90)
    user.printFirstName {
        user.firstName
    }
    user {
        firstName
    }
}
