package com.github.saleshelper

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmActivity : AppCompatActivity() {

    private lateinit var tvCodeString : TextView
    private lateinit var tvAmountString : TextView
    private lateinit var tvValueString : TextView
    private lateinit var btSend : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        initComponents()
        setTextValuesFromExtras()
    }


    private fun setTextValuesFromExtras() {
        val code = intent.getStringExtra("code")
        val amount = intent.getStringExtra("amount")
        val value = intent.getStringExtra("value")

        tvCodeString.text = code
        tvAmountString.text = amount
        tvValueString.text = value
    }


    private fun initComponents() {
        tvCodeString = findViewById(R.id.tvCodeString)
        tvAmountString = findViewById(R.id.tvAmountString)
        tvValueString = findViewById(R.id.tvValueString)

        btSend = findViewById(R.id.btSend)

        btSend.setOnClickListener{
            btSendOnClick()
        }
    }

    private fun btSendOnClick() {
        val smsBody = "Código ${tvCodeString.text}, Qtd: ${tvAmountString.text}, Valor: ${tvValueString}"
        val phone = "sms:+5546123456789"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(phone))
        intent.putExtra("sms_body", smsBody)

        startActivity(intent)
    }
}