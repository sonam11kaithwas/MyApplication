package android.com.myapplication.user_list_pkg

import android.com.myapplication.R
import android.com.myapplication.databinding.ActivityUserListBinding
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {

    lateinit var test: String
    var userListViewModel: UserListViewModel? = null
    var activityUserListBinding: ActivityUserListBinding? = null
    lateinit var myadpter: UserListCustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        activityUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)

        initializeViews()

        userListViewModel?.usreMutableList?.observe(this, Observer {
            myadpter.updateUserList(it)
        })
    }


    fun initializeViews() {
        var recylerView = findViewById<RecyclerView>(R.id.recylerView)
        recylerView.layoutManager = LinearLayoutManager(this)
        val dataList = ArrayList<UserListRes>()

        myadpter = UserListCustomAdapter(dataList)
        recylerView.adapter = myadpter

        userListViewModel?.getUserListFromSrvr()

    }
}