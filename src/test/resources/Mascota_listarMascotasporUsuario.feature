# language: en
# encoding: iso-8859-1

  Feature: Listar todas mis mascotas
    Como usuario quiero listar todas mis mascotas para observar las mascotas que tengo registradas en la aplicacion

    Scenario: El usuario lista a todas sus mascotas
      Given que ingreso al API "http://localhost:8080"
      And me ubico en la ruta "/api/mascota/listarMascotasporUsuario/"
      And teniendo como codigo de usuario "1"
      And mediante el metodo "GET"
      When envio mi peticion
      Then obtuve la lista de todas mis mascotas