class Mapa {
    #MiClave = "AIzaSyCcWW7VDmc4iLEyBB8-K7pzauZXRG3W1Mc";
    #mapa;
    #descripcionesDeLaRuta = new Map();
    #rutaEnBruto = [];
    #rutaAdaptadaACallesYCarreteras = [];
    
        
    constructor(coordenadasSobreLasQueCentrarlo) {
        var opcionesDelMapa = {
            zoom: 17,
            center: coordenadasSobreLasQueCentrarlo,
        };
        this.#mapa = new google.maps.Map(document.getElementById("contenedor-del-mapa"), opcionesDelMapa);
    }
        
    anadirUnPuntoALaRuta(coordenadas, nombre, descripcion) {
        this.#rutaEnBruto.push(new google.maps.LatLng(coordenadas));
        this.#descripcionesDeLaRuta.set(nombre, descripcion);
    }
    
    ponerMarcador(coordenadas, nombre,
    id,fecha_hora,direccion,codigoPostal,nombreLocalizacion,
    precioTotal,observaciones) {
        const marcador = new google.maps.Marker({
            position: coordenadas,
            label: nombre,
            map: this.#mapa,
            clickable: true,
            draggable: false
        })
        marcador.addListener("click", () => {
            this.procesarClicEnElMarcador(nombre,
    id,fecha_hora,direccion,codigoPostal,nombreLocalizacion,
    precioTotal,observaciones);
        })
    }
    
    procesarClicEnElMarcador(nombre,
    id,fecha_hora,direccion,codigoPostal,nombreLocalizacion,
    precioTotal,observaciones) {
        document.getElementById("informacion-adiccional").innerHTML = 
        "<div class='contenido_punto'> " +
	        "Se ha clicado en " + nombre + 
	        "<br>" + this.#descripcionesDeLaRuta.get(nombre)+
	        "<br> <a href='/repartidor/terminarPedido/"+id+"'>Completar Pedido</a>"+
			"<br> <label> Pedido"+id+"</label>"+
		    "<br> Fecha y Hora: "+ fecha_hora+
		    "<br> Direccion:"+ direccion+","+codigoPostal+","+nombreLocalizacion+
		    "<br> Productos:"+
		    "<br> <a href='/repartidor/verProductos/"+id+"'>Ver Productos del Pedido</a>"+
		    "<br> <br>"+
		    "<br>Precio Total: "+precioTotal+" €"+
		    "<br><br> Observaciones: "+observaciones+
	    "</div>";
    }
        
}
