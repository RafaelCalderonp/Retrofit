package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.FragmentFirstBinding
import com.example.retrofit.databinding.LandListBinding
import com.example.retrofit.model.viewModel.MarsViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mBinding : FragmentFirstBinding
    private  val viewModel : MarsViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MarsAdapter()

        mBinding.rvLand.adapter = adapter

        mBinding.rvLand.layoutManager = GridLayoutManager(context,2)
        viewModel.allLand.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })



    }

}