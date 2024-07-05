package chapter4.moonggae

data class Chicken(
    val name: String,
    val price: Int,
    val isFavorite: Boolean = false
)

fun Chicken.isRed(): Boolean = name.contains("레드")

val chickenList = listOf(
    Chicken(name = "허니오리지날", price = 19000),
    Chicken(name = "레드오리지날", price = 20000),
    Chicken(name = "교촌오리지날", price = 19000),
    Chicken(name = "반반오리지날", price = 20000),
    Chicken(name = "블랙시크릿콤보", price = 14000),
    Chicken(name = "블랙시크릿오리지날", price = 20000),
    Chicken(name = "블랙시크릿콤보", price = 23000),
    Chicken(name = "블랙시크릿순살", price = 23000),
    Chicken(name = "교촌콤보", price = 22000),
    Chicken(name = "교촌순살", price = 22000),
    Chicken(name = "교촌윙", price = 22000),
    Chicken(name = "교촌스틱", price = 22000),
    Chicken(name = "허니콤보", price = 23000),
    Chicken(name = "허니순살", price = 23000),
    Chicken(name = "레드콤보", price = 23000, isFavorite = true),
    Chicken(name = "레드순살", price = 23000),
    Chicken(name = "레드윙", price = 23000, isFavorite = true),
    Chicken(name = "레드스틱", price = 23000, isFavorite = true),
    Chicken(name = "리얼후라이드", price = 20000),
    Chicken(name = "살살후라이드미니", price = 7000),
    Chicken(name = "살살후라이드", price = 20000),
    Chicken(name = "파채소이살살", price = 19000),
    Chicken(name = "반반콤보", price = 23000),
    Chicken(name = "반반순살", price = 23000),
    Chicken(name = "반반스틱", price = 23000),
    Chicken(name = "반반윙", price = 23000),
    Chicken(name = "레블반반콤보", price = 23000),
    Chicken(name = "레허반반순살", price = 23000),
    Chicken(name = "시그니처순살세트", price = 33000),
    Chicken(name = "반반점보윙", price = 19000),
    Chicken(name = "반반점보윙", price = 19000),
    Chicken(name = "반반점보윙", price = 19000),
    Chicken(name = "교촌점보윙", price = 19000),
    Chicken(name = "레드점보윙", price = 19000),
    Chicken(name = "허니점보윙", price = 19000),
    Chicken(name = "문베어 모스카토 스위트 ALE", price = 0),
    Chicken(name = "문베어 소빈블랑 IPA", price = 0),
    Chicken(name = "1991 벨지안 위트에일", price = 0),
    Chicken(name = "1991 라거", price = 0),
    Chicken(name = "금강산 골든에일", price = 5500),
    Chicken(name = "백두산 IPA", price = 6000),
    Chicken(name = "아, 귀한 먹태", price = 13000),
    Chicken(name = "칩카사바", price = 2000),
    Chicken(name = "퐁듀치즈볼", price = 6000),
    Chicken(name = "고르곤치즈볼", price = 6000),
    Chicken(name = "웨지감자", price = 4000),
    Chicken(name = "샐러드", price = 5000),
    Chicken(name = "교촌순살", price = 12000),
    Chicken(name = "레드순살", price = 13000),
    Chicken(name = "허니순살", price = 13000),
    Chicken(name = "닭갈비볶음밥", price = 4000),
    Chicken(name = "배달료", price = 2000),
    Chicken(name = "교촌순살치밥세트", price = 25000),
    Chicken(name = "레드순살치밥세트", price = 26000),
    Chicken(name = "블랙시크릿순살", price = 14000),
    Chicken(name = "교촌콤보", price = 12000),
    Chicken(name = "교촌윙", price = 12000),
    Chicken(name = "교촌스틱", price = 12000),
    Chicken(name = "레드콤보", price = 13000),
    Chicken(name = "레드윙", price = 13000),
    Chicken(name = "레드스틱", price = 13000),
    Chicken(name = "블랙시크릿팝콘", price = 2000),
    Chicken(name = "옥수수볼", price = 5000),
    Chicken(name = "달걀듬뿍볶음밥", price = 4000),
    Chicken(name = "의성마늘볶음밥", price = 4000),
    Chicken(name = "한입쏙직화닭발", price = 17000),
    Chicken(name = "츠쿠네어묵탕", price = 18000),
    Chicken(name = "고르곤치즈볼", price = 3500),
    Chicken(name = "포테이토앤칩스", price = 6500),
    Chicken(name = "퐁듀치즈볼", price = 3500),
    Chicken(name = "국물맵떡", price = 9000)
)