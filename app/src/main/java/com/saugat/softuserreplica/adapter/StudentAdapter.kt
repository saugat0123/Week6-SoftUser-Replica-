package com.saugat.softuserreplica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saugat.softuserreplica.R
import com.saugat.softuserreplica.model.Student
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(
        val lstStudents: ArrayList<Student>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val btnDelete: ImageButton
        val imgProfile: CircleImageView
        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView

        init {
            btnDelete = view.findViewById(R.id.btnDelete)
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudents[position]
        holder.tvName.text = student.studentName
        holder.tvAge.text = student.studentAge.toString()
        holder.tvAddress.text = student.studentAddress
        holder.tvGender.text = student.studentGender

        holder.btnDelete.setOnClickListener{
            lstStudents.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position,lstStudents.size)
            Toast.makeText(context, "Student Deleted!!", Toast.LENGTH_SHORT).show()
        }

        when(student.studentGender){
            "Male" -> Glide.with(context)
                    .load("https://cdn.wallpapersafari.com/4/72/Ou9IRM.jpg")
                    .into(holder.imgProfile)
            "Female" -> Glide.with(context)
                    .load("https://media.istockphoto.com/vectors/default-avatar-profile-icon-grey-photo-placeholder-hand-drawn-modern-vector-id1273297923?b=1&k=6&m=1273297923&s=612x612&w=0&h=kCbZRaXozftYrZv44poGI6_RrTg7DMa1lIqz_NtZNis=")
                    .into(holder.imgProfile)
            "Other" -> Glide.with(context)
                    .load("https://png.pngtree.com/png-vector/20190217/ourmid/pngtree-smile-vector-template-design-illustration-png-image_555082.jpg")
                    .into(holder.imgProfile)
        }


    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}