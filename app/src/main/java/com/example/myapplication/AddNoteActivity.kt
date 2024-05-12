package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

     private lateinit var binding : ActivityAddNoteBinding
     private lateinit var db : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNoteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        db=DatabaseHelper(this)

        binding.imageView.setOnClickListener {
            val title =binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note =Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }
        }
    }
