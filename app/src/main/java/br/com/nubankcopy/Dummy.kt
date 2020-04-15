package br.com.nubankcopy

import java.util.*

data class Dummy(
    val id: Int,
    val name: String,
    val date: String
) {

    companion object {
        fun listOfDummy(): List<Dummy> {
            val dummies = mutableListOf<Dummy>()
            for (i in 0..30) {
                dummies.add(Dummy(i, "Dummy $i", Date().toString()))
            }
            return dummies.toList()
        }
    }
}