package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {addNickname(it)}
        binding.nicknameText.setOnClickListener {updateNickname(it)}
    }

    private fun addNickname(view: View){
        binding.apply {
            nicknameText.text = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        binding.nicknameText.visibility = View.GONE
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE

        nickname_edit.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname_edit, 0)
    }
}