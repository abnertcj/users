'use strict';
app.controller("AddEditController", function($scope, $stateParams, AjaxService, AlertService) {
	var self = this;
	
	self.id = $stateParams.id;
	
	self.init = function() {
		self.user = {
			email: '',
			name: '',
			cpf: '',
			phone: '',
			code: 1,
			profile: 0
		};
		
		if (self.id != undefined) {
			AjaxService.httpGet('/api/users/' + self.id, self.getSuccessCallback, self.getFailureCallback);
		}
		AjaxService.httpGet('/api/functions', self.getFunctionsSuccessCallback, self.getFailureCallback);
	}

	self.saveUser = function() {
		var newUser = angular.copy(self.user);
		if (self.id == undefined) {
			AjaxService.httpPost('/api/users', newUser, self.saveSuccessCallback, self.saveFailureCallback);
		} else {
			AjaxService.httpPut('/api/users', newUser, self.updateSuccessCallback, self.updateFailureCallback);
		}
		
		
		filme.id = Date.now();
		$scope.filmes.push(filme);

		$scope.novoFilme = {};
	}
	
	/*
	 * Callbacks
	 */
	
	self.getSuccessCallback = function(response) {
		self.user = angular.copy(response.data);
	}
	
	self.getFunctionsSuccessCallback = function(response) {
		self.functions = angular.copy(response.data);
	}
	
	self.getFailureCallback = function() {
		
	}
	
	self.saveSuccessCallback = function() {
		AlertService.showSuccess("Cadastro efetuado com sucesso!");
	}
	
	self.saveFailureCallback = function() {
		AlertService.showError("Falha");
	}
	
	self.updateSuccessCallback = function() {
		AlertService.showSuccess("Alteração efetuada com sucesso!");
	}
	
	self.updateFailureCallback = function() {
		AlertService.showError("Falha");
	}
	
	self.init();
	
});