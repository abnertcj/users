"use strict";

app.factory("AjaxService", function($http) {

	var service = {};
	var urlBase = 'http://localhost:8080';
	
    service.httpGet = function(url, success, failure) {
      $http({
        method: "GET",
        url: urlBase + url
      }).then(
        function successCallback(response) {
          if (success) success(response);
        },
        function errorCallback(err) {
          if (failure) service.failure(failure, err);
        }
      );
    };

    service.httpPost = function(url, data, success, failure) {
      $http({
        method: "POST",
        url: urlBase + url,
        data: data
      }).then(
        function successCallback(response) {
          if (success) success(response);
        },
        function errorCallback(err) {
          if (failure) service.failure(failure, err);
        }
      );
    };

    service.httpPut = function(url, data, success, failure) {
      $http({
        method: "PUT",
        url: urlBase + url,
        data: data
      }).then(
        function successCallback(response) {
          if (success) success(response);
        },
        function errorCallback(err) {
          if (failure) service.failure(failure, err);
        }
      );
    };

    service.httpDelete = function(url, success, failure) {
      $http({
        method: "DELETE",
        url: urlBase + url
      }).then(
        function successCallback(response) {
          if (success) success(response);
        },
        function errorCallback(err) {
          if (failure) service.failure(failure, err);
        }
      );
    };

    service.failure = function(failure, err) {
      if (failure) {
        failure(err);
      }
    };

    return service;
  });
