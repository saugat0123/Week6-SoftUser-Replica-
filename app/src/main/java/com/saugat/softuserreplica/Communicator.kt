package com.saugat.softuserreplica

import com.saugat.softuserreplica.model.Student

interface Communicator {
    fun passData(lstStd: ArrayList<Student>)
}