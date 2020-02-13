package de.rowl.playgroundapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val sendButton: Button = findViewById(R.id.send_button)
        val editText = findViewById<EditText>(R.id.editText)
        val messages = mutableListOf<Message>()
        for (i in 0..9)
            messages.add(Message("Boarisch", "De mim Huat de san guad", "Quirin"))

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MessagesAdapter(messages)
        }

        sendButton.setOnClickListener {
            val newMessage = editText.text.toString()
            if(newMessage.isEmpty()) {
                Toast.makeText(applicationContext, "Bitte Text eingeben!", Toast.LENGTH_SHORT).show()
            }else{
                sendMessage(newMessage)
            }
        }
    }

    private fun sendMessage(newMessage: String) {
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, newMessage)
        }
        startActivity(intent)
    }
}
