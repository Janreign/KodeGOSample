package ph.kodego.aragon.janreign.kodegosample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.kodegosample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var username: String
    private lateinit var password: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmit.setOnClickListener{

            username = binding.usernametext.text.toString()
            password = binding.passwordtext.text.toString()

            Snackbar.make(binding.root, "$username - $password", Snackbar.LENGTH_SHORT).show()

            var goToHome = Intent(this,HomeActivity::class.java)


            var bundle = Bundle()
            bundle.putString("username", username)
            bundle.putString("password", username)
            goToHome.putExtras(bundle)

            goToHome.putExtra("something", "extra")

            startActivity(goToHome)
            finish()
        }

    }

    override fun onBackPressed() {
    }
}