package ru.netology

fun main() {
    // Пример использования функции agoToText
    val lastVisitSeconds0 = 40
    val lastVisitSeconds1 = 61
    val lastVisitSeconds2 = 400
    val lastVisitSeconds3 = 40000
    val lastVisitSeconds4 = 100000
    agoToText(lastVisitSeconds0)
    agoToText(lastVisitSeconds1)
    agoToText(lastVisitSeconds2)
    agoToText(lastVisitSeconds3)
    agoToText(lastVisitSeconds4)
}

// Функция, которая принимает количество секунд и возвращает правильное склонение слова "минута"
fun getMinutesText(minutes: Int): String {
    return when (minutes) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}

// Функция, которая принимает количество секунд и возвращает правильное склонение слова "час"
fun getHoursText(hours: Int): String {
    return when (hours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

// Функция, которая принимает количество секунд с момента последнего визита пользователя и выводит информацию в консоль
fun agoToText(seconds: Int) {
    when {
        seconds in 0..60 -> println("был(а) только что")
        seconds in 61..60 * 60 -> {
            val minutes = seconds / 60
            val minutesText = getMinutesText(minutes)
            println("был(а) $minutes $minutesText назад")
        }

        seconds in (60 * 60) + 1..24 * 60 * 60 -> {
            val hours = seconds / (60 * 60)
            val hoursText = getHoursText(hours)
            println("был(а) $hours $hoursText назад")
        }

        seconds in 24 * 60 * 60 + 1 until 48 * 60 * 60 -> println("был(а) вчера")
        seconds in 48 * 60 * 60 + 1 until 72 * 60 * 60 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

