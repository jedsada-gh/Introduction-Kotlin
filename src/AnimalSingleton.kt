class BaseApi {

    interface CallBackApi<in T> {
        fun onSuccess(t: T?)
        fun onError(message: String)
    }

    companion object {
        fun <T> requestApi(path: String, callBackApi: CallBackApi<T>) {
            val t: T? = null
            callBackApi.onSuccess(t)
        }
    }
}

class UserInfoModel {
    var fistNmae: String? = null
    var lastNmae: String? = null
}

fun main(args: Array<String>) {
    BaseApi.requestApi("path", object : BaseApi.CallBackApi<String> {
        override fun onSuccess(t: String?) {

        }

        override fun onError(message: String) {

        }
    })


//    val a1 = AnimalSingleton.instance
//    println(a1.number)
//
//    val a2 = AnimalSingleton.instance
//    println(a2.number)

//    val n = Normal()
//    n.number = 5
//
//    val n1 = Normal()
//    println(n1.number)
}

class Normal {
    var number: Int? = 0
}