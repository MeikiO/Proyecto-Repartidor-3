class Mapa {
    #MiClave = "AIzaSyCdEePgg8aVDdW1R8z1zBUHQAbFKAz5Afk";
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
        
    añadirUnPuntoALaRuta(coordenadas, nombre, descripcion) {
        this.#rutaEnBruto.push(new google.maps.LatLng(coordenadas));
        this.#descripcionesDeLaRuta.set(nombre, descripcion);
    }
    
    ponerMarcador(coordenadas, nombre) {
        const marcador = new google.maps.Marker({
            position: coordenadas,
            label: nombre,
            map: this.#mapa,
            clickable: true,
            draggable: false
        })
        marcador.addListener("click", () => {
            this.procesarClicEnElMarcador(nombre);
        })
    }
    
    procesarClicEnElMarcador(nombre) {
        document.getElementById("informacion-adiccional").innerHTML = "Se ha clicado en " + nombre + "<br>" + this.#descripcionesDeLaRuta.get(nombre);
    }
    
    
    pintarLaPolineaDeLaRutaEnBruto() {
        var polilinea = new google.maps.Polyline({
            path: this.#rutaEnBruto,
            strokeColor: '#00FF00',
            strokeWeight: 10,
            strokeOpacity: 0.5,
        });
        polilinea.setMap(this.#mapa);
    }
    
     
    pintarLaRutaASeguir() {
        var puntosDelCamino = [];
        for (const element of this.#rutaEnBruto) {
            puntosDelCamino.push(element.toUrlValue());
        }
        fetch("https://roads.googleapis.com/v1/snapToRoads", {
            method: "GET",
            headers: {
                path: puntosDelCamino.join("|"),
                interpolate: true,
                key: this.#MiClave,
            }
        })
        .then((response) => {
            response.json();
        })
        .then((data) => {
            this.procesarLaRespuestaDeSnapToRoads(data);
        })
        .catch((error) => {
            console.error("Se ha producido un error:", error);
        });
        this.pintarLaPolineaDelCaminoAdaptado();
    }
    
    procesarLaRespuestaDeSnapToRoads(data) {
        this.#rutaAdaptadaACallesYCarreteras = [];
        for (const element of data.snappedPoints) {
            var coordenadas = new google.maps.LatLng(
                element.location.latitude,
                element.location.longitude
            );
            this.#rutaAdaptadaACallesYCarreteras.push(coordenadas);
        }
    }
        
    pintarLaPolineaDeLaRutaAdaptada() {
        var polilinea = new google.maps.Polyline({
            path: this.#rutaAdaptadaACallesYCarreteras,
            strokeColor: '#FC0ED4',
            strokeWeight: 5,
            strokeOpacity: 0.8,
        });
        polilinea.setMap(this.#mapa);
    }
    
}
