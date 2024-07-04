package com.example.ecommerce.domain.usecases

import com.example.ecommerce.api.Result
import com.example.ecommerce.data.repository.products.FakeProductsRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class GetProductListUsecaseTest {

    private lateinit var fakeProductsRepositoryImpl: FakeProductsRepositoryImpl
    private lateinit var getProductListUsecase: GetProductListUsecase

    @Test
    fun `products response success test case `() = runTest {
        val k = getProductListUsecase.invoke()
        if (k is Result.Success) {
            assert(k.data?.size!! > 0)
        }
        assert(k is Result.Success)
    }

    @Test
    fun `products response failure test case `() = runTest {
        val k = getProductListUsecase.invoke()
        if (k is Result.Error) {
            assert(k.errorCode!! >0)
        }
        assert(k is Result.Success)
    }
    @Before
    fun setUp() {
        fakeProductsRepositoryImpl = FakeProductsRepositoryImpl()
        getProductListUsecase = GetProductListUsecase(fakeProductsRepositoryImpl)
    }
}