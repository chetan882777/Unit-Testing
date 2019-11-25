package com.example.unittesting2.di;

import com.example.unittesting2.ViewModels.ViewModelProviderFactory;
import com.example.unittesting2.ui.note.NoteViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel.class)
    public abstract ViewModel bindNoteViewModel(NoteViewModel noteViewModel);
}