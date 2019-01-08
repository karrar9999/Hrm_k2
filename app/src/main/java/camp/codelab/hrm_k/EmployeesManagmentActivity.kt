package camp.codelab.hrm_k

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_managment_employees.*

class EmployeesManagmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_managment_employees)


        val db = FirebaseDatabase.getInstance()
        val ref = db.getReference("employees")

        back_button.setOnClickListener {

            finish()


        }

        // ratingButton.setOnClickListener {rating->
        //   val intent1=Intent(rating.context,EmployeeRating::class.java)
        //  startActivity(intent1)

        // }

        AddButton.setOnClickListener { add ->

            Log.v("TEST", "ADD BUTTON")
            val name = name_employee_editText.text.toString()
            val age = age_employee_editText.text.toString().toInt()
            val salary = salaryeditText.text.toString().toInt()

            var employee = Employee(name, age, salary)

            ref.push()
                .setValue(employee)


        }


    }

}