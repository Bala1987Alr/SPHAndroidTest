package com.bala.sphandroidtest.models

import com.google.gson.annotations.SerializedName

open class Resources
{

    @SerializedName("success")
    var success : String = ""
    @SerializedName("result")
    lateinit var result : Result

}
open class Result
{
    @SerializedName("records")
    lateinit var records: List<Records>
}

 open class Records
{
    @SerializedName("volume_of_mobile_data")
    var volume_of_mobile_data : String = ""

    @SerializedName("quarter")
    var quarter: String = ""

    @SerializedName("_id")
    var _id : Int = 0

}