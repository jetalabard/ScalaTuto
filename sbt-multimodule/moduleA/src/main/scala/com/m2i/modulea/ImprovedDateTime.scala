package com.m2i.modulea

import org.joda.time.DateTime

object ImprovedDateTime
{

  implicit class ImprovedDateTime(date : DateTime){

    def isBetween(dateTime1: DateTime,dateTime2: DateTime) : Boolean =
    {
        var between: Boolean = false
        if(dateTime1.isBefore(dateTime2) && dateTime2.isAfter(dateTime1)){
          between = true;
        }
        between
    }
  }



}
