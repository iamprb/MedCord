package com.thoughtbeats.pranay.medcords.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.thoughtbeats.pranay.medcords.R
import com.thoughtbeats.pranay.medcords.adapter.CustomLinearLayoutManager
import com.thoughtbeats.pranay.medcords.adapter.HorizontalAdapter
import com.thoughtbeats.pranay.medcords.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment(){

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private val horizontalViewAdapter : HorizontalAdapter by lazy{
        HorizontalAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hsv_container.apply{
            layoutManager = CustomLinearLayoutManager(
                this.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = this@HomeFragment.horizontalViewAdapter
        }

        btn_b1.setOnClickListener {
            loader.show()
            handleUiWhileLoading(false)
            sendClickedButtonInfoToViewModel(btn_b1.text.toString())
        }
        btn_b2.setOnClickListener {
            loader.show()
            handleUiWhileLoading(false)
            sendClickedButtonInfoToViewModel(btn_b2.text.toString())
        }
        btn_b3.setOnClickListener {
            loader.show()
            handleUiWhileLoading(false)
            sendClickedButtonInfoToViewModel(btn_b3.text.toString())
        }
        btn_b4.setOnClickListener {
            loader.show()
            handleUiWhileLoading(false)
            sendClickedButtonInfoToViewModel(btn_b4.text.toString())
        }
    }

    private fun sendClickedButtonInfoToViewModel(buttonText:String){
        homeViewModel.sendClickedButtonInfo(buttonText)
    }

    private fun observeViewModel(){
        homeViewModel.responseString.observe(this, Observer {
            loader.hide()
            handleUiWhileLoading(true)
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })
        homeViewModel.errorResponseString.observe(this, Observer {
            loader.hide()
            handleUiWhileLoading(true)
            Toast.makeText(context, it?.let { it1 -> getString(it1) },Toast.LENGTH_SHORT).show()
        })
    }
    private fun handleUiWhileLoading(isEnabled: Boolean){
        btn_b1.isEnabled= isEnabled
        btn_b2.isEnabled= isEnabled
        btn_b3.isEnabled= isEnabled
        btn_b4.isEnabled= isEnabled
    }
}