package com.leobg.exercice02_leobg.models

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String? = null,
    val capacity: Int
)