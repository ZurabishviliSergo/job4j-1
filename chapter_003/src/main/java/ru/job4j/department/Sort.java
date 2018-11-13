package ru.job4j.department;

import java.util.*;

/**
 * В организации было решено ввести справочник подразделений. Коды подразделений представлены в виде массива строк вида:
 *
 * “K1\SK1”
 *
 * “K1\SK2”
 *
 * “K1\SK1\SSK1”
 *
 * “K1\SK1\SSK2”
 *
 * “K2”
 *
 * “K2\SK1\SSK1”
 *
 * “K2\SK1\SSK2”
 *
 * , где каждая строка имеет следующую структуру: каждая строка включает в себя код данного подразделения,
 * а также все коды подразделений, которые включают в свою структуру данное подразделение
 * (к примеру департамент K1 включает в себя службу SK1, включающую в себя отдел SSK1).
 * Подразделения в одной строке разделены знаком “\”.
 * Возможны случаи, когда в массиве отсутствуют строки с кодом верхнеуровнего подразделения
 * (в показанном выше массиве есть строки с подразделением K1, но данный код подразделения не представлен отдельной
 * строкой “K1”, аналогичный случай с кодом K2\SK1), в таком случае необходимо добавить строку с кодом данного
 * подразделения и учитывать ее при сортировке.
 *
 * Задача:
 *
 * Реализовать возможность сортировки массива кодов подразделений по возрастанию и убыванию, при которых сохранялась бы
 * иерархическая структура (показано далее в примерах сортировки), т.к. отсортированный массив используется для
 * отображения категорий пользователю. Отсортированный тестовый массив должен иметь вид:
 *
 * Сортировка по возрастанию:
 *
 * “K1”
 *
 * “K1\SK1”
 *
 * “K1\SK1\SSK1”
 *
 * “K1\SK1\SSK2”
 *
 * “K1\SK2”
 *
 * “K2”
 *
 * “K2\SK1”
 *
 * “K2\SK1\SSK1”
 *
 * “K2\SK1\SSK2”
 *
 *
 *
 *
 * Сортировка по убыванию:
 *
 * “K2”
 *
 * “K2\SK1”
 *
 * “K2\SK1\SSK2”
 *
 * “K2\SK1\SSK1”
 *
 * “K1”
 *
 * “K1\SK2”
 *
 * “K1\SK1”
 *
 * “K1\SK1\SSK2”
 *
 * “K1\SK1\SSK1”
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/12/18
 */
public class Sort {
    /**
     * Основной процесс сортировки.
     * Результат собираем в TreeMap<String, TreeSet<String>> так как сможем удобно сортировать коренные отделы
     * по ключам мапа, а затем и подотделы - в Set-е значений.
     * Разбиваем каждый департамент на части по обратному слешу, назначаем ключем коренной департамент, а в
     * качестве значения отсортированное множество его дочерних департаментов.
     * @param departments департаменты для сортировки.
     * @param direction направление сортировки: true - по-возрастанию, false - по-убыванию.
     * @return отсортированные, согласно требованиям, департаменты.
     */
    private String[] startSorting(String[] departments, boolean direction) {
        TreeMap<String, TreeSet<String>> departmentsMap = direction ? new TreeMap<>() : new TreeMap<>(new CompareDescMap());
        for (String department : departments) {
            String[] departmentSplit = department.split("\\\\");
            String newKey = departmentSplit[0];
            departmentsMap.putIfAbsent(newKey,  direction ? new TreeSet<>() : new TreeSet<>(new CompareDescSet()));
            StringBuilder sb = new StringBuilder();
            for (String element : departmentSplit) {
                sb.append(element);
                departmentsMap.get(newKey).add(sb.toString());
                sb.append("\\");
            }
        }
        return mapToArr(departmentsMap);
    }

    /**
     * Метод для внешнего использования сортировки по-возрастанию.
     * @param departments департаменты для сортировки.
     * @return отсортированные, согласно требованиям, департаменты.
     */
    public String[] asc(String[] departments) {
        return startSorting(departments, true);
    }

    /**
     * Метод для внешнего использования сортировки по-убыванию.
     * @param departments департаменты для сортировки.
     * @return отсортированные, согласно требованиям, департаменты.
     */
    public String[] desc(String[] departments) {
        return startSorting(departments, false);
    }

    /**
     * Делаем из сортированного Map результирующий массив.
     * @param departmentsMap отсортированные в Map департаменты.
     * @return отсортированные, согласно требованиям, департаменты.
     */
    private String[] mapToArr(TreeMap<String, TreeSet<String>> departmentsMap) {
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> item : departmentsMap.entrySet()) {
            resultList.addAll(item.getValue());
        }
        return resultList.toArray(new String[0]);
    }

    /**
     * Компаратор для ключей Map.
     */
    private class CompareDescMap implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result = 0;
            if (o1.compareTo(o2) != 0) {
                result = o1.compareTo(o2) * -1;
            }
            return result;
        }
    }

    /**
     * Компаратор для значений Set.
     */
    private class CompareDescSet implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result;
            if (o1.length() != o2.length()) {
                result = o1.length() > o2.length() ? 1 : -1;
            } else {
                result = o1.compareTo(o2) * -1;
            }
            return result;
        }
    }
}
