package com.anywhereapps.outdoorsy.test.ui.main.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.anywhereapps.outdoorsy.test.R
import com.anywhereapps.outdoorsy.test.data.api.ApiHelper
import com.anywhereapps.outdoorsy.test.data.api.RetrofitBuilder
import com.anywhereapps.outdoorsy.test.data.model.Result
import com.anywhereapps.outdoorsy.test.ui.base.ViewModelFactory
import com.anywhereapps.outdoorsy.test.ui.main.adapter.ResultAdapter
import com.anywhereapps.outdoorsy.test.ui.main.viewmodel.MainViewModel
import com.anywhereapps.outdoorsy.test.utils.Status.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()

    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
            .get(MainViewModel::class.java)
    }

    private fun setupUI() {
        // recylerview setup
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ResultAdapter(null)
        recyclerView.adapter = adapter

        searchTxt.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var text = s.toString()

            if (text.length > 2) {
                getData(text, 50)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }



    private fun getData(search: String, limit : Int) {

        viewModel.getResults(search, limit).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { data -> updateView(data) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun updateView(result: Result) {

//        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(searchTxt.windowToken, 0)

        adapter.apply {
            addData(result)
            notifyDataSetChanged()
        }
    }

}
