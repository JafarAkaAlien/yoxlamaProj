

///////////////////// nullability chatper
fun divideifWhole(value: Int, divisor: Int):Int? {
    var result : Int? = null
     if(value%divisor==0){
         result=value/divisor
     }
    return result

}
lateinit var user: ArrayList<Users>
lateinit var names:ArrayList<String>
lateinit var age:ArrayList<Int>
lateinit var state:ArrayList<Boolean>



fun main() {
    names = arrayListOf("ahmad","Baba","qaqa","Nurlan", "Buni", "Zorzor")
    age = arrayListOf<Int>(12,22,23,21,55,12)
    state = arrayListOf<Boolean>(false,true,true,true,true,true)



    user = arrayListOf<Users>()
    getUserData()
    lateinit var newData:ArrayList<Users>

    var sorter = object :Sorter<Users,Int>{
        override fun sortByGiven(value: Users): Int {
            return value.age
        }

    }


    var answerForBaba = testLis<Users>(user)
//    var k = answerForBaba.sortby(user){ it->
//        it.age
//    }
    var k = answerForBaba.sortWithInterface(user,sorter)
//    var k = answerForBaba.filterBy {it->
//        myFilter(it) }
//
//    val Baba = CompareUsers("Hbaba",21)
//    val Nurlan  = CompareUsers("Nurlan", 20)
//    val Zort = CompareUsers("Zort",10)

    println(k)

}

fun getUserData() {
    for(i in names.indices){
        var yaz = Users(names[i],age[i],state[i])
        user.add(yaz)
    }
}

class homeOwner (var firstname:String, var lastname:String){
    val fullname
        get() ="$firstname $lastname"

}
fun sorting(myItems:ArrayList<Users>) : ArrayList<Users> {
    return myItems
}
fun myFilter(item:Users):Boolean{
    if(item.age>10) return true
    return false

}

fun opera(a:Int, b:Int, fn:(Int,Int)->Int){
    println( fn(a,b))
}
fun topla(a:Int,b:Int):Int{
    return a+b
}
