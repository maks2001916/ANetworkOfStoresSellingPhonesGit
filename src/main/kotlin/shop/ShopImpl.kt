package org.example.shop

import org.example.model.Phone
import org.example.enums.PhoneModel
import org.example.enums.Sitys

class ShopImpl(): Shop {
    override lateinit var listPurchasedPhones: MutableMap<Sitys, Phone>
    override lateinit var listPhones: MutableMap<Sitys, Phone>

    override fun buyingPhone(model: PhoneModel, sity: Sitys) {
        if (listPhones.get(sity)?.model == model &&
            listPhones.get(sity)?.quality!! > 0) {
            // если в городе есть такая модель то уменьшаем количество
            listPhones.get(sity)?.quality = listPhones.get(sity)?.quality!! - 1

            //пополняем список проданных телефонов
            listPurchasedPhones.set(
                sity,
                Phone(
                    listPhones.get(sity)!!.model,
                    listPhones.get(sity)!!.price,
                    1,
                    listPhones.get(sity)!!.sity,
                    listPhones.get(sity)!!.renovated
                )
            )
        }
    }


    override fun getPurchasedPhones() {
        val statistics = mutableMapOf<PhoneModel, MutableMap<Sitys, Int>>()

        for (phone in listPurchasedPhones.values) {
            statistics.getOrPut(phone.model) { mutableMapOf() }
                .merge(phone.sity, 1, Int::plus)
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