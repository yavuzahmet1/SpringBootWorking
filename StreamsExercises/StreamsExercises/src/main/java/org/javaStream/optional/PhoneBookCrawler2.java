package org.javaStream.optional;

//Qu:Implement findPhoneNumberByNameAndPrintPhoneBookIfNothingFound in PhoneBookCrawler that uses the implementation from
public class PhoneBookCrawler2 {
    private PhoneBook phoneBook;

    public PhoneBookCrawler2(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return null;
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        StringBuilder result=new StringBuilder();
         phoneBook.findPhoneNumberByName(name)
                 .ifPresentOrElse(phoneNumber->result.append(phoneNumber)
                         ,()-> System.out.println(phoneBook.getPhoneBookEntries()));
        return result.toString();
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){
        return null;
    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }
}
