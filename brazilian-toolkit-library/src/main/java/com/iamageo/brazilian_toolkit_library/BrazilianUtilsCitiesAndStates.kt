package com.iamageo.brazilian_toolkit_library

class BrazilianUtilsCitiesAndStates {

    fun getAllStates(): AllStates {
        return AllStates(
            listOf(
                States(code = "AC", name = "Acre"),
                States(code = "AL", name = "Alagoas"),
                States(code = "AP", name = "Amapá"),
                States(code = "AM", name = "Amazonas"),
                States(code = "BA", name = "Bahia"),
                States(code = "CE", name = "Ceará"),
                States(code = "DF", name = "Distrito Federal"),
                States(code = "ES", name = "Espírito Santo"),
                States(code = "GO", name = "Goiás"),
                States(code = "MA", name = "Maranhão"),
                States(code = "MT", name = "Mato Grosso"),
                States(code = "MS", name = "Mato Grosso do Sul"),
                States(code = "MG", name = "Minas Gerais"),
                States(code = "PA", name = "Pará"),
                States(code = "PB", name = "Paraíba"),
                States(code = "PR", name = "Paraná"),
                States(code = "PE", name = "Pernambuco"),
                States(code = "PI", name = "Piauí"),
                States(code = "RJ", name = "Rio de Janeiro"),
                States(code = "RN", name = "Rio Grande do Norte"),
                States(code = "RS", name = "Rio Grande do Sul"),
                States(code = "RO", name = "Rondônia"),
                States(code = "RR", name = "Roraima"),
                States(code = "SC", name = "Santa Catarina"),
                States(code = "SP", name = "São Paulo"),
                States(code = "SE", name = "Sergipe"),
                States(code = "TO", name = "Tocantins")
            ),
        )
    }

    fun getCitiesByState(state: String): AllCities {
        return AllCities(
            listOf(
                OneState(code = "GO", listOf(
                    City(name = "")
                ))
            )
        )
    }

    data class AllCities(
        val states: List<OneState>
    )

    data class OneState(
        val code: String,
        val listCities: List<City>
    )

    data class City(
        val name: String
    )

    data class AllStates(
        val list: List<States>
    )

    data class States(
        val code: String,
        val name: String
    )


}