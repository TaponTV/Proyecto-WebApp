Index:
	- El menu de inicio deberá tener opciones tales cómo:
		- Inicio, Nosotros, Contacto, Comentarios (No programar aun OMITIR), Login
		- Diseño de veterinario con colores claros y contraste, verdes, azules, grises, negros (en caso de ser necesario), ocupar un diseño minimalista pero médico.

Login:
- Inicio de sesión con usuario existente.
	- Servlet encargado de iniciar Sesión con email y pswrd. (Listo - solo falta modificar la BD para que el email sea irrepetible)
	- Servlet encargado de cerrar Sesión. (Listo)

- Creación de usuario Cliente:
	- Permitir crear un usuario nuevo con el rol del cliente. (Listo)
	- Crear registro nuevo en la tabla 'Cliente' con el idUser nuevo. (Pendiente) 
	- Inicie sesión con el nuevo usuario. (Listo)
	- Redireccionar al menu cliente. (Listo)

- Creación de usuario Veterinario: (Pendiente Trabajar urgente)
	- Permitir crear un usuario nuevo con el rol Veterinario 
	- Crear registro nuevo en la tabla 'veterinario' con el idUser nuevo.
		- Al crear usuario, redireccionar a un nuevo JSP con el formulario para los datos necesarios para crear el nuevo registro para el veterinario.
	- Iniciar sesión con el nuevo usuario.
	- Redireccionar al menu Veterinario
	- Verificar si el idUser del usuario logueado, corresponde a algun registro de la tabla veterinario, de no ser así, redireccionar al JSP del formulario para los datos necesarios para crear el nuevo registro para el veterinario.

- Determinar si un usuario ya está logueado: 
	- En caso de estar logueado, siguiente paso, sino, mostrar index. (Listo)
	- Esta función debe estar presenta en todos y cada uno de los JSP para evitar una intrución en el sistema. (Pendiente)
- Redireccionar al menu correspondiente al rol. (Pendiente)

ROL ADMINISTRADOR (PERMISOS Y ACCESIBILIDAD)
- Crear menu para el usuario administrador:
	- Modulo que muestre un dashboard para el administrador con estadisticas de la WebApp.
		- Cantidad de usuarios registrados:
			- Dividir entre Clientes y Veterinarios
		- Cantidad de conexiones.
		- Cantidad de mascotas registradas.
		- Cantidad de solicitudes realizadas.
	- Modulo que muestre a los usuarios 'Clientes' registrados:
		- Los datos presentes en la lista solo deben ser:
			- idUser, idCliente, Nombre, Edad, cantidad de conexiones, ultima conexión (Fecha Conexión), Cantidad de mascotas registradas, solicitudes pendientes, solicitudes declinadas, solicitudes aceptadas, cantidad de citas, comentarios realizados.
		- lista a través de una tabla:
			- Debe tener botones con diferentes funciones:
				- Botón para borrar el usuario correspondiente (Eliminación permanente), tener en cuenta que esta eliminación debe borrar todos y cada uno de los datos que tengan que ver con este usuario dentro de la base de datos (Exceptuando aquellos que involucren a otro usuario).
				- Opción que permita mostrar todos los datos relacionados a este cliente, es decir, listar todas las conexiones de este usuario, listar todas las mascotas registradas por este usuario (Solo idMascota, Nombre), listar todas las solicitudes de este cliente(idSolicitud, Nombre del medico a quien se realizó dicha solicitud, Estado de dicha solicitud), listar todas las citas a las que ha acudido (idCita, fecha). Cada una de las listas debe ser tratada como una función diferente dentro de una misma (Opciones a mostrar)
	- Modulo que muestre a los usuarios 'Veterinario' registrados:
		- Los datos presentes en la lista solo deben ser:
			- idUser, cedula o idVeterinario, Nombre, Edad, especialidad, fechaTitulación, universidad, solicitudes pendientes, solicitudes aceptadas, solicitudes declinadas, Citas atentidas, calificación.
		- listar a través de una tabla:
			- Debe tener botones con diferentes funciones:
				- Botón para borrar el usuario correspondiente (Eliminación permanente), tener en cuenta que esta eliminación debe borrar todos y cada uno de los datos que tengan que ver con este usuario dentro de la base de datos (Exceptuando aquellos que involucren a otros usuario)
				- Opción que permita mostrar todos los datos relaciones a este veterinario, es decir, listar todas las conexiones de este usuario, listar todas las citas realizadas (idCita, NombreCliente, nombreMascota, especieMascota, fecha, botón que muestre la receta de esta cita, si y solo si existe la receta), listar todas las solicitudes aceptadas, declinadas o pendientes (idSolicitud, nombreCliente, fecha, estado de dicha solicitud).

