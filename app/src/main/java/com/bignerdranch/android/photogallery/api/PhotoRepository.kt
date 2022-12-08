package com.bignerdranch.android.photogallery.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {
    private val flickrApi: FlickrApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pi.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flickrApi = retrofit.create()
    }
    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems
}