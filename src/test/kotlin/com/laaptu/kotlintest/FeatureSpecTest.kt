package com.laaptu.kotlintest

import com.laaptu.kotlintest.models.User
import io.kotlintest.shouldBe
import io.kotlintest.specs.FeatureSpec
import io.kotlintest.specs.Test


class FeatureSpecTest : FeatureSpec() {
    init {
        featureSpecTest()
        secondFeatureSpecTest()
    }

    @Test
    fun featureSpecTest() {
        feature("User fullname feature") {
            scenario("Print user firstName only when lastName is empty") {
                val user = User("Tom", "", 20)
                user.getFullName() shouldBe "Tom "
            }

            scenario("Print user's firstName and lastName if they are present") {
                val user = User("Tom", "Cruise", 20)
                user.getFullName() shouldBe "Tom Cruise"
            }
        }
    }

    @Test
    fun secondFeatureSpecTest() {
        feature("User age feature") {
            scenario("If user age is negative , it should return 0") {
                User("Tom", "Cruise", -1).age shouldBe 0
            }

            scenario("If user age is positive, it should return the same value") {
                User("Tom", "Cruise", 10).age shouldBe 10
            }
        }
    }
}
