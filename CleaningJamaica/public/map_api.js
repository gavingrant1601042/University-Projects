let map;
function initMap() {
  map = new google.maps.Map(document.getElementById("map1"), {
    center: { lat: 18.006529215508053, lng: -76.78805530071259 },
    zoom: 8,
    mapTypeId: "terrain"
  });
  const marker = new google.maps.Marker({
      position: { lat: 18.006529215508053, lng: -76.78805530071259 },
      map: map,
      label: "A",
      title: " CleaningJmaiaca",
      draggable: false,
      animation: google.maps.Animation.DROP,
      icon: "map.png"
  });

  const infoWindow = new google.maps.InfoWindow({
    content: "<p>This is where our company is located</p>"
  });
  infoWindow.open(map, marker);
}

