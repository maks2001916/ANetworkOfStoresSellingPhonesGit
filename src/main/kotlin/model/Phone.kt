package org.example.model

import org.example.enums.PhoneModel
import org.example.enums.Sitys

data class Phone(
    var model: PhoneModel,
    var price: String,
    var quality: Int,
    var sity: Sitys,
    var renovated: Boolean
) {}