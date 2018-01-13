var app = angular.module('myApp');

app.controller('RepositoryController',function ($scope,github,$routeParams) {
    $scope.project_name = $routeParams.projectname;
    $scope.repo_name = $routeParams.reponame;

    var onUserComplete = function (response) {
        $scope.repo_detail = response;
    };

    github.getReposDetail($scope.project_name,$scope.repo_name).then(onUserComplete);
});