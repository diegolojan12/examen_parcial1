//Ejercicio1
def myMethod(datos: List[Double]): Double = {
  val promedio = datos.sum / datos.size
  val valor = datos.map(d => (d - promedio) * (d - promedio)).sum / datos.size
  math.sqrt(valor)
}

myMethod(List(1,2.8,3,4,5))


//Ejercicio2
def transformarCalificaciones(calificaciones: List[Double], seleccion: Int): List[Double] =
  //Funcion con nombre para aplicar una bonificacion
  def bonificacion(n: Double): Double = if (n != 10) n+0.5 else n
  //Funcion con nombre para disminuir la calificacion mas alta
  def calificacionalta(n: Double): Double = if(n > 9.8) n - 0.24 else n
  seleccion match{
    case 1 => calificaciones.map(c => Math.round(c).toDouble)
    case 2 => calificaciones.map(bonificacion)
    case 3 => calificaciones.map(calificacionalta)
  }

transformarCalificaciones(List(10,9,9.5,6.7,10),1)
transformarCalificaciones(List(10,9,9.5,6.7,10),2)
transformarCalificaciones(List(10,9,9.5,6.7,10),3)

//Ejercicio3
//Funcion anonima
val generadorSaludosAnonimo: String => (String => String) =
  (fraseBase: String) =>
    (nombre:String) =>
      s"$fraseBase, $nombre!"
val s = generadorSaludosAnonimo("hola")
s("Miguel")

//Funcion con nombre
def generadorSaludosConNombre(fraseBase: String): String => String = (nombre: String) => s"$fraseBase, $nombre!"
val saludo = generadorSaludosConNombre("Hola")
saludo("Rebeca")