package JavaModule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FilteredSortedList {

    // Перевіряє критерії:
    // 1) не менше 4 цифр у записі числа
    // 2) серед цифр немає 0, 4 і 9
    static boolean isValid(int n) {
        String s = Integer.toString(n);
        if (s.length() < 4) return false;
        for (char c : s.toCharArray()) {
            if (c == '0' || c == '4' || c == '9') return false;
        }
        return true;
    }

    // Повертає перші дві цифри числа як ціле (11-11, 5678-56)
    static int firstTwoDigits(int n) {
        String s = Integer.toString(n);
        return Integer.parseInt(s.substring(0, 2));
    }

    public static void main(String[] args) {
        final int SIZE = 12;
        List<Integer> list = new ArrayList<>();
        Random random = new Random(7);

        // Заповнюємо список валідними числами (4-5 цифр)
        while (list.size() < SIZE) {
            int candidate = 1000 + random.nextInt(89000); // [1000, 89999]
            if (isValid(candidate)) {
                list.add(candidate);
            }
        }

        System.out.println("Список до сортування (" + SIZE + " елементів):");
        list.forEach(n -> System.out.printf("  %5d%n", n));

        // Компаратор-об'єкт: порівнює лише перші дві цифри числа
        Comparator<Integer> firstTwoComparator =
            Comparator.comparingInt(FilteredSortedList::firstTwoDigits);

        list.sort(firstTwoComparator);

        System.out.println("\nСписок після сортування (за першими двома цифрами зліва):");
        System.out.printf("  %-10s %s%n", "Число", "Перші дві цифри");
        System.out.println("  " + "-".repeat(28));
        list.forEach(n -> System.out.printf("  %-10d %d%n", n, firstTwoDigits(n)));
    }
}
