package org.example

import org.example.enums.PhoneModel
import org.example.enums.Sitys
import org.example.shop.ShopImpl

fun main() {
    var shop = ShopImpl()
    shop.replenishmentWarehouse()

    println("Здравствуйте!")
    var input = ""
    var sity:Sitys = Sitys.MOSKOV
    var model:PhoneModel = PhoneModel.POCO
    var renovate = false
    while (true) {
        println("Выберите город в магазине которого хотите приобрести телефон")
        println("1. ${Sitys.MOSKOV}\n" +
                "2. ${Sitys.ROSTOV_NA_DONU}\n" +
                "3. ${Sitys.SANKT_PITERBURG}\n" +
                "0. Выйти")
        var sityStatus = true
        while (sityStatus) {
            var checkInput = readln()
            if (!checkInput.isEmpty() &&
                checkInput.all { it.isDigit()} &&
                checkInput.toIntOrNull()!! <= 3) {
                input = checkInput
                sityStatus = false
            } else {
                println("Выберите город")
            }
        }
        if (input == "0") {
            return
        }
        when (input.toInt()) {
            1 -> sity = Sitys.MOSKOV
            2 -> sity = Sitys.ROSTOV_NA_DONU
            3 -> sity = Sitys.SANKT_PITERBURG
        }
        println("Выберите модель телефона")
        println("1. ${PhoneModel.POCO}\n" +
                "2. ${PhoneModel.REDMI}\n" +
                "3. ${PhoneModel.HUAWEI}\n" +
                "4. ${PhoneModel.IPHONE}\n" +
                "5. ${PhoneModel.SAMSUNG}\n" +
                "0. Статистика продаж")
        var modelStatus = true
        while (modelStatus) {
            var checkModel = readln()
            if (!checkModel.isEmpty() &&
                checkModel.all { it.isDigit()} &&
                checkModel.toIntOrNull()!! <= 5) {
                input = checkModel
                modelStatus = false
            } else {
                println("Выберите модель")
            }
        }
        when (input.toInt()) {
            1 -> model = PhoneModel.POCO
            2 -> model = PhoneModel.REDMI
            3 -> model = PhoneModel.HUAWEI
            4 -> model = PhoneModel.IPHONE
            5 -> model = PhoneModel.SAMSUNG
            0 -> shop.getPurchasedPhones()
        }
        if (sity == Sitys.MOSKOV) {
            println("Хотите отремонтировать телефон?")
            println("1. да\n2. нет")
            var renovateStatus = true
            while (renovateStatus) {
                var checkRenovate = readln()
                if (!checkRenovate.isEmpty()) {
                    input = checkRenovate
                    renovateStatus = false
                } else {
                    println("Выберите действие")
                }
            }
            when (input.toInt()) {
                1 -> {
                    renovate = true
                    println("Телефон отремонтирован")
                }
                2 -> renovate = false
            }
        }
        shop.buyingPhone(model, sity)
        println("Телефон $model куплен в магазине города $sity ")
    }
}

