package ph.kodego.aragon.janreign.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ph.kodego.aragon.janreign.fragments.databinding.ActivityHomeBinding
import ph.kodego.aragon.janreign.fragments.databinding.ActivityViewPageBinding

class ViewPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragmentAdapter = FragmentAdapater(supportFragmentManager, lifecycle)
        fragmentAdapter.addFragement(AFragment())
        fragmentAdapter.addFragement(BFragment())
        fragmentAdapter.addFragement(CFragment())

        with(binding.viewPager2) {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
//            setPageTransformer(ZoomOutPageTransformer())
            adapter = fragmentAdapter
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager2){
            tab, position ->
            tab.text = "Chapter ${(position + 1)}"
        }.attach()
    }
        override fun onBackPressed(){
            if(binding.viewPager2.currentItem == 0){
                super.onBackPressed()
            }else{
                binding.viewPager2.currentItem = binding.viewPager2.currentItem - 1
            }
        }
    }
