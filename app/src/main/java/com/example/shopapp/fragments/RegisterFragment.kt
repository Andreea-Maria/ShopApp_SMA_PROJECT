package com.example.shopapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
//import br.com.simplepass.loadingbutton.customViews.CircularProgressButton
import com.example.shopapp.databinding.RegisterBinding
import com.example.shopapp.model.User
import com.example.shopapp.viewmodel.RegisterViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.shopapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.shopapp.R

private const val TAG = "RegisterFragment"

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: RegisterBinding
    lateinit var viewModel: RegisterViewModel
    //val buttonRegister: Button = findViewById(R.id.register_button)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.apply{
            registerButton.setOnClickListener{
                val user = User(
                    firstNameEditText.text.toString().trim(),
                    lastNameEditText.text.toString().trim(),
                    emailEditText.text.toString().trim()
                )
                val password = passwordEditText.text.toString()
                viewModel.createAccountWithEmailAndPassword(user,password)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.register.collect{
                when(it){
                    is Resource.Loading -> {
                        binding.registerButton.isEnabled = false
                        binding.registerButton.text = "Loading..."


                    }
                    is Resource.Success -> {
                        Log.d("test",it.toString())
                    }
                    is Resource.Error -> {
                        Log.e(TAG,it.message.toString())
                    }
                }
            }
        }
    }
}

