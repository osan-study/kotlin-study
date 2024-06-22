import atomictest.*

fun main() {

    val v1 = 11
    val v2 = "Ontology"

    v1 eq 11
    v2 eq "Ontology"
    v2 neq "Epistimology"
    v2 eq "Epistimology"

    calculateBMI(160.0, 68.0) eq "Normal weight"
    calculateBMI(160.0, 68.0) eq "Underweight"
    calculateBMI(160.0, 68.0) eq "Overweight"

}

fun calculateBMI(
    weight: Double,
    height: Double,
): String {
    val bmi = weight / (height * height) * 703.07
    return if (bmi < 18.5) "Underweight"
    else if (bmi < 25) "Normal weight"
    else "Overweight"
}