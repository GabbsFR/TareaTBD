<template>

  <div class="home">
    
    <h1 class="top" >Perros de Chile</h1>
    <!--<div>{{point}} 
      <input type="text" v-model="name" placeholder="nombre" />
      <button type="button" @click="createPoint">Crear</button>
    </div>
    <div>{{message}}</div>-->
    <div class = "mapa" id="mapid"></div>
    <label class="regionLabel">Escoge una región:</label>
    <select class="regionSelect" id="año">
      <option>Región de Arica y Parinacota</option>
      <option>Región de Tarapacá</option>
      <option>Región de Antofagasta</option>
      <option>Región de Atacama</option>
      <option>Región de Coquimbo</option>
      <option>Región de Valparaíso</option>
      <option>Región Metropolitana de Santiago</option>
      <option>Región del Libertador Bernardo O'Higgins</option>
      <option>Región del Maule</option>
      <option>Región del Bío-Bío</option>
      <option>Región de La Araucanía</option>
      <option>Región de Los Ríos</option>
      <option>Región de Los Lagos</option>
      <option>Región de Aysén del Gral.Ibañez del Campo</option>
      <option>Región de Magallanes y Antártica Chilena</option>
    </select>
  </div>
</template>
<script>
//Importaciones
import './leaflet/dist/leaflet'; //librería leaflet
import './leaflet/dist/leaflet.css'; //css leaflet
var icon = require('./leaflet/dist/images/marker-icon.png'); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
          options: {iconSize:[25, 41], iconAnchor:[12, 41], popupAnchor: [-3, -41]}
      });
var myIcon = new LeafIcon({iconUrl: icon});

//librería axios
import axios from 'axios';
export default {
  name: 'Home',
  data:function(){
    return{
      latitude:null, //Datos de nuevo punto
      longitude:null,
      name:'',
      points:[], //colección de puntos cargados de la BD
      regions:[],
      message:'', 
      mymap:null //objeto de mapa(DIV)
    }
  },
  computed:{
    point(){ // función computada para representar el punto seleccionado
      if(this.latitude && this.longitude){
        let lat = this.latitude.toFixed(3);
        let lon = this.longitude.toFixed(3);
        return `(${lat}, ${lon})`;
      }else{
        return '';
      }
    }
  },
  methods:{
    clearMarkers:function(){ //eliminar marcadores
    
      this.points.forEach(p=>{
        this.mymap.removeLayer(p);
      })
      this.points = [];
    },
    async createPoint(){ //Crear un nuevo punto
      this.message = '';

      let newPoint ={
        name: this.name,
        latitude: this.latitude,
        longitude: this.longitude
      }
      
      try {
        let response = await axios.post('http://localhost:3000/dogs/read' ,newPoint);
        console.log('response', response.data);
        let id = response.data.id;
        this.message = `${this.name} fue creado con éxito con id: ${id}`;
        this.name = '';
        this.clearMarkers(this.mymap);
        this.getPoints(this.mymap)

      } catch (error) {
       console.log('error', error); 
       this.message = 'Ocurrió un error'
      }
    },
    async getPoints(map){
      try {
        //se llama el servicio 
        let response = await axios.get('http://localhost:3000/dogs/read');
        let dataPoints = response.data;
        //console.log(dataPoints);
        //Se itera por los puntos
        dataPoints.forEach(point => {

          //Se crea un marcador por cada punto
          let p =[point.latitude, point.longitude]
          let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
          .bindPopup(point.name) //Se agrega un popup con el nombre
          
          //Se agrega a la lista
          this.points.push(marker);
        });

        //Los puntos de la lista se agregan al mapa
        this.points.forEach(p=>{
          p.addTo(map)
        })
      } catch (error) {
       console.log('error', error); 
      }
      
    },
    async getRegions(){
      try {
        let response = await axios.get('http://localhost:3000/region/read');
        let regiones = response.data;
        //console.log(regiones);
        //Se itera por los puntos
        regiones.forEach(region => {
          
          //Se agrega a la lista
          this.regions.push(region.nom_reg);
        });

      } catch (error) {
       console.log('error', error); 
      }


    }
  },
  mounted:function(){
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    	attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
    	maxZoom: 10
    }).addTo(this.mymap);

    //Evento click obtiene lat y long actual
    this.mymap.on('click', function(e) {
      _this.latitude = e.latlng.lat;
      _this.longitude =e.latlng.lng;
    });

    //Se agregan los puntos mediante llamada al servicio
    this.getPoints(this.mymap);
    this.getRegions();
    console.log(this.regions);
    let select = document.getElementById("año");
    /*for(let i = 2000; i <= 2050; i++){
        let option = document.createElement("option");
        option.value = i;
        option.text = i;
        select.appendChild(option);
    }*/
    this.regions.forEach(region => {
      let option = document.createElement("option");
      option.value = region;
      option.text = region;
      select.appendChild(option)
    })
    
  }
}
</script>
<style>
.home{
  display:flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
/* Estilos necesarios para definir el objeto de mapa */
#mapid { 
  height: 400px; 
  width:600px;
}

.mapa {
  width: 120px;
  position:absolute;
  left:450px;
  top:150px;
}

.top {
  position:absolute;
  left:650px;
  top:50px;
}

.regionLabel{
  position:absolute;
  left:665px;
  top:110px;
}

.regionSelect{
  position:absolute;
  left:815px;
  top:110px;
}
</style>