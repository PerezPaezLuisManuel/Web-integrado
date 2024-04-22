<?php
// Definir las credenciales correctas
$usuarioCorrecto = "admin";
$contrasenaCorrecta = "adminpass";

// Recoger datos del formulario
$usuarioForm = $_POST['username'];
$contrasenaForm = $_POST['password'];

// Verificar si las credenciales son correctas
if ($usuarioForm === $usuarioCorrecto && $contrasenaForm === $contrasenaCorrecta) {
    // Si las credenciales son correctas, redirigir a index.html
    header("Location: index.html");
    exit();
} else {
    // Si las credenciales son incorrectas, mostrar un mensaje de error
    echo "<p style='color: red; text-align: center;'>Datos incorrectos, inténtelo de nuevo.</p>";
    // Re-incluir el formulario de login para permitir otro intento
    include 'login.html';
}
?>
