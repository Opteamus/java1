package lesson05;

public class HomeWorkApp5 {
    public static void main(String[] args) {
        Person[] listOfPerson = new Person[5];
        listOfPerson[0] = new Person("Иванов", "Иван", "Иванович", "Директор", "ii@office.org",
                "+7(925)722-22-22", 80000, 52);
        listOfPerson[1] = new Person("Александрова","Александра","Александровна ", "Секретарь",
                "aa@office.org","+7(925)722-22-25", 45000, 29);
        listOfPerson[2] = new Person("Петров","Петр","Петрович", "Зам. директора", "pp@office.org",
                "+7(925)722-22-23", 80000, 48);
        listOfPerson[3] = new Person("Семенов","Семен","Семенович", "Менеджер", "ss@office.org",
                "+7(925)722-22-24", 80000, 37);
        listOfPerson[4] = new Person("Валентинова","Валентина","Валентиновна", "Главный бухгалтер",
                "vv@office.org","+7(925)722-22-26", 70000, 46);

        printPersonOlderNAgeInfo(20, listOfPerson);
    }
    public static void printPersonOlderNAgeInfo(int n, Person[] arrPerson) {
        System.out.println("Список сотрудников старше " + n + ':');
        for (int i = 0; i < arrPerson.length; i++) {
            if (arrPerson[i].getAge() > n) {
                System.out.println(arrPerson[i].getAllInfo());;
            }
        }
    }
}
