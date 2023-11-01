
fun main() {
    println(calculatePrice(amountTransfer = 100_000))
}

fun calculatePrice(typeCard: String = "VK Pay", amountPreviousTransfers: Int = 0, amountTransfer: Int): String {
    val total = userTypeCard(typeCard) * amountTransfer

    when (typeCard) {
        "Mastercard", "Maestro", "Visa", "Мир" -> if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) return "Превышен лимит"
        "VK Pay" -> if (amountTransfer > 15_000 || amountTransfer + amountPreviousTransfers > 40_000) return "Превышен лимит"
    }

    return when (typeCard) {

        "Mastercard", "Maestro" -> if (amountTransfer < 75_000) "Комиссия составит 0 рублей" else "Комиссия составит ${total + 20} рублей"

        "Visa", "Мир" -> if (total < 35) "Комиссия составит 35 рублей" else "Комиссия составит $total рублей"

        else -> "Комиссия составит $total рублей"
    }
}


fun userTypeCard(typeCard: String) = when (typeCard) {
    "Mastercard", "Maestro" -> 0.006
    "Visa", "Мир" -> 0.0075
    else -> 0.0
}