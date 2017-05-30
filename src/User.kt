import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileReader

data class User(val id: Int, val username: String, val email: String)

fun usersFromJSONFile(filename: String): List<User> {
    val gson = Gson()
    return gson.fromJson(FileReader(filename), object : TypeToken<List<User>>() {}.type)
}