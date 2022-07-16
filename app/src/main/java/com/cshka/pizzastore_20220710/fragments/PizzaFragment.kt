package com.cshka.pizzastore_20220710.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cshka.pizzastore_20220710.DetailSotreActivity
import com.cshka.pizzastore_20220710.R
import com.cshka.pizzastore_20220710.StoreData
import com.cshka.pizzastore_20220710.adapters.StoreListAdapter
import kotlinx.android.synthetic.main.fragment_pizza.*

class PizzaFragment : Fragment() {
    lateinit var mStoreListAdapter : StoreListAdapter
    val mList = ArrayList<StoreData>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        
        mList.add(StoreData("피자헛", 4.2, "1588-5588"))
        mList.add(StoreData("피자헛2", 2.2, "1588-5589"))
        mList.add(StoreData("피자헛3", 3.2, "1588-5580"))
        mList.add(StoreData("피자헛4", 5.2, "1588-5581"))
        
        mStoreListAdapter = StoreListAdapter(requireContext(), R.layout.store_list_item, mList)
        pizzaStoreListView.adapter = mStoreListAdapter
        
        pizzaStoreListView.setOnItemClickListener { adapterView, view, i, l ->
            val myIntent = Intent(requireContext(), DetailSotreActivity::class.java)
            myIntent.putExtra("storeData", mList[i])
            startActivity(myIntent)
        }
    }
}