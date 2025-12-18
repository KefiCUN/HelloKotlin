
// Практическое задание: "Система игровых достижений"
// Контекст: Ты создаешь систему учета достижений для игры. Каждое достижение имеет определенные характеристики.

// Задача 1: Создание data-классов
// Создай data-класс Achievement (Достижение):

// id: String (уникальный ID, например: "ach_001")

// title: String (название: "Первый шаг")

// description: String (описание: "Зайти в игру первый раз")

// points: Int (очки за достижение: 10)

// isSecret: Boolean (секретное ли: false)

// Создай data-класс PlayerAchievement (Достижение игрока):

// achievementId: String (ID достижения)

// playerName: String (имя игрока)

// unlockedAt: String (дата получения: "2024-12-16")

// completionTime: Int? (время выполнения в секундах, опционально)

// Задача 2: Работа с достижениями
// В функции main() создай 3-4 разных достижения:

// kotlin
// val firstLogin = Achievement("ach_001", "Первый шаг", "Зайти в игру", 10, false)
// val speedRunner = Achievement("ach_002", "Скоростной", "Пройти уровень за 60 сек", 50, false)
// val secretFind = Achievement("sec_001", "Тайное знание", "Найти секретную комнату", 100, true)
// Создай список достижений игрока "ProGamer":

// kotlin
// val playerAchievements = listOf(
//     PlayerAchievement("ach_001", "ProGamer", "2024-12-15", null),
//     PlayerAchievement("ach_002", "ProGamer", "2024-12-16", 58),
//     PlayerAchievement("sec_001", "ProGamer", "2024-12-16", null)
// )
// Задача 3: Деструктуризация и копирование
// Напиши функцию createHardcoreAchievement(base: Achievement): Achievement, которая:

// Принимает обычное достижение

// Возвращает его "хардкорную" версию с 2x очками и пометкой "секретное"

// Формула: points * 2

// Используй метод copy()

// Напиши функцию printAchievementInfo(achievement: Achievement), которая:

// Использует деструктуризацию для получения свойств

// Выводит: "[ID] Название: Очки | Секретное: да/нет"

// Задача 4: Фильтрация и поиск
// Напиши функцию getTotalPoints(achievements: List<PlayerAchievement>, allAchievements: List<Achievement>): Int, которая:

// Принимает список достижений игрока и всех возможных достижений

// Возвращает общее количество очков игрока

// Алгоритм: для каждого PlayerAchievement найти Achievement по ID и сложить points

// Напиши функцию getFastestCompletion(playerAchievements: List<PlayerAchievement>): PlayerAchievement?, которая:

// Находит достижение с наименьшим completionTime (где оно не null)

// Возвращает это достижение или null

fun main(args: Array<String>) {
    
    val firstLogin = Achievement("ach_001", "Первый шаг", "Зайти в игру", 10, false)
    val speedRunner = Achievement("ach_002", "Скоростной", "Пройти уровень за 60 сек", 50, false)
    val secretFind = Achievement("sec_001", "Тайное знание", "Найти секретную комнату", 100, true)
    
    val achievements = listOf(
        firstLogin,
        speedRunner,
        secretFind
    )

    val playerAchievements = listOf(
        PlayerAchievement("ach_001", "ProGamer", "2024-12-15", null),
        PlayerAchievement("ach_002", "ProGamer", "2024-12-16", 58),
        PlayerAchievement("sec_001", "ProGamer", "2024-12-16", null)
    )
    


    // Создание достижений
    val speedRun = Achievement("ach_002", "Скоростной", "Пройти за 60 сек", 50, false)
    
    // Создание хардкорной версии
    val hardcoreSpeedRun = createHardcoreAchievement(speedRun)
    println("Хардкорное: $hardcoreSpeedRun")
    
    // Деструктуризация
    printAchievementInfo(speedRun)
    // Вывод: [ach_002] Скоростной: 50 очков | Секретное: нет
    
    // Подсчет очков
    val total = getTotalPoints(playerAchievements, listOf(speedRun, firstLogin, secretFind))
    println("Всего очков: $total")
    
    // Самое быстрое выполнение
    val fastest = getFastestCompletion(playerAchievements)
    fastest?.let {
        println("Самое быстрое: ${it.achievementId} за ${it.completionTime}сек")
    
    }
}


fun createHardcoreAchievement(base: Achievement): Achievement {
    var returned: Achievement = base.copy(isSecret = true, points = base.points*2)
    return returned
}

fun printAchievementInfo(achievement: Achievement) {
    var (id, title, description, points, isSecret) = achievement
    println("[$id] Название: $title  Очки: $points | Секретное: " + if(isSecret) "да" else "нет")
}

fun getTotalPoints(achievements: List<PlayerAchievement>, allAchievements: List<Achievement>): Int {
    var allPoints: Int = 0
    for (i in achievements) {
        for (j in allAchievements) {
            if (i.achievementId == j.id) {
                allPoints += j.points
            }
        }
    }
    return allPoints
}


fun getFastestCompletion(playerAchievements: List<PlayerAchievement>): PlayerAchievement? {
    var least: Int = 0
    var leastAchievement: PlayerAchievement = PlayerAchievement()
    for (i in playerAchievements) {
        if(i.completionTime != null) {
            if(least == 0) {
                least = i.completionTime
                leastAchievement = i.copy()
            } else if (least < i.completionTime) {
                least = i.completionTime
                leastAchievement = i.copy()
            }
        } 
    }
    return leastAchievement
}