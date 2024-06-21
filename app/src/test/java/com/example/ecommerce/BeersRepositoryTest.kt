package com.example.ecommerce

import com.example.ecommerce.api.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class BeersRepositoryTest {

    private val dummyTemp = Temp("", 0)
    private val dummyFermentation = Fermentation(dummyTemp)
    private val dummyMashTemp = MashTemp(0, dummyTemp)
    private val dummyMashTempList = listOf(dummyMashTemp)
    private val dummyVolume = Volume("", 0)

    private val beerOne = BeersDto(
        abv = 0.0,
        attenuation_level = 0.0,
        boil_volume = BoilVolume("", 0),
        brewers_tips = "",
        contributed_by = "",
        description = "",
        ebc = 0,
        first_brewed = "",
        food_pairing = emptyList(),
        ibu = 0.0,
        id = 0,
        image_url = "",
        method = Method(
            fermentation = dummyFermentation,
            mash_temp = dummyMashTempList,
            twist = ""
        ),
        name = "",
        ph = 0.0,
        srm = 0.0,
        tagline = "",
        target_fg = 0,
        target_og = 0.0,
        volume = dummyVolume
    )

    private val beerTwo = beerOne.copy(abv = 1.0)
    private val dummyBeerList = listOf<BeersDto>(beerOne, beerTwo)
    private val dummySingleBeersList = listOf<BeersDto>(beerOne)

    @Test
    fun `when we fetch the beers list, then we get the list of beers from api`() = runTest {
        val remoteDataSource = mockk<RemoteDataSource> {
            coEvery { getPunkBeersData() } returns dummyBeerList
        }

        val beersRepository = BeersRepositoryImpl(remoteDataSource)
        val beersListResult = beersRepository.fetchBeers()

        assertTrue((beersListResult as Result.Success).data.isNotEmpty())
        assertEquals((beersListResult).data.size, 2)
    }

    @Test
    fun `when we fetch the beers and an error occurs, then we get proper exception`() = runTest {
        val remoteDataSource = mockk<RemoteDataSource>()

        val beersRepository = BeersRepositoryImpl(remoteDataSource)
        val beersListResult = beersRepository.fetchBeers()

        assertTrue((beersListResult as Result.Error).exception.isNotEmpty())
    }
}


