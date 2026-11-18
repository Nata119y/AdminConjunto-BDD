Feature: Gestion de inmuebles

  Scenario: Registrar un inmueble
    Given El administrador ingresa al sistema
    When Registra el inmueble torre "2" apartamento "202" con area "70" y propietario con cedula "2000000003"
    Then Se muestra el mensaje "Inmueble registrado correctamente."

  Scenario: Consultar los inmuebles registrados
    Given El administrador ingresa al sistema
    When Ingresa al modulo de inmuebles
    Then Se muestra el inmueble del apartamento "101"

  Scenario: Buscar un inmueble
    Given El administrador ingresa al sistema
    When Busca el apartamento "101"
    Then Solo se muestra el inmueble del apartamento "101"

  Scenario: Asignar un propietario a un inmueble
    Given El administrador ingresa al sistema
    When Registra el inmueble torre "3" apartamento "303" con area "55" y propietario con cedula "2000000003"
    Then El inmueble del apartamento "303" muestra al propietario "Propietario BDD"

  Scenario: Registrar un inmueble con datos incompletos
    Given El administrador ingresa al sistema
    When Intenta guardar un inmueble con los campos obligatorios vacios
    Then El sistema solicita completar la informacion obligatoria