# language: en
# encoding: iso-8859-1

Feature: Registrar baños
  Como dueño de mascota registrado Quiero tener un registro de baños de mi mascota Para tener un buen control de su higiene.

  Scenario: El usuario registra un baño para su mascota
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/registroCuidado/registrarCuidado/" para registrar
    And teniendo como codigo de mascota "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista para registrar
      | fechaRegistro | idCuidado |
      | 2020-11-20    | 2         |
      | 2020-12-02    | 2         |
      | 2020-12-14    | 2         |
    When envio la peticion para registrar
    Then se insertaron mis registros

  Scenario: Se registran dos baños en la misma fecha
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/registroCuidado/registrarCuidado/" para registrar
    And teniendo como codigo de usuario "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista de mascotas para registrar
      | fechaRegistro | idCuidado |
      | 2020-11-20    | 2         |
      | 2020-11-20    | 2         |
    When envio la peticion para registrar
    Then recibo un mensaje de error "No se pudo registrar el baño. Ya se ha registrado uno para ese día."

Feature: Registrar alimentos
  Como dueño de mascota registrado Quiero tener un registro de alimentos de mi mascota Para tener controlada la nutrición de mi mascota.

  Scenario: El usuario registra un alimento para su mascota
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/registroCuidado/registrarCuidado/" para registrar
    And teniendo como codigo de mascota "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista para registrar
      | fechaRegistro | idCuidado |
      | 2020-11-20    | 1         |
      | 2020-12-02    | 1         |
      | 2020-12-14    | 1         |
    When envio la peticion para registrar
    Then se insertaron mis registros

  Scenario: Se registran dos alimentos en la misma fecha
    Given que ingreso al API "http://localhost:8080" para registrar
    And me ubico en la ruta "/api/registroCuidado/registrarCuidado/" para registrar
    And teniendo como codigo de usuario "1" para registrar
    And mediante el metodo "POST" para registrar
    And tengo la siguiente lista de mascotas para registrar
      | fechaRegistro | idCuidado |
      | 2020-11-20    | 1         |
      | 2020-11-20    | 1        |
    When envio la peticion para registrar
    Then recibo un mensaje de error "No se pudo registrar el alimento. Ya se ha registrado uno para ese día."

