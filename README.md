# Sistema de Gestión de Intercambio de Criptodivisas

¡Bienvenido al proyecto de Sistema de Gestión de Intercambio de Criptodivisas! Este sistema está diseñado para permitir a los usuarios realizar intercambios de criptomonedas de manera segura y eficiente. A continuación, encontrarás información sobre las características del sistema, las instrucciones para su puesta en funcionamiento y otras consideraciones importantes.

## Características del Sistema

El sistema de gestión de intercambio de criptodivisas cuenta con las siguientes características:

- Distintos tipos de divisas con distintos valores: Cada divisa se representa con su valor en pesos. Por ejemplo, 1 BTC equivale a $100 y 1 ETH equivale a $20.
- Almacenamiento de datos de usuario: Para cada usuario del sistema, se almacenan los siguientes datos: DNI, Sexo, Nombre/s, Apellido/s, Email y Teléfono.
- Billeteras de usuario: Cada usuario puede tener una o más billeteras, cada una con un identificador único. En cada billetera se pueden almacenar distintos tipos de divisas. El saldo de la billetera se expresa en pesos.
- Intercambio de divisas: Los usuarios pueden intercambiar divisas entre sus billeteras. El cálculo del intercambio se realiza utilizando el valor en pesos de cada divisa. Por ejemplo, si se cambia BTC por ETH, 1 BTC será equivalente a 5 ETH (con BTC = $100 y ETH = $20).
- Depósito de divisas: Los usuarios pueden depositar divisas en una billetera específica. Por ejemplo, se pueden agregar a una billetera 1 BTC, 2 ETH y $500.
- Auditoría de operaciones: Todas las operaciones de intercambio y depósito quedan registradas en el sistema. Se registra la fecha y hora de la operación, el tipo de operación (intercambio o depósito), las billeteras de origen y destino (para depósitos no se registra la billetera de origen) y los tipos de monedas que se intercambiaron.

## Implementación

El sistema se ha implementado siguiendo los siguientes lineamientos:

- Framework Java: Se ha utilizado el framework Spring Boot para el desarrollo del sistema.
- Base de datos relacional: Se ha utilizado una base de datos relacional para el almacenamiento de los datos. Se incluye un script de creación de la base de datos.
- API REST: Se ha implementado una API REST que permite realizar las siguientes operaciones:
  - ABM de usuarios.
  - ABM de divisas.
  - ABM de billeteras.
  - Intercambio de divisas entre billeteras (pueden ser de distintos o del mismo usuario).
  - Depósito de divisas en una billetera.
  - Consulta de saldo de una billetera.
  - Consulta del saldo total de todas las billeteras de un usuario.
- Scripts y pruebas: Se incluye un script para la creación de la base de datos y otro para la carga inicial de datos para pruebas. Además, se proporciona
un conjunto de pruebas para la API REST, que puede ser ejecutado utilizando Postman o Swagger para la documentación de la API.

## Instrucciones para poner el sistema en funcionamiento

Sigue estos pasos para poner en funcionamiento el sistema:

1. Clona el repositorio desde GitHub: https://github.com/Elseguura/Examen-Stacktrace.git
2. Asegúrate de tener instalado Java JDK (versión 18) en tu máquina.
3. Configura la base de datos relacional y ejecuta el script de creación de la base de datos que se proporciona: Esta en la carpeta "Base de datos".
4. Modifica el archivo de configuración "application.properties" para establecer la conexión a la base de datos.
5. Utiliza Postman o Swagger para probar las diferentes operaciones disponibles en la API.

 Ahora puedes empezar a utilizar el sistema de gestión de intercambio de criptodivisas.


