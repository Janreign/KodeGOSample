package ph.kodego.aragon.janreign.code_apis_retrofi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ph.kodego.aragon.janreign.code_apis_retrofi.api.PokemonAPIClient
import ph.kodego.aragon.janreign.code_apis_retrofi.databinding.FragmentPokemonInfoBinding
import ph.kodego.aragon.janreign.code_apis_retrofi.models.PokemonInfoResponse
import ph.kodego.aragon.janreign.code_apis_retrofi.models.getPokemonID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonInfoFragment : Fragment() {

    private val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent){

            var message: String? = intent!!.getStringExtra("data")

            Log.i("Pokemon Info", message!!.toString())

            message?.let {
                getData(message.getPokemonID())

            }
        }
    }

    var binding: FragmentPokemonInfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupReceiver()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonInfoBinding.inflate(inflater, container, false)
        var view = binding!!.root
        return view
    }

    override fun onDestroyView() {
        requireActivity().unregisterReceiver(receiver)
        super.onDestroyView()
    }

    private fun setupReceiver(){
        val intentFilter = IntentFilter()
        intentFilter.addAction ("ph.kodego.md2p.GETDATA")
        requireActivity().registerReceiver (receiver, intentFilter)
    }

    private fun getData(id: Int) {
        val call: Call<PokemonInfoResponse> =
            PokemonAPIClient.getPokemonData.getPokemonInfo(id)

        call.enqueue(object : Callback<PokemonInfoResponse> {
            override fun onFailure(call: Call<PokemonInfoResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<PokemonInfoResponse>,
                response: Response<PokemonInfoResponse>
            ) {

                var response: PokemonInfoResponse = response!!.body()!!


                Intent().also {
                    Log.d("Pokemon", "${response.sprites.front_default}")
                    it.setAction("ph.kodego.md2p.LOADIMAGEACTION")
                    it.putExtra("data", response.sprites.front_default)
                    context!!.sendBroadcast(it)
                }

                Log.d("API INFO CALL", response.name)
            }
        })
    }
}