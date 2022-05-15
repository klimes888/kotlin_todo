package com.example.todolist.main.home.view
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.databinding.*
import com.example.todolist.main.home.model.Todo


class TodolistListActivity: AppCompatActivity() {
    private val data:MutableList<Todo> = mutableListOf()
    private val adapter = RecycleAdapter()

    private lateinit var binding : TodolistListBinding
    private lateinit var todoItemBinding: TodoItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodolistListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        refreshRecyclerView()

        binding.fabBtn.setOnClickListener(){
            val mDialogView = CustomDialogBinding.inflate(layoutInflater)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView.root)
            val mAlertDialog = mBuilder.show()

            mDialogView.closeButton.setOnClickListener(){
                mAlertDialog.dismiss()
            }
            mDialogView.successButton.setOnClickListener(){
                val userText = mDialogView.editText.text.toString();
                data.add(Todo(0, userText, R.drawable.bird))
                binding.recyclerView.adapter?.notifyDataSetChanged()
                mAlertDialog.dismiss()

            }
        }

    }

    private fun refreshRecyclerView(){
        adapter.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
