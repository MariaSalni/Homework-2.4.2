package ru.netology.stats;

public class StatsService {
    //1. Расчет суммы всех продаж
    public long sumSales(long[] sales) {
        long sum = 0;
        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    //2. Расчет средней суммы продаж
    public long calculateAverage(long[] sales) {
        long sum = sumSales(sales);
        return sum / sales.length;
    }

    // 3. Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[maxMonth] - продажи в месяце maxMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;


    }

    // 4. Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    // 5. Кол-во месяцев, в которых продажи были ниже среднего
    public int minThenAverageSales(long[] sales) {
        int numberOfMonth = 0;
        double averageSale = calculateAverage (sales);
        for (long sale : sales) {
            if (sale <= averageSale) {
                numberOfMonth = numberOfMonth + 1;
            }

        }
        return numberOfMonth;
    }

    // 6. Кол-во месяцев, в которых продажи были выше среднего
    public int maxThenAverageSales(long[] sales) {
        int numberOfMonth = 0;
        double averageSale = calculateAverage (sales);
        for (long sale : sales) {
            if (sale >= averageSale) {
                numberOfMonth = numberOfMonth + 1;
            }

        }
        return numberOfMonth;
    }
}
