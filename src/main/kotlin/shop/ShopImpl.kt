package org.example.shop

import org.example.model.Phone
import org.example.enums.PhoneModel
import org.example.enums.Sitys

class ShopImpl(): Shop {
    override var listPurchasedPhones: MutableList<Phone> = mutableListOf()
    override var listPhones: MutableList<Phone> = mutableListOf()

    override fun buyingPhone(model: PhoneModel, sity: Sitys) {
        val phoneInStock = listPhones.find { it.model == model && it.sity == sity && it.quality > 0 }

        if (phoneInStock != null) {
            // Уменьшаем количество на складе
            phoneInStock.quality -= 1

            // Проверяем, есть ли такая модель в списке проданных
            val purchasedPhone = listPurchasedPhones.find { it.model == model && it.sity == sity }

            if (purchasedPhone == null) {
                // Если такой модели еще нет, добавляем её
                listPurchasedPhones.add(phoneInStock.copy(quality = 1))
            } else {
                // Если модель уже есть, увеличиваем количество
                purchasedPhone.quality += 1
            }
        }
    }

    override fun getPurchasedPhones() {
        for (phone in listPurchasedPhones) {
            println("Город: ${phone.sity} | Модель: ${phone.model} | Продано: ${phone.quality}")
        }

        val statistics = mutableMapOf<PhoneModel, MutableMap<Sitys, Int>>()

        for (phone in listPurchasedPhones) {
            statistics.getOrPut(phone.model) { mutableMapOf() }
                .merge(phone.sity, phone.quality, Int::plus)
        }

        for ((model, cityStats) in statistics) {
            println("Модель: ${model.name}")
            for ((city, count) in cityStats) {
                println("  Город: $city - Продано: $count")
            }
        }
    }

    fun replenishmentWarehouse() {
        listPhones.add(Phone(PhoneModel.POCO, "20_000", 50, Sitys.MOSKOV, false))
        listPhones.add(Phone(PhoneModel.REDMI, "20_000", 50, Sitys.MOSKOV, false))
        listPhones.add(Phone(PhoneModel.HUAWEI, "40_000", 50, Sitys.MOSKOV, false))
        listPhones.add(Phone(PhoneModel.IPHONE, "60_000", 50, Sitys.MOSKOV, false))
        listPhones.add(Phone(PhoneModel.SAMSUNG, "60_000", 50, Sitys.MOSKOV, false))

        listPhones.add(Phone(PhoneModel.POCO, "23_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.add(Phone(PhoneModel.REDMI, "23_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.add(Phone(PhoneModel.HUAWEI, "45_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.add(Phone(PhoneModel.IPHONE, "63_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.add(Phone(PhoneModel.SAMSUNG, "63_000", 50, Sitys.ROSTOV_NA_DONU, false))

        listPhones.add(Phone(PhoneModel.POCO, "18_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.add(Phone(PhoneModel.REDMI, "18_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.add(Phone(PhoneModel.HUAWEI, "36_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.add(Phone(PhoneModel.IPHONE, "58_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.add(Phone(PhoneModel.SAMSUNG, "58_000", 50, Sitys.SANKT_PITERBURG, false))
    }
}