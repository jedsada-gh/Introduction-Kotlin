sealed class UserResult
data class Success(val users: List<User>) : UserResult()
data class Failure(val message: String) : UserResult()

fun retrieveUsers(): UserResult {
    return Success(usersFromJSONFile("user.json"))
}

fun retrieveUsersFailure(): UserResult {
    return Failure("error")
}

fun main(args: Array<String>) {

    val value = generateSequence(1) {
        it * 10
    }

    value.take(10).forEach { println(it) }

    val users = usersFromJSONFile("user.json").asSequence()
    users.forEach { println(it.username) }

    users.take(users.count()).forEach { println(it.id + 1) }

    users.map { user -> user.email.replace(user.email, "test@test.test") }
            .forEach { println(it) }

    val result = retrieveUsers()
    when (result) {
        is Success -> result.users.forEach({ println(it.email) })
        is Failure -> print(result.message)
    }
}