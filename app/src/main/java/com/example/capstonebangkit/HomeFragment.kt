package com.example.capstonebangkit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonebangkit.model.DataAdapter
import com.example.capstonebangkit.model.DataInformation
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class HomeFragment : Fragment() {
    private val list = ArrayList<DataInformation>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home,container,false)
        root.btn_to_report.setOnClickListener{
            activity?.startActivity(Intent(activity, ReportActivity::class.java))
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_home.setHasFixedSize(true)
        showrv()
        list.addAll(getdata())
    }
    private fun getdata(): ArrayList<DataInformation>{
        val judullist = resources.getStringArray(R.array.judul)
        val imagelist = resources.obtainTypedArray(R.array.image)
        val datalists = ArrayList<DataInformation>()
        for (position in judullist.indices){
            val dataInformation = DataInformation(
                    imagelist.getResourceId(position, -1),
                    judullist[position]
            )
            datalists.add(dataInformation)
        }
        return datalists
    }
    private fun showrv(){
        rv_home.layoutManager = LinearLayoutManager(activity)
        val wasd = DataAdapter(list, requireActivity())
        rv_home.adapter = wasd
    }
}