ROL VETERINARIO (PERMISOS Y ACCESIBILIDAD)
- Crear menu para el usuario Veterinario:
	- Modulo que muestre un dashboard con estadisticas personales:
		- Cantidad de solicitudes pendientes.
		- Cantidad de solicitudes aceptadas.
		- Cantidad de citas realizadas.
		- Cantidad clientes atendidos.
		- Calificación promedio. (Numero o estrellas a gusto del programador).
	- Modulo de notificaciones:
		- Solicitudes pendientes:
			- Click para poder ver información completa de esta solicitud (NombreCliente, descripcion, datos de la mascota)
			- posibilidad de aceptarlas o declinarlas
				- Si son aceptadas, mostrar otra ventana que muestre los datos para agendar la cita, permitiendo introducir una fecha y hora a la cita y una descripción.
				- Si son declinadas, mostrar otra ventana para agregar una descripción del porqué no puede ser procesada dicha solicitud.
		- Citas próximas (3 días de anticipación a la fecha actual)
		- Citas vencidas (1 día de retraso).
	- Modulo para configurar datos personales:
	- Modulo para mostrar comentarios relacionados a si mismo.
	- Modulo para mostrar citas próximas
		- Listar todas las citas (NombreCliente, fecha y hora cita, descripción, Nombre Mascota [Mostrar mascota como enlace o botón para mostrar datos de dicha mascota {Nombre, Edad, Especie, Raza, Cartilla de vacunación de dicha mascota}])
		- Este usuario debe tener la posibilidad de actualizar la cartilla de vacunación de la mascota seleccionada (En caso de requerirlo).
	- Modulo para mostrar mascotas atendidas con recetas puestas.

ROL CLIENTE (PERMISOS Y ACCESIBILIDAD)
- Crear menu para usuario Cliente:
	- Menu directo de búsqueda de veterinarios
		- Opciones fijas de filtraje: por País, Estado y Ciudad
		- Opciones de filtraje posibles para el usuario: Atención de especie especifica, Mejor puntuación, Genero
		- Listar todos los Usuarios Veterinarios que cumplan con el filtrado puesto
		- En caso de seleccionar uno, mostrar ventana con los datos básicos de este veterinario (Nombre, calificación, descripción del perfil) y un botón que permita regresar a la busqueda y uno para realizar una solicitud.
		- La solicitud se hace agregando los datos de una mascota registrada, si no existe ninguna mascota registrada, los datos deberán ser llenados ahí mismo, además de una descripción del porque la solicitud (Sigo pensando si la prioridad igual la agrega el cliente).
	- Modulo de mascotas:
		- Añadir, Eliminar, Mostrar o dar por muerta una mascota (Esto es broma pero me da gracia pensar que lo pueda tener como opción o que aparezca un moñito negro xD)
		- Al mostrar mascota:
			- Mostrar datos generales de la mascota junto con un botón que permita mostrar la cartilla de vacunación de dicha mascota, al igual mostrar dentro de los datos generales, a cuantas citas ha ido y al dar click en el número, mostrar listado de citas de dicha mascota, también mostrar la receta del tratamiento actual que esté siguiendo esta mascota.
	- Modulo de notificaciones (Solicitudes aceptadas y Solicitudes declinadas)
	- Modulo de solicitudes pendientes.
	- Modulo de citas próximas
	- Modulo de configuración de datos personales
