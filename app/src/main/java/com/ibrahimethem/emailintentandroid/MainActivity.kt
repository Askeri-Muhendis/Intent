package com.ibrahimethem.emailintentandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ibrahimethem.emailintentandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendBtn.setOnClickListener {
            val email = binding.emailAddress.text.toString()
            val subject = binding.subject.text.toString()
            val message = binding.message.text.toString()

            val address = email.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,address)
                putExtra(Intent.EXTRA_SUBJECT,subject)
                putExtra(Intent.EXTRA_TEXT,message)
            }

            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }else{
                Toast.makeText(this,"istek reddedildi",Toast.LENGTH_LONG).show()
            }
        }
    }
}