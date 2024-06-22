package com.github.saleshelper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SaleLaunchActivity : AppCompatActivity() {

    private lateinit var etCode : EditText
    private lateinit var etAmount : EditText
    private lateinit var etValue : EditText

    private lateinit var btConfirm : Button
    private lateinit var btList : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale_launch)

        initComponents()

    }


    fun initComponents() {
        etCode = findViewById(R.id.etCode)
        etAmount = findViewById(R.id.etAmount)
        etValue = findViewById(R.id.etValue)

        btConfirm = findViewById(R.id.btConfirm)
        btList = findViewById(R.id.btList)

        btConfirm.setOnClickListener{
            btConfirmOnClick()
        }

        btList.setOnClickListener{
            btListOnCLick()
        }
    }


    private fun btListOnCLick() {
        val intent = Intent(this, ListActivity::class.java).let{
            getResult.launch(it)
        }
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            if (it.data != null) {
                val ret = it.data?.getIntExtra("returnCode", 0)
                etCode.setText(ret.toString())
            }
        }
    }


    private fun btConfirmOnClick() {
        val intent = Intent(this, ConfirmActivity::class.java)
        intent.putExtra("code", etCode.text.toString())
        intent.putExtra("amount", etAmount.text.toString())
        intent.putExtra("value", etValue.text.toString())
        startActivity(intent)
    }
}