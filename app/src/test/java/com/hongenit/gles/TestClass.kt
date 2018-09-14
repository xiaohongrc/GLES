package com.hongenit.gles

/**
 * Created by hongenit on 2018/3/5.
 */
class TestClass {

    fun main(args: String) {

        testNull(null)

    }

    private fun testNull(str: String?) {
        val indexOf = str?.indexOf("p")
        println(indexOf)

    }


}