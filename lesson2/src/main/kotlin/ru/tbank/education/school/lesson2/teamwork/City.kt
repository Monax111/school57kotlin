package ru.tbank.education.school.lesson2.teamwork

// Данные по номерам домов : Город -> Округ -> Район -> Улица -> Номера домов
val data: Map<String, Map<String, Map<String, Map<String, Set<Int>>>>> = mapOf(
    "Москва" to mapOf(
        "CAO" to mapOf(
            "Войковский" to mapOf(
                "Зои и Александра" to setOf(1, 2, 3, 4, 6, 8),
            ),
            "Красноармейский" to mapOf(
                "Космонавт Волков" to setOf(1, 3, 5, 6, 7),
                "Ракета" to setOf(2, 4, 8),
                "Тупик" to setOf(4)
            ),
        ),
        "ЗAO" to mapOf(
            "Звенигородскй" to mapOf(
                "Шоссе" to setOf(3, 4, 5, 6, 7),
                "Славянский бульвар" to setOf(1),
            ),
            "Минский" to mapOf(
                "Шоссе" to setOf(4, 1, 3, 6),
                "Генерала дорохова" to setOf(1, 2, 3, 4, 6, 8),
            )
        ),
        "ЦАО" to mapOf(
            "Тверской" to mapOf(
                "Тверская" to setOf(2, 4, 5, 6, 7),
                "Лубянка" to setOf(3, 2, 1, 4, 5, 6),
                "Красная площадь" to setOf(1, 2, 3, 4, 6, 8),
                "Пушкинская" to setOf(1, 2, 3, 4, 6, 8),
                "Красная площадь" to setOf(1, 2, 3, 4, 6, 8),
            ),
        ),
        "ВАО" to mapOf(
            "Митино" to mapOf(
                "Шоссе" to setOf(3, 4, 5, 6, 7),
                "Ворота" to setOf(2),
            )
        )
    )
)

fun main() {

    // все пропущенные дома, с указанием 'город, округ, район, улица, номера дома'
    data.forEach { (city, cityData) ->
        cityData.forEach { (district, districtData) ->
            districtData.forEach { (area, areaData) ->
                areaData.forEach { (street, houseData) ->
                    (1..houseData.max()).forEach {
                        if (it !in houseData) {

                            //println("$city, $district,$area , $street, $it")

                        }
                    }
                }
            }
        }
    }

    // все пропущенные дома, с указанием 'город, округ, район, улица, номера дома'
    // только в районах, где улиц больше, чем районов в округе
    // и количество пропущенных домов больше чем существующих

    data.forEach { (city, cityData) ->
        cityData.forEach { (district, districtData) ->
            districtData.forEach { (area, areaData) ->
                if (areaData.size > districtData.size) {
                    areaData.forEach { (street, houseData) ->
                        (1..houseData.max()).filter { it !in houseData }.forEach {
                            println("$city, $district, $area , $street, $it")
                        }
                    }
                }
            }
        }
    }
}