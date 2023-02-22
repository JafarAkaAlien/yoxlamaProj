data class Grade(
    val letter : Char,
    val points: Double,
    val credits: Double
)

class Person(var firstname: String, var lastname:String){
    fun fullName() = "$firstname $lastname"
}

open class Student(var firstname: String, var lastname: String,
                   var grades:MutableList<Grade> = mutableListOf<Grade>())
{
    open fun recordGrade(grade: Grade){
        grades.add(grade)
    }
}
class AtletStudent(
    firstname: String,
    lastname: String
):Student(firstname,lastname){
    val failedClasses = mutableListOf<Grade>()
    override fun recordGrade(grade: Grade){

        super.recordGrade(grade)
        if(grade.letter == 'F'){
            failedClasses.add(grade)
        }
    }
}

//////////////////////////////////////generics


class Mover<T>(
    thingstomove : List<T>, val truckHeight : Int = (12*12)
)
{
    private var thinghLeftIntheOldPlace = mutableListOf<T>()
    private var thingsinTruck = mutableListOf<T>()
    private var thingsInNewPlace = mutableListOf<T>()


    init{
        thinghLeftIntheOldPlace.addAll(thingstomove)
    }

    fun moveEverythingToTruck(){
        while(thinghLeftIntheOldPlace.count()>0){
            val item = thinghLeftIntheOldPlace.removeAt(0)
            thingsinTruck.add(item)
            println("Moved your $item to the truck!")
        }
    }

    fun moveEverythingtoNewPlace(){
        while (thingsinTruck.count()>0) {
            val item = thingsinTruck.removeAt(0)
            thingsInNewPlace.add(item)
            println("Moved your $item to new place!")
        }
    }

    fun finishMove() {
        println("OK, we finished! We were able to move your:${thingsInNewPlace}")
    }


}