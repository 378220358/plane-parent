<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<!doctype html>
<html>
<head>
  <title>机票选座</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/jquery.seat-charts.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/style.css"/>"/>
  <script type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/> "></script>
  <script type="text/javascript" src="<c:url value="/modules/common/js/jquery.seat-charts.js"/>"></script>
</head>
<body>
<div class="wrapper">
  <div class="container">
    <div id="seat-map">
      <div class="front-indicator">机头</div>
    </div>
    <div class="booking-details">
      <h3>已选中的座位 (<span id="counter">0</span>):</h3>
      <ul id="selected-seats">
      </ul>
      <p>总价: <b>$<span id="total">0</span></b></p>
      <p><button class="checkout-button">结算</button></p>
      <div id="legend"></div>
    </div>
  </div>
</div>
<script>
  var firstSeatLabel = 1;

  $(document).ready(function() {
    var $cart = $('#selected-seats'),
            $counter = $('#counter'),
            $total = $('#total'),
            sc = $('#seat-map').seatCharts({
              map: [
                'ff_ff',
                'ff_ff',
                'ee_ee',
                'ee_ee',
                'ee___',
                'ee_ee',
                'ee_ee',
                'ee_ee',
                'ee_ee',
                'eeeee',
              ],
              seats: {
                f: {
                  price   : 100,
                  classes : 'first-class', //your custom CSS class
                  category: '头等舱'
                },
                e: {
                  price   : 40,
                  classes : 'economy-class', //your custom CSS class
                  category: '经济舱'
                }

              },
              naming : {
                top : false,
                getLabel : function (character, row, column) {
                  return firstSeatLabel++;
                },
              },
              legend : {
                node : $('#legend'),
                items : [
                  [ 'f', 'available',   '头等舱' ],
                  [ 'e', 'available',   '经济舱'],
                  [ 'f', 'unavailable', '已预定']
                ]
              },
              click: function () {
                if (this.status() == 'available') {
                  $('<li>'+this.data().category+this.settings.label+'号座位'+'：<br/>价格：<b>$'+this.data().price+'</b> <a href="#" class="cancel-cart-item">[删除]</a></li>')
                          .attr('id','cart-item-'+this.settings.id)
                          .data('seatId', this.settings.id)
                          .appendTo($cart);
                  $counter.text(sc.find('selected').length+1);
                  $total.text(recalculateTotal(sc)+this.data().price);

                  return 'selected';
                } else if (this.status() == 'selected') {
                  //update the counter
                  $counter.text(sc.find('selected').length-1);
                  //and total
                  $total.text(recalculateTotal(sc)-this.data().price);

                  //remove the item from our cart
                  $('#cart-item-'+this.settings.id).remove();

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

    //this will handle "[cancel]" link clicks
    $('#selected-seats').on('click', '.cancel-cart-item', function () {
      //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
      sc.get($(this).parents('li:first').data('seatId')).click();
    });

    //let's pretend some seats have already been booked
    sc.get(['1,2', '4,1', '7,1', '7,s2']).status('unavailable');

  });

  function recalculateTotal(sc) {
    var total = 0;

    //basically find every selected seat and sum its price
    sc.find('selected').each(function () {
      total += this.data().price;
    });

    return total;
  }

</script>
</body>
</html>
