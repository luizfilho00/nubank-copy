package br.com.nubankcopy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.nubankcopy.databinding.FragmentProfileInfoBinding

class ProfileInfoFragment : Fragment() {

    private var binding: FragmentProfileInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileInfoBinding.inflate(inflater, container, false)
        setupUi()
        return binding?.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    fun toggleButton() {
        binding?.button?.isEnabled?.let { isEnable ->
            binding?.button?.isEnabled = !isEnable
        }
    }

    private fun setupUi() {
        binding?.button?.setOnClickListener {
            DialogFragment().show(childFragmentManager, null)
        }
    }
}