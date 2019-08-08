package com.github.outerheavenproject.wanstagram.ui

interface MainContract {
    interface View {
        fun shareDogs(dogs: Set<String>)
    }

    interface Presenter {
        fun start()
        fun share()
    }
}
