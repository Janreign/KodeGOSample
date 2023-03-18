package ph.kodego.aragon.janreign.code_apis_retrofi.api

import ph.kodego.aragon.janreign.code_apis_retrofi.models.PokemonInfoResponse
import ph.kodego.aragon.janreign.code_apis_retrofi.models.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("pokemon/") //@GET is called annotation
    fun getList(
        @Query("offset") startIndex:Int,
        @Query("limit") limit:Int)
            : Call<PokemonListResponse>

    @GET("pokemon/{pokemonId}/")
    fun getPokemonInfo(
        @Path("pokemonId") pokemonID:Int)
            : Call<PokemonInfoResponse>

}