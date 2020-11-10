# language: en
# encoding: iso-8859-1

Feature: Registrar mascotas
  Como usuario registrado quiero registrar a mis mascotas para llevar un registro de sus cuidados.

  Scenario: El usuario agrega a sus mascotas
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/mascota/registrarMascota/" para registrar
    And teniendo como codigo de usuario "1"
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista de mascotas para registrar
      | Nombre | edad | peso |
      | Firulais | 5 | 4.6 |
      | Michi | 6 | 6.5 |
      | Rocky | 3 | 8.0 |
    When envio la peticion para registrar
    Then se insertaron mis mascotas

