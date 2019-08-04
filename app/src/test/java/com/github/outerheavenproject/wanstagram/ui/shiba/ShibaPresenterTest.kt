package com.github.outerheavenproject.wanstagram.ui.shiba

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.outerheavenproject.wanstagram.data.Dog
import com.github.outerheavenproject.wanstagram.data.DogService
import com.github.outerheavenproject.wanstagram.data.Dogs
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShibaPresenterTest {

    private lateinit var presenter: ShibaPresenter
    private lateinit var dogService: DogService
    private lateinit var view: TestView

    @Before
    fun setUp() {
        dogService = TestDogService()
        view = TestView()
        presenter = ShibaPresenter(dogService = dogService)
        presenter.attachView(view)
    }

    @Test
    fun start() {
        runBlockingTest {
            presenter.start()
        }

        Truth.assertThat(view.called).isEqualTo(1)
    }
}

private class TestDogService : DogService {
    override suspend fun getDog(): Dog {
        return Dog(url = "1", status = "success")
    }

    override suspend fun getDogs(limit: Int): Dogs {
        return Dogs(urls = listOf("1"), status = "success")
    }

    override suspend fun getBleed(bleed: String, limit: Int): Dogs {
        return Dogs(urls = listOf("1"), status = "success")
    }
}

private class TestView : ShibaContract.View {
    var called: Int = 0

    override fun updateDogs(dogs: Dogs) {
        called += 1
    }
}
