<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/13/2021
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="bandwidth.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="static/midExLtm.css">
  <style>
  </style>
</head>
<body class="bg-dark p-5">

<div class="col-md-6 offset-md-3 " >
  <div class="card">
    <div class="card-body" id="lb1">Bandwidth Test
      <div class="card-body"><button class=" btn1" onclick="updateChart()">GO</button></div>
    </div>

    <div class="card-body"><p class="avg" id="avg"></p></div>
    <div class="card-body">
      <canvas id="myChart" width="400" height="200"></canvas>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  var olddata = [0, 0, 0, 0, 0, 0];
  var ctx = document.getElementById('myChart').getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['Time 1', 'Time 2', 'Time 3', 'Time 4', 'Time 5', 'Time 6'],
      datasets: [{
        label: '# of Votes',
        data: olddata,
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
      }]
    },
    options: {
      // scales: {
      //     y: {
      //         beginAtZero: true
      //     }
      // }
    }
  });
  function updateChart() {
    var avg = 0;
    var dem = 5;
    for (var i=0;i<5;i++) {
      (function(ind) {
        setTimeout(function(){
          myChart.data.datasets[0].data = [21, 30, 35, 32, 33,41];
          for (let index = 0; index < myChart.data.datasets[0].data.length; index++) {
            myChart.data.datasets[0].data[index] = Math.floor(Math.random() * 15    ) +20;
            avg+=myChart.data.datasets[0].data[index];
            console.log(myChart.data.datasets[0].data[index]);

          }
          console.log(avg);
          document.getElementById("avg").innerHTML =  Math.round( avg/dem ) + " Mbps";
          dem+=5;
          myChart.update();
        }, 1000 + (2000 * ind));
      })(i);

    }

  }
</script>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
