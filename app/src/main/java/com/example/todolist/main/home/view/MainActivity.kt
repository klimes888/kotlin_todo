package com.example.todolist.main.home.view
import com.example.todolist.main.home.view.TodolistListActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.databinding.MainActivityBinding

class MainActivity: AppCompatActivity(){
    private lateinit var binding : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moveView.setOnClickListener {
            val intent = Intent(this, TodolistListActivity::class.java)
            startActivity(intent)
        }
    }
}