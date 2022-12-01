package com.example.recyclerviewtest



enum class NutriScore(val label: String) {
    A("A"), B("B"), C("C"), D("D"), E("E"), Unknown("")
}

data class Product(
    val nom: String,
    val marque:  String,
    val code_barres: String,
    val nutriscore: NutriScore,
    val calories: String,
    val url: String,
    val quantité: String,
    val liste_pays: List<String>,
    val liste_ingredients:List<String>,
    val liste_substances: List<String>,
    val liste_aditifs: List<String>
)

fun generateFakeProduct() = Product(
    "Petits pois et carottes",
    "Cassegrain",
    "3083680085304",
    NutriScore.A,
    "280 ",
    "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
    "400 g",
    listOf("France", "Japon", "Suisse"),
    listOf(
        "Petits pois 66%",
        "Eau",
        "Garniture 2,8% (salade, oignon grelot)",
        "Sucre",
        "Sel",
        "Arôme naturel"
    ),
    listOf<String>(),
    listOf<String>()
)

