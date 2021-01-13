package com.saugat.softuserreplica.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saugat.softuserreplica.R
import com.saugat.softuserreplica.adapter.StudentAdapter
import com.saugat.softuserreplica.model.Student


class HomeFragment : Fragment() {
    private val lstStudents = ArrayList<Student>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        loadStudents()
        val adapter = StudentAdapter(lstStudents,this@HomeFragment)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        return view

    }

    private fun loadStudents() {
        lstStudents.add(Student(1,"Student 1","Ratopul",21,"Male"))
        lstStudents.add(Student(2,"Student 2","Maitidevi",22,"Female"))
        lstStudents.add(Student(3,"Student 3","Ratopul",20,"Male"))
    }

}