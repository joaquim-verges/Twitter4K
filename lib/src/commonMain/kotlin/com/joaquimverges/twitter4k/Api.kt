package com.joaquimverges.twitter4k

import com.joaquimverges.twitter4k.models.Tweet
import com.joaquimverges.twitter4k.models.TwitterResponse
import com.joaquimverges.twitter4k.models.User
import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.URLBuilder
import io.ktor.http.Url
import kotlinx.serialization.json.Json

class Api(
    private val bearerToken: String
) {

    private var baseUrl = "https://api.twitter.com/2"
    private var searchEndpoint = Url("$baseUrl/tweets/search/recent")
    private var userLookupEndpoint = Url("$baseUrl/users")

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

    suspend fun searchTweets(query: String): List<Tweet> {
        return client.get<TwitterResponse<Tweet>>(searchEndpoint) {
            parameter("query", query)
        }.data
    }

    suspend fun lookupUsers(userIds: List<String>): List<User> {
        return client.get<TwitterResponse<User>>(userLookupEndpoint) {
            parameter("ids", userIds.joinToString(","))
        }.data
    }
}