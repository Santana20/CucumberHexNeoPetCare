# language: en
# encoding: iso-8859-1

Feature: Registrar mascotas
  Como dueño de mascota registrado Quiero tener diferentes perfiles para cada mascota registrando sus datos como: nombre, edad, tipo de mascota y peso Para tener una mejor organización de sus necesidades.

  Scenario: El usuario crea perfil de sus mascotas
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/mascota/registrarMascota/" para registrar
    And teniendo como codigo de usuario "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista de mascotas para registrar
      | nombre   | edad | peso | idtipomascota |
      | Firulais | 5    | 4.6  | 1             |
      | Michi    | 6    | 3.5  | 2             |
      | Rocky    | 3    | 8.0  | 1             |
    When envio la peticion para registrar
    Then se insertaron mis mascotas

  Scenario: No se ingresaron todos los datos o son datos inválidos
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/mascota/registrarMascota/" para registrar
    And teniendo como codigo de usuario "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista de mascotas para registrar
      | nombre   | edad | peso | idtipomascota |
      | Firulais2 | 5    | 4.6  |               |
      | Michi40    | 6    | -3.5 | 2             |
      |          | 3    | 8.0  | 1             |
    When envio la peticion para registrar
    Then recibo un mensaje de error "No se pudo registrar a la mascota. No se completo todos los datos o son ivalidos."

  Scenario: Dos mascotas tienen el mismo nombre
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/mascota/registrarMascota/" para registrar
    And teniendo como codigo de usuario "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista de mascotas para registrar
      | nombre   | edad | peso | idtipomascota |
      | Firulais | 8    | 5    | 2             |
    When envio la peticion para registrar
    Then recibo un mensaje de error "No se pudo registrar a la mascota. Una de sus mascotas ya tiene ese nombre."