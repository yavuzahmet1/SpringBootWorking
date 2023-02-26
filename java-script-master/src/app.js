console.log("Merhaba kodlama.io")

let dolarDun=9.20
dolarDun="Ankara"
let dolarBugun=9.30
{
    let dolarDun=9.05
}

//console.log(dolarDun)

const euroDun=11.22
//euroDun=11

//console.log(euroDun)


//array
let konutKredileri=["Konut Kredisi","Emlak Konut Kredisi","Kamu Konut Kredisi","Deprem Kredisi"]
//console.log(konutKredileri)

for (let index = 0; index < konutKredileri.length; index++) {
    //console.log("konut kredileri "+ konutKredileri[index])
    
}

let showProducts=function(id,...products){
    console.log(id)
    console.log(products)
    console.log(products[2])
}

//console.log(typeof showProducts)
// showProducts()
// showProducts(10,"Elma","Armut","Kivi")
// showProducts(10,"Elma",10,"Armut","Kivi",10)
// showProducts(10,"Elma",10,["Armut","Kivi",10])
// showProducts(10,["Elma",10,"Armut","Kivi",10])
// showProducts()

console.log(Math.max(20,22,41,1))
console.log(Math.max([20,22,41,1]))

//spread->ayrıştırmak parametre gibi ayırmaya yarıyor
let points=[20,11,34,54]
console.log(...points) // 20 11 34 54
console.log(points)// [20, 11, 34, 54] array olarak gönderir

console.log("ABC","D","EFG","H") //ABC D EFG H
console.log(..."ABC","D",..."EFG","H")//A B C D E F G H elimizdeki veriyi ayşıştırıyoruz

//Destructuring->react dünyasında çok kullanılır
//Elimizde arraylar var bunları değişkenlere aktarır

let populations=[1000,2000,3000,[7000,9000]]
let [small,medium,large,veryLarge,maximum]=populations

console.log(small)
console.log(medium)
console.log(large)
console.log(veryLarge)
console.log(maximum)//->atanacak değer yok undefined

function someFunction([small1],number){
console.log(small1)
}

someFunction(populations)

let category={id:1,name:"drink"}
console.log(category.id)
console.log(category.name)
console.log(category["name"])

let{id,name}=category
console.log(id)
console.log(name)
