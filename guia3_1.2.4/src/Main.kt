fun main() {
    val prod1 = mapOf<String, Any>("nombre" to "laptop gamer", "precio" to 1250.50, "categoria" to "tecnologia")
    val prod2 = mapOf<String, Any>("nombre" to "cepillo de dientes", "precio" to 9.99, "categoria" to "higiene")
    val prod3 = mapOf<String, Any>("nombre" to "coca-cola", "precio" to 12.50, "categoria" to "comestible")
    val prod4 = mapOf<String, Any>("nombre" to "audifonos", "precio" to 199.90, "categoria" to "tecnologia")
    val prod5 = mapOf<String, Any>("nombre" to "cuaderno", "precio" to 29.90, "categoria" to "oficina")
    val prod6 = mapOf<String, Any>("nombre" to "lapis mina", "precio" to 1.00, "categoria" to "oficina")

    val productos = listOf<Map<String, Any>>(prod1, prod2, prod3, prod4, prod5, prod6)

    println("Ingrese un producto a buscar:")
    print(">")
    var texto = readln()

    buscarProducto(texto, productos)

    println("Promedio del precio de los productos: $" + calcularPromedioPrecios(productos))

    println("Ingrese una categoria por la cual filtra:")
    print(">")
    texto = readln()

    val listaFiltrada=productos.filter{it["categoria"]==texto}
    println(listaFiltrada)

    val listaNombres = productos.map {it["nombre"]}
    println(listaNombres)
}

fun buscarProducto(nombre:String, productos: List<Map<String,Any>>):Map<String,Any>?{
    for (producto in productos){
        if (producto["nombre"]==nombre){
            println("Se encontro el producto deseado: $producto")
            return producto
        }
    }
    println("El producto '$nombre' no fue encontrado")
    return null
}

fun calcularPromedioPrecios(productos: List<Map<String,Any>>):Double{
    var acumulador:Double=0.0

    productos.forEach{ producto ->
        // ?: es como decir, en el caso que de nulo, has esto:
        acumulador+=(producto["precio"] as? Double) ?: 0.0
    }
    return acumulador / productos.size
}

/*

pensaba que habia que hacer una nueva funcion pero era solo una linea de codigo, dejo esto como evidencia de mi trabajo

fun filtroProductos(categoria:String, productos: List<Map<String,Any>>):List<Map<String,Any>>?{
    for (producto in productos){
        if (producto["categoria"]==categoria){

            val listaFiltrada=productos.filter{it["categoria"]==categoria}

            println("Se a creado una lista con la siguiente categoria: $categoria")
            return listaFiltrada
        }
    }
    println("No se encontraron productos con la siguiente categoria: $categoria")
    return null
}
*/