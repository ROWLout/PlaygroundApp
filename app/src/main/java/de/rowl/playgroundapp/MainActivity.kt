package de.rowl.playgroundapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "EXTRA_MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val sendButton: Button = findViewById(R.id.send_button)
        val editText = findViewById<EditText>(R.id.editText)

        val messages = mutableListOf<Message>()
        for (i in 0..9)
            messages.add(Message("Boarisch", "De mim Huat de san guad, de mim Kappe san dappe", "Quirin"))

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MessagesAdapter(messages)
        }

        sendButton.setOnClickListener {
            val newMessage = editText.text.toString()
            if(newMessage.isEmpty()) {
                Toast.makeText(applicationContext, "Dei Spruch is laar, du Gloiffe! Bittschön Text eigebn", Toast.LENGTH_SHORT).show()
            }else{
                sendMessage(newMessage)
            }
        }

        val service:SearchService = Retrofits().create()
        val response:TotalCountResponse? = service.getTotalCount('C').execute().body()
        val responseBike:TotalCountResponse? = service.getTotalCount('B').execute().body()
        sendButton.text = "Fahrzeuge ${response?.tc}\n Bikes ${responseBike?.tc}"
    }

    private fun sendMessage(newMessage: String) {
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, newMessage)
        }
        startActivity(intent)
    }
}
