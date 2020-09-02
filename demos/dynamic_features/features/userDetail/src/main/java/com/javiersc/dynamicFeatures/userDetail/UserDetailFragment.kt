package com.javiersc.dynamicFeatures.userDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.javiersc.dynamicFeatures.userDetail.databinding.UserDetailFragmentBinding

class UserDetailFragment : Fragment(R.layout.user_detail_fragment) {

    private var _binding: UserDetailFragmentBinding? = null
    private val binding: UserDetailFragmentBinding get() = _binding!!

    private val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = UserDetailFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewUser.text = args.userName
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}