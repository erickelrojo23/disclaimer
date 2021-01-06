#RetoBackEnd
Reto BackEnd



#GitHub repository
https://github.com/erickelrojo23/retoBackEnd


#Docker Hub
docker pull erickelrojo/backend


#Request

{

    "tipoObjeto": "Computadora",
    "computadora": {
        "marca": "DELL",
        "serie":"1k2345",
        "tipoPantalla": "LCD",
        "tarjetaVideo": "nvidia",
        "tipoLectora": "dvd"
    }
}

{

    "tipoObjeto": "Laptop",
    "laptop": {
        "marca": "HP",
        "serie":"ER2345",
        "tipoPantalla": "LED",
        "tarjetaVideo": "msi",
        "tipoLectora": "sin lectora"
    }
}

{

    "tipoObjeto": "MaquinaEscribir",
    "maquinaEscribir": {
        "marca": "Sansung",
        "serie":"FH12312"
    }
}


#Response

[

    {
        "computadora": {
            "idComputadora": 1,
            "marca": "DELL",
            "serie": "1k2345",
            "tipoPantalla": "LCD",
            "tarjetaVideo": "nvidia",
            "tipoLectora": "dvd",
            "comun": null
        },
        "laptopArray": [
            ["idLaptop: 1"],
            ["marca: HP"],
            ["serie: ER2345"],
            ["pantalla: LED"],
            ["tarjetaVideo: msi"],
            ["tipoLectora: sin lectora"]
        ],
        "maquinaEscribirs": [
            {
                "idMaquina": 1,
                "marca": "Sansung",
                "serie": "FH12312",
                "comun": null
            }
        ]
    }
]
