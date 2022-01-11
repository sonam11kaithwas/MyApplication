package android.com.myapplication.user_list_pkg

import android.com.myapplication.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Sona-11 on 29/12/21.
 */
class UserListCustomAdapter(var mList: List<UserListRes>) :
    RecyclerView.Adapter<UserListCustomAdapter.ViewHolder>() {
    var contexts: Context? = null
    fun updateUserList(list: List<UserListRes>) {
        this.mList.isEmpty()
        this.mList = list
        notifyDataSetChanged()
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_adpter, parent, false)
        contexts = parent.context
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val userListRes = mList[position]

        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(userListRes.avatar)
        Glide.with(contexts!!)
            .load(userListRes.avatar)
            .override(300, 200)
            .into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        holder.textView.text =
            userListRes.first_name + " " + userListRes.last_name + "\n" + userListRes.email

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
