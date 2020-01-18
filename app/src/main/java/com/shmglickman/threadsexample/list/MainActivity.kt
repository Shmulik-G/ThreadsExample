package com.shmglickman.threadsexample.list

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.shmglickman.threadsexample.R
import com.shmglickman.threadsexample.threads.AsyncTaskActivity
import com.shmglickman.threadsexample.threads.ThreadsActivity
import kotlin.system.exitProcess
import android.view.Menu as Menu1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu1): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.movies_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_open_async_task -> {
                // Open Async Task Activity
                startActivity(Intent(this@MainActivity, AsyncTaskActivity::class.java))
                return true
            }

            R.id.action_open_thread_handler -> {
                // Open Thread Handler Activity
                startActivity(Intent(this@MainActivity, ThreadsActivity::class.java))
                return true
            }

            R.id.exit -> {
                // Exit App
                exitProcess(0)
            }
            else ->
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item)
        }
    }

}