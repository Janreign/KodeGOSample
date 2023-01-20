package ph.kodego.aragon.janreign.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import ph.kodego.aragon.janreign.fragments.databinding.FragmentFirstBinding
import ph.kodego.aragon.janreign.fragments.databinding.FragmentSecondBinding

class FirstFragment : Fragment (){

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.btnToSecond.setOnClickListener {

                val bundle = bundleOf("data" to "SAMPLE DATA", "info" to "INFORMATION")
                findNavController().navigate(R.id.action_firstfragment_to_secondfragment, bundle)
            }
        }


//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//    }


        override fun onDestroyView() {
            super.onDestroyView()

        }
}

