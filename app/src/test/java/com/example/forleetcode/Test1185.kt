package com.example.forleetcode

import org.junit.Test

class Test1185 {
    @Test
    fun testImpl() {
        with(DayOfWeek1185.MathImpl) {
            cases.forEach { data ->
                println("===case: (${data.year}/${data.month}/${data.day})===")
                dayOfTheWeek(data.day, data.month,data.year).also {
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    @Test
    fun testCalendar() {
        with(DayOfWeek1185.CalendarImpl) {
            cases.forEach { data ->
                println("===case: (${data.year}/${data.month}/${data.day})===")
                dayOfTheWeek(data.day, data.month, data.year).also {
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    private val cases = listOf(
        InOut(21, 6,2022, "Tuesday"),
        InOut(21, 6,2020, "Sunday"),
        InOut(21, 6,1995, "Wednesday"),
        InOut(21, 3,1995, "Tuesday"),
        InOut(21, 6,2019, "Friday"),
        InOut(31, 8,2019, "Saturday"),
        InOut(day = 18, month = 7, year = 1999, ans = "Sunday"),
        InOut(6, 3, 1995, "Monday"),
        InOut(day = 15, month = 8, year = 1993, ans = "Sunday")
    )

    private data class InOut(val day: Int, val month: Int, val year: Int, val ans: String)
}