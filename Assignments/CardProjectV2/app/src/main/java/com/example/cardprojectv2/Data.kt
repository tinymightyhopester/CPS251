package com.example.cardprojectv2

import java.util.*

class Data {

    fun getTitles(): Array<String> {
        return titles.copyOf()
    }
    fun getDetails(): Array<String> {
        return details.copyOf()
    }
    fun getImages(): IntArray {
        return images.copyOf()
    }

    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    private val images = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)


}