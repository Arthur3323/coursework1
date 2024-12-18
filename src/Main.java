import java.util.Random;

public class Main {
    public static void main(String[] args) {
        initEmployees();
        printStaff();
        System.out.println("Сумма ЗП всех сотрудников: " + sumSalary());
        System.out.println("Минимальная ЗП у сотрудника: " + minSalary());
        System.out.println("Максимальая ЗП у сотрудника: " + maxSalary());
        System.out.println("Средняя ЗП всех сотрудников: " + averageSalary());
        printFullName();
        indexSalary();
    }

    private final static Random RANDOM = new Random();

    private final static String[] NAMES = {"Иван", "Петр", "Евгений", "Роман", "Елизавета", "Мария", "Алина", "Алексей", "Анастасия", "Артур"};
    private final static String[] SURNAMES = {"Васейко", "Коротенко", "Старовойт", "Маркес", "Моралес", "Мельник", "Ющенко", "Тимошенко", "Шевченко", "Долгих"};
    private final static String[] PATRONYMIC = {"Антонович(-вна)", "Сергеевич(-вна)", "Алексеевич(-вна)", "Александрович(-вна)", "Евгеньевич(-вна)", "Витальевич(-вна)", "Рагимович(-вна)", "Юрьевич(-вна)", "Эдуардович(-вна)", "Майхлович(-вна)"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " + NAMES[RANDOM.nextInt(0, NAMES.length)] + " " + PATRONYMIC[RANDOM.nextInt(0, PATRONYMIC.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 100001));
        }
    }

    private static void printStaff() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int sumSalary() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee minSalary() {
        Employee nameMin = EMPLOYEES[0];
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < nameMin.getSalary()) {
                nameMin = employee;
            }
        }
        return nameMin;
    }

    private static Employee maxSalary() {
        Employee nameMax = EMPLOYEES[0];
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() > nameMax.getSalary()) {
                nameMax = employee;
            }
        }
        return nameMax;
    }

    private static double averageSalary() {
        return (double) sumSalary() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

    private static void indexSalary() {
        double percent = 10;
        double index = percent / 100;
        for (Employee employee : EMPLOYEES) {
            double changedSalary = employee.getSalary() + employee.getSalary() * index;
            employee.setSalary((int) changedSalary);
            System.out.println(employee);
        }
    }

}


