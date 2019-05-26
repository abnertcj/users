'use strict';

app.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      
      .state("users", {
        url: "/users",
        templateUrl: "users.html"
      })
      .state("add", {
        url: "/add",
        templateUrl: "add-edit.html"
      })
      .state("edit", {
        url: "/edit/:id",
        templateUrl: "add-edit.html"
      });

      $urlRouterProvider.otherwise('/users');
  });