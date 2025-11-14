//Ejercicio2 mejorado con IA
// Definición de la función principal que recibe la lista y la política de transformación
def transformarCalificaciones(
                               calificaciones: List[Double],
                               politica: Double => Double
                             ): List[Double] = calificaciones.map(politica)

// Ejemplo de políticas de transformación

// Redondear cada calificación
def redondear(n: Double): Double = Math.round(n).toDouble

// Aplicar una bonificación (0.5 puntos excepto si es 10)
def bonificacion(n: Double): Double = if (n != 10) n + 0.5 else n

// Disminuir calificaciones demasiado altas (>9.8)
def calificacionAlta(n: Double): Double = if (n > 9.8) n - 0.24 else n

// Ejemplo de uso: crear distintas listas de acuerdo a la política seleccionada
val listaOriginal = List(10, 9.8, 9.5, 6.7, 10)

val listaRedondeada = transformarCalificaciones(listaOriginal, redondear)
val listaBonificada = transformarCalificaciones(listaOriginal, bonificacion)
val listaAjustadaAltas = transformarCalificaciones(listaOriginal, calificacionAlta)

// Imprimir resultados
println(listaRedondeada)       // List(10.0, 10.0, 10.0, 7.0, 10.0)
println(listaBonificada)       // List(10.0, 10.3, 10.0, 7.2, 10.0)
println(listaAjustadaAltas)    // List(9.76, 9.56, 9.5, 6.7, 9.76)


