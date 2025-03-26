package com.example.aspenperform.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aspenperform.CountriesQuery
import com.example.aspenperform.databinding.ItemCountryBinding

class CountryAdapter(private val countries: MutableList<CountriesQuery.Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    fun updateData(newCountries: List<CountriesQuery.Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged() // Có thể thay thế bằng `notifyItemRangeChanged` để tối ưu hơn
    }

    class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: CountriesQuery.Country) {
            binding.apply {
                countryName.text = country.name
                countryEmoji.text = country.emoji
                countryNative.text = country.native ?: "N/A"
                capital.text = country.capital ?: "N/A"
                languagesCode.text = country.languages.joinToString { it.code ?: "N/A" }
                languagesName.text = country.languages.joinToString { it.name ?: "N/A" }
                currency.text = country.currency ?: "N/A"
            }
        }
    }
}
