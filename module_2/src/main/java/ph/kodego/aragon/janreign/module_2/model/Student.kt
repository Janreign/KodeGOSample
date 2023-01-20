package ph.kodego.aragon.janreign.module_2.model

import ph.kodego.aragon.janreign.module_2.R

class Student (var firstName:String = "Unknown", var lastName:String = "Unknown", var img:Int){

    var id: Int = 0
    constructor(): this("", "", R.drawable.placeholder){}
}