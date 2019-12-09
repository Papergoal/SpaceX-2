package com.example.spacex.infosTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

import com.example.spacex.R
import kotlinx.android.synthetic.main.infofragment.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InfoFragment : Fragment() {
    companion object {
        fun newInstance() = InfoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.infofragment, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://www.thecocktaildb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(CocktailWebservice::class.java)
        val cocktailService = InfoService(retrofitService)

        cocktailService.getRandomInfo(
            { info ->
                
            }, { error -> TODO() }
        )
    }

}