package com.joaquimverges.twitter4k

import com.joaquimverges.twitter4k.models.Tweet
import com.joaquimverges.twitter4k.models.TwitterResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.Url
import kotlinx.serialization.json.Json

class Api(
    private val bearerToken: String
) {

    private var baseUrl = "https://api.twitter.com/2"
    private var recentSearchEndpoint = Url("$baseUrl/tweets/search/recent")

    private val client = HttpClient {
        defaultRequest {
            header("Authorization", "Bearer $bearerToken")
            header("Content-type", "application/json")
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun recentSearch(query: String): List<Tweet> {
        val response: TwitterResponse<Tweet> = client.get("$recentSearchEndpoint?query=$query")
        return response.data
    }
}