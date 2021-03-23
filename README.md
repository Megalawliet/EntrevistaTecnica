# Entrevista Técnica

#### 1. Equipo Desarrollo 

| Developer | Rama | Rol |
| --- | :---:  | :---:  |
| Myroslav Andreykiv | Master / Dev1 | Developer | 
| Gerard Bonet | Dev 2 | Developer |
| Noelia Barrera | Dev 3 | Developer | 

#### 2. Descripción
Entrevista Técnica
En este proyecto fullStack desarrollamos una aplicación que permite registrar las entrevistas técnicas que realiza una empresa tecnológica para sus puestos de trabajo ofertados.

La aplicación estará gestionada por un usuario de recursos humanos que creará las posiciones en que los candidatos podrán aplicar, también contará con una extensión de rol para el usuario llamado “experto” que será el que realizará las entrevistas técnicas.


Comenzando 🚀
Se puede obtener el proyecto clonando de este repositorio de github a la Spring Tool Suite 
https://github.com/andreykiv/EntrevistaTecnica.git.


Pre-requisitos 📋


Tener instalado: 

Postman

Spring Tool Suite

MySql en un servidor.



Ejecutando el programa ⚙️
Utilizar los siguientes endPoints para realizar las consultas y modificaciones  sobre la base de datos :


End-points🔩
Api:
@RequestMapping("/api")

Listar i crear id según la entidad(si queremos listar sólo un registro /{id}):

@GetMapping("/candidate")
@GetMapping("/candidatePosition")
@GetMapping("/candidateSkill")
@GetMapping("/companyUser")
@GetMapping("/positions")
@GetMapping("/skill")

Guardar y actualizar según la entidad(si queremos guardar o actualizar sólo un registro /{id}):
@PostMapping("/candidate")
@PostMapping("/candidatePosition")
@PostMapping("/candidateSkill")
@PostMapping("/companyUser")
@PostMapping("/skill")
@PostMapping("/positions")


Eliminar un registro de la entidad:
@DeleteMapping("/candidate/{id}")
@DeleteMapping("/candidatePosition/{id}")
@DeleteMapping("/candidateSkill/{id}")
@DeleteMapping("/companyUser/{id}")
@DeleteMapping("/skill/{id}")
@DeleteMapping("/positions/{id}")

Construido con 🛠️
Menciona las herramientas que utilizaste para crear tu proyecto
Spring Tool Suite


Autores ✒️
Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios:
Noelia Barrera
Miroslav Andreykiv
Gerard Bonet

Licencia 📄
Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo LICENSE.md para detalles


Expresiones de Gratitud 🎁
Google
Mi familia 
Aragon en el retorno del rey por llegar con los espíritus en barco.

#### 3. Link a un demo con el proyecto desplegado: https://github.com/andreykiv/EntrevistaTecnica


#### 4. Lista con los pasos mínimos que se necesitan para clonar exitosamente el proyecto y echarlo a andar en local.



