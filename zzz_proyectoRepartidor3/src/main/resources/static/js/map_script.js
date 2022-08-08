

const myLatLng = { lat: -25.363, lng: 131.044 };

const myLatLng2 = { lat: -26.363, lng: 131.044 };


let array_with_coordinates=[myLatLng,myLatLng2];


function myMap() {
var mapProp= {
  center:myLatLng,
  zoom:5,
};

var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

createNewMarkers(array_with_coordinates,map);

}


function createNewMarkers(array_with_coordinates, map){
  
    for(let actual of array_with_coordinates){
    
        new google.maps.Marker({
            position: actual,
            map,
            title: "Hello World!",
        });   

    }

}

