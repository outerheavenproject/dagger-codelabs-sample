package com.github.outerheavenproject.wanstagram.ui.dogaction

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DogActionBottomSheetDialogFragmentModule {
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
