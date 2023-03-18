package ph.kodego.aragon.janreign.code_apis_retrofi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import ph.kodego.aragon.janreign.code_apis_retrofi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val pokemonListFragment = PokemonListFragment()
    private val pokemonInfoFragment = PokemonInfoFragment()
    private val pokemonImageFragment = PokemonImageFragment()
//    private val pokemonMovesFragment = PokemonMovesFragment()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonInfoAdapter : PokemonInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_holder, pokemonListFragment)
            .commit()

        pokemonInfoAdapter = PokemonInfoAdapter(supportFragmentManager)
        pokemonInfoAdapter.add(pokemonInfoFragment, "Pokemon Information")
        pokemonInfoAdapter.add(pokemonImageFragment, "Pokemon Image")
//        pokemonInfoAdapter.add(pokemonMovesFragment, "Pokemon Moves")
        binding.pokemonInfoViewpager.adapter = pokemonInfoAdapter
    }

}