<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/17
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<html>
<head>
    <title>飞机选座</title>
    <script type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/modules/common/js/jquery.seat-charts.js"/> "></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/jquery.seat-charts.css"/> ">
    <script type="text/javascript">
      $(document).ready(function() {

        var sc = $('#test').seatCharts({
          map: [
            'aaaaaa_sDDDDD',
            'aaaaaa__aaaaa',
            'aaaaaa__aaaaa',
            'bbbbbb__bbbbb',
            'bbbbbb__bbbbb',
            'bbbbbb__bbbbb',
          ],
          seats: {
            a: {
              price   : 99.99,
              classes : 'front-seat' //your custom CSS class
            }

          },
          click: function () {
            if (this.status() == 'available') {
              //do some stuff, i.e. add to the cart
              return 'selected';
            } else if (this.status() == 'selected') {
              //seat has been vacated
              return 'available';
            } else if (this.status() == 'unavailable') {
              //seat has been already booked
              return 'unavailable';
            } else {
              return this.style();
            }
          }
        });

        //Make all available 'c' seats unavailable
        sc.find('c.available').status('unavailable');

        /*
         Get seats with ids 2_6, 1_7 (more on ids later on),
         put them in a jQuery set and change some css
         */
        sc.get(['2_6', '1_7']).node().css({
          color: '#ffcfcf'
        });

        console.log('Seat 1_2 costs ' + sc.get('1_2').data().price + ' and is currently ' + sc.status('1_2'));

      });
    </script>
</head>
<body>
  <div id="test">

  </div>
</body>
</html>
