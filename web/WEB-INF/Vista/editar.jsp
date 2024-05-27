<%-- 
    Document   : editar
    Created on : 25 may. 2024, 18:33:33
    Author     : lurto
--%>

<%@page import="Modelo.PersonaDAO"%>
<%@page import="Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar usuario</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              //Instanciado
              PersonaDAO dao=new PersonaDAO();
              
              //Obtiene el ID (atributo) "idper" de la persona y la transforma a entero
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              
              //Obtiene datos de la persona con el ID especificado
              Persona p=(Persona)dao.list(id);
          %>
            <h1>Modificar Persona</h1>
            <form action="Controlador">
                <!-- Muestra los campos de texto con los datos prellenados-->
                DNI:<br>
                <input class="form-control" type="text" name="txtDni" value="<%= p.getDni()%>"><br>
                Nombres: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getNom()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>
        </div>
    </body>
</html>
