import java.math.BigDecimal

data class Money(val amount: BigDecimal, val currency: String)

private val Int.bd: BigDecimal get() = BigDecimal(this)

fun sendPayment(money: Money, message: String = "default") {
    println("Sending ${money.amount}" + "\t" + message)
}

fun plus(x: Int, y: Int) = x + y

fun convertToDollars(money: Money): Money = when (money.currency) {
    "$" -> money
    "EUR" -> Money(money.amount * BigDecimal(1.1), "$")
    else -> throw IllegalArgumentException("not the currency you're interested in!")
}

fun BigDecimal.percent(percentage: Int): BigDecimal =
        multiply(java.math.BigDecimal(percentage)).divide(BigDecimal(1000))

infix fun Int.percentOf(money: Money): BigDecimal =
        money.amount.multiply(BigDecimal(this)).divide(BigDecimal(100))

operator fun Money.plus(money: Money) =
        if (money.currency == currency) {
            Money(amount + money.amount, currency)
        } else {
            throw IllegalArgumentException("We're gonna have a problem here!")
        }

operator fun Money.minus(money: Money) =
        if (money.currency == currency) {
            Money(amount - money.amount, currency)
        } else {
            throw IllegalArgumentException("We're gonna have a problem here!")
        }

var email20scoop = fun(users: User): Boolean {
    return users.email.endsWith("20scoop.com")
}

val addStrTest = fun(user: User): User {
    return User(user.id, user.username + "test", user.email)
}

fun main(args: Array<String>) {

    val tickets = Money(10.bd, "$")
    val popcorn = tickets.copy(500.bd, "EUR")
    val apple = tickets.copy(500.bd, "$")

    if (tickets != popcorn) println("They are different")

    sendPayment(message = "POND", money = popcorn)

    sendPayment(money = popcorn)

    println(plus(50, 50).toString())

    println(String.format("%.2f", convertToDollars(popcorn).amount))

    println(BigDecimal(100).percent(7))

    println("${7 percentOf popcorn}")

    val pair = 7 to popcorn

    println("$pair")

    val costs = tickets + apple
    println("${costs.amount}")

    val costsMinus = tickets - apple
    println("${costsMinus.amount}")

    val train: Money = Money(amount = 100.bd, currency = "$")
    println("$train")

    val user = usersFromJSONFile("user.json")

    val userScoop = user.filter { it.email.endsWith("@20scoops.com") }
            .sortedBy { it.id }
            .map { it.email to it.username }
    println("$userScoop")

    val (_, _, email) = user.filter { it.email.endsWith("@20scoops.com") }
            .sortedBy { it.id }.first()
    println(email)

    user.filter(email20scoop).forEach { println(it.email) }
    user.filterNot(email20scoop)
            .map(addStrTest)
            .forEach { println(it.username) }
}