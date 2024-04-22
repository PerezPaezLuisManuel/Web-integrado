<%-- 
    Document   : index
    Created on : 21 abr. 2024, 17:55:06
    Author     : lurto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Integrado</title>
    </head>
    <body>
        <h2>QUEJAS Y RECLAMOS</h2>
        <div class="container">
            <form action="" method="post" class="form-group">
                <label for="labelDni"><b>DNI:</b></label><br>
                <input type="number" name="txtDni" id="txtDni" class="form-control" required>
                
                <br>
                <br>
                
                <label for="labelNombre"><b>Nombres:</b></label><br>
                <input type="text" name="txtNombre" id="txtNombre" class="form-control" required>
                
                <br>
                <br>
                
                <label for="labelApellidos"><b>Apellidos:</b></label><br>
                <input type="text" name="txtApellidos" id="txtApellidos" class="form-control" required>
                
                <br>
                <br>
                
                <label for="labelTelefono"><b>Teléfono:</b></label><br>
                <input type="number" name="txtTelefono" id="txtTelefono" class="form-control" required>
                
                <br>
                <br>
                
                
                <label for="labelDescripcion"><b>Descripción:</b></label><br>
                <textarea class="form-control" rows="8" cols="21" id="txtAreaDescripcion"></textarea>
                
                <br>
                <br>
                
                <button type="button" name="btnEnviar" id="btnEnviar" class="btn btn-primary" onclick="alerta()">Enviar</button>
                
                <script>
                    function alerta(){
                        window.alert('Reclamo enviado correctamente');
                    }
                </script>
            </form>
        </div>
    </body>
</html>
