package com.example.forleetcode

import com.example.forleetcode.util.parse2DList_List
import com.example.forleetcode.util.parse2DList_ListString
import org.junit.Test

class Test1418 {
    @Test
    fun testSimple() {
        with(TableFoodOrders1418.SimpleImpl) {
            getData().forEach { data ->
                displayTable(data.orders).also {
                    println("ans: [${it.joinToString()}]")
                    it.zip(data.ans).forEach { pair ->
                        for (i in pair.first.indices) {
                            assert(pair.first[i] == pair.second[i])
                        }
                    }
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut(
                "[[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]".parse2DList_ListString(),
                "[[\"Table\",\"Beef Burrito\",\"Ceviche\",\"Fried Chicken\",\"Water\"],[\"3\",\"0\",\"2\",\"1\",\"0\"],[\"5\",\"0\",\"1\",\"0\",\"1\"],[\"10\",\"1\",\"0\",\"0\",\"0\"]]".parse2DList_ListString()
            ),
            InOut(
                "[[\"James\",\"12\",\"Fried Chicken\"],[\"Ratesh\",\"12\",\"Fried Chicken\"],[\"Amadeus\",\"12\",\"Fried Chicken\"],[\"Adam\",\"1\",\"Canadian Waffles\"],[\"Brianna\",\"1\",\"Canadian Waffles\"]]".parse2DList_ListString(),
                "[[\"Table\",\"Canadian Waffles\",\"Fried Chicken\"],[\"1\",\"2\",\"0\"],[\"12\",\"0\",\"3\"]]".parse2DList_ListString()
            )

        )
    }

    private data class InOut(val orders: List<List<String>>, val ans: List<List<String>>)
}