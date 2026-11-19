Feature: Gestion de usuarios

  Scenario: Registrar un nuevo propietario
    Given El administrador de usuarios inicia sesion en el sistema
    When Crea el usuario "Maria Propietaria" con documento "3000000001" correo "propietario.nuevo.bdd@gmail.com" y rol "Residente"
    Then Se muestra el mensaje de usuarios "Usuario creado. Deberá cambiar su contraseña al iniciar sesión."
    And La lista muestra al usuario con correo "propietario.nuevo.bdd@gmail.com" y rol "Residente"

  Scenario: Registrar un nuevo arrendatario
    Given El administrador de usuarios inicia sesion en el sistema
    When Crea el usuario "Carlos Arrendatario" con documento "3000000002" correo "arrendatario.nuevo.bdd@gmail.com" y rol "Arrendador"
    Then Se muestra el mensaje de usuarios "Usuario creado. Deberá cambiar su contraseña al iniciar sesión."
    And La lista muestra al usuario con correo "arrendatario.nuevo.bdd@gmail.com" y rol "Arrendador"

  Scenario: Registrar un administrador
    Given El administrador de usuarios inicia sesion en el sistema
    When Crea el usuario "Ana Administradora" con documento "3000000003" correo "administrador.nuevo.bdd@gmail.com" y rol "Administrador"
    Then Se muestra el mensaje de usuarios "Usuario creado. Deberá cambiar su contraseña al iniciar sesión."
    And La lista muestra al usuario con correo "administrador.nuevo.bdd@gmail.com" y rol "Administrador"

  Scenario: Registrar usuario con documento duplicado
    Given El administrador de usuarios inicia sesion en el sistema
    When Intenta crear un usuario con documento "2000000001" correo "duplicado.bdd@gmail.com" y rol "Residente"
    Then Se rechaza el registro con el mensaje "Ya existe un usuario con ese correo o documento."

  Scenario: Residente intenta acceder a la administracion de usuarios
    Given El residente inicia sesion para probar usuarios
    When Intenta ingresar al modulo de usuarios
    Then El sistema deniega el acceso con el mensaje "No tiene permisos para realizar esta acción."

  # Funciones aún no construidas en la aplicación (fase roja). El runner las excluye.
  @pendiente
  Scenario: Editar informacion de un usuario
    Given Existe un usuario registrado
    When El administrador modifica sus datos
    Then El sistema guarda los cambios

  @pendiente
  Scenario: Desactivar un usuario
    Given Existe un usuario activo
    When El administrador lo desactiva
    Then El sistema cambia su estado