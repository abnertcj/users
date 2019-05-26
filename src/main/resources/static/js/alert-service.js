"use strict";

app.factory("AlertService", function() {
    var service = {};
 
    service.showSuccess = function(msg) {
    	$("#message-box").removeClass('alert-danger');
    	$("#message-box").addClass('alert-success');
    	$(".alert-strong").remove();
    	$("#message-box").append('<strong class="alert-strong">' + msg + '</strong>');
    	$("#message-box").show();
    };

    service.showError = function(msg) {
    	$("#message-box").removeClass('alert-success');
    	$("#message-box").addClass('alert-danger');
    	$(".alert-strong").remove();
    	$("#message-box").append('<strong class="alert-strong">' + msg + '</strong>');
    	$("#message-box").show();
    };

    return service;
  });
