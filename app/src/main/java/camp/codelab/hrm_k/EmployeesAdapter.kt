package camp.codelab.hrm_k

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import camp.codelab.hrm_k.R.id
import camp.codelab.hrm_k.R.layout

class EmployeesAdapter(val employees: List<Employee>) : RecyclerView.Adapter<EmployeesAdapter.EmployeeViweHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViweHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employees, parent, false)
        return EmployeeViweHolder(view)
    }


    override fun getItemCount(): Int {
        return employees.size

    }

    override fun onBindViewHolder(viewHolder: EmployeeViweHolder, position: Int) {
        viewHolder.setEmployee(employees[position])

    }


    inner class EmployeeViweHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun setEmployee(employee: Employee) {
            view.findViewById<TextView>(id.name_textView).text = employee.name


        }

    }

}
