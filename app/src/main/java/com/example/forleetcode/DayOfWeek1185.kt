package com.example.forleetcode

import java.util.Calendar
import kotlin.collections.HashMap

/* 1185. Day of the Week
Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.



Example 1:

Input: day = 31, month = 8, year = 2019
Output: "Saturday"

Example 2:

Input: day = 18, month = 7, year = 1999
Output: "Sunday"

Example 3:

Input: day = 15, month = 8, year = 1993
Output: "Sunday"



Constraints:

    The given dates are valid dates between the years 1971 and 2100.


 */
sealed class DayOfWeek1185 {
    abstract fun dayOfTheWeek(day: Int, month: Int, year: Int): String

    protected val mmap: MutableMap<Int, Int> = HashMap<Int, Int>().also { mmap ->
        mmap[1] = 31
        mmap[2] = 28
        mmap[3] = 31
        mmap[4] = 30
        mmap[5] = 31
        mmap[6] = 30
        mmap[7] = 31
        mmap[8] = 31
        mmap[9] = 30
        mmap[10] = 31
        mmap[11] = 30
        mmap[12] = 31
    }


    object MathImpl: DayOfWeek1185() {
        override fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
            val weekList: Array<String> = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
            var sum = 0
            val calendar = Calendar.getInstance()

            val curY = calendar.get(Calendar.YEAR)
            val curM = calendar.get(Calendar.MONTH) + 1
            val curD = calendar.get(Calendar.DAY_OF_MONTH)
//            reset to 1/1
            sum -= curD
            for (m in 2..curM) {
                sum -= mmap[m]!!
            }

            if (curY != year) {
                val rangeY = if (year > curY) curY until year else year until curY
                val signY = if (year > curY) 1 else -1
                for(y in rangeY) {
                    sum += (365 + if (isLeap(y)) { 1 } else { 0 }) * signY
                }
            }


            if (1 != month) {
                val rangeM = 1 until month
                for (m in rangeM) {
                    sum += (mmap[m]!! + (if (m == 2 && isLeap(year)) 1 else 0))
                }
            }


            val diff = day - 1
            sum += diff

            val curW = calendar.get(Calendar.DAY_OF_WEEK) - 1
            return weekList.getOrElse((curW + sum) % 7) { weekList[(it + 7)] }
        }
    }

    protected fun isLeap(year: Int): Boolean {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)
    }

    object CalendarImpl: DayOfWeek1185() {
        override fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
            val weekList: Array<String> = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
            val i = Calendar.getInstance().let {
                it.set(year, month - 1, day)
                it.get(Calendar.DAY_OF_WEEK) - 1
            }
            return weekList[i]
        }

    }
}