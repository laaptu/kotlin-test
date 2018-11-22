package com.laaptu.kotlintest

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec

class BehaviorSpecTest : BehaviorSpec() {
    init {
        additionMultiplicationTest()
    }


    fun additionMultiplicationTest() {
        val x = 10
        val y = 2
        Given("Two Integers $x and $y") {
            When("they are added") {
                then("result should be 12") {
                    addNumbers(x, y) shouldBe 12
                }
            }

            When("they are multiplied") {
                then(" result should be 20") {
                    multiplyNumbers(x, y) shouldBe 20
                }
            }
        }
    }
}
