var app = angular.module('myApp');

/*
 *<1>$http is substitute by github,
 *<2>after route remove github,$log,$anchorScroll
 */
app.controller('MainController',function ($scope,$interval,$location) {
    /*var baseUrl = "https://api.github.com/";
    var subUrl_1 = "users/";*/

    //$scope.toggleErrorMessage = false;
    $scope.countdown = 10;
    $scope.searchedUserName = "angular";


    var decrementCountdown = function () {
        $scope.countdown -= 1;
        //$log.info("decrementCountdown " + $scope.countdown);
        if($scope.countdown < 1){
            $scope.search($scope.searchedUserName)
        }
    };

    var countdownInterval = null;
    var startCountdown = function () {
        //$log.info("startCountdown");
        countdownInterval = $interval(decrementCountdown,1000,$scope.countdown);
    };

    $scope.userProfile = "User Profile";

    $scope.search = function (searchedUserName) {
        //$log.info("search for " + searchedUserName);
        //$http.get(baseUrl + subUrl_1 + searchedUserName).then(onUserComplete,onError);
        //github.getUser(searchedUserName).then(onUserComplete,onError);
        if(countdownInterval){
            $interval.cancel(countdownInterval);
            $scope.countdown = null;
        }
        $location.path("/user/" + searchedUserName)
    };

    startCountdown();
});