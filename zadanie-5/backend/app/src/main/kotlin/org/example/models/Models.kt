package org.example.models

data class Produkt(
    val id: Int,
    val nazwa: String,
    val cena: Double
)

data class Platnosc(
    val kwota: Double,
    val produktId: Int
)
