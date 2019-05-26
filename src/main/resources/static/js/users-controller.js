app.controller("UsersController", function($scope, $state, AjaxService, AlertService) {
	var self = this;
	
	self.init = function() {
		AjaxService.httpGet('/api/users/', self.getSuccessCallback, self.getFailureCallback);
	}
	
	self.searchModel = {
		name: '',
		situation: '',
		profile: ''
	}
	
	self.search = function() {
		
	}
	
	self.editUser = function(id) {
		$state.go('#edit/' + id);
	}
	
	self.updateSituation = function(id) {
		angular.forEach(self.users, function(user){
			if(user.cpf == id) {
				AjaxService.httpPut('/api/users/situation', user, self.updateSuccessCallback, self.updateFailureCallback);
			}
		});
	}
	
	self.removeUser = function(id, name) {
		var response = confirm("Deseja realmente excluir o usuário " + name + "?");
		if (response == true) {
			angular.forEach(self.users, function(user){
				if(user.id == id) {
					AjaxService.httpDelete('/api/users', user, self.removeSuccessCallback, self.removeFailureCallback);
				}
			});
		}
	}

	/*
	 * Callbacks
	 */
	
	self.getSuccessCallback = function(response) {
		self.users = response.data;
	}
	
	self.getFailureCallback = function() {
		
	}
	
	self.updateSuccessCallback = function(response) {
		var isEnabled = response.data;
		if (isEnabled) {
			AlertService.showSuccess("Usuário habilitado com sucesso!");
		} else {
			AlertService.showError("Usuário desabilitado com sucesso!");
		}
	}
	
	self.updateFailureCallback = function() {
		
	}
	
	self.removeSuccessCallback = function() {
		self.init();
		AlertService.showSuccess("Exclusão efetuada com sucesso.");
	}
	
	self.removeFailureCallback = function() {
		AlertService.showError("Falha");
	}

	self.init();
	
});