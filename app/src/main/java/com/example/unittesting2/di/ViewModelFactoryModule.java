package com.example.unittesting2.di;

import com.example.unittesting2.ViewModels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;


import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}