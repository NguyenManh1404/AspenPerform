package com.example.aspenperform.data.sources.remote.services

import com.apollographql.apollo.ApolloClient


class  ApolloClient {
    val client: ApolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com/")
        .build()
}
