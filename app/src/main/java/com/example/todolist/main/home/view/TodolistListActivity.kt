package com.example.todolist.main.home.view
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.databinding.*
import com.example.todolist.main.home.model.Todo

class TodolistListActivity: AppCompatActivity() {
    private val data:MutableList<Todo> = mutableListOf()

    private lateinit var binding : TodolistListBinding
    private lateinit var itemBinding: TodoItemBinding
    val adapter = RecycleAdapter(
        deleteItem = {removeItem(it)}
    )
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

            mDialogView.closeButton.setOnClickListener {
                mAlertDialog.dismiss()
            }
            mDialogView.successButton.setOnClickListener {
                val userText = mDialogView.editText.text.toString();
                data.add(Todo(0, userText, R.drawable.bird))
                binding.recyclerView.adapter?.notifyDataSetChanged()
                mAlertDialog.dismiss()
            }
        }

        itemBinding = TodoItemBinding.inflate(layoutInflater)
//        itemBinding.removeBtn.setOnClickListener {
//            binding.recyclerView.adapter?.notifyDataSetChanged()
//        }

        adapter.setItemClickListener(object: RecycleAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                data.removeAt(position)
//                val item = data[position]
//                println(position)
//                Toast.makeText(v.context, "Activity\n${item.todo}\n" +
//                        "${position}", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }
        })
    }
    fun removeItem (todo:Todo) {
        println(todo)
    }
    private fun refreshRecyclerView(){
        adapter.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
