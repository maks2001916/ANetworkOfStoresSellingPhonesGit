package org.example

interface Shop {
    var listPurchasedPhones: List<Phone> //список содержит проданные телефоны
    var listPhones: List<Phone> //список содержит телефоны в ассортименте магазина
    fun buyingPhone() //вункция покупки телефона
    fun getPurchasedPhones() //функция выводит статистику по проданным телефонам

}