package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("FatiWi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        fun addNickname(view: View) {
            binding.apply {
                myName?.nickname = nicknameEdit.text.toString()
                invalidateAll()
                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }
            //val editText = findViewById<EditText>(R.id.nickname_edit)
            //binding.nicknameText.text = binding.nicknameEdit.text.toString()
            //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
            //nicknameTextView.text = editText.text
            //editText.visibility = View.GONE
            // binding.nicknameText.visibility = View.GONE
            view.visibility = View.GONE
            //nicknameTextView.visibility = View.VISIBLE
            //binding.nicknameText.visibility = View.VISIBLE
            // Hide the keyboard.
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as
                    InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun updateNickname (view: View) {
            binding.apply {
                nicknameEdit.visibility = View.VISIBLE
                doneButton.visibility = View.VISIBLE
                nicknameEdit.requestFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(nicknameEdit, 0)
            }
            //val editText = findViewById<EditText>(R.id.nickname_edit)
           //val doneButton = findViewById<Button>(R.id.done_button)
           //editText.visibility = View.VISIBLE
            //doneButton.visibility = View.VISIBLE
            view.visibility = View.GONE

            // Set the focus to the edit text.
            //editText.requestFocus()
            // Show the keyboard.


        }

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }


    }
}