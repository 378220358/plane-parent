/**
 * 限制输入框只能输入数字和小数点，并且不能从剪贴板上获得内容
 */
 $.fn.onlyNum = function () {
     $(this).keypress(function (event) {
         var eventObj = event || e;
         var keyCode = eventObj.keyCode || eventObj.which;
         if ((keyCode >= 48 && keyCode <= 57) || keyCode == 8 || keyCode == 46 ||(keyCode>37 && keyCode < 40))
             return true;
         else{
        	 return false;
         }
     }).focus(function () {
     //禁用输入法
         this.style.imeMode = 'disabled';
     });
 };
 $.fn.onlyDegree = function () {
     $(this).keypress(function (event) {
         var eventObj = event || e;
         var keyCode = eventObj.keyCode || eventObj.which;
         if ((keyCode >= 48 && keyCode <= 57) || keyCode == 8 || keyCode == 46 ||(keyCode>37 && keyCode < 40) || keyCode == 45)
             return true;
         else{
        	 return false;
         }
     }).focus(function () {
     //禁用输入法
         this.style.imeMode = 'disabled';
     });
 };
 $(function () {
	 jQuery.validator.addMethod("radixPoint6", function(value, element) {       
         return this.optional(element) || /^\d+(\.\d{1,6})?$/.test(value);       
     }, "小数位不能超过六位");
     jQuery.validator.addMethod("radixPoint2", function(value, element) {       
         return this.optional(element) || /^\d+(\.\d{1,2})?$/.test(value);       
     }, "小数位不能超过两位");
     jQuery.validator.addMethod("score", function(value, element) {       
         return this.optional(element) || /^[0-5](\.[05]){0,1}$/.test(value);       
     }, "只能输入0-5小数点后只能0|5");
     jQuery.validator.addMethod("range100", function(value, element) {       
         return this.optional(element) || /^([0-9]|[0-9]{2}|100)$/.test(value);       
     }, "数字范围只能是0-100");
     jQuery.validator.addMethod("range10", function(value, element) {       
         return this.optional(element) || /([0-9]{1}|10)$/.test(value);       
     }, "数字范围只能是0-10");
     jQuery.validator.addMethod("nameLength", function(value, element) {   
    	 var length = value.length;
         return this.optional(element) || length < 40;       
     }, "名称长度不能超过四十");
     jQuery.validator.addMethod("describeLength", function(value, element) {       
         return this.optional(element) || length < 400;       
     }, "描述长度不能超过四百"),
     jQuery.validator.addMethod("estateLongitude", function(value, element) {   
         return this.optional(element) || /^0$|^-?0\.\d*[0-9]$|^-?[0-9](\.\d*[0-9])?$|^-?[0-9]\d(\.\d*[0-9])?$|^-?1[0-7]\d(\.\d*[0-9])?$|^-?180$/.test(value*2/2);       
     }, "经度的范围是-180到180");
     jQuery.validator.addMethod("estateLatitude", function(value, element) {   
         return this.optional(element) || /^0$|^-?0\.\d*[0-9]$|^-?[0-9](\.\d*[0-9])?$|^-?[0-9]\d(\.\d*[0-9])?$|^-?1[0-7]\d(\.\d*[0-9])?$|^-?180$/.test(value*2);       
     }, "纬度的范围是-90到90");
     jQuery.extend(jQuery.validator.messages, {
    	 number: "请输入阿拉伯数字",
     });
 });
  