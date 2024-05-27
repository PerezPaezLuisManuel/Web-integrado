<%-- 
    Document   : listar
    Created on : 25 may. 2024, 18:33:19
    Author     : lurto
--%>

<%@page import="Modelo.PersonaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista de usuarios</title>
    </head>
    <body>
        <div class="container">
            <h1>Personas</h1>
            <!-- Botón para agregar un nuevo usuario -->
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <!-- Encabezados de las columnas de la base de datos -->
                        <th class="text-center">ID</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    //Se crea una instancia
                    PersonaDAO dao=new PersonaDAO();
                    
                    //Se obtiene una lista de los usuarios "Persona"
                    List<Persona>list=dao.listar();
                    
                    //Se crea un iterador para recorrer la lista de personas
                    Iterator<Persona>iter=list.iterator();
                    Persona per=null;
                    
                    //Recorre la lista en bucle y los imprime hasta que todos estén listados
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <!-- Muestra información de la persona (usuario) -->
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getDni()%></td>
                        <td><%= per.getNom()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
