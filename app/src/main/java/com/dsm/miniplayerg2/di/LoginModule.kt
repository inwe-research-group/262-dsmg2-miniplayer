package com.dsm.miniplayerg2.di

import com.dsm.miniplayerg2.ui.screens.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    // ViewModel
    viewModel { LoginViewModel() }
}