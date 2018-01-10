var app = angular.module('myApp',['githubService']);

//$http is substitute by github
app.controller('MainController',function ($scope,github,$interval,$log,$anchorScroll,$location) {
    var baseUrl = "https://api.github.com/";
    var subUrl_1 = "users/";

    $scope.toggleErrorMessage = false;
    $scope.countdown = 10;
    $scope.searchedUserName = "angular";

    var onRepos = function (response) {
        //$scope.repos = response.data;
        $scope.repos = response;
        $location.hash("search_result");
        $anchorScroll();
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

    var decrementCountdown = function () {
        $scope.countdown -= 1;
        $log.info("decrementCountdown " + $scope.countdown);
        if($scope.countdown < 1){
            $scope.search($scope.searchedUserName)
        }
    };

    var countdownInterval = null;
    var startCountdown = function () {
        $log.info("startCountdown");
        countdownInterval = $interval(decrementCountdown,1000,$scope.countdown);
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

    $scope.search = function (searchedUserName) {
        $log.info("search for " + searchedUserName);
        //$http.get(baseUrl + subUrl_1 + searchedUserName).then(onUserComplete,onError);
        github.getUser(searchedUserName).then(onUserComplete,onError);
        if(countdownInterval){
            $interval.cancel(countdownInterval);
            $scope.countdown = null;
        }
    };

    startCountdown();
});