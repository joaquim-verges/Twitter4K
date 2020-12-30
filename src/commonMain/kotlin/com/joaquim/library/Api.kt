package com.joaquim.library

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json


// 'https://api.twitter.com/2/tweets/search/recent?query=nyc&tweet.fields=author_id,created_at,entities,geo,in_reply_to_user_id,lang,possibly_sensitive,referenced_tweets,source'

class Api {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}