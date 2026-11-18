package com.leobg.exercice02_leobg.models

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val capacity: Int = 0,
    val location: String? = null,
    val description: String = "",
)