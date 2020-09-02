package com.javiersc.dynamicFeatures.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.javiersc.dynamicFeatures.users.databinding.UsersFragmentBinding

class UsersFragment : Fragment(R.layout.users_fragment) {

    private var _binding: UsersFragmentBinding? = null
    private val binding: UsersFragmentBinding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = UsersFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textViewUser1.setOnClickListener { navigateToUserDetail(textViewUser1.text.toString()) }
            textViewUser2.setOnClickListener { navigateToUserDetail(textViewUser2.text.toString()) }
        }
    }

    private fun navigateToUserDetail(user: String) {
        findNavController().navigate(UsersFragmentDirections.toUserDetail(user))
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
