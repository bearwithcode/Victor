var app = angular.module('myApp');

/**
 * $http is substitute by github
 */
app.controller('UserController',function ($scope,github,$routeParams,$location) {
    $scope.toggleErrorMessage = false;
    $scope.searchedUserName = $routeParams.username;

    var onRepos = function (response) {
        //$scope.repos = response.data;
        $scope.repos = response;
        //$location.hash("search_result");
        //$anchorScroll();
    };

    var onUserComplete = function (response) {
        //$scope.user = response.data;
        $scope.user = response;
        $scope.toggleErrorMessage = true;
        //$http.get($scope.user.repos_url).then(onRepos,onError);
        github.getRepos($scope.user).then(onRepos,onError);
    };

    var onError = function () {
        $scope.errorMsg = "something wrong, maybe user not exist";
        $scope.toggleErrorMessage = false;
    };

    $scope.userProfile = "User Profile";
    $scope.repoSortOrder = "+stargazers_count";

    $scope.nameSort = function () {
        if($scope.repoSortOrder === "+name"){
            $scope.repoSortOrder = "-name"
        }
        else{
            $scope.repoSortOrder = "+name"
        }
    };

    $scope.starsSort = function () {
        if($scope.repoSortOrder === "+stargazers_count"){
            $scope.repoSortOrder = "-stargazers_count"
        }
        else{
            $scope.repoSortOrder = "+stargazers_count"
        }
    };

    $scope.languageSort = function () {
        if($scope.repoSortOrder === "+language"){
            $scope.repoSortOrder = "-language"
        }
        else{
            $scope.repoSortOrder = "+language"
        }
    };

    $scope.goRepoPage = function (repo_name) {
        $location.path("/repo/" + $scope.user.name + "/" + repo_name);
    };

    github.getUser($scope.searchedUserName).then(onUserComplete,onError);
});