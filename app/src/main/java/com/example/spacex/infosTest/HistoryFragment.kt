package com.example.spacex.infosTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import com.example.spacex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.history_fragment.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HistoryFragment : Fragment() {
    companion object {
        fun newInstance() = HistoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.history_fragment, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://spaceflightnewsapi.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(HistoryWebServices::class.java)
        val historyService = HistoryService(retrofitService)

        historyService.getRandomHistory(
            { history ->
                view.HistoryTitle.text = history.title
                Picasso.get().load(history.featured_image).into(view.spaceImage)
            }, { error -> TODO() }
        )
    }

}