package com.github.outerheavenproject.wanstagram.ui.dogaction

interface DogActionBottomSheetContract {
    interface View {
    }

    interface Presenter {
        fun start(url: String)
        fun share()
    }
}
