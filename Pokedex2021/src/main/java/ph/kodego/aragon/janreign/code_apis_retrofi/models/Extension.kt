package ph.kodego.aragon.janreign.code_apis_retrofi.models

fun String.getPokemonID() : Int{
    var value = this.toString()
    val id = value.substring(34, value.length-1)
    return id.toInt()

}