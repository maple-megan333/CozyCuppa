// Create root and chart
var root = am5.Root.new("chartdiv"); 

// Set themes
root.setThemes([
  am5themes_Animated.new(root)
]);

var chart = root.container.children.push(
  am5map.MapChart.new(root, {
     panX: "translateX",
  	panY: "translateY",
    projection: am5map.geoMercator(),
 
  })
);

// Create polygon series
var polygonSeries = chart.series.push(
  am5map.MapPolygonSeries.new(root, {
    geoJSON: am5geodata_worldLow,
    exclude: ["AQ"]
  })
);

polygonSeries.mapPolygons.template.setAll({
  tooltipText: "{name}",
  templateField: "polygonSettings",
  toggleKey: "active",
  interactive: true
});

polygonSeries.mapPolygons.template.setAll({
  stroke: am5.color(0x472D30),
  strokeWidth: 0.5,
  fill: am5.color(0x723D46),
  fillOpacity: 0.5
});



polygonSeries.mapPolygons.template.states.create("hover", {
  fill: am5.color(0xE26D5C)
});

chart.set("zoomControl", am5map.ZoomControl.new(root, {}));

polygonSeries.mapPolygons.template.events.on("click", function (ev) {
  console.log(ev.target.dataItem.dataContext.id);
});


polygonSeries.mapPolygons.template.states.create("active", {
  fill: am5.color(0xE26D5C)
});

var drinkCountryListString = document.getElementById("drinkCountryList").value;
if(drinkCountryListString.length > 0){
	const countryArray = drinkCountryListString.split(",");
	var jsonArr = [];

	for (var i = 0; i < countryArray.length; i++) {
	    jsonArr.push({
	        id: countryArray[i],
	        polygonSettings: { fill: am5.color(0x472D30) }
	    });
	}
	
	polygonSeries.data.setAll(jsonArr);
}
