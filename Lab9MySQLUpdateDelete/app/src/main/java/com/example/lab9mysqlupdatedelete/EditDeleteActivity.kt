package com.example.lab9mysqlupdatedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_edit_delete.*
import okhttp3.Response
import retrofit2.Call
import javax.security.auth.callback.Callback

class EditDeleteActivity : AppCompatActivity() {
    val createClient = StudentAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_delete)

        val mID = intent.getStringExtra("mId")
        val mName = intent.getStringExtra("mName")
        val mAge = intent.getStringExtra("mAge")

        edt_id.setText(mID)
        edt_id.isEnabled = false
        edt_name.setText(mName)
        edt_age.setText(mAge)
    }
    fun saveStudent(view: View){
        createClient.updateStudent(

            edt_id.text.toString(),
            edt_name.text.toString(),
            edt_age.text.toString().toInt()
        ).enqueue(object : retrofit2.Callback<Student> {
                override fun onResponse(call: Call<Student>, response: retrofit2.Response<Student>){
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext, "Successfully Updated", Toast.LENGTH_LONG).show()
                        finish()
                    }else{
                        Toast.makeText(applicationContext, "Update Failure", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<Student>, t: Throwable) = t.printStackTrace()
            })

    }
    fun deleteStudent(view: View){


    }
}

