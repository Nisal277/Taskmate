package com.example.taskmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskmate.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddNoteBinding
    private lateinit var db:NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val tile = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,tile,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT ).show()

        }

    }
}