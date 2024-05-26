<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado del Formulario</title>
    <link rel="stylesheet" href="estilosmuestra.css">
</head>
<body>
    <h1>resultado de su pedido</h1>
    <?php
    // Obtener los datos del formulario
    $nombre = $_POST['nombre'];
    $edad = $_POST['edad'];
    $direccion_usa = $_POST['direccion_usa'];
    $direccion_gt = $_POST['direccion_gt'];
    $peso = $_POST['peso'];

    
    if ($peso >= 0 && $peso <= 1) {
        $precio = 419.91;
    } else if ($peso > 1 && $peso <= 5) {
        $precio = 653;
    } else if ($peso > 5 && $peso <= 10) {
        $precio = 1042;
    } else if ($peso > 10 && $peso <= 20) {
        $precio = 1819;
    } else {
     $precio = 1819 + (($peso - 20) * 77.76);
    }

    // Imprimir los datos ingresados y el total de la compra
    echo "<p>Nombre: $nombre</p>";
    echo "<p>Edad: $edad</p>";
    echo "<p>Dirección en Estados Unidos: $direccion_usa</p>";
    echo "<p>Dirección en Guatemala: $direccion_gt</p>";
    echo "<p>Peso: $peso kg</p>";
    echo "<p>Total de la compra: Q $precio</p>";
    ?>

    
</body>
</html>
