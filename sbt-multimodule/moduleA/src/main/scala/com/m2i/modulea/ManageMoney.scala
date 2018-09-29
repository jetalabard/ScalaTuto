package com.m2i.modulea

class ManageMoney {

  def addMoneys(m1 :Money , m2: Money):Money = {
    var newMoney = Money(0,m1.currency)
    if(m1.currency == m2.currency)
    {
      newMoney=  Money(m1.value + m2.value,m1.currency)
    }
    else
    {
      newMoney = Money(0,"error")
    }
    newMoney

  }

  def sum(list :List[Money] , currency: String):Money = {

    list
      .filter(m => m.currency == currency)
      .reduce((m1: Money, m2: Money) => addMoneys(m1,m2))


  }

  def sumMoneysByCurrency(list :List[Money]):List[Money]= {

    list
      .groupBy(m => m.currency)
      .map { case (currency, listMoneys) => sum(listMoneys,listMoneys.head.currency) }
      .toList

  }
}
