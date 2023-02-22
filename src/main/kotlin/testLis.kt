
class testLis<T : Any>(var element: List<T>) {


    fun filterBy(fn: (T) -> Boolean): ArrayList<T> {
        var boslist = arrayListOf<T>()
        for (i in element) {
            if (fn(i)) {
                boslist.add(i)
            }
        }
        return boslist
    }

    fun <R : Comparable<R>> sortby(value: ArrayList<T>, funk: (T) -> R): ArrayList<T> {
        for (i in value.indices) {
            for (j in value.indices) {
                if (funk(value[i]) > funk(value[j])) {
                    val temp = value[j]
                    value[j] = value[i]
                    value[i] = temp
                }
            }
        }
        return value
    }

    fun <R:Comparable <R>> sortWithInterface(items:ArrayList<T>, sorter:Sorter<T,R>) :ArrayList<T>{
        for (i in items.indices) {
            for (j in items.indices) {
                if (sorter.sortByGiven(items[i]) > sorter.sortByGiven(items[j])) {
                    val temp = items[j]
                    items[j] = items[i]
                    items[i] = temp
                }
            }
        }
        return items
    }
}
interface Sorter <T,R : Comparable<R>> {
    fun sortByGiven(it:T):R
}


data class  CompareUsers(var name:String, var age:Int):Comparable<CompareUsers>{
    override fun compareTo(other: CompareUsers): Int {
        return this.age-other.age
    }
    fun compareByName(other: CompareUsers):Int{
        return this.name.compareTo(other.name)
    }

}



