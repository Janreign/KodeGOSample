package ph.kodego.aragon.janreign.kodegosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.kodegosample.databinding.ActivityLoginBinding
import ph.kodego.aragon.janreign.kodegosample.databinding.ActivityRegisterBinding
import java.text.FieldPosition
import java.util.Objects

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profilepicture.setBackgroundResource(R.drawable.sample)

        var value = binding.fulllnametext.text

//        binding.fulllnametext.setText("FUll Name")
        binding.fulllnametext.setText("Full Name")
//        binding.fulllnametext.setHint("FUll Name")

//binding.fulllnametext.hint = "Full Name"
//binding.fulllnametext.doOnTextChanged { text, start, before, count ->  }


         var spinnerValue =binding.usertype.selectedItem.toString()

        binding.usertype.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                var data = binding.usertype.selectedItem.toString()
                Snackbar.make(binding.root, "$data", Snackbar.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Snackbar.make(binding.root, "No Change in the choice", Snackbar.LENGTH_SHORT).show()
            }
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.usertype2,
        android.R.layout.simple_spinner_item
        ).also {
          adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
          binding.usersubtype.adapter = adapter
        }

        var locations = arrayOf("Marikina", "Makati", "Mandaluyong", "Taguig", "Rizal")
       ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            locations
        ).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.location.adapter = adapter

        }

        binding.seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    if (seekBar !=null){
                    if(progress > 50 && progress < seekBar.max){
                        Snackbar.make(binding.root, "Seek : ${progress}", Snackbar.LENGTH_SHORT).show()
                }
              }
            }
          }

            override fun onStartTrackingTouch(p0: SeekBar?) {
//                Snackbar.make(binding.root, "Seek : Start", Snackbar.LENGTH_SHORT).show()


            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

//                Snackbar.make(binding.root, "Seek : Stop", Snackbar.LENGTH_SHORT).show()
            }

        })

        binding.btnRegister.setOnClickListener {
            var ratingValue = binding.rating.rating
            Snackbar.make(binding.root, "Rating : ${ratingValue}", Snackbar.LENGTH_SHORT).show()
        }

    }
}