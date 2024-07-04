package com.example.ecommerce.data.repository.products

import com.example.ecommerce.api.Result
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.google.gson.Gson

class FakeProductsRepositoryImpl : ProductsRepository {
    override suspend fun getProducts(): Result<ProductListResponseDomain?> {
        return Result.Success(Gson().fromJson(productsRes, ProductListResponseDomain::class.java))
    }
}

val productsRes = "[\n" +
        "  {\n" +
        "    \"product_id\": 1,\n" +
        "    \"name\": \"Smartphone\",\n" +
        "    \"description\": \"High-end smartphone with advanced features.\",\n" +
        "    \"price\": 599.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/smartphone.jpg\",\n" +
        "    \"discount\": 10,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"BrandX\",\n" +
        "    \"category\": \"Electronics\",\n" +
        "    \"rating\": 4.5,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 1,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Great phone with a superb camera!\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 2,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"Good performance, but the battery life could be better.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 2,\n" +
        "    \"name\": \"Laptop\",\n" +
        "    \"description\": \"Powerful laptop for work and gaming.\",\n" +
        "    \"price\": 999.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/laptop.jpg\",\n" +
        "    \"discount\": 5,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"BrandY\",\n" +
        "    \"category\": \"Electronics\",\n" +
        "    \"rating\": 4.7,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 3,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Excellent laptop for gaming and work tasks.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 4,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"Good value for the price.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 3,\n" +
        "    \"name\": \"Wireless Headphones\",\n" +
        "    \"description\": \"Premium wireless headphones with noise-cancellation.\",\n" +
        "    \"price\": 149.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/headphones.jpg\",\n" +
        "    \"discount\": 15,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"SoundMasters\",\n" +
        "    \"category\": \"Electronics\",\n" +
        "    \"rating\": 4.8,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 5,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Top-notch sound quality and comfort.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 6,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"Impressive noise-cancellation, but a bit pricey.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 4,\n" +
        "    \"name\": \"Smartwatch\",\n" +
        "    \"description\": \"Feature-packed smartwatch with fitness tracking.\",\n" +
        "    \"price\": 199.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/smartwatch.jpg\",\n" +
        "    \"discount\": 10,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"TechWear\",\n" +
        "    \"category\": \"Wearables\",\n" +
        "    \"rating\": 4.6,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 7,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"Great value for the features it offers.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 8,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Sleek design and accurate fitness tracking.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 5,\n" +
        "    \"name\": \"Professional DSLR Camera\",\n" +
        "    \"description\": \"High-quality DSLR camera for photography enthusiasts.\",\n" +
        "    \"price\": 499.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/camera.jpg\",\n" +
        "    \"discount\": 5,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"PhotoPro\",\n" +
        "    \"category\": \"Cameras\",\n" +
        "    \"rating\": 4.9,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 9,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Exceptional image quality and versatility.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 10,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"A bit heavy, but the results are worth it.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 6,\n" +
        "    \"name\": \"Smart TV\",\n" +
        "    \"description\": \"High-definition smart TV with built-in streaming apps.\",\n" +
        "    \"price\": 799.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/tv.jpg\",\n" +
        "    \"discount\": 8,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"ViewTech\",\n" +
        "    \"category\": \"Electronics\",\n" +
        "    \"rating\": 4.7,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 11,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Stunning picture quality and user-friendly interface.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 12,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"A great addition to our home entertainment setup.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 7,\n" +
        "    \"name\": \"Tablet\",\n" +
        "    \"description\": \"Compact tablet for productivity and entertainment.\",\n" +
        "    \"price\": 299.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/tablet.jpg\",\n" +
        "    \"discount\": 12,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"TabTech\",\n" +
        "    \"category\": \"Electronics\",\n" +
        "    \"rating\": 4.4,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 13,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"Good value for the price, but the battery life could be better.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 14,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Ideal for both work and entertainment on the go.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 8,\n" +
        "    \"name\": \"Gaming Console\",\n" +
        "    \"description\": \"Next-gen gaming console for immersive gaming experiences.\",\n" +
        "    \"price\": 399.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/console.jpg\",\n" +
        "    \"discount\": 10,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"GameX\",\n" +
        "    \"category\": \"Gaming\",\n" +
        "    \"rating\": 4.8,\n" +
        "    \"reviews\": [\n" +
        "      {\n" +
        "        \"user_id\": 15,\n" +
        "        \"rating\": 5,\n" +
        "        \"comment\": \"Incredible gaming performance and graphics.\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"user_id\": 16,\n" +
        "        \"rating\": 4,\n" +
        "        \"comment\": \"A must-have for gaming enthusiasts.\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"product_id\": 9,\n" +
        "    \"name\": \"Energy-Efficient Refrigerator\",\n" +
        "    \"description\": \"Modern refrigerator with energy-saving features.\",\n" +
        "    \"price\": 599.99,\n" +
        "    \"unit\": \"Piece\",\n" +
        "    \"image\": \"https://example.com/images/refrigerator.jpg\",\n" +
        "    \"discount\": 5,\n" +
        "    \"availability\": true,\n" +
        "    \"brand\": \"CoolTech\",\n" +
        "    \"category\": \"Appliances\",\n" +
        "    \"rating\": 4.6\n" +
        "  } \n" +
        "]"
