package de.htw_berlin.nguembawrterbuch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.htw_berlin.nguembawrterbuch.databinding.FragmentCopyrightBinding
import de.htw_berlin.nguembawrterbuch.databinding.FragmentKommentareBinding
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KommentareFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KommentareFragment : Fragment() {

    internal lateinit var kommentar: EditText
    internal lateinit var binding : FragmentKommentareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity?)?.setActionBarTitle("Kommentare")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kommentare,container,false)
        binding.sendKommentarButton.setOnClickListener {
            //kommentar.text
        }
        return binding.root
    }
}