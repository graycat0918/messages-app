package top.gpg2.messages

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dry.messages.SessionsDisplayer
import com.dry.messages.NewMessageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottomAppBar)
        if (Build.VERSION.SDK_INT >= 23) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = resources.getColor(R.color.colorPrimary)
        }

    }

    override fun onResume() {
        super.onResume()
        SessionsDisplayer(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_bottom_action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_new_conversation -> {
                toast("New Messages Activity")
                val intent = Intent(this, NewMessageActivity::class.java)
                // start your next activity
                startActivity(intent)
            }
            R.id.action_settings -> toast("Settings Activity")
            android.R.id.home -> {
                val navigationSheetFragment = NavigationSheetFragment()
                navigationSheetFragment.show(supportFragmentManager, navigationSheetFragment.tag)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun toast(text: CharSequence) {
        val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toast.show()
    }
}
