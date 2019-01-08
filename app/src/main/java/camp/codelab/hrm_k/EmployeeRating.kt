package camp.codelab.hrm_k

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_managment_employees.*

class EmployeeRating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)


        back_button.setOnClickListener {

            val intent = Intent(this@EmployeeRating, EmployeesManagmentActivity::class.java)
            startActivity(intent)


        }


    }


}