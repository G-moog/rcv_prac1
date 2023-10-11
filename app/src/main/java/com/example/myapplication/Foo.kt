package com.example.myapplication

/*data class Foo(
    val id: Int,
    val name: String,
    val phone: String,
) {
    // 더미
    companion object {
        fun createSamples(page : Int) = mutableListOf<Foo>().apply {
            for (i in 1 until 10) {
                val number = page * 10
                add(Foo(number +i, "이름 ${number + i}", "01000000000"))
            }
        }
    }
}*/



data class Foo(
    val folderName: String,
    val imageUrl: Any

) {

    companion object {
        fun createSamples(folderNameList: MutableList<String>, imageUriList: MutableList<Any>) = mutableListOf<Foo>().apply {
            for (i in folderNameList) {

                add(Foo(folderNameList[i],imageUriList[i]))
            }
        }
    }
}