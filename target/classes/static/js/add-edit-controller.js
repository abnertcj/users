'use strict';
app.controller("AddEditController", function($scope, $state, $stateParams, AjaxService, AlertService) {
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
		newUser.cpf = newUser.cpf.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g,"");
		if (self.id == undefined) {
			var response = confirm("Deseja confirmar o salvamento?");
			if (response == true) {
				AjaxService.httpPost('/api/users', newUser, self.saveSuccessCallback, self.saveFailureCallback);
			}
		} else {
			var response = confirm("Deseja confirmar a edição?");
			if (response == true) {
				AjaxService.httpPut('/api/users', newUser, self.updateSuccessCallback, self.updateFailureCallback);
			}
		}
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
		self.init();
		AlertService.showSuccess("Cadastro efetuado com sucesso!");
	}
	
	self.saveFailureCallback = function(response) {
		var value = response.data;
		if (response.data == -1) {
			AlertService.showError("Operação não realizada. Usuário já incluído.");
		} else {
			AlertService.showError("Operação não realizada. CPF digitado é inválido.");
		}
	}
	
	self.updateSuccessCallback = function() {
		self.id = undefined;
		self.init();
		AlertService.showSuccess("Alteração efetuada com sucesso!");
	}
	
	self.updateFailureCallback = function() {
		AlertService.showError("Falha");
	}
	
	self.init();
	
});