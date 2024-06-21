package com.example.ecommerce

import com.example.ecommerce.api.Result
import com.example.ecommerce.presentation.screens.productList.mvi.ProductsScreenState
import com.example.ecommerce.presentation.screens.productList.ProductsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ProductsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val dummyVolumeDomainModel = VolumeDomainModel(unit = "litres", value = 5)
    private val beerOne = BeersDomainModel(
        abv = 0.0,
        attenuationLevel = 0.0,
        boilVolume = dummyVolumeDomainModel,
        brewersTips = "",
        contributedBy = "",
        description = "",
        ebc = 0,
        firstBrewed = "",
        foodPairing = emptyList(),
        ibu = 0.0,
        id = 0,
        imageUrl = "",
        name = "",
        ph = 0.0,
        srm = 0.0,
        tagline = "",
        targetFg = 0,
        targetOg = 0.0,
        volume = dummyVolumeDomainModel
    )

    private val beerTwo = beerOne.copy(abv = 2.0)
    private val beerThree = beerOne.copy(abv = 3.0)
    private val dummyBeersList = listOf(beerOne, beerTwo, beerThree)

    private lateinit var viewModel: ProductsViewModel

    @Test
    fun `call to getBeersList should return with proper list data`() = runTest {
        val mockBeersRepository = mockk<BeersRepository> {
            coEvery { fetchBeers() } returns Result.Success(dummyBeersList)
        }
        viewModel = ProductsViewModel(mockBeersRepository)

        val state = viewModel.state.value as? ProductsScreenState

        assertEquals(state?.beers, dummyBeersList)
        assertEquals(state?.isLoading, false)
        assertEquals(state?.beers?.size, 3)
    }

    @Test
    fun `when we fetch beersList and an error occurs it should be handled`() = runTest {
        val mockBeersRepository = mockk<BeersRepository> {
            coEvery { fetchBeers() } returns Result.Error("Exception Occurred")
        }
        viewModel = ProductsViewModel(mockBeersRepository)

        val state = viewModel.state.value as? ProductsScreenState

        assertEquals(state?.isLoading, false)
        assertTrue(state?.errorMsg?.isNotBlank()?: false)
    }
}


