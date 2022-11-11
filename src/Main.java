import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    /**
     * 1. Создать коллекцию класса ArrayList наполнить ее рандомными элементами типа Integer.
     * С помощью Stream'ов:
     * - Удалить дубликаты
     * - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
     * - Каждый элемент умножить на 2
     * - Отсортировать и вывести на экран первых 4 элемента
     * - Вывести количество элементов в стриме
     * - Вывести среднее арифметическое всех чисел в стриме
     */
    private static void task1() {
        System.out.println("__________ Task 1 __________");

        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 15) {
            randomList.add(new Random().nextInt(20));
        }
        System.out.println("ArrayList pандомных элементов типа Integer: \n" + randomList);

        System.out.println("\nУдалить дубликаты; вывести все четные элементы в диапазоне от 7 до 17 (включительно):");
        randomList.stream()
                .distinct()
                .filter(getPredicate())
                .forEach(i -> System.out.print(i + " "));

        System.out.println("\n\nКаждый элемент умножить на 2; отсортировать и вывести первых 4 элемента:");
        randomList.stream()
                .map(i -> i * 2)
                .sorted()
                .limit(4)
                .forEach(i -> System.out.print(i + " "));

        long count = randomList.stream().count();
        System.out.println("\n\nВывести количество элементов в стриме: \n" + count);

        randomList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(x -> System.out.println("\nВывести среднее арифметическое всех чисел в стриме:\n" + x));
    }

    private static Predicate<? super Integer> getPredicate() {
        return (i -> i % 2 == 0 && i >= 7 && i <= 17);
    }

    /**
     * 2. Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
     * С помощью Stream'ов:
     * - Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
     * - Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
     */
    private static void task2() {
        System.out.println("\n__________ Task 2 __________");

        List<String> names = List.of("Валерия", "Денис", "Глеб", "Ольга", "Роман", "Ольга", "Даниил",
                "Александр", "Елизавета", "Святослав", "Яна", "Мария", "Дмитрий", "Ирина", "Александр", "Даниил", "Юлия");

        String myName = "Ольга";
        long count = names.stream()
                          .filter(s -> s.equalsIgnoreCase(myName))
                          .count();
        System.out.println("Количество людей с именем " + myName + " (вне зависимости от регистра):\n" + count);

        System.out.println("\nВсе имена, начинающиеся на 'а' (вне зависимости от регистра):");
        names.stream()
                .filter(s -> s.regionMatches(true, 0, "а", 0, 1))
                .forEach(System.out::println);
    }
}