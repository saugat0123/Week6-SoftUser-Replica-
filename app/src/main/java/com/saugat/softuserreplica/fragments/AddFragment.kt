package com.saugat.softuserreplica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.saugat.softuserreplica.Communicator
import com.saugat.softuserreplica.R
import com.saugat.softuserreplica.StudentListData
import com.saugat.softuserreplica.model.Student


class AddFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnSave: Button
    private lateinit var male: RadioButton
    private lateinit var female: RadioButton
    private lateinit var other: RadioButton
    private lateinit var tvGender: TextView
    private val lstStudents = ArrayList<Student>()
    private var i = 4
    private var selectedGender = ""
    private lateinit var communicator: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        radioGroup = view.findViewById(R.id.radioGroup)
        btnSave = view.findViewById(R.id.btnSave)
        male = view.findViewById(R.id.male)
        female = view.findViewById(R.id.female)
        other = view.findViewById(R.id.other)
        tvGender = view.findViewById(R.id.tvGender)

        //communicator = activity as Communicator

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedGender = when (checkedId) {
                R.id.male -> {
                    male.text.toString()
                }
                R.id.female -> {
                    female.text.toString()
                }
                R.id.other -> {
                    other.text.toString()
                }
                else -> {
                    ""
                }
            }
        }


        btnSave.setOnClickListener {
            if (validate()) {
                StudentListData.get().list().add(Student(i++, etName.text.toString(), etAddress.text.toString(), etAge.text.toString().toInt(), selectedGender))
                //communicator.passData(lstStudents)
                val bundle = Bundle()
                bundle.putString("listData", "passedData")
                HomeFragment().arguments = bundle
                Toast.makeText(activity, "Student Added!!", Toast.LENGTH_LONG).show()
                etName.setText("")
                etAddress.setText("")
                etAge.setText("")
                radioGroup.isChe
            }

        }


        return view
    }

    private fun validate(): Boolean {
        return when {
            radioGroup.checkedRadioButtonId == -1 ->{
                tvGender.error = "Select Gender"
                Toast.makeText(context, "Please Select Gender", Toast.LENGTH_SHORT).show()
                false
            }

            etName.text.toString().isEmpty() -> {
                etName.error = "Blank Name"
                false
            }
            etAddress.text.toString().isEmpty() -> {
                etAddress.error = "Blank Address"
                false
            }
            etAge.text.toString().isEmpty() -> {
                etAge.error = "Blank Age"
                false
            }
            else -> true
        }


    }

}