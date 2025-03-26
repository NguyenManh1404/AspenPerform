package com.example.aspenperform.data.repository

import com.apollographql.apollo.api.ApolloResponse
import com.example.aspenperform.CountriesQuery
import com.example.aspenperform.data.sources.remote.services.CountryAPIService

class CountriesRepository(private val countryAPIService: CountryAPIService) {
    suspend fun getAllCountries(): ApolloResponse<CountriesQuery.Data> =
        countryAPIService.getAllCountries()

    suspend fun getCountryDetail(code: String) {
        countryAPIService.getCountryDetail(code)
    }
}
