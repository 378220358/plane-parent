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
      <form action="/plane/ticket/seatAccount.do" method="post">
        <input type="hidden" name="cabinAleardySeat" id="cabinAleardySeat" value="${cabinInfo.cabinAleardySeat}">
        <input type="hidden" name="cabinId" id="cabinId" value="${cabinInfo.cabinId}">
        <h3>已选中的座位 (<span id="counter">0</span>):</h3>
        <ul id="selected-seats">
        </ul>
        <p>姓　　　名：<b><input type="text" name="ticketName"></b></p>
        <p>身份证号码：<b><input type="text" name="ticketCard"></b></p>
        <p>总　　　价: <b>$<input id="total" name="ticketMoney" readonly style="border-style:none;color:#808080" ></b></p>
        <p><button class="checkout-button" onclick="">结算</button></p>
        <div id="legend"></div>
      </form>
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
                  var tempRow = this.settings.row + 1;
                  var tempColumn = this.settings.column + 1;
                  if(parseInt(tempColumn) > 2 && parseInt(this.settings.row) != 10){
                    tempColumn --;

                  }
                  var tempSeat = $("#cabinAleardySeat").val() + ",'" + tempRow + "_" + tempColumn + "'";
                  $("#cabinAleardySeat").val(tempSeat);
                  console.log($("#cabinAleardySeat").val());
                  $('<li>'+this.data().category+this.settings.label+'号座位'+'：<br/>价格：<b>$'+this.data().price+'</b> <a href="#" class="cancel-cart-item">[删除]</a></li>')
                          .attr('id','cart-item-'+this.settings.id)
                          .data('seatId', this.settings.id)
                          .appendTo($cart);
                  $counter.text(sc.find('selected').length+1);
                  $("#total").val(recalculateTotal(sc)+this.data().price);
                 // $total.text(recalculateTotal(sc)+this.data().price);

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
    //sc.get(['1_2', '4_1', '7_1', '7_2']).status('unavailable');
    <c:if test="${cabinInfo != null}">
    sc.get([${cabinInfo.cabinAleardySeat}]).status('unavailable');
    </c:if>

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
