# TiendaUcompensar
proyecto tienda backend

API de Dispositivos

Esta es una API desarrollada con Java y Spring Boot que gestiona dispositivos electrónicos y sus características asociadas.
Configuración del Proyecto

Para ejecutar la aplicación en tu entorno local, sigue estos pasos:

    Clona este repositorio en tu máquina local usando el siguiente comando:

    bash

    git clone https://github.com/Heiber96/TiendaUcompensar

    Abre el proyecto en tu IDE preferido. Asegúrate de tener configurado Java y Maven en tu entorno de desarrollo.

    Configura las propiedades de la base de datos en el archivo application.properties según tu entorno local.

    Ejecuta la aplicación. La API estará disponible en la URL http://localhost:9101, donde puerto es el número de puerto configurado en tu entorno local.

Endpoints Disponibles

La API proporciona los siguientes endpoints para interactuar con los dispositivos:

    GET /dispositivos/listadodispositivos: Obtiene la lista de todos los dispositivos.
    POST /dispositivos/agregardispositivo: Agrega un nuevo dispositivo.
    PUT /dispositivos/actualizardispositivo/{id}: Actualiza los detalles de un dispositivo existente por su ID.
    DELETE /dispositivos/eliminar/{id}: Elimina un dispositivo existente por su ID.

Ejemplo de Uso

Aquí hay un ejemplo de cómo usar la API con cURL para agregar un nuevo dispositivo:

bash

curl -X POST \
  http://localhost:puerto/dispositivos \
  -H 'Content-Type: application/json' \
  -d '{
    "nombre": "Smartphone X",
    "tipo": "Smartphone",
    "marca": "Marca XYZ",
    "caracteristicas": {
        "procesador": "Snapdragon 888",
        "ram": 8,
        "almacenamiento": "128GB"
    },
    "fechaLanzamiento": "2024-04-05",
    "camara": "Triple cámara, 64MP principal",
    "urlImagen": "https://example.com/imagen.jpg"
}'

