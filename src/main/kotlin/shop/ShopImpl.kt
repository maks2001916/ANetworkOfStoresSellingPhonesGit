package org.example.shop

import org.example.model.Phone
import org.example.enums.PhoneModel
import org.example.enums.Sitys

class ShopImpl(): Shop {
    override var listPurchasedPhones: MutableMap<Sitys, Phone> = mutableMapOf()
    override var listPhones: MutableMap<Sitys, Phone> = mutableMapOf()

    override fun buyingPhone(model: PhoneModel, sity: Sitys) {
        if (listPhones.get(sity)?.model == model &&
            listPhones.get(sity)?.quality!! > 0) {
            // если в городе есть такая модель то уменьшаем количество
            listPhones.get(sity)?.quality = listPhones.get(sity)?.quality!! - 1

            //пополняем список проданных телефонов
            if (!listPurchasedPhones.contains(sity)) {
                listPurchasedPhones.set(
                    sity,
                    listPhones.get(sity)!!.copy(quality = 1)
                )
                println(listPurchasedPhones.get(sity)?.sity)
            } else {
                val purchasedPhone = listPurchasedPhones[sity]
                if (purchasedPhone != null) {
                    purchasedPhone.quality += 1
                }

            }
        }
    }


    override fun getPurchasedPhones() {
        for ((sity, phone) in listPurchasedPhones) {
            println("город: $sity | модель: $phone")
        }
        val statistics = mutableMapOf<PhoneModel, MutableMap<Sitys, Int>>()

        for ((city, phone) in listPurchasedPhones) {
            statistics.getOrPut(phone.model) { mutableMapOf() }
                .merge(city, phone.quality, Int::plus)
        }

        for ((model, cityStats) in statistics) {
            println("Модель: ${model.name}")
            for ((city, count) in cityStats) {
                println("  Город: $city - Продано: $count")
            }
        }
    }

    fun replenishmentWarehouse() {
        listPhones.set(Sitys.MOSKOV, Phone(PhoneModel.POCO, "20_000", 50, Sitys.MOSKOV, false))
        listPhones.set(Sitys.MOSKOV, Phone(PhoneModel.REDMI, "20_000", 50, Sitys.MOSKOV, false))
        listPhones.set(Sitys.MOSKOV, Phone(PhoneModel.HUAWEI, "40_000", 50, Sitys.MOSKOV, false))
        listPhones.set(Sitys.MOSKOV, Phone(PhoneModel.IPHONE, "60_000", 50, Sitys.MOSKOV, false))
        listPhones.set(Sitys.MOSKOV, Phone(PhoneModel.SAMSUNG, "60_000", 50, Sitys.MOSKOV, false))

        listPhones.set(Sitys.ROSTOV_NA_DONU, Phone(PhoneModel.POCO, "23_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.set(Sitys.ROSTOV_NA_DONU, Phone(PhoneModel.REDMI, "23_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.set(Sitys.ROSTOV_NA_DONU, Phone(PhoneModel.HUAWEI, "45_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.set(Sitys.ROSTOV_NA_DONU, Phone(PhoneModel.IPHONE, "63_000", 50, Sitys.ROSTOV_NA_DONU, false))
        listPhones.set(Sitys.ROSTOV_NA_DONU, Phone(PhoneModel.SAMSUNG, "63_000", 50, Sitys.ROSTOV_NA_DONU, false))

        listPhones.set(Sitys.SANKT_PITERBURG, Phone(PhoneModel.POCO, "18_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.set(Sitys.SANKT_PITERBURG, Phone(PhoneModel.REDMI, "18_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.set(Sitys.SANKT_PITERBURG, Phone(PhoneModel.HUAWEI, "36_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.set(Sitys.SANKT_PITERBURG, Phone(PhoneModel.IPHONE, "58_000", 50, Sitys.SANKT_PITERBURG, false))
        listPhones.set(Sitys.SANKT_PITERBURG, Phone(PhoneModel.SAMSUNG, "58_000", 50, Sitys.SANKT_PITERBURG, false))
    }
}