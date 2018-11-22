package com.laaptu.kotlintest.table

import com.laaptu.kotlintest.addNumbers
import com.laaptu.kotlintest.multiplyNumbers
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class AddMultiplierTest : StringSpec() {
    init {
        "should add correctly"{
            val additionTable = table(
                headers("a", "b", "result"),
                row(2, 3, 5),
                row(
                    10, -10, 0
                ),
                row(100, 100, 200)
            )

            forAll(additionTable) { a, b, result ->
                addNumbers(a, b) shouldBe result
            }
        }

        "should multiply correctly"{
            val multiplicationTable = table(
                headers("a", "b", "result"),
                row(2, 3, 6),
                row(5, 5, 25),
                row(20, 10, 200)
            )
            forAll(multiplicationTable) { a, b, result ->
                multiplyNumbers(a, b) shouldBe result
            }
        }
    }
}
