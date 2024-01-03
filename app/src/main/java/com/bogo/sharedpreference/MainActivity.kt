package com.bogo.sharedpreference

import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bogo.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sp: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sp = getSharedPreferences("my sp", MODE_PRIVATE)
    }

    override fun onPause() {
        super.onPause()
        val name = binding.editTextText.text.toString()
        val age = binding.editTextText2.text.toString().toInt()

        val editor = sp.edit()

        editor.apply{
            putString("sp_name",name)
            putInt("sp_age",age)
            commit()
        }


    }

    override fun onResume() {
        super.onResume()
        val name = sp.getString("sp_name","null")
        val age = sp.getInt("sp_age",0)

        binding.editTextText2.setText(name)
        if (name!=null){
            binding.editTextText.setText(name.toString())
        }

        if (age!=0){
            binding.editTextText2.setText(age.toString())
        }
    }

}