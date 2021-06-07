# Buscador de mutantes
## Descripción
 La siguiente API Rest, hosteada en AWS, determina si un ADN dado sea de un mutante. Para ello, valida si hay al menos cuatro letras consecutivas en forma horizontal, oblicua o vertical.
 
## Condiciones
El usuario debe ingresar por consola los valores del ADN, separados por coma. El sistema validará:

- La cantidad de carácteres, para que pueda generarse una matriz cuadrada
- Que los carácteres sean los correspondientes, es decir: "A", "C", "G" o "T"
- Que la matriz tenga al menos 5 letras

## Modo de ejecución
Para la correcta ejecución, realizar los siguientes pasos:
1. Clonar el repositorio desde:

    `https://github.com/LauJorge/MercadoLibre.git`

2. Navegar hasta la locación del repositorio clonado, accediendo a la carpeta donde se haya el pom file

    `cd /{dir_de_repo_clonado}/MercadoLibre/MercadoLibre` 

3. Para levantar el servicio, ejecutar la siguiente linea de comando:

    `$ mvn spring-boot:run`

## Validar el servicio

- **Guardar un mutante en memoria local** 

**POST** `http://mutants-env.zdttkk7xym.us-east-1.elasticbeanstalk.com/mutants`

>**Header** `Content-Type: application/json`   
**Body**  `{"dna": "acgtt,aacta,aatgt,atcat,ttgca"}`


- **Mostrar todos los mutantes**

**GET** `http://mutants-env.zdttkk7xym.us-east-1.elasticbeanstalk.com/mutants`
