package mdmccullough.wccnet.edu.coroutines

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mdmccullough.wccnet.edu.coroutines.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {




    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    private val coroutineScope = CoroutineScope(Dispatchers.Main)



    fun launchCoroutine(view: View) {

        coroutineScope.launch(Dispatchers.Main) {
            startCoroutine()


        }
    }

    private suspend fun startCoroutine() {
        val name = binding.addNameText.text.toString()
        binding.addNameText.text.clear()
        val random = (1..10).random().times(1000).toLong()
        delay(random)
        mainViewModel.nameList.add(name)
        mainViewModel.delayList.add(random)
        adapter?.notifyDataSetChanged()
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

//        setSupportActionBar(binding.toolbar)
        layoutManager = LinearLayoutManager(this)
        binding.myRecyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(mainViewModel)
        binding.myRecyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}