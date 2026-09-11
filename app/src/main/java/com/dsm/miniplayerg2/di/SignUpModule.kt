package com.dsm.miniplayerg2.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.dsm.miniplayerg2.ui.screens.signup.SignUpViewModel

val signUpModule = module {
    // ViewModel
    viewModel { SignUpViewModel() }
}