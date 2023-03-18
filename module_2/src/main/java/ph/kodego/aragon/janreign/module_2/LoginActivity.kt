package ph.kodego.aragon.janreign.module_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.module_2.databinding.ActivityLoginBinding
import ph.kodego.aragon.janreign.module_2.utility.PreferenceUtility

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var username: String
    private lateinit var password: String
    private lateinit var preferenceUtility: PreferenceUtility // added Jan 26, 2023



    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
      val data = result.data

        Snackbar.make(binding.root,
    "Registered ${data!!.getStringExtra("username")}",
    Snackbar.LENGTH_LONG).show()

}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceUtility = PreferenceUtility(applicationContext) // added Jan 26, 2023

        binding.usernametext.setText(preferenceUtility.getStringPreferences("username")) // added Jan 26, 2023
        binding.passwordtext.setText(preferenceUtility.getStringPreferences("password")) // added Jan 26, 2023

        binding.btnSubmit.setOnClickListener{

            username = binding.usernametext.text.toString()
            password = binding.passwordtext.text.toString()

            preferenceUtility.saveStringPreferences("username", binding.usernametext.text.toString())
            preferenceUtility.saveStringPreferences("passowrd", binding.usernametext.text.toString())

            var goToHome = Intent(this, MainActivity::class.java)

            var bundle = Bundle()
            bundle.putString("username", username)
            bundle.putString("password", username)
            goToHome.putExtras(bundle)

            goToHome.putExtra("something", "extra")

            startActivity(goToHome)
            finish()
        }

        binding.btnRegister.setOnClickListener {

            var goToRegister = Intent(this, RegisterActivity::class.java)
            launchRegister.launch(goToRegister)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}