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
    precioTotal,observaciones,lista) {
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
    precioTotal,observaciones,lista);
        })
    }
    
    procesarClicEnElMarcador(nombre,
    id,fecha_hora,direccion,codigoPostal,nombreLocalizacion,
    precioTotal,observaciones) {
        document.getElementById("informacion-adiccional").innerHTML = 
        "<div class='mt-4 p-5 bg-primary text-white rounded'> " +
	        "Se ha clicado en " + nombre +" "+this.#descripcionesDeLaRuta.get(nombre)+
	        "<br> <a class='btn btn-success' href='/repartidor/terminarPedido/"+id+"'>Completar Pedido</a>"+
			"<br><h1> Pedido "+id+"</h1>"+
		    "<p> Fecha y Hora: "+ fecha_hora+"</p>"+
		    "<p>Direccion:"+ direccion+","+codigoPostal+","+nombreLocalizacion+"</p>"+
		    "<p>Productos:</p>"+
		    "<a class='btn btn-info' href='/repartidor/verProductos/"+id+"'>Ver Productos del Pedido</a>"+
		    "<br><p>Precio Total: "+precioTotal+" €</p>"+
		    "<label for='observ'>Observaciones</label>"+
		    "<br><textarea id='observ' rows='3' class='form-control' readonly>"+observaciones+"</textarea>"+
	    "</div>";
    }
        
}
