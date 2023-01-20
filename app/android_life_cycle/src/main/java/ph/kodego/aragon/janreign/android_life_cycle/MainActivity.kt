package ph.kodego.aragon.janreign.android_life_cycle

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.android_life_cycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "ANDROID LIFE CYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"onCreate Called")

    }
    override fun onStart(){
        super.onStart()
    }
    override fun onDestroy(){
        super.onDestroy()
    }
    override fun onStop(){
        super.onStop()
    }
    override fun onResume(){
        super.onResume()
    }
    override fun onPause(){
        super.onPause()
    }
}