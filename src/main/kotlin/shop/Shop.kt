package org.example.shop

import org.example.model.Phone
import org.example.enums.PhoneModel
import org.example.enums.Sitys

interface Shop {
    var listPurchasedPhones: MutableMap<Sitys, Phone> //список содержит проданные телефоны
    var listPhones: MutableMap<Sitys, Phone> //список содержит телефоны в ассортименте магазина
    fun buyingPhone(model: PhoneModel, sity: Sitys) //вункция покупки телефона
    fun getPurchasedPhones() //функция выводит статистику по проданным телефонам

}