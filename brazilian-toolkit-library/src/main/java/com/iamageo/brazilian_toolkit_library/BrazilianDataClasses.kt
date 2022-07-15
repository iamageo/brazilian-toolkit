package com.iamageo.brazilian_toolkit_library

data class BrazilianAllCities(
    val listAllStatesAndCities: List<BrazilianStates>
)

data class BrazilianStates(
    val code: String,
    val listCities: List<BrazilianCity>
)

data class BrazilianCity(
    val name: String
)

data class BrazilianAllStates(
    val list: List<BrazilianState>
)

data class BrazilianState(
    val code: String,
    val name: String
)
