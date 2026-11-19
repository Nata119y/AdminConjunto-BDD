Feature: Gestion de pagos

  Scenario: Consultar cuotas pendientes
    Given El propietario inicia sesion en el sistema
    When Ingresa al modulo de saldos y pagos
    Then Ve su cuota de "$225.000" con estado "Pendiente"

  Scenario: Registrar un pago completo
    Given El administrador de pagos inicia sesion en el sistema
    When Registra el pago total de la cuota pendiente por el metodo "Efectivo"
    Then Se muestra el mensaje de pagos "Pago completo registrado correctamente."
    And La cuota pagada queda con estado "Pagada"

  # Depende del escenario anterior: la cuota ya fue pagada por el administrador
  Scenario: Consultar cuotas pagadas
    Given El propietario inicia sesion en el sistema
    When Consulta su historial de pagos
    Then Ve su cuota de "$225.000" con estado "Pagada"

  # Funciones aún no construidas en la aplicación (fase roja). El runner las excluye.
  @pendiente
  Scenario: Registrar un pago parcial
    Given Existe una cuota pendiente
    When El administrador registra un pago inferior al valor total
    Then El sistema registra el pago parcial
    And La cuota no aparece como pagada
    And No se genera el paz y salvo

  @pendiente
  Scenario: Generar el paz y salvo al pagar completo
    Given Existe una cuota pagada por completo
    When El administrador consulta el paz y salvo
    Then El sistema genera el documento correspondiente

  @pendiente
  Scenario: Generar comprobante de pago en PDF
    Given Existe un pago registrado
    When El administrador solicita el comprobante
    Then El sistema genera un documento PDF

  @pendiente
  Scenario: Impedir registrar un pago negativo
    Given El administrador esta registrando un pago
    When Ingresa un valor negativo
    Then El sistema rechaza el registro

  @pendiente
  Scenario: Impedir registrar un pago de valor cero
    Given El administrador esta registrando un pago
    When Ingresa un valor de cero
    Then El sistema solicita un valor valido