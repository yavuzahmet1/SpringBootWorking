class Customer{
    constructor(id,customerNumber){
        this.id=id
        this.customerNumber=customerNumber
    }
}

let customer=new Customer(1,"123555");

//prototyping 
customer.name="Ahmet YAVUZ"
console.log(customer.name)
Customer.bisey="Bisey"

console.log(Customer.bisey)//Bisey->instance'ye yapılan prototyping

console.log(customer.bisey)//undefined->class'a yapılan prototyping

console.log(customer.customerNumber)
console.log(customer.id)

class IndividualCustomer extends Customer{
    constructor(firstName,id,customerNumber){
    super(id,customerNumber)
    this.firstName=firstName
    }
}

class CorporateCustomer extends Customer{
    constructor(companyName,id,customerNumber){
    super(id,customerNumber)
    this.companyName=companyName
    }
}