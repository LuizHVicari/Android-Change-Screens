package com.github.saleshelper

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    private lateinit var lvProducts : ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list)

        lvProducts = findViewById(R.id.lvProducts)
        lvProducts.setOnItemClickListener{parent, view, position, id ->
            val selectedCode = position + 1
            intent.putExtra("returnCode", selectedCode)
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}