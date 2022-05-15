package com.example.todolist.main.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TodoItemBinding
import com.example.todolist.databinding.TodolistListBinding
import com.example.todolist.main.home.controller.TodoHolder
import com.example.todolist.main.home.model.Todo

class RecycleAdapter:RecyclerView.Adapter<TodoHolder>() {
    var listData = mutableListOf<Todo>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
            val item = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TodoHolder(item)
        }
        override fun onBindViewHolder(holder: TodoHolder, position: Int) {
            val member = listData[position]
            holder.setData(member)
        }
        override fun getItemCount(): Int {
            return listData.size
        }
}