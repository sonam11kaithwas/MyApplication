package android.com.myapplication

import android.com.myapplication.user_list_pkg.UserListActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intent = Intent(this, UserListActivity::class.java)
        startActivity(intent)
    }

}



