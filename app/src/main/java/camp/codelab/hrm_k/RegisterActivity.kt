package camp.codelab.hrm_k

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        registrationbutton.setOnClickListener {

            performregister()


        }

        already_have_accounttextView.setOnClickListener {

           finish()



        }


    }

    private fun performregister() {
        val email = emaileditText2_register.text.toString()
        val password = passwordeditText3_register.text.toString()


        if (email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "please enter email or password", Toast.LENGTH_LONG).show()
            return

        }
        //Firebase Authntication
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                if (!it.isSuccessful) return@addOnCompleteListener

                Toast.makeText(this, "Successfully created user with id: ${it.result.user.uid}", Toast.LENGTH_LONG).show()


            }
            .addOnFailureListener {

                Toast.makeText(this, "please enter email or password", Toast.LENGTH_LONG).show()
            }

    }

}
