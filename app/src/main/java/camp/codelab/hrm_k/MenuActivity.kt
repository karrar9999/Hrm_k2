package camp.codelab.hrm_k

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.item_employees.*

private const val TAG = "MenuActivity"

class MenuActivity : AppCompatActivity() {
    val employees: MutableList<Employee> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        preparRecyclerView()

        employees_managment_button.setOnClickListener {

            val intent = Intent(this, EmployeesManagmentActivity::class.java)
            startActivity(intent)
        }
    }


    private fun preparRecyclerView() {

        val db = FirebaseDatabase.getInstance()
        val ref = db.getReference("employees")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MenuActivity, error.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {


                snapshot.children.forEach { child ->


                    val employee = child.getValue(Employee::class.java)

                    employee?.let { employee ->


                        employees.add(employee)


                    }


                }

                recyclerViwe.layoutManager = LinearLayoutManager(this@MenuActivity, RecyclerView.VERTICAL, false)
                recyclerViwe.adapter = EmployeesAdapter(employees)

            }
        })
    }
}