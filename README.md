# Sistema de Gestión de Productos - JavaFX + PostgreSQL

## Descripción

Aplicación desarrollada en JavaFX que permite gestionar productos almacenados en una base de datos PostgreSQL.

El sistema permite:

- Registrar productos.
- Mostrar productos almacenados.
- Limpiar campos del formulario.
- Cerrar la aplicación.
- Visualizar los datos en una tabla (TableView).

---

## Tecnologías Utilizadas

- Java JDK 26
- JavaFX 21
- PostgreSQL
- JDBC
- Maven
- IntelliJ IDEA

---

## Estructura del Proyecto

```text
src
│
├── main
│   ├── java
│   │   └── com.tarea.tienda
│   │       ├── Main.java
│   │       ├── Conexion.java
│   │       ├── Producto.java
│   │       └── ProductoController.java
│   │
│   └── resources
│       └── com.tarea.tienda
│           ├── Producto.fxml
│           └── styles.css
│
└── module-info.java
```

---

## Base de Datos

### Crear Base de Datos

```sql
CREATE DATABASE tienda;
```

### Crear Tabla

```sql
CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10,2),
    stock INT
);
```

---

## Configuración de la Conexión

Archivo:

```java
Conexion.java
```

Configuración:

```java
String url = "jdbc:postgresql://localhost:5432/tienda";
String user = "postgres";
String pass = "1234";
```

Modificar los datos según la configuración local de PostgreSQL.

---

## Dependencia PostgreSQL

Agregar en el archivo pom.xml:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.4</version>
</dependency>
```

---

## Funcionalidades

### Guardar

Permite registrar un nuevo producto en la base de datos mediante un INSERT.

Validaciones:

- No permite campos vacíos.
- Utiliza PreparedStatement para evitar errores SQL.

---

### Mostrar

Realiza una consulta SELECT y carga todos los registros en el TableView.

---

### Limpiar

Borra el contenido de los TextField y coloca el cursor en el primer campo.

---

### Salir

Cierra la aplicación.

---

## Diseño de la Interfaz

La interfaz fue desarrollada utilizando:

- JavaFX FXML
- CSS personalizado

## Ejecución del Proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que PostgreSQL esté iniciado.
3. Verificar que exista la base de datos "tienda".
4. Configurar usuario y contraseña en Conexion.java.
5. Ejecutar la clase:

```java
Main.java
```

## Autor

Nombre: Victor Calapaqui

Asignatura: Programacion Orientada a Objetos

Tema: JavaFX + Base de Datos PostgreSQL
