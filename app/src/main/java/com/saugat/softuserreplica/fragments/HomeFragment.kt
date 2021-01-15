package com.saugat.softuserreplica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saugat.softuserreplica.R
import com.saugat.softuserreplica.StudentListData
import com.saugat.softuserreplica.adapter.StudentAdapter
import com.saugat.softuserreplica.model.Student


class HomeFragment : Fragment() {
    private val lstStudents = ArrayList<Student>()
    private lateinit var recyclerView: RecyclerView
    //private lateinit var recyclerView2: RecyclerView
    //private var newList = ArrayList<Student>()


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
//

        if (StudentListData.get().list().size == 0){
            loadStudents()
        }

        val adapter = StudentAdapter(StudentListData.get().list(),context!!)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        return view

    }

    private fun loadStudents() {
        StudentListData.get().list().add(Student(1,"Will","Ratopul",21,"Male"))
        StudentListData.get().list().add(Student(2,"Eleven","Maitidevi",22,"Female"))
        StudentListData.get().list().add(Student(3,"Mike","Baneswor",20,"Male"))
    }

}