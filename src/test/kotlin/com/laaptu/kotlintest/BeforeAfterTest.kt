package com.laaptu.kotlintest

import com.laaptu.kotlintest.models.User
import io.kotlintest.Description
import io.kotlintest.Spec
import io.kotlintest.TestResult
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 *  Each spec has two methods to override
 *  beforeTest(), afterTest() similar
 *  @Before and @After
 *  beforeSpec(), afterSpec() similar
 *  so we can write @BeforeClass and @AfterClass kind of thing out here
 */
class BeforeAfterTest : StringSpec() {

    lateinit var user: User

    init {
        "Validate User full name"{
            user.getFullName() shouldBe "Tom Cruise"
        }
    }

    override fun beforeTest(description: Description) {
        super.beforeTest(description)
        println("Before Any Test() ##########>>")
        user = User("Tom", "Cruise", 55)
    }

    override fun afterTest(description: Description, result: TestResult) {
        super.afterTest(description, result)
        println("#######>> After Any Test()")
    }

    override fun beforeSpec(description: Description, spec: Spec) {
        super.beforeSpec(description, spec)
        println("Before Spec --->")
    }

    override fun afterSpec(description: Description, spec: Spec) {
        super.afterSpec(description, spec)
        println("---> After Spec")
    }
}
