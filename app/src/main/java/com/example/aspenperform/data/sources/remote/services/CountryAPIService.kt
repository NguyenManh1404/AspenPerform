package com.example.aspenperform.data.sources.remote.services
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloResponse
import com.example.aspenperform.CountriesQuery

class CountryAPIService(private val graphQLService: ApolloClient) {

    suspend fun getAllCountries(): ApolloResponse<CountriesQuery.Data> =
        graphQLService.query(CountriesQuery()).execute()

    suspend fun getCountryDetail(code: String) {

    }
}
