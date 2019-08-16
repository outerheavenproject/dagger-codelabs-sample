package com.github.outerheavenproject.wanstagram.ui.dogaction

import com.github.outerheavenproject.wanstagram.di.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogActionBottomSheetDialogFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            DogActionBottomSheetDialogFragmentBindModule::class
        ]
    )
    fun contributeDogActionBottomSheetDialogFragment(): DogActionBottomSheetDialogFragment
}

@Module
interface DogActionBottomSheetDialogFragmentBindModule {
    @Binds
    fun bindView(fragment: DogActionBottomSheetDialogFragment): DogActionBottomSheetContract.View

    @Binds
    fun bindPresenter(presenter: DogActionBottomSheetPresenter): DogActionBottomSheetContract.Presenter
}